package org.iae.annecy.st1.etape1.model.panier;

import java.util.ArrayList;

import org.iae.annecy.st1.etape1.model.client.Client;
import org.iae.annecy.st1.etape1.model.produit.Produit;
import org.iae.annecy.st1.tools.ConsoleHelper;

public class Panier implements java.io.Serializable{
	private ArrayList<Produit> produits = new ArrayList<Produit>();
	private Boolean validercommande=false;
	private Client client;

	public Panier(Client meclient){
		this.client=meclient;
	}
	
	public Panier(){
		
	}
	
	public ArrayList<Produit> getProduits() {
		return produits;
	}

	public void setProduits(ArrayList<Produit> produits) {
		this.produits = produits;
	}
	
	public Boolean getValidercommande() {
		return validercommande;
	}

	public void setValidercommande(Boolean validercommande) {
		this.validercommande = validercommande;
	}
	
	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public void ajouterProduit(Produit produit){
		this.getProduits().add(produit);
	}
	
	public void listerpanier(){
		
		if(this.getValidercommande() == false){
			ConsoleHelper.display("votre panier n\'est pas valider il contient les produit suivant :");
		}else{
			ConsoleHelper.display("votre panier est valider il contient les produit suivant :");
		}
		
		for(Produit produit : this.getProduits()){
			produit.afficher();
		}
		
	}
	
	public void prixpanier(){
		float totale =0;
		int numero=0;
		float prixpromo=0;
		if(this.client != null){
			if(this.getProduits()!=null){
				for(Produit produit : this.getProduits()){
					totale = produit.getPrix()+totale;
					numero+=numero;
					ConsoleHelper.display("le produit numero: "+ numero + "nommer :"+produit.getNom()+"à le prix :"+produit.getPrix());
				}
			
				ConsoleHelper.display("votre code de promotion est :"+this.client.getcodepromo()+"%");
				ConsoleHelper.display("le prix totale des produit commandé est : "+totale);
				if(this.getClient().getcodepromo()==10){
					prixpromo=totale/10;
				}else if(this.getClient().getcodepromo()==25){
					prixpromo=totale/4;
				}else if(this.getClient().getcodepromo()==50){
					prixpromo=totale/2;
				}
					
				ConsoleHelper.display("le prix totale avec votre code de promotion est : "+ prixpromo);
			}else {
				ConsoleHelper.display("votre panier est vide !!");
			}
			
		}
		
	}

}
