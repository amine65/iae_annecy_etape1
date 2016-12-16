package org.iae.annecy.st1.etape1.controller.listclient;

import java.util.ArrayList;
import java.util.Iterator;

import org.iae.annecy.st1.etape1.model.client.Client;
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
	
	public void metreajour(Client monclient){
		int i=0;
		while(this.client.iterator().hasNext()){
			Client landaclient=this.client.iterator().next();
			if(monclient.getNumero() == landaclient.getNumero()){
				this.client.get(i).setProduit(monclient.getProduit());
			}
			i++;
		}
	}
	

}
