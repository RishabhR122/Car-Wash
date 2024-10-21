package com.customer.model;

public class Ratings {

	
    private String id;  

    
    private String washerName;
  
    private String comments;
   
    private int rating;
    private WasherProfile washer;
    
    public Ratings() {}

 
    
   




	public Ratings(String id, String washerName, String comments, int rating, com.customer.model.WasherProfile washer) {
		super();
		this.id = id;
		this.washerName = washerName;
		this.comments = comments;
		this.rating = rating;
		this.washer = washer;
	}








	public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getWasherName() {
        return washerName;
    }

    public void setWasherName(String washerName) {
        this.washerName = washerName;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public WasherProfile getWasher() {
        return washer;
    }

    public void setWasher(WasherProfile washer) {
        this.washer = washer;
    }

	

}
