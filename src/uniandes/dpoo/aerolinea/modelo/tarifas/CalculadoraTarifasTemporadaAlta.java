package uniandes.dpoo.aerolinea.modelo.tarifas;

import uniandes.dpoo.aerolinea.modelo.Vuelo;
import uniandes.dpoo.aerolinea.modelo.cliente.Cliente;

public class CalculadoraTarifasTemporadaAlta extends CalculadoraTarifas {
	
	protected int COSTO_POR_KM = 1000;

	@Override
	protected int calcularCostoBase(Vuelo vuelo, Cliente cliente) {
		
		int distancia = calcularDistanciaVuelo(vuelo.getRuta());
		int costoBase = distancia * COSTO_POR_KM;
		
		return costoBase;
		
	}

	@Override
	protected double calcularPorcentajeDescuento(Cliente cliente) {
		return 0;		
	}

}
