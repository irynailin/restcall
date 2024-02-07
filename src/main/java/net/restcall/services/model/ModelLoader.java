package net.restcall.services.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import net.restcall.model.RequestFolder;
import net.restcall.model.RestCall;
import net.restcall.model.Workspace;

public class ModelLoader {
	public void load(Workspace workspace) {
		List<RequestFolder> rootFolders = createSampleFolders();
		workspace.installFolders(rootFolders);
	}

	private List<RequestFolder> createSampleFolders() {
		List<RequestFolder> rootFolders = new ArrayList<>();
		RequestFolder folder1 = new RequestFolder("Folder1", "", new Date());
		rootFolders.add(folder1);
		
		RequestFolder folder2 = new RequestFolder();
		folder2.setName("folderII");
		rootFolders.add(folder2);
		
		List<RequestFolder> folder2FoldersChildren = new ArrayList<>();
		folder2FoldersChildren.add(new RequestFolder("haz"));
		folder2FoldersChildren.add(new RequestFolder("daiiiz"));
		folder2FoldersChildren.add(new RequestFolder("vauhiz"));
		folder2FoldersChildren.add(new RequestFolder("saaz"));
		folder2.setFolders(folder2FoldersChildren);
		
		List<RestCall> folder2RestcallsChildren = new ArrayList<>();
		folder2RestcallsChildren.add(new RestCall("restcalla", null, null));
		folder2.setRestCalls(folder2RestcallsChildren);
		
		RequestFolder folder3 = new RequestFolder();
		folder3.setName("folderThree");
		folder3.setDescription("the folder");
		folder3.setCreationDate(new Date());
		rootFolders.add(folder3);
		return rootFolders;
	}
}
