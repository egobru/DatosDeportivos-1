package com.acing.eventos;

import java.util.Collection;

public interface GestorSucesos<T extends Suceso> extends Evento {

	Collection<T>  getSucesosGestionados();
	
	Collection<T>  getSucesosParticipante(Participante participante);
	
	public void addSucesoInterfaz(T suceso);//Le he tenido que cambiar el nombre por el Ersaure de Evento.
	
	public void addSuceso(T suceso);
	
	public void addSuceso(T suceso, int numero, Participante participante);
	
	
	
	
}
