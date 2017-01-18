package org.iae.mti.m1.jeremie.view;

import java.util.Scanner;

import org.iae.mti.m1.jeremie.model.CatalogueProduit;
import org.iae.mti.m1.jeremie.model.Produit;

public class Input {
	
	public int readInt(){
		Scanner sc = new Scanner(System.in);   // Scanner pour attribut int
				return sc.nextInt();
	}
	
	public String readString(){				// Scanner pour attribut String
		Scanner sc = new Scanner(System.in);
		return sc.nextLine();
	}

	public double readDouble(){				// Scanner pour attribut double
		Scanner sc = new Scanner(System.in);
		return sc.nextDouble();
	}
}
