package cazo.app.controladores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import cazo.app.servicios.SocioServicio;

@Controller
@RequestMapping("/socio") // --> Ruta general
public class SocioControlador {
	
	@Autowired
	private SocioServicio socio;
	
	//Enviamos una get request, porque solo estamos trayendo una vista
	@GetMapping("/registro") // --> localhost:8080/socio/registro
	public String formularioRegistroSocio(){
		return "registroSocio.html";
	}
	
	
	@PostMapping("/registro")
	
	/*Apunta al mismo ENDPOINT que el @GetMapping
	El objeto ModelMap, sirve para modelar acciones como mensajes de exito y error.
	@RequestParam --> Es una anotación que sirve para indicarle al controlador
	que un parámetro vendrá del front-end*/
	
	/*
	public String guardarSocio(ModelMap modelo, @RequestParam String nombre, 
	@RequestParam String apellido, @RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd") Date fechaNacimiento, 
	@RequestParam SexoSocio sexo, 
	@RequestParam String telefono, @RequestParam TipoDocumento tipoDocumento,
	@RequestParam String valorDocumento, @RequestParam String nacionalidad, 
	@RequestParam String provincia, @RequestParam String ciudad, 
	@RequestParam String localidad, @RequestParam String direccion, 
	@RequestParam Integer numDireccion,
	@RequestParam String codigoPostal, @RequestParam String nombreUsuario, 
	@RequestParam String claveUsuario, @RequestParam String URLimgPerfil, 
	@RequestParam String correo) throws Exception{
		
		socio.guardarSocio(nombre, apellido, fechaNacimiento, 
		sexo, telefono, tipoDocumento, 
		valorDocumento, nacionalidad, 
		provincia, ciudad, localidad, direccion, 
		numDireccion, codigoPostal, nombreUsuario, 
		claveUsuario, URLimgPerfil, correo);
		
		return "registroSocio.html";
	}*/
	
	@GetMapping("/listadoSocios") // --> localhost:8080/socio/listadoSocios
	public String listarSocios(){
		return "listadoSocios.html";
	}
}
