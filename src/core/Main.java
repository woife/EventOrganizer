package core;

import gui.IGUI;
import gui.swinggui.SwingGui;

import java.io.IOException;

import template_input.TemplateEnumerator;

public class Main {

	static TemplateEnumerator TempEnum;
	
	public static void main(String[] args) throws IOException {
		
		TempEnum = new TemplateEnumerator();
		
		IGUI gui = new SwingGui();
		
		gui.Show( TempEnum );

	}

}
