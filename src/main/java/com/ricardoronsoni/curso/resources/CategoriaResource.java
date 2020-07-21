package com.ricardoronsoni.curso.resources;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ricardoronsoni.curso.domain.Categoria;
import com.ricardoronsoni.curso.services.CategoriaService;

@RestController
@RequestMapping(value="/categorias")
public class CategoriaResource {
	
	@Autowired   // para instanciar automatcamente
	private CategoriaService service;

	
	//o ? dentro do ResponseEntity é para dizer que o retorno pode ser de qualquer tipo
	// o @PathVariable é pra informar que o id vem da url 
	@RequestMapping(value="/{id}", method = RequestMethod.GET)
	public ResponseEntity<?> find(@PathVariable Integer id) { 
		
		Categoria obj = service.find(id);

		//o ResponseEntity retorna o valor no padrao rest...o ok é para dizer que tudo esta certo
		return ResponseEntity.ok().body(obj);
		//caso tenha uma excessao, o handler é que ira receptar isso e revolver para o cliente. Nao é bom usar o try/catch na camada de resorce
	}
}
