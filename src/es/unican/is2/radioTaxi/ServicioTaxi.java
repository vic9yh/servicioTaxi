package es.unican.is2.radioTaxi;

import java.util.Calendar;

/**
 * Clase que representa un trayecto realizado por un taxi
 * @author IS2
 *  @version May 2015
 */
public class ServicioTaxi {
	
	private Calendar horaInicio;
	private Calendar horaFin;
	private double kms;
	private boolean urbano;
	private boolean aeropuerto;
	
	public class ValorNoValidoException extends RuntimeException {
		private static final long serialVersionUID = 1L;
		
	}
	
	public ServicioTaxi(Calendar horaInicio, Calendar horaFin, double kms, boolean urbano,
			boolean aeropuerto) throws ValorNoValidoException 
			{
		if (horaInicio == null || horaFin == null || kms <= 0)
			throw new ValorNoValidoException();
		
		this.horaInicio = horaInicio;
		this.horaFin = horaFin;
		this.kms = kms;
		this.urbano = urbano;
		this.aeropuerto = aeropuerto;
		TarifasRadioTaxi.inicializa();
	}
	
	public Calendar getHoraInicio() {
		return horaInicio;
	}
	public Calendar getHoraFin() {
		return horaFin;
	}
	public double getKms() {
		return kms;
	}
	public boolean isUrbano() {
		return urbano;
	}
	public boolean isAeropuerto() {
		return aeropuerto;
	}
	
	public double importeServicio() {
		double importe;
		// Calculo de tarifa
		int tarifa = calculoTarifa(horaInicio, urbano);
			
		importe = TarifasRadioTaxi.bajadaBandera(tarifa) + getKms()* TarifasRadioTaxi.precioPorKm(tarifa);
		
		if (importe<TarifasRadioTaxi.servicioMinimo(tarifa))
			importe = TarifasRadioTaxi.servicioMinimo(tarifa);
		
		if (aeropuerto)
			return importe + TarifasRadioTaxi.SUPLEMENTOAEROPUERTO;
		
		return importe;
	}
	
	private static int calculoTarifa (Calendar fecha, boolean urbano) {
		int diaSemana = fecha.get(Calendar.DAY_OF_WEEK);
		int hora = fecha.get(Calendar.HOUR_OF_DAY);
		
		boolean diurna = false;
		
		if (diaSemana >= Calendar.MONDAY && diaSemana <Calendar.SATURDAY ) {
			// Lunes a Viernes
			if (hora>=6 && hora<22)
				diurna = true;
		} else if (diaSemana == Calendar.SATURDAY) {
			// Sabado
			if (hora>=8 && hora<15)
				diurna = true;
		}
		
		if (diurna && urbano) 
			return 1;
		if (!diurna && urbano)
			return 2;
		if (diurna && !urbano)
			return 3;
		return 4;
	}

	
	
	
}
