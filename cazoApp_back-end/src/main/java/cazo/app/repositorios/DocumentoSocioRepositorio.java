package cazo.app.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import cazo.app.modelo.DocumentoSocio;

@Repository
public interface DocumentoSocioRepositorio extends JpaRepository<DocumentoSocio, Long>{

}