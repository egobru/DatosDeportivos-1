package com.acing.serial;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.UnsupportedEncodingException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

import com.acing.eventos.Evento;
import com.acing.eventos.Participante;

public class SerializadorCSV {

	public static Collection<Evento> getEventos(String rutaArchivo){
		Collection<Evento> eventosLeidos = new ArrayList<>();
		
		try (BufferedReader reader = new BufferedReader(
				new InputStreamReader(
						new FileInputStream(rutaArchivo),
						"UTF-8"))){
			
			String linea = reader.readLine();// Leo la primera linea
			while((linea = reader.readLine()) != null) {
				eventosLeidos.add(deserializarEvento(linea));
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return eventosLeidos;
	}
	
	public static Evento deserializarEvento(String linea) throws ParseException {
		String[] campos = linea.split(",");
		String division = campos[0];
		String fechaString = campos[1];
		String localString = campos[2];
		String visitanteString = campos[3];
		String golesLocalString = campos[4];
		String golesVisitanteString = campos[5];
		
		SimpleDateFormat sdformat = new SimpleDateFormat("dd/MM/yy");
		
		Date fecha = sdformat.parse(fechaString);
		Participante local = new Participante(generarId(division, localString), localString);
		Participante visitante = new Participante(generarId(division, visitanteString),visitanteString);
		int golesLocal = Integer.parseInt(golesLocalString);
		int golesVisitante = Integer.parseInt(golesVisitanteString);
		String resultado = golesLocal + "-" + golesVisitante;
		
		// NO SE HACE ASI
//		Evento miEvento = new Evento();
//		miEvento.local = local;
//		miEvento.visitante = visitante;
//		miEvento.fecha = fecha;
//		miEvento.golesLocal = golesLocal;
//		miEvento.golesVisitante = golesVisitante;
		
		Evento miEvento = new Evento(local, visitante, fecha);
		miEvento.setResultado(resultado);
		
		return miEvento;
	}
	
	public static String generarId(String division, String nombreParticipante) {
		
		String idParticipante = division;
		idParticipante += nombreParticipante.substring(0,1) 
				+ nombreParticipante.substring(nombreParticipante.length()-2,nombreParticipante.length()-1)+
				 nombreParticipante.substring(nombreParticipante.length()-1,nombreParticipante.length());
		return idParticipante;
	}
}
