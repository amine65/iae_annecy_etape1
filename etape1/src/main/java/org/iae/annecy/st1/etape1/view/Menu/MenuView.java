package org.iae.annecy.st1.etape1.view.Menu;

import java.util.Scanner;
import org.iae.annecy.st1.tools.ConsoleHelper;
import org.iae.annecy.st1.etape1.controller.ClientController;
import org.iae.annecy.st1.etape1.controller.catalogue.CatalogueController;
import org.iae.annecy.st1.etape1.model.client.Client;
import org.iae.annecy.st1.etape1.model.panier.Panier;
import org.iae.annecy.st1.etape1.model.produit.Produit;

public class MenuView {
	
	private Scanner saisie = new Scanner(System.in);
	
	
	public MenuView(){
		
	}
	
	public int menuproduit(){
		
		int choix;
		
		ConsoleHelper.display("Quel produit voulez-vous choisir ?");
		
		choix = this.saisie.nextInt();
		return choix;
	}
	
	public int menucataloguegeneral(){
		int choix;
		this.saisie.reset();
		ConsoleHelper.display("######### Menu Responsable produit #########");
		ConsoleHelper.display("1-Afficher les produit au catalogue  \t 2-modifier un produit dans le catalogue \t 3-Recherche dans le catalogue \t 4-Ajouter produit dans le catalogue \n 5-Supprimer du catalogue "
							+ "\t 6-Quitter");
		choix=this.saisie.nextInt();;
		return choix;
	}
	
	public int menuclientnative(){
		int choix;
		this.saisie.reset();
		ConsoleHelper.display("######### Menu Client #########");
		ConsoleHelper.display("1-ajouter un produit à votre panier  \t 2-voir le prix de mon panier \t 3-valider votre commande \t 4-Quitter");
		choix=this.saisie.nextInt();;
		return choix;
	}
	
	public int menuclientgeneral(){
		int choix;
		this.saisie.reset();
		ConsoleHelper.display("######### Menu Responsable clientèle #########");
		ConsoleHelper.display("1-Afficher les clients  \t 2-modifier un client \t 3-Recherche un client \t 4-Ajouter un client "
							+ "\t 5-Quitter");
		choix=this.saisie.nextInt();;
		return choix;
	}
	
	public int menuattribut(Produit p){
		int choix;
		
		//ConsoleHelper.display("1 : la reference du produit choisi est : "+p.getRef());
		ConsoleHelper.display("1 : le nom du produit choisi est : "+p.getNom());
		ConsoleHelper.display("2 : la description du produit choisi est : "+p.getDescription());
		ConsoleHelper.display("3 : le prix du produit choisi est : "+p.getPrix());
		
		ConsoleHelper.display("le quelle voulez-vous medifier ?");
		choix = this.saisie.nextInt();
		return choix;
	}
	
	public int menugeneral(){
		int choixmenu;
		
		ConsoleHelper.display("choisiez votre degreé de responsabilité : ");
		ConsoleHelper.display("1 : Responsable produit");
		ConsoleHelper.display("2 : Responsable clientèle");
		ConsoleHelper.display("3 : Client");
		ConsoleHelper.display("4 : Vendeur dans le magasin");
		ConsoleHelper.display("ou 5 : Quitter");
		choixmenu = this.saisie.nextInt();
		
		return choixmenu;
		
	}
	
