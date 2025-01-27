package net.restcall.gui.pages.response;

import java.awt.Component;

import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class ResponsePanel extends JPanel {
	private final ResponseTabs responseTabs = new ResponseTabs();

	public ResponsePanel() {
		super();
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		add(new JLabel("howdy"));
		add(responseTabs);

	}

	public ResponseTabs getResponseTabs() {
		return responseTabs;
	}
	
}
