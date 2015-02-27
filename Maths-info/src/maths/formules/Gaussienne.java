package maths.formules;

import java.util.ArrayList;

import maths.Fonction;

public class Gaussienne implements Formule{
	private String name;
	private ArrayList<ArrayList<Double>> tabValeur;
	
	public Gaussienne(){
		this.name="Gaussienne";
		this.tabValeur=new ArrayList<ArrayList<Double>>();
	}
	
	public void resoudre(int n, Fonction fonction){
		System.out.println("Résolution avec la méthode Gaussienne");
	}
	public String toString(){
		return this.name;
	}
}
