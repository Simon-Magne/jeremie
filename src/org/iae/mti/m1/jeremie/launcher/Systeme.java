package org.iae.mti.m1.jeremie.launcher;

import java.io.IOException;

import org.iae.mti.m1.jeremie.data.SerializerProduit;
import org.iae.mti.m1.jeremie.data.SerializerClient;
import org.iae.mti.m1.jeremie.model.CatalogueClient;
import org.iae.mti.m1.jeremie.model.CatalogueProduit;
import org.iae.mti.m1.jeremie.model.Client;
import org.iae.mti.m1.jeremie.model.Produit;
import org.iae.mti.m1.jeremie.view.Display;
import org.iae.mti.m1.jeremie.view.Input;

public class Systeme {
	
	static Display dis = new Display(); 
	static Input inp = new Input();
	
	public static int poserQuestionInt (String q){
		dis.poserQuestion(q);
		int retour = inp.readInt();
		return retour;
	}
	
	public static String poserQuestionString (String q){
		dis.poserQuestion(q);
		String retour = inp.readString();
		return retour;
	}
	
	public static double poserQuestionDouble (String q){
		dis.poserQuestion(q);
		double retour = inp.readDouble();
		return retour;
	}
	
						// création d'un display et input pour permettre d'afficher les questions et permettre à l'utilisateur de répondre
	
	public static void main(String[] args) throws IOException {
		
		 
		CatalogueProduit catalogueProduit = new CatalogueProduit();
		CatalogueClient catalogueClient = new CatalogueClient();
		SerializerProduit serp = new SerializerProduit();
		SerializerClient serc = new SerializerClient();
		catalogueProduit = serp.loadProduit();
		catalogueClient = serc.loadClient();

		// création d'un catalogue produit et d'un catalogue client ainsi que 2 serializer afin de charger les fichiers des catalogues
	
		int choixMenu = -1;
		while (choixMenu != 99) {
			dis.poserQuestion("Que voulez-vous faire ?");
			System.out.println(dis.afficherMenu());
			choixMenu = inp.readInt();

			
			switch (choixMenu) {
			case 1:
				System.out.println(catalogueProduit.afficherProduits());      // premier choix du menu, afficher le catalogue produit
				break;
			case 2:
				System.out.println(catalogueProduit.afficherProduits());
				int indexProduit = poserQuestionInt("Quel produit voulez-vous modifier ? (sélectionner la référence)");
																			// deuxième choix, modifier un produit
				
				for (int i = 0; i < catalogueProduit.size(); i++) {
					int j = i + 1;
					if (catalogueProduit.get(i).getReference() == indexProduit) {    // Boucle pour parcourir les produits du catalogue et afficher le produit ayant la référence recherchée
						Produit prod = catalogueProduit.get(i);							// variable prod est maintenant égale au produit recherché
						System.out.println(prod.afficherProduit());
						
						System.out.println(dis.menuModifProduit());
						int choixAttribut = poserQuestionInt("Quelle information voulez-vous modifier ?"); 		// si deuxième choix alors proposer les informations à modifier

						switch (choixAttribut) {
						case 1:
							
							String nvlleDescription = poserQuestionString("Quelle est la nouvelle valeur de l'attribut");
							prod.setDescription(nvlleDescription);				// si choix de l'attribut description, rentrer une nouvelle description
							break;

						case 2:
							
							double nvPrix = poserQuestionDouble("Quelle est la nouvelle valeur de l'attribut?");
							prod.setPrix(nvPrix);				// si choix de l'attribut prix, rentrer un nouveau prix
							serp.saveProduit(catalogueProduit);
							break;
						default:
							System.out.println("Interdit");			// si aucun choix, afficher le message interdit
							
						}

						System.out.println(prod.afficherProduit());
						break;
						
					}
					
				}
				
					break;
				

				
			case 3:			// création d'un nouveau produit
				int nvlleRef = poserQuestionInt("Quel est la référence du nouveau produit?" );
				String nvNom = poserQuestionString ("Quel est le nom du produit ?");
				String nvlleDescription = poserQuestionString("Quelle est la description du produit?");
				double nvPrix = poserQuestionDouble("Quel est le nouveau prix du produit?");
				Produit p = new Produit(nvlleRef, nvNom, nvlleDescription, nvPrix);
				boolean isPrixValid = p.validerPrix();
				boolean isRefValid = catalogueProduit.validerRef(p);
				
				if(isPrixValid == true && isRefValid == true){
					catalogueProduit.add(p);                    // si le prix et la référence du nouveau produit sont valide alors le produit est ajouté au catalogue
					serp.saveProduit(catalogueProduit);
				}
				else{
					System.out.println("Le produit n'est pas valide (prix et/ou référence !");
				}
				
				break;
				
			
			 case 4 : // afficher le catalogue client
	
				System.out.println(catalogueClient.afficherClients());
				
				break;
				
			case 5 : // demander le client à modifier
				
				System.out.println(catalogueClient.afficherClients());
				int indexClient = poserQuestionInt("Quel Client voulez-vous modifier ? (taper le numero du client a modifier)");
				for (int i = 0; i < catalogueClient.size(); i++) {
					int j = i + 1;
					if (catalogueClient.get(i).getNumeroClient() == indexClient) {    // Boucle pour parcourir les clients du catalogue et afficher le client ayant le numero client recherchée
						Client client = catalogueClient.get(i);							// variable client est maintenant égale au client recherché
						System.out.println(client.afficherClient());

				System.out.println(dis.menuModifClient());  // demander l'attribut du client à modifier
				int choixAttributClient = poserQuestionInt("Quelle information voulez-vous modifier ?");

				switch (choixAttributClient) {
				case 1:// modifier le nom,
					
					String nvxnom = poserQuestionString("Quelle est la nouvelle valeur de l'attribut");
					client.setNom(nvxnom);
					break;
					
				case 2: // modifier le prenom
					
					String nvxprenom = poserQuestionString("Quelle est la nouvelle valeur de l'attribut");
					client.setPrenom(nvxprenom);
					break;
										

				case 3: // modifier le code promo
					
					String nvxcodepromo = poserQuestionString("Quelle est la nouvelle valeur de l'attribut");
					client.setCodePromo(nvxcodepromo);
										serc.saveClient(catalogueClient);
					break;
				default:
					System.out.println("Interdit"); // si aucun choix ou mauvais, afficher interdit
				}

				System.out.println(client.afficherClient());
				break;
					}
				}
				
				break;
				
			case 6 : // création d'un nouveau client
				
				String nvxnom = poserQuestionString("Quel est le nom du nouveau client?" );
				String nvxprenom = poserQuestionString("Quelle est le prenom du client?");
				String nvxcodepromo = poserQuestionString("Quelle est le code promotionnel du client? (taper aucun si null)");
				int nvxnumclient = poserQuestionInt("Quel est le numero du client?");
				Client client1 = new Client(nvxnumclient, nvxnom, nvxprenom, nvxcodepromo);
			boolean isNumValid = catalogueClient.validerNum(client1);
				
				if(isNumValid == true){
					catalogueClient.add(client1);               // si numero client est valide alors on ajoute le nouveau client au catalogue
					serc.saveClient(catalogueClient);
				}
				else{
					System.out.println("Le client n'est pas valide (numero client !)");
				}
				break;
				
			case 99: // quitter la boucle de l'application
				System.out.println("Fin de l'application : Aurevoir !");
				break;
			}

		}

		
		
		 


		

	}

}
