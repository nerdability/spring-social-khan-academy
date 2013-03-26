package org.springframework.social.khanacademy.api;

import java.util.Date;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.annotate.JsonProperty;

/**
 * This is the domain object that maps to the Exercise object on Khan Academy.
 * 
 * Uses Jackson JSON mapping to translate API response to pojo
 * 
 * @author rob hinds
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class KhanAcademyUserExercise {

	@JsonProperty("exercise")
	private String name;

	@JsonProperty("first_done")
	private Date dateFirstCompleted;

	@JsonProperty("kind")
	private String exerciseType;

	@JsonProperty("last_done")
	private Date dateLastCompleted;

	@JsonProperty("last_review")
	private Date dateLastReviewed;

	@JsonProperty("longest_streak")
	private int longestStreak;

	@JsonProperty("proficient_date")
	private Date dateFirstProficient;

	@JsonProperty("seconds_per_fast_problem")
	private int secondsPerFastQuestion;

	@JsonProperty("streak")
	private String streak;

	@JsonProperty("summative")
	private boolean summative;

	@JsonProperty("total_done")
	private int totalDone;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getDateFirstCompleted() {
		return dateFirstCompleted;
	}

	public void setDateFirstCompleted(Date dateFirstCompleted) {
		this.dateFirstCompleted = dateFirstCompleted;
	}

	public String getExerciseType() {
		return exerciseType;
	}

	public void setExerciseType(String exerciseType) {
		this.exerciseType = exerciseType;
	}

	public Date getDateLastCompleted() {
		return dateLastCompleted;
	}

	public void setDateLastCompleted(Date dateLastCompleted) {
		this.dateLastCompleted = dateLastCompleted;
	}

	public Date getDateLastReviewed() {
		return dateLastReviewed;
	}

	public void setDateLastReviewed(Date dateLastReviewed) {
		this.dateLastReviewed = dateLastReviewed;
	}

	public int getLongestStreak() {
		return longestStreak;
	}

	public void setLongestStreak(int longestStreak) {
		this.longestStreak = longestStreak;
	}

	public Date getDateFirstProficient() {
		return dateFirstProficient;
	}

	public void setDateFirstProficient(Date dateFirstProficient) {
		this.dateFirstProficient = dateFirstProficient;
	}

	public int getSecondsPerFastQuestion() {
		return secondsPerFastQuestion;
	}

	public void setSecondsPerFastQuestion(int secondsPerFastQuestion) {
		this.secondsPerFastQuestion = secondsPerFastQuestion;
	}

	public String getStreak() {
		return streak;
	}

	public void setStreak(String streak) {
		this.streak = streak;
	}

	public boolean isSummative() {
		return summative;
	}

	public void setSummative(boolean summative) {
		this.summative = summative;
	}

	public int getTotalDone() {
		return totalDone;
	}

	public void setTotalDone(int totalDone) {
		this.totalDone = totalDone;
	}

}
