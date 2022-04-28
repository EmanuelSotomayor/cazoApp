package cazo.app.modelo;



import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Actividad")
public class  Actividad{

	@Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name="actividad_id")
    private Long id;
    @Column(name = "actividad_nombre", length = 50, nullable = false)
    private String nombre;
    @Column(name = "actividad_url", length = 255, nullable = false)
    private String url;
    
    //Constructor vacio
    public Actividad() {}
    //Constructor parametrizado
    public Actividad(Long id, String nombre, String url) {
        this.id = id;
        this.nombre = nombre;
        this.url = url;
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

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public String toString() {
        return "Actividad{" + "id=" + id + ", nombre=" + nombre + ", url=" + url + '}';
    }

}