import java.sql.*;

import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import net.proteanit.sql.DbUtils;
import java.util.Date;

public class conecta {
	private String url1;
	private  String user;
	private  String password ;
    private ResultSet myRs;
    Connection MyConn = null;
    //private  Connection MyConn;
    
public conecta() {
	url1 = "jdbc:mysql://127.0.0.1:3306/restaurante";
	 user = "root";
	 password = "password";
	 try {
		 Class.forName("com.mysql.cj.jdbc.Driver");
		 MyConn = (Connection)DriverManager.getConnection(url1,user,password);
	 }catch (Exception e) {
		 JOptionPane.showMessageDialog(null, e);
	 }
}
public String getUser() {
	return user;
}
public void setUser(String user) {
	this.user = user;
}
	public ResultSet getMyRs() {
		try {
			url1 = "jdbc:mysql://127.0.0.1:3306/restaurante";
			 user = "root";
			 password = "password";
			Connection MyConn = DriverManager.getConnection(url1,user,password);
			String SQL = "Select * from restaurante.facturacion";
			PreparedStatement MyStmt = MyConn.prepareStatement(SQL);
			myRs = MyStmt.executeQuery(SQL);
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, e);
		}
		return myRs;
	}
	public ResultSet getCategoria (String categoria) {
		try {
			url1 = "jdbc:mysql://127.0.0.1:3306/restaurante";
			 user = "root";
			 password = "password";
			Connection MyConn = DriverManager.getConnection(url1,user,password);
			String SQL = "SELECT * FROM restaurante.productos WHERE Categoría='"+categoria+"'";
			PreparedStatement myStmt = MyConn.prepareStatement(SQL);
			myRs = myStmt.executeQuery(SQL);
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, e);
		} 
		return myRs;
	}
	
	public ResultSet getMesa (int Mesa) {
		try {
			url1 = "jdbc:mysql://127.0.0.1:3306/restaurante";
			 user = "root";
			 password = "password";
			Connection MyConn = DriverManager.getConnection(url1,user,password);
			String SQL = "SELECT * FROM restaurante.mesas WHERE NoMesa="+Mesa;
			PreparedStatement myStmt = MyConn.prepareStatement(SQL);
			myRs = myStmt.executeQuery(SQL);
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, e);
		}
		return myRs;
	}
	
	public boolean InsertarAlimentos(int Mesa, String Producto, String Categoria, int Precio) {
		try {
			url1 = "jdbc:mysql://127.0.0.1:3306/restaurante";
			 user = "root";
			 password = "password";
			Connection MyConn = DriverManager.getConnection(url1,user,password);
			Statement myStmt = MyConn.createStatement();
			String SQL = "Insert into restaurante.mesas"
					+ "(NoMesa,Producto,Categoría,Precio) "
					+ "values("+Mesa+",'"+Producto+"','"+Categoria+"',"+Precio+")";
			myStmt.executeUpdate(SQL);
			return true;
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, e);
			return false;
		}
	}
	
	public boolean EliminarAlimentos (int id) {
		try {
			url1 = "jdbc:mysql://127.0.0.1:3306/restaurante";
			 user = "root";
			 password = "password";
			Connection MyConn = DriverManager.getConnection(url1,user,password);
			Statement myStmt = MyConn.createStatement();
			String SQL = "DELETE FROM restaurante.mesas WHERE IDPedido="+id;
			myStmt.executeUpdate(SQL);
			return true;
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, e);
			return false;
		}
	}
	
	public ResultSet CobrarAlimentos (int Mesa) {
		try {
			url1 = "jdbc:mysql://127.0.0.1:3306/restaurante";
			 user = "root";
			 password = "password";
			Connection MyConn = DriverManager.getConnection(url1,user,password);
			Statement myStmt = MyConn.createStatement();
			String SQL = "DELETE FROM restaurante.mesas WHERE NoMesa="+Mesa;
			myStmt.executeUpdate(SQL);
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, e);
		} return myRs;
	}
	
	public boolean Inserta(String nombre, String RFC, int importe) {
		try {
			url1 = "jdbc:mysql://127.0.0.1:3306/restaurante";
			 user = "root";
			 password = "password";
			Connection MyConn = DriverManager.getConnection(url1,user,password);
			Statement myStmt = MyConn.createStatement();
			String SQL = "Insert into restaurante.facturacion"
					+ "(Nombre,RFC,Importe) "
					+ "values('"+ nombre+"','"+RFC+"',"+importe+")";
			myStmt.executeUpdate(SQL);
			return true;
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, e);
			return false;			
		}
	}
	public boolean EliminarContribuyente(int id) {
		try {
			url1 = "jdbc:mysql://127.0.0.1:3306/restaurante";
			 user = "root";
			 password = "password";
			Connection MyConn = DriverManager.getConnection(url1,user,password);
			Statement myStmt = MyConn.createStatement();
			String SQL = "DELETE FROM restaurante.facturacion WHERE idFacturacion="+id;
			myStmt.executeUpdate(SQL);
			return true;
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, e);
			return false;
		}
	}
	public boolean ActualizarContribuyente(int id, String nombre, String RFC, int importe) {
		try { 
			url1 = "jdbc:mysql://127.0.0.1:3306/restaurante";
			 user = "root";
			 password = "password";
			Connection MyConn = DriverManager.getConnection(url1,user,password);
			Statement myStmt = MyConn.createStatement();
			String SQL = "UPDATE restaurante.facturacion set Nombre='"+nombre+"', RFC='"+RFC+"', Importe="+importe+" WHERE idFacturacion="+id;
			myStmt.executeUpdate(SQL);
			return true;
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, e);
			return false;
		}
	}
	public ResultSet BuscarContribuyente(String nombre) {
		try {
			url1 = "jdbc:mysql://127.0.0.1:3306/restaurante";
			 user = "root";
			 password = "password";
			Connection MyConn = DriverManager.getConnection(url1,user,password);
			String SQL = "SELECT * FROM restaurante.facturacion WHERE Nombre='"+nombre+"'";
			PreparedStatement myStmt = MyConn.prepareStatement(SQL);
			myRs = myStmt.executeQuery(SQL);
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, e);
		} 
		return myRs;
	}
	
}

