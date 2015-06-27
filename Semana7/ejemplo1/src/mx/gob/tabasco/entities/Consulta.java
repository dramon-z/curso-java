package mx.gob.tabasco.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the consultas database table.
 * 
 */
@Entity
@Table(name="consultas")
@NamedQuery(name="Consulta.findAll", query="SELECT c FROM Consulta c")
public class Consulta implements Serializable {
	private static final long serialVersionUID = 1L;
	private Integer id;
	private Date fecha;
	private String observaciones;
	private Asegurado asegurado;
	private Medico medico;
	private List<Receta> recetas;

	public Consulta() {
	}


	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}


	@Temporal(TemporalType.DATE)
	public Date getFecha() {
		return this.fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}


	public String getObservaciones() {
		return this.observaciones;
	}

	public void setObservaciones(String observaciones) {
		this.observaciones = observaciones;
	}


	//bi-directional many-to-one association to Asegurado
	@ManyToOne
	@JoinColumn(name="asegurados_id")
	public Asegurado getAsegurado() {
		return this.asegurado;
	}

	public void setAsegurado(Asegurado asegurado) {
		this.asegurado = asegurado;
	}


	//bi-directional many-to-one association to Medico
	@ManyToOne
	@JoinColumn(name="medicos_id")
	public Medico getMedico() {
		return this.medico;
	}

	public void setMedico(Medico medico) {
		this.medico = medico;
	}


	//bi-directional many-to-one association to Receta
	@OneToMany(mappedBy="consulta")
	public List<Receta> getRecetas() {
		return this.recetas;
	}

	public void setRecetas(List<Receta> recetas) {
		this.recetas = recetas;
	}

	public Receta addReceta(Receta receta) {
		getRecetas().add(receta);
		receta.setConsulta(this);

		return receta;
	}

	public Receta removeReceta(Receta receta) {
		getRecetas().remove(receta);
		receta.setConsulta(null);

		return receta;
	}

}