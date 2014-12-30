package core;

import gui.IGUI;
import gui.swinggui.SwingGui;

import java.io.IOException;

import template_input.TemplateEnumerator;
import config.ConfigHandler;

public class Main {

	static TemplateEnumerator tempEnum;
	static ConfigHandler	  configHandler;
	
	public static void main(String[] args) throws IOException {
		
		tempEnum 		= new TemplateEnumerator();
		configHandler	= new ConfigHandler();
		
		
		IGUI gui = new SwingGui();
		
		gui.Show( tempEnum, configHandler );

	}

}
