package org.iae.annecy.st1.etape1.controller.listclient;

import java.util.ArrayList;
import java.util.Iterator;

import org.iae.annecy.st1.etape1.model.client.Client;
import org.iae.annecy.st1.etape1.model.produit.Produit;
import org.iae.annecy.st1.tools.ConsoleHelper;

public class ClientController implements java.io.Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -7170397225018528367L;
	private ArrayList<Client> client = new ArrayList<Client>();

	public ClientController(Client monclient){
		this.client.add(monclient);
	}
	public ClientController(){

	}

	public ArrayList<Client> getClient() {
		return client;
	}
	public void setClient(ArrayList<Client> client) {
		this.client = client;
	}


	public String get(){
		String texte="";
		if(!this.getClient().isEmpty()){
			for(Client monclient : this.client){
				texte += monclient.afficher()+"\n";
			}
		}else{
			ConsoleHelper.display("le repertoire des clients est vide");
		}
		return texte;
	}

	public void ajouterClient(Client monclient){
		this.client.add(monclient);
	}

	public Client recherch(int id){
		Iterator<Client> it = this.client.iterator();
		while(it.hasNext()){
			Client landaclient=it.next();
			if(id == landaclient.getNumero()){
				return landaclient;
			}
		}
		return null;
	}

	public int numeroclient(int numero){
		int i=0;
		Client landaclient = new Client();
		Iterator<Client> it = this.getClient().iterator();
		while(it.hasNext()){
			landaclient=it.next();
			if(numero == landaclient.getNumero()){
				return i;
			}
			i++;
		}
		return -1;
	}
	public void metreajour(Client monclient){
		int i=0;
		while(this.client.iterator().hasNext()){
			Client landaclient=this.client.iterator().next();
			
			
			
			if(monclient.getNumero() == landaclient.getNumero()){
				this.getClient().get(i).setProduit(monclient.getProduit());
			}
			i++;
		}
	}

	public void afficherparclient() {
		for (Client client : this.getClient()) {
			if (!client.getProduit().isEmpty()) {
				ConsoleHelper.display("le client: " + client.getNom() + " numero : " + client.getNumero()
				+ " à acheter les produit suivants : ");
				client.afficherproduits();
			}else {
				ConsoleHelper.display(" Salut client: " + client.getNom() + " numero : " + client.getNumero());
				ConsoleHelper.display(" vous n\'avez acheté aucun produit pour le moment ");
			}
		}

	}


}
