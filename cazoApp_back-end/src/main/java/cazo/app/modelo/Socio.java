package cazo.app.modelo;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;

import cazo.app.enumeraciones.SexoSocio;

@Entity
@Table(name = "socio")
public class Socio {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "socio_id")
	private Long socio_id;

	@Column(name = "socio_nombre", length = 50, nullable = false)
	private String socio_nombre;

	@Column(name = "socio_apellido", length = 50, nullable = false)
	private String socio_apellido;

	@Column(name = "socio_sexo", columnDefinition = "ENUM('MASCULINO', 'FEMENINO', 'OTRO')")
	@Enumerated(EnumType.STRING)
	private SexoSocio socio_sexo;

	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@Column(name = "socio_fecha_nac")
	private Date socio_fecha_nac;
	
	/*
	 Le agregamos la propiedad "unique", para que en la base de datos no se pueda
	 repetir.
	 */
	@Column(name = "socio_correo", length = 255, nullable = false, unique = true)
	private String socio_correo;

	@Column(name = "socio_telefono", length = 20, nullable = false)
	private String socio_telefono;
	
	@OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL, orphanRemoval = true)
	@JoinColumn(name = "documento_id")
	private DocumentoSocio documento_id;
	
	/*El orphanRemoval, solo funciona sí está declarado el fetch como EAGER*/
	@OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL, orphanRemoval = true)
	@JoinColumn(name = "procedencia_id")
	private ProcedenciaSocio procedencia_id;

	// Socio tiene un usuario y de este lado empezamos la relación OneToOne
	@OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL, orphanRemoval = true)
	/*Indicamos el nombre que le vamos a dar al campo que se guardará en la base de
	 datos*/
	@JoinColumn(name = "usuario_id")
	private Usuario usuario_id;

	// Constructor vacio
	public Socio() {}
	//Constructor parametrizado
	public Socio(Long socio_id, String socio_nombre, String socio_apellido, SexoSocio socio_sexo, Date socio_fecha_nac,
			String socio_correo, String socio_telefono, DocumentoSocio documento_id, ProcedenciaSocio procedencia_id,
			Usuario usuario_id) {
		super();
		this.socio_id = socio_id;
		this.socio_nombre = socio_nombre;
		this.socio_apellido = socio_apellido;
		this.socio_sexo = socio_sexo;
		this.socio_fecha_nac = socio_fecha_nac;
		this.socio_correo = socio_correo;
		this.socio_telefono = socio_telefono;
		this.documento_id = documento_id;
		this.procedencia_id = procedencia_id;
		this.usuario_id = usuario_id;
	}
	
	//Getters y setters
	public Long getSocio_id() {
		return socio_id;
	}
	public void setSocio_id(Long socio_id) {
		this.socio_id = socio_id;
	}
	public String getSocio_nombre() {
		return socio_nombre;
	}
	public void setSocio_nombre(String socio_nombre) {
		this.socio_nombre = socio_nombre;
	}
	public String getSocio_apellido() {
		return socio_apellido;
	}
	public void setSocio_apellido(String socio_apellido) {
		this.socio_apellido = socio_apellido;
	}
	public SexoSocio getSocio_sexo() {
		return socio_sexo;
	}
	public void setSocio_sexo(SexoSocio socio_sexo) {
		this.socio_sexo = socio_sexo;
	}
	public Date getSocio_fecha_nac() {
		return socio_fecha_nac;
	}
	public void setSocio_fecha_nac(Date socio_fecha_nac) {
		this.socio_fecha_nac = socio_fecha_nac;
	}
	public String getSocio_correo() {
		return socio_correo;
	}
	public void setSocio_correo(String socio_correo) {
		this.socio_correo = socio_correo;
	}
	public String getSocio_telefono() {
		return socio_telefono;
	}
	public void setSocio_telefono(String socio_telefono) {
		this.socio_telefono = socio_telefono;
	}
	public DocumentoSocio getDocumento_id() {
		return documento_id;
	}
	public void setDocumento_id(DocumentoSocio documento_id) {
		this.documento_id = documento_id;
	}
	public ProcedenciaSocio getProcedencia_id() {
		return procedencia_id;
	}
	public void setProcedencia_id(ProcedenciaSocio procedencia_id) {
		this.procedencia_id = procedencia_id;
	}
	public Usuario getUsuario_id() {
		return usuario_id;
	}
	public void setUsuario_id(Usuario usuario_id) {
		this.usuario_id = usuario_id;
	}
	
	@Override
	public String toString() {
		return "Socio [socio_id=" + socio_id + ", socio_nombre=" + socio_nombre + ", socio_apellido=" + socio_apellido
				+ ", socio_sexo=" + socio_sexo + ", socio_fecha_nac=" + socio_fecha_nac + ", socio_correo="
				+ socio_correo + ", socio_telefono=" + socio_telefono + ", documento_id=" + documento_id
				+ ", procedencia_id=" + procedencia_id + ", usuario_id=" + usuario_id + "]";
	}
	
}