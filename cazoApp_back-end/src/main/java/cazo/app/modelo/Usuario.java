package cazo.app.modelo;

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
import javax.persistence.Transient;

import cazo.app.enumeraciones.TipoUsuario;

@Entity
@Table(name = "usuario")
public class Usuario{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "usuario_id")
	private Long usuario_id;

	@Column(name = "usuario_nombre", length = 50, nullable = false)
	private String usuario_nombre;

	@Column(name = "usuario_clave", length = 50, nullable = false)
	private String usuario_clave;

	@Column(name = "usuario_clave_rep", length = 50, nullable = false)
	private String usuario_clave_rep;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "imagen_id")
	private Imagen imagen_id;

	@Column(name = "usuario_tipo", columnDefinition = "ENUM('NORMAL', 'ADMINISTRADOR')")
	@Enumerated(EnumType.STRING)
	private TipoUsuario usuario_tipo;

	/*
	 * También le agregamos la relación del lado de usuario, para que sea
	 * bi-direccional. De este lado, le ponemos exactamente el mismo nombre que
	 * tiene el campo con el @JoinColumn en la clase que lleva la relación
	 */
	
	//Se eliminó la relación bi-direccional con socio, hay que reveerla porque genera un loop interno

	// Constructor vacio
	public Usuario() {}

	// Constructor parametrizado
	public Usuario(Long usuario_id, String usuario_nombre, String usuario_clave, String usuario_clave_rep,
			Imagen imagen_id, TipoUsuario usuario_tipo) {
		super();
		this.usuario_id = usuario_id;
		this.usuario_nombre = usuario_nombre;
		this.usuario_clave = usuario_clave;
		this.usuario_clave_rep = usuario_clave_rep;
		this.imagen_id = imagen_id;
		this.usuario_tipo = usuario_tipo;
	}

	//Getters y setters
	public Long getUsuario_id() {
		return usuario_id;
	}

	public void setUsuario_id(Long usuario_id) {
		this.usuario_id = usuario_id;
	}

	public String getUsuario_nombre() {
		return usuario_nombre;
	}

	public void setUsuario_nombre(String usuario_nombre) {
		this.usuario_nombre = usuario_nombre;
	}

	public String getUsuario_clave() {
		return usuario_clave;
	}

	public void setUsuario_clave(String usuario_clave) {
		this.usuario_clave = usuario_clave;
	}

	public String getUsuario_clave_rep() {
		return usuario_clave_rep;
	}

	public void setUsuario_clave_rep(String usuario_clave_rep) {
		this.usuario_clave_rep = usuario_clave_rep;
	}

	public Imagen getImagen_id() {
		return imagen_id;
	}

	public void setImagen_id(Imagen imagen_id) {
		this.imagen_id = imagen_id;
	}

	public TipoUsuario getUsuario_tipo() {
		return usuario_tipo;
	}

	public void setUsuario_tipo(TipoUsuario usuario_tipo) {
		this.usuario_tipo = usuario_tipo;
	}

	@Override
	public String toString() {
		return "Usuario [usuario_id=" + usuario_id + ", usuario_nombre=" + usuario_nombre + ", usuario_clave="
				+ usuario_clave + ", usuario_clave_rep=" + usuario_clave_rep + ", imagen_id=" + imagen_id
				+ ", usuario_tipo=" + usuario_tipo + "]";
	}

}