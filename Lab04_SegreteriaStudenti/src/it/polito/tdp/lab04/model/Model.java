package it.polito.tdp.lab04.model;

import java.util.List;

import it.polito.tdp.lab04.DAO.CorsoDAO;
import it.polito.tdp.lab04.DAO.StudenteDAO;

public class Model {

	public Studente cercaStudente(int matricolaStudente) {
		Studente daCercare=new Studente("","",matricolaStudente,"");
		StudenteDAO sd= new StudenteDAO();
		return sd.cercaStudente(daCercare);
		
	}

	public List<Studente> getIscritti(String corso) {
	StudenteDAO sd= new StudenteDAO();
	
		return sd.cercaIscrittiCorso(corso);
	}

	public List<Corso> cercaIscrizioni(int matricola) {
		StudenteDAO sd= new StudenteDAO();
		return sd.cercaIscrizioni(matricola);
	}

	public boolean iscrivi(int matricola, String corso) {
	//controllo se esiste la matricola
	Studente st=(cercaStudente(matricola));
	if (st.getMatricola()!=matricola) {return false;}

	CorsoDAO cd= new CorsoDAO();
	Corso daCercare= new Corso();
	daCercare.setCodins(corso);
	if (cd.getCorso(daCercare).getCodins().compareTo(corso)!=0) {
		return false;}

	
	return cd.iscriviStudenteACorso(new Studente("","",matricola,""),daCercare);
	}
	

	
	
}
