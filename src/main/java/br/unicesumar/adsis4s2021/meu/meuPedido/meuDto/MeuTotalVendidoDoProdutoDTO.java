package br.unicesumar.adsis4s2021.meu.meuPedido.meuDto;

import java.math.BigDecimal;

public class MeuTotalVendidoDoProdutoDTO {
	public final String produto;
	public final BigDecimal totalVendido;
	
	public MeuTotalVendidoDoProdutoDTO(String produto, BigDecimal totalVendido) {
		super();
		this.produto = produto;
		this.totalVendido = totalVendido;
	}
	
}
