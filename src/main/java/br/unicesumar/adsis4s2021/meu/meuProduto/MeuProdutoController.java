package br.unicesumar.adsis4s2021.meu.meuProduto;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
	
	@DeleteMapping("/{id}")
	public void deletePeloId(@PathVariable ("id") String id) {
		repo.deleteById(id);
	}
	
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
	
	@GetMapping("/{id}")
	public MeuProduto getProdutoPeloId(@PathVariable ("id") String id) {
		return repo.findById(id).get();
	}

}