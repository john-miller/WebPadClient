package com.esg.webpad.menu;

import com.esg.webpad.service.SettingsService;
import com.esg.webpad.service.SettingsServiceImpl;
import com.esg.webpad.service.SettingsService.Setting;

public enum JavaFXMenuBarItem implements SelectableMenuBarItem {
	
	INSTANCE;

	private SettingsService settingsService = SettingsServiceImpl.INSTANCE;
	
	@Override
	public String getDisplayName() {
		return "JavaFX";
	}

	@Override
	public MenuBarItem[] getChildren() {
		return new MenuBarItem[]{};
	}

	@Override
	public void onAction() {
		settingsService.setSetting(Setting.UI_FRAMEWORK, "JavaFX");
	}

	@Override
	public boolean isSelected() {
		return settingsService.getSetting(Setting.UI_FRAMEWORK).equals("JavaFX");
	}

}
