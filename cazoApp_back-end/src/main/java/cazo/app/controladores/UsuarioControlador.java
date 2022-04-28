package cazo.app.controladores;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/usuario")
public class UsuarioControlador {
	
	@GetMapping("/usuarios")
	public String listarUsuarios(){
		return "listadoUsuarios.html";
	}
}
