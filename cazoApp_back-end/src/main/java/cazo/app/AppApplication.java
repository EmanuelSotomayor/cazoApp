package cazo.app;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import cazo.app.servicios.UsuarioServicio;

@SpringBootApplication
public class AppApplication {
	
	@Autowired
	private UsuarioServicio usrSrv;
	
	public static void main(String[] args) {
		SpringApplication.run(AppApplication.class, args);
	}
	
	/*Le indicamos a Spring Security, cual es el servicio que debe de utilizar para
	autentificar al usuario y además, le setea un encriptador de contraseña*/
	
	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception{
		auth.userDetailsService(usrSrv).passwordEncoder(new BCryptPasswordEncoder());
	}
	
}