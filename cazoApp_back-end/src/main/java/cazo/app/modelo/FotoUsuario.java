package cazo.app.modelo;

import java.util.Arrays;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;

@Entity
@Table(name = "foto_usuario")
public class FotoUsuario {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "foto_usuario_id")
	private Long id;
	@Column(name = "foto_usuario_mime")
	private String mime;
	@Column(name = "foto_usuario_nombre")
	private String nombre;
	/*El arreglo de bytes, matchea con el tipo de dato LONGBLOB en MySQL para
	Objetos pesados*/
	@Lob @Basic(fetch = FetchType.LAZY) @Column(name = "foto_usuario_contenido")
	private byte[] contenido;

	// Constructor vacio
	public FotoUsuario() {}
	//Constructor parametrizado
	public FotoUsuario(Long id, String mime, String nombre, byte[] contenido) {
		this.id = id;
		this.mime = mime;
		this.nombre = nombre;
		this.contenido = contenido;
	}
	
	//Getters y setters
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getMime() {
		return mime;
	}
	public void setMime(String mime) {
		this.mime = mime;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public byte[] getContenido() {
		return contenido;
	}
	public void setContenido(byte[] contenido) {
		this.contenido = contenido;
	}
	
	@Override
	public String toString() {
		return "FotoUsuario [id=" + id + ", mime=" + mime + ", nombre=" + nombre + ", contenido="
				+ Arrays.toString(contenido) + "]";
	}
}