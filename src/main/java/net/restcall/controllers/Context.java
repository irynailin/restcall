package net.restcall.controllers;

public class Context {
	private static final Context context = new Context();

	private static boolean updating = false;

	private RootController rootController;

	public static void init() {
		context.rootController = new RootController();
	}

	public static void show() {
		try {
			updating = true;
			context.rootController.show();
		} finally {
			updating = false;
		}
	}

	public static void updateUi(Updatable excluded) {
		if (!updating) {
			try {
				updating = true;
				context.rootController.updateUi(excluded);
			} finally {
				updating = false;
			}
		}
	}

	public static boolean mayUpdate() {
		return !updating;
	}
}
