package com.acing.app;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

import com.acing.eventos.Evento;
import com.acing.serial.SerializadorCSV;
import com.acing.serial.SerializadorDate;
import com.esotericsoftware.jsonbeans.Json;
import com.esotericsoftware.jsonbeans.OutputType;

public class App {

	public static void main(String[] args) {
		System.out.println("FUNCIONA!!!");
		
		Collection<Evento> eventos;
		Json json = new Json(OutputType.json);
		String rutaCsv = "datos/SP1.csv";
		String rutaJson = "datos/eventos.json";
		
		// LEER DESDE EL CSV
		eventos = SerializadorCSV.getEventos(rutaCsv);
		
		// CONVERTIR eventos a JSON
//		String eventosJson = json.prettyPrint(eventos);
//		System.out.println(eventosJson);
		guardarColeccionAJsonPorLineas(eventos, rutaJson);
		
		// Guardar un String a disco
//		guardarStringEnFichero(eventosJson, rutaJson);
		
//		eventos = json.fromJson(ArrayList.class, rutaJson);
		eventos = getEventosFromJson(rutaJson);
		
		// Imprimir eventos
		for (Evento evento : eventos) {
			System.out.println(evento);
		}
	}

	private static void guardarStringEnFichero(String cadena, String ruta) {
		try (BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(
	              new FileOutputStream(ruta), "UTF-8"))) {
			writer.write(cadena);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private static void guardarColeccionAJsonPorLineas(Collection<Evento> eventos, String ruta) {
		Json json = new Json();
		json.setSerializer(Date.class, new SerializadorDate());
		try (BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(
	              new FileOutputStream(ruta), "UTF-8"))) {
			for (Evento evento : eventos) {
				writer.write(json.toJson(evento));
				writer.newLine();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private static Collection<Evento> getEventosFromJson(String rutaArchivo) {
		Collection<Evento> eventosLeidos = new ArrayList<>();
		Json json = new Json();
		json.setSerializer(Date.class, new SerializadorDate());
		try (BufferedReader reader = new BufferedReader(
				new InputStreamReader(
						new FileInputStream(rutaArchivo),
						"UTF-8"))){
			
			String linea;
			while((linea = reader.readLine()) != null) {
				eventosLeidos.add(json.fromJson(Evento.class, linea));
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return eventosLeidos;
	}

}
