package net.restcall.controllers.mainwindow;

import java.util.ArrayList;
import java.util.List;

import net.restcall.controllers.Updatable;
import net.restcall.gui.RightPanel;
import net.restcall.gui.pages.RequestPage;
import net.restcall.model.ModelItem;
import net.restcall.model.Workspace;

public class RightPanelController implements Updatable {

	private List<ModelItem> shownItems = new ArrayList<>();
	private ModelItem currentModelItem;
	private Workspace workspace;
	private RightPanel rightPanel;

	public RightPanelController(Workspace workspace, RightPanel rightPanel) {
		this.workspace = workspace;
		this.rightPanel = rightPanel;
	}

	@Override
	public void updateUi() {
		if (rightPanel.isAllTabsPresent(shownItems.size())) {
			ModelItem item = shownItems.get(shownItems.size() - 1);
			rightPanel.openTab(item.getName(), new RequestPage(item));
		}
		if (currentModelItem != null) {
			rightPanel.switchToTab(shownItems.indexOf(currentModelItem));
		}
	}

	public void openModelItem(ModelItem modelItem) {
		if (isNotShown(modelItem)) {
			shownItems.add(modelItem);
		}
		currentModelItem = modelItem;
		updateUi();
	}

	private boolean isNotShown(ModelItem modelItem) {
		return !shownItems.contains(modelItem);
	}
	
}
