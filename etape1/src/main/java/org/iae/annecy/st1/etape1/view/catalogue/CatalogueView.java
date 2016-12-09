package org.iae.annecy.st1.etape1.view.catalogue;

import org.iae.annecy.st1.etape1.model.catalogue.Catalogue;
import org.iae.annecy.st1.etape1.model.produit.Produit;


public class CatalogueView {
	
	private Catalogue catalogue = new Catalogue();
	
	public CatalogueView(Catalogue moncatalogue){
		this.catalogue=moncatalogue;
	}
	
	public Catalogue getCatalogue() {
		return catalogue;
	}

	public void setCatalogue(Catalogue catalogue) {
		this.catalogue = catalogue;
	}

	public String afficher() {
		// TODO Auto-generated method stub
		String texte="";
		int numero=0;
		 for(Produit p : this.catalogue.getProduits()){
			 texte +="numero du produit est = "+numero+" la réference du produit est :"+p.getRef()+
						" le prix du produit : "+p.getPrix()+
						" la description du produit :"+p.getDescription()+
						" le nom du produit :"+p.getNom()+"\n";	
			 numero++;
		 }
		return texte;
	}

}
