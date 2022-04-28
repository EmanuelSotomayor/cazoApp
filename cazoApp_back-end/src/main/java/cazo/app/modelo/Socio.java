package cazo.app.modelo;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
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
public class Socio{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "socio_id")
	private Long id;
	
	@Column(name = "socio_nombre", length = 50, nullable = false)
	private String nombre;
	
	@Column(name = "socio_apellido", length = 50, nullable = false)
	private String apellido;
	
	@Column(name = "socio_sexo", columnDefinition = "ENUM('MASCULINO', 'FEMENINO', 'OTRO')")
	@Enumerated(EnumType.STRING)
	private SexoSocio sexo;
	
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@Column(name = "socio_fecha_nac")
	private Date fechaNacimiento;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "documento_id")
	private DocumentoSocio documento;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "procedencia_id")
	private ProcedenciaSocio procedencia;
	
	@Column(name = "socio_telefono", length = 20, nullable = false)
	private String telefono;
	
	//Socio tiene un usuario y de este lado empezamos la relación OneToOne
	@OneToOne(cascade = CascadeType.ALL)
	/*Indicamos el nombre que le vamos a dar al campo que se guardará en la
	base de datos*/
	@JoinColumn(name = "usuario_id")
	private Usuario usuario;
	//Constructor vacio
	public Socio(){}
	
	//Constructor parametrizado
	public Socio(Long id, String nombre, String apellido, SexoSocio sexo, 
	Date fechaNacimiento, DocumentoSocio documento, ProcedenciaSocio procedencia, String telefono,
	Usuario usuario) {
		this.id = id;
		this.nombre = nombre;
		this.apellido = apellido;
		this.sexo = sexo;
		this.fechaNacimiento = fechaNacimiento;
		this.documento = documento;
		this.procedencia = procedencia;
		this.telefono = telefono;
		this.usuario = usuario;
	}
	
	//Getters y setters
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public String getNombre() {
		return nombre;
	}
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public void setUsuario(Usuario usuario){
		this.usuario = usuario;
	}
	
	public Usuario getUsuario(){
		return this.usuario;
	}
	
	public String getApellido() {
		return apellido;
	}
	
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	
	public SexoSocio getSexo() {
		return sexo;
	}
	
	public void setSexo(SexoSocio sexo) {
		this.sexo = sexo;
	}
	
	public Date getFechaNacimiento() {
		return fechaNacimiento;
	}
	
	public void setFechaNacimiento(Date fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}
	
	public DocumentoSocio getDocumento() {
		return documento;
	}
	
	public void setDocumento(DocumentoSocio documento) {
		this.documento = documento;
	}
	
	public ProcedenciaSocio getProcedencia() {
		return procedencia;
	}
	
	public void setProcedencia(ProcedenciaSocio procedencia) {
		this.procedencia = procedencia;
	}
	
	public String getTelefono() {
		return telefono;
	}
	
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	@Override
	public String toString() {
		return "Socio [id=" + id + ", nombre=" + nombre + ", apellido=" + apellido + ", sexo=" + sexo
				+ ", fechaNacimiento=" + fechaNacimiento + ", documento=" + documento + ", procedencia=" + procedencia
				+ ", telefono=" + telefono + ", usuario=" + usuario + "]";
	}
	
}