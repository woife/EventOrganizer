package gui.swinggui;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.KeyStroke;

import config.ConfigHandler;
import template_input.TemplateEnumerator;

public class MainFrame extends JFrame {
	
	WorkBenchPanel wb;
	
	public MainFrame( String title, TemplateEnumerator tempEnum, ConfigHandler configHandler ) {
		super( title );
		
		// Create components
		wb = new WorkBenchPanel( tempEnum, configHandler );
		
		// Add components to content pane
		Container c = getContentPane();
		
		c.setLayout(new BoxLayout(c, BoxLayout.Y_AXIS));
		
		c.add( wb );
				
		// Menu
		JMenuBar 	menuBar;
		JMenu 		menu;
		JMenuItem 	menuItem;

		// Create the menu bar
		menuBar = new JMenuBar();

		// File menu
		menu = new JMenu("Event");
		menu.setMnemonic(KeyEvent.VK_E);
		menuBar.add(menu);

		menuItem = new JMenuItem("Create event");
		menuItem.setMnemonic(KeyEvent.VK_C);
		menuItem.addActionListener( new ActionListener() { public void actionPerformed(ActionEvent e) {
															            	wb.showCreateEventPanel();
															            } });
		menu.add(menuItem);

		menuItem = new JMenuItem("Delete event");
		menuItem.setMnemonic(KeyEvent.VK_D);
		menuItem.addActionListener( new ActionListener() {	public void actionPerformed(ActionEvent e) {
															            	wb.showDeleteEventPanel();
															            } });
		menu.add(menuItem);
		
		menu.addSeparator();
		
		menuItem = new JMenuItem("Preferences");
		menuItem.setMnemonic(KeyEvent.VK_P);
		menuItem.addActionListener( new ActionListener() {	public void actionPerformed(ActionEvent e) {
															            	wb.showConfigPanel();
															            } });
		menu.add(menuItem);
		
		menu.addSeparator();
		
		menuItem = new JMenuItem("Exit");
		menuItem.setMnemonic(KeyEvent.VK_E);
		menuItem.addActionListener( new ActionListener() { public void actionPerformed(ActionEvent e) {
															            	System.exit(0);
															            } });		
		menu.add(menuItem);


		// Help menu
		menu = new JMenu("Help");
		menu.setMnemonic(KeyEvent.VK_H);

		menuItem = new JMenuItem("About" );
		menuItem.setMnemonic(KeyEvent.VK_A);
		menuItem.addActionListener( new ActionListener() { public void actionPerformed(ActionEvent e) {
			AboutDialog aboutDialog = new AboutDialog();
			aboutDialog.setVisible(true);
        } });
		
		
		
		menu.add(menuItem);
		
		menuBar.add(menu);

		setJMenuBar(menuBar);
		
		
		
		setPreferredSize( new Dimension( 500, 500 ));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
//        setIconImage(new ImageIcon("/images/Beer.png").getImage());
        setIconImage(Toolkit.getDefaultToolkit().getImage("src/images/Beer.png"));
        
//      setIconImage(new ImageIcon(imgURL).getImage());

        pack();
        
	}
}
