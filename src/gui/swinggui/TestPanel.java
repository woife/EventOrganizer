package gui.swinggui;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.JToolBar;

public class TestPanel extends JPanel {

	/**
	 * Create the panel.
	 */
	public TestPanel() {
		
		JToolBar toolBar = new JToolBar();
		add(toolBar);
		
		JButton btnNewButton = new JButton("Press this button");
		add(btnNewButton);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"test1", "test2"}));
		add(comboBox);

	}

}
