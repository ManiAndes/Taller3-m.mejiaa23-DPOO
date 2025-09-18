package uniandes.dpoo.aerolinea.modelo.tarifas;

import uniandes.dpoo.aerolinea.modelo.Vuelo;
import uniandes.dpoo.aerolinea.modelo.Ruta;
import uniandes.dpoo.aerolinea.modelo.cliente.Cliente;
import uniandes.dpoo.aerolinea.modelo.Aeropuerto;

public abstract class CalculadoraTarifas {
	
	public double IMPUESTO = 0.28;
	
	protected abstract int calcularCostoBase(Vuelo vuelo, Cliente cliente);
	protected abstract double calcularPorcentajeDescuento(Cliente cliente);
	
	protected int calcularDistanciaVuelo(Ruta ruta) {
		
		Aeropuerto Origen = ruta.getOrigen();
		Aeropuerto Destino = ruta.getDestino();
		
		int distancia = Aeropuerto.calcularDistancia(Origen, Destino);
		return distancia;
		
	}
	
	protected int calcularValorImpuestos(int costoBase) {
		
		int impuestos = (int) Math.round(costoBase * IMPUESTO);
		return impuestos;
		
	}
	
	public int calcularTarifa(Vuelo vuelo, Cliente cliente) {
		
		int costoBase = calcularCostoBase(vuelo, cliente);
		double porcentajeDescuento = calcularPorcentajeDescuento(cliente);
		double costoConDescuento = costoBase - (costoBase * porcentajeDescuento);
		double costoConImpuesto = costoConDescuento - (costoConDescuento * IMPUESTO);
		
		int tarifa = (int) Math.round(costoConImpuesto);
		
		return tarifa;
		
	}

}
