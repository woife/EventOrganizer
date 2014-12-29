package gui.swinggui;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class HomePanel extends JPanel {

	public HomePanel() {;
		
		JButton btnCreateEvent = new JButton("Create Event");
		btnCreateEvent.setBounds(230, 0, 220, 145);
		btnCreateEvent.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				
//				getContentPane().
				
			}
		});
		setLayout(null);
		
		JLabel txtInfo = new JLabel( "This is some text" );
		txtInfo.setBounds(25, 0, 170, 56);
		add(txtInfo);
		add(btnCreateEvent);
		
		
		JButton btnDeleteEvent = new JButton("Delete Event");
		btnDeleteEvent.setBounds(0, 155, 220, 145);
		add(btnDeleteEvent);

	}

}
