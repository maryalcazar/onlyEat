package org.learning.controller;

import org.learning.dto.LoginDTO;
import org.learning.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("login")
public class LoginController {
	@Autowired
	private ClientService clientService;

	@PostMapping("/doLogin")
	public String doLogin(@ModelAttribute LoginDTO login) {
		boolean found = clientService.findUser(login);

		if (found) {
			return "welcome";
		} else {
			return "error";
		}
	}
}
