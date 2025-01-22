package net.restcall.model.call;

import net.restcall.model.call.response.Body;
import net.restcall.model.call.response.Cookies;
import net.restcall.model.call.response.Headers;
import net.restcall.model.call.response.TestResults;

public class Response {
	private Body body;

	private Headers headers;
	private Cookies cookies;
	private TestResults testResults;

	public Response() {
		this.body=new Body("");
	}

	public Response(Body body, Headers headers, Cookies cookies, TestResults testResults) {
		super();
		this.body = body;
		this.headers = headers;
		this.cookies = cookies;
		this.testResults = testResults;
	}

	public Body getBody() {
		return body;
	}

	public void setBody(Body body) {
		this.body = body;
	}

	public Headers getHeaders() {
		return headers;
	}

	public void setHeaders(Headers headers) {
		this.headers = headers;
	}

	public Cookies getCookies() {
		return cookies;
	}

	public void setCookies(Cookies cookies) {
		this.cookies = cookies;
	}

	public TestResults getTestResults() {
		return testResults;
	}

	public void setTestResults(TestResults testResults) {
		this.testResults = testResults;
	}
}
