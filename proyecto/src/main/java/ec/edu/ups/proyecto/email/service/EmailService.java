package ec.edu.ups.proyecto.email.service;
import ec.edu.ups.proyecto.email.EmailRequest;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

@Service
public class EmailService {

    @Autowired
    private JavaMailSender mailSender;

    public void sendEmail(String to, String subject, String text) throws MessagingException {
        MimeMessage message = mailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message, true);

        helper.setTo(to);
        helper.setSubject(subject);
        helper.setText(text, true); // Use true to enable HTML content

        // You can also add attachments if needed
        // helper.addAttachment("attachmentFilename.jpg", new ClassPathResource("image.jpg"));

        mailSender.send(message);
    }
    @Autowired
    private RabbitTemplate rabbitTemplate;

    public void enqueueEmail(EmailRequest emailRequest) {
        rabbitTemplate.convertAndSend("emailQueue", emailRequest);
    }

}
