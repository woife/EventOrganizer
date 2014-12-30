package gui.swinggui;

import java.awt.CardLayout;
import java.awt.Dimension;

import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;

import config.ConfigHandler;
import template_input.TemplateEnumerator;

public class WorkBenchPanel extends JPanel {

	CardLayout cl;
	
	public WorkBenchPanel( TemplateEnumerator tempEnum, ConfigHandler configHandler ){
		
		cl = new CardLayout(0, 0);
		
		setLayout( cl );
		
		HomePanel 			homep 		= new HomePanel();
		ConfigPanel 		configp 	= new ConfigPanel( configHandler );
		CreateEventPanel 	cep 		= new CreateEventPanel( tempEnum );
		DeleteEventPanel 	dep 		= new DeleteEventPanel();
		
		add( homep, 	"Home" );
		add( configp,   "Config" );
		add( cep,   	"CreateEvent" );
		add( dep,   	"DeleteEvent" );
		
		//setBorder( BorderFactory.createLineBorder(Color.black) );
		setBorder(BorderFactory.createCompoundBorder(new EmptyBorder(10, 10, 10, 10), new EtchedBorder()));
		
		setPreferredSize(new Dimension(400, 400));
		setMinimumSize(new Dimension(200, 100));
		setMaximumSize(new Dimension(400, 400));
		
		cl.show( this, "CreateEvent");
	}
	
	public void showHomePanel()
	{
		cl.show( this, "Home");
	}
	
	public void showConfigPanel()
	{
		cl.show( this, "Config");
	}
	
	public void showCreateEventPanel()
	{
		cl.show( this, "CreateEvent");
	}
	
	public void showDeleteEventPanel()
	{
		cl.show( this, "DeleteEvent");
	}

}
