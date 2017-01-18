package org.iae.mti.m1.jeremie.model;

import java.util.ArrayList;
import java.util.Iterator;

public class CatalogueClient extends ArrayList<Client>{

	private static CatalogueClient instance2 = null;
	public static CatalogueClient getInstance() {
		if (instance2 == null) {						// Singleton pour le catalogue Client 
			instance2 = new CatalogueClient();
		}
		return instance2;
	}
//-----------------------------------AfficherProduits()-------------------------------------\\
	public String afficherClients() {
		// TODO Auto-generated method stub
		
		Iterator<Client> it = iterator();
		String result = "";						// parcours la collection de client présente dans le catalogue et fait un afficherClients()
		while(it.hasNext()){					// pour chaque client de la collection et retourne l'intégralité des client parcouruent
			Client client = it.next();
			 result = result + client.afficherClient() + "\r\n";
		}
		return result;
		
	}
	
	public boolean validerNum(Client client){
		Iterator<Client> it = iterator();
		boolean isValid = true ;				// parcours la collection en vérifiant si le numero du client ,passé en paramètre, et égale
		while(it.hasNext()){					 // à un des numero client de la collection. Si c'est le cas le boolean est faux, sinon il est vrai
			Client c1 = it.next();
			if(client.getNumeroClient() == c1.getNumeroClient()){
				isValid = false;
				break;
			
			
			}
		}
		return isValid;
	}
	
	
	
	
	}
	

