package EC3.JOAQUINROQUE.CITA.model;

import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Table(name = "Recepcionista")
@Entity
public class Cliente {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idRecepcionista;
	private String nombre;
	private Integer celular;
	
	
	@ManyToOne
	@JoinColumn(
			name = "id_especialidad",
			nullable = false,
			unique = true,
			foreignKey = @ForeignKey(foreignKeyDefinition = "foreign key (id_especialidad) references especialidad(id_especialidad)")
			)
	private Cliente cliente;
	
	
	public Integer getIdRecepcionista() {
		return idRecepcionista;
	}
	public void setIdRecepcionista(Integer idRecepcionista) {
		this.idRecepcionista = idRecepcionista;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public Integer getCelular() {
		return celular;
	}
	public void setCelular(Integer celular) {
		this.celular = celular;
	}
	

}
