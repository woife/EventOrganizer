package gui.swinggui;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextArea;

import config.ConfigHandler;

public class ConfigPanel extends JPanel {
	private JPasswordField gmailPwd;
	private JTextArea gmailAccount;
	
	public ConfigPanel( final ConfigHandler configHandler ) {
		setLayout(null);
		
		JLabel lblPreferences = new JLabel("Preferences");
		lblPreferences.setBounds(20, 27, 171, 25);
		lblPreferences.setFont(new Font("Dialog", Font.BOLD, 16));
		add(lblPreferences);
		
		gmailAccount = new JTextArea();
		gmailAccount.setBounds(20, 125, 250, 20);
		add(gmailAccount);
		
		gmailPwd = new JPasswordField();
		gmailPwd.setBounds(20, 157, 250, 20);
		add(gmailPwd);
		
		JLabel lblGoogleAccount = new JLabel("GMail account:");
		lblGoogleAccount.setBounds(20, 98, 140, 15);
		add(lblGoogleAccount);
		
		JButton btnSave = new JButton("Save");
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				configHandler.setGmailLogin( gmailAccount.getText() );
				configHandler.setGmailPwd( new String( gmailPwd.getPassword() ) ); 
				
				configHandler.saveGmailConfig();
			}
		});
		btnSave.setBounds(278, 152, 68, 25);
		add(btnSave);
		
		gmailAccount.setText( configHandler.getGmailLogin() );
		gmailPwd.setText( configHandler.getGmailPwd() );
	}
}
