package model;

import javafx.beans.property.SimpleStringProperty;


public class Address {
	/* --- --- --- private field --- --- --- */
	private final SimpleStringProperty name = new SimpleStringProperty("");

	private final SimpleStringProperty email = new SimpleStringProperty("");

	/* --- --- --- public constructor --- --- --- */
	public Address() {
		this("", "");
	}

	public Address(String name, String email) {
		this.setName(name);
		this.setEmail(email);
	}

	/* --- --- --- public method --- --- --- */
	public String getName() {
		return this.name.get();
	}

	public void setName(String name) {
		this.name.set(name);
	}

	public String getEmail() {
		return this.email.get();
	}

	public void setEmail(String email) {
		this.email.set(email);
	}
}
