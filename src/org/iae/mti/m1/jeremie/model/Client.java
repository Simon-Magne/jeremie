package org.iae.mti.m1.jeremie.model;

import java.io.Serializable;

public class Client implements Serializable {

	private static final long serialVersionUID = 1L;
	private String nom;
	private String prenom;
	private int numeroClient;
	private String codePromo;
	
	//************************************ GETTER & SETTER *********************************************\\
	
	
	public String getNom() {
		return nom;
	}
	
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	public int getNumeroClient() {
		return numeroClient;
	}
	public void setNumeroClient(int numeroClient) {
		this.numeroClient = numeroClient;
	}
	public String getCodePromo() {
		return codePromo;
	}
	public void setCodePromo(String codePromo) {
		this.codePromo = codePromo;
	}
	
	
	//***********************************************Constructeur*************************************\\
	
	public Client(int numeroClient, String nom, String prenom, String codePromo) {
		super();
		
		this.nom = nom;
		this.prenom = prenom;
		this.numeroClient = numeroClient;
		this.codePromo = codePromo;
	}
	
	
	//*************************************************METHODES ****************************************\\
	
	
	public String afficherClient() {
		return " Numero client : " + this.numeroClient +"," + " Nom : " + this.nom + "," + " Prenom : " + this.prenom + ","
				+  " Code Promotionnel : " + this.codePromo;
	}
	// Retourne les attributs du client
	
}
