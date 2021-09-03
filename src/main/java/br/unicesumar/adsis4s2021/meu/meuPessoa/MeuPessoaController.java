package br.unicesumar.adsis4s2021.meu.meuPessoa;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.unicesumar.adsis4s2021.base.BaseController;

@RestController
@RequestMapping("/minhas-pessoas")
public class MeuPessoaController extends BaseController<MeuPessoa, MeuPessoaRepository>{

}
