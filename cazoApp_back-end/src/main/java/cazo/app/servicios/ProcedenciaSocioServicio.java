package cazo.app.servicios;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cazo.app.modelo.ProcedenciaSocio;
import cazo.app.repositorios.ProcedenciaSocioRepositorio;

@Service
public class ProcedenciaSocioServicio {
	
	@Autowired
	private ProcedenciaSocioRepositorio proRepo;
	
	@Transactional
	public ProcedenciaSocio obtenerProcedenciaPorId(Long id) throws Exception{
		Optional<ProcedenciaSocio> presente = proRepo.findById(id);
			if(presente.isPresent()){
				return presente.get();
			}else{
				throw new Exception("La procedencia no se pudo encontrar");
			}
	}
}