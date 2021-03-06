/**
 * 
 */

package org.iae.annecy.st1.etape1;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.Scanner;

import org.iae.annecy.st1.etape1.controller.catalogue.CatalogueController;
import org.iae.annecy.st1.etape1.controller.listclient.ClientController;
import org.iae.annecy.st1.etape1.model.catalogue.Catalogue;
import org.iae.annecy.st1.etape1.model.client.Client;
import org.iae.annecy.st1.etape1.model.commande.Commande;
import org.iae.annecy.st1.etape1.model.panier.Panier;
import org.iae.annecy.st1.etape1.model.produit.Produit;
import org.iae.annecy.st1.etape1.view.Menu.MenuView;
import org.iae.annecy.st1.tools.ConsoleHelper;

/**
 * Classe permetant de tester le MVC.
 * 
 * @author amine
 */
public class Main {

	/**
	 * Lance l'application.
	 * 
	 * @param args
	 *            command line parameters
	 */
	public static void main(final String[] args) {

		Produit produit1 = new Produit("ref1", "description1", "description long 1", 15, "prod1");
		Produit produit2 = new Produit("ref2", "description2", "description long 2", 30, "prod2");

		Catalogue catalogue = new Catalogue();

		Panier monpanier = new Panier();

		Client client = new Client();

		Commande commande = new Commande();

		Scanner saisie = new Scanner(System.in);

		int numeroclient = 0;

		CatalogueController catalogueController = new CatalogueController();

		ClientController clientcatalogue = new ClientController();
		Client monclient = new Client();

		MenuView menu = new MenuView();
		int choixmenu;

		// ############################### Deserialisation Clients############################################
		try {
			FileInputStream fileIn = new FileInputStream("client.ser");
			ObjectInputStream in = new ObjectInputStream(fileIn);
			clientcatalogue = (ClientController) in.readObject();
			in.close();
			fileIn.close();
		} catch (FileNotFoundException f) {

		} catch (IOException i) {
			ConsoleHelper.display("un erreur est survenu lors de la lecture du le fichier : " + i);

		} catch (ClassNotFoundException e) {
			ConsoleHelper.display("la classe Clients n\'existe pas !!");
			e.printStackTrace();
			return;
		}

		// ############################### Deserialisation Catalogue############################################
		try {
			FileInputStream fileIn = new FileInputStream("catalogue.ser");
			ObjectInputStream in = new ObjectInputStream(fileIn);
			catalogue = (Catalogue) in.readObject();
			catalogueController.setMoncatatalogue(catalogue);
			in.close();
			fileIn.close();
		} catch (FileNotFoundException f) {
			catalogue.getProduits().add(produit1);
			catalogue.getProduits().add(produit2);
			catalogueController.setMoncatatalogue(catalogue);

		} catch (IOException i) {
			ConsoleHelper.display("un erreur est survenu lors de la lecture du le fichier : " + i);
			return;
		} catch (ClassNotFoundException e) {
			ConsoleHelper.display("la classe Catalogue n\'existe pas !!");
			e.printStackTrace();
			return;
		}
		// #################Menu Generale########################

		choixmenu = menu.menugeneral();
		while (choixmenu != 5) {

			switch (choixmenu) {
			case 1:
				menu.menuresponsableproduit(catalogueController);
				choixmenu = menu.menugeneral();
				break;
			case 2:
				commande = menu.menuresponsableclientele(clientcatalogue);
				choixmenu = menu.menugeneral();
				break;
			case 3:
				ConsoleHelper.display("Entre votre numero client pour acceder à votre compte : ");
				int numero = saisie.nextInt();

				client = clientcatalogue.recherch(numero);
				numeroclient= clientcatalogue.numeroclient(numero);
				if (client != null) {
					monclient = menu.menuclient(catalogueController, monpanier, client);
					
					clientcatalogue.getClient().get(numeroclient).setProduit(monclient.getProduit());
					monclient=clientcatalogue.getClient().get(numeroclient);
					commande.ajouterclient(monclient);
					
				} else {
					ConsoleHelper.display("le numero saisie ne correspond à aucun client !!");
				}
				


				choixmenu = menu.menugeneral();
				break;
			case 4:
				if (commande.getClients().isEmpty()) {

					commande.setClients(clientcatalogue.getClient());
				}

				menu.menuvendeurmagasin(commande);
				choixmenu = menu.menugeneral();
				break;
			case 5:
				break;
			default:
				ConsoleHelper.display("Erreue de saisie ");
				menu.menuvendeurmagasin(commande);
				choixmenu = menu.menugeneral();
				break;
			}
		}

	}

}
