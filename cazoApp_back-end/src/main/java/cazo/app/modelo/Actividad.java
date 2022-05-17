package cazo.app.modelo;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "actividad")
public class Actividad{

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="actividad_id")
    private Long actividad_id;
    @Column(name = "actividad_nombre", length = 50, nullable = false)
    private String actividad_nombre;
    
    //Constructor vacio
    public Actividad() {}
    //Constructor parametrizado
    public Actividad(Long actividad_id, String actividad_nombre) {
        this.actividad_id = actividad_id;
        this.actividad_nombre = actividad_nombre;
    }
    
    //Getters y setters
    public Long getActividad_id() {
        return actividad_id;
    }

    public void setActividad_id(Long actividad_id) {
        this.actividad_id = actividad_id;
    }

    public String getActividad_nombre() {
        return actividad_nombre;
    }

    public void setActividad_nombre(String actividad_nombre) {
        this.actividad_nombre = actividad_nombre;
    }
    
	@Override
	public String toString() {
		return "Actividad [actividad_id=" + actividad_id + ", actividad_nombre=" + actividad_nombre + "]";
	}

}