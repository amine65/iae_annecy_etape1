package org.iae.annecy.st1.etape1.model.panier;

import java.util.ArrayList;

import org.iae.annecy.st1.etape1.model.client.Client;
import org.iae.annecy.st1.etape1.model.produit.Produit;
import org.iae.annecy.st1.tools.ConsoleHelper;

public class Panier {
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
			ConsoleHelper.display("votre panier n\'est pas valider");
		}else{
			ConsoleHelper.display("votre panier est valider");
		}
		
		for(Produit produit : this.getProduits()){
			produit.afficher();
		}
		
	}
	
	public void prixpanier(){
		int totale =0;
		int numero=0;
		for(Produit produit : this.getProduits()){
			totale = produit.getPrix()+totale;
			numero+=numero;
			ConsoleHelper.display("le produit numero: "+ numero + "nommer :"+produit.getNom()+"à le prix :"+produit.getPrix());
		}
		if(this.client != null){
			ConsoleHelper.display("votre code de promotion est :"+this.client.getcodepromo());
			ConsoleHelper.display("le prix totale des produit commandé est :"+totale);
			ConsoleHelper.display("le prix totale avec votre code de promotion est :");
			
		}
	}

}
