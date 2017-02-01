package io.ess.webpad.client;

import io.ess.webpad.client.login.LoginController;
import io.ess.webpad.client.login.LoginControllerImpl;

public class Application {

	public static void main(String[] args) {
		LoginController loginController = new LoginControllerImpl();
		loginController.login();
	}
	
}
