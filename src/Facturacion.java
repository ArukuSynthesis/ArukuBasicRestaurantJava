import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Image;

import javax.swing.SwingConstants;
import javax.swing.ImageIcon;
import javax.swing.JTable;
import javax.swing.JTextField;
import java.awt.Color;
import javax.swing.table.DefaultTableModel;

import net.proteanit.sql.DbUtils;

import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.sql.*;
import java.awt.event.ActionEvent;

public class Facturacion extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JTextField txtBuscar;
	private JTextField txtNombre;
	private JTextField txtRFC;
	private JTextField txtImporte;
	private conecta ConexionFacturacion = new conecta();
	ResultSet RsFacturacion;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Facturacion frame = new Facturacion();
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
	public Facturacion() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 404, 401);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 204, 102));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnGuardar = new JButton("");
		btnGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
				int precio = Integer.parseInt(txtImporte.getText());
				if (ConexionFacturacion.Inserta(txtNombre.getText(), txtRFC.getText(), precio))
					JOptionPane.showMessageDialog(null, "Se ha añadido a la facturación con exito");
				RsFacturacion = ConexionFacturacion.getMyRs();
				} catch (Exception e4) {
					JOptionPane.showMessageDialog(null, "Por favor, rellene los campos correctamente");
				}
			}
		});
		Image img = new ImageIcon(this.getClass().getResource("/floppy.png")).getImage();
		btnGuardar.setIcon(new ImageIcon("imagenes/floppy.png"));
		btnGuardar.setBounds(255, 310, 40, 40);
		contentPane.add(btnGuardar);
		
		JButton btnBorrar = new JButton("");
		btnBorrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
				int id= Integer.parseInt(JOptionPane.showInputDialog(null, "Escribe el ID del contribuyente para eliminar la factura"));
				ConexionFacturacion.EliminarContribuyente(id);
				RsFacturacion = ConexionFacturacion.getMyRs();
				JOptionPane.showMessageDialog(null, "Factura Eliminada");
				} catch (Exception e3) {
					JOptionPane.showMessageDialog(null, "Por favor, seleccione un ID Valido");
				}
			}
		});
		btnBorrar.setIcon(new ImageIcon("imagenes/Basurero.png"));
		btnBorrar.setBounds(342, 310, 40, 40);
		contentPane.add(btnBorrar);
		
		JButton btnActualizar = new JButton("Obtener Datos");
		btnActualizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				RsFacturacion = ConexionFacturacion.getMyRs();
				table.setModel(DbUtils.resultSetToTableModel(RsFacturacion));
			}
		});
		btnActualizar.setBounds(10, 211, 139, 20);
		contentPane.add(btnActualizar);
		
		JButton btnBuscar = new JButton("");
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				RsFacturacion = ConexionFacturacion.BuscarContribuyente(txtBuscar.getText());
				table.setModel(DbUtils.resultSetToTableModel(RsFacturacion));
			}
		});
		btnBuscar.setIcon(new ImageIcon("imagenes/lupa.png"));
		btnBuscar.setBounds(338, 217, 40, 40);
		contentPane.add(btnBuscar);
		
		JButton button = new JButton("New button");
		button.setBounds(151, 368, -2, -1);
		contentPane.add(button);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 11, 368, 195);
		contentPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"ID", "Nombre", "RFC", "Importe"
			}
		));
		
		txtBuscar = new JTextField();
		txtBuscar.setBounds(173, 237, 158, 20);
		contentPane.add(txtBuscar);
		txtBuscar.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Buscar por nombre:");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(173, 217, 158, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblNombre = new JLabel("Nombre:");
		lblNombre.setBounds(10, 271, 67, 14);
		contentPane.add(lblNombre);
		
		txtNombre = new JTextField();
		txtNombre.setBounds(87, 268, 291, 20);
		contentPane.add(txtNombre);
		txtNombre.setColumns(10);
		
		JLabel lblRFC = new JLabel("RFC:");
		lblRFC.setBounds(10, 310, 67, 14);
		contentPane.add(lblRFC);
		
		txtRFC = new JTextField();
		txtRFC.setBounds(87, 304, 158, 20);
		contentPane.add(txtRFC);
		txtRFC.setColumns(10);
		
		JLabel lblImporte = new JLabel("Importe:");
		lblImporte.setBounds(10, 338, 67, 14);
		contentPane.add(lblImporte);
		
		txtImporte = new JTextField();
		txtImporte.setBounds(87, 335, 158, 20);
		contentPane.add(txtImporte);
		txtImporte.setColumns(10);
		
		JButton btnVolver = new JButton("Volver");
		btnVolver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CobrarALaMesa window = new CobrarALaMesa();
				window.setVisible(true);
				setVisible(false);
			}
		});
		btnVolver.setBounds(10, 234, 139, 23);
		contentPane.add(btnVolver);
		
		JButton btnActualizarDatos = new JButton("");
		btnActualizarDatos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
				int Importe = Integer.parseInt(txtImporte.getText());
				int id = Integer.parseInt(JOptionPane.showInputDialog("Escribe el ID del contribuyente a Actualizar"));
				String Nombre = txtNombre.getText();
				String RFC = txtRFC.getText();
			
				ConexionFacturacion.ActualizarContribuyente(id, Nombre, RFC, Importe);
				RsFacturacion = ConexionFacturacion.getMyRs();
				JOptionPane.showMessageDialog(null, "Factura Actualizada");
				} catch (Exception e2) {
					JOptionPane.showMessageDialog(null, "Por favor, rellene los campos correctamente");
				}
			}
		});
		btnActualizarDatos.setIcon(new ImageIcon("imagenes/actualizar.png"));
		btnActualizarDatos.setBounds(299, 310, 40, 40);
		contentPane.add(btnActualizarDatos);
	}
}
