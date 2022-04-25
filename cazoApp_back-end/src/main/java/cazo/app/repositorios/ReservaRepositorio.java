package cazo.app.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import cazo.app.modelo.Reserva;

@Repository
public interface ReservaRepositorio extends JpaRepository<Reserva, Long>{

}
