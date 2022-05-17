package cazo.app.modelo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "procedencia")
public class ProcedenciaSocio {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "procedencia_id")
	private Long procedencia_id;

	@Column(name = "procedencia_nac", length = 100, nullable = false)
	private String procedencia_nac;

	@Column(name = "procedencia_prov", length = 100, nullable = false)
	private String procedencia_prov;

	@Column(name = "procedencia_ciudad", length = 100, nullable = false)
	private String procedencia_ciudad;

	@Column(name = "procedencia_loc", length = 100, nullable = false)
	private String procedencia_loc;

	@Column(name = "procedencia_dir", length = 100, nullable = false)
	private String procedencia_dir;

	@Column(name = "procedencia_dir_num", length = 10, nullable = false)
	private Integer procedencia_dir_num;

	@Column(name = "procedencia_cod", length = 10, nullable = false)
	private String procedencia_cod;

	// Constructor vacio
	public ProcedenciaSocio() {
	}

	// Constructor parametrizado
	public ProcedenciaSocio(Long procedencia_id, String procedencia_nac, String procedencia_prov,
	String procedencia_ciudad, String procedencia_loc, String procedencia_dir, Integer procedencia_dir_num,
	String procedencia_cod) {
		this.procedencia_id = procedencia_id;
		this.procedencia_nac = procedencia_nac;
		this.procedencia_prov = procedencia_prov;
		this.procedencia_ciudad = procedencia_ciudad;
		this.procedencia_loc = procedencia_loc;
		this.procedencia_dir = procedencia_dir;
		this.procedencia_dir_num = procedencia_dir_num;
		this.procedencia_cod = procedencia_cod;
	}

	// Getters y setters
	public Long getProcedencia_id() {
		return procedencia_id;
	}

	public void setProcedencia_id(Long procedencia_id) {
		this.procedencia_id = procedencia_id;
	}

	public String getProcedencia_nac() {
		return procedencia_nac;
	}

	public void setProcedencia_nac(String procedencia_nac) {
		this.procedencia_nac = procedencia_nac;
	}

	public String getProcedencia_prov() {
		return procedencia_prov;
	}

	public void setProcedencia_prov(String procedencia_prov) {
		this.procedencia_prov = procedencia_prov;
	}

	public String getProcedencia_ciudad() {
		return procedencia_ciudad;
	}

	public void setProcedencia_ciudad(String procedencia_ciudad) {
		this.procedencia_ciudad = procedencia_ciudad;
	}

	public String getProcedencia_loc() {
		return procedencia_loc;
	}

	public void setProcedencia_loc(String procedencia_loc) {
		this.procedencia_loc = procedencia_loc;
	}

	public String getProcedencia_dir() {
		return procedencia_dir;
	}

	public void setProcedencia_dir(String procedencia_dir) {
		this.procedencia_dir = procedencia_dir;
	}

	public Integer getProcedencia_dir_num() {
		return procedencia_dir_num;
	}

	public void setProcedencia_dir_num(Integer procedencia_dir_num) {
		this.procedencia_dir_num = procedencia_dir_num;
	}

	public String getProcedencia_cod() {
		return procedencia_cod;
	}

	public void setProcedencia_cod(String procedencia_cod) {
		this.procedencia_cod = procedencia_cod;
	}

	@Override
	public String toString() {
		return "ProcedenciaSocio [procedencia_id=" + procedencia_id + ", procedencia_nac=" + procedencia_nac
				+ ", procedencia_prov=" + procedencia_prov + ", procedencia_ciudad=" + procedencia_ciudad
				+ ", procedencia_loc=" + procedencia_loc + ", procedencia_dir=" + procedencia_dir
				+ ", procedencia_dir_num=" + procedencia_dir_num + ", procedencia_cod=" + procedencia_cod + "]";
	}

}