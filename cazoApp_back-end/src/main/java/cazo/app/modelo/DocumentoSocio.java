package cazo.app.modelo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import cazo.app.enumeraciones.TipoDocumento;

@Entity
@Table(name = "documento")
public class DocumentoSocio{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "documento_id")
	private Long id;
	
	@Column(name = "documento_tipo", columnDefinition = "ENUM('DNI', 'LE', 'LC', 'CI')")
	@Enumerated(EnumType.STRING)
	private TipoDocumento tipoDocumento;
	
	@Column(name = "documento_valor", length = 20, nullable = false)
	private String valorDocumento;

	// Constructor vacio
	public DocumentoSocio() {}

	// Constructor parametrizado
	public DocumentoSocio(Long id, TipoDocumento tipoDocumento, String valorDocumento) {
		this.id = id;
		this.tipoDocumento = tipoDocumento;
		this.valorDocumento = valorDocumento;
	}

	// Getters y setters
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public TipoDocumento getTipoDocumento() {
		return tipoDocumento;
	}

	public void setTipoDocumento(TipoDocumento tipoDocumento) {
		this.tipoDocumento = tipoDocumento;
	}

	public String getValorDocumento() {
		return valorDocumento;
	}

	public void setValorDocumento(String valorDocumento) {
		this.valorDocumento = valorDocumento;
	}

	@Override
	public String toString() {
		return "DocumentoSocio [id=" + id + ", tipoDocumento=" + tipoDocumento + ", valorDocumento=" + valorDocumento
				+ "]";
	}

}