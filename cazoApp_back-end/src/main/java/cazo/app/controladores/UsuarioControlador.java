package cazo.app.controladores;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import cazo.app.excepciones.UsuarioExcepcion;
import cazo.app.modelo.Usuario;
import cazo.app.servicios.UsuarioServicio;

@RestController
@RequestMapping("/usuario")
public class UsuarioControlador {
	
	@Autowired
	private UsuarioServicio usrSrv;
	private static final Logger LOGGER = LoggerFactory.getLogger(Usuario.class);
	
	@PreAuthorize("hasAnyRole('USUARIO_NORMAL')")
	@GetMapping("/listarUsuario")
	@ResponseBody
	public Usuario buscarUsuarioPorNombre(@RequestParam String usuario_nombre){
		Usuario usuario = new Usuario();
		try{
			usuario = usrSrv.buscarUsuarioPorNombre(usuario_nombre);
		}catch(UsuarioExcepcion ue){
			ue.getMessage();
		}
		return usuario;
	}
	
}