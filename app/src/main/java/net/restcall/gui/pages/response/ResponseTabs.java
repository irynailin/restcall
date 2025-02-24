package net.restcall.gui.pages.response;

import javax.swing.JLabel;
import javax.swing.JTabbedPane;

import net.restcall.gui.pages.response.tabs.ResponseBody;

public class ResponseTabs extends JTabbedPane {

	private final ResponseBody responseBody = new ResponseBody();

	public ResponseTabs() {
		super(BOTTOM, SCROLL_TAB_LAYOUT);
		addTab("Body", responseBody);
		addTab("Cookies", new JLabel("dhsoif"));
		addTab("Headers", new JLabel("dhsoif"));
		addTab("Test Results", new JLabel("dhsoif"));
	}

	public ResponseBody getResponseBody() {
		return responseBody;
	}
}
