package org.springframework.social.khanacademy.api.impl;

import org.junit.Before;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.test.web.client.MockRestServiceServer;

public class BaseTemplateTest {

	protected KhanAcademyTemplate khanAcademy;
	protected MockRestServiceServer mockServer;
	protected HttpHeaders responseHeaders;

	public BaseTemplateTest() {
		super();
	}

	@Before
	public void setUp() {
		khanAcademy = new KhanAcademyTemplate("accessToken");
		mockServer = MockRestServiceServer.createServer(khanAcademy.getRestTemplate());
		responseHeaders = new HttpHeaders();
		responseHeaders.setContentType(MediaType.APPLICATION_JSON);
	}

}