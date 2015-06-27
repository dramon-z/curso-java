package mx.gob.tabasco.seguro.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the asegurados database table.
 * 
 */
@Entity
@Table(name="asegurados")
@NamedQuery(name="Asegurado.findAll", query="SELECT a FROM Asegurado a")
public class Asegurado implements Serializable {
	private static final long serialVersionUID = 1L;
	private Integer id;
	private String apellido;
	private Integer edad;
	private String nombre;
	private String numeroSeguroSocial;
	private String sexo;
	private List<Consulta> consultas;

	public Asegurado() {
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


	public Integer getEdad() {
		return this.edad;
	}

	public void setEdad(Integer edad) {
		this.edad = edad;
	}


	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	@Column(name="numero_seguro_social")
	public String getNumeroSeguroSocial() {
		return this.numeroSeguroSocial;
	}

	public void setNumeroSeguroSocial(String numeroSeguroSocial) {
		this.numeroSeguroSocial = numeroSeguroSocial;
	}


	public String getSexo() {
		return this.sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}


	//bi-directional many-to-one association to Consulta
	@OneToMany(mappedBy="asegurado")
	public List<Consulta> getConsultas() {
		return this.consultas;
	}

	public void setConsultas(List<Consulta> consultas) {
		this.consultas = consultas;
	}

	public Consulta addConsulta(Consulta consulta) {
		getConsultas().add(consulta);
		consulta.setAsegurado(this);

		return consulta;
	}

	public Consulta removeConsulta(Consulta consulta) {
		getConsultas().remove(consulta);
		consulta.setAsegurado(null);

		return consulta;
	}

}