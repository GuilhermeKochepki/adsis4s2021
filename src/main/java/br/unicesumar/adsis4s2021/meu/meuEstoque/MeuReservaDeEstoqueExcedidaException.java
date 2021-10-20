package br.unicesumar.adsis4s2021.meu.meuEstoque;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class MeuReservaDeEstoqueExcedidaException extends RuntimeException{

	public MeuReservaDeEstoqueExcedidaException(String message) {
		super(message);
	}
	
}
