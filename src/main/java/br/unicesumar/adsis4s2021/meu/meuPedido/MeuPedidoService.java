package br.unicesumar.adsis4s2021.meu.meuPedido;

import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.unicesumar.adsis4s2021.meu.meuEstoque.MeuReservaDeEstoque;
import br.unicesumar.adsis4s2021.meu.meuEstoque.MeuReservaDeEstoqueService;
import br.unicesumar.adsis4s2021.meu.meuPedido.dto.MeuPedidoDTO;
import br.unicesumar.adsis4s2021.meu.meuPedido.dto.MeuTotalVendidoDoProdutoDTO;

@Service
@Transactional
public class MeuPedidoService {
	@Autowired
	private MeuPedidoRepository repo;
	
	@Autowired
	private MeuReservaDeEstoqueService reservaDeEstoqueService;
	
	public List<MeuPedidoDTO> getAll() {
		List<MeuPedidoDTO> pedidosDTO  = repo.meuEncontrarTodosComoDTO();
		for (MeuPedidoDTO pedidoDTO : pedidosDTO) {
			pedidoDTO.setItens(repo.encontrarItensPedidoDoPedidoDTO(pedidoDTO.getId()));
		}
		return pedidosDTO;
	}
	
	public String insert(MeuPedido novo) {
		if (repo.findById(novo.getId()).isPresent()) {
			throw new RuntimeException("Seu pedido já existe, faça um put ao invés de post!");
		}
		
		for (MeuItemPedido ip : novo.getItens()) {
			reservaDeEstoqueService.insert(new MeuReservaDeEstoque(novo.getCliente(), new Date(), ip.getProduto(), ip.getQuantidade()));
		}
		if ((10-10) == 0 ) {
			throw new RuntimeException("Opa, deu erro... deveria fazer um rollback!");
		}		
		novo = repo.save(novo);
		return novo.getId();
	}
	
	public List<Map<String, Object>> consultarTotalVendidoPorProduto() {
		return repo.consultarTotalVendidoPorProduto();
	}
	
	public List<MeuTotalVendidoDoProdutoDTO> consultarTotalVendidoPorProdutoDTO() {
		return repo.consultarTotalVendidoPorProdutoDTO();
	}
	
	
}
