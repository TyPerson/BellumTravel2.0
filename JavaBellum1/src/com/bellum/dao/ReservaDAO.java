package com.bellum.dao;

/* Remember...
 *  	Create, Read, Update, Delete
 * */
import com.bellum.connect.*;
import java.sql.Connection;
import com.bellum.model.Reserva;
//import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
//import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class ReservaDAO {

		Connection conn = null;
		PreparedStatement pstm = null;

	public void save(Reserva reserva) {
		String sql = "INSERT INTO Reserva (destino, periodo, vagas, itinerario, programacao, dataInicio, dataFim) VALUES (?,?,?,?,?,?,?);";
		
		try {
			//Create DB connection
			conn = ConnectionFacility.createConnectionToMySQL();
			// Create a PreparedStatement, to execute one query
			pstm = (PreparedStatement) conn.prepareStatement(sql);
			// Add values by query
			
			
			
			
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
	public void removeById(int idReserva) {
		
		String sql = "DELETE FROM Reserva WHERE idReserva = ?";
		
		try {
			conn = ConnectionFacility.createConnectionToMySQL();
			pstm = conn.prepareStatement(sql);
			pstm.setInt(1, idReserva);
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

	public List<Reserva> getPessoass() {

		String sql = "SELECT * FROM Pessoas";

		List<Reserva> reservas = new ArrayList<Reserva>();

		ResultSet rset = null;
		try {
			conn = ConnectionFacility.createConnectionToMySQL();
			pstm = conn.prepareStatement(sql);
			rset = pstm.executeQuery();
			
			while (rset.next()) {
				
				Reserva reserva = new Reserva();
				
			//	reserva.setIdPessoa(rset.getInt("idReserva"));
				
				
				
				
				
				reservas.add(reserva);
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
		return reservas;
	}
	
	public Reserva getPessoaoById(int idReserva) {

		String sql = "SELECT * FROM Reserva where idReserva = ?";
		Reserva reserva = new Reserva();

		ResultSet rset = null;

		try {
			conn = ConnectionFacility.createConnectionToMySQL();
			pstm = conn.prepareStatement(sql);
			pstm.setInt(1, idReserva);
			rset = pstm.executeQuery();

			rset.next();
			
			
			
			
		
			
			
		
			
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
		return reserva;
	}
}




















