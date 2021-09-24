package br.unicesumar.adsis4s2021.meu.MeuBase;

import java.util.UUID;

import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
public class MeuBaseEntity{
	@Id
	private String id;
	
	public MeuBaseEntity() {
		this.id = UUID.randomUUID().toString();
	}
	public MeuBaseEntity(String id) {
		this.id = id;
	}
	
	public String getId() {
		return id;
	}
}
