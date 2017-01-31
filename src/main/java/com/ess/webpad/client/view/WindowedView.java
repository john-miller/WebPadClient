package com.ess.webpad.client.view;

public interface WindowedView {

	public void displayInWindow();
	
	public void closeWindow();
	
	public String getTitle();
	
	public void setTitle(String title);
	
	public void setDimension(double width, double height);
	
	public void setWindowedViewListener(WindowedViewListener windowedViewListener);
	
	public WindowedViewListener getWindowedViewListener();
}
