package cazo.app.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import cazo.app.modelo.FotoUsuario;

@Repository
public interface FotoUsuarioRepositorio extends JpaRepository<FotoUsuario, Long>{

}
