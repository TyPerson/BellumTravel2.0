package com.bellum.dao;

/* Memorando...
 *  	Create, Read, Update, Delete
 * */
import com.bellum.connect.*;
import java.sql.Connection;
import com.bellum.model.Pessoa;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class PessoaDAO {

		Connection conn = null;
		PreparedStatement pstm = null;

	public void save(Pessoa pessoa) {
		String sql = "INSERT INTO Pessoa (nome, cpf, telefone, email, endereco, sexo) VALUES (?,?,?,?,?,?);";
		
		try {
			//Create DB connection
			conn = ConnectionFacility.createConnectionToMySQL();
			// Create a PreparedStatement, to execute one query
			pstm = (PreparedStatement) conn.prepareStatement(sql);
			// Add values by query
			pstm.setString(1, pessoa.getNome());
			pstm.setString(2, pessoa.getCPF());
			pstm.setString(3, pessoa.getTelefone());
			pstm.setString(4, pessoa.getEmail());
			pstm.setString(5, pessoa.getEndereco());
			pstm.setString(6, pessoa.getSexo());
			
			// Execute the query
			pstm.execute();
			System.out.println("New person sucessfully saved!");
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			
			// Close all connections
			try {
				if(pstm!=null) {
					pstm.close();
				}
				
				if (conn!=null) {
					conn.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
	}
	public void removeById(int idPessoa) {
		
		String sql = "DELETE FROM Pessoa WHERE idPessoa = ?";
		
		try {
			conn = ConnectionFacility.createConnectionToMySQL();
			pstm = conn.prepareStatement(sql);
			pstm.setInt(1, idPessoa);
			pstm.execute();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {

			try {
				if (pstm != null) {
					pstm.close();
				}
				if (conn != null) {
					conn.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	public List<Pessoa> getPessoass() {

		String sql = "SELECT * FROM Pessoas";

		List<Pessoa> pessoas = new ArrayList<Pessoa>();

		ResultSet rset = null;
		try {
			conn = ConnectionFacility.createConnectionToMySQL();
			pstm = conn.prepareStatement(sql);
			rset = pstm.executeQuery();
			
			while (rset.next()) {
				
				Pessoa pessoa = new Pessoa();
				
			//	pessoa.setIdPessoa(rset.getInt("idPessoa"));
				
				pessoa.setNome(rset.getString("nome"));
			
				pessoa.setManager(rset.getBoolean("manager"));
				
				pessoa.setCPF(rset.getString("cpf"));
				
				pessoa.setTelefone(rset.getString("telefone"));
				
				pessoa.setEmail(rset.getString("email"));
				
				pessoa.setEndereco(rset.getString("endereco"));
				
				pessoa.setSexo(rset.getString("sexo"));
				
				pessoas.add(pessoa);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (rset != null) {
					rset.close();
				}
				if (pstm != null) {
					pstm.close();
				}
				if (conn != null) {
					conn.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return pessoas;
	}
	
	public Pessoa getPessoaoById(int idPessoa) {

		String sql = "SELECT * FROM Pessoa where idPessoa = ?";
		Pessoa pessoa = new Pessoa();

		ResultSet rset = null;

		try {
			conn = ConnectionFacility.createConnectionToMySQL();
			pstm = conn.prepareStatement(sql);
			pstm.setInt(1, idPessoa);
			rset = pstm.executeQuery();

			rset.next();
			
			pessoa.setNome(rset.getString("nome"));
			
			pessoa.setManager(rset.getBoolean("manager"));
			
			pessoa.setCPF(rset.getString("cpf"));
			
			pessoa.setTelefone(rset.getString("telefone"));
			
			pessoa.setEmail(rset.getString("email"));
			
			pessoa.setEndereco(rset.getString("endereco"));
			
			pessoa.setSexo(rset.getString("sexo"));
			
			
		
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (rset != null) {
					rset.close();
				}
				if (pstm != null) {
					pstm.close();
				}
				if (conn != null) {
					conn.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return pessoa;
	}
}




















