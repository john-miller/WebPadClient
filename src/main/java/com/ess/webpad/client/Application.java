package com.ess.webpad.client;

import com.ess.webpad.client.controller.LoginController;
import com.ess.webpad.client.controller.LoginControllerImpl;

public class Application {

	public static void main(String[] args) {
		LoginController loginController = new LoginControllerImpl();
		loginController.login();
	}
	
}
