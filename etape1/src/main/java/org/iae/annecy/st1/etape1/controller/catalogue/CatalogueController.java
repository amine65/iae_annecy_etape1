package org.iae.annecy.st1.etape1.controller.catalogue;


import org.iae.annecy.st1.etape1.model.catalogue.Catalogue;

public class CatalogueController {
	private Catalogue cat;
	public CatalogueController(Catalogue c){
		this.cat=c;
	}
	public String get(){
		
		return this.cat.afficher();
		
	}
}
