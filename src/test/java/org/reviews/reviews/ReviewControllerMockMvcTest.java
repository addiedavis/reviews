package org.reviews.reviews;

import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.Matchers.hasSize;
import static org.mockito.Mockito.when;


import java.util.Arrays;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
//import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
//import java.util.Collection;

import javax.annotation.Resource;

import org.reviews.reviews.Review;
import org.reviews.reviews.ReviewController;
import org.reviews.reviews.ReviewRepository;

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
		mvc.perform(get("/show-reviews")).andExpect(status().isOk());
	}

	@Test
	public void shouldRouteToAllReviewView() throws Exception {
		mvc.perform(get("/show-reviews")).andExpect(view().name(is("reviews")));
	}

	@Test
	public void shouldPutAllCoursesIntoModel() throws Exception {
		
		when(repository.findAll()).thenReturn(Arrays.asList(firstReview, secondReview));
		mvc.perform(get("/show-reviews")).andExpect(model().attribute("reviews", hasSize(2)));
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
