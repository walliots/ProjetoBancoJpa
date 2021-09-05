package dao;

import java.util.List;

import model.Pessoa;

/**
 * Interface da Classe Pessoa
 */
public interface PessoaDAO {
	public void salvar(Pessoa pessoa);

	public void alterar(Pessoa pessoa);

	public void remover(String numero);

	public Pessoa pesquisar(String numero);

	public List<Pessoa> ListarTodos();

}
