package net.restcall.controllers.mainwindow;

import java.util.ArrayList;
import java.util.List;

import net.restcall.controllers.Context;
import net.restcall.controllers.Updatable;
import net.restcall.controllers.mainwindow.rightpanelcontrollers.BaseRightPanelTabController;
import net.restcall.controllers.mainwindow.rightpanelcontrollers.FolderTabController;
import net.restcall.controllers.mainwindow.rightpanelcontrollers.RestcallTabController;
import net.restcall.gui.RightPanel;
import net.restcall.model.ModelItem;
import net.restcall.model.RestCall;
import net.restcall.model.Workspace;

public class RightPanelController implements Updatable {

	private final List<BaseRightPanelTabController> tabControllers = new ArrayList<>();
	private final Workspace workspace;
	private final RightPanel rightPanel;
	private int currentTabIndex = -1;

	public RightPanelController(Workspace workspace, RightPanel rightPanel) {
		this.workspace = workspace;
		this.rightPanel = rightPanel;
	}

	@Override
	public void updateUi(Updatable excluded) {
		if (rightPanel.isAllTabsPresent(tabControllers.size())) {
			BaseRightPanelTabController tabController = tabControllers.get(tabControllers.size() - 1);
			tabController.open();
		}
		if (currentTabIndex >= 0) {
			rightPanel.switchToTab(currentTabIndex);
			var updatable = tabControllers.get(currentTabIndex);
			if (updatable != excluded) {
				updatable.updateUi(excluded);
			}
		}
	}

	public void openModelItem(ModelItem modelItem) {
		currentTabIndex = findTabIndex(modelItem);

		if (currentTabIndex < 0) {
			tabControllers.add(createTabController(modelItem));
			currentTabIndex = tabControllers.size() - 1;
		}
		updateUi(null);
	}

	private BaseRightPanelTabController createTabController(ModelItem modelItem) {
		if (modelItem instanceof RestCall) {
			return new RestcallTabController(modelItem, rightPanel);
		} else {
			return new FolderTabController(modelItem, rightPanel);
		}

	}

	private int findTabIndex(ModelItem modelItem) {
		for (int i = 0; i < tabControllers.size(); i++) {
			if (tabControllers.get(i).ownModelItem(modelItem)) {
				return i;

			}
		}
		return -1;
	}

}
