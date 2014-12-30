package gui.swinggui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.ScrollPaneConstants;
import javax.swing.SpinnerDateModel;
import javax.swing.border.EmptyBorder;

import net.sourceforge.jdatepicker.impl.JDatePanelImpl;
import net.sourceforge.jdatepicker.impl.JDatePickerImpl;
import net.sourceforge.jdatepicker.impl.UtilDateModel;
import event_handling.AbsoluteToDo;
import event_handling.EventSchedule;

public class EventScheduleDialog extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JScrollPane scrollPane;
	
	private SpinnerDateModel sp;

	public EventScheduleDialog( EventSchedule schedule )
	{
		setBounds(100, 100, 1000, 500);
		
		getContentPane().setLayout(null);
		
		// --------------------------------------------------------
		// Content Pane
		// --------------------------------------------------------
		contentPanel.setBounds(0, 0, 1000, 400);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPanel.setLayout(new BorderLayout());
		
		getContentPane().add(contentPanel);
		
		// Schedule Pane
		JPanel schedulePanel = new JPanel();

		schedulePanel.setLayout( null );
		
		JLabel lblName;
		JLabel lblDesc;
		JLabel lblDate;
		JLabel lblTime;
		
		int LineIdx = 0;

		int	AbsPosX		= 10;
		int	AbsPosY		= 10;
		int	LineHeight 	= 30;
		
		int	SpaceX		= 10;
		int SpaceY		= 10;
		
		int	DateWidth	= 150;
		int	TimeWidth	= 70;
		int	NameWidth	= 300;
		int	DescWidth	= 500;
		
		int	DatePosX	= AbsPosX;
		int	TimePosX	= DatePosX + DateWidth + SpaceX;
		int	NamePosX	= TimePosX + TimeWidth + SpaceX;
		int	DescPosX	= NamePosX + NameWidth + SpaceX;
		
		int	PosY;

		for( AbsoluteToDo todo : schedule.getToDos() )
		{
			// Date picker
			UtilDateModel	model 		= new UtilDateModel( todo.getDateTime().toDate() );
			JDatePanelImpl 	datePanel 	= new JDatePanelImpl(model);
			JDatePickerImpl datePicker 	= new JDatePickerImpl(datePanel);
			
			// Time picker
			sp = new SpinnerDateModel();
			JSpinner timeSpinner = new JSpinner( sp );
			JSpinner.DateEditor timeEditor = new JSpinner.DateEditor(timeSpinner, "HH:mm");
			timeSpinner.setEditor(timeEditor);
			timeSpinner.setValue( todo.getDateTime().toDate() );
			
			if( todo.isAllDay() )
			{
				timeSpinner.setEnabled( false );
			}
			
			lblName = new JLabel( todo.getName() );
			lblDesc = new JLabel( todo.getDescription() );
			
			// Position elements
			PosY		= AbsPosY + LineIdx * (LineHeight + SpaceY);
			
			datePicker.setBounds( DatePosX, PosY, DateWidth, LineHeight );
			timeSpinner.setBounds( TimePosX, PosY, TimeWidth, LineHeight );
			lblName.setBounds( NamePosX, PosY, NameWidth, LineHeight );
			lblDesc.setBounds( DescPosX, PosY, DescWidth, LineHeight );

			schedulePanel.add( datePicker );
			schedulePanel.add( timeSpinner );
			schedulePanel.add( lblName );
			schedulePanel.add( lblDesc );
			
			LineIdx ++;
		}
		
		int Width		= AbsPosX + DescPosX + DescWidth + SpaceX;
		int Height		= AbsPosY + LineIdx * (LineHeight + SpaceY);
				
		schedulePanel.setPreferredSize( new Dimension( Width, Height ) );		
		
		// Scroll pane
		scrollPane = new JScrollPane( schedulePanel );
		
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		
		scrollPane.setPreferredSize( schedulePanel.getPreferredSize() );
		
		contentPanel.add(scrollPane, BorderLayout.CENTER);

		// --------------------------------------------------------
		// Button Pane
		// --------------------------------------------------------
		JPanel buttonPane = new JPanel();
		buttonPane.setBounds(0, 400, 448, 35);
		buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
		getContentPane().add(buttonPane);
		{
			JButton okButton = new JButton("OK");
			okButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					dispose();
				}
			});
			okButton.setActionCommand("OK");
			buttonPane.add(okButton);
			getRootPane().setDefaultButton(okButton);
		}
	}
}
