package org.iae.annecy.st1.etape1.view.Menu;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.Scanner;
import org.iae.annecy.st1.tools.ConsoleHelper;
import org.iae.annecy.st1.etape1.controller.ClientController;
import org.iae.annecy.st1.etape1.controller.catalogue.CatalogueController;
import org.iae.annecy.st1.etape1.model.client.Client;
import org.iae.annecy.st1.etape1.model.commande.Commande;
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
		ConsoleHelper.display("1-ajouter un produit à votre panier  \t 2-voir le prix de mon panier \t 3-valider votre commande \n 4-voir votre panier \t 5-Quitter");
		choix=this.saisie.nextInt();;
		return choix;
	}
	
	public int menuvendeur(){
		int choix;
		this.saisie.reset();
		ConsoleHelper.display("######### Menu Vendeur #########");
		ConsoleHelper.display("1-visualiser les produits achetés par un client \t 2-Quitter");
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
		ConsoleHelper.display("4 : le description long du produit choisi est : "+p.getPrix());
		
		ConsoleHelper.display("le quelle voulez-vous medifier ?");
		choix = this.saisie.nextInt();
		return choix;
	}
	
	public int menuattributclient(Client c){
		int choix;
		
		//ConsoleHelper.display("1 : la reference du produit choisi est : "+p.getRef());
		ConsoleHelper.display("1 : le numero du client choisi est : "+c.getNumero());
		ConsoleHelper.display("2 : la nom du client choisi est : "+c.getNom());
		ConsoleHelper.display("3 : le prenom du client choisi est : "+c.getPrenom());
		ConsoleHelper.display("4 : le code promotionnel du client choisi est : "+c.getcodepromo());
		
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
		String descriptionlong;
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
						
						ConsoleHelper.display("entrer la nouvelle description long :");
						
						descriptionlong=this.saisie.next();
						
						cataloguecontroller.ajouterproduit(new Produit(reference,description,descriptionlong,prix,nom));
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
		
		try {
	         FileOutputStream fileOut = new FileOutputStream("catalogue.ser");
	         ObjectOutputStream out = new ObjectOutputStream(fileOut);
	         out.writeObject(cataloguecontroller.getMoncatatalogue());
	         out.close();
	         fileOut.close();
	         ConsoleHelper.display("Catalgue sauvrgarder in catalogue.se");
	      }catch(IOException i) {
	         ConsoleHelper.display("un erreur est survenu lors de l\'écréture dans le fichier : "+i);
	      }
		
	}

	public Commande menuresponsableclientele(ClientController clientcontroller){
		int choixgeneral,choixpromo,choixattribut;
		
		String nom;
		String prenom;
		int numero;
		int codepromo;
		
		Commande commande = new Commande();
		
		
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
					choixattribut=menuattributclient(clienttrouver);
					if(choixattribut==1){
						ConsoleHelper.display("entrer le nouveau numero du client :");
						numero =this.saisie.nextInt();
						clienttrouver.setNumero(numero);
					}else if(choixattribut==2){
						ConsoleHelper.display("entrer le nouveau nom du client :");
						nom =this.saisie.next();
						clienttrouver.setNom(nom);
					}else if(choixattribut==3){
						ConsoleHelper.display("entrer le nouveau prenom du client :");
						prenom =this.saisie.next();
						clienttrouver.setPrenom(prenom);
					}else if(choixattribut==4){
						ConsoleHelper.display("voulez-vous modifier le code promotionnel ? 1:oui 2:non");
						choixpromo =this.saisie.nextInt();
						if(choixpromo == 1){
							ConsoleHelper.display("choisissez le code promotionnel du client  =  1=>10%  2:=>25%  3=>50%");
							codepromo =this.saisie.nextInt();
							if(codepromo==1){
								clienttrouver.setcodepromo(10);
							}else if(codepromo == 2){
								clienttrouver.setcodepromo(25);
							}else if(codepromo == 3){
								clienttrouver.setcodepromo(50);
							}
						}
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
					Client clienttrouver = clientcontroller.recherch(numero);
					if(clienttrouver == null){
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
							ConsoleHelper.display("choisissez le code promotionnel du client  =  1=>10%  2:=>25%  3=>50%");
							codepromo =this.saisie.nextInt();
							if(codepromo==1){
								clientnouveau.setcodepromo(10);
							}else if(codepromo == 2){
								clientnouveau.setcodepromo(25);
							}else if(codepromo == 3){
								clientnouveau.setcodepromo(50);
							}
						
						}
						clientcontroller.ajouterClient(clientnouveau);
						ConsoleHelper.display("Client ajouter !!!");
					}else{
						ConsoleHelper.display("Le numero de client existe deja !!");
					}
					choixgeneral = this.menuclientgeneral();
					}
		}
		
		try {
	         FileOutputStream fileOut = new FileOutputStream("client.ser");
	         ObjectOutputStream out = new ObjectOutputStream(fileOut);
	         out.writeObject(clientcontroller);
	         out.close();
	         fileOut.close();
	         ConsoleHelper.display("Clients sauvrgarder in client.se");
	      }catch(IOException i) {
	         ConsoleHelper.display("un erreur est survenu lors de l\'écréture dans le fichier : "+i);
	      }
		
		commande.setClients(clientcontroller.getClient());
		return commande;
	}
	
	public Client menuclient(CatalogueController cataloguecontroller,Panier monpanier,Client client){
		int choixgeneral,confirmation;
		String reference="";
		Produit monproduit = new Produit();
		Client clients=new Client();
		monpanier.setClient(client);
		choixgeneral = this.menuclientnative();
		while(choixgeneral < 5){
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
						
						clients.ajouterproduit(monproduit);
						
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
				monpanier.listerpanier();
				if(monpanier.getValidercommande() == false){
					
					ConsoleHelper.display("voulez-vous valider votre panier ? 1:oui 2:non");
					confirmation=this.saisie.nextInt();
					if(confirmation==1){
						monpanier.setValidercommande(true);
						ConsoleHelper.display("Votre panier à bien était valider !!");
					}
					
				}else{
					ConsoleHelper.display("Votre panier est déja valider !!");
				}
				
				choixgeneral = this.menuclientnative();
			}else if(choixgeneral == 4){
				monpanier.listerpanier();
				choixgeneral = this.menuclientnative();
			}
		}
		
		try {
	         FileOutputStream fileOut = new FileOutputStream("panier.ser");
	         ObjectOutputStream out = new ObjectOutputStream(fileOut);
	         out.writeObject(monpanier);
	         out.close();
	         fileOut.close();
	         ConsoleHelper.display("panier sauvrgarder in panier.se");
	      }catch(IOException i) {
	         ConsoleHelper.display("un erreur est survenu lors de l\'écréture dans le fichier : "+i);
	      }
		
		return clients;
		
	}

	public void menuvendeurmagasin(Commande commande) {
		// TODO Auto-generated method stub
		int choixgeneral;
		choixgeneral = this.menuvendeur();
		while(choixgeneral<2){
			if(choixgeneral == 1){
				
				commande.afficherparclient();
				choixgeneral = this.menuvendeur();
			}
		}
		
	}
}
