package uniandes.dpoo.aerolinea.modelo.tarifas;

import uniandes.dpoo.aerolinea.modelo.Vuelo;
import uniandes.dpoo.aerolinea.modelo.cliente.*;

public class CalculadoraTarifasTemporadaBaja extends CalculadoraTarifas {
	
	protected int COSTO_POR_KM_NATURAL = 600;
	protected int COSTO_POR_KM_CORPORATIVO = 900;
	protected double DESCUENTO_PEQ = 0.02;
	protected double DESCUENTO_MEDIANAS = 0.1;
	protected double DESCUENTO_GRANDES = 0.2;

	@Override
	protected int calcularCostoBase(Vuelo vuelo, Cliente cliente) {
		
		String tipoCliente = cliente.getTipoCliente();
		int distancia = calcularDistanciaVuelo(vuelo.getRuta());
		int costoBase;
		
		if (tipoCliente.equals("Natural")) {
			costoBase = distancia * COSTO_POR_KM_NATURAL;
			
		} else {
			costoBase = distancia * COSTO_POR_KM_CORPORATIVO;
		}
		
		return costoBase;
		
	}

	@Override
	protected double calcularPorcentajeDescuento(Cliente cliente) {
		
		if (cliente instanceof ClienteCorporativo) {
			
			ClienteCorporativo clienteCorp= (ClienteCorporativo) cliente;
			int tamanoEmpresa = clienteCorp.getTamanoEmpresa();
			
			if (tamanoEmpresa == 1) {
				return DESCUENTO_GRANDES;
				
			} else if (tamanoEmpresa == 2) {
				return DESCUENTO_MEDIANAS;
				
			} else {
				return DESCUENTO_PEQ;
			}
			
		} else {
			return 0;
		}
		
	}

}
