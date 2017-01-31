package io.ess.webpad.client.view.login;

/**
 * Allows the presenter to listen to the
 * events generated by the GUI
 *
 * Created On Jan 14, 2017
 * @author Jonathan Miller
 */
public interface LoginViewListener {

	public void cancel();
	
	public void login(String username, String password);
}