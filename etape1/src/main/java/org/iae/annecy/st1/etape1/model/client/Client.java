package org.iae.annecy.st1.etape1.model.client;

import java.util.ArrayList;
import java.util.Iterator;

import org.iae.annecy.st1.etape1.model.produit.Produit;

public class Client implements java.io.Serializable {
	/**
	 * 
	 */
	private String nom;
	private String prenom;
	private int numero;
	private int codepromo;
	private ArrayList<Produit> produit = new ArrayList<Produit>();
	
	public Client(){
		
	}
	
	public ArrayList<Produit> getProduit() {
		return produit;
	}
	public void setProduit(ArrayList<Produit> produit) {
		this.produit = produit;
	}
	
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
	public int getcodepromo() {
		return codepromo;
	}
	public void setcodepromo(int codepromo) {
		this.codepromo = codepromo;
	}
	public String afficher() {
		String texte=" Numero : "+this.numero+"\n Nom : "+this.nom+"\n Prénom : "+this.prenom+"\n Code promotionnel :"+this.codepromo+"\n";
		return texte;
	}
	public void ajouterproduit(Produit produit){
		this.getProduit().add(produit);
	}
	public void afficherproduits(){
		for(Produit produit : this.getProduit()){
			produit.afficher();
		}
	}
	public Produit recherch(String r){
		Iterator<Produit> it = this.getProduit().iterator();
		while(it.hasNext()){
			Produit produit=it.next();
			if(r.equals(produit.getRef())){
				return produit;
			}
		}
		return null;
	}

}
