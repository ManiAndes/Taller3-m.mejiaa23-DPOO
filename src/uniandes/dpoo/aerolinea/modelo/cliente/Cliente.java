package uniandes.dpoo.aerolinea.modelo.cliente;
import java.util.*;

public abstract class Cliente {
	
	private List<Tiquete> tiquetesSinUsar;
	private List<Tiquete> tiquetesUsados;
	
	public Cliente() {
		this.tiquetesSinUsar = new ArrayList<Tiquete>();
		this.tiquetesUsados = new ArrayList<Tiquete>();
	}
	
	public abstract String getTipoCliente();
	public abstract String getIdentificador();
	
	public void agregarTiquete(Tiquete tiquete) {
		//TODO
	}
	
	public int calcularValorTotalTiquetes() {
		// TODO
		return 0;
	}
	
	public void usarTiquetes(Vuelo vuelo) {
		// TODO
	}

}
