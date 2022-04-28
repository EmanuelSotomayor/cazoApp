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

import cazo.app.enumeraciones.TipoUsuario;

@Entity
@Table(name = "usuario")
public class Usuario{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "usuario_id")
	private Long id;
	
	@Column(name = "usuario_nombre", length = 50, nullable = false)
	private String nombreUsuario;
	
	@Column(name = "usuario_clave", length = 50, nullable = false)
	private String claveUsuario;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "foto_usuario_id")
	private FotoUsuario foto;
	
	/*Le agregamos la propiedad "unique", para que en la base de datos no se pueda repetir. */
	@Column(name = "usuario_correo", length = 255, nullable = false, unique = true)
	private String correo;
	
	@Column(name = "usuario_tipo", columnDefinition = "ENUM('NORMAL', 'ADMINISTRADOR')")
	@Enumerated(EnumType.STRING)
	private TipoUsuario tipo;
	
	/*También le agregamos la relación del lado de usuario, para que sea 
	bi-direccional. De este lado, le ponemos exactamente el mismo nombre
	que tiene el campo con el @JoinColumn en la clase que lleva la relación*/
	@OneToOne(mappedBy = "usuario", fetch = FetchType.LAZY)
	private Socio socio;

	// Constructor vacio
	public Usuario() {}

	// Constructor parametrizado
	public Usuario(Long id, String nombreUsuario, String claveUsuario, FotoUsuario foto,
	String correo, Socio socio) {
		this.id = id;
		this.nombreUsuario = nombreUsuario;
		this.claveUsuario = claveUsuario;
		this.foto = foto;
		this.correo = correo;
		this.socio = socio;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombreUsuario() {
		return nombreUsuario;
	}

	public void setNombreUsuario(String nombreUsuario) {
		this.nombreUsuario = nombreUsuario;
	}

	public String getClaveUsuario() {
		return claveUsuario;
	}

	public void setClaveUsuario(String claveUsuario) {
		this.claveUsuario = claveUsuario;
	}

	public FotoUsuario getFotoUsuario() {
		return foto;
	}

	public void setFotoUsuario(FotoUsuario foto) {
		this.foto = foto;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public Socio getSocio() {
		return socio;
	}

	public void setSocio(Socio socio) {
		this.socio = socio;
	}

	@Override
	public String toString() {
		return "Usuario [id=" + id + ", nombreUsuario=" + nombreUsuario + ", claveUsuario=" + claveUsuario
				+ ", FotoUsuario=" + foto + ", correo=" + correo + ", socio=" + socio + "]";
	}

}