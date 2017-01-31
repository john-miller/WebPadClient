package io.ess.webpad.client.view;

import javax.swing.JFrame;
import javax.swing.JPanel;

public abstract class AbstractSwingWindowedView implements WindowedView {
	
	private JFrame frmMain = new JFrame();
	private WindowedViewListener windowedViewListener;
	
	public void initialize() {
		frmMain.add(getReferencePanel());
		frmMain.pack();
	}
	
	@Override
	public void displayInWindow() {
		frmMain.setVisible(true);
	}

	@Override
	public void closeWindow() {
		frmMain.dispose();
	}

	public void setWindowedViewListener(WindowedViewListener windowedViewListener) {
		this.windowedViewListener = windowedViewListener;
	}

	public WindowedViewListener getWindowedViewListener() {
		return windowedViewListener;
	}
		
	@Override
	public String getTitle() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setTitle(String title) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setDimension(double width, double height) {
		// TODO Auto-generated method stub
		
	}

	public abstract JPanel getReferencePanel();

}
