package org.learning.dto;

public class RegisterClientDTO {
	private String email;
	private String contrasenya;
	
	public RegisterClientDTO(String email, String contrasenya) {
		this.email = email;
		this.contrasenya = contrasenya;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getContrasenya() {
		return contrasenya;
	}

	public void setContrasenya(String contrasenya) {
		this.contrasenya = contrasenya;
	}
}
