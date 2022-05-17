package cazo.app.controladores;

import javax.servlet.http.HttpServletRequest;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import cazo.app.excepciones.SocioExcepcion;

@Controller
public class ErrorPersonalizadoControlador implements ErrorController{
	
	/*Recibe una petición HTTP por parámetro
	@RequestMapping("/error")
	public String error(HttpServletRequest request) throws Exception, SocioExcepcion{
		return "error.html";
	}*/
}
