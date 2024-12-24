package net.restcall.controllers.mainwindow.rightpanelcontrollers.responsedetails;

import net.restcall.controllers.BaseTabController;
import net.restcall.controllers.mainwindow.rightpanelcontrollers.requestdetails.tabcontrollers.QueryParamsController;
import net.restcall.controllers.mainwindow.rightpanelcontrollers.responsedetails.tabcontrollers.ResponseBodyController;
import net.restcall.gui.pages.response.ResponseTabs;
import net.restcall.model.call.Response;

public class RequestResponseController extends BaseTabController  {

	private final Response response;
	private final ResponseTabs responseTabs;

	public RequestResponseController(Response response, ResponseTabs responseTabs) {
		this.response = response;
		this.responseTabs = responseTabs;
		registerController(new ResponseBodyController(response.getBody(), responseTabs.getResponseBody()));
	}

	

}
