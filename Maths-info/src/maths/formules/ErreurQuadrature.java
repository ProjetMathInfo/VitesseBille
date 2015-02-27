package maths.formules;

import java.util.ArrayList;

import maths.Fonction;

public class ErreurQuadrature implements Formule{
	private String name;
	private ArrayList<ArrayList<Double>> tabValeur;
	
	public ErreurQuadrature(){
		this.name="Erreur de Quadrature";
		this.tabValeur=new ArrayList<ArrayList<Double>>();
	}
	
	public void resoudre(int n, Fonction fonction){
		System.out.println("Résolution avec la méthode ErreurQuadrature");
	}
	public String toString(){
		return this.name;
	}

}
