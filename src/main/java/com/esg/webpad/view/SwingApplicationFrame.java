package com.esg.webpad.view;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import org.apache.log4j.Logger;

import com.esg.webpad.menu.MenuBarItem;
import com.esg.webpad.service.SettingsService;
import com.esg.webpad.service.SettingsServiceImpl;
import com.esg.webpad.service.SettingsService.Setting;


public enum SwingApplicationFrame implements ApplicationFrame<JPanel> {
	
	INSTANCE;
	
	private JFrame frame;
	private JPanel pnlMain = new JPanel(new BorderLayout());
	private JMenuBar menuBar = new JMenuBar();
	private SettingsService settingsService = SettingsServiceImpl.INSTANCE;
	private Logger logger = Logger.getLogger(SwingApplicationFrame.class);
	
	private SwingApplicationFrame() {
		frame = new JFrame("ESG Notepad");
		pnlMain.add(menuBar, BorderLayout.NORTH);
		frame.add(pnlMain);
		frame.setIconImage(new ImageIcon(SwingApplicationFrame.class.getResource("/images/icon-web.png")).getImage());
		try {
			UIManager.setLookAndFeel(settingsService.getSetting(Setting.SWING_STYLE));
			SwingUtilities.updateComponentTreeUI(frame);
		} catch (ClassNotFoundException e) {
			logger.error("Could not load style", e);
		} catch (InstantiationException e) {
			logger.error("Could not load style", e);
		} catch (IllegalAccessException e) {
			logger.error("Could not load style", e);
		} catch (UnsupportedLookAndFeelException e) {
			logger.error("Could not load style", e);
		}
	}

	@Override
	public void display() {
		frame.setSize(500, 500);
		frame.setVisible(true);
	}

	@Override
	public JPanel getContainer() {
		return pnlMain;
	}

	@Override
	public void setMenuBarItems(MenuBarItem... items) {
		for(MenuBarItem item : items)
			menuBar.add(addMenuBarItems(item));
	}
	
	private JMenuItem addMenuBarItems(final MenuBarItem item) {
		/* Check for children */
		if(item.getChildren() != null && item.getChildren().length > 0) {
			JMenu menu = new JMenu(item.getDisplayName());
			for(MenuBarItem childItem : item.getChildren())
				menu.add(addMenuBarItems(childItem));
			return menu;
		} else {
			
			JMenuItem menu = new JMenuItem(item.getDisplayName());
			
			/* When menu item it clicked the item action will be triggered */
			menu.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					item.onAction();
				}
			});
				
			return menu;
		}
	}
	

}
