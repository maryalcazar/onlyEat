package org.learning.service;

import org.learning.domain.Client;
import org.learning.dto.LoginDTO;
import org.learning.dto.RegisterClientDTO;
import org.learning.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClientService {
	@Autowired
	private ClientRepository clientRepo;
	
	public boolean registerNewClient(RegisterClientDTO dto) {
		Client c = new Client();
		
		c.setEmail(dto.getEmail());
		c.setPassword(dto.getContrasenya());
		
		return clientRepo.save(c) != null;
	}
	
	public boolean findUser(LoginDTO dto) {
		String email = dto.getemail();
		String pass = dto.getPsw();
		Client user = clientRepo.findUser(email, pass);
		boolean userFound = user != null;
		
		return userFound;
	}
}
