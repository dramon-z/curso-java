package mx.gob.tabasco.seguro.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the medicos database table.
 * 
 */
@Entity
@Table(name="medicos")
@NamedQuery(name="Medico.findAll", query="SELECT m FROM Medico m")
public class Medico implements Serializable {
	private static final long serialVersionUID = 1L;
	private Integer id;
	private String apellido;
	private String cedula;
	private String espcialidad;
	private String nombre;
	private List<Consulta> consultas;

	public Medico() {
	}


	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}


	public String getApellido() {
		return this.apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}


	public String getCedula() {
		return this.cedula;
	}

	public void setCedula(String cedula) {
		this.cedula = cedula;
	}


	public String getEspcialidad() {
		return this.espcialidad;
	}

	public void setEspcialidad(String espcialidad) {
		this.espcialidad = espcialidad;
	}


	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	//bi-directional many-to-one association to Consulta
	@OneToMany(mappedBy="medico")
	public List<Consulta> getConsultas() {
		return this.consultas;
	}

	public void setConsultas(List<Consulta> consultas) {
		this.consultas = consultas;
	}

	public Consulta addConsulta(Consulta consulta) {
		getConsultas().add(consulta);
		consulta.setMedico(this);

		return consulta;
	}

	public Consulta removeConsulta(Consulta consulta) {
		getConsultas().remove(consulta);
		consulta.setMedico(null);

		return consulta;
	}

}