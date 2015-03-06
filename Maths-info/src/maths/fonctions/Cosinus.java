package maths.fonctions;

public class Cosinus implements FonctionDerivable {
	
	private static FonctionDerivable derivee=new Oppose(new Sinus()) ;
	
	public Cosinus() {}
	
	public double eval(double x) {
		return Math.cos(x) ;
	}
	public FonctionDerivable derive() {
		return derivee ;
	}
	public String toString() {
		return "cos" ;
	}
}