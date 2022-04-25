package cazo.app.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import cazo.app.modelo.ActividadTipo;

@Repository
public interface ActividadTipoRepositorio extends JpaRepository<ActividadTipo, Long>{

}