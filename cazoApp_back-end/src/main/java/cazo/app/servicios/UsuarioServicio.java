package cazo.app.servicios;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cazo.app.excepciones.UsuarioExcepcion;
import cazo.app.modelo.Usuario;
import cazo.app.repositorios.UsuarioRepositorio;

@Service
public class UsuarioServicio implements UserDetailsService{
	
	private static final Logger LOGGER = LoggerFactory.getLogger(Usuario.class);
	@Autowired
	private UsuarioRepositorio usuarioRepo;
	
	@Transactional
	public Usuario retornarUsuario(Usuario usuario){
		Usuario usuarioModificado = new Usuario();
		usuarioModificado.setUsuario_nombre(usuario.getUsuario_nombre());
		String claveEncriptada = new BCryptPasswordEncoder().encode(usuario.getUsuario_clave());
		usuarioModificado.setUsuario_clave(claveEncriptada);
		usuarioModificado.setUsuario_clave_rep(claveEncriptada);
		usuarioModificado.setUsuario_tipo(usuario.getUsuario_tipo());
		return usuarioModificado;
	}
	
	@Transactional
	public Usuario buscarUsuarioPorNombre(String usuario_nombre) throws UsuarioExcepcion{
		Optional<Usuario> presente = usuarioRepo.buscarUsuarioPorNombre(usuario_nombre);
			if(presente.isPresent()){
				return presente.get();
			}else{
				throw new UsuarioExcepcion("No sé encontró el usuario");
			}
	}
	
	@Transactional
	public Usuario buscarPorId(Long id) throws UsuarioExcepcion{
		Optional<Usuario> presente = usuarioRepo.findById(id);
			if(presente.isPresent()){
				return presente.get();
			}else{
				throw new UsuarioExcepcion("No se encontró el usuario");
			}
	}
	
	@Override
	public UserDetails loadUserByUsername(String usuario_nombre) throws UsernameNotFoundException {
		Optional<Usuario> usuarioPresente = usuarioRepo.buscarUsuarioPorNombre(usuario_nombre);
			if(usuarioPresente.isPresent()){
				List<GrantedAuthority> permisos = new ArrayList<>();
				GrantedAuthority usuarioNormal = new SimpleGrantedAuthority("ROLE_USUARIO_NORMAL");
				permisos.add(usuarioNormal);
				Usuario usuario = usuarioPresente.get();
				User user = new User(usuario.getUsuario_nombre(), usuario.getUsuario_clave(), permisos);
				return user;
			}else{
				throw new UsernameNotFoundException("El usuario o la contraseña no son validos");
			}
	}
	
	@Transactional
	public void validarUsuario(Usuario usuario) throws UsuarioExcepcion{
		if(usuario.getUsuario_nombre().isEmpty() || usuario.getUsuario_nombre() == null){
			throw new UsuarioExcepcion("El nombre de usuario no puede estar vacio");
		}
		if(usuario.getUsuario_clave().isEmpty() || usuario.getUsuario_clave() == null){
			throw new UsuarioExcepcion("La clave no puede estar vacia");
		}
		if(usuario.getUsuario_clave().length() < 8 || usuario.getUsuario_clave_rep().length() < 8){
			throw new UsuarioExcepcion("La clave no puede tener menos de 8 caracteres");
		}
		if(usuario.getUsuario_clave_rep().isEmpty() || usuario.getUsuario_clave_rep() == null){
			throw new UsuarioExcepcion("La repetición de la clave no puede estar vacia");
		}
		if(!usuario.getUsuario_clave_rep().equals(usuario.getUsuario_clave())){
			throw new UsuarioExcepcion("Las claves no coinciden");
		}
	}
}