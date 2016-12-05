package org.iae.annecy.st1.etape1.model.catalogue;

import java.util.ArrayList;
import java.util.Iterator;

import org.iae.annecy.st1.etape1.model.produit.Produit;
import org.iae.annecy.st1.etape1.view.produit.ProduitView;

public class Catalogue implements java.io.Serializable {
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
	public void ajouterproduit(Produit p){
		this.getProduits().add(p);
	}
	
	public Produit recherch(String r){
		Iterator<Produit> it = this.getProduits().iterator();
		while(it.hasNext()){
			Produit p=it.next();
			if(r.equals(p.getRef())){
				return p;
			}
		}
		return null;
	}
	public String afficher() {
		// TODO Auto-generated method stub
		String texte="";
		 for(Produit p : this.getProduits()){
			 texte +="la réference du produit est :"+p.getRef()+
						" le prix du produit : "+p.getPrix()+
						" la description du produit :"+p.getDescription()+
						" le nom du produit :"+p.getNom()+"\n";	
		 }
		return texte;
	}
	
	
	

}
