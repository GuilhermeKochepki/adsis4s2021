package br.unicesumar.adsis4s2021.meu.guilherme;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/guilherme-controller")
public class GuilhermeController {
	
	@GetMapping
	public String get() {
		return "Olha o guilherme-controller está funcionando";
	}
	
}
