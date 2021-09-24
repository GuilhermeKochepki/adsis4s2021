package br.unicesumar.adsis4s2021.meu.meuPedido;

import java.util.List;
import java.util.Map;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.unicesumar.adsis4s2021.meu.meuPedido.meuDto.MeuTotalVendidoDoProdutoDTO;

public interface MeuPedidoRepository extends JpaRepository<MeuPedido, String>{
	
//	@Query(value = "select p.nome as produto, "
//			+ "sum(ip.quantidade = ip.preco_unitario) as \"totalVendido\" "
//			+ "from item_pedido ip "
//			+ "inner join produto p on p.id = ip.produto_id "
//			+ "group by p.nome ", nativeQuery = true)
//	List<Map<String, Object>> consultarTotalVendidoPorProduto();
	
	@Query(value = "select p.nome as produto, "
			+ "sum(ip.quantidade * ip.precoUnitario) as totalVendido "
			+ "from MeuItemPedido ip "
			+ "inner join ip.produto p "
			+ "group by p.nome")
	List<Map<String, Object>> consultarTotalVendidoPorProduto();
	
	@Query(value = "select new br.unicesumar.adsis4s2021.meu.meuPedido.meuDto.MeuTotalVendidoDoProdutoDTO(p.nome, "
			+ "sum(ip.quantidade * ip.precoUnitario)) "
			+ "from MeuItemPedido ip "
			+ "inner join ip.produto p "
			+ "group by p.nome")
	List<MeuTotalVendidoDoProdutoDTO> consultarTotalVendidoPorProdutoDTO();
	
}
