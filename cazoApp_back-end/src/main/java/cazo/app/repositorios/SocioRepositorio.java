package cazo.app.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import cazo.app.modelo.Socio;

@Repository
public interface SocioRepositorio extends JpaRepository<Socio, Long>{

}
