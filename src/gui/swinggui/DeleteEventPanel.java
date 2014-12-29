package gui.swinggui;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class DeleteEventPanel extends JPanel {

	/**
	 * Create the panel.
	 */
	public DeleteEventPanel() {
		setLayout(null);
		
		JLabel lblDeleteAnExisting = new JLabel("Delete an existing event schedule");
		lblDeleteAnExisting.setBounds(50, 43, 326, 25);
		lblDeleteAnExisting.setFont(new Font("Dialog", Font.BOLD, 16));
		add(lblDeleteAnExisting);
		
		JButton b = new JButton( "Delete" );
		b.setBounds(277, 221, 81, 25);

		add( b );
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Stefaniball 2014", "Zechversammlung Mai 2015", "Nikolaus 2015", "Stefaniball 2015"}));
		comboBox.setBounds(74, 135, 284, 25);
		add(comboBox);
		
		JLabel lblSelectEvent = new JLabel("Select event:");
		lblSelectEvent.setBounds(50, 98, 175, 25);
		add(lblSelectEvent);
		
	}
}
