package com.abbyy.client;

public class ClientSettings {

	// Name of application you created
	public static final String APPLICATION_ID = "12e882f9-09c3-4e4d-b0d5-24866c9e014a";
	// Password should be sent to your e-mail after application was created
	public static final String PASSWORD = "JbHffzdw0Qa8J5jG8Ogn9cMr";

	public static void setupProxy() {
		// Uncomment this if you are behind a proxy
		/*
		 * String host = ""; String port = ""; final String user = ""; final String
		 * password = "";
		 * 
		 * Authenticator.setDefault( new Authenticator() { public PasswordAuthentication
		 * getPasswordAuthentication() { return new PasswordAuthentication( user,
		 * password.toCharArray()); } } );
		 * 
		 * System.getProperties().put("http.proxyHost", host );
		 * System.getProperties().put("https.proxyHost", host );
		 * System.getProperties().put("http.proxyPort", port);
		 * System.getProperties().put("https.proxyPort", port);
		 * System.getProperties().put("http.proxyUser", user);
		 * System.getProperties().put("https.proxyUser", user);
		 * System.getProperties().put("http.proxyPassword", password);
		 * System.getProperties().put("https.proxyPassword", password);
		 */
	}

}
