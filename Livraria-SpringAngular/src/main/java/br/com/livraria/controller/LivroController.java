package br.com.livraria.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import br.com.livraria.model.ResultadoModel;
import br.com.livraria.model.Livro;
import br.com.livraria.repository.LivroRepository;

/**
 * 
 * @author cicero.ednilson
 *
 *         Essa � a classe que o Spring vai gerenciar (Controller para o
 *         usu�rio)
 *
 * @Controller => informa que a classe � um controller a ser gerenciado pelo
 *             Spring
 *
 * @RequestMapping => caminho para acessar o controller
 */
@Controller
@RequestMapping("/livro")
public class LivroController {

	/**
	 * @Autowired => injetando o objeto resultadoModel no nosso controller
	 */
	@Autowired
	ResultadoModel resultadoModel;

	/**
	 * Injetando o objeto usuarioRepository
	 */
	@Autowired
	LivroRepository livroRepository;

	/**
	 * 
	 * Chama � view(cadastrar.jsp) para cadastrar um novo registro
	 * 
	 * @RequestMapping => value => Defini o caminho para a chamada da view.
	 * @RequestMapping => method => Defini o o m�todo http que o m�todo vai
	 *                 responder.
	 */
	@RequestMapping(value = "/cadastrar.html", method = RequestMethod.GET)
	public ModelAndView cadastrar() {

		return new ModelAndView("livro/cadastrarLivro");
	}

	/**
	 * Chama a view(consultarRegistros.jsp) para mostrar todos os registros
	 * cadastrados
	 * 
	 */
	@RequestMapping(value = "/consultarRegistros.html", method = RequestMethod.GET)
	public ModelAndView consultar() {

		return new ModelAndView("consultarRegistros");
	}

	/**
	 * Chama a view (editarRegistro.jsp) para editar um registro cadastrado
	 * 
	 */
	@RequestMapping(value = "/editarRegistro.html/{codigo}", method = RequestMethod.GET)
	public ModelAndView editarRegistro(@PathVariable int codigo) {

		Livro livro = livroRepository.consultarPorCodigo(codigo);

		return new ModelAndView("editarLivro", "livro", livro);
	}

	/**
	 * 
	 * Salva um novo registro via ajax, esse m�todo vai ser chamado pelo
	 * cadastrarController.js atrav�s do AngularJS
	 * 
	 */
	@RequestMapping(value = "/salvar", method = RequestMethod.POST)
	public @ResponseBody ResultadoModel salvar(@RequestBody Livro livro) {

		try {

			livroRepository.salvar(livro);

			resultadoModel.setCodigo(1);
			resultadoModel.setMensagem("Livro Incluído com sucesso!");

		} catch (Exception e) {

			resultadoModel.setCodigo(2);
			resultadoModel.setMensagem("Erro ao salvar o registro (" + e.getMessage() + ")");
		}

		return resultadoModel;
	}

	/**
	 * Altera um registro cadastrado (editarRegistroController.js)
	 * 
	 *
	 */
	@RequestMapping(value = "/alterar", method = RequestMethod.POST)
	public @ResponseBody ResultadoModel alterar(@RequestBody Livro livro) {

		try {

			livroRepository.alterar(livro);

			resultadoModel.setCodigo(1);
			resultadoModel.setMensagem("Registro alterado com sucesso!");

		} catch (Exception e) {

			resultadoModel.setCodigo(2);
			resultadoModel.setMensagem("Erro ao salvar o registro (" + e.getMessage() + ")");
		}

		return resultadoModel;
	}

	/**
	 * Consulta todos os registros cadastrados(consultarRegistrosController.js)
	 * 
	 */
	@RequestMapping(value = "/consultarTodos", method = RequestMethod.GET)
	public @ResponseBody List<Livro> consultarTodos() {

		return livroRepository.todosLivros();

	}

	/**
	 * Excluir um usu�rio pelo c�digo (consultarRegistrosController.js)
	 * 
	 */
	@RequestMapping(value = "/excluirRegistro/{codigo}", method = RequestMethod.DELETE)
	public @ResponseBody void excluirRegistro(@PathVariable int codigo) {

		livroRepository.excluir(codigo);

	}

}