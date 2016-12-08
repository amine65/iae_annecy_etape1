package org.iae.annecy.st1.etape1.model.client;

public class Client {
	private String nom;
	private String prenom;
	private int numero;
	private String codepromo;
	
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	public int getNumero() {
		return numero;
	}
	public void setNumero(int numero) {
		this.numero = numero;
	}
	public String getcodepromo() {
		return codepromo;
	}
	public void setcodepromo(String codepromo) {
		this.codepromo = codepromo;
	}
	public String afficher() {
		// TODO Auto-generated method stub
		String texte="Nom : "+this.nom+" Prénom : "+this.prenom+" Numero : "+this.numero+" Code promotionnel :"+this.codepromo+"\n";
		return texte;
	}
	

}
