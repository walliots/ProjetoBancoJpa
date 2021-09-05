package model;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
/**
 * 
 * @author Walmir_pereira_de_Lima
 *
 */
@Entity
@Table(name = "ENDERECO")
public class Endereco {
	
	@Id
	@Column(name =  "ID_ENDERECO")
	@GeneratedValue(strategy =  GenerationType.SEQUENCE, generator="ENDERECO")
	@SequenceGenerator(name ="ENDERECO", sequenceName = "S_ID_ENDERECO", allocationSize = 1, initialValue = 100)
	private Integer id;
	private String rua;
	private Integer numero;
	private String complemento;
	

	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getRua() {
		return rua;
	}
	public void setRua(String rua) {
		this.rua = rua;
	}
	public Integer getNumero() {
		return numero;
	}
	public void setNumero(Integer numero) {
		this.numero = numero;
	}
	public String getComplemento() {
		return complemento;
	}
	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}
	@Override
	public String toString() {
		return "Endereco [id=" + id + ", rua=" + rua + ", numero=" + numero + ", complemento=" + complemento + "]";
	}
	@Override
	public int hashCode() {
		return Objects.hash(complemento, id, numero, rua);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Endereco other = (Endereco) obj;
		return Objects.equals(complemento, other.complemento) && Objects.equals(id, other.id)
				&& Objects.equals(numero, other.numero) && Objects.equals(rua, other.rua);
	}
	
	

}
