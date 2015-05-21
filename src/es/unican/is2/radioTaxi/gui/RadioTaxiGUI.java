package es.unican.is2.radioTaxi.gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;

import java.awt.BorderLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JSpinner;
import javax.swing.JRadioButton;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

import es.unican.is2.radioTaxi.ServicioTaxi;

import java.awt.Color;
import java.util.Calendar;
import javax.swing.JComboBox;

public class RadioTaxiGUI {

	private JFrame frame;
	private JTextField tarifa;
	private JTextField kms;
	private JLabel lblHorainicio;
	private JSpinner horaInicio;
	private JSpinner minInicio;

	private JSpinner horaFin;
	private JSpinner minFin;
	private JComboBox diaInicio;
	private JRadioButton aeropuerto;
	private	JRadioButton urbano;
	private JComboBox diaFin;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RadioTaxiGUI window = new RadioTaxiGUI();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public RadioTaxiGUI() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 501, 197);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JButton btnNewButton = new JButton("Calcula tarifa");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Calendar inicio = Calendar.getInstance();
				inicio.set(Calendar.HOUR_OF_DAY, (Integer)horaInicio.getValue());
				inicio.set(Calendar.MINUTE, (Integer)minInicio.getValue());
				inicio.set(Calendar.DAY_OF_WEEK, calculaDiaSemana());
				
				Calendar fin = Calendar.getInstance();
				fin.set(Calendar.HOUR_OF_DAY, (Integer)horaFin.getValue());
				fin.set(Calendar.MINUTE, (Integer)minFin.getValue());
				inicio.set(Calendar.DAY_OF_WEEK, calculaDiaSemana());
				
				
				double kilometros = Double.valueOf(kms.getText());
				ServicioTaxi s = new ServicioTaxi(inicio, fin, kilometros, urbano.isSelected(), aeropuerto.isSelected());
				tarifa.setText(Double.toString(s.importeServicio()));
				
				
			}
		});
		btnNewButton.setBounds(349, 87, 114, 32);
		frame.getContentPane().add(btnNewButton);
		
		tarifa = new JTextField();
		tarifa.setBounds(362, 56, 101, 20);
		frame.getContentPane().add(tarifa);
		tarifa.setColumns(10);
		
		JLabel lblTarifa = new JLabel("Tarifa");
		lblTarifa.setBounds(392, 31, 46, 14);
		frame.getContentPane().add(lblTarifa);
		
		kms = new JTextField();
		kms.setBounds(78, 25, 86, 20);
		frame.getContentPane().add(kms);
		kms.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Kilometros");
		lblNewLabel.setBounds(10, 28, 69, 14);
		frame.getContentPane().add(lblNewLabel);
		
		lblHorainicio = new JLabel("Hora Inicio");
		lblHorainicio.setBounds(10, 59, 58, 14);
		frame.getContentPane().add(lblHorainicio);
		
		horaInicio = new JSpinner();
		horaInicio.setBounds(114, 56, 50, 20);
		frame.getContentPane().add(horaInicio);
		
		JLabel lblHora = new JLabel("hora");
		lblHora.setBounds(78, 59, 46, 14);
		frame.getContentPane().add(lblHora);
		
		JLabel lblHoraFin = new JLabel("Hora Fin");
		lblHoraFin.setBounds(10, 94, 46, 14);
		frame.getContentPane().add(lblHoraFin);
		
		urbano = new JRadioButton("Urbano");
		urbano.setBounds(126, 123, 109, 23);
		frame.getContentPane().add(urbano);
		
		aeropuerto = new JRadioButton("Aeropuerto");
		aeropuerto.setBounds(15, 123, 109, 23);
		frame.getContentPane().add(aeropuerto);
		
		JLabel lblHora_1 = new JLabel("hora");
		lblHora_1.setBounds(78, 94, 46, 14);
		frame.getContentPane().add(lblHora_1);
		
		horaFin = new JSpinner();
		horaFin.setBounds(114, 94, 50, 20);
		frame.getContentPane().add(horaFin);
		
		minFin = new JSpinner();
		minFin.setBounds(204, 94, 40, 20);
		frame.getContentPane().add(minFin);
		
		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel.setBounds(0, 53, 336, 32);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		String[] diasSemana = {"L", "M", "X", "J", "V", "S", "D"};
	
		
		JLabel lblMin = new JLabel("min");
		lblMin.setBounds(175, 9, 46, 14);
		panel.add(lblMin);
		
		minInicio = new JSpinner();
		minInicio.setBounds(200, 6, 41, 20);
		panel.add(minInicio);
		
		diaInicio = new JComboBox(diasSemana);
		diaInicio.setBounds(268, 6, 58, 20);
		panel.add(diaInicio);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_1.setBounds(0, 84, 336, 32);
		frame.getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblMin_1 = new JLabel("min");
		lblMin_1.setBounds(175, 11, 46, 14);
		panel_1.add(lblMin_1);
		
		diaFin = new JComboBox(diasSemana);
		diaFin.setBounds(267, 8, 59, 20);
		panel_1.add(diaFin);
	}
	
	private int calculaDiaSemana() {
		switch ((String) diaInicio.getSelectedItem()) {
		case "L":
			return Calendar.MONDAY;
		case "M":
			return Calendar.TUESDAY;
		case "X":
			return Calendar.WEDNESDAY;
		case "J":
		return Calendar.THURSDAY;
		case "V":
		return Calendar.FRIDAY;
		case "S":
		return Calendar.SATURDAY;
		case "D":
			return Calendar.SUNDAY;
		}
		return -1;
	}
}
