package maths.formules;
import maths.fonctions.*;
import java.util.ArrayList;


public class Hybride implements Formule{
	private String name;
	private ArrayList<ArrayList<Double>> tabValeur;
	
	public Hybride(){
		this.name="Hybride";
		this.tabValeur=new ArrayList<ArrayList<Double>>();
	}
	
	public ArrayList<ArrayList<Double>> resoudre(int n, Fonction fonction){
		System.out.println("Résolution avec la méthode Hybride");
		return this.tabValeur;
	}
	public String toString(){
		return this.name;
	}
}
