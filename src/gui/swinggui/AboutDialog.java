package gui.swinggui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AboutDialog extends JDialog {

	private final JPanel contentPanel = new JPanel();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			AboutDialog dialog = new AboutDialog();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public AboutDialog() {
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JLabel lblEventOrganizer = new JLabel("Event Organizer");
			lblEventOrganizer.setFont(new Font("Dialog", Font.BOLD, 16));
			lblEventOrganizer.setBounds(55, 12, 196, 15);
			contentPanel.add(lblEventOrganizer);
		}
		{
			JLabel lblAToolTo = new JLabel("A tool to create ToDo lists for recurring events.");
			lblAToolTo.setBounds(55, 69, 334, 15);
			contentPanel.add(lblAToolTo);
		}
		
		JTextArea txtrCopyrightZechePischelsdorflicense = new JTextArea();
		txtrCopyrightZechePischelsdorflicense.setEditable(false);
		txtrCopyrightZechePischelsdorflicense.setText("Copyright:\tZeche Pischelsdorf\nLicense:\tGPL\n\nThe most recent verstion can be found on:");
		txtrCopyrightZechePischelsdorflicense.setBounds(55, 112, 334, 67);
		contentPanel.add(txtrCopyrightZechePischelsdorflicense);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
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
}
