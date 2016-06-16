package com.esg.webpad.view;

import java.awt.BorderLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import org.apache.log4j.Logger;

import com.esg.webpad.menu.IconableItem;
import com.esg.webpad.menu.MenuBarItem;
import com.esg.webpad.menu.SelectableMenuBarItem;
import com.esg.webpad.service.SettingsService;
import com.esg.webpad.service.SettingsService.Setting;
import com.esg.webpad.service.SettingsServiceImpl;


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
			
			if(item instanceof IconableItem)
				applyIcon(menu, (IconableItem) item);
			
			return menu;
		} else {
			
			JMenuItem menu;
			
			if(item instanceof SelectableMenuBarItem) {
				menu = new JCheckBoxMenuItem(item.getDisplayName());
				menu.setSelected(((SelectableMenuBarItem) item).isSelected());
			} else {
				menu = new JMenuItem(item.getDisplayName());
			}
			
			if(item instanceof IconableItem)
				applyIcon(menu, (IconableItem) item);
			
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
	
	private void applyIcon(JMenuItem menu, IconableItem iconable) {
		ImageIcon icon = new ImageIcon(SwingApplicationFrame.class.getResource(iconable.getImageLocation()));
		Image img = icon.getImage();
		menu.setIcon(new ImageIcon(img.getScaledInstance(16, 16, java.awt.Image.SCALE_SMOOTH)));
	}
	

}
