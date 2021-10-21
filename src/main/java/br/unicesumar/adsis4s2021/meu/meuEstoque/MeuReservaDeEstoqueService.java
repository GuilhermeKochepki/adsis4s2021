package br.unicesumar.adsis4s2021.meu.meuEstoque;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MeuReservaDeEstoqueService {
	@Autowired
	private MeuReservaDeEstoqueRepository repo;
	
	public String insert(MeuReservaDeEstoque nova) {
		BigDecimal quantidadeTotalJáReservada = repo.recuperarQuantidadeTotalJáReservada(nova.getCliente().getId(), nova.getProduto().getId());
		//if (quantidadeTotalJáReservada > 0) {
		if (quantidadeTotalJáReservada.compareTo( new BigDecimal("0.0") ) > 0) {
			throw new MeuReservaDeEstoqueExcedidaException("Não é possível reservar mais estoque para este produto, reserva prévia encontrada.");
		}
		return repo.save(nova).getId();
	}

}
