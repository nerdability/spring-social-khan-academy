package org.springframework.social.khanacademy.api;

import java.util.List;

/**
 * Interface to define all available actions regarding a user on the Khan
 * Academy API
 * 
 * @author rob
 */
public interface UserOperations {

	/**
	 * Fetch the full user profile for an authenticated user
	 * 
	 * @return KhanAcademyUser
	 */
	KhanAcademyUser getUser();

	/**
	 * Fetch all exercises attempted by the authenticated user
	 * 
	 * @return List<KhanAcademyUserExercise>
	 */
	List<KhanAcademyUserExercise> getUserExercises();

}
