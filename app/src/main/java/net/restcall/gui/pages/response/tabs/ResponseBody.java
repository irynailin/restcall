package net.restcall.gui.pages.response.tabs;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JPanel;

import net.restcall.consts.RcConsts;
import net.restcall.gui.listeners.UiChangeListener;
import net.restcall.gui.pages.response.tabs.bodies.ResponseBodyNone;
import net.restcall.gui.pages.response.tabs.bodies.ResponseBodyPretty;
import net.restcall.gui.pages.response.tabs.bodies.ResponseBodyPreview;
import net.restcall.gui.pages.response.tabs.bodies.ResponseBodyRaw;
import net.restcall.gui.pages.response.tabs.bodies.UpdatableBody;

public class ResponseBody extends JPanel {

	private static final String[] payloadTypes = { RcConsts.PRETTY, RcConsts.RAW, RcConsts.PREVIEW };

	private final JComboBox<String> payloadTypeComboBox = new JComboBox<>(payloadTypes);
	private final JPanel contentPanel = new JPanel(new BorderLayout(0, 0));

	private UiChangeListener changeListener;

	private UpdatableBody updatableBody;

	public ResponseBody() {
		super(new BorderLayout(0, 0));

		add(payloadTypeComboBox, BorderLayout.NORTH);
		add(contentPanel, BorderLayout.CENTER);
		replaceContentPanel((String) payloadTypeComboBox.getSelectedItem()); // Initial update

		// Add an ActionListener to the combo box
		payloadTypeComboBox.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (changeListener != null) {
					changeListener.uiChanged();
				}
			}
		});
	}

	public String currentMode() {
		return (String) payloadTypeComboBox.getSelectedItem();
	}

	public void update(String payloadType, String payload) {
		if (!payloadType.equals(currentMode())) {

			payloadTypeComboBox.setSelectedItem(payloadType);

			if (replaceContentPanel(payloadType) instanceof UpdatableBody ub) {
				updatableBody = ub;
			} else {
				updatableBody = null;
			}
		}

		if (updatableBody != null) {
			updatableBody.update(payload);
		}
	}

	public void registerChangeListener(UiChangeListener changeListener) {
		this.changeListener = changeListener;
	}

	/**
	 * Update content panel
	 * 
	 * @param selectedOption
	 * @return
	 */
	private JComponent replaceContentPanel(String selectedOption) {
		// Clear previous content
		contentPanel.removeAll();

		var contentPanelChild = createBodyContent(selectedOption);

		// Add new content based on the selected option
		contentPanel.add(contentPanelChild, BorderLayout.CENTER);

		// Repaint the panel
		contentPanel.revalidate();
		contentPanel.repaint();

		return contentPanelChild;

	}

	private JComponent createBodyContent(String selectedOption) {
		switch (selectedOption) {
		case RcConsts.PRETTY:
			return new ResponseBodyPretty();
		case RcConsts.RAW:
			return new ResponseBodyRaw();
		case RcConsts.PREVIEW:
			return new ResponseBodyPreview();
		default:
			return new ResponseBodyNone();
		}
	}

}
