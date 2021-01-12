package model;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Utilizator {
	
	private StringProperty nume;
	private StringProperty username;
	private StringProperty pass;
	
	public Utilizator(){
		this.nume = new SimpleStringProperty();
		this.username = new SimpleStringProperty();
		this.pass = new SimpleStringProperty();
	}
	
	//name
	public String getName() {
		return nume.get();
	}

	public void setName(String nume) {
		this.nume.set(nume);
	}

	public StringProperty nameProperty(){
		return nume;
	}
	
	//user name
	public String getUsername() {
		return username.get();
	}

	public void setUsername(String username) {
		this.username.set(username);
	}

	public StringProperty usernameProperty(){
		return username;
	}
	
	//pass
	public String getPass() {
		return pass.get();
	}

	public void setPass(String pass) {
		this.pass.set(pass);
	}

	public StringProperty passProperty(){
		return pass;
	}

	@Override
	public String toString() {
		return "Utilizator [nume=" + nume + ", username=" + username + ", pass=" + pass + "]";
	}
}
