package net.restcall;

import java.awt.EventQueue;

import com.formdev.flatlaf.FlatLightLaf;

import net.restcall.controllers.Context;

public class RestcallApplication {

	public static void main(String[] args) {
		var app = new RestcallApplication();
		app.startGui();
	}

	private void startGui() {
		FlatLightLaf.setup();
		Context.init();
		EventQueue.invokeLater(Context::show);

	}
}
