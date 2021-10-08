package br.unicesumar.adsis4s2021.meu.meuCidade;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.unicesumar.adsis4s2021.meu.MeuBase.MeuBaseController;

@RestController
@RequestMapping("/meu-cidades")
public class MeuCidadeController extends MeuBaseController<MeuCidade, MeuCidadeRepository>{

}
