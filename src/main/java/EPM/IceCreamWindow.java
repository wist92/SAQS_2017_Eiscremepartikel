package EPM;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.border.EtchedBorder;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.util.Observable;
import java.util.Observer;

public class IceCreamWindow implements Observer{

	private JFrame frmIcecremeParticleObservation;
	private JTextField textFieldLabel;
	private JTextField textFieldDate;
	private JTextField textFieldTarget;
	private JTextField textFieldActual;
	private JTextField textFieldVariance;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					IceCreamWindow window = new IceCreamWindow();
					window.frmIcecremeParticleObservation.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public IceCreamWindow() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmIcecremeParticleObservation = new JFrame();
		frmIcecremeParticleObservation.setTitle("Icecreme Particle Observation");
		frmIcecremeParticleObservation.setBounds(100, 100, 649, 256);
		frmIcecremeParticleObservation.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmIcecremeParticleObservation.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panel.setBounds(306, 11, 314, 156);
		frmIcecremeParticleObservation.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblStationId = new JLabel("Station ID");
		lblStationId.setBounds(22, 11, 81, 14);
		panel.add(lblStationId);
		
		JLabel lblDate = new JLabel("Date");
		lblDate.setBounds(22, 36, 81, 14);
		panel.add(lblDate);
		
		JLabel lblTarget = new JLabel("Target");
		lblTarget.setBounds(22, 61, 81, 14);
		panel.add(lblTarget);
		
		JLabel lblActual = new JLabel("Actual");
		lblActual.setBounds(22, 86, 81, 14);
		panel.add(lblActual);
		
		JLabel lblVariance = new JLabel("Variance");
		lblVariance.setBounds(22, 111, 81, 14);
		panel.add(lblVariance);
		
		textFieldLabel = new JTextField();
		textFieldLabel.setBounds(113, 8, 191, 20);
		panel.add(textFieldLabel);
		textFieldLabel.setColumns(10);
		
		textFieldDate = new JTextField();
		textFieldDate.setColumns(10);
		textFieldDate.setBounds(113, 33, 191, 20);
		panel.add(textFieldDate);
		
		textFieldTarget = new JTextField("42");
		textFieldTarget.setEditable(false);
		textFieldTarget.setColumns(10);
		textFieldTarget.setBounds(113, 58, 191, 20);
		panel.add(textFieldTarget);
		
		textFieldActual = new JTextField("33");
		textFieldActual.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent arg0) {
				try {
					Integer.parseInt(textFieldActual.getText());
					System.out.println(Double.parseDouble(textFieldActual.getText()) / Double.parseDouble(textFieldTarget.getText()) * 100);
					if(Double.parseDouble(textFieldActual.getText()) / Double.parseDouble(textFieldTarget.getText()) * 100 <= 90)
						textFieldVariance.setForeground(Color.RED);
					else if(Double.parseDouble(textFieldActual.getText()) / Double.parseDouble(textFieldTarget.getText()) * 100 >= 105)
						textFieldVariance.setForeground(Color.GREEN);
					else
						textFieldVariance.setForeground(Color.BLACK);
					textFieldVariance.setText("" + (Integer.parseInt(textFieldActual.getText()) - Integer.parseInt(textFieldTarget.getText())));
				} catch (NumberFormatException nfe) {
					JOptionPane.showMessageDialog(frmIcecremeParticleObservation, "Wrong Format", "Error", JOptionPane.ERROR_MESSAGE);
					textFieldActual.requestFocus();
				}
			}
		});
		textFieldActual.setColumns(10);
		textFieldActual.setBounds(113, 83, 191, 20);
		panel.add(textFieldActual);
		
		textFieldVariance = new JTextField("" + (Integer.parseInt(textFieldActual.getText()) - Integer.parseInt(textFieldTarget.getText())));
		textFieldVariance.setEditable(false);
		textFieldVariance.setColumns(10);
		textFieldVariance.setBounds(113, 108, 191, 20);
		
		System.out.println(Double.parseDouble(textFieldActual.getText()) / Double.parseDouble(textFieldTarget.getText()) * 100);
		if(Double.parseDouble(textFieldActual.getText()) / Double.parseDouble(textFieldTarget.getText()) * 100 <= 90)
			textFieldVariance.setForeground(Color.RED);
		else if(Double.parseDouble(textFieldActual.getText()) / Double.parseDouble(textFieldTarget.getText()) * 100 >= 105)
			textFieldVariance.setForeground(Color.GREEN);
		else
			textFieldVariance.setForeground(Color.BLACK);
		panel.add(textFieldVariance);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setBounds(10, 11, 286, 196);
		frmIcecremeParticleObservation.getContentPane().add(scrollPane);
		
		JList list = new JList();
		scrollPane.setViewportView(list);
		
		DefaultListModel listModel;
		listModel = new DefaultListModel();
		listModel.addElement("item 1");
		listModel.addElement("item 2");
		
		list.setModel(listModel);
		
		JButton btnAddStation = new JButton("Add Station");
		btnAddStation.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnAddStation.setBounds(306, 178, 115, 29);
		frmIcecremeParticleObservation.getContentPane().add(btnAddStation);
	}

	public void update(Observable arg0, Object arg1) {
		// TODO Auto-generated method stub
		
	}
}
