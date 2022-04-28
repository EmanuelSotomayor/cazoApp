package cazo.app.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import cazo.app.modelo.ProcedenciaSocio;

@Repository
public interface ProcedenciaSocioRepositorio extends JpaRepository<ProcedenciaSocio, Long>{

}