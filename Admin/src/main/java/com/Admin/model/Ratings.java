package com.Admin.model;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Positive;

@Entity
public class Ratings {

    @Id
    private String id;  

    @NotEmpty(message="Detail cannot be left empty")
    private String washerName;
    @NotEmpty(message="Detail cannot be left empty")
    private String comments;
    @Positive(message = "Rating Should be positive")
    @Max(value = 5 ,message = "Max Rating should be 5")
    private int rating;

    @ManyToOne(cascade = CascadeType.ALL)
    @JsonBackReference
    private WasherProfile washer;
    
    public Ratings() {}

 
    
   
    public Ratings(String id, @NotEmpty(message = "Detail cannot be left empty") String washerName,
			@NotEmpty(message = "Detail cannot be left empty") String comments,
			@Positive(message = "Rating Should be positive") @Max(value = 5, message = "Max Rating should be 5") int rating,
			WasherProfile washer) {
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


	@Override
	public String toString() {
		return "Ratings [id=" + id + ", washerName=" + washerName + ", comments=" + comments + ", rating=" + rating;
	}
    
}
