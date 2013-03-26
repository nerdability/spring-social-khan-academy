package org.springframework.social.khanacademy.api.impl;

import static org.junit.Assert.assertEquals;
import static org.springframework.http.HttpMethod.GET;
import static org.springframework.test.web.client.match.RequestMatchers.method;
import static org.springframework.test.web.client.match.RequestMatchers.requestTo;
import static org.springframework.test.web.client.response.ResponseCreators.withResponse;

import java.util.List;

import org.junit.Test;
import org.springframework.social.khanacademy.api.KhanAcademyUser;
import org.springframework.social.khanacademy.api.KhanAcademyUserExercise;

public class UserTemplateTest extends BaseTemplateTest {

	private final String userString = "{\"all_proficient_exercises\": [\"addition_1\", \"subtraction_1\", \"multiplication_0.5\"], \"badge_counts\": {\"0\": 1, \"1\": 1, \"2\": 0, \"3\": 0, \"4\": 0, \"5\": 1}, \"coaches\": [\"yourcoach@gmail.com\"], \"joined\": \"2011-02-04T06:01:47Z\", \"kind\": \"UserData\", \"last_activity\": \"2011-05-04T06:01:47Z\", \"nickname\": \"Gob Bluth\",\"points\": 9188, \"proficient_exercises\": [\"addition_1\", \"subtraction_1\", \"multiplication_0.5\"], \"suggested_exercises\": [\"addition_2\", \"subtraction_2\"], \"total_seconds_watched\": 105, \"user_id\": \"you@gmail.com\", \"prettified_user_email\": \"you@gmail.com\"}";
	private final String exerciseString = "[{\"exercise\": \"subtraction_1\", \"first_done\": \"2011-05-01T06:01:47Z\", \"kind\": \"UserExercise\", \"last_done\": \"2011-05-04T06:01:47Z\", \"last_review\": \"2011-05-02T06:01:47Z\", \"longest_streak\": 26, \"proficient_date\": \"2011-05-03T06:01:47Z\", \"seconds_per_fast_problem\": 4.0, \"streak\": 26, \"summative\": false, \"total_done\": 26, \"user\": \"you@gmail.com\"},{\"exercise\": \"subtraction_1\", \"first_done\": \"2011-05-01T06:01:47Z\", \"kind\": \"UserExercise\", \"last_done\": \"2011-05-04T06:01:47Z\", \"last_review\": \"2011-05-02T06:01:47Z\", \"longest_streak\": 26, \"proficient_date\": \"2011-05-03T06:01:47Z\", \"seconds_per_fast_problem\": 4.0, \"streak\": 26, \"summative\": false, \"total_done\": 26, \"user\": \"you@gmail.com\"}]";

	@Test
	public void getUser() throws Exception {
		mockServer.expect(requestTo("http://www.khanacademy.org/api/v1/user")).andExpect(method(GET)).andRespond(withResponse(userString, responseHeaders));

		KhanAcademyUser user = khanAcademy.userOperations().getUser();

		assertEquals("you@gmail.com", user.getUserName());
		assertEquals("you@gmail.com", user.getEmail());
		assertEquals(9188, user.getPoints());
		assertEquals("Gob Bluth", user.getNickname());
		assertEquals(105, user.getSecondsVideoWatched());
		List<String> proficientExercises = user.getProficientExercises();
		assertEquals(3, proficientExercises.size());
	}

	@Test
	public void getUserExercises() throws Exception {
		mockServer.expect(requestTo("http://www.khanacademy.org/api/v1/user/exercises")).andExpect(method(GET)).andRespond(withResponse(exerciseString, responseHeaders));

		List<KhanAcademyUserExercise> exercises = khanAcademy.userOperations().getUserExercises();
		assertEquals(2, exercises.size());
		KhanAcademyUserExercise ex = exercises.get(0);
		assertEquals("UserExercise", ex.getExerciseType());
		assertEquals("subtraction_1", ex.getName());
		assertEquals(26, ex.getTotalDone());

	}

}
