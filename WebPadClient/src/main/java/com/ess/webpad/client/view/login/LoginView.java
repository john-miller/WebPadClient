package com.ess.webpad.client.view.login;

import com.ess.webpad.client.view.WindowedView;

/**
 * Defines the contract of a login view implementation
 *
 * Created On Jan 14, 2017
 * @author Jonathan Miller
 */
public interface LoginView extends WindowedView {
		
	public void setUsername(String username);
	
	public String getUsername();
	
	public void setPassword(String password);
	
	public String getPassword();
	
	public void setLoginViewListener(LoginViewListener loginViewListener);
	
	public LoginViewListener getLoginViewListener();
		
}
