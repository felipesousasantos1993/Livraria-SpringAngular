package br.com.livraria.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;
import org.springframework.stereotype.Repository;

import br.com.livraria.model.Livro;

/**
 * @author: cicero.ednilson
 * 
 *          CLASSE QUE VAI REALIZAR A PERSIST�NCIA DO NOSSO OBJETO Livro
 *          NO BANCO DE DADOS.
 * 
 * 
 */
@Repository
public class LivroRepository {

	/**
	 * @PersistenceContext � o local onde ficam armazenados as entidades que
	 *                     est�o sendo manipuladas pelo EntityManager
	 * 
	 * 
	 * @PersistenceContext(type = PersistenceContextType.EXTENDED) assim o
	 *                          Wildfly vai gerenciar para nos as entidades.
	 * 
	 **/
	@PersistenceContext(type = PersistenceContextType.EXTENDED)
	private EntityManager manager;

	/**
	 * 
	 * @param Livro
	 * 
	 *            Salva um novo registro
	 * 
	 *            O JPA exige um contexto de transa��o para realizar as
	 *            altera��es, por isso vamos usar a
	 *            anota��o @javax.transaction.Transactional
	 * 
	 */
	@javax.transaction.Transactional
	public void salvar(Livro Livro) {

		manager.persist(Livro);
	}

	/**
	 * 
	 * @param Livro
	 * 
	 *            Realiza a altera��o de um registro
	 */
	@javax.transaction.Transactional
	public void alterar(Livro Livro) {

		manager.merge(Livro);
	}

	/**
	 * 
	 * @param codigo
	 * @return Livro
	 * 
	 *         Consulta um usu�rio por c�digo
	 */
	public Livro consultarPorCodigo(int codigo) {

		return manager.find(Livro.class, codigo);
	}

	/**
	 * 
	 * @param codigo
	 * 
	 *            Exclui um usu�rio pelo c�digo
	 */
	@javax.transaction.Transactional
	public void excluir(int codigo) {

		Livro livro = this.consultarPorCodigo(codigo);

		manager.remove(livro);

	}

	/**
	 * 
	 * @return List<Livro>
	 * 
	 *         Consulta todos os livros cadastrados no banco de dados
	 */
	public List<Livro> todosLivros() {

		return manager.createQuery("SELECT l FROM Livro l ORDER BY c.deTitulo ", Livro.class).getResultList();
	}

}
