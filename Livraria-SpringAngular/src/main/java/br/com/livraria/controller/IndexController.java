package br.com.livraria.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.livraria.repository.LivroRepository;

@Controller
@RequestMapping("*")
public class IndexController {

	@Autowired
	LivroRepository livroRepository;

	@RequestMapping("*")
	public String index() {

		return "index";
	}

}
