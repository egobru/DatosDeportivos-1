package com.acing.eventos;
import java.util.HashMap;
import java.util.Map;

public class Participante implements Identificable {
	public static Map<String, Participante> mapaParticipantes = new HashMap<>();
	private String nombre;
	private String id;
	
	public Participante() {
	}
	
	
	public Participante(String id, String nombre) {
		this.id = id;
		this.nombre = nombre;
		if(!mapaParticipantes.containsKey(id)) {
			mapaParticipantes.put(id, this);
		}
	}

	@Override
	public String toString() {
		return nombre;
	}

	@Override
	public String getId() {
		
		return id;
	}

	
	
}
