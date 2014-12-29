package gui.swinggui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import net.sourceforge.jdatepicker.impl.JDatePanelImpl;
import net.sourceforge.jdatepicker.impl.JDatePickerImpl;
import net.sourceforge.jdatepicker.impl.UtilDateModel;
import template_input.TemplateEnumerator;
import java.awt.Font;

public class CreateEventPanel extends JPanel {
	private JTextField textField;
	private JFileChooser fc = new JFileChooser();
	private JComboBox comboBox;

	private JButton btnCreateEvent;
	
	public CreateEventPanel( final TemplateEnumerator TempEnum ) {
		
		UtilDateModel model = new UtilDateModel();
		JDatePanelImpl datePanel = new JDatePanelImpl(model);
		setLayout(null);
		JDatePickerImpl datePicker = new JDatePickerImpl(datePanel);
		datePicker.setBounds(150, 240, 202, 25);

		
		add( datePicker );
		
		btnCreateEvent = new JButton( "Create Event" );
		btnCreateEvent.setBounds(191, 327, 142, 25);
		
		btnCreateEvent.addActionListener( new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				
			}
			
		});
		

		add( btnCreateEvent );
		
		JLabel lblTest = new JLabel("Name:");
		lblTest.setBounds(57, 176, 45, 15);
		add(lblTest);
		
		JLabel lblDate = new JLabel("Date:");
		lblDate.setBounds(57, 252, 39, 15);
		add(lblDate);
		
		JLabel lblType = new JLabel("Type:");
		lblType.setBounds(57, 103, 39, 15);
		add(lblType);
		
		textField = new JTextField();
		textField.setBounds(150, 170, 202, 27);
		add(textField);
		textField.setColumns(10);
		
		comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel( TempEnum.GetDescStringArray() ));
		comboBox.setSelectedIndex(0);
		comboBox.setBounds(150, 98, 202, 25);
		
		comboBox.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				textField.setText( TempEnum.GetStringAt(comboBox.getSelectedIndex()) );
			}
			
		});
		
		add(comboBox);
		
		JLabel lblCreateANew = new JLabel("Create a new event schedule");
		lblCreateANew.setFont(new Font("Dialog", Font.BOLD, 16));
		lblCreateANew.setBounds(46, 27, 287, 33);
		add(lblCreateANew);
	
		
	}
}
