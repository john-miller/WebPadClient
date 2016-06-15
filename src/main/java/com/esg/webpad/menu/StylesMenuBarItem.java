package com.esg.webpad.menu;

import com.esg.webpad.service.UIService;
import com.esg.webpad.style.FXStyle;
import com.esg.webpad.style.Style;
import com.esg.webpad.style.SwingStyle;

public enum StylesMenuBarItem implements MenuBarItem {
	
	INSTANCE;
	
	/* FX or swing style */
	private	Style[] styles = UIService.INSTANCE.isJavaFX() ? FXStyle.values() : SwingStyle.INSTANCE.getStyles();
	
	@Override
	public String getDisplayName() {
		return "Styles";
	}

	@Override
	public MenuBarItem[] getChildren() {
		/* Each style will be its own menu bar item */
		MenuBarItem[] menuBarItems = new MenuBarItem[styles.length];
		for(int i = 0; i < menuBarItems.length; i++) {
			final Style style = styles[i];
			menuBarItems[i] = new MenuBarItem() {
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
			};
		}
		return menuBarItems;
	}

	@Override
	public void onAction() {
		
	}

}
