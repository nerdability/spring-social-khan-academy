package org.springframework.social.khanacademy.api.impl;

import org.springframework.social.MissingAuthorizationException;

/**
 * Class to define core is authorised checks to be used by all Operation class
 * implementations. (Based on Facebook implementation)
 * 
 * @author rob hinds
 */
public class AbstractKhanAcademyOperations {

	private static final String BASE_API_URL = "http://www.khanacademy.org/api/v1";

	private final boolean isAuthorized;

	public AbstractKhanAcademyOperations(boolean isAuthorized) {
		this.isAuthorized = isAuthorized;
	}

	protected void requireAuthorization() {
		if (!isAuthorized) {
			throw new MissingAuthorizationException("KhanAcademy Authorisation required");
		}
	}

	protected String buildUrl(String string) {
		return BASE_API_URL + string;
	}
}
