package maths.formules;
import maths.fonctions.*;
import java.util.ArrayList;

public class ErreurQuadrature implements Formule{
	private String name;
	private ArrayList<ArrayList<Double>> tabValeur;
	
	public ErreurQuadrature(){
		this.name="Erreur de Quadrature";
		this.tabValeur=new ArrayList<ArrayList<Double>>();
	}
	
	public ArrayList<ArrayList<Double>> resoudre(int n, Fonction fonction){
		System.out.println("Résolution avec la méthode ErreurQuadrature");
		double res=1.0/24.0/*dérivée seconde de f sur ]0,1[*/;
		return this.tabValeur;
	}
	public String toString(){
		return this.name;
	}

}
