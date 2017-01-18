package org.iae.mti.m1.jeremie.model;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import org.iae.mti.m1.jeremie.data.SerializerProduit;

public class CatalogueProduit extends ArrayList<Produit> {
	
//------------------------------Singleton-----------------------------------------------\\
	private static CatalogueProduit instance = null;

	public static CatalogueProduit getInstance() {
		if (instance == null) {                      // Singleton pour le catalogue produit 
			instance = new CatalogueProduit();
		}
		return instance;
	}
//-----------------------------------AfficherProduits()-------------------------------------\\
	public String afficherProduits() {
		// TODO Auto-generated method stub
		
		Iterator<Produit> it = iterator();                
		String result = "";
		while(it.hasNext()){                      // parcours la collection de produit présente dans le catalogue et fait un afficherProduit()
			Produit p = it.next();                // pour chaque produit de la collection et retourne l'intégralité des produits parcouruent
			 result = result + p.afficherProduit() + "\r\n";
		}
		return result;
		
	}
	
	public boolean validerRef(Produit p){
		Iterator<Produit> it = iterator();
		boolean isValid = true ;                 // parcours la collection en vérifiant si la référence du produit passé en paramètre et égale
		while(it.hasNext()){                     // à un des produits de la collection. Si c'est le cas le boolean est faux, sinon il est vrai
			Produit p1 = it.next();
			if(p.getReference() == p1.getReference()){
				isValid = false;
				break;
			
			
			}
		}
		return isValid;
	}
	
}
