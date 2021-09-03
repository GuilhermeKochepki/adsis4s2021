package br.unicesumar.adsis4s2021.meu.meuPessoa;

import br.unicesumar.adsis4s2021.meu.meuBase.MeuBaseEntity;

public class MeuPessoa extends MeuBaseEntity{
	private String nome;
	
	public MeuPessoa() {
	}
	
	public MeuPessoa(String id, String nome) {
		super(id);
		this.nome = nome;
	}

	public String getNome() {
		return nome; 
	} 
}
