package net.restcall.gui.pages.response.tabs;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JPanel;

import net.restcall.gui.pages.response.tabs.bodies.ResponseBodyNone;
import net.restcall.gui.pages.response.tabs.bodies.ResponseBodyPretty;
import net.restcall.gui.pages.response.tabs.bodies.ResponseBodyPreview;
import net.restcall.gui.pages.response.tabs.bodies.ResponseBodyRaw;

public class ResponseBody extends JPanel {
	private static final String PRETTY = "pretty";
	private static final String RAW = "raw";
	private static final String PREVIEW = "preview";
	private static final String NONE = "none";

	private final JPanel contentPanel = new JPanel(new BorderLayout(0, 0));

	public ResponseBody() {
		super(new BorderLayout(0, 0));

		String[] payloadTypes = { PRETTY, RAW, PREVIEW };
		JComboBox<String> payloadTypeComboBox = new JComboBox<>(payloadTypes);

		add(payloadTypeComboBox, BorderLayout.NORTH);
		add(contentPanel, BorderLayout.CENTER);
		updateContentPanel((String) payloadTypeComboBox.getSelectedItem()); // Initial update

		// Add an ActionListener to the combo box
		payloadTypeComboBox.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String selectedOption = (String) payloadTypeComboBox.getSelectedItem();
				updateContentPanel(selectedOption);
			}
		});
	}

	/**
	 * Update content panel
	 * 
	 * @param selectedOption
	 */
	private void updateContentPanel(String selectedOption) {
		// Clear previous content
		contentPanel.removeAll();

		// Add new content based on the selected option
		contentPanel.add(createBodyContent(selectedOption), BorderLayout.CENTER);

		// Repaint the panel
		contentPanel.revalidate();
		contentPanel.repaint();
	}

	private JComponent createBodyContent(String selectedOption) {
		switch (selectedOption) {
		case PRETTY:
			return new ResponseBodyPretty();
		case RAW:
			return new ResponseBodyRaw();
		case PREVIEW:
			return new ResponseBodyPreview();
		default:
			return new ResponseBodyNone();
		}
	}

}
