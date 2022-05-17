package cazo.app.controladores;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/")
public class PrincipalControlador {
	
	@GetMapping("/")
	public String redireccionarInicio(){
		return "redirect:/inicio";
	}
	
	
	@GetMapping("/inicio")
	public String mostrarInicio(){
		return "index-ext/index-ext.html";
	}
	
	@GetMapping("/login")
	public String mostrarFormInicioSesion(@RequestParam(required = false) String error, 
	@RequestParam(required = false) String logout, ModelMap model){
			if(error != null){
				model.put("usrError", "El usuario o la clave son incorrectos");
			}if(logout != null){
				model.put("logout", "Cerraste sesión exitosamente");
			}
		return "iniciar-sesion.html";
	}
}