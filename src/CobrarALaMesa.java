import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.*;
import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;
import javax.swing.Action;
import java.awt.Color;

public class CobrarALaMesa extends JFrame {

	private JPanel contentPane;
	private final ButtonGroup Requisito= new ButtonGroup();
	private final JButton btnVolver = new JButton("Volver al men\u00FA principal");
	public int Mesa = GUIPrincipal.Mesa;
	public double TotalMesa = TableroAlimentos.TotalMesa;
	private conecta ConexionCobranza = new conecta();
	ResultSet RsCobrar;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CobrarALaMesa frame = new CobrarALaMesa();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public CobrarALaMesa() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 271, 231);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 204, 102));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblTotal = new JLabel("Su total es de:");
		lblTotal.setHorizontalAlignment(SwingConstants.CENTER);
		lblTotal.setBounds(10, 94, 109, 14);
		contentPane.add(lblTotal);
		
		JLabel lblTotalNumero = new JLabel(String.valueOf(TotalMesa));
		lblTotalNumero.setHorizontalAlignment(SwingConstants.CENTER);
		lblTotalNumero.setFont(new Font("Tahoma", Font.BOLD, 22));
		lblTotalNumero.setBounds(10, 119, 109, 28);
		contentPane.add(lblTotalNumero);
		
		JLabel lblRequiere = new JLabel("Requiere Factura?");
		lblRequiere.setHorizontalAlignment(SwingConstants.CENTER);
		lblRequiere.setBounds(129, 44, 109, 14);
		contentPane.add(lblRequiere);
		
		JLabel lblMesaLB = new JLabel("Mesa:");
		lblMesaLB.setHorizontalAlignment(SwingConstants.CENTER);
		lblMesaLB.setBounds(42, 18, 46, 14);
		contentPane.add(lblMesaLB);
		
		JLabel lblMesaNum = new JLabel(String.valueOf(Mesa));
		lblMesaNum.setFont(new Font("Tahoma", Font.BOLD, 36));
		lblMesaNum.setHorizontalAlignment(SwingConstants.CENTER);
		lblMesaNum.setBounds(42, 41, 46, 42);
		contentPane.add(lblMesaNum);
		
		JButton btnCobrar = new JButton("Cobrar");
		btnCobrar.setEnabled(false);
		btnCobrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				RsCobrar = ConexionCobranza.CobrarAlimentos(Mesa);
				JOptionPane.showMessageDialog(null, "Gracias por su compra");
				GUIPrincipal window = new GUIPrincipal();
				window.setVisible(true);
				setVisible(false);
			}
		});
		btnCobrar.setBounds(129, 11, 109, 28);
		contentPane.add(btnCobrar);
		
		JButton btnFacturacion = new JButton("Facturacion");
		btnFacturacion.setEnabled(false);
		btnFacturacion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Facturacion window = new Facturacion();
				window.setVisible(true);
				setVisible(false);
			}
		});
		btnFacturacion.setBounds(129, 119, 109, 28);
		contentPane.add(btnFacturacion);
		
		JRadioButton RBNo = new JRadioButton("No");
		RBNo.setBackground(new Color(255, 204, 102));
		RBNo.setHorizontalAlignment(SwingConstants.CENTER);
		RBNo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (RBNo.isSelected()) {
					btnFacturacion.setEnabled(false);
					btnCobrar.setEnabled(true);
				} else {
					btnFacturacion.setEnabled(true);
					btnCobrar.setEnabled(true);
				}
			}
		});
		Requisito.add(RBNo);
		RBNo.setBounds(129, 65, 109, 23);
		contentPane.add(RBNo);
		
		JRadioButton RBSi = new JRadioButton("Si");
		RBSi.setBackground(new Color(255, 204, 102));
		RBSi.setHorizontalAlignment(SwingConstants.CENTER);
		RBSi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (RBSi.isSelected()) {
					btnFacturacion.setEnabled(true);
					btnCobrar.setEnabled(true);
				} else {
					btnFacturacion.setEnabled(false);
					btnCobrar.setEnabled(true);
				}
			}
		});
		Requisito.add(RBSi);
		RBSi.setBounds(129, 91, 109, 23);
		contentPane.add(RBSi);
		btnVolver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				GUIPrincipal window = new GUIPrincipal();
				window.setVisible(true);
				setVisible(false);
			}
		});
		btnVolver.setBounds(10, 161, 228, 20);
		contentPane.add(btnVolver);
	}
	
}
