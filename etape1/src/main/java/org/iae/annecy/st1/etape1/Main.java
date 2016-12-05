/**
 * 
 */

package org.iae.annecy.st1.etape1;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Scanner;

import org.iae.annecy.st1.etape1.controller.catalogue.CatalogueController;
//import org.iae.annecy.st1.common.mvc.DataView;
//import org.iae.annecy.st1.common.mvc.StringView;
//import org.iae.annecy.st1.etape1.controller.MainController;
//import org.iae.annecy.st1.etape1.model.UserModel;
import org.iae.annecy.st1.etape1.model.catalogue.Catalogue;
import org.iae.annecy.st1.etape1.model.produit.Produit;
//import org.iae.annecy.st1.etape1.view.UserTextFrenchView;
import org.iae.annecy.st1.etape1.view.Menu.MenuView;
//import org.iae.annecy.st1.etape1.view.catalogue.CatalogueView;
//import org.iae.annecy.st1.tools.ConsoleHelper;

/**
 * Classe permetant de tester le MVC.
 * 
 * @author Djer1013
 */
public class Main {

	/**
	 * COntroller pemetant le traitement des actions d'exemple.
	 */
	/*private static MainController mainController;

	static {
		Main.mainController = new MainController();
	}*/

	/**
	 * Lance l'application.
	 * 
	 * @param args
	 *            command line parameters
	 */
	public static void main(final String[] args) {
		/*initUserModel();

		final DataView userData = mainController.get("user:display");
		final StringView userView = new UserTextFrenchView();

		ConsoleHelper.display(userView.build(userData));*/
		
		Produit p1= new Produit("ref1","description1",15,"prod1");
		Produit p2= new Produit("ref2","description2",30,"prod2");
		
		Catalogue c = new Catalogue();
		
		try {
	         FileInputStream fileIn = new FileInputStream("catalogue.ser");
	         ObjectInputStream in = new ObjectInputStream(fileIn);
	         c = (Catalogue) in.readObject();
	         in.close();
	         fileIn.close();
		}catch(FileNotFoundException f){
			System.out.print("votre catalogue est vide pensez a le remplir !! \n");
			c.ajouterproduit(p1);
	 		c.ajouterproduit(p2);
	      }catch(IOException i) {
	    	System.out.println("un erreur est survenu lors de la lecture du le fichier : "+i);
	        c.ajouterproduit(p1);
	 		c.ajouterproduit(p2);
	 		 return;
	      }catch(ClassNotFoundException e) {
	         System.out.println("la classe Catalogue n\'existe pas !!");
	         e.printStackTrace();
		     c.ajouterproduit(p1);
		     c.ajouterproduit(p2);
	         return;
	      }
		
		CatalogueController cc =new CatalogueController(c);
		
		MenuView menu = new MenuView();
		
		int choixp,choixa,choixg;
		
		Scanner s = new Scanner(System.in);
		
		choixg =menu.menugeneral();
		
		while(choixg > 6){
			
			if(choixg == 1){
				System.out.println(cc.get());
				choixg =menu.menugeneral();
			}else if(choixg == 2){
				System.out.println(cc.get());
				choixp = menu.menuproduit();
				choixa = menu.menuattribut(c.getProduits().get(choixp-1));
			
				if(choixa == 1){
					System.out.println("entrer le nouveau nom :");
					String n=s.next();
					c.getProduits().get(choixp-1).setNom(n);
				}else if(choixa == 2){
						System.out.println("entrer la nouvelle description :");
						String d=s.nextLine();
						c.getProduits().get(choixp-1).setDescription(d);
				}else if(choixa == 3){
					System.out.println("entrer le nouveau prix :");
					int prix =s.nextInt();
						c.getProduits().get(choixp-1).setPrix(prix);
				}
				choixg =menu.menugeneral();
				
			}else if(choixg == 3){
				System.out.println("Entre la reference que vous chercher : ");
				String r;
				if(s.hasNext()){
					r = s.next();
				}else{
					r="";
				}
				Produit p = c.recherch(r);
				if(p!=null){
					System.out.println("produit trouver \n la réference du produit est :"+p.getRef()+
							" \n le prix du produit : "+p.getPrix()+
							" \n la description du produit :"+p.getDescription());
				}else{
					System.out.println("le produit n\'existe pas");
				}
				choixg =menu.menugeneral();
			}else if(choixg == 4){
				System.out.println("entrer la nouvelle reference :");
				String r=s.next();
				
				if(c.recherch(r) == null){
					System.out.println("entrer le nouveau prix :");
					int p =s.nextInt();
					if(p>=0){
						System.out.println("entrer le nouveau nom :");
						String n=s.next();
						
						System.out.println("entrer la nouvelle description :");
						
						String d=s.next();
						
						c.ajouterproduit(new Produit(r,d,p,n));
					}else{
						System.out.println("vous ne pouvez pas ajouter un prix negatif !!! :");
					}
				}else{
					System.out.println("le reference que vous-voulez existe deja !!! :");
				}	
				
				choixg =menu.menugeneral();
			}else if(choixg == 5){
				System.out.println("Entre la reference du produit que vous-voulez supprimer : ");
				String ref=s.next();
				Produit p = c.recherch(ref);
				if(p!=null){
					c.getProduits().remove(p);
				}else{
					System.out.println("le produit n\'existe pas");
				}
				choixg =menu.menugeneral();
			}
		}
		try {
	         FileOutputStream fileOut = new FileOutputStream("catalogue.ser");
	         ObjectOutputStream out = new ObjectOutputStream(fileOut);
	         out.writeObject(c);
	         out.close();
	         fileOut.close();
	         System.out.printf("Catalgue sauvrgarder in catalogue.se");
	      }catch(IOException i) {
	         System.out.println("un erreur est survenu lors de l\'écréture dans le fichier : "+i);
	      }
	}

	/*private static void initUserModel() {
		final UserModel userModel = new UserModel();
		userModel.register(mainController);
	}*/

}
