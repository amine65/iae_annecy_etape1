package org.iae.annecy.st1.etape1.view.Menu;

import java.util.Scanner;

import org.iae.annecy.st1.etape1.model.produit.Produit;

public class MenuView {
	Scanner s = new Scanner(System.in);
	
	public int menuproduit(){
		
		int choix;
		
		System.out.println("Quel produit voulez-vous choisir ?");
		
		choix = this.s.nextInt();
		return choix;
	}
	
	public int menugeneral(){
		int choix;
		this.s.reset();
		System.out.println("1-Afficher les produit  \t 2-modifier un produit \t 3-Recherche \t 4-Ajouter produit \t 5-Supprimer "
							+ "\t 6-Quitter");
		choix=this.s.nextInt();;
		return choix;
	}
	
	public int menuattribut(Produit p){
		Scanner s = new Scanner(System.in);
		int choix;
		
		//System.out.println("1 : la reference du produit choisi est : "+p.getRef());
		System.out.println("1 : le nom du produit choisi est : "+p.getNom());
		System.out.println("2 : la description du produit choisi est : "+p.getDescription());
		System.out.println("3 : le prix du produit choisi est : "+p.getPrix());
		
		System.out.println("le quelle voulez-vous medifier ?");
		choix = s.nextInt();
		return choix;
	}

}
