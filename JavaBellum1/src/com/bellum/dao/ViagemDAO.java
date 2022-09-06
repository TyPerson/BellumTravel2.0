package com.bellum.dao;

/* Remember...
 *  	Create, Read, Update, Delete
 * */
import com.bellum.connect.*;
import java.sql.Connection;
import com.bellum.model.Viagem;
//import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
//import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class ViagemDAO {

		Connection conn = null;
		PreparedStatement pstm = null;

	public void save(Viagem viagem) {
		String sql = "INSERT INTO Viagem (destino, periodo, vagas, itinerario, programacao, dataInicio, dataFim) VALUES (?,?,?,?,?,?,?);";
		
		try {
			//Create DB connection
			conn = ConnectionFacility.createConnectionToMySQL();
			// Create a PreparedStatement, to execute one query
			pstm = (PreparedStatement) conn.prepareStatement(sql);
			// Add values by query
			pstm.setInt(1, viagem.getDestino());
			pstm.setInt(2, viagem.getPeriodo());
			pstm.setInt(3, viagem.getVagas());
			pstm.setString(4, viagem.getItinerario());
			pstm.setString(5, viagem.getProgramacao());
			pstm.setString(6, viagem.getDataInicio());
			pstm.setString(7, viagem.getDataFim());
			
			// Execute the query
			pstm.execute();
			System.out.println("New trip sucessfully saved!");
			
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
	public void removeById(int codigo) {
		
		String sql = "DELETE FROM Viagem WHERE codigo = ?";
		
		try {
			conn = ConnectionFacility.createConnectionToMySQL();
			pstm = conn.prepareStatement(sql);
			pstm.setInt(1, codigo);
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

	public List<Viagem> getPessoass() {

		String sql = "SELECT * FROM Pessoas";

		List<Viagem> viagens = new ArrayList<Viagem>();

		ResultSet rset = null;
		try {
			conn = ConnectionFacility.createConnectionToMySQL();
			pstm = conn.prepareStatement(sql);
			rset = pstm.executeQuery();
			
			while (rset.next()) {
				
				Viagem viagem = new Viagem();
				
			//	viagem.setIdPessoa(rset.getInt("codigo"));
				
				pstm.setInt(1, viagem.getDestino());
				pstm.setInt(2, viagem.getPeriodo());
				pstm.setInt(3, viagem.getVagas());
				pstm.setString(4, viagem.getItinerario());
				pstm.setString(5, viagem.getProgramacao());
				pstm.setString(6, viagem.getDataInicio());
				pstm.setString(7, viagem.getDataFim());
				
				
				viagens.add(viagem);
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
		return viagens;
	}
	
	public Viagem getPessoaoById(int codigo) {

		String sql = "SELECT * FROM Viagem where codigo = ?";
		Viagem viagem = new Viagem();

		ResultSet rset = null;

		try {
			conn = ConnectionFacility.createConnectionToMySQL();
			pstm = conn.prepareStatement(sql);
			pstm.setInt(1, codigo);
			rset = pstm.executeQuery();

			rset.next();
			
			viagem.setDestino(rset.getInt("destino"));
			
			viagem.setPeriodo(rset.getInt("periodo"));
			
			viagem.setVagas(rset.getInt("vagas"));
			
			viagem.setItinerario(rset.getString("itinerario"));
			
			viagem.setProgramacao(rset.getString("programacao"));
			
			viagem.setDataInicio(rset.getString("dataInicio"));
			
			viagem.setDataFim(rset.getString("dataFim"));
				
		
			
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
		return viagem;
	}
}




















