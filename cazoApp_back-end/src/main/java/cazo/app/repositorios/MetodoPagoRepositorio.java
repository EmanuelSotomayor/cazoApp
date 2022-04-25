package cazo.app.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import cazo.app.modelo.MetodoPago;

@Repository
public interface MetodoPagoRepositorio extends JpaRepository<MetodoPago, Long>{

}
