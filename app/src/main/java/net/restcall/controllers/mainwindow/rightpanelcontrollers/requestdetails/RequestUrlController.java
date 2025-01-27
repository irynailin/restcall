package net.restcall.controllers.mainwindow.rightpanelcontrollers.requestdetails;

import net.restcall.controllers.Context;
import net.restcall.controllers.Updatable;
import net.restcall.engine.RestCallEngine;
import net.restcall.gui.listeners.OperationListener;
import net.restcall.gui.listeners.UiChangeListener;
import net.restcall.gui.pages.request.HttpUrlInput;
import net.restcall.model.RequestConsts.RequestTypes;
import net.restcall.model.RestCall;
import net.restcall.model.call.Endpoint;
import net.restcall.model.call.request.QueryParameters;

public class RequestUrlController implements Updatable, UiChangeListener, OperationListener {
	private final RestCall restcall;

	private final HttpUrlInput urlInput;

	public RequestUrlController(RestCall restcall, HttpUrlInput urlInput) {
		super();
		this.restcall = restcall;

		this.urlInput = urlInput;
		urlInput.registerChangeListener(this);
		urlInput.registerSendOperationListener(this);
	}

	@Override
	public void updateUi(Updatable excluded) {
		urlInput.update(restcall.getEndpoint().getMethod().toString(), createFullEndpoint());
	}

	private String createFullEndpoint() {
//		var fullEndpoint = new StringBuilder();
//		fullEndpoint.append(endpoint.getUrl());
//		fullEndpoint.append(queryParameters);
//		return fullEndpoint.toString();
		return restcall.getEndpoint().getUrl() + restcall.getRequest().getQueryParameters();
	}

	@Override
	public void uiChanged() {
		if (Context.mayUpdate()) {
			Endpoint endpoint = restcall.getEndpoint();
			endpoint.setMethod(RequestTypes.valueOf(urlInput.method()));
			endpoint.setUrl(extractUrl(urlInput.url()));
			restcall.getRequest().getQueryParameters().fromString(extractQueryParameters(urlInput.url()));
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

	@Override
	public void operationFired() {
		RestCallEngine.current().call(restcall);
		Context.updateUi(null);
	}

}
