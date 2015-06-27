package mx.gob.tabasco.seguro.entities;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the recetas database table.
 * 
 */
@Entity
@Table(name="recetas")
@NamedQuery(name="Receta.findAll", query="SELECT r FROM Receta r")
public class Receta implements Serializable {
	private static final long serialVersionUID = 1L;
	private Integer id;
	private String dosis;
	private Consulta consulta;
	private Medicamento medicamento;

	public Receta() {
	}


	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}


	public String getDosis() {
		return this.dosis;
	}

	public void setDosis(String dosis) {
		this.dosis = dosis;
	}


	//bi-directional many-to-one association to Consulta
	@ManyToOne
	@JoinColumn(name="consultas_id")
	public Consulta getConsulta() {
		return this.consulta;
	}

	public void setConsulta(Consulta consulta) {
		this.consulta = consulta;
	}


	//bi-directional many-to-one association to Medicamento
	@ManyToOne
	@JoinColumn(name="medicamentos_id")
	public Medicamento getMedicamento() {
		return this.medicamento;
	}

	public void setMedicamento(Medicamento medicamento) {
		this.medicamento = medicamento;
	}

}