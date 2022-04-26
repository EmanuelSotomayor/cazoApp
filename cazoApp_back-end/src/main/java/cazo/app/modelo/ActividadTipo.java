package cazo.app.modelo;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "ActividadTipo")
public class ActividadTipo extends Actividad implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "actividadTipo_id")
    private Long id;
    @Column(name = "actividadTipo_desc", length = 255, nullable = false)
    private String descripcion;
    @Column(name = "actividadTipo_cupo", nullable = false)
    private Integer cupo;

    public ActividadTipo() {
    }

    public ActividadTipo(Long id, String descripcion, Integer cupo, String nombre, String url) {
        super(id, nombre, url);
        this.cupo = cupo;
        this.descripcion = descripcion;

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Integer getCupo() {
        return cupo;
    }

    public void setCupo(Integer cupo) {
        this.cupo = cupo;
    }

    @Override
    public String toString() {
        return "ActividadTipo{" + "id=" + id + ", descripcion=" + descripcion + ", cupo=" + cupo + '}';
    }

}
