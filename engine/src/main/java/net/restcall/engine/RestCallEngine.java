package net.restcall.engine;

import net.restcall.model.RestCall;

public class RestCallEngine {
	private static RestCallEngine current = new RestCallEngine();

	public static RestCallEngine current() {
		return current;
	}

	public void call(RestCall restcall) {
		System.out.println(restcall.getEndpoint().getUrl());
	}

}
