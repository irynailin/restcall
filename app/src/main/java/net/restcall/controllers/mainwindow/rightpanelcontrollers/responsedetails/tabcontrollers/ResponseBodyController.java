package net.restcall.controllers.mainwindow.rightpanelcontrollers.responsedetails.tabcontrollers;

import net.restcall.controllers.Updatable;
import net.restcall.gui.pages.response.tabs.ResponseBody;
import net.restcall.model.call.response.Body;

public class ResponseBodyController implements Updatable {

	private final Body body;
	private final ResponseBody responseBody;

	public ResponseBodyController(Body body, ResponseBody responseBody) {
		this.body = body;
		this.responseBody = responseBody;
	}

	@Override
	public void updateUi(Updatable excluded) {
		if(this!=excluded) {
			
		}
		

	}

}
