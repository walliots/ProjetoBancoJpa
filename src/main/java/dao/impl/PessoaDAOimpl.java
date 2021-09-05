package dao.impl;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import dao.PessoaDAO;
import model.Conta;
import model.Endereco;
import model.Pessoa;
import model.util.JpaUtil;
/** 
 * Métodos de manipulação de dados pessoais
 */
public class PessoaDAOimpl implements PessoaDAO {
	private EntityManager em;
	private EntityTransaction et;

	/**
	 * Salva uma pessoa
	 * 
	 * @param pessoa
	 */

	@Override
	public void salvar(Pessoa pessoa) {
		try {
			this.em = JpaUtil.getEntityManager();
			et = em.getTransaction();
			et.begin();
			em.persist(pessoa);
			et.commit();

		} catch (Exception e) {
			if (em.isOpen()) {
				et.rollback();
			}
			System.out.println("ERRO TRANSAÇÃO | ERRO AO SALVAR PESSOA");

		} finally {
			if (em.isOpen()) {
				em.close();

			}
		}

	}

	/**
	 * Altera uma pessoa
	 * 
	 * @param pessoa
	 */

	@Override
	public void alterar(Pessoa pessoa) {
		try {
			this.em = JpaUtil.getEntityManager();
			et = em.getTransaction();
			et.begin();
			em.merge(pessoa);
			et.commit();

		} catch (Exception e) {
			if (em.isOpen()) {
				et.rollback();
			}
			System.out.println("ERRO TRANSAÇÃO | ERRO AO ALTERAR PESSOA");

		} finally {
			if (em.isOpen()) {
				em.close();

			}
		}

	}

	/**
	 * Remove uma pessoa
	 * 
	 * @param numero
	 */

	@Override
	public void remover(String numero) {
		try {
			this.em = JpaUtil.getEntityManager();
			et = em.getTransaction();
			et.begin();
			em.remove(em.find(Pessoa.class, numero));
			et.commit();

		} catch (Exception e) {
			if (em.isOpen()) {
				et.rollback();
			}
			System.out.println("ERRO TRANSAÇÃO | ERRO AO REMOVER PESSOA");

		} finally {
			if (em.isOpen()) {
				em.close();

			}
		}

	}

	/**
	 * Pesquisa uma pessoa
	 * 
	 * @param numero
	 */

	@Override
	public Pessoa pesquisar(String numero) {
		Pessoa pessoa = new Pessoa();
		try {
			this.em = JpaUtil.getEntityManager();
			pessoa = em.find(Pessoa.class, numero);

		} catch (Exception e) {
			if (em.isOpen()) {
				et.rollback();
			}
			System.out.println("ERRO TRANSAÇÃO | ERRO AO PESQUISAR PESSOA");

		} finally {
			if (em.isOpen()) {
				em.close();

			}
		}

		return pessoa;
	}

	@Override
	public List<Pessoa> ListarTodos() {
		this.em = JpaUtil.getEntityManager();
		Query query = em.createQuery("from Endereco e");
		List<Pessoa> listapessoa = query.getResultList();
		em.close();
		return listapessoa;
	}

}
