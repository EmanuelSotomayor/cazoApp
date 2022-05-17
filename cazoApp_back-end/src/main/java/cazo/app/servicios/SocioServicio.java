package cazo.app.servicios;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cazo.app.excepciones.SocioExcepcion;
import cazo.app.modelo.DocumentoSocio;
import cazo.app.modelo.ProcedenciaSocio;
import cazo.app.modelo.Socio;
import cazo.app.repositorios.SocioRepositorio;
import cazo.app.repositorios.UsuarioRepositorio;

@Service
public class SocioServicio{
	
	private final static Logger LOGGER = LoggerFactory.getLogger(Socio.class);
	
	@Autowired
	private SocioRepositorio socioRepo;
	
	@Transactional
	public void guardarSocio(Socio socio){
		socioRepo.save(socio);
	}
	
	@Transactional
	public void eliminarSocioPorId(Long id) throws Exception{
		Optional<Socio> presente = socioRepo.findById(id);
			if(presente.isPresent()){
				Socio socio = presente.get();
				socioRepo.delete(socio);
				LOGGER.info("Socio [ID] " + id + " eliminado");
			}else {
				LOGGER.error("El socio no fue encontrado");
				throw new Exception("El socio no fue encontrado");
			}
	}
	
	@Transactional
	public List<Socio> listarSocios(){
		List<Socio> socios = socioRepo.findAll();
		return socios;
	}
	
	@Transactional
	public Socio obtenerSocioPorId(Long id) throws Exception{
		Optional<Socio> presente = socioRepo.findById(id);
			if(presente.isPresent()){
				return presente.get();
			}else{
				throw new Exception("El socio no se encontró");
			}
	}
	
	@Transactional
	public void validarSocio(Socio socio, DocumentoSocio documento, ProcedenciaSocio procedencia) throws SocioExcepcion {
		if(socio.getSocio_nombre().isEmpty() || socio.getSocio_nombre() == null){
			throw new SocioExcepcion("El nombre no puede estar vacio");
		}
		if(socio.getSocio_apellido().isEmpty() || socio.getSocio_apellido() == null){
			throw new SocioExcepcion("El apellido no puede estar vacio");
		}
		if(socio.getSocio_telefono().length() < 10){
			throw new SocioExcepcion("El numero no es valido");
		}
		if(documento.getDocumento_valor().length() < 8){
			throw new SocioExcepcion("El DNI no es valido");
		}
		if(procedencia.getProcedencia_nac().length() < 5){
			throw new SocioExcepcion("El país no es valido");
		}
		if(procedencia.getProcedencia_prov().length() < 5){
			throw new SocioExcepcion("La provincia no es valida");
		}
		if(procedencia.getProcedencia_ciudad().length() < 5){
			throw new SocioExcepcion("La ciudad no es valida");
		}
		if(procedencia.getProcedencia_loc().length() < 5){
			throw new SocioExcepcion("La localidad no es valida");
		}
		if(procedencia.getProcedencia_dir().length() < 5){
			throw new SocioExcepcion("La direccion no es valida");
		}
		if(procedencia.getProcedencia_dir_num() < 1){
			throw new SocioExcepcion("El numero no es valido");
		}
		if(procedencia.getProcedencia_cod().length() < 4){
			throw new SocioExcepcion("El codigo postal no es valido");
		}
		if(socio.getSocio_correo().isEmpty() || !socio.getSocio_correo().contains("@") 
		|| !socio.getSocio_correo().contains(".")){
			throw new SocioExcepcion("El formato de correo no es correcto");
		}
	}
	
	@Transactional
	public void validarSocio(Socio socio, ProcedenciaSocio procedencia) throws SocioExcepcion {
		if(socio.getSocio_nombre().isEmpty() || socio.getSocio_nombre() == null){
			throw new SocioExcepcion("El nombre no puede estar vacio");
		}
		if(socio.getSocio_apellido().isEmpty() || socio.getSocio_apellido() == null){
			throw new SocioExcepcion("El apellido no puede estar vacio");
		}
		if(socio.getSocio_correo().isEmpty() || !socio.getSocio_correo().contains("@")
		|| !socio.getSocio_correo().contains(".")){
			throw new SocioExcepcion("El formato del correo no es valido");
		}
		if(socio.getSocio_telefono().length() < 10){
			throw new SocioExcepcion("El telefono no es valido");
		}
		if(procedencia.getProcedencia_prov().length() < 5){
			throw new SocioExcepcion("La provincia no es valida");
		}
		if(procedencia.getProcedencia_ciudad().length() < 5){
			throw new SocioExcepcion("La ciudad no es valida");
		}
		if(procedencia.getProcedencia_loc().length() < 5){
			throw new SocioExcepcion("La localidad no es valida");
		}
		if(procedencia.getProcedencia_dir().length() < 5){
			throw new SocioExcepcion("La direccion no es valida");
		}
		if(procedencia.getProcedencia_dir_num() < 1){
			throw new SocioExcepcion("El numero no es valido");
		}
		if(procedencia.getProcedencia_cod().length() < 4){
			throw new SocioExcepcion("El codigo postal no es valido");
		}
	}
	
	@Transactional
	public void validarSocio(Socio socio) throws SocioExcepcion {
		if(socio.getSocio_nombre().isEmpty() || socio.getSocio_nombre() == null){
			throw new SocioExcepcion("El nombre no puede estar vacio");
		}
		if(socio.getSocio_apellido().isEmpty() || socio.getSocio_apellido() == null){
			throw new SocioExcepcion("El apellido no puede estar vacio");
		}
		if(socio.getSocio_correo().isEmpty() || !socio.getSocio_correo().contains("@")
		|| !socio.getSocio_correo().contains(".")){
			throw new SocioExcepcion("El formato del correo no es valido");
		}
		if(socio.getSocio_telefono().length() < 10){
			throw new SocioExcepcion("El telefono no es valido");
		}
	}
	
	
}