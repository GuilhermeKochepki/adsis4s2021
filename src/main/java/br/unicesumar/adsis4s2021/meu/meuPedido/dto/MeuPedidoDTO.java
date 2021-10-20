package br.unicesumar.adsis4s2021.meu.meuPedido.dto;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class MeuPedidoDTO {
	private String id;
	private Long numero;
	private Date emitidoEm;
	private String clienteId;
	private String clienteNome;
	private List<MeuItemPedidoDTO> itens = new ArrayList<>();

	public MeuPedidoDTO(String id, Long numero, Date emitidoEm, String clienteId, String clienteNome,
			List<MeuItemPedidoDTO> itens) {
		this(id, numero, emitidoEm, clienteId, clienteNome);
		this.itens = itens;
	}
	
	public MeuPedidoDTO(String id, Long numero, Date emitidoEm, String clienteId, String clienteNome) {
		this.id = id;
		this.numero = numero;
		this.emitidoEm = emitidoEm;
		this.clienteId = clienteId;
		this.clienteNome = clienteNome;
	}

	public String getId() {
		return id;
	}

	public Long getNumero() {
		return numero;
	}

	public Date getEmitidoEm() {
		return emitidoEm;
	}

	public String getClienteId() {
		return clienteId;
	}

	public String getClienteNome() {
		return clienteNome;
	}

	public List<MeuItemPedidoDTO> getItens() {
		return itens;
	}
	
	public void setItens(List<MeuItemPedidoDTO> itens) {
		this.itens = itens;
	}
}
