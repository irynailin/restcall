package net.restcall.controllers.mainwindow.rightpanelcontrollers.responsedetails.tabcontrollers;

import net.restcall.consts.RcConsts;
import net.restcall.controllers.Context;
import net.restcall.controllers.Updatable;
import net.restcall.gui.listeners.UiChangeListener;
import net.restcall.gui.pages.response.tabs.ResponseBody;
import net.restcall.model.RequestConsts.RequestTypes;
import net.restcall.model.call.Endpoint;
import net.restcall.model.call.response.Body;

public class ResponseBodyController implements Updatable, UiChangeListener {

	private final Body body;
	private final ResponseBody responseBody;

	private String presentationMode = RcConsts.PRETTY;

	public ResponseBodyController(Body body, ResponseBody responseBody) {
		this.body = body;
		this.responseBody = responseBody;
		this.responseBody.registerChangeListener(this);
	}

	@Override
	public void updateUi(Updatable excluded) {
		if (this != excluded) {
			responseBody.update(presentationMode,body.getPayload());
		}

	}

	@Override
	public void uiChanged() {
		if (Context.mayUpdate()) {
			presentationMode = responseBody.currentMode();
			Context.updateUi(null);
		}

	}

}
