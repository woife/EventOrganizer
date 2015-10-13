package gui.swinggui;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SpinnerDateModel;

import net.sourceforge.jdatepicker.impl.JDatePanelImpl;
import net.sourceforge.jdatepicker.impl.JDatePickerImpl;
import net.sourceforge.jdatepicker.impl.UtilDateModel;
import template_input.TemplateEnumerator;
import event_handling.EventSchedule;
import event_handling.EventTemplate;

public class CreateEventPanel extends JPanel {
	private JTextField eventName;
	private JFileChooser fc = new JFileChooser();
	private JComboBox eventType;
	private UtilDateModel utilModel;

	private JButton btnCreateEvent;
	
	private SpinnerDateModel sp;
	
	private Boolean	typeSelected;
	private Boolean	dateSelected;
	
	public CreateEventPanel( final TemplateEnumerator TempEnum ) {

		typeSelected = false;
		dateSelected = false;
		
		setLayout(null);
		
		// Headline
		JLabel lblCreateANew = new JLabel("Create a new event schedule");
		lblCreateANew.setFont(new Font("Dialog", Font.BOLD, 16));
		lblCreateANew.setBounds(46, 27, 287, 33);
		add(lblCreateANew);
		
		// Date picker
		utilModel = new UtilDateModel();
		JDatePanelImpl datePanel = new JDatePanelImpl(utilModel);
		JDatePickerImpl datePicker = new JDatePickerImpl(datePanel);
		datePicker.setBounds(150, 240, 202, 25);
		
		datePicker.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent arg0) {
				
				dateSelected = true;
				
				CheckEnableCreate();				
			}			
		});
		
		add( datePicker );
		
		JLabel lblTest = new JLabel("Name:");
		lblTest.setBounds(57, 176, 45, 15);
		add(lblTest);
		
		JLabel lblDate = new JLabel("Date:");
		lblDate.setBounds(57, 252, 39, 15);
		add(lblDate);
		
		JLabel lblType = new JLabel("Type:");
		lblType.setBounds(57, 103, 39, 15);
		add(lblType);

		eventType = new JComboBox();
		eventType.setModel(new DefaultComboBoxModel( TempEnum.GetDescStringArray() ));
		eventType.setSelectedIndex(0);
		eventType.setBounds(150, 98, 202, 25);
		
		eventType.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent arg0) {
				eventName.setText( TempEnum.GetStringAt(eventType.getSelectedIndex()) );
				
				typeSelected = true;
				
				CheckEnableCreate();				
			}			
		});
		
		add(eventType);
		
		eventName = new JTextField();
		eventName.setBounds(150, 170, 202, 27);
		add(eventName);
		eventName.setColumns(10);
		
		btnCreateEvent = new JButton( "Create Event" );
		btnCreateEvent.setBounds(191, 327, 142, 25);
		
		btnCreateEvent.setEnabled( false );
		
		btnCreateEvent.addActionListener( new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent arg0) {

				EventTemplate 	template 	= TempEnum.GetTemplateList().elementAt( eventType.getSelectedIndex() );
				Date			eventDate	= utilModel.getValue();
				EventSchedule 	schedule 	= new EventSchedule( eventName.getText(), template, eventDate );
				
				EventScheduleDialog scheduleDialog = new EventScheduleDialog( schedule );
				scheduleDialog.setVisible(true);
			}			
		});		

		add( btnCreateEvent );
	}
	
	public void CheckEnableCreate()
	{
		if( typeSelected && dateSelected )
		{
			btnCreateEvent.setEnabled( true );
		}
	}
}
