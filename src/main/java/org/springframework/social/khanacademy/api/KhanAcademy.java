package org.springframework.social.khanacademy.api;

import org.springframework.social.ApiBinding;

/**
 * Central interface that defines all operations available to us
 * 
 * @author rob hinds
 */
public interface KhanAcademy extends ApiBinding {

	/**
	 * This is used to access all user related operations on the API - as per
	 * the docs, this will always need to be OAUTH authenticated
	 * 
	 * @return
	 */
	UserOperations userOperations();

}
