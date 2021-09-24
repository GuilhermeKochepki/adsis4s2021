package br.unicesumar.adsis4s2021.meu.meuPedido;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.unicesumar.adsis4s2021.meu.MeuBase.MeuBaseController;

@RestController
@RequestMapping("/meus-pedidos")
public class MeuPedidoController extends MeuBaseController<MeuPedido, MeuPedidoRepository>{
	@Autowired
	private MeuPedidoRepository repo;
	
	@GetMapping
	public List<MeuPedido> getAll() {
		return repo.findAll();
	}
	
	@PostMapping
	public String post(@RequestBody MeuPedido novo) {
		if (repo.findById(novo.getId()).isPresent()) {
			throw new RuntimeException("Seu pedido já existe, faça um put ao invés de post!");
		}
		novo = repo.save(novo);
		return novo.getId();
	}
	
	@GetMapping("/meu-total-vendido-por-produto")
	public List<Map<String, Object>> getTotalVendidoPorProduto() {
		return repo.consultarTotalVendidoPorProduto();
	}
}
