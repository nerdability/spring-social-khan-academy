package org.springframework.social.khanacademy.connect;

import org.springframework.social.khanacademy.api.KhanAcademy;
import org.springframework.social.khanacademy.api.impl.KhanAcademyTemplate;
import org.springframework.social.oauth2.AbstractOAuth2ServiceProvider;
import org.springframework.social.oauth2.OAuth2Template;

public class KhanAcademyServiceProvider extends AbstractOAuth2ServiceProvider<KhanAcademy> {

	public KhanAcademyServiceProvider(String clientId, String clientSecret) {
		super(createOAuth2Template(clientId, clientSecret));
	}

	private static OAuth2Template createOAuth2Template(String clientId, String clientSecret) {
		OAuth2Template oAuth2Template = new OAuth2Template(clientId, clientSecret, "http://www.khanacademy.org/api/auth/request_token", "http://www.khanacademy.org/api/auth/access_token");
		oAuth2Template.setUseParametersForClientAuthentication(true);
		return oAuth2Template;
	}

	public KhanAcademy getApi(String accessToken) {
		return new KhanAcademyTemplate(accessToken);
	}

}
