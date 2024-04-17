package ru.sgu.hell.dh.controller.api;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;
import ru.sgu.hell.dh.model.Message;

@RestController
@RequestMapping("/api/")
@Slf4j
public class MessageApi {
	@PostMapping
	public void addMessages(Message message) {
		log.info("addMessage! message = {}", message);
	}
}
