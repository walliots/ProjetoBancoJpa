package model;

import java.util.Objects;
import javax.persistence.Entity;
import javax.persistence.Id;
/**
 * 
 * @author Walmir Pereira de Lima
 *
 */
@Entity
public class Conta {
	
	@Id
	private Integer numero;
	private Double saldo;
	private Double limite;
	
	
	public Integer getNumero() {
		return numero;
	}
	
	public void setNumero(Integer numero) {
		this.numero = numero;
	}
	
	public Double getSaldo() {
		return saldo;
	}
	
	public void setSaldo(Double saldo) {
		this.saldo = saldo;
	}
	
	public Double getLimite() {
		return limite;
	}
	
	public void setLimite(Double limite) {
		this.limite = limite;
	}

	@Override
	public String toString() {
		return "Conta [numero=" + numero + ", saldo=" + saldo + ", limite=" + limite + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(limite, numero, saldo);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Conta other = (Conta) obj;
		return Objects.equals(limite, other.limite) && Objects.equals(numero, other.numero)
				&& Objects.equals(saldo, other.saldo);
	}
	
	
	

}
