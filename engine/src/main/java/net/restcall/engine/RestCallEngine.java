package net.restcall.engine;

import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import net.restcall.model.RestCall;
import net.restcall.model.call.Response;
import net.restcall.model.call.response.Body;

public class RestCallEngine {
	private static RestCallEngine current = new RestCallEngine();

	public static RestCallEngine current() {
		return current;
	}

	public void call(RestCall restcall) {
		try {
			HttpClient client = HttpClient.newHttpClient();
			HttpRequest request = HttpRequest.newBuilder().uri(createUri(restcall))
					// .headers(...)
					.build();
			HttpResponse<String> httpResponse = client.send(request, HttpResponse.BodyHandlers.ofString());
			System.out.println(httpResponse.body());

			restcall.setResponse(new Response(new Body(httpResponse.body()), null, null, null));
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	private URI createUri(RestCall restcall) throws URISyntaxException {

		return new URI(restcall.getEndpoint().getUrl() + restcall.getRequest().getQueryParameters());
	}

}
