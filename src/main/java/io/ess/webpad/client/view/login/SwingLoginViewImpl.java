package io.ess.webpad.client.view.login;

import javax.swing.JPanel;

import io.ess.webpad.client.view.AbstractSwingWindowedView;

/**
 * Swing implementation of the login view
 *
 * Created On Jan 14, 2017
 * @author Jonathan Miller
 */
public class SwingLoginViewImpl extends AbstractSwingWindowedView implements LoginView {

	private JPanel pnlMain = new JPanel();
	
	public SwingLoginViewImpl() {
		initialize();
	}	
	
	public void setUsername(String username) {
		// TODO Auto-generated method stub
		
	}

	public String getUsername() {
		// TODO Auto-generated method stub
		return null;
	}

	public void setPassword(String password) {
		// TODO Auto-generated method stub
		
	}

	public String getPassword() {
		// TODO Auto-generated method stub
		return null;
	}

	public void setLoginViewListener(LoginViewListener loginViewListener) {
		// TODO Auto-generated method stub
		
	}

	public LoginViewListener getLoginViewListener() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public JPanel getReferencePanel() {
		return pnlMain;
	}



}
