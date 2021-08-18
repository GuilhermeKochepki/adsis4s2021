package br.unicesumar.adsis4s2021.meu.meuProduto;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/meu-produto")
public class MeuProdutoController {
	//conectar no banco
	@Autowired
	private MeuProdutoRepository repo;
	
	//retornar
	@GetMapping
	public List<MeuProduto> getProdutos() {
		return repo.findAll();
	}
	
	//incluir
	@PostMapping
	public String postProduto(@RequestBody MeuProduto novo) {
		novo = repo.save(novo);
		return novo.getId();
	}

}