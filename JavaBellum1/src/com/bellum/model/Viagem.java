package com.bellum.model;

//import java.util.Date;

public class Viagem {
	protected int codigo;
	private int destino;
	private int periodo;
	private int vagas;
	private String itinerario;
	private String programacao;
	private String dataInicio;
	private String dataFim;
	// to add total price
	
	public Viagem() {
		// TODO Auto-generated constructor stub
	}

	
	public int getCodigo() {
		return codigo;
	}
/*
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
*/
	public int getDestino() {
		return destino;
	}

	public void setDestino(int destino) {
		this.destino = destino;
	}

	public int getPeriodo() {
		return periodo;
	}

	public void setPeriodo(int periodo) {
		this.periodo = periodo;
	}

	public int getVagas() {
		return vagas;
	}

	public void setVagas(int vagas) {
		this.vagas = vagas;
	}

	public String getItinerario() {
		return itinerario;
	}

	public void setItinerario(String itinerario) {
		this.itinerario = itinerario;
	}

	public String getProgramacao() {
		return programacao;
	}

	public void setProgramacao(String programacao) {
		this.programacao = programacao;
	}

	public String getDataInicio() {
		return dataInicio;
	}

	public void setDataInicio(String dataInicio) {
		this.dataInicio = dataInicio;
	}

	public String getDataFim() {
		return dataFim;
	}

	public void setDataFim(String dataFim) {
		this.dataFim = dataFim;
	}

	public void addVaga(int v) {
		this.vagas = this.vagas + v;
	}
	
	public void remVaga(int v) {
		this.vagas = this.vagas - v;
	}
	
	public void editViagem(String iti, String prog) {
		setItinerario(iti); setProgramacao(prog);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
