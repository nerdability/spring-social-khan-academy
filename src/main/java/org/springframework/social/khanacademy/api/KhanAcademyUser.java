package org.springframework.social.khanacademy.api;

import java.util.List;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.annotate.JsonProperty;

/**
 * This is the domain object that maps to user profile on Khan Academy.
 * 
 * Uses Jackson JSON mapping to translate API response to pojo
 * 
 * @author rob hinds
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class KhanAcademyUser {

	@JsonProperty("nickname")
	private String nickname;

	@JsonProperty("prettified_user_email")
	private String email;

	@JsonProperty("user_id")
	private String userName;

	@JsonProperty("total_seconds_watched")
	private int secondsVideoWatched;

	@JsonProperty("points")
	private int points;

	@JsonProperty("proficient_exercises")
	private List<String> proficientExercises;

	@JsonProperty("all_proficient_exercises")
	private List<String> allProficientExercises;

	@JsonProperty("suggested_exercises")
	private List<String> suggestedExercises;

	@JsonProperty("coaches")
	private List<String> coaches;

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public int getSecondsVideoWatched() {
		return secondsVideoWatched;
	}

	public void setSecondsVideoWatched(int secondsVideoWatched) {
		this.secondsVideoWatched = secondsVideoWatched;
	}

	public int getPoints() {
		return points;
	}

	public void setPoints(int points) {
		this.points = points;
	}

	public List<String> getProficientExercises() {
		return proficientExercises;
	}

	public void setProficientExercises(List<String> proficientExercises) {
		this.proficientExercises = proficientExercises;
	}

	public List<String> getAllProficientExercises() {
		return allProficientExercises;
	}

	public void setAllProficientExercises(List<String> allProficientExercises) {
		this.allProficientExercises = allProficientExercises;
	}

	public List<String> getSuggestedExercises() {
		return suggestedExercises;
	}

	public void setSuggestedExercises(List<String> suggestedExercises) {
		this.suggestedExercises = suggestedExercises;
	}

	public List<String> getCoaches() {
		return coaches;
	}

	public void setCoaches(List<String> coaches) {
		this.coaches = coaches;
	}
}
