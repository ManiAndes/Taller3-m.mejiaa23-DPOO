package uniandes.dpoo.aerolinea.modelo.tarifas;

import uniandes.dpoo.aerolinea.modelo.Vuelo;
import uniandes.dpoo.aerolinea.modelo.Ruta;
import uniandes.dpoo.aerolinea.modelo.cliente.Cliente;

public abstract class CalculadoraTarifas {
	
	public double IMPUESTO = 0.28;
	
	protected abstract int calcularCostoBase(Vuelo vuelo, Cliente cliente);
	protected abstract double calcularPorcentajeDescuento(Cliente cliente);
	
	protected int calcularDistanciaVuelo(Ruta ruta) {
		// TODO
		return 0;
	}
	protected int calcularValorImpuestos(int costoBase) {
		// TODO
		return 0;
	}
	public int calcularTarifa(Vuelo vuelo, Cliente cliente) {
		// TODO
		return 0;
	}

}
