package net.restcall.gui.pages.request.tabs;

import java.awt.BorderLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import net.restcall.controllers.mainwindow.rightpanelcontrollers.requestdetails.tabcontrollers.QueryParamsController;
import net.restcall.gui.listeners.UiChangeListener;

public class QueryParametersPanel extends JPanel {
	
	private UiChangeListener changeListener;

	public QueryParametersPanel() {
		super(new BorderLayout(0, 0));

		var header = new JLabel("Query RestCall");

		String data[][] = { { "param1", "value1", "sdfjdif" }, { "param2", "value2", "eefef?" },
				{ "param3", "value3", "descrptione" }, { "param4", "value4", "111" } };
					
		String col[] = { "Name", "Value", "Description" };
		DefaultTableModel model = new DefaultTableModel(data, col);
		JTable table = new JTable(model);

		JScrollPane scrollpane = new JScrollPane(table);
		add(scrollpane, BorderLayout.CENTER);
		add(header, BorderLayout.NORTH);
	}

	public void registerChangeListener(UiChangeListener changeListener) {
		this.changeListener = changeListener;
	}
}
