package gui.swinggui;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextArea;

public class ConfigPanel extends JPanel {
	private JPasswordField gmailPwd;
	private JTextArea gmailAccount;
	
	public ConfigPanel() {
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
				
				File file = new File("config/accounts/gmail.com.txt");
				
				try {
					// if file doesnt exists, then create it
					if (!file.exists()) {
						file.createNewFile();
					}
		 
					FileWriter fw = new FileWriter(file.getAbsoluteFile());
					BufferedWriter bw = new BufferedWriter(fw);
					
					bw.write( gmailAccount.getText() );
					bw.newLine();
					bw.write( gmailPwd.getPassword() );
					bw.newLine();					
					
					bw.close();
				}
				catch (IOException e) {
					e.printStackTrace();
				}
			}
		});
		btnSave.setBounds(278, 152, 68, 25);
		add(btnSave);
		
		// Try to read config file
		BufferedReader br = null;
		 
		try {
 
			String sCurrentLine;
 
			br = new BufferedReader(new FileReader("config/accounts/gmail.com.txt"));

			if((sCurrentLine = br.readLine()) != null)
			{
				gmailAccount.setText( sCurrentLine );
			}
			
			if((sCurrentLine = br.readLine()) != null)
			{
				gmailPwd.setText( sCurrentLine );
			}
		} catch (IOException e) {
			// Ignore non-existing account file
		} finally {
			try {
				if (br != null)br.close();
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}
		

	}
}
