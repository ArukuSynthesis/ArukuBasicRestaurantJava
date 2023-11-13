public class Mesa {
	private int Mesa;
	Mesa siguiente;
	Mesa anterior;
	Mesa actual;
	
	public Mesa(int Mesa) {
		this.Mesa = Mesa;
	}

	public int getMesa() {
		return Mesa;
	}

	public void setMesa(int Mesa) {
		this.Mesa = Mesa;
	}

	public Mesa getSiguiente() {
		return siguiente;
	}

	public void setSiguiente(Mesa siguiente) {
		this.siguiente = siguiente;
	}

	public Mesa getAnterior() {
		return anterior;
	}

	public void setAnterior(Mesa anterior) {
		this.anterior = anterior;
	}

	public Mesa getActual() {
		return actual;
	}

	public void setActual(Mesa actual) {
		this.actual = actual;
	}
	
}
