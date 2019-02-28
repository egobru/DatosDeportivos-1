package com.acing.eventos;

import java.util.Collection;

public interface GestorSucesos<T extends Suceso> extends Evento {

	Collection<T>  getSucesosGestionados();
	
	Collection<T>  getSucesosParticipante(Participante participante);
	
	public void addSuceso(T suceso);
	
	public void addSuceso(Class<T> tipoSuceso, Participante participante);
	
	public void addSuceso(Class<T> tipoSuceso, int numero, Participante participante);
	
	
	
	
}
