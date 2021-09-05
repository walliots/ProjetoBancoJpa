package dao;

import java.util.List;

import model.Conta;
import model.Endereco;

/**
 * Interface da classe Endereço
 */

public interface EnderecoDAO {
	public void salvar(Endereco endereco);

	public void alterar(Endereco endereco);

	public void remover(int numero);

	public Endereco pesquisar(int numero);

	public List<Endereco> ListarTodos();

}
