package org.iae.annecy.st1.etape1.controller;

import java.util.ArrayList;
import java.util.Iterator;

import org.iae.annecy.st1.etape1.model.client.Client;

public class ClientController implements java.io.Serializable {
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
		for(Client monclient : this.client){
			texte = monclient.afficher()+"\n";
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
	

}
