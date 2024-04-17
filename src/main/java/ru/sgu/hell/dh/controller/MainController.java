package ru.sgu.hell.dh.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import ru.sgu.hell.dh.model.Message;
import ru.sgu.hell.dh.model.Window;

@Controller
@RequestMapping("/crypt")
public class MainController {

	@GetMapping
	public String getPage(Model model) {
		Window window = new Window();
		model.addAttribute("window", window);
		model.addAttribute("message", new Message());
		return "crypt";
	}
}
