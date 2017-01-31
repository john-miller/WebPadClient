package io.ess.webpad.client.view.login;

import io.ess.webpad.client.view.AbstractFXWindowedView;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

/**
 * JavaFX implementation of login view
 *
 * Created On Jan 14, 2017
 * @author Jonathan Miller
 */
public class FXLoginViewImpl extends AbstractFXWindowedView implements LoginView {
	
	@FXML
	private TextField txtUsername;
	
	@FXML
	private TextField txtPassword;
	
	private LoginViewListener loginViewListener;
	
	public void setUsername(String username) {
		txtUsername.setText(username);
	}

	public String getUsername() {
		return txtUsername.getText();
	}

	public void setPassword(String password) {
		txtPassword.setText(password);
	}

	public String getPassword() {
		return txtPassword.getText();
	}

	public void setLoginViewListener(LoginViewListener loginViewListener) {
		this.loginViewListener = loginViewListener;
	}

	public LoginViewListener getLoginViewListener() {
		return loginViewListener;
	}

	@Override
	public String getFXMLDocument() {
		return "/fxml/login-view.fxml";
	}

	@Override
	public void setDimension(double width, double height) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String getCSSLocation() {
		return "/css/login-view.css";
	}

}
