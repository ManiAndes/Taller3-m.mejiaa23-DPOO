package uniandes.dpoo.aerolinea.persistencia;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.io.PrintWriter;
import java.nio.file.Files;

import org.json.JSONArray;
import org.json.JSONObject;

import uniandes.dpoo.aerolinea.exceptions.ClienteRepetidoException;
import uniandes.dpoo.aerolinea.exceptions.InformacionInconsistenteException;
import uniandes.dpoo.aerolinea.modelo.Aerolinea;
import uniandes.dpoo.aerolinea.modelo.cliente.Cliente;
import uniandes.dpoo.aerolinea.modelo.cliente.ClienteCorporativo;
import uniandes.dpoo.aerolinea.modelo.cliente.ClienteNatural;
import uniandes.dpoo.aerolinea.modelo.*;

public class PersistenciaAerolineaJson implements IPersistenciaAerolinea {

	@Override
	public void cargarAerolinea(String archivo, Aerolinea aerolinea) throws IOException, InformacionInconsistenteException {
		
		String jsonCompleto = new String(Files.readAllBytes(new File(archivo).toPath()));
		JSONObject root = new JSONObject(jsonCompleto);
		
		cargarAviones( aerolinea, root.getJSONArray( "aviones" ) );
        cargarVuelos( aerolinea, root.getJSONArray( "vuelos" ) );
		
	}

	@Override
	public void salvarAerolinea(String archivo, Aerolinea aerolinea) throws IOException {
		// TODO Auto-generated method stub
	}
	
	private void cargarAviones( Aerolinea aerolinea, JSONArray jAviones ) throws ClienteRepetidoException
    {
        int numClientes = jAviones.length( );
        for( int i = 0; i < numClientes; i++ )
        {
            JSONObject avion = jAviones.getJSONObject( i );
            Avion nuevoAvion = null;
        }
    }
	
	private void cargarVuelos( Aerolinea aerolinea, JSONArray jVuelos ) throws ClienteRepetidoException
    {
        int numClientes = jVuelos.length( );
        for( int i = 0; i < numClientes; i++ )
        {
            JSONObject avion = jVuelos.getJSONObject( i );
            Vuelo nuevoVuelos = null;
        }
    }

}
