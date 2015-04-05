package maths.fonctions;

public class Somme implements FonctionDerivable {
	private FonctionDerivable f ;
	private FonctionDerivable g ;
	
	public Somme(FonctionDerivable f,FonctionDerivable g) {
		this.f=f ;
		this.g=g ;
	}
	public double eval(double x) {
		return f.eval(x)+g.eval(x) ;
	}
	public FonctionDerivable derive() {
		return new Somme(f.derive(),g.derive()) ;
	}
	public String toString() {
		return f+"+"+g ;
	}
}