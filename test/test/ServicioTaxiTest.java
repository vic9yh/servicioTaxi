package test;

import static org.junit.Assert.*;

import java.util.Calendar;

import org.junit.Test;

import es.unican.is2.radioTaxi.ServicioTaxi;

public class ServicioTaxiTest {

	private ServicioTaxi s;
	private Calendar horaInicio;
	private double importe;

	@Test
	public void testImporteServicioCajaNegra() {
		// {URBANO, 6, True, L,3} 
		 horaInicio = Calendar.getInstance();
		horaInicio.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);
		horaInicio.set(Calendar.HOUR_OF_DAY, 6);		
		s = new ServicioTaxi(horaInicio, horaInicio, 3, true, true);
		importe = s.importeServicio();
		assertTrue("El importe sale "+importe, importe== 11.71);
		
		// {INTERURBANO, 7, False, M,5}
		horaInicio.set(Calendar.DAY_OF_WEEK, Calendar.TUESDAY);
		horaInicio.set(Calendar.HOUR_OF_DAY, 7);
		s = new ServicioTaxi(horaInicio, horaInicio, 5, false, false);	
		importe = s.importeServicio();
		assertTrue("El importe sale "+importe, importe== 4.35);
		
		// {URBANO, 8, True, X,10}
		horaInicio.set(Calendar.DAY_OF_WEEK, Calendar.WEDNESDAY);
		horaInicio.set(Calendar.HOUR_OF_DAY, 8);
		s = new ServicioTaxi(horaInicio, horaInicio, 10, true, true);	
		importe = s.importeServicio();
		assertTrue("El importe sale "+importe, importe== 17.15);
		
		// {INTERURBANO, 12, False, J,3}
		horaInicio.set(Calendar.DAY_OF_WEEK, Calendar.THURSDAY);
		horaInicio.set(Calendar.HOUR_OF_DAY, 12);
		s = new ServicioTaxi(horaInicio, horaInicio, 3, false, false);	
		importe = s.importeServicio();
		assertTrue("El importe sale "+importe, importe== 3.15);		
		
		// {URBANO, 15, false, V,5}
		horaInicio.set(Calendar.DAY_OF_WEEK, Calendar.FRIDAY);
		horaInicio.set(Calendar.HOUR_OF_DAY, 15);
		s = new ServicioTaxi(horaInicio, horaInicio, 5, true, false);	
		importe = s.importeServicio();
		assertTrue("El importe sale "+importe, importe== 0.92*5 + 1.35);	
		
		// {INTERURBANO, 18, False, S,10}
		horaInicio.set(Calendar.DAY_OF_WEEK, Calendar.SATURDAY);
		horaInicio.set(Calendar.HOUR_OF_DAY, 18);
		s = new ServicioTaxi(horaInicio, horaInicio, 10, false, false);	
		importe = s.importeServicio();
		assertTrue("El importe sale "+importe, importe== 8.65);	
		
		// {URBANO, 22, True, D,3}
		horaInicio.set(Calendar.DAY_OF_WEEK, Calendar.SUNDAY);
		horaInicio.set(Calendar.HOUR_OF_DAY, 22);
		s = new ServicioTaxi(horaInicio, horaInicio, 3, true, true);	
		importe = s.importeServicio();
		assertTrue("El importe sale "+importe, importe== 11.95);	
		
		// {{INTERURBANO, 23:30, True, L,5}
		horaInicio.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);
		horaInicio.set(Calendar.HOUR_OF_DAY, 23);
		horaInicio.set(Calendar.MINUTE, 30);
		s = new ServicioTaxi(horaInicio, horaInicio, 5, false, true);	
		importe = s.importeServicio();
		assertTrue("El importe sale "+importe, importe== 11.75);	
		
		// {URBANO, 24:00, True, V,1}
		horaInicio.set(Calendar.DAY_OF_WEEK, Calendar.FRIDAY);
		horaInicio.set(Calendar.HOUR_OF_DAY, 24);
		s = new ServicioTaxi(horaInicio, horaInicio, 1, true, true);	
		importe = s.importeServicio();
		assertTrue("El importe sale "+importe, importe== 11.5);	
		
		// {INTERURBANO, 3:00, False, S,1}
		horaInicio.set(Calendar.DAY_OF_WEEK, Calendar.SATURDAY);
		horaInicio.set(Calendar.HOUR_OF_DAY, 3);
		s = new ServicioTaxi(horaInicio, horaInicio, 1, false, false);	
		importe = s.importeServicio();
		assertTrue("El importe sale "+importe, importe== 3.15);		
		
	}
	
	@Test
	public void testImporteServicioCajaBlanca () {
		// {INTERURBANO, 12:00, False, S, 1}
		 horaInicio = Calendar.getInstance();
				horaInicio.set(Calendar.DAY_OF_WEEK, Calendar.SATURDAY);
				horaInicio.set(Calendar.HOUR_OF_DAY, 12);
				s = new ServicioTaxi(horaInicio, horaInicio, 1, false, false);	
				importe = s.importeServicio();
				assertTrue("El importe sale "+importe, importe== 2.90);
				
				
		// {URBANO, 3:00, False, S, 1} PAra poner una hora <6 entresemana
				horaInicio.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);
				horaInicio.set(Calendar.HOUR_OF_DAY, 3);
				s = new ServicioTaxi(horaInicio, horaInicio,3, true, false);	
				importe = s.importeServicio();
				assertTrue("El importe sale "+importe, importe== 5.35);
				
				
				 horaInicio = Calendar.getInstance();
					horaInicio.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);
					horaInicio.set(Calendar.HOUR_OF_DAY, 12);
					s = new ServicioTaxi(horaInicio, horaInicio, 1, false, false);	
					importe = s.importeServicio();
					assertTrue("El importe sale "+importe, importe== 2.90);		
				
				
				
				
				
				
	}
}
