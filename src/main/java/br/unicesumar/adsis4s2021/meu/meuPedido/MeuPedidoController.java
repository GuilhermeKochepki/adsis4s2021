package br.unicesumar.adsis4s2021.meu.meuPedido;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.unicesumar.adsis4s2021.meu.meuPedido.dto.MeuPedidoDTO;
import br.unicesumar.adsis4s2021.meu.meuPedido.dto.MeuTotalVendidoDoProdutoDTO;

@RestController
@RequestMapping("/meu-pedidos")
public class MeuPedidoController{
	@Autowired
	private MeuPedidoService service;
	
	@GetMapping
	public List<MeuPedidoDTO> getAll() {
		return service.getAll();
	}
	
	@PostMapping
	public String post(@RequestBody MeuPedido novo) {
		return service.insert(novo);
	}
	
	@GetMapping("/meu-total-vendido-por-produto")
	public List<Map<String, Object>> getTotalVendidoPorProduto() {
		return service.consultarTotalVendidoPorProduto();
	}
	
	@GetMapping("/meu-total-vendido-por-produto-DTO")
	public List<MeuTotalVendidoDoProdutoDTO> getTotalVendidoPorProdutoDTO() {
		return service.consultarTotalVendidoPorProdutoDTO();
	}
}
