package org.springframework.social.khanacademy.connect;

import org.springframework.social.connect.support.OAuth2ConnectionFactory;
import org.springframework.social.khanacademy.api.KhanAcademy;

public class KhanAcademyConnectionFactory extends OAuth2ConnectionFactory<KhanAcademy> {

	public KhanAcademyConnectionFactory(String clientId, String clientSecret) {
		super("khanacademy", new KhanAcademyServiceProvider(clientId, clientSecret), new KhanAcademyAdapter());
	}

}
