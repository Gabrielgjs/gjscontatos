package com.gjscontatos.controllers;

import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

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
	
}
