package org.reviews.reviews;

public class Review {
	

	private long id;
	private String name;
	private String description;
	private String category;
	private String url;

	public Review(long id, String name, String description, String category, String url) {
		this.id = id;
		this.name = name;
		this.description = description;
		this.category = category;
		this.url = url;
	}
	
	public Long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getDescription() {
		return description;
	}
	
	public String getCategory() {
		return category;
	}
	
	public String getUrl() {
		return url;
	}

}
