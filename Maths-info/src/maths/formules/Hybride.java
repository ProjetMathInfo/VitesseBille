package maths.formules;

import java.util.ArrayList;

import maths.Fonction;

public class Hybride implements Formule{
	private String name;
	private ArrayList<ArrayList<Double>> tabValeur;
	
	public Hybride(){
		this.name="Hybride";
		this.tabValeur=new ArrayList<ArrayList<Double>>();
	}
	
	public void resoudre(int n, Fonction fonction){
		System.out.println("Résolution avec la méthode Hybride");
	}
	public String toString(){
		return this.name;
	}
}
