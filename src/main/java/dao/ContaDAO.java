package dao;

import java.util.List;
import model.Conta;

/**
 * Interface da classe Conta
 */
public interface ContaDAO {
	public void salvar(Conta conta);

	public void alterar(Conta conta);

	public void remover(int numero);

	public Conta pesquisar(int numero);

	public List<Conta> ListarTodos();

}
