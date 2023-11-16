/*es para arrancar la pagina*/

package ar.org.centro8.Escuela;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@ServletComponentScan()
@SpringBootApplication
public class EscuelaApplication {

	public static void main(String[] args) {
		SpringApplication.run(EscuelaApplication.class, args);

		//para ejecutar el server en una terminal bash
		//sh mvnw spring-boot:run
		
		//luego dice que arranco en el puerto 8080. Si esta ocupado tengo un problema
		//cuando entro, "spring security" inyecto el codigo de login!que grande!
		// usuario: user
		// clave: 923effe2-3567-49b6-a4e6-00fa44ac147a (lo saque de la terminal)
		// como no me toma, fui a "aplication.properties" y cambie el nombre
  


	}

}
