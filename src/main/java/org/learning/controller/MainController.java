package org.learning.controller;

import org.learning.dto.LoginDTO;
import org.learning.dto.RegisterClientDTO;
import org.learning.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MainController {
	@Autowired
	private ClientService clientService;
	
	@RequestMapping(value = "/helloWorld", method = RequestMethod.GET)
	public ResponseEntity<String> helloWorld(@RequestParam String name){
		return new ResponseEntity<String>(String.format("Hi %s!", name), HttpStatus.OK);
	}
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String start(Model model) {
		//model.addAttribute("mensaje", "Hola!");
		model.addAttribute("login", new LoginDTO());
		return "login";
	}
	
	//HTTP GET abreviado
	@RequestMapping("/hello/{name}")
	public ResponseEntity<String> hello(@PathVariable String name){
		return new ResponseEntity<String>(String.format("Hi %s!", name), HttpStatus.OK);
	}
	
	@GetMapping("/helloView")
	public String hello(Model model){
		model.addAttribute("mensaje", "Hola!");
		return "welcome";
	}
	
	@Deprecated //Borrar, solo para aprendizaje inicial
	@RequestMapping("/register")
	public ResponseEntity<String> register(@RequestParam String email, @RequestParam String password){
		RegisterClientDTO dto = new RegisterClientDTO(email, password);
		
		boolean registerNewClient = clientService.registerNewClient(dto);
		
		ResponseEntity<String> responseEntity;
		if (registerNewClient) {
			responseEntity = new ResponseEntity<String>(String.format("Hi %s! You are with us now!", email), HttpStatus.OK);
		} else {
			responseEntity = new ResponseEntity<String>("Error while registering new user!", HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		return responseEntity;
	}
}
