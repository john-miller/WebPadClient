package io.ess.webpad.client.controller;

import io.ess.webpad.client.service.JVMService;
import io.ess.webpad.client.view.WindowedViewListener;
import io.ess.webpad.client.view.login.FXLoginViewImpl;
import io.ess.webpad.client.view.login.LoginView;
import io.ess.webpad.client.view.login.LoginViewListener;
import io.ess.webpad.client.view.login.SwingLoginViewImpl;

public class LoginControllerImpl implements LoginController {
	
	/*
	 * Attempts to load the preferred JavaFX view but will degrade to swing
	 * if java fx is not supported
	 */
	private LoginView loginView = JVMService.INSTANCE.supportsJavaFX() ? new FXLoginViewImpl() : new SwingLoginViewImpl();
	
	public void login() {
		
		loginView.setUsername("Test");
		loginView.setPassword("Password");
		
		loginView.setLoginViewListener(new LoginViewListener() {
			public void login(String username, String password) {
				System.out.println(username + " " + password);
			}
			public void cancel() {
				System.out.println("cancel");
			}
		});
		
		loginView.setWindowedViewListener(new WindowedViewListener() {
			public void onClose() {
				System.out.println("Window closed");
			}
		});
		
		loginView.displayInWindow();
		
	}

}
