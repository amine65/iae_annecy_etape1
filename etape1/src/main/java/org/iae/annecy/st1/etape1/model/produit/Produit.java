package org.iae.annecy.st1.etape1.model.produit;

import org.iae.annecy.st1.tools.ConsoleHelper;

public class Produit implements java.io.Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 4403018142099389267L;
	private String ref;
	private String description;
	private String descriptionlong;
	private int prix;
	private String nom;

	private int quantiteproduit = 0;

	public Produit() {

	}

	public Produit(String r, String d, String dl, int p, String nom) {
		this.prix = p;
		this.ref = r;
		this.description = d;
		this.descriptionlong = dl;
		this.nom = nom;
	}

	public int getQuantiteproduit() {
		return quantiteproduit;
	}

	public void setQuantiteproduit(int quantiteproduit) {
		this.quantiteproduit = quantiteproduit;
	}

	public String getDescriptionlong() {
		return descriptionlong;
	}

	public void setDescriptionlong(String descriptionlong) {
		this.descriptionlong = descriptionlong;
	}

	public String getRef() {
		return ref;
	}

	public void setRef(String ref) {
		this.ref = ref;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getPrix() {
		return prix;
	}

	public void setPrix(int prix) {
		this.prix = prix;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public void afficher() {
		ConsoleHelper.display("la réference du produit est :" + this.getRef() + " le nom du produit : " + this.getNom()
				+ " le prix du produit : " + this.getPrix() + " la description du produit :" + this.getDescription()
				+ " la description long du produit :" + this.getDescriptionlong());
	}

}
