import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MetodoPagoRepositorio extends JpaRepository<MetodoPago, Long>{

}
