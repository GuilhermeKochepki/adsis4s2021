package br.unicesumar.adsis4s2021.meu.meuProduto;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface MeuProdutoRepository extends JpaRepository<MeuProduto, String>{
															//classe	tipo da variável id na classe
	@Query("select p from MeuProduto p where p.preco >= :preco")
	List<MeuProduto> recuperarPrecoMaiorQue(double preco);
	
	@Query(value = "select p.nome, p.id, p.preco from MeuProduto p where p.preco >= :preco", nativeQuery = true)
	List<MeuProduto> recuperarPrecoMaiorQueViaSQL(double preco);
}
