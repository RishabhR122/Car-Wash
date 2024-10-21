package com.washerplatform.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;


public class WashPack {
	@Id
	private String packId;
	private String name;
	private int cost;
	private String description;
	public WashPack() {
		
	}
	public WashPack(String packId, String name, int cost, String description) {
		
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
