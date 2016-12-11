package org.iae.annecy.st1.etape1.controller.catalogue;

import java.util.Iterator;

import org.iae.annecy.st1.etape1.model.catalogue.Catalogue;
import org.iae.annecy.st1.etape1.model.produit.Produit;
import org.iae.annecy.st1.etape1.view.catalogue.CatalogueView;;

public class CatalogueController {

	private Catalogue moncatatalogue;
	private CatalogueView catalogueview;

	public CatalogueController() {

	}

	public CatalogueController(Catalogue catatalogue) {
		this.moncatatalogue = catatalogue;
		this.catalogueview = new CatalogueView(this.moncatatalogue);
	}

	public Catalogue getMoncatatalogue() {
		return moncatatalogue;
	}

	public void setMoncatatalogue(Catalogue moncatatalogue) {
		this.moncatatalogue = moncatatalogue;
		this.catalogueview = new CatalogueView(this.moncatatalogue);
	}

	public String get() {

		return this.catalogueview.afficher();

	}

	public void ajouterproduit(Produit p) {
		this.moncatatalogue.getProduits().add(p);
	}

	public Produit recherch(String r) {
		Iterator<Produit> it = this.moncatatalogue.getProduits().iterator();
		while (it.hasNext()) {
			Produit produit = it.next();
			if (r.equals(produit.getRef())) {
				return produit;
			}
		}
		return null;
	}
}
