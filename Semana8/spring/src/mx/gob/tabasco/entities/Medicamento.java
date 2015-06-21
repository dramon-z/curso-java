package mx.gob.tabasco.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the medicamentos database table.
 * 
 */
@Entity
@Table(name="medicamentos")
@NamedQuery(name="Medicamento.findAll", query="SELECT m FROM Medicamento m")
public class Medicamento implements Serializable {
	private static final long serialVersionUID = 1L;
	private Integer id;
	private String nombre;
	private String presentacion;
	private List<Receta> recetas;

	public Medicamento() {
	}


	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}


	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public String getPresentacion() {
		return this.presentacion;
	}

	public void setPresentacion(String presentacion) {
		this.presentacion = presentacion;
	}


	//bi-directional many-to-one association to Receta
	@OneToMany(mappedBy="medicamento")
	public List<Receta> getRecetas() {
		return this.recetas;
	}

	public void setRecetas(List<Receta> recetas) {
		this.recetas = recetas;
	}

	public Receta addReceta(Receta receta) {
		getRecetas().add(receta);
		receta.setMedicamento(this);

		return receta;
	}

	public Receta removeReceta(Receta receta) {
		getRecetas().remove(receta);
		receta.setMedicamento(null);

		return receta;
	}

}