package com.ess.webpad.client.controller;

import com.ess.webpad.client.view.WindowedViewListener;
import com.ess.webpad.client.view.login.LoginView;
import com.ess.webpad.client.view.login.LoginViewListener;
import com.ess.webpad.client.view.login.SwingLoginViewImpl;

public class LoginControllerImpl implements LoginController {
	
	private LoginView loginView = new SwingLoginViewImpl();
	
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
