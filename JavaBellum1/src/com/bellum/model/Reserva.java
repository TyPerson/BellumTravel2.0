package com.bellum.model;

import java.util.Date;

public class Reserva {
	int protocolo;
	private Date momento;
	private boolean confirmado;
	private int pagamento;
	protected int idReserva;
	protected int idPessoa;
	protected int codViagem;
	

	public Reserva() {
		// TODO Auto-generated constructor stub
	}

	public int getProtocolo() {
		return protocolo;
	}

	public void setProtocolo(int protocolo) {
		this.protocolo = protocolo;
	}

	public Date getMomento() {
		return momento;
	}

	public void setMomento(Date momento) {
		this.momento = momento;
	}

	public boolean isConfirmado() {
		return confirmado;
	}

	public void setConfirmado(boolean confirmado) {
		this.confirmado = confirmado;
	}

	public int getPagamento() {
		return pagamento;
	}

	public void setPagamento(int pagamento) {
		this.pagamento = pagamento;
	}

	public int getIdReserva() {
		return idReserva;
	}
/*
	public void setIdReserva(int idReserva) {
		this.idReserva = idReserva;
	}
*/
	public int getidPessoa() {
		return idPessoa;
	}

	public void setidPessoa(int idPessoa) {
		this.idPessoa = idPessoa;
	}

	public int getCodViagem() {
		return codViagem;
	}

	public void setCodViagem(int codViagem) {
		this.codViagem = codViagem;
	}
	
	public void confirmar() {
		this.confirmado = true;
	}
	public void cancelar() {
		this.confirmado = false;
	}
		

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
