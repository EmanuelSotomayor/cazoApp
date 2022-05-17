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
@Table(name = "imagen")
public class Imagen {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "imagen_id")
	private Long imagen_id;
	@Column(name = "imagen_mime")
	private String imagen_mime;
	@Column(name = "imagen_nombre")
	private String imagen_nombre;
	/*
	 * El arreglo de bytes, matchea con el tipo de dato LONGBLOB en MySQL para
	 * Objetos pesados
	 */
	@Lob
	@Basic(fetch = FetchType.LAZY)
	@Column(name = "imagen_contenido")
	private byte[] imagen_contenido;

	// Constructor vacio
	public Imagen() {}

	// Constructor parametrizado
	public Imagen(Long imagen_id, String imagen_mime, String imagen_nombre, byte[] imagen_contenido) {
		super();
		this.imagen_id = imagen_id;
		this.imagen_mime = imagen_mime;
		this.imagen_nombre = imagen_nombre;
		this.imagen_contenido = imagen_contenido;
	}
	
	//Getters y setters
	public Long getImagen_id() {
		return imagen_id;
	}

	public void setImagen_id(Long imagen_id) {
		this.imagen_id = imagen_id;
	}

	public String getImagen_mime() {
		return imagen_mime;
	}

	public void setImagen_mime(String imagen_mime) {
		this.imagen_mime = imagen_mime;
	}

	public String getImagen_nombre() {
		return imagen_nombre;
	}

	public void setImagen_nombre(String imagen_nombre) {
		this.imagen_nombre = imagen_nombre;
	}

	public byte[] getImagen_contenido() {
		return imagen_contenido;
	}

	public void setImagen_contenido(byte[] imagen_contenido) {
		this.imagen_contenido = imagen_contenido;
	}

	@Override
	public String toString() {
		return "Imagen [imagen_id=" + imagen_id + ", imagen_mime=" + imagen_mime + ", imagen_nombre=" + imagen_nombre
				+ ", imagen_contenido=" + Arrays.toString(imagen_contenido) + "]";
	}
	
}