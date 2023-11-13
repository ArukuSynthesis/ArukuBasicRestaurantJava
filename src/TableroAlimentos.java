import java.awt.BorderLayout;

import java.awt.EventQueue;
import net.proteanit.sql.DbUtils;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.AbstractListModel;
import javax.swing.DefaultListModel;

import java.awt.event.ActionListener;
import java.sql.*;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import java.awt.Color;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;

public class TableroAlimentos extends JFrame {
	
	private conecta ConexionProductos = new conecta();
	ResultSet RsProductos;
	private JPanel contentPane;
	//DefaultListModel Modelo = new DefaultListModel();
	private JTable table;
	private JTable table_1;
	public static double TotalMesa;
	public int Mesa = GUIPrincipal.Mesa;
	
	
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TableroAlimentos frame = new TableroAlimentos();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public double totalizar() {
		double t = 0;
		double p = 0;
		if (table_1.getRowCount() > 0) {
			for (int i = 0; i < table_1.getRowCount(); i++) {
				p = Double.parseDouble (table_1.getValueAt(i, 4).toString());
				t += p;
			}
			
		} return t;
	} 
	
	/**
	 * Create the frame.
	 */
	public TableroAlimentos() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 588, 491);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 204, 102));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnBebidas = new JButton("Bebidas");
		btnBebidas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				RsProductos = ConexionProductos.getCategoria("Bebidas");
				table.setModel(DbUtils.resultSetToTableModel(RsProductos));
			}
		});
		btnBebidas.setBounds(10, 11, 100, 50);
		contentPane.add(btnBebidas);
		
		JButton btnEntradas = new JButton("Entradas");
		btnEntradas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				RsProductos = ConexionProductos.getCategoria("Entradas");
				table.setModel(DbUtils.resultSetToTableModel(RsProductos));
			}
		});
		btnEntradas.setBounds(10, 72, 100, 50);
		contentPane.add(btnEntradas);
		
		JButton btnAlitas = new JButton("Alitas");
		btnAlitas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				RsProductos = ConexionProductos.getCategoria("Alitas");
				table.setModel(DbUtils.resultSetToTableModel(RsProductos));
			}
		});
		btnAlitas.setBounds(10, 133, 100, 50);
		contentPane.add(btnAlitas);
		
		JButton btnEnsalada = new JButton("Ensalada");
		btnEnsalada.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				RsProductos = ConexionProductos.getCategoria("Ensalada");
				table.setModel(DbUtils.resultSetToTableModel(RsProductos));
			}
		});
		btnEnsalada.setBounds(10, 194, 100, 50);
		contentPane.add(btnEnsalada);
		
		JButton btnPizza = new JButton("Pizza");
		btnPizza.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				RsProductos = ConexionProductos.getCategoria("Pizza");
				table.setModel(DbUtils.resultSetToTableModel(RsProductos));
			}
		});
		btnPizza.setBounds(10, 255, 100, 50);
		contentPane.add(btnPizza);
		
		JButton btnPasta = new JButton("Pasta");
		btnPasta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				RsProductos = ConexionProductos.getCategoria("Pasta");
				table.setModel(DbUtils.resultSetToTableModel(RsProductos));
			}
		});
		btnPasta.setBounds(10, 316, 100, 50);
		contentPane.add(btnPasta);
		
		JButton btnHamburguesas = new JButton("Hamburguesas");
		btnHamburguesas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				RsProductos = ConexionProductos.getCategoria("Hamburguesa");
				table.setModel(DbUtils.resultSetToTableModel(RsProductos));
			}
		});
		btnHamburguesas.setFont(new Font("Tahoma", Font.PLAIN, 9));
		btnHamburguesas.setBounds(463, 11, 100, 50);
		contentPane.add(btnHamburguesas);
		
		JButton btnPrincipales = new JButton("Principales");
		btnPrincipales.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				RsProductos = ConexionProductos.getCategoria("Principales");
				table.setModel(DbUtils.resultSetToTableModel(RsProductos));
			}
		});
		btnPrincipales.setBounds(463, 72, 100, 50);
		contentPane.add(btnPrincipales);
		
		JButton btnGuarniciones = new JButton("Guarniciones");
		btnGuarniciones.setFont(new Font("Tahoma", Font.PLAIN, 9));
		btnGuarniciones.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				RsProductos = ConexionProductos.getCategoria("Guarniciones");
				table.setModel(DbUtils.resultSetToTableModel(RsProductos));
			}
		});
		btnGuarniciones.setBounds(463, 133, 100, 50);
		contentPane.add(btnGuarniciones);
		
		JButton btnPostres = new JButton("Postres");
		btnPostres.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				RsProductos = ConexionProductos.getCategoria("Postres");
				table.setModel(DbUtils.resultSetToTableModel(RsProductos));
			}
		});
		btnPostres.setBounds(463, 194, 100, 50);
		contentPane.add(btnPostres);
		
		JButton btnCervezas = new JButton("Cervezas");
		btnCervezas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				RsProductos = ConexionProductos.getCategoria("Cervezas");
				table.setModel(DbUtils.resultSetToTableModel(RsProductos));
			}
		});
		btnCervezas.setBounds(463, 255, 100, 50);
		contentPane.add(btnCervezas);
		
		JButton btnLicores = new JButton("Licores");
		btnLicores.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				RsProductos = ConexionProductos.getCategoria("Licores");
				table.setModel(DbUtils.resultSetToTableModel(RsProductos));
			}
		});
		btnLicores.setBounds(463, 316, 100, 50);
		contentPane.add(btnLicores);
		
		JLabel lblMesa = new JLabel("Mesa:");
		lblMesa.setHorizontalAlignment(SwingConstants.CENTER);
		lblMesa.setBounds(463, 388, 46, 14);
		contentPane.add(lblMesa);
		
		JLabel lblNewLabel = new JLabel(String.valueOf(Mesa));
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 36));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(516, 377, 46, 39);
		contentPane.add(lblNewLabel);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(120, 38, 333, 145);
		contentPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"idProductos", "Nombre Producto", "Categor\u00EDa", "Precio"
			}
		));
		table.getColumnModel().getColumn(1).setPreferredWidth(104);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(120, 220, 333, 145);
		contentPane.add(scrollPane_1);
		
		table_1 = new JTable();
		scrollPane_1.setViewportView(table_1);
		table_1.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"idProductos","N°Mesa", "Nombre Producto", "Categor\u00EDa", "Precio"
			}
		));
		table_1.getColumnModel().getColumn(1).setPreferredWidth(98);
		table_1.getColumnModel().getColumn(1).setMinWidth(18);
		
		JLabel lblProductosRestaurante = new JLabel("Productos del Restaurante");
		lblProductosRestaurante.setHorizontalAlignment(SwingConstants.CENTER);
		lblProductosRestaurante.setBounds(120, 11, 333, 14);
		contentPane.add(lblProductosRestaurante);
		
		JLabel lblProductosCliente = new JLabel("Productos del Cliente");
		lblProductosCliente.setHorizontalAlignment(SwingConstants.CENTER);
		lblProductosCliente.setBounds(220, 194, 132, 14);
		contentPane.add(lblProductosCliente);
		
		JLabel lblTotalNumerico = new JLabel(String.valueOf(TotalMesa));
		lblTotalNumerico.setBounds(507, 427, 40, 14);
		contentPane.add(lblTotalNumerico);
		
		JButton btnSuma = new JButton("+");
		btnSuma.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnSuma.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					int index = table.getSelectedRow();
					String Producto = (table.getValueAt(index, 1).toString());
					String Categoria = (table.getValueAt(index, 2).toString());
					String PrecioString = (table.getValueAt(index, 3).toString());
					int Precio = Integer.parseInt(PrecioString);
					if (table.getSelectedRowCount() == 1 && ConexionProductos.InsertarAlimentos(Mesa, Producto, Categoria, Precio)) {
					RsProductos = ConexionProductos.getMesa(Mesa);
					table_1.setModel(DbUtils.resultSetToTableModel(RsProductos));
					} else {
						if (table.getSelectedRowCount() == 0)
							JOptionPane.showMessageDialog(null, "No has seleccionado ningún producto a agregar");
						else if (table.getSelectedRowCount() > 1)
							JOptionPane.showMessageDialog(null, "Selecciona solo un producto a agregar");
					}
				} catch (Exception e2) {
					JOptionPane.showMessageDialog(null, e2);
				}
					double Total = totalizar();
					lblTotalNumerico.setText(String.valueOf(Total));
					TotalMesa = Total;
			}
		});
		btnSuma.setBounds(120, 188, 100, 22);
		contentPane.add(btnSuma);
		
		JButton btnSalir = new JButton("Volver");
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				GUIPrincipal window = new GUIPrincipal();
				window.setVisible(true);
				setVisible(false);
			}
		});
		btnSalir.setBounds(10, 402, 100, 39);
		contentPane.add(btnSalir);
		
		JButton btnResta = new JButton("-");
		btnResta.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnResta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					int index = table_1.getSelectedRow();
					String StringId = table_1.getValueAt(index, 0).toString();
					int ID = Integer.parseInt(StringId);
				if (table_1.getSelectedRowCount()==1 && ConexionProductos.EliminarAlimentos(ID)) {
					RsProductos = ConexionProductos.getMesa(Mesa);
					table_1.setModel(DbUtils.resultSetToTableModel(RsProductos));
				} else {
					if (table_1.getRowCount()==0) {
						JOptionPane.showMessageDialog(null, "La tabla está vacía");
					} else {
						JOptionPane.showMessageDialog(null, "Seleccione un solo item a eliminar");
					}
				}
				double Total = totalizar();
				lblTotalNumerico.setText(String.valueOf(Total));
				TotalMesa = Total;
				RsProductos = ConexionProductos.getMesa(Mesa);
				table_1.setModel(DbUtils.resultSetToTableModel(RsProductos));
				} catch (Exception e2) {
					JOptionPane.showMessageDialog(null, e2);
				}
			}
		});
		
		btnResta.setBounds(353, 188, 100, 22);
		contentPane.add(btnResta);
		
		JLabel lblTotalInstructivo = new JLabel("Total:");
		lblTotalInstructivo.setBounds(463, 427, 34, 14);
		contentPane.add(lblTotalInstructivo);
		
		JLabel lblNewLabel_1 = new JLabel("$");
		lblNewLabel_1.setBounds(546, 427, 16, 14);
		contentPane.add(lblNewLabel_1);
		
		JButton btnObtenerDatos = new JButton("Obtener Datos");
		btnObtenerDatos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				RsProductos = ConexionProductos.getMesa(Mesa);
				table_1.setModel(DbUtils.resultSetToTableModel(RsProductos));
				double Total = totalizar();
				lblTotalNumerico.setText(String.valueOf(Total));
				TotalMesa = Total;
			}
		});
		btnObtenerDatos.setBounds(120, 377, 333, 23);
		contentPane.add(btnObtenerDatos);
		
		JButton btnCobrarALaMesa = new JButton("Cobrar a la Mesa Actual");
		btnCobrarALaMesa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CobrarALaMesa window = new CobrarALaMesa();
				window.setVisible(true);
				setVisible(false);
			}
		});
		btnCobrarALaMesa.setBounds(120, 410, 333, 22);
		contentPane.add(btnCobrarALaMesa);
		
		
	}
}
