package org.reviews.reviews;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsInAnyOrder;

import java.util.Collection;

import org.reviews.reviews.Review;
import org.reviews.reviews.ReviewRepository;
import org.junit.Test;

public class ReviewRepoTest {

	ReviewRepository underTest;

	private long firstReviewId = 1L;
	private Review firstReview = new Review(firstReviewId, "review name", "description");

	private long secondReviewId = 2L;
	private Review secondReview = new Review(secondReviewId, "review name", "description");

	@Test
	public void shouldFindAReview() {
		underTest = new ReviewRepository(firstReview);
		Review result = underTest.findOne(firstReviewId);
		assertThat(result, is(firstReview));
	}

	@Test
	public void shouldFindASecondCourse() {
		underTest = new ReviewRepository(secondReview);
		Review result = underTest.findOne(secondReviewId);
		assertThat(result, is(secondReview));
	}

	@Test
	public void shouldFindAllReviews() {
		underTest = new ReviewRepository(firstReview, secondReview);
		Collection<Review> result = underTest.findAll();
		assertThat(result, containsInAnyOrder(firstReview, secondReview));
	}

}
