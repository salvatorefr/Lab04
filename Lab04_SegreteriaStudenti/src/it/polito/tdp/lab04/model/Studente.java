package it.polito.tdp.lab04.model;

public class Studente {
	private String nome;
	private String cognome;
	private int matricola;
	private String cds;
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCognome() {
		return cognome;
	}
	public void setCognome(String cognome) {
		this.cognome = cognome;
	}
	public int getMatricola() {
		return matricola;
	}
	public void setMatricola(int matricola) {
		this.matricola = matricola;
	}
	public String getCds() {
		return cds;
	}
	public void setCds(String cds) {
		this.cds = cds;
	}
	@Override
	protected Object clone()  {
	
		return new Studente(nome,cognome,matricola,cds);
	}
	@Override
	public boolean equals(Object obj) {
		Studente altro= new Studente();
	 altro= (Studente) obj ;
	return (this.matricola==altro.matricola);
		
		
		
	}
	@Override
	public int hashCode() {
		return matricola;
	}
	@Override
	public String toString() {
		String toString= nome+" "+cognome+" "+matricola+" "+cds+"\n";
		return toString;
	}
	/**
	 * costruttore di Studente
	 * @param nome 
	 * @param cognome
	 * @param matricola
	 * @param cds
	 */
	public Studente(String nome, String cognome, int matricola, String cds) {
		super();
		this.nome = nome;
		this.cognome = cognome;
		this.matricola = matricola;
		this.cds = cds;
	}
	public Studente() {
		
	}
	
	
}
