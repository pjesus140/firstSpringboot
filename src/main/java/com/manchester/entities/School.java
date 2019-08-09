package com.manchester.entities;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class School {

	
	@Id
	int regno;
	String name;
	public int getRegno() {
		return regno;
	}
	public void setRegno(int regno) {
		this.regno = regno;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
}
