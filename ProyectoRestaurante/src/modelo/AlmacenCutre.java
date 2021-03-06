package modelo;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;

public class AlmacenCutre extends Almacen {

	private HashSet<Ingrediente> ingredientes;
	private HashSet<Bebida> bebidas;

	// Constructor

	public AlmacenCutre() {
		ingredientes = new HashSet<Ingrediente>();
		bebidas = new HashSet<Bebida>();
	}

	// Metodos

	public int comprobarDisponibilidadBebida(String idBebida, int cantidad) {
		int cantidadAlmacen = 0;
		Iterator<Bebida> it = bebidas.iterator();
		while (it.hasNext()) {
			Bebida bebidaIt = it.next();
			if (bebidaIt.getId().equalsIgnoreCase(idBebida)) {
				if ((cantidadAlmacen = bebidaIt.getCantidad()) >= cantidad) {
					return 0;// devuelve 0 si hay suficiente cantidad de bebidas para las demandadas por el
								// cliente en el pedido
				}

			}

		}
		return calcularNoDisponibles(cantidadAlmacen, cantidad);
	}

	public int calcularNoDisponibles(int cantidadAlmacen, int cantidadPedido) {
		return cantidadAlmacen - cantidadPedido;
	}


	public int comprobarDisponibilidadIngredientes(String idIngrediente, int cantidad) {
		int cantidadAlmacen = 0;
		Iterator<Ingrediente> it = ingredientes.iterator();
		while (it.hasNext()) {
			Ingrediente ingredienteIt = it.next();
			if (ingredienteIt.getId().equals(idIngrediente)) {
				if ((cantidadAlmacen = ingredienteIt.getCantidad()) >= cantidad) {// si queda al menos un ingrediente
																					// con ese id en el almacen
					return 0;// devuelve 0 si hay suficiente cantidad de ingredientes para preparar el plato
				}
			}
		}

		return calcularNoDisponibles(cantidadAlmacen, cantidad);

	}

	public boolean comprobarDisponibilidadPlato(HashMap<String, Integer> ingredientes) {
		for (String idIngrediente : ingredientes.keySet()) {
			if (comprobarDisponibilidadIngredientes(idIngrediente, ingredientes.get(idIngrediente)) != 0) {
				return false;
			}

		}

		return true;
	}


	public void anadirProducto(Object o) {
		if (o instanceof Ingrediente) {
			Ingrediente i = (Ingrediente) o;
			if (!ingredientes.add(i)) {
				for (Iterator<Ingrediente> it = ingredientes.iterator(); it.hasNext();) {
					Ingrediente in = it.next();
					if (in.getId().equals(i.getId()))
						in.setCantidad(in.getCantidad() + i.getCantidad());
				}
			}
		} else if (o instanceof Bebida) {
			Bebida b = (Bebida) o;
			if (!bebidas.add(b)) {
				for (Iterator<Bebida> it = bebidas.iterator(); it.hasNext();) {
					Bebida be = (Bebida) it.next();
					if (be.getId().equals(b.getId()))
						be.setCantidad(be.getCantidad() + b.getCantidad());
				}
			}
		}

	}

	@Override
	public void eliminarProducto(String id) {
		if (id.startsWith("I"))
			ingredientes.removeIf((Ingrediente i) -> i.getId().equalsIgnoreCase(id));
		else {
			bebidas.removeIf((Consumible c) -> c.getId().equalsIgnoreCase(id));
		}
	}

	public void modificarProducto(String id, String nombre) {

	}

	public String mostrarIngredientes() {
		String cadena = "";
		for (Iterator<Ingrediente> it = ingredientes.iterator(); it.hasNext();) {
			cadena += it.next().toString() + "\n";
		}
		return cadena;
	}

	public String mostrarBebidas() {
		String cadena = "";
		for (Iterator<Bebida> it = bebidas.iterator(); it.hasNext();) {
			cadena += it.next().toString() + "\n";
		}
		return cadena;
	}


}
