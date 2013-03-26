package org.springframework.social.khanacademy.api.impl;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.annotate.JsonAutoDetect.Visibility;
import org.codehaus.jackson.annotate.JsonMethod;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.type.TypeReference;
import org.springframework.social.khanacademy.api.KhanAcademyUser;
import org.springframework.social.khanacademy.api.KhanAcademyUserExercise;
import org.springframework.social.khanacademy.api.UserOperations;
import org.springframework.web.client.RestTemplate;

public class UserTemplate extends AbstractKhanAcademyOperations implements UserOperations {

	private final RestTemplate restTemplate;

	public UserTemplate(RestTemplate restTemplate, boolean isAuthorized) {
		super(isAuthorized);
		this.restTemplate = restTemplate;
	}

	public KhanAcademyUser getUser() {
		requireAuthorization();
		KhanAcademyUser user = restTemplate.getForObject(buildUrl("/user"), KhanAcademyUser.class);
		return user;
	}

	public List<KhanAcademyUserExercise> getUserExercises() {
		requireAuthorization();
		String apiReturn = restTemplate.getForObject(buildUrl("/user/exercises"), String.class);

		ObjectMapper mapper = new ObjectMapper().setVisibility(JsonMethod.FIELD, Visibility.ANY);
		List<KhanAcademyUserExercise> exercises = new ArrayList<KhanAcademyUserExercise>();
		try {
			exercises = mapper.readValue(apiReturn, new TypeReference<List<KhanAcademyUserExercise>>() {
			});
		} catch (JsonParseException e) {
			e.printStackTrace();
		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		return exercises;
	}
}
