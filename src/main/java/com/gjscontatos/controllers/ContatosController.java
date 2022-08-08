package com.gjscontatos.controllers;

import java.util.ArrayList;
import java.util.UUID;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.gjscontatos.model.Contato;

@Controller
public class ContatosController {
	
	private static final ArrayList<Contato> LISTA_CONTATOS = new ArrayList<>();
	
	static {
		LISTA_CONTATOS.add(new Contato("1", "Maria", "55 11 5011 2233"));
		LISTA_CONTATOS.add(new Contato("2", "Joao", "55 11 5011 2244"));
		LISTA_CONTATOS.add(new Contato("3", "Junior", "55 11 5011 2255"));
		LISTA_CONTATOS.add(new Contato("4", "Vitor", "55 11 5011 2266"));
		LISTA_CONTATOS.add(new Contato("5", "Gabriel", "55 11 5011 2233"));
	}
	
	
	@GetMapping("/")
	public String index() {
		return "index";
	}
	
	@GetMapping("/contatos")
	public ModelAndView listar() {
		ModelAndView modelAndView = new ModelAndView("listar");
		
		modelAndView.addObject("contatos", LISTA_CONTATOS);
		
		return modelAndView;
	}
	
	@GetMapping("/contatos/novo")
	public ModelAndView novo() {
		ModelAndView modelAndView = new ModelAndView("formulario");
		
		modelAndView.addObject("contato", new Contato());
		
		return modelAndView;
	}
	
	@PostMapping("/contatos")
	public String cadastrar(Contato contato) {
		
		String id = UUID.randomUUID().toString();
		contato.setId(id);
		LISTA_CONTATOS.add(contato);
		
		return "redirect:/contatos";
	}

}
