package gui.swinggui;

import gui.IGUI;

import java.util.Properties;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import template_input.TemplateEnumerator;

import com.jtattoo.plaf.hifi.HiFiLookAndFeel;

public class SwingGui implements IGUI {
	
	public void Show( final TemplateEnumerator TempEnum ) {
		
		SwingUtilities.invokeLater(new Runnable() {
            public void run() 
            {
            	// Set Look & Feel
            	// Look & Feel is based on JTattoo
            	// URL: http://www.jtattoo.net
            	try 
            	{
            		Properties props = new Properties();
            		props.put("logoString", "EventOrganizer");
            		HiFiLookAndFeel.setCurrentTheme(props);
            		
            		
            		UIManager.setLookAndFeel( UIManager.getCrossPlatformLookAndFeelClassName() );
            		
            		UIManager.setLookAndFeel("com.jtattoo.plaf.hifi.HiFiLookAndFeel");
//            		UIManager.setLookAndFeel("com.jtattoo.plaf.acryl.AcrylLookAndFeel");
//            		UIManager.setLookAndFeel("com.jtattoo.plaf.mcwin.McWinLookAndFeel");
	            } 
	            catch (UnsupportedLookAndFeelException e) {
	               // handle exception
	            }
	            catch (ClassNotFoundException e) {
	               // handle exception
	            }
	            catch (InstantiationException e) {
	               // handle exception
	            }
	            catch (IllegalAccessException e) {
	               // handle exception
	            }
            	
                JFrame frame = new MainFrame( "EventOrganizer", TempEnum );
                
                frame.setVisible(true);
            }
        });
		
	}

}
