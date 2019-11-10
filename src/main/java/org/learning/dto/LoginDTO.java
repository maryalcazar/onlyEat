package org.learning.dto;

public class LoginDTO {
	private String email;
	private String psw;
	
	public LoginDTO() {
		super();
	}

	public LoginDTO(String email, String psw) {
		super();
		this.email = email;
		this.psw = psw;
	}
	
	public String getemail() {
		return email;
	}

	public void setemail(String email) {
		this.email = email;
	}

	public String getPsw() {
		return psw;
	}

	public void setPsw(String psw) {
		this.psw = psw;
	}
}
