package org.iae.annecy.st1.etape1.model.produit;

public class Produit implements java.io.Serializable {
	private String ref;
	private String description;
	private int prix;
	private String nom;
	
	public Produit(String r,String d,int p,String nom){
		this.prix=p;
		this.ref=r;
		this.description=d;
		this.nom=nom;
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
	
	
}
