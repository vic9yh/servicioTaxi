package es.unican.is2.radioTaxi;

import java.util.HashMap;
import java.util.Map;

/**
 * Clase que agrupa las tarifas del servicio de RadioTaxi de Santander
 * Modo de uso: Es necesario invocar el método inicializa() al menos una
 * vez antes de usar los métodos de consulta
 * @author IS2
 *
 */
public class TarifasRadioTaxi {

	private static Map<Integer, Double> servicioMinimo = new HashMap<Integer, Double>();
	private static Map<Integer, Double> bajadaBandera= new HashMap<Integer, Double>();
	private static Map<Integer, Double> precioPorKm= new HashMap<Integer, Double>();
	public final static double SUPLEMENTOAEROPUERTO = 6.6;
	
	public static void inicializa() {
		
		servicioMinimo.put(1, 3.90);
		servicioMinimo.put(2, 4.90);
		servicioMinimo.put(3, 2.9);
		servicioMinimo.put(4, 3.15);
		
		bajadaBandera.put(1, 1.35);
		bajadaBandera.put(2, 1.75);
		bajadaBandera.put(3, 1.35);
		bajadaBandera.put(4, 1.65);
		
		precioPorKm.put(1, 0.92);
		precioPorKm.put(2, 1.2);
		precioPorKm.put(3, 0.6);
		precioPorKm.put(4, 0.7);
		
	}
	
	/**
	 * Retorna el valor de servicio mínimo para la tarifa dada
	 * @param tarifa
	 * @return
	 */
	public static double servicioMinimo(int tarifa) {
		return servicioMinimo.get(tarifa);
	}
	
	/**
	 * Retorna el valor de bajada de bandera para la tarifa dada
	 * @param tarifa
	 * @return
	 */
	public static double bajadaBandera(int tarifa) {
		return bajadaBandera.get(tarifa);
	}
	
	/**
	 * Retorna el valor del precio por km recorrido para la tarifa dada
	 * @param tarifa
	 * @return
	 */	
	public static double precioPorKm(int tarifa) {
		return precioPorKm.get(tarifa);
	}
	
}
