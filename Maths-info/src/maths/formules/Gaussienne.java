package maths.formules;

import java.util.ArrayList;
import maths.fonctions.*;
import java.util.ArrayList;

public class Gaussienne implements Formule{
	private String name;
	private ArrayList<ArrayList<Double>> tabValeur;
	
	public Gaussienne(){
		this.name="Gaussienne";
		this.tabValeur=new ArrayList<ArrayList<Double>>();
	}
	
	public ArrayList<ArrayList<Double>> resoudre(int n, Fonction fonction){
		System.out.println("Résolution avec la méthode Gaussienne");
		return this.tabValeur;
	}
	public String toString(){
		return this.name;
	}
}
