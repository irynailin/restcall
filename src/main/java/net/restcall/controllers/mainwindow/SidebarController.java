package net.restcall.controllers.mainwindow;

import java.util.List;

import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreeModel;

import net.restcall.controllers.Updatable;
import net.restcall.gui.Sidebar;
import net.restcall.model.RequestFolder;
import net.restcall.model.Workspace;

public class SidebarController implements Updatable {

	private Workspace workspace;
	private Sidebar sidebarPanel;

	public SidebarController(Workspace workspace, Sidebar sidebarPanel) {
		this.workspace = workspace;
		this.sidebarPanel = sidebarPanel;
		// TODO Auto-generated constructor stub
	}

	@Override
	public void updateUi() {
		List<RequestFolder> folders = workspace.getRootFolders();

		DefaultMutableTreeNode root = new DefaultMutableTreeNode(workspace.getName());

		for (RequestFolder rf : folders) {
			DefaultMutableTreeNode branch = new DefaultMutableTreeNode(rf.getName());
			root.add(branch);
		}

		TreeModel model = new DefaultTreeModel(root);
		sidebarPanel.setModel(model);

	}

}