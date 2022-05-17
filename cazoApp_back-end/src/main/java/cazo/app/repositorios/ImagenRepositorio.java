package cazo.app.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import cazo.app.modelo.Imagen;

@Repository
public interface ImagenRepositorio extends JpaRepository<Imagen, Long>{

}
