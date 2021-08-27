package br.unicesumar.adsis4s2021.meu.meuProduto_transiente;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/produtos_transientes")
public class Produto_TransienteController {
	private List<Produto_Transiente> produtos = new ArrayList<>();
	
	public Produto_TransienteController() {
		produtos.add(new Produto_Transiente("1", "Amendoim DORI", 9.56));
		produtos.add(new Produto_Transiente("2", "Abóbora Goicotchea", 12.99));
		produtos.add(new Produto_Transiente("3", "Margarina Coamo", 15.50));
	}
	
	@PostMapping
	public void postProduto(@RequestBody Produto_Transiente novoProduto) {
		produtos.add(novoProduto);
	}
	@GetMapping
	public List<Produto_Transiente> getProduto(){
		return this.produtos;
	}
	@GetMapping("/{id}")
	public Produto_Transiente getProdutoPeloId(@PathVariable("id") String id) {
		for(Produto_Transiente p: produtos) {
			if(p.getId().equals(id)) {
				return p;
			}
		}
		return null;
	}
	@DeleteMapping("/{id}")
	public void deleteProdutoPeloId(@PathVariable("id") String id) {
		Produto_Transiente paraRemover = null;
		for(Produto_Transiente p : produtos) {
			if(p.getId().equals(id)) {
				paraRemover = p;
			}
		}
		if(paraRemover != null) {
			produtos.remove(paraRemover);
		}
	}
}
