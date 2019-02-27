package com.acing.eventos;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import es.lanyu.commons.identificable.AbstractNombrable;

public class Participante extends AbstractNombrable {
	
	public static Map<String, Participante> mapaParticipantes = new HashMap<>();
	
	
//	@Override
//	public String getIdentificador() {
//		return id;
//	}
	
	public Participante() {
	}
	
	public Participante(String nombre) {
//		this.nombre = nombre;
		setIdentificador(nombre);
		setNombre(nombre);
		if(!mapaParticipantes.containsKey(id)) {//Al cerar el objeto, lo incluyo en el Map.
			mapaParticipantes.put(id, this);
		}
	}

	@Override
	public String toString() {
		return nombre;
	}
	
	public Collection<Participante> getParticipantesRegistrados(){
		Collection<Participante> aux = new ArrayList<>();
		mapaParticipantes.forEach((id, participante) -> aux.add(participante));//recorro el Map y cojo todos los Participantes del Mapa.
		return aux;
	}
	
}
