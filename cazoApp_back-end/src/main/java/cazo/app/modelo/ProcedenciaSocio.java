package cazo.app.modelo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "procedencia")
public class ProcedenciaSocio{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "procedencia_id")
	private Long id;
	
	@Column(name = "procedencia_nac", length = 100, nullable = false)
	private String nacionalidad;
	
	@Column(name = "procedencia_prov", length = 100, nullable = false)
	private String provincia;
	
	@Column(name = "procedencia_ciudad", length = 100, nullable = false)
	private String ciudad;
	
	@Column(name = "procedencia_loc", length = 100, nullable = false)
	private String localidad;
	
	@Column(name = "procedencia_dir", length = 100, nullable = false)
	private String direccion;
	
	@Column(name = "procedencia_dir_num", length = 10, nullable = false)
	private Integer numDireccion;
	
	@Column(name = "procedencia_cod", length = 10, nullable = false)
	private String codigoPostal;

	// Constructor vacio
	public ProcedenciaSocio() {}

	// Constructor parametrizado
	public ProcedenciaSocio(Long id, String nacionalidad, String provincia, String ciudad, String localidad,
	String direccion, Integer numDireccion, String codigoPostal) {
		this.id = id;
		this.nacionalidad = nacionalidad;
		this.provincia = provincia;
		this.ciudad = ciudad;
		this.localidad = localidad;
		this.direccion = direccion;
		this.numDireccion = numDireccion;
		this.codigoPostal = codigoPostal;
	}

	// Getters y setters
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNacionalidad() {
		return nacionalidad;
	}

	public void setNacionalidad(String nacionalidad) {
		this.nacionalidad = nacionalidad;
	}

	public String getProvincia() {
		return provincia;
	}

	public void setProvincia(String provincia) {
		this.provincia = provincia;
	}

	public String getCiudad() {
		return ciudad;
	}

	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}

	public String getLocalidad() {
		return localidad;
	}

	public void setLocalidad(String localidad) {
		this.localidad = localidad;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public Integer getNumDireccion() {
		return numDireccion;
	}

	public void setNumDireccion(Integer numDireccion) {
		this.numDireccion = numDireccion;
	}

	public String getCodigoPostal() {
		return codigoPostal;
	}

	public void setCodigoPostal(String codigoPostal) {
		this.codigoPostal = codigoPostal;
	}

	@Override
	public String toString() {
		return "ProcedenciaSocio [id=" + id + ", nacionalidad=" + nacionalidad + ", provincia=" + provincia
				+ ", ciudad=" + ciudad + ", localidad=" + localidad + ", direccion=" + direccion + ", numDireccion="
				+ numDireccion + ", codigoPostal=" + codigoPostal + "]";
	}
}