import javax.swing.JOptionPane;

public class DataMesa {

	private Mesa siguiente;
	private Mesa anterior;
	private Mesa actual;
	Mesa primero;
	Mesa ultimo;
	
	
	public void AgregarMesaAlFrente (int Mesa) {
		Mesa nuevo = new Mesa (Mesa);
		if (primero == null)
			primero = ultimo = nuevo;
		else {
			primero.anterior = nuevo;
			nuevo.siguiente = primero;
			primero = nuevo;
		}
		actual = nuevo;
	}
	
	public void AgregarMesaAlFinal (int Mesa) {
		Mesa actual = primero;
		Mesa nuevo = new Mesa (Mesa);
		if (primero == null)
			primero = ultimo = nuevo;
		else {
			while (actual.siguiente!= null)
				actual = actual.siguiente;
			actual.siguiente = nuevo;
			nuevo.anterior = actual;
			ultimo = nuevo;
		}
		actual = nuevo;
	}
	
	public void AgregarMesaAlMedio (int Mesa) {
		Mesa actual = primero;
		Mesa nuevo = new Mesa(Mesa);
		while (actual.siguiente != null && actual.getMesa()< Mesa)
			actual = actual.siguiente;
		actual.anterior.siguiente = nuevo;
		nuevo.anterior = actual.anterior;
		actual.anterior = nuevo;
		nuevo.siguiente = actual;
		actual = nuevo;
	}
	
	public void AgregarMesaDondeSea (Mesa nuevo) {
		if (primero == null)
			primero = ultimo = nuevo;
		else {
			if (nuevo.getMesa() < primero.getMesa())
				AgregarMesaAlFrente(nuevo.getMesa());
			else 
				if (nuevo.getMesa() > ultimo.getMesa())
					AgregarMesaAlFinal(nuevo.getMesa());
				else
					AgregarMesaAlMedio(nuevo.getMesa());
		}
	}
	
	public Mesa Anterior () {
		if (actual.anterior == null) {
			JOptionPane.showMessageDialog(null, "No hay mesas anteriores");
			actual = primero;
		} else
			actual = actual.anterior;
		return actual;
	}
	
	public Mesa Siguiente () {
		if (actual.siguiente == null) {
			JOptionPane.showMessageDialog(null, "No hay mesas siguientes");
			actual = ultimo;
		} else
			actual = actual.siguiente;
		return actual;
	}
}
