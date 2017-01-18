package org.iae.mti.m1.jeremie.view;

import java.util.Iterator;

import org.iae.mti.m1.jeremie.model.CatalogueProduit;
import org.iae.mti.m1.jeremie.model.Produit;

public class Display {
	
	public String afficherMenu(){  //Permet d'afficher le menu que peut utiliser l'utilisateur
		return "1 - Afficher le catalogue Produit \r\n2 - Modifier un produit\r\n3 - Ajouter un produit \r\n4 - Afficher le catalogue Client \r\n5 - Modifier un client \r\n6 - Ajouter un client\r\n99 - Quitter";
	}
	
	public String menuModifProduit(){ // Affiche le menu visible par l'utilisateur quand il a choisit de modifier un produit
		return "1 - Description \r\n2 - Prix";
	}
	
	public String menuModifClient(){  // Affiche le menu visible par l'utilisateur quand il a choisit de modifier un client
		return "1 - Nom \r\n2 - Prenom \r\n3 - Code Promotionnel";
	}
	
	public void poserQuestion(String question){   //Permet de poser une question à l'utilisateur
		System.out.println(question); 
	}


}
