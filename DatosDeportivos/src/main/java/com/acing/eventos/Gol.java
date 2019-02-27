package com.acing.eventos;

public class Gol extends Suceso {

	private int minuto;
	
	
	public Gol(int minuto, Participante anotador) {
		super(anotador);
		this.minuto = minuto;
	}

	public Participante getParticipanteAnotador() {
		return this.getParticipante();
	}
	
	public int getMinuto() {
		return minuto;
	}
	
	
	
	
	




	
}
