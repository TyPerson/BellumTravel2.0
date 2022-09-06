/**
 * 
 */
package com.bellum.model;

/**
 * @author tkfn
 *
 */


public class Pessoa {

	/**
	 * to implement age after...
	 */
	protected int idPessoa;
	protected String nome;
	protected boolean manager;
	private static String CPF;
	private String telefone;
	private String email;
	private String endereco;
	private String Sexo;
	
	public Pessoa() {
		//
		
	}

	public int getIdPessoa() {
		return idPessoa;
	}
/*
	public void setIdPessoa(int idPessoa) {
		this.idPessoa = idPessoa;
	}
*/
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Boolean getManager() {
		return manager;
	}

	public void setManager(Boolean manager) {
		this.manager = manager;
	}

	public String getCPF() {
		return CPF;
	}

	public void setCPF(String cpf) {
		this.CPF = cpf;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getSexo() {
		return Sexo;
	}

	public void setSexo(String sexo) {
		Sexo = sexo;
	}

	
	public void editPessoa(String n, boolean m, String cel, String e, String ende, String sx) {
		if(sx != "F") {
			System.out.println("Assuming that sex is MALE, as standard... ");
			sx = "M";
		}
		
		setNome(n); setTelefone(cel); setEmail(e); setEndereco(ende); setSexo(sx);
		
	}
	
	public void showPessoa() {
		System.out.println("ID: " + getIdPessoa());
		System.out.println("Nome: " + getNome());
		System.out.println("MGR status: " + getManager());
		System.out.println("CPF: " + getCPF());
		System.out.println("tel.: " + getTelefone());
		System.out.println("E-mail: " + getEmail());
		System.out.println("End.: " + getEndereco());
		System.out.println("Sexo (F = FEM / M = MASC): " + getSexo());
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	}

}