	public void menuresponsableproduit(CatalogueController cataloguecontroller){
		int choixproduit,choixattribut,choixgeneral;
		
		String reference;
		String nom;
		String description;
		int prix;
		Produit prodtrouver = new Produit();
		
		choixgeneral = this.menucataloguegeneral();
		while(choixgeneral<6){
			if(choixgeneral == 1){
				ConsoleHelper.display(cataloguecontroller.get());
				choixgeneral = this.menucataloguegeneral();
			}else if(choixgeneral == 2){
				ConsoleHelper.display(cataloguecontroller.get());
				choixproduit = this.menuproduit();
				choixattribut = this.menuattribut(cataloguecontroller.getMoncatatalogue().getProduits().get(choixproduit-1));
			
				if(choixattribut == 1){
					ConsoleHelper.display("entrer le nouveau nom :");
					nom = this.saisie.next();
					cataloguecontroller.getMoncatatalogue().getProduits().get(choixproduit-1).setNom(nom);
				}else if(choixattribut == 2){
						ConsoleHelper.display("entrer la nouvelle description :");
						description=this.saisie.nextLine();
						cataloguecontroller.getMoncatatalogue().getProduits().get(choixproduit-1).setDescription(description);
				}else if(choixattribut == 3){
					ConsoleHelper.display("entrer le nouveau prix :");
					prix =this.saisie.nextInt();
					cataloguecontroller.getMoncatatalogue().getProduits().get(choixproduit-1).setPrix(prix);
				}
				choixgeneral = this.menucataloguegeneral();
				
			}else if(choixgeneral == 3){
				ConsoleHelper.display("Entre la reference que vous chercher : ");
				reference = this.saisie.next();
				
				prodtrouver = cataloguecontroller.recherch(reference);
				if(prodtrouver!=null){
					ConsoleHelper.display("produit trouver \n la réference du produit est :"+prodtrouver.getRef()+
							" \n le prix du produit : "+prodtrouver.getPrix()+
							" \n la description du produit :"+prodtrouver.getDescription());
				}else{
					ConsoleHelper.display("le produit n\'existe pas");
				}
				choixgeneral = this.menucataloguegeneral();
			}else if(choixgeneral == 4){
				ConsoleHelper.display("entrer la nouvelle reference :");
				reference=this.saisie.next();
				prodtrouver = cataloguecontroller.recherch(reference);
				if( prodtrouver == null){
					ConsoleHelper.display("entrer le nouveau prix :");
					prix =this.saisie.nextInt();
					if(prix>=0){
						ConsoleHelper.display("entrer le nouveau nom :");
						nom=this.saisie.next();
						
						ConsoleHelper.display("entrer la nouvelle description :");
						
						description=this.saisie.next();
						
						cataloguecontroller.ajouterproduit(new Produit(reference,description,prix,nom));
					}else{
						ConsoleHelper.display("vous ne pouvez pas ajouter un prix negatif !!! :");
					}
				}else{
					ConsoleHelper.display("le reference que vous-voulez existe deja !!! :");
				}	
				choixgeneral = this.menucataloguegeneral();
			}else if(choixgeneral == 5){
				ConsoleHelper.display("Entre la reference du produit que vous-voulez supprimer : ");
				reference=this.saisie.next();
				prodtrouver = cataloguecontroller.recherch(reference);
				if(prodtrouver!=null){
					cataloguecontroller.getMoncatatalogue().getProduits().remove(prodtrouver);
				}else{
					ConsoleHelper.display("le produit n\'existe pas");
				}
				choixgeneral = this.menucataloguegeneral();
			}
		}
		
	}

