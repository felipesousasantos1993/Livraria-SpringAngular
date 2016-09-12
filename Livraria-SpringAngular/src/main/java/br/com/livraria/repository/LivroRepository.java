package br.com.livraria.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import br.com.livraria.model.Livro;

/**
 * @author: cicero.ednilson
 * 
 *          CLASSE QUE VAI REALIZAR A PERSIST�NCIA DO NOSSO OBJETO Livro NO
 *          BANCO DE DADOS.
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

	public List<Livro> pesquisarFiltro(String filtro) {
		StringBuilder sql = new StringBuilder();
		sql.append(" SELECT l from Livro l ");
		if (null != filtro && !"".equals(filtro)) {
			sql.append(" WHERE trim(upper(l.deTitulo)) LIKE  :filtro ");
			sql.append(" AND trim(upper(l.deAutor)) LIKE  :filtro ");
			sql.append(" AND trim(upper(cast(l.aaPublicacao as string))) LIKE  :filtro ");
			sql.append(" AND trim(upper(l.deEdicao)) LIKE  :filtro ");
			sql.append(" AND trim(upper(l.deEditora)) LIKE  :filtro ");
		}
		Query query = manager.createQuery(sql.toString());
		if (null != filtro && !"".equals(filtro)) {
			query.setParameter("filtro", "%" + filtro.toUpperCase() + "%");
		}
		return query.getResultList();
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

		return manager.createQuery("SELECT l FROM Livro l ORDER BY l.deTitulo ", Livro.class).getResultList();
	}

}
