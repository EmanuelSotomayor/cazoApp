package cazo.app.controladores;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import cazo.app.enumeraciones.SexoSocio;
import cazo.app.enumeraciones.TipoDocumento;
import cazo.app.excepciones.SocioExcepcion;
import cazo.app.excepciones.UsuarioExcepcion;
import cazo.app.modelo.DocumentoSocio;
import cazo.app.modelo.ProcedenciaSocio;
import cazo.app.modelo.Socio;
import cazo.app.modelo.Usuario;
import cazo.app.servicios.ProcedenciaSocioServicio;
import cazo.app.servicios.SocioServicio;
import cazo.app.servicios.UsuarioServicio;

@Controller
@RequestMapping("/socio") // --> Ruta general
public class SocioControlador {
	
	private final static Logger LOGGER = LoggerFactory.getLogger(Socio.class);
	
	@Autowired
	private SocioServicio socioSrv;
	@Autowired
	private UsuarioServicio usuarioSrv;
	@Autowired
	private ProcedenciaSocioServicio procSrv;
	
	//Enviamos una petición de tipo GET, porque solo estamos solicitando una vista
	@GetMapping("/registro") // --> localhost:8080/socio/registro
	public String formRegistroSocioUsuario(Model model){
		model.addAttribute("socio", new Socio());
		/*Traemos la lista de sexos del ENUM asignandolos como atributo
		para pasarlo en la vista y así recorrerlos*/
		model.addAttribute("sexos", SexoSocio.values());
		model.addAttribute("documento", new DocumentoSocio());
		/*Traemos la lista de documentos del ENUM asignandolos como atributo
		para pasarlo en la vista y así recorrerlos**/
		model.addAttribute("tiposDoc", TipoDocumento.values());
		model.addAttribute("procedencia", new ProcedenciaSocio());
		model.addAttribute("usuario", new Usuario());
		return "registro-socio.html";
	}
	
	/*Apunta al mismo ENDPOINT que el @GetMapping
	La interface ModelMap, sirve para modelar acciones y objetos,
	es lo mismo que la interface Model.
	@RequestParam --> Es una anotación que sirve para indicarle al controlador
	que un parámetro vendrá del front-end*/
	
	@PostMapping("/registro")
	public String registroSocioUsuario(ModelMap model, Socio socio, DocumentoSocio documento,
	ProcedenciaSocio procedencia, Usuario usuario){
		try{
			socioSrv.validarSocio(socio, documento, procedencia);
			usuarioSrv.validarUsuario(usuario);
			Usuario usuarioMod = usuarioSrv.retornarUsuario(usuario);
			socio.setDocumento_id(documento);
			socio.setProcedencia_id(procedencia);
			socio.setUsuario_id(usuarioMod);
			socioSrv.guardarSocio(socio);
		}catch(SocioExcepcion se){
			//Creamos un objeto que guarde el mensaje de la excepción, para pasarlo en la vista
			model.put("scError", se.getMessage());
			/*Creamos un objeto que guarde los valores de los ENUM, para que cuando
			le demos al botón registrar y se lance una excepción, sigan ahí y no desaparezcan*/
			model.put("sexos", SexoSocio.values());
			/*Creamos un objeto que guarde los valores de los ENUM, para que cuando
			le demos al botón registrar y se lance una excepción, sigan ahí y no desaparezcan*/
			model.put("tiposDoc", TipoDocumento.values());
			return "registro-socio.html";
		}catch(UsuarioExcepcion ue){
			model.put("usrError", ue.getMessage());
			return "registro-socio.html";
		}
		return "redirect:/";
	}
	
	@GetMapping("/editarSocio/{id}")
	public String formEditarSocio(Model model, @PathVariable Long id) throws Exception{
		try{
			//Traemos los datos del socio que obtenemos por ID
			model.addAttribute("socio", socioSrv.obtenerSocioPorId(id));
		}catch(Exception e){
			e.getMessage();
		}
		return "redirect:/socio/listarSocios";
	}
	
	@PreAuthorize("hasAnyRole('ROLE_USUARIO_NORMAL')")
	@PostMapping("/editarSocio/{id}")
	public String editarSocio(@PathVariable Long id, @ModelAttribute("socio") Socio socio, ModelMap model) throws Exception, SocioExcepcion{
		
		try{
			
			socioSrv.validarSocio(socio);
			
			Socio socioActual = socioSrv.obtenerSocioPorId(id);
			
			socioActual.setSocio_id(id);
			socioActual.setSocio_nombre(socio.getSocio_nombre());
			socioActual.setSocio_apellido(socio.getSocio_apellido());
			socioActual.setSocio_telefono(socio.getSocio_telefono());
			socioActual.setSocio_correo(socio.getSocio_correo());

			socioSrv.guardarSocio(socioActual);
			
		}catch(SocioExcepcion se){
			model.put("scError", se.getMessage().toString());
			LOGGER.error(se.getMessage());
			return "lista-socios.html";
		}catch(Exception e){
			e.getMessage();
			return "lista-socios.html";
		}
		return "redirect:/socio/listarSocios";
	}
	
	@PreAuthorize("hasAnyRole('ROLE_USUARIO_NORMAL')")
	@GetMapping("/eliminarSocio/{id}")
	public String eliminarSocio(@PathVariable Long id) throws Exception{
		try{
			socioSrv.eliminarSocioPorId(id);
		}catch(Exception e){
			e.getMessage();
		}
		return "redirect:/socio/listarSocios";
	}
	
	@PreAuthorize("hasAnyRole('ROLE_USUARIO_NORMAL')")
	@GetMapping("/listarSocios") // --> localhost:8080/socio/listarSocios
	public String listarSocios(Model model){
		model.addAttribute("socios", socioSrv.listarSocios());
		return "lista-socios.html";
	}
}