package com.bellum.app;

//import com.bellum.connect.*;
import com.bellum.model.*;
import com.bellum.dao.*;

public class Main {

	public Main() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		PessoaDAO pessoaDAO = new PessoaDAO();
		
		Pessoa pessoa = new Pessoa();
		pessoa.setNome("Jorge Junior");
		pessoa.setCPF("200.169.978-44");
		

		pessoaDAO.save(pessoa);

	}

}
