package net.restcall.gui.pages.response.tabs.bodies;

import java.awt.BorderLayout;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class ResponseBodyPretty extends JPanel {
	public ResponseBodyPretty() {
		super(new BorderLayout(0, 0));
		var textArea = new JTextArea();
		JScrollPane scrollPane = new JScrollPane(textArea);
		add(scrollPane, BorderLayout.CENTER);
	}

}
