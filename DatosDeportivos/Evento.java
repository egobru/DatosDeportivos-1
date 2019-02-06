package com.acing.eventos;
import java.util.Date;

public class Evento {
	private Participante local;
	private Participante visitante;
	private Date fecha;
	private String resultado;
	// No tiene por que ser un evento con goles
//	private int golesLocal;
//	private int golesVisitante;
	
	protected Date getFecha() {
		return fecha;
	}
	
	public void setResultado(String resultado) {
		this.resultado = resultado;
	}

	public Evento() {}
	
	public Evento(Participante local, Participante visitante, Date fecha) {
		super();
		this.local = local;
		this.visitante = visitante;
		this.fecha = fecha;
	}

	@Override
	public String toString() {
		return "(" + fecha + ") " + local + " vs " + visitante + " => " + resultado;
	}
	
	
}
