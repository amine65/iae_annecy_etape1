package org.iae.annecy.st1.etape1.view.catalogue;

import org.iae.annecy.st1.etape1.model.catalogue.Catalogue;

import org.iae.annecy.st1.etape1.view.produit.ProduitView;

public class CatalogueView {
	
	private ProduitView pv = new ProduitView();
	
	public void afficher(Catalogue c){
		for(int i=0;i<c.getProduits().size();i++){
			pv.afficher(i+1,c.getProduits().get(i));
		}
	}

}
