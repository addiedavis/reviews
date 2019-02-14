package org.reviews.reviews;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Repository;

@Repository
public class ReviewRepository {

	private Map<Long, Review> reviewList = new HashMap<>();

	public ReviewRepository() {
		Review northHigh = new Review(1L, "North High", "Has good Coffee IPA");
		Review wolfRidge = new Review(2L, "Wolf Ridge", "Has a good Cream Ale");
		Review sideswipe = new Review(3L, "Sideswipe", "Has a good smoked Porter");

		reviewList.put(northHigh.getId(), northHigh);
		reviewList.put(wolfRidge.getId(), wolfRidge);
		reviewList.put(sideswipe.getId(), sideswipe);
	}

	// testing use only
	public ReviewRepository(Review... reviews) {
		for (Review review : reviews) {
			reviewList.put(review.getId(), review);
		}
	}

	public Review findOne(long id) {
		return reviewList.get(id);
	}

	public Collection<Review> findAll() {
		return reviewList.values();
	}

}
