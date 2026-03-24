package projetoTeste.controller;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import projetoTeste.model.Greetening;

@RestController
public class GreeteningController {
	
	private static final String template = "Hello, %s!";
	private final AtomicLong counter = new AtomicLong();
	
	
	@RequestMapping("/greetening")
	
	public Greetening greetening(
			@RequestParam(value = "name",defaultValue = "word!")
			String name) {
		
		return new Greetening(counter.incrementAndGet(), String.format(template, name));
	}

}
