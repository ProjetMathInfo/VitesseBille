package maths.fonctions;

public class Sinus implements FonctionDerivable {
	
	private static FonctionDerivable derivee= new Cosinus() ;
	
	public Sinus(){}
	
	public double eval(double x) {
		return Math.sin(x) ;
	}
	public FonctionDerivable derive() {
		return derivee ;
	}
	public String toString() {
		return "sin" ;
	}
}