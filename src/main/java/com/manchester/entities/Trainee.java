package com.manchester.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;



@Entity
public class Trainee{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int traineeid;
	private String traineename;
	private String traineecity;
	
	public Trainee() {
	}

	public int getTraineeid() {
		return traineeid;
	}

	public void setTraineeid(int traineeid) {
		this.traineeid = traineeid;
	}

	public String getTraineename() {
		return traineename;
	}

	public void setTraineename(String traineename) {
		this.traineename = traineename;
	}

	public String getTraineecity() {
		return traineecity;
	}

	public void setTraineecity(String traineecity) {
		this.traineecity = traineecity;
	}

	
	
	

}
