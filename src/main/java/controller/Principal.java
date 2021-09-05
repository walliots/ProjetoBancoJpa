package controller;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import dao.impl.ContaDAOimpl;
import dao.impl.EnderecoDAOimpl;
import dao.impl.PessoaDAOimpl;
import model.Conta;
import model.Endereco;
import model.Pessoa;
import model.util.JpaUtil;

public class Principal {
	public static void main(String[] args) {
		
		EntityManager em = JpaUtil.getEntityManager();
		EntityTransaction et = em.getTransaction();
		et.begin();
		em.close();
		
//		List<Conta> conta = new ArrayList<Conta>();
//		for (Conta c : conta) {
//			System.out.println(c);
//		}	
		
//		Conta conta = new Conta();
//		conta.setNumero(3852859);
//		conta.setLimite(4500d);
//		conta.setSaldo(9006d);
		
//		ContaDAOimpl contaDao = new ContaDAOimpl();
//		contaDao.salvar(conta);
		
//		Endereco endereco = new Endereco();
//		endereco.setRua("RUA DA AURORA");
//		endereco.setNumero(155);
//		endereco.setComplemento("PARQ");
		
//		EnderecoDAOimpl enderecoDao = new EnderecoDAOimpl();
//		enderecoDao.salvar(endereco);
		
//		Pessoa pessoa = new Pessoa();
//		pessoa.setCpf("22233399927");
//		pessoa.setEndereco(endereco);
//		pessoa.setNome("PEDRO ALVARO");
//		pessoa.setConta(conta);
//		pessoa.setSexo("m");
//		pessoa.setIdade(36);
		
//		PessoaDAOimpl pessoaDao = new PessoaDAOimpl();
//		pessoaDao.salvar(pessoa);
		
		ContaDAOimpl contaDao = new ContaDAOimpl();
		contaDao.remover(800);
		
	}

}



