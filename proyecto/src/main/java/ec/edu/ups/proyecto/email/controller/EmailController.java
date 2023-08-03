package ec.edu.ups.proyecto.email.controller;
import ec.edu.ups.proyecto.email.EmailRequest;
import ec.edu.ups.proyecto.email.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.mail.MessagingException;


@RestController
@RequestMapping("/email")
public class EmailController {

    @Autowired
    private EmailService emailService;

   /* @PostMapping("/send")
    public String sendEmail(@RequestBody EmailRequest emailRequest) {
        try {
            emailService.sendEmail(emailRequest.getTo(), emailRequest.getSubject(), emailRequest.getText());
            return "Email sent successfully!";
        } catch (MessagingException e) {
            e.printStackTrace();
            return "Error sending email";
        }
    }*/
    /*
    Manejo de Errores Elegante:
    En el controlador, maneja los errores de manera elegante y registra los errores en lugar de mostrar mensajes genéricos:
     */
    @PostMapping("/send")
    public ResponseEntity<String> sendEmail(@RequestBody EmailRequest emailRequest) {
        try {
            emailService.sendEmail(emailRequest.getTo(), emailRequest.getSubject(), emailRequest.getText());
            return ResponseEntity.ok("Email sent successfully!");
        } catch (MessagingException e) {
            e.printStackTrace();
            // Registra el error y devuelve una respuesta de error
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error sending email");
        }
    }
    /*
    "Colas de Correo" para la tolerancia a la caída del servidor de correo
     */
    @PostMapping("/send-colas")
    public ResponseEntity<String> sendEmailColas(@RequestBody EmailRequest emailRequest) {
        try {
            emailService.enqueueEmail(emailRequest); // Enqueue the email
            return ResponseEntity.ok("Email enqueued successfully!");
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error enqueueing email");
        }
    }

}
