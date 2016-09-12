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
 *         Essa ï¿½ a classe que o Spring vai gerenciar (Controller para o
 *         usuï¿½rio)
 *
 * @Controller => informa que a classe ï¿½ um controller a ser gerenciado pelo
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
	 * Chama ï¿½ view(cadastrar.jsp) para cadastrar um novo registro
	 * 
	 * @RequestMapping => value => Defini o caminho para a chamada da view.
	 * @RequestMapping => method => Defini o o mï¿½todo http que o mï¿½todo vai
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
	@RequestMapping(value = "/consultar.html", method = RequestMethod.GET)
	public ModelAndView consultar() {

		return new ModelAndView("livro/consultarLivro");
	}

	/**
	 * Chama a view (editarRegistro.jsp) para editar um registro cadastrado
	 * 
	 */
	@RequestMapping(value = "/editar.html/{codigo}", method = RequestMethod.GET)
	public ModelAndView editarRegistro(@PathVariable int codigo) {

		return new ModelAndView("livro/editarLivro", "livro", livroRepository.consultarPorCodigo(codigo));
	}

	/**
	 * 
	 * Salva um novo registro via ajax, esse mï¿½todo vai ser chamado pelo
	 * cadastrarController.js atravÃ©s do AngularJS
	 * 
	 */
	@ResponseBody
	@RequestMapping(value = "/salvar", method = RequestMethod.POST)
	public ResultadoModel salvar(@RequestBody Livro livro) {
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
	@ResponseBody
	@RequestMapping(value = "/alterar", method = RequestMethod.POST)
	public ResultadoModel alterar(@RequestBody Livro livro) {

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
	@ResponseBody
	@RequestMapping(value = "/consultarTodos", method = RequestMethod.GET)
	public List<Livro> consultarTodos() {

		return livroRepository.todosLivros();

	}

	/**
	 * Excluir um usuï¿½rio pelo cï¿½digo (consultarRegistrosController.js)
	 * 
	 */
	@ResponseBody
	@RequestMapping(value = "/excluirRegistro/{codigo}", method = RequestMethod.DELETE)
	public void excluirRegistro(@PathVariable int codigo) {

		livroRepository.excluir(codigo);

	}

}
