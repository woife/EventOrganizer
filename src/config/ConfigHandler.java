package config;

public class ConfigHandler {

	AccountConfig	gmailConfig;
	
	public String getGmailLogin() {
		return gmailConfig.getLoginName();
	}
	
	public String getGmailPwd() {
		return gmailConfig.getPassword();
	}
	
	public void setGmailLogin( String LoginName ) {
		gmailConfig.setLoginName( LoginName );
	}
	
	public void setGmailPwd( String password ) {
		gmailConfig.setPassword( password );
	}
	
	public void saveGmailConfig(){
		gmailConfig.Save();
	}

	public ConfigHandler() {

		gmailConfig = new AccountConfig( "config/accounts/gmail.com.txt" );
		
	}
}
