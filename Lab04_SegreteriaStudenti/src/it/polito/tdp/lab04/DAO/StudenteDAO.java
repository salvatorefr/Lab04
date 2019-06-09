package it.polito.tdp.lab04.DAO;


import it.polito.tdp.lab04.model.Corso;
import it.polito.tdp.lab04.model.Studente;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class StudenteDAO {

	public Studente cercaStudente(Studente daCercare) {
		int matricola= daCercare.getMatricola();
		
		String sql = "SELECT * FROM studente WHERE matricola=?";
		Studente cercato;
		try {
			Connection conn = ConnectDB.getConnection();
			PreparedStatement st = conn.prepareStatement(sql);
			st.setInt(1, matricola);
			ResultSet rs = st.executeQuery();

			if (rs.next()) {
				int matricola2=rs.getInt(1);
				String cognome= rs.getString(2);
				String nome=rs.getString(3);
				String cds=rs.getString(4);
				cercato= new Studente (nome,cognome,matricola2,cds);
				conn.close();
			}
			
			else cercato= null;
		}catch (SQLException sExcp) {return null;}

			return  cercato;

			
		
		
	}

	public List<Studente> cercaIscrittiCorso(String corso) {
		List<Studente> iscritti= new ArrayList<Studente>();
		String query="SELECT s.matricola,s.cognome,s.nome,s.CDS FROM studente AS s,iscrizione AS i WHERE s.matricola= i.matricola AND i.codins = ? ";
		try {
			Connection conn = ConnectDB.getConnection();
			PreparedStatement st = conn.prepareStatement(query);
			st.setString(1, corso);
			ResultSet rs = st.executeQuery();

			while (rs.next()) {
				String nome=rs.getString(3);
				String cognome=rs.getString(2);
				int matricola=rs.getInt(1);
				String cds=rs.getString(4);
				iscritti.add(new Studente(nome,cognome,matricola,cds));
			}
				
			}catch(SQLException se) {}
	return iscritti;
	}

	public List<Corso> cercaIscrizioni(int matricola) {
		List<Corso> iscrizioniStudente= new ArrayList<Corso>();
		String query="SELECT c.codins,c.crediti,c.nome,c.pd FROM corso c, iscrizione i,studente s WHERE c.codins=i.codins AND s.matricola=i.matricola AND s.matricola=?";
		try {
			Connection conn = ConnectDB.getConnection();
			PreparedStatement st = conn.prepareStatement(query);
			st.setInt(1, matricola);
			ResultSet rs = st.executeQuery();

			while (rs.next()) {
				Corso c=new Corso();
			c.setCodins(rs.getString(1));
			c.setNome(rs.getString(3));
			c.setCrediti(rs.getInt(2));
			c.setPd(rs.getInt(4));
				iscrizioniStudente.add(c);
				
			}
			conn.close();
		}catch(SQLException se) {}
		return iscrizioniStudente;
		
		
		
		
		
		
		
	}
	
	
	
	
	
	
	
	
	
	

}
