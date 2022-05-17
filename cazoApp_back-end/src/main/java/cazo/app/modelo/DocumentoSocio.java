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
	private Long documento_id;
	
	@Column(name = "documento_tipo", columnDefinition = "ENUM('DNI', 'LE', 'LC', 'CI')")
	@Enumerated(EnumType.STRING)
	private TipoDocumento documento_tipo;
	
	@Column(name = "documento_valor", length = 20, nullable = false)
	private String documento_valor;

	// Constructor vacio
	public DocumentoSocio() {}

	// Constructor parametrizado
	public DocumentoSocio(Long documento_id, TipoDocumento documento_tipo, String documento_valor) {
		super();
		this.documento_id = documento_id;
		this.documento_tipo = documento_tipo;
		this.documento_valor = documento_valor;
	}
	
	//Getters y setters
	public Long getDocumento_id() {
		return documento_id;
	}

	public void setDocumento_id(Long documento_id) {
		this.documento_id = documento_id;
	}

	public TipoDocumento getDocumento_tipo() {
		return documento_tipo;
	}

	public void setDocumento_tipo(TipoDocumento documento_tipo) {
		this.documento_tipo = documento_tipo;
	}

	public String getDocumento_valor() {
		return documento_valor;
	}

	public void setDocumento_valor(String documento_valor) {
		this.documento_valor = documento_valor;
	}

	@Override
	public String toString() {
		return "DocumentoSocio [documento_id=" + documento_id + ", documento_tipo=" + documento_tipo
				+ ", documento_valor=" + documento_valor + "]";
	}
}