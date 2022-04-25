package cazo.app.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import cazo.app.modelo.Persona;

@Repository
public interface PersonaRepositorio extends JpaRepository<Persona, Long>{

}
