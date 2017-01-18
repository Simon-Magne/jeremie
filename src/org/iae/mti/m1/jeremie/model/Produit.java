package org.iae.mti.m1.jeremie.model;

import java.io.Serializable;

//************************************ CLASSES *********************************************\\
public class Produit implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int reference;
	private String nom;
	private String description;
	private double prix;

//************************************ GETTER & SETTER *********************************************\\
	
	
	public int getReference() {
		return reference;
	}

	public void setReference(int reference) {
		this.reference = reference;
	}
	
	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public double getPrix() {
		return this.prix;
	}

	public void setPrix(double prix) {
		this.prix = prix;
	}

//***********************************************Constructeur*************************************\\
	/**
	 * @param reference
	 * @param description
	 * @param prix
	 */
	
	public Produit(int reference, String nom, String description, double prix) {
		super();
		this.reference = reference;
		this.nom = nom;
		this.description = description;
		this.prix = prix;
	}



//*************************************************METHODES ****************************************\\
	public String afficherProduit() {
		return "Reference : " + this.reference + "," + " Description : " + this.description + ","
				+ " Prix : " + this.prix;     // Retourne les attributs du produit
	}
	
	public boolean validerPrix() {
		if (this.prix > 0){
			return true;           // Vérifie si le prix est supérieur à 0, si c'est le cas le boolean retourne vrai sinon retourne faux.
		}
		else {
			return false;
		}
		}
}
