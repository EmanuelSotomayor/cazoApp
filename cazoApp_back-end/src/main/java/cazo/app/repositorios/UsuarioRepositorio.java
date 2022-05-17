package cazo.app.repositorios;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import cazo.app.modelo.Usuario;

@Repository
public interface UsuarioRepositorio extends JpaRepository<Usuario, Long>{
	@Query(value = "select u from Usuario u where u.usuario_nombre = :usuario_nombre")
	public Optional<Usuario> buscarUsuarioPorNombre(@Param("usuario_nombre") String usuario_nombre);
}