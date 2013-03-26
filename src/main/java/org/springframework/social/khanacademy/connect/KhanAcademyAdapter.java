package org.springframework.social.khanacademy.connect;

import org.springframework.social.ApiException;
import org.springframework.social.connect.ApiAdapter;
import org.springframework.social.connect.ConnectionValues;
import org.springframework.social.connect.UserProfile;
import org.springframework.social.connect.UserProfileBuilder;
import org.springframework.social.khanacademy.api.KhanAcademy;
import org.springframework.social.khanacademy.api.KhanAcademyUser;

/**
 * Adapter implementation for Khan Academy (based on Facebook implementation)
 */
public class KhanAcademyAdapter implements ApiAdapter<KhanAcademy> {

	public void setConnectionValues(KhanAcademy khanAcademy, ConnectionValues values) {
		KhanAcademyUser profile = khanAcademy.userOperations().getUser();
		values.setProviderUserId(String.valueOf(profile.getUserName()));
		values.setDisplayName(profile.getNickname());
	}

	public UserProfile fetchUserProfile(KhanAcademy khanAcademy) {
		KhanAcademyUser profile = khanAcademy.userOperations().getUser();
		return new UserProfileBuilder().setName(profile.getNickname()).setEmail(profile.getEmail()).setUsername(profile.getUserName()).build();
	}

	public boolean test(KhanAcademy khanAcademy) {
		try {
			khanAcademy.userOperations().getUser();
			return true;
		} catch (ApiException e) {
			return false;
		}
	}

	public void updateStatus(KhanAcademy github, String message) {
		// We are not doing any writing through this API for now
	}

}