package dao.impl;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import dao.ContaDAO;
import model.Conta;
import model.util.JpaUtil;

/**
 * Métodos de manipulação de uma conta bancária
 */

public class ContaDAOimpl implements ContaDAO {

	private EntityManager em;
	private EntityTransaction et;

	/**
	 * Salva a conta
	 * 
	 * @param conta
	 */
	@Override
	public void salvar(Conta conta) {
		try {
			this.em = JpaUtil.getEntityManager();
			et = em.getTransaction();
			et.begin();
			em.persist(conta);
			et.commit();

		} catch (Exception e) {
			if (em.isOpen()) {
				et.rollback();
			}
			System.err.println("ERRO TRANSAÇÃO | ERRO AO SALVAR CONTA");

		} finally {
			if (em.isOpen()) {
				em.close();

			}
		}

	}

	/**
	 * Altera a conta
	 * 
	 * @param conta
	 */
	@Override
	public void alterar(Conta conta) {
		try {
			this.em = JpaUtil.getEntityManager();
			et = em.getTransaction();
			et.begin();
			em.merge(conta);
			et.commit();

		} catch (Exception e) {
			if (em.isOpen()) {
				et.rollback();
			}
			System.err.println("ERRO TRANSAÇÃO | ERRO AO ALTERAR CONTA");

		} finally {
			if (em.isOpen()) {
				em.close();

			}
		}

	}

	/**
	 * Remove a conta
	 * 
	 * @param numero número a ser inserido
	 */
	@Override
	public void remover(int numero) {
		try {
			this.em = JpaUtil.getEntityManager();
			et = em.getTransaction();
			et.begin();
			em.remove(em.find(Conta.class, numero));
			et.commit();

		} catch (Exception e) {
			if (em.isOpen()) {
				et.rollback();
			}
			System.err.println("ERRO TRANSAÇÃO | ERRO AO REMOVER CONTA");

		} finally {
			if (em.isOpen()) {
				em.close();

			}
		}

	}

	/**
	 * Pesquisa a conta
	 * 
	 * @param numero número a ser pesquisado
	 */
	@Override
	public Conta pesquisar(int numero) {
		Conta conta = new Conta();
		try {
			this.em = JpaUtil.getEntityManager();
			conta = em.find(Conta.class, numero);

		} catch (Exception e) {
			if (em.isOpen()) {
				et.rollback();
			}
			System.err.println("ERRO TRANSAÇÃO | ERRO AO PESQUISAR CONTA");

		} finally {
			if (em.isOpen()) {
				em.close();

			}
		}
		return conta;
	}

	@Override
	public List<Conta> ListarTodos() {
		this.em = JpaUtil.getEntityManager();
		Query query = em.createQuery("from Conta e");
		List<Conta> listaConta = query.getResultList();
		em.close();
		return listaConta;

	}

}
