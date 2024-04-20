package ru.sgu.hell.dh.controller.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;
import ru.sgu.hell.dh.model.Request;
import ru.sgu.hell.dh.service.WindowService;

@RestController
@RequestMapping("/api/")
@Slf4j
public class MessageApi {
	@Autowired
	private WindowService windowService;

	@PostMapping("/encrypt/")
	public Request encrypt(@RequestBody Request request) {
		log.trace("REST encrypt text = {}", request.getMessage());
		log.trace("REST encrypt person = {}", request.getPerson());
		Request answer = new Request();
		if (request.getPerson().equals("Alice")) {
			String encryptText = windowService.getAlice().encrypt(request.getMessage());
			log.trace("REST Service = {}", windowService);
			log.trace("REST Alice = {}", windowService.getAlice());
			log.trace("REST Alice encrypt. Encrypt =  {}", encryptText);
			answer.setPerson("Alice");
			answer.setMessage(encryptText);
		} else {
			answer.setPerson("Alice");
			answer.setMessage(windowService.getBob().encrypt(request.getMessage()));
		}
		return answer;
	}

	@PostMapping("/decrypt/")
	public Request decrypt(@RequestBody Request request) {
		log.trace("REST decrypt text = {}", request.getMessage());
		log.trace("REST decrypt person = {}", request.getPerson());
		Request answer = new Request();
		if (request.getPerson().equals("Alice")) {
			String decryptText = windowService.getAlice().decrypt(request.getMessage());
			log.trace("REST Service = {}", windowService);
			log.trace("REST Alice = {}", windowService.getAlice());
			log.trace("REST Alice decrypt. decrypt =  {}", decryptText);
			answer.setPerson("Alice");
			answer.setMessage(decryptText);
		} else {
			answer.setPerson("Alice");
			answer.setMessage(windowService.getBob().decrypt(request.getMessage()));
		}
		return answer;
	}
}
