package org.iae.annecy.st1.etape1.view.produit;

import org.iae.annecy.st1.etape1.model.produit.Produit;

public class ProduitView {

	public void afficher(int i,Produit p){
		System.out.println("le numero du produit "+i+" la réference du produit est :"+p.getRef()+
							" le prix du produit : "+p.getPrix()+
							" la description du produit :"+p.getDescription());	
	}

}
