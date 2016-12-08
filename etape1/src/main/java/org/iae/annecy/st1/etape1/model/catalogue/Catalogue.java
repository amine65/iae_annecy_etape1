package org.iae.annecy.st1.etape1.model.catalogue;

import java.util.ArrayList;
import org.iae.annecy.st1.etape1.model.produit.Produit;

public class Catalogue implements java.io.Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -6647434616582236649L;
	private ArrayList<Produit> produits = new ArrayList<Produit>();

	public Catalogue(ArrayList<Produit> p){
		this.produits=p;
	}
	
	public Catalogue(){
		
	}
	
	public ArrayList<Produit> getProduits() {
		return produits;
	}

	public void setProduits(ArrayList<Produit> produits) {
		this.produits = produits;
	}
	
}
