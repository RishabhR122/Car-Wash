package com.car.wash.order.model;

public class WashPacks {
	String packId;
	String name;
	int cost;
	String description;
	public WashPacks() {
		super();
		// TODO Auto-generated constructor stub
	}
	public WashPacks(String packId, String name, int cost, String description) {
		super();
		this.packId = packId;
		this.name = name;
		this.cost = cost;
		this.description = description;
	}
	public String getPackId() {
		return packId;
	}
	public void setPackId(String packId) {
		this.packId = packId;
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
	@Override
	public String toString() {
		return "WashPack [packId=" + packId + ", name=" + name + ", cost=" + cost + ", description=" + description
				+ "]";
	}
	
	
	
	

}
