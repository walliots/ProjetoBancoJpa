package dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import dao.EnderecoDAO;
import model.Conta;
import model.Endereco;
import model.util.JpaUtil;

/**
 * Métodos de manipulação de um endereço pessoal
 */
public class EnderecoDAOimpl implements EnderecoDAO {

	private EntityManager em;
	private EntityTransaction et;

	/**
	 * Salva o endereço
	 * 
	 * @param endereco
	 */
	@Override
	public void salvar(Endereco endereco) {
		try {
			this.em = JpaUtil.getEntityManager();
			et = em.getTransaction();
			et.begin();
			em.persist(endereco);
			et.commit();

		} catch (Exception e) {
			if (em.isOpen()) {
				et.rollback();
			}
			System.out.println("ERRO TRANSAÇÃO | ERRO AO SALVAR ENDERECO");

		} finally {
			if (em.isOpen()) {
				em.close();

			}
		}

	}

	/**
	 * Altera o endereço
	 * 
	 * @param endereco
	 */
	@Override
	public void alterar(Endereco endereco) {
		try {
			this.em = JpaUtil.getEntityManager();
			et = em.getTransaction();
			et.begin();
			em.merge(endereco);
			et.commit();

		} catch (Exception e) {
			if (em.isOpen()) {
				et.rollback();
			}
			System.err.println("ERRO TRANSAÇÃO | ERRO AO ALTERAR ENDERECO");

		} finally {
			if (em.isOpen()) {
				em.close();

			}
		}

	}

	/**
	 * Remove o endereço
	 * 
	 * @param numero número a ser removido
	 */
	@Override
	public void remover(int numero) {
		try {
			this.em = JpaUtil.getEntityManager();
			et = em.getTransaction();
			et.begin();
			em.remove(em.find(Endereco.class, numero));
			et.commit();

		} catch (Exception e) {
			if (em.isOpen()) {
				et.rollback();
			}
			System.err.println("ERRO TRANSAÇÃO | ERRO AO REMOVER ENDEREÇO");

		} finally {
			if (em.isOpen()) {
				em.close();

			}
		}
	}

	/**
	 * Pesquisa o endereço
	 * 
	 * @param numero número a ser pesquisado
	 */
	@Override
	public Endereco pesquisar(int numero) {
		Endereco endereco = new Endereco();
		try {
			this.em = JpaUtil.getEntityManager();
			endereco = em.find(Endereco.class, numero);

		} catch (Exception e) {
			if (em.isOpen()) {
				et.rollback();
			}
			System.err.println("ERRO TRANSAÇÃO | ERRO AO PESQUISAR ENDEREÇO");

		} finally {
			if (em.isOpen()) {
				em.close();

			}
		}
		return endereco;
	}

	@Override
	public List<Endereco> ListarTodos() {
		this.em = JpaUtil.getEntityManager();
		Query query = em.createQuery("from Endereco e");
		List<Endereco> listaendereco = query.getResultList();
		em.close();
		return listaendereco;
	}

}
