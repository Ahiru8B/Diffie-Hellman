package ru.sgu.hell.dh.controller.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;
import ru.sgu.hell.dh.service.WindowService;

@RestController
@RequestMapping("/api/")
@Slf4j
public class MessageApi {
	@Autowired
	private WindowService windowService;

	@GetMapping("/encrypt/{person}/{text}")
	public String encrypt(@ModelAttribute(name = "text") String text, @ModelAttribute(name = "person") String person) {
		log.trace("REST encrypt text = {}", text);
		log.trace("REST encrypt person = {}", person);
		if (person.equals("Alice")) {
			return windowService.getAlice().encrypt(text);
		} else {
			return windowService.getBob().encrypt(text);
		}
	}
}
