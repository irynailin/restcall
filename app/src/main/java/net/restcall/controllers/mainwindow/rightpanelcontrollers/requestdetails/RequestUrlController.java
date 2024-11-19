package net.restcall.controllers.mainwindow.rightpanelcontrollers.requestdetails;

import net.restcall.controllers.Context;
import net.restcall.controllers.Updatable;
import net.restcall.gui.listeners.UiChangeListener;
import net.restcall.gui.pages.request.HttpUrlInput;
import net.restcall.model.RequestConsts.RequestTypes;
import net.restcall.model.call.Endpoint;
import net.restcall.model.call.request.QueryParameters;

public class RequestUrlController implements Updatable, UiChangeListener {
	private final Endpoint endpoint;
	private final QueryParameters queryParameters;
	private final HttpUrlInput urlInput;

	public RequestUrlController(Endpoint endpoint, QueryParameters queryParameters, HttpUrlInput urlInput) {
		super();
		this.endpoint = endpoint;
		this.queryParameters = queryParameters;
		this.urlInput = urlInput;
		urlInput.registerChangeListener(this);
	}

	@Override
	public void updateUi(Updatable excluded) {
		urlInput.update(endpoint.getMethod().toString(), createFullEndpoint());
	}

	private String createFullEndpoint() {
//		var fullEndpoint = new StringBuilder();
//		fullEndpoint.append(endpoint.getUrl());
//		fullEndpoint.append(queryParameters);
//		return fullEndpoint.toString();
		return endpoint.getUrl() + queryParameters;
	}

	@Override
	public void uiChanged() {
		if (Context.mayUpdate()) {
			endpoint.setMethod(RequestTypes.valueOf(urlInput.method()));
			endpoint.setUrl(extractUrl(urlInput.url()));
			queryParameters.fromString(extractQueryParameters(urlInput.url()));
			Context.updateUi(this);
		}
	}

	private String extractUrl(String url) {
		int endUrlIndex = url.indexOf('?');
		if (endUrlIndex == -1) {
			return url;
		} else {
			return url.substring(0, endUrlIndex);
		}
	}

	private String extractQueryParameters(String url) {
		int endUrlIndex = url.indexOf('?');
		if (endUrlIndex == -1) {
			return "";
		} else {
			return endUrlIndex < url.length() - 1 ? url.substring(endUrlIndex + 1) : "";
		}
	}

}
