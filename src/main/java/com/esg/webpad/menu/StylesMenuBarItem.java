package com.esg.webpad.menu;

import org.apache.log4j.Logger;

import com.esg.webpad.service.SettingsService;
import com.esg.webpad.service.SettingsService.Setting;
import com.esg.webpad.service.SettingsServiceImpl;
import com.esg.webpad.service.UIService;
import com.esg.webpad.style.FXStyle;
import com.esg.webpad.style.Style;
import com.esg.webpad.style.SwingStyle;

public enum StylesMenuBarItem implements MenuBarItem {
	
	INSTANCE;
	
	/* FX or swing style */
	private	Style[] styles = UIService.INSTANCE.isJavaFX() ? FXStyle.INSTANCE.getStyles() : SwingStyle.INSTANCE.getStyles();
	
	/* Settings service */
	private SettingsService settingsService = SettingsServiceImpl.INSTANCE;
	
	private Logger logger = Logger.getLogger(StylesMenuBarItem.class);
		
	private StylesMenuBarItem() {
		logger.info("Styles menu bar item created");
	}
	
	@Override
	public String getDisplayName() {
		return "Styles";
	}

	@Override
	public MenuBarItem[] getChildren() {
		/* Each style will be its own menu bar item */
		SelectableMenuBarItem[] menuBarItems = new SelectableMenuBarItem[styles.length];
		for(int i = 0; i < menuBarItems.length; i++) {
			final Style style = styles[i];
			menuBarItems[i] = new SelectableMenuBarItem() {
				@Override
				public void onAction() {
					style.apply();
				}
				@Override
				public String getDisplayName() {
					return style.getName();
				}
				@Override
				public MenuBarItem[] getChildren() {
					return new MenuBarItem[]{};
				}
				@Override
				public boolean isSelected() {
					if(UIService.INSTANCE.isJavaFX()) {
						return FXStyle.INSTANCE.getStyle(style.getName())
								.equals(FXStyle.INSTANCE.getStyle(settingsService.getSetting(Setting.JAVAFX_STYLE)));
					} else {
						return style.getName()
								.equals(SwingStyle.INSTANCE.getStyle(settingsService.getSetting(Setting.SWING_STYLE)).getName());
					}
				}
			};
		}
		return menuBarItems;
	}

	@Override
	public void onAction() {
		
	}

}
