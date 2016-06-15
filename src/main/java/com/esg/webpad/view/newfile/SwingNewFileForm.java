package com.esg.webpad.view.newfile;

import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import org.apache.log4j.Logger;

import com.esg.webpad.view.SwingContentInjector;

import javafx.fxml.FXML;

public enum SwingNewFileForm implements NewFileForm {
	
	INSTANCE;
	
	private Logger logger = Logger.getLogger(SwingNewFileForm.class);
	private JPanel pnlMain = new JPanel(new GridLayout(4, 2));
	private JLabel lblFileName = new JLabel("Name");
	private JLabel lblFileDescription = new JLabel("Description");
	private JTextField txtFileName = new JTextField();
	private JTextField txtFileDescription = new JTextField();
	
	private SwingNewFileForm() {
		pnlMain.add(lblFileName);
		pnlMain.add(txtFileName);
		pnlMain.add(lblFileDescription);
		pnlMain.add(txtFileDescription);
	}
	
	@Override
	public void display() {
		SwingContentInjector.INSTANCE.inject(pnlMain);
	}
	
	@FXML
	public void create() {
		logger.info("User chose to create new file");
	}
	
	@FXML
	public void cancel() {
		logger.info("User chose to cancel");
	}
	
}
