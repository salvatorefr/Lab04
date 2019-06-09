package it.polito.tdp.lab04.controller;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import it.polito.tdp.lab04.DAO.CorsoDAO;
import it.polito.tdp.lab04.model.Corso;
import it.polito.tdp.lab04.model.Model;
import it.polito.tdp.lab04.model.Studente;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class SegreteriaStudentiController {
	Model model;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private ComboBox<String> nomeCorso;

    @FXML
    private TextField textMatricola;
  
    @FXML
    private CheckBox checkBox;


    @FXML
    private TextField textNome;

    @FXML
    private TextField textCognome;

    @FXML
    private TextArea textOutput;

    @FXML
    void cercaCorsi(ActionEvent event) {
    	List<Corso> iscrizioniStudente;
    	this.textOutput.clear();
    int matricola=0;
    try {
    	matricola=Integer.parseInt(this.textMatricola.getText());
    }catch (NumberFormatException nfc) {
    	this.textOutput.appendText("Il numero della matricola è errato\n");
    }
    if (matricola!=0) {
    	iscrizioniStudente=	model.cercaIscrizioni(matricola);
    	for (Corso c: iscrizioniStudente) {
    		this.textOutput.appendText(c.getCodins()+" "+c.getNome()+" "+c.getCrediti()+" "+c.getPd()+"\n");
    	}
    }

    }
    @FXML
    void cercaStudente(ActionEvent event) {
    int matricolaStudente=0;
    Studente st= new Studente();
    try { String studenteDaCercare=this.textMatricola.getText();
    	matricolaStudente= Integer.parseInt(studenteDaCercare);
    
    }catch  (NumberFormatException err) {
    	this.textOutput.clear();
    	this.textOutput.appendText("studente non trovato");
    	    }
    
    if (matricolaStudente!=0) {
    	 st= model.cercaStudente(matricolaStudente);
    	 if (st!=null) {
    		 this.textCognome.setText(st.getCognome())    		 ;
    		 this.textNome.setText(st.getNome());
    		 
    	 }
    	 else {
    		 this.textCognome.clear();
    		 this.textNome.clear();
    		 this.textOutput.clear();
    		 this.checkBox.setSelected(false);
    	 this.textOutput.appendText("nessuno studente trovato con questa matricola");
    	 }
    	 
    }
    }


    @FXML
    void cercaIscrittiCorso(ActionEvent event) {
    	this.textOutput.clear();
    	String corso= this.nomeCorso.getValue();
    	System.out.println(corso);
    	if ((corso==null)||(corso.compareTo("")==0))
    		{
    		this.textOutput.appendText("nessun corso selezionato");
    		return;
    		}
    	else {
    	List <Studente> iscritti= model.getIscritti(corso);
    	for (Studente s:iscritti) {
    		this.textOutput.appendText(s+"\n");
    	}
    	}

    }

    @FXML
    void doReset(ActionEvent event) {

    }

    @FXML
    void iscrivi(ActionEvent event) {
    	int matricola=0;
    	String corso="";
    	 try {
    	    	matricola=Integer.parseInt(this.textMatricola.getText());
    	    	corso=this.nomeCorso.getValue();
    	    	
    	    	
    	 }catch(NumberFormatException bf) {
    		 this.textOutput.appendText("errore nell'inserimento dei dati\n");
    	 }
    	 model.iscrivi(matricola,corso);
    	 
    	

    }

    @FXML
    void initialize() {
        assert nomeCorso != null : "fx:id=\"nomeCorso\" was not injected: check your FXML file 'SegreteriaStudenti.fxml'.";
        assert textMatricola != null : "fx:id=\"textMatricola\" was not injected: check your FXML file 'SegreteriaStudenti.fxml'.";
        assert textNome != null : "fx:id=\"textNome\" was not injected: check your FXML file 'SegreteriaStudenti.fxml'.";
        assert textCognome != null : "fx:id=\"textCognome\" was not injected: check your FXML file 'SegreteriaStudenti.fxml'.";
        assert textOutput != null : "fx:id=\"textOutput\" was not injected: check your FXML file 'SegreteriaStudenti.fxml'.";
        CorsoDAO cD= new CorsoDAO();
       List<Corso> corsi= cD.getTuttiICorsi();
       nomeCorso.getItems().add("");
       for (Corso c:corsi) {
    	   this.nomeCorso.getItems().addAll(c.getCodins());
       }

    }

	public void setModel(Model model) {
		this.model=model;
		
	}
}
