package cazo.app.servicios;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cazo.app.modelo.DocumentoSocio;
import cazo.app.repositorios.DocumentoSocioRepositorio;

@Service
public class DocumentoSocioServicio {
	@Autowired
	private DocumentoSocioRepositorio docRepo;
	
	@Transactional
	public DocumentoSocio obtenerDocumentoPorId(Long id) throws Exception{
		Optional<DocumentoSocio> presente = docRepo.findById(id);
			if(presente.isPresent()){
				return presente.get();
			}else{
				throw new Exception("El documento no se encontró");
			}
	}
	
}
