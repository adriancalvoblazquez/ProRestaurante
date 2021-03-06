package modelo;

//import java.util.HashMap;
import java.util.HashSet;

public class Menu extends Consumible {

	private HashSet<Consumible> listaConsumibles;
	//private HashMap<String, Integer> listaConsumibles;

	// Constructores
	public Menu(String id, String nombre, double precio) {
		super(id, nombre, precio);
		this.listaConsumibles = new HashSet<Consumible>();
	}

	public Menu(Menu m) {
		super(m);
		this.listaConsumibles = m.getListaConsumibles();
	}

	// Metodos

	/**
	 * A�ade un consumible al menu
	 * 
	 * @param consumible
	 * 
	 */
	public void anadirConsumible(Consumible consumible) {
		listaConsumibles.add(consumible);
	}

	/**
	 * Busca en la lista de consumibles el id pasado como parametro y lo elimina
	 * 
	 * @param id
	 * @return true si encuentra y elimina el consumible, false si no encuentra el
	 *         id de consumible
	 */
	public boolean eliminarConsumible(String id) {

		return listaConsumibles.removeIf((Consumible c) -> c.getId().equalsIgnoreCase(id));

	}

	public HashSet<Consumible> getListaConsumibles() {
		return listaConsumibles;
	}

	public void setListaConsumibles(HashSet<Consumible> listaConsumibles) {
		this.listaConsumibles = listaConsumibles;
	}

	@Override
	public String toString() {
		return "Menu (" + super.toString() + " -> " + listaConsumibles + ")";
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj instanceof Plato) {
			Plato other = (Plato) obj;
			if (this.getId() == other.getId())
				return true;
		}
		return false;
	}

}
