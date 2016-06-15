package com.esg.webpad.view;

import java.awt.BorderLayout;

import javax.swing.JPanel;

import org.apache.log4j.Logger;

/**
 * Allows injection of Swing content
 * into the application frame
 *
 * Created on Jun 15, 2016 11:08:32 AM
 * @author Jonathan Miller
 */
public enum SwingContentInjector implements ContentInjector<JPanel> {
	
	INSTANCE;
	
	private Logger logger = Logger.getLogger(SwingContentInjector.class);
	
	private SwingContentInjector() {
		logger.info("Creating swing content injector");
	}
	
	@Override
	public void inject(JPanel content) {
		logger.info("Injecting new content");
		JPanel pnlMain = SwingApplicationFrame.INSTANCE.getContainer();
		pnlMain.add(content, BorderLayout.CENTER);
		pnlMain.invalidate();
		pnlMain.validate();
		pnlMain.repaint();
	}
	

}
