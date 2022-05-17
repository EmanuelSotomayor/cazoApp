package cazo.app.modelo;

import java.util.Date;

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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "reserva")
public class Reserva {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "reserva_id")
	private Long reserva_id;

	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@Column(name = "reserva_fecha")
	private Date reserva_fecha;

	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "actividad_id")
	private Actividad actividad_id;

	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "actividad_tipo_id")
	private ActividadTipo actividad_tipo_id;

	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "usuario_id")
	private Usuario usuario_id;

	// Constructor vacio
	public Reserva() {}

	// Constructor parametrizado
	public Reserva(Long reserva_id, Date reserva_fecha, Actividad actividad_id, ActividadTipo actividad_tipo_id,
			Usuario usuario_id) {
		super();
		this.reserva_id = reserva_id;
		this.reserva_fecha = reserva_fecha;
		this.actividad_id = actividad_id;
		this.actividad_tipo_id = actividad_tipo_id;
		this.usuario_id = usuario_id;
	}

	// Getters y setters
	public Long getReserva_id() {
		return reserva_id;
	}

	public void setReserva_id(Long reserva_id) {
		this.reserva_id = reserva_id;
	}

	public Date getReserva_fecha() {
		return reserva_fecha;
	}

	public void setReserva_fecha(Date reserva_fecha) {
		this.reserva_fecha = reserva_fecha;
	}

	public Actividad getActividad_id() {
		return actividad_id;
	}

	public void setActividad_id(Actividad actividad_id) {
		this.actividad_id = actividad_id;
	}

	public ActividadTipo getActividad_tipo_id() {
		return actividad_tipo_id;
	}

	public void setActividad_tipo_id(ActividadTipo actividad_tipo_id) {
		this.actividad_tipo_id = actividad_tipo_id;
	}

	public Usuario getUsuario_id() {
		return usuario_id;
	}

	public void setUsuario_id(Usuario usuario_id) {
		this.usuario_id = usuario_id;
	}

	@Override
	public String toString() {
		return "Reserva [reserva_id=" + reserva_id + ", reserva_fecha=" + reserva_fecha + ", actividad_id="
				+ actividad_id + ", actividad_tipo_id=" + actividad_tipo_id + ", usuario_id=" + usuario_id + "]";
	}
}