	public void menuresponsableclientele(ClientController clientcontroller){
		int choixgeneral,choixpromo;
		
		String nom;
		String prenom;
		int numero;
		String codepromo;
		
		
			choixgeneral = this.menuclientgeneral();
		while(choixgeneral<5){
			if(choixgeneral == 1){
				ConsoleHelper.display(clientcontroller.get());
				choixgeneral = this.menuclientgeneral();
				
			}else if(choixgeneral == 2){
				ConsoleHelper.display(clientcontroller.get());
				ConsoleHelper.display("Entre le numero du client que vous chercher : ");
				numero = this.saisie.nextInt();
				
				Client clienttrouver = clientcontroller.recherch(numero);
				if(clienttrouver!=null){
					ConsoleHelper.display("entrer le nouveau numero du client :");
					numero =this.saisie.nextInt();
					clienttrouver.setNumero(numero);
					
					ConsoleHelper.display("entrer le nouveau nom du client :");
					nom =this.saisie.next();
					clienttrouver.setNom(nom);
					
					ConsoleHelper.display("entrer le nouveau prenom du client :");
					prenom =this.saisie.next();
					clienttrouver.setPrenom(prenom);
					
					ConsoleHelper.display("voulez-vous modifier le code promotionnel ? 1:oui 2:non");
					choixpromo =this.saisie.nextInt();
					if(choixpromo == 1){
						ConsoleHelper.display("entrer le nouveau code promotionnel du client :");
						codepromo =this.saisie.next();
						clienttrouver.setcodepromo(codepromo);
					}
					//clientcontroller.ajouterClient(clientnouveau);
					ConsoleHelper.display("Client modifier !!!");
				}else{
					ConsoleHelper.display("Client existe pas !!!");
				}
				choixgeneral = this.menuclientgeneral();
				
			}else if(choixgeneral == 3){
				ConsoleHelper.display("Entre le numero du client que vous chercher : ");
				numero = this.saisie.nextInt();
				
				Client clienttrouve = clientcontroller.recherch(numero);
				if(clienttrouve!=null){
					ConsoleHelper.display("Client trouver \n le numero du client est :"+clienttrouve.getNumero()+
							" \n Le nom du client est  : "+clienttrouve.getNom()+
							" \n Le prenom du client est  :"+clienttrouve.getPrenom()+
							" \n Son numero promotionnel est  : "+clienttrouve.getcodepromo());
				}else{
					ConsoleHelper.display("le client demander n\'existe pas");
				}
				choixgeneral = this.menuclientgeneral();
			}else if(choixgeneral == 4){
				
					Client clientnouveau= new Client();
					ConsoleHelper.display("entrer le numero du client :");
					numero =this.saisie.nextInt();
					clientnouveau.setNumero(numero);
					
					ConsoleHelper.display("entrer le nom du client :");
					nom =this.saisie.next();
					clientnouveau.setNom(nom);
					
					ConsoleHelper.display("entrer le prenom du client :");
					prenom =this.saisie.next();
					clientnouveau.setPrenom(prenom);
					
					ConsoleHelper.display("voulez-vous lui attribuer un code promotionnel ? 1:oui 2:non");
					choixpromo =this.saisie.nextInt();
					if(choixpromo == 1){
						ConsoleHelper.display("entrer le code promotionnel du client :");
						codepromo =this.saisie.next();
						clientnouveau.setcodepromo(codepromo);
					}
					clientcontroller.ajouterClient(clientnouveau);
					ConsoleHelper.display("Client ajouter !!!");
					choixgeneral = this.menuclientgeneral();
			}
		}
	}
	
	public void menuclient(CatalogueController cataloguecontroller,Panier monpanier,Client client){
		int choixgeneral,confirmation;
		String reference="";
		Produit monproduit = new Produit();
		monpanier.setClient(client);
		choixgeneral = this.menuclientnative();
		while(choixgeneral < 4){
			if(choixgeneral == 1){
				ConsoleHelper.display("les produit existant dans le catalogue sont : ");
				ConsoleHelper.display(cataloguecontroller.get());
				ConsoleHelper.display("entre la reference du produit que vous-voulez ajoutre a votre panier :");
				reference = this.saisie.next();
				monproduit=cataloguecontroller.recherch(reference);
				
				if(monproduit != null){
					ConsoleHelper.display("le produit choisis est : ");
					monproduit.afficher();
					ConsoleHelper.display("voulez-vous l\'ajouter à votre panier ? 1:oui 2:non");
					confirmation=this.saisie.nextInt();
					if(confirmation==1){
						monpanier.ajouterProduit(monproduit);
						ConsoleHelper.display("produit ajouter avec succès");
					}
				}else{
					ConsoleHelper.display("le produit demander n\'existe pas !!");
				}
				choixgeneral = this.menuclientnative();
			}else if(choixgeneral == 2){
				monpanier.prixpanier();
				choixgeneral = this.menuclientnative();
			}else if(choixgeneral == 3){
				ConsoleHelper.display("Votre panier contient les produit suivant :");
				monpanier.listerpanier();
				ConsoleHelper.display("voulez-vous valider votre panier ? 1:oui 2:non");
				confirmation=this.saisie.nextInt();
				if(confirmation==1){
					monpanier.setValidercommande(true);
					ConsoleHelper.display("Votre panier à bien était valider !!");
				}
				choixgeneral = this.menuclientnative();
			}
		}
		
	}
}
