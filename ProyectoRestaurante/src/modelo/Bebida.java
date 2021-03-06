package modelo;

public class Bebida extends Consumible {
	
	private int cantidad;
	
	//Constructor
	public Bebida(String id, String nombre, double precio, int cantidad) {
		super(id, nombre, precio);
		this.cantidad = cantidad;
	}
	public Bebida(Bebida b) {
		super(b);
		this.cantidad = b.getCantidad();
	}

	
	//get
	public int getCantidad() {
		return cantidad;
	}
	//set
	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	@Override
	public String toString() {
		return "Bebida [" + super.toString() + "cantidad=" + cantidad + "]";
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj instanceof Bebida) {
			Bebida other = (Bebida) obj;
			if (this.getId().equalsIgnoreCase(other.getId()))
				return true;
		}
		return false;
	}
	
}
