package org.reviews.reviews;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Repository;

@Repository
public class ReviewRepository {

	private Map<Long, Review> reviewList = new HashMap<>();

	public ReviewRepository() {
		Review northHigh = new Review(1L, "North High", "Has good Coffee IPA", "IPA", "http://www.northhighbrewing.com/wp-content/themes/northhigh/images/beer-home-glasses.png");
		Review wolfRidge = new Review(2L, "Wolf Ridge", "Has a good Cream Ale", "Cream", "https://static1.squarespace.com/static/5536b546e4b07cdf871c2b70/555f52cae4b003d47ad54377/5c5efce9fa0d60425b99c12b/1549729011814/FullSizeRender-1.jpg?format=500w");
		Review sideswipe = new Review(3L, "Sideswipe", "Has a good smoked Stout", "Stout", "https://static1.squarespace.com/static/586be67ad2b8577385860e0c/t/58a5dd095016e119c5829d6c/1487265038854/?format=300w");

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
