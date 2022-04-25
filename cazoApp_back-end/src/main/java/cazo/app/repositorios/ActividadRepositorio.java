package cazo.app.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import cazo.app.modelo.Actividad;

@Repository
public interface ActividadRepositorio extends JpaRepository<Actividad, Long>{
	
}