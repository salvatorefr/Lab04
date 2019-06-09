package it.polito.tdp.lab04.model;

public class Corso {
private String codins;//chiave primaria
private int crediti;
private String nome;
private int pd;
public Corso(String codins, int crediti, String nome, int pd) {
	super();
	this.codins = codins;
	this.crediti = crediti;
	this.nome = nome;
	this.pd = pd;
}
public Corso() {
	
}
public String getCodins() {
	return codins;
}
public void setCodins(String codins) {
	this.codins = codins;
}
public int getCrediti() {
	return crediti;
}
public void setCrediti(int crediti) {
	this.crediti = crediti;
}
public String getNome() {
	return nome;
}
public void setNome(String nome) {
	this.nome = nome;
}
public int getPd() {
	return pd;
}
public void setPd(int pd) {
	this.pd = pd;
}
@Override
protected Corso clone()  {
	return new Corso(codins,crediti,nome,pd);
}
@Override
public boolean equals(Object obj) {
	
	return (((Corso)obj).hashCode()==this.hashCode());
}
@Override
public int hashCode() {
	
	return this.codins.hashCode();
}
@Override
public String toString() {
	String stampa=codins+" "+crediti+" "+nome+" "+pd+"\n";
	return stampa;
}

}
