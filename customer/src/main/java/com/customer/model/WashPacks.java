package com.customer.model;

public class WashPacks {
	
	String pack_id;
    String name;
    int cost;
    String description;


    public WashPacks(String pack_id, String name, int cost, String description) {
		super();
		this.pack_id = pack_id;
		this.name = name;
		this.cost = cost;
		this.description = description;
	}


	public String getPack_id() {
		return pack_id;
	}


	public void setPack_id(String pack_id) {
		this.pack_id = pack_id;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public int getCost() {
		return cost;
	}


	public void setCost(int cost) {
		this.cost = cost;
	}


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}


	public WashPacks(){

    }
}