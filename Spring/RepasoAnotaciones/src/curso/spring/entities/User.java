package curso.spring.entities;

import curso.spring.annotation.FieldCase;
import curso.spring.annotation.Input;

public class User {

	@Input(min = 5, max = 20)
	@FieldCase(caseType = StringType.LOWERCASE)
	public String userName;
	
	@FieldCase(caseType = StringType.UPPERCASE)
	public String password;
	
	private int edad;

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}

}
