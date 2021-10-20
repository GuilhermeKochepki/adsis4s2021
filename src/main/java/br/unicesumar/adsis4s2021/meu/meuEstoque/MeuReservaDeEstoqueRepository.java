package br.unicesumar.adsis4s2021.meu.meuEstoque;

import java.math.BigDecimal;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface MeuReservaDeEstoqueRepository extends JpaRepository<MeuReservaDeEstoque, String>{

	@Query(value = "select coalesce(sum(r.quantidade),0.0) as quantidade "
			+ "		  from meu_reserva_de_estoque r"
			+ "      where r.cliente_id = :clienteId"
			+ "        and r.produto_id = :produtoId",
			nativeQuery = true)
	BigDecimal recuperarQuantidadeTotalJáReservada(String clienteId, String produtoId);
	
}
