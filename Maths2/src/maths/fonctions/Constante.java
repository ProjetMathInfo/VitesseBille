package maths.fonctions;
import maths.fonctions.*;

public class Constante implements FonctionDerivable {
	private double valeur;
	
	public Constante(double constante) {
		this.valeur = constante;
	}
	
	public double eval(double x) {
		return  this.valeur;
	}
	
	public FonctionDerivable derive(){
		return new Constante(0);
	}
	
	public String toString() {
		return ""+this.valeur;
	}
}