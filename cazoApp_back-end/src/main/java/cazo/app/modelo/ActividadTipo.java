package cazo.app.modelo;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "actividad_tipo")
public class ActividadTipo {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "actividad_tipo_id")
	private Long actividad_tipo_id;

	@Column(name = "actividad_tipo_nombre")
	private String actividad_tipo_nombre;

	@Column(name = "actividad_tipo_descripcion", length = 255, nullable = false)
	private String actividad_tipo_descripcion;

	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "actividad_id")
	private Actividad actividad_id;

	// Constructor vacio
	public ActividadTipo() {}

	// Constructor parametrizado
	public ActividadTipo(Long actividad_tipo_id, String actividad_tipo_nombre, String actividad_tipo_descripcion,
	Actividad actividad_id) {
		super();
		this.actividad_tipo_id = actividad_tipo_id;
		this.actividad_tipo_nombre = actividad_tipo_nombre;
		this.actividad_tipo_descripcion = actividad_tipo_descripcion;
		this.actividad_id = actividad_id;
	}

	// Getters y setters
	public Long getActividad_tipo_id() {
		return actividad_tipo_id;
	}

	public void setActividad_tipo_id(Long actividad_tipo_id) {
		this.actividad_tipo_id = actividad_tipo_id;
	}

	public String getActividad_tipo_nombre() {
		return actividad_tipo_nombre;
	}

	public void setActividad_tipo_nombre(String actividad_tipo_nombre) {
		this.actividad_tipo_nombre = actividad_tipo_nombre;
	}

	public String getActividad_tipo_descripcion() {
		return actividad_tipo_descripcion;
	}

	public void setActividad_tipo_descripcion(String actividad_tipo_descripcion) {
		this.actividad_tipo_descripcion = actividad_tipo_descripcion;
	}

	public Actividad getActividad_id() {
		return actividad_id;
	}

	public void setActividad_id(Actividad actividad_id) {
		this.actividad_id = actividad_id;
	}

	@Override
	public String toString() {
		return "ActividadTipo [actividad_tipo_id=" + actividad_tipo_id + ", actividad_tipo_nombre="
				+ actividad_tipo_nombre + ", actividad_tipo_descripcion=" + actividad_tipo_descripcion
				+ ", actividad_id=" + actividad_id + "]";
	}

}
