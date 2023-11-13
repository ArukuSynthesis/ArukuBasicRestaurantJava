public class Productos {

	int idProductos;
	String NombreProducto;
	String Categoria;
	int Precio;
	
	public Productos() {

	}

	public int getIdProductos() {
		return idProductos;
	}

	public void setIdProductos(int idProductos) {
		this.idProductos = idProductos;
	}

	public String getNombreProducto() {
		return NombreProducto;
	}

	public void setNombreProducto(String nombreProducto) {
		NombreProducto = nombreProducto;
	}

	public String getCategoria() {
		return Categoria;
	}

	public void setCategoria(String categoria) {
		Categoria = categoria;
	}

	public int getPrecio() {
		return Precio;
	}

	public void setPrecio(int precio) {
		Precio = precio;
	} 
	//@Override
	//public String toString() {
	//	return this.idProductos+" |  "+this.NombreProducto+" |  "+this.Categoria+" |  "+this.Precio;
	//}
	
}
