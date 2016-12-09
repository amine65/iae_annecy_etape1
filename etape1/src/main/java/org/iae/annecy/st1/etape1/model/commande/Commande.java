package org.iae.annecy.st1.etape1.model.commande;

import java.util.ArrayList;
import java.util.Iterator;

import org.iae.annecy.st1.etape1.model.client.Client;
import org.iae.annecy.st1.tools.ConsoleHelper;

public class Commande {
	private ArrayList<Client> clients = new ArrayList<Client>();

	public ArrayList<Client> getClients() {
		return clients;
	}

	public void setClients(ArrayList<Client> clients) {
		this.clients = clients;
	}
	
	public void ajouterclient(Client client){
		this.getClients().add(client);
	}
	
	public Client recherch(int id){
		Iterator<Client> it = this.clients.iterator();
		while(it.hasNext()){
			Client landaclient=it.next();
			if(id == landaclient.getNumero()){
				return landaclient;
			}
		}
		return null;
	}
	
	public void recherchclient(int id){
		Iterator<Client> it = this.clients.iterator();
		int i=0;
		while(it.hasNext()){
			Client landaclient=it.next();
			if(id == landaclient.getNumero()){
				this.getClients().get(i).setProduit(landaclient.getProduit());
			}
			i++;
		}
		
	}
	
	public void afficherparclient(){
		for(Client client: this.getClients()){
			if(client.getProduit()!=null){
				ConsoleHelper.display("le client numero : "+client.getNumero()+" à acheter les produit suivants : ");
				client.afficherproduits();
			}
		}
		
	}

}
