package org.reviews.reviews;

public class Review {
	

	private long id;
	private String name;
	private String description;

	public Long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getDescription() {
		return description;
	}
	public Review(long id, String name, String description) {
		this.id = id;
		this.name = name;
	}

}
