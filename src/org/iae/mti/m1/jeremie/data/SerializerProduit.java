package org.iae.mti.m1.jeremie.data;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;


import org.iae.mti.m1.jeremie.model.CatalogueProduit;
import org.iae.mti.m1.jeremie.model.Produit;

public class SerializerProduit {
	
	public CatalogueProduit loadProduit(){
//******************************** DESERIALISATION = récupère le fichier sauvegardé ******************************************/
	// On créer une liste "catalogueProduit" qui est une nouvelle ArrayList
	CatalogueProduit catalogueProduit = new CatalogueProduit();
		try {
			FileInputStream streamIn1 = new FileInputStream("C:/Users/Simon/workspace/monCatalogue.ser");  //On charge le fichier qui se trouve à l'espace indiqué
			ObjectInputStream objectinputstream1 = new ObjectInputStream(streamIn1);
			try {
				catalogueProduit = (CatalogueProduit) objectinputstream1.readObject();
			} finally {
				try {
					objectinputstream1.close();
				} finally {
					streamIn1.close();
				}
			}
		} catch (IOException ioe) {
			// ioe.printStackTrace();
			System.out.println("nouveau calogue"); // si le catalogue n'existe pas, la création d'un nouveau catalogue est indiquée
		} catch (ClassNotFoundException cnfe) {
			cnfe.printStackTrace();
		}
		return catalogueProduit;      // retourne le catalogue chargé

	}

//************************** Serialisation = sauvegarde de la modification ***************************/
	public void saveProduit(CatalogueProduit cat) throws IOException{
	
		FileOutputStream fout = new FileOutputStream("C:/Users/Simon/workspace/monCatalogue.ser");   // sauvegarde du catalogue dans le fichier 
		ObjectOutputStream oos = new ObjectOutputStream(fout);
		oos.writeObject(cat);
		oos.close();
	}
	
	
	
}
