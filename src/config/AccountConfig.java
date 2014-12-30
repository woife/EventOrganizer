package config;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class AccountConfig {

	private	String loginName;
	private String password;
	private String Filename;
	
	public AccountConfig( String Filename ) {
		
		this.Filename = Filename;
		
		Reload();
	}
	
	public void	Reload()
	{
		BufferedReader br = null;
		 
		try {
 
			String sCurrentLine;
 
			br = new BufferedReader(new FileReader( Filename ));

			if((sCurrentLine = br.readLine()) != null)
			{
				loginName = sCurrentLine;
			}
			
			if((sCurrentLine = br.readLine()) != null)
			{
				password = sCurrentLine;				
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
	
	public void Save()
	{
		File file = new File( Filename );
		
		try {
			// if file doesnt exists, then create it
			if (!file.exists()) {
				file.createNewFile();
			}
 
			FileWriter fw = new FileWriter(file.getAbsoluteFile());
			BufferedWriter bw = new BufferedWriter(fw);
			
			bw.write( loginName );
			bw.newLine();
			bw.write( password );
			bw.newLine();					
			
			bw.close();
		}
		catch (IOException e) {
			e.printStackTrace();
		}
	}

	public String getLoginName() {
		return loginName;
	}

	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}
