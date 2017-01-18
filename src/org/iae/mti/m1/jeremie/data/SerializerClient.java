package org.iae.mti.m1.jeremie.data;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import org.iae.mti.m1.jeremie.model.CatalogueClient;

public class SerializerClient {
	public CatalogueClient loadClient(){
		//******************************** DESERIALISATION = récupère le fichier sauvegardé ******************************************/
			// On créer une liste "catalogueP" qui est une nouvelle ArrayList
			CatalogueClient catalogueP = new CatalogueClient();
				try {
					FileInputStream streamIn2 = new FileInputStream("C:/Users/Simon/workspace/monCatalogueClient.ser");   //On charge le fichier qui se trouve à l'espace indiqué
					ObjectInputStream objectinputstream2 = new ObjectInputStream(streamIn2);
					try {
						catalogueP = (CatalogueClient) objectinputstream2.readObject();
					} finally {
						try {
							objectinputstream2.close();
						} finally {
							streamIn2.close();
						}
					}
				} catch (IOException ioe) {
					// ioe.printStackTrace();
					System.out.println("nouveau calogue");    // si le catalogue n'existe pas, la création d'un nouveau catalogue est indiquée
				} catch (ClassNotFoundException cnfe) {
					cnfe.printStackTrace();
				}
				return catalogueP;				// retourne le catalogue chargé

			}
	
	public void saveClient(CatalogueClient catClient) throws IOException{
		
		FileOutputStream fout2 = new FileOutputStream("C:/Users/Simon/workspace/monCatalogueClient.ser");
		ObjectOutputStream oos2 = new ObjectOutputStream(fout2);
		oos2.writeObject(catClient);								// sauvegarde du catalogue dans le fichier
		oos2.close();
	}
}
