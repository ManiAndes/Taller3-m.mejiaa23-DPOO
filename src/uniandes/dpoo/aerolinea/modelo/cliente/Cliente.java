package uniandes.dpoo.aerolinea.modelo.cliente;

import java.util.*;

import uniandes.dpoo.aerolinea.modelo.Vuelo;
import uniandes.dpoo.aerolinea.tiquetes.Tiquete;

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
		
		if (tiquete.esUsado()) {
			this.tiquetesUsados.add(tiquete);
			
		} else {
			this.tiquetesSinUsar.add(tiquete);
		}
	}
	
	public int calcularValorTotalTiquetes() {
		
		int valorTotal = 0;
		
		for (Iterator<Tiquete> tiquetesSinUsar = this.tiquetesSinUsar.iterator(); tiquetesSinUsar.hasNext();) {
			
			Tiquete nTiqueteSinUsar = tiquetesSinUsar.next();
			valorTotal += nTiqueteSinUsar.getTarifa();
			
		}
		
		return valorTotal;
		
	}
	
	public void usarTiquetes(Vuelo vuelo) {
		
		int pos = 0;
		for (Iterator<Tiquete> tiquetesSinUsar = this.tiquetesSinUsar.iterator(); tiquetesSinUsar.hasNext();) {
			
			Tiquete nTiqueteSinUsar = tiquetesSinUsar.next();
			
			if (vuelo.equals(nTiqueteSinUsar.getVuelo())) {
				
				nTiqueteSinUsar.marcarComoUsado();
				this.tiquetesUsados.add(nTiqueteSinUsar);
				this.tiquetesSinUsar.remove(pos);
				
			}
			
			pos++;
			
		}
		
		
	}

}
