package cazo.app.configuracion;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import cazo.app.servicios.UsuarioServicio;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class ConfiguracionSeguridad extends WebSecurityConfigurerAdapter{
	
	@Autowired
	public UsuarioServicio usrSrv;
	
	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception{
		/*El objeto auth es un builder*/
		auth.userDetailsService(usrSrv).passwordEncoder(new BCryptPasswordEncoder());
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception{
		/*El objeto http, también es un builder*/
		http.headers().frameOptions().sameOrigin().and()
			.authorizeRequests()
				.antMatchers("/css/*", "/js/*", "/imgs/*")
				.permitAll()
			.and().formLogin()
				//Indicamos el ENDPOINT del formulario de inicio de sesión
				.loginPage("/login")
				.loginProcessingUrl("/logincheck")
				.usernameParameter("usuario_nombre")
				.passwordParameter("usuario_clave")
				//Sí el inicio de sesión es exitoso, lo redireccionamos a la página principal
				.defaultSuccessUrl("/socio/listarSocios")
				.permitAll()
					.and().logout().permitAll()
					//Sí el deslogeo es exitoso, lo redireccionamos a la página principal
					//.logoutUrl("/logout")
					.logoutSuccessUrl("/login?logout");
	}
}