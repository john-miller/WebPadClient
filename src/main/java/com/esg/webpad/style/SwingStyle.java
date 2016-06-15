package com.esg.webpad.style;

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
	
	public Style[] getStyles() {
		final LookAndFeelInfo[] infos = UIManager.getInstalledLookAndFeels();
		Style[] styles = new Style[infos.length];
		
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
		
		return styles;
	}
		
}
