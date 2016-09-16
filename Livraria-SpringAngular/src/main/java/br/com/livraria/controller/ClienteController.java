package br.com.livraria.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import br.com.livraria.model.ResultadoModel;

@Controller
@RequestMapping("/cliente")
public class ClienteController {

	@Autowired
	private ResultadoModel resultadoModel;

	@RequestMapping(value = "cadastrar.html", method = RequestMethod.GET)
	public ModelAndView cadastrar() {
		return new ModelAndView("cliente/cadastrarCliente");
	}

}
