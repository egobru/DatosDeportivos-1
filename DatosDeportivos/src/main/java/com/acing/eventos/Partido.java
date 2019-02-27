package com.acing.eventos;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;


public class Partido extends EventoImpl implements EventoConGoles, GestorSucesos<Suceso> {
	private final static SimpleDateFormat sdfToString= new SimpleDateFormat("dd/MM/yy HH:mm");
	private Participante local;
	private Participante visitante;
//	String resultado;
	
	@Override
	public String getResultado() {
		long golesLocal = 0;// = getSucesos().stream()
//							.filter(s -> s.getParticipante().equals(local))
//							.count();
		long golesVisitante = 0;
		for (Suceso s : getSucesos()) {
			if(s.getParticipante().equals(visitante))
				golesVisitante++;
			if(s.getParticipante().equals(local))
				golesLocal++;
		}
		return golesLocal + "-" + golesVisitante;
	}
	
//	public void setResultado(String resultado) {
////		this.resultado = resultado;
//	}

	public Partido() {}
	
	public Partido(Participante local, Participante visitante, Date fecha) {
		super();
		this.local = local;
		this.visitante = visitante;
		setFecha(fecha);
	}

	@Override
	public String toString() {
		return "(" + sdfToString.format(getFecha()) + ") " + local + " vs " + visitante + " => " + getResultado();
	}

	@Override
	public Participante getGanador() {
		
		return null;
	}

	@Override
	public Participante getLocal() {
		return local;
	}

	@Override
	public Participante getVisitante() {
		return visitante;
	}

	@Override
	public Collection<Gol> getGoles() {//No se puede hacer el Casteo (Downcast). 
										//Voy a crear un Array Aux para meter los objetos tipo Gol
		Collection<Gol> aux = new ArrayList<>();
		for (Suceso s : getSucesos()) {
			if(s instanceof Gol) {//Compruebo que el Suceso es del tipo Gol. Si lo es, entra en mi array aux.
				aux.add((Gol) s);
			}
		}
		return aux;			
	}

	@Override
	public int getGolesParticipante(Participante participante) {//Voy a necesitar comparar los participantes con su ID. 
		int golesParticipante = 0;								//Otra opci�n podr�a ser con el comparador de SU libreria.
		for (Suceso s : getSucesos()) {
//			if(s.getParticipante().getIdentificador().equals(participante.getIdentificador())) {//sumo cuando el anotador 
//																//es el participante que busco
//				golesParticipante++;
//			}
			if(s.getParticipante().isEquals(participante)) {//Utilizando su libreria
				golesParticipante++;
			}
		}		
		return golesParticipante;
	}

	@Override
	public void addGoles(int numGolesLocal, int numGolesVisitante) {//Lo que hacemos es crear Objetos tipo Gol
																	//tantos como diga el par�metro de entrada.
		for (int i=0; i<numGolesLocal; i++) {
			Gol golLocal = new Gol(0, getLocal());
			addSuceso(golLocal);
		}
		
		for (int i=0; i<numGolesVisitante; i++) {
			Gol golVisitante = new Gol(0, getVisitante());
			addSuceso(golVisitante);
		}
	}

	@Override
	public Collection<Suceso> getSucesosGestionados() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Collection<Suceso> getSucesosParticipante(Participante participante) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void addSucesoInterfaz(Suceso suceso) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void addSuceso(Suceso gol) {
		getSucesos().add(gol);
		
	}

	@Override
	public void addSuceso(Suceso suceso, int numero, Participante participante) {
		// TODO Auto-generated method stub
		
	}
	
}
