package model;

import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

/**
 * 
 * @author Walmir_Pereira_de_Lima
 *
 */
@Entity
public class Pessoa {

	@Id
	private String cpf;
	private String nome;
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "ID_ENDERECO", referencedColumnName = "ID_ENDERECO")
	private Endereco endereco;

	private int idade;
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "NUMERO_CONTA", referencedColumnName = "NUMERO")
	private Conta conta;
	private String sexo;

	public Pessoa() {
		super();

	}

	public Pessoa(String cpf, String nome, Endereco endereco, int idade, Conta conta, String sexo) {
		super();
		this.cpf = cpf;
		this.nome = nome;
		this.endereco = endereco;
		this.idade = idade;
		this.conta = conta;
		this.sexo = sexo;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	public int getIdade() {
		return idade;
	}

	public void setIdade(int idade) {
		this.idade = idade;
	}

	public Conta getConta() {
		return conta;
	}

	public void setConta(Conta conta) {
		this.conta = conta;
	}

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	@Override
	public String toString() {
		return "Pessoa [cpf=" + cpf + ", nome=" + nome + ", endereco=" + endereco + ", idade=" + idade + ", conta="
				+ conta + ", sexo=" + sexo + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(conta, cpf, endereco, idade, nome, sexo);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Pessoa other = (Pessoa) obj;
		return Objects.equals(conta, other.conta) && Objects.equals(cpf, other.cpf)
				&& Objects.equals(endereco, other.endereco) && idade == other.idade && Objects.equals(nome, other.nome)
				&& Objects.equals(sexo, other.sexo);
	}

}
