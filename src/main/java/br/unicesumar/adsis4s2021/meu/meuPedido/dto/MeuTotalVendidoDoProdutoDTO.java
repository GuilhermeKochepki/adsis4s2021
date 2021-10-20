package br.unicesumar.adsis4s2021.meu.meuPedido.dto;

import java.math.BigDecimal;

public class MeuTotalVendidoDoProdutoDTO {
	public String produto;
	public BigDecimal totalVendido;
	
	public MeuTotalVendidoDoProdutoDTO(String produto, BigDecimal totalVendido) {
		this.produto = produto;
		this.totalVendido = totalVendido;
	}
}
