package br.unicesumar.adsis4s2021.meu.meuPedido;

import java.util.List;
import java.util.Map;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.unicesumar.adsis4s2021.meu.meuPedido.dto.MeuItemPedidoDTO;
import br.unicesumar.adsis4s2021.meu.meuPedido.dto.MeuPedidoDTO;
import br.unicesumar.adsis4s2021.meu.meuPedido.dto.MeuTotalVendidoDoProdutoDTO;

public interface MeuPedidoRepository extends JpaRepository<MeuPedido, String>{
	
	@Query(value = "select p.nome as MeuProduto, "
			+ "sum(ip.quantidade * ip.precoUnitario) as totalVendido "
			+ "from MeuItemPedido ip "
			+ "inner join ip.MeuProduto p "
			+ "group by p.nome")
	List<Map<String, Object>> consultarTotalVendidoPorProduto();
	
	@Query(value = "select new br.unicesumar.adsis4s2021.meu.meuPedido.meuDto.MeuTotalVendidoDoProdutoDTO(p.nome, "
			+ "sum(ip.quantidade * ip.precoUnitario)) "
			+ "from MeuItemPedido ip "
			+ "inner join ip.MeuProduto p "
			+ "group by p.nome")
	List<MeuTotalVendidoDoProdutoDTO> consultarTotalVendidoPorProdutoDTO();
	
	@Query(value = "select new br.unicesumar.adsis4s2021.meu.meuPedido.meuDto.MeuPedidoDTO"
			+ "(p.id, p.numero, p.emitidoEm, c.id, c.nome) "
			+ "from MeuPedido "
			+ "inner join p.cliente c")
	List<MeuPedidoDTO> meuEncontrarTodosComoDTO();
	
	@Query(value = "select new br.unicesumar.adsis4s2021.meu.meuPedido.meuDto.MeuItemPedidoDTO(ip.id, ip.quantidade, ip.percentualDeDesconto, ip.precoUnitario, prod.id, prod.nome) "
			+ "from MeuPedido p "
			+ "inner join p.itens ip "
			+ "inner join ip.MeuProduto prod "
			+ "where p.id = :pedidoId")
	List<MeuItemPedidoDTO> encontrarItensPedidoDoPedidoDTO(String pedidoId);
}
