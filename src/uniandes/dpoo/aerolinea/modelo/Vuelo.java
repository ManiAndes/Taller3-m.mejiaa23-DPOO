package uniandes.dpoo.aerolinea.modelo;

import uniandes.dpoo.aerolinea.modelo.cliente.Cliente;
import uniandes.dpoo.aerolinea.modelo.tarifas.CalculadoraTarifas;
import uniandes.dpoo.aerolinea.tiquetes.*;
import java.util.*;

public class Vuelo {
	
	//* Solo contiene una ruta
	private Ruta ruta;
	
	//* Es un mapa donde las llaves son el codigo del tiquete
	private Map<String, Tiquete> tiquetes;
	
	//* Solo contiene un avion
	private Avion avion;
	
	private String fecha;

	public Vuelo(Ruta ruta, String fecha, Avion avion) {
		super();
		this.ruta = ruta;
		this.avion = avion;
		this.fecha = fecha;
		this.tiquetes = new HashMap<String, Tiquete>();
	}
	
	//* Getters and setters
	
	public Ruta getRuta() {
		return ruta;
	}

	public void setRuta(Ruta ruta) {
		this.ruta = ruta;
	}

	public Collection<Tiquete> getTiquetes() {
		return tiquetes.values();
	}

	public void setTiquetes(Map<String, Tiquete> tiquetes) {
		this.tiquetes = tiquetes;
	}

	public Avion getAvion() {
		return avion;
	}

	public void setAvion(Avion avion) {
		this.avion = avion;
	}

	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}
	
	public int venderTiquetes(Cliente cliente, CalculadoraTarifas calculadora, int cantidad) {
		
		int tarifa = calculadora.calcularTarifa(this, cliente);
		int valorTotal = cantidad * tarifa;
		
		for (int i = 0; i < cantidad; i++) {
			
			Tiquete nTiquete = GeneradorTiquetes.generarTiquete(this, cliente, tarifa);
			nTiquete.marcarComoUsado();
			this.tiquetes.put(nTiquete.getCodigo(), nTiquete);
			
		}
		
		return valorTotal;
		
	}
	
	public boolean equals(Object obj) {
		return this.equals(obj);
	}

}
