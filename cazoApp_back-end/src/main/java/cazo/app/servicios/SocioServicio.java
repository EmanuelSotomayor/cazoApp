package cazo.app.servicios;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cazo.app.repositorios.SocioRepositorio;

@Service
public class SocioServicio {

	@Autowired
	private SocioRepositorio socioRepo;
	
	/*
	@Transactional
	public Socio guardarSocio(String nombre, String apellido, Date fechaNacimiento,
	SexoSocio sexo, String telefono, TipoDocumento tipoDocumento,
	String valorDocumento, String nacionalidad, String provincia,
	String ciudad, String localidad, String direccion, Integer numDireccion,
	String codigoPostal, String nombreUsuario, String claveUsuario,
	String URLimgPerfil, String correo) throws Exception {

		validacion(nombre, apellido, fechaNacimiento, sexo, telefono, 
		tipoDocumento, valorDocumento, nacionalidad, provincia,
		ciudad, localidad, direccion, numDireccion, codigoPostal, 
		nombreUsuario, claveUsuario, URLimgPerfil, correo);
		
		Socio soc = new Socio();
		DocumentoSocio docSoc = new DocumentoSocio();
		ProcedenciaSocio procSoc = new ProcedenciaSocio();
		Usuario user = new Usuario();
		
		docSoc.setTipoDocumento(tipoDocumento);
		docSoc.setValorDocumento(valorDocumento);
		
		procSoc.setCiudad(ciudad);
		procSoc.setCodigoPostal(codigoPostal);
		procSoc.setDireccion(direccion);
		procSoc.setLocalidad(localidad);
		procSoc.setNacionalidad(nacionalidad);
		procSoc.setNumDireccion(numDireccion);
		procSoc.setProvincia(provincia);
		
		user.setNombreUsuario(nombreUsuario);
		user.setClaveUsuario(claveUsuario);
		user.setCorreo(correo);
		user.setURLimgPerfil(URLimgPerfil);
		user.setSocio(soc);
		
		soc.setNombre(nombre);
		soc.setApellido(apellido);
		soc.setFechaNacimiento(fechaNacimiento);
		soc.setSexo(sexo);
		soc.setTelefono(telefono);
		soc.setDocumento(docSoc);
		soc.setProcedencia(procSoc);
		soc.setUsuario(user);
		
		return socioRepo.save(soc);
	}
	
	@Transactional
	public void validacion(String nombre, String apellido, Date fechaNacimiento,
	SexoSocio sexo, String telefono, TipoDocumento tipoDocumento,
	String valorDocumento, String nacionalidad, String provincia,
	String ciudad, String localidad, String direccion, Integer numDireccion,
	String codigoPostal, String nombreUsuario, String claveUsuario,
	String URLimgPerfil, String correo) throws Exception {
	
		if (nombre.isBlank() || nombre.isEmpty() || nombre == null) {
			throw new Exception("El usuario no puede estar vacio");
		}
		
		if (apellido.isBlank() || apellido.isEmpty() || apellido == null) {
			throw new Exception("El apellido no puede estar vacio");
		}
		
	}*/
}