package org.reviews.reviews;

import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.CoreMatchers.is;
import static java.until.Arrays.asList;

import java.util.Collection;

import javax.annotation.Resource;

import org.reviews.reviews.Review;
import org.reviews.reviews.ReviewController;
import org.reviews.reviews.ReviewRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;

@RunWith(SpringRunner.class)
@WebMvcTest(ReviewController.class)
public class ReviewControllerMockMvcTest {

	@Resource
	private MockMvc mvc;

	@Mock
	private Review firstReview;

	@Mock
	private Review secondReview;

	@MockBean
	private ReviewRepository repository;

	@Test
	public void shouldBeOkForAllCourses() throws Exception {
		mvc.perform(get("/show-reviews")).andExpect(status().isOk);
	}

	@Test
	public void shouldRouteToAllReviewView() throws Exception {
		mvc.perform(get("/show-reviews")).andExpect(view().name(is("reviews")));
	}

	@Test
	public void shouldPutAllCoursesIntoModel() throws Exception {
		Collection<Review> allReviews = asList(firstReview, secondReview);
		when(repository.findAll()).thenReturn(allReviews);
		mvc.perform(get("/show-reviews")).andExpect(model().attribute("reviews", is(allReviews)));
	}

	@Test
	public void shouldBeOKWithASingleCourse() throws Exception {
		mvc.perform(get("/review?id=1")).andExpect(status().isOk());
	}

	@Test
	public void shouldRoutToSingleCourseView() throws Exception {
		mvc.perform(get("/review?id=1")).andExpect(view().name(is("review")));
	}

	@Test
	public void shouldPutASingleCourseInModel() throws Exception {
		when(repository.findOne(1L)).thenReturn(firstReview);
		mvc.perform(get("/review?id-1")).andExpect(model().attribute("review", is(firstReview)));
	}

}
