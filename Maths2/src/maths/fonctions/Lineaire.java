package maths.fonctions;

public class Lineaire implements FonctionDerivable {
	private FonctionDerivable derivee ;
	private String name;
	
	public Lineaire() {
		this.name="x";
	}
	
	public double eval(double x) {
		return x ;
	}
	public FonctionDerivable derive() {
		return derivee ;
	}
	public String toString() {
		return this.name;
	}
}