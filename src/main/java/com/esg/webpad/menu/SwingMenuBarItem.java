package com.esg.webpad.menu;

import com.esg.webpad.service.SettingsService;
import com.esg.webpad.service.SettingsServiceImpl;
import com.esg.webpad.service.SettingsService.Setting;

public enum SwingMenuBarItem implements SelectableMenuBarItem {
	
	INSTANCE;

	private SettingsService settingsService = SettingsServiceImpl.INSTANCE;
	
	@Override
	public String getDisplayName() {
		return "Swing";
	}

	@Override
	public MenuBarItem[] getChildren() {
		return new MenuBarItem[]{};
	}

	@Override
	public void onAction() {
		settingsService.setSetting(Setting.UI_FRAMEWORK, "Swing");
	}

	@Override
	public boolean isSelected() {
		return settingsService.getSetting(Setting.UI_FRAMEWORK).equals("Swing");
	}

}
