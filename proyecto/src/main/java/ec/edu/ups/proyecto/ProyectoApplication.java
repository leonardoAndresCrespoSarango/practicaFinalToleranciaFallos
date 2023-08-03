package ec.edu.ups.proyecto;

import ec.edu.ups.proyecto.Service.UsuarioService;
import ec.edu.ups.proyecto.entity.Usuario;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class ProyectoApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProyectoApplication.class, args);
	}
	@Bean
	public CommandLineRunner testDataLoader(UsuarioService usuarioRepository) {
		return args -> {
			// Crear objetos de ejemplo de la entidad Usuario
			Usuario usuario1 = new Usuario( "Cristian Timbi", "Monay", "0984864034", "2022-07-25 08:00", "30-D1-6B-E4-FC-ED", "v1");


			// Guardar los usuarios en la base de datos
			usuarioRepository.insertarRegistro(usuario1);

		};
	}

}
