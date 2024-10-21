package com.Admin.model;

public class Car {

	
	int id;
	String name;
	String model;
	OrderDetails order;

	public Car() {
	}

	public Car(String name, String model) {
		super();
		this.name = name;
		this.model = model;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

}
