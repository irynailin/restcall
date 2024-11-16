package net.restcall.controllers;

import java.util.ArrayList;
import java.util.List;

public abstract class BaseTabController implements Updatable {
	private final List<Updatable> controllers = new ArrayList<>();

	protected void registerController(Updatable updatable) {
		controllers.add(updatable);
	}

	@Override
	public void updateUi(Updatable excluded) {
		for (Updatable controller : controllers) {
			if (controller != excluded) {
				controller.updateUi(excluded);
			}
		}
	}
}
