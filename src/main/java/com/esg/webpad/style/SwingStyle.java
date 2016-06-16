package com.esg.webpad.style;

import javax.swing.LookAndFeel;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;
import javax.swing.UnsupportedLookAndFeelException;

import org.apache.log4j.Logger;

import com.esg.webpad.service.SettingsService;
import com.esg.webpad.service.SettingsServiceImpl;
import com.esg.webpad.service.SettingsService.Setting;
import com.esg.webpad.view.SwingApplicationFrame;

public enum SwingStyle {
	
	INSTANCE;
	
	private Logger logger = Logger.getLogger(SwingStyle.class);
	private SettingsService settingsService = SettingsServiceImpl.INSTANCE;
	private Style[] styles;
	
	private SwingStyle() {
		final LookAndFeelInfo[] infos = UIManager.getInstalledLookAndFeels();
		styles = new Style[infos.length];
		for(int i = 0; i < infos.length; i++) {
			final LookAndFeelInfo info = infos[i];
			styles[i] = new Style() {
				@Override
				public String getName() {
					return info.getName();
				}
				@Override
				public void apply() {
					 try {
						 	UIManager.setLookAndFeel(info.getClassName());
					        SwingUtilities.updateComponentTreeUI(SwingApplicationFrame.INSTANCE.getContainer());
					        settingsService.setSetting(Setting.SWING_STYLE, info.getClassName());
					    } catch (UnsupportedLookAndFeelException e) {
					    	logger.error(e);
					    } catch (ClassNotFoundException e) {
					    	logger.error(e);
						} catch (InstantiationException e) {
					    	logger.error(e);
						} catch (IllegalAccessException e) {
					    	logger.error(e);
						}
				}
			};
		}
		
	}
	
	public Style[] getStyles() {
		return styles;
	}
	
	public Style getStyle(String location) {
		LookAndFeel lookAndFeel = UIManager.getLookAndFeel();
		for(Style style : styles) {
			System.out.println(style.getName() + " " + lookAndFeel.getName());
			if(style.getName().equals(lookAndFeel.getName()))
				return style;
		}
		
		return styles[0];
	}
		
}
