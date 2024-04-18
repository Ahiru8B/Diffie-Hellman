package ru.sgu.hell.dh.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import ru.sgu.hell.dh.service.WindowService;

@Controller
@RequestMapping("/crypt")
public class MainController {
	@Autowired
	private WindowService windowService;

	@GetMapping
	public String getPage(Model model) {
		model.addAttribute("alice", windowService.getAlice());
		model.addAttribute("bob", windowService.getBob());
		return "crypt";
	}
}
