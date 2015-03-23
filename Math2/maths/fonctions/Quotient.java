package maths.fonctions;

public class Quotient implements FonctionDerivable {
	private FonctionDerivable f ;
	private FonctionDerivable g ;
	public Quotient(FonctionDerivable f,FonctionDerivable g) {
		this.f=f ;
		this.g=g ;
	}
	public double eval(double x) {
		return f.eval(x)/g.eval(x) ;
	}
	public FonctionDerivable derive() {
		return new Quotient(
		(new Difference(new Produit(f.derive(),g),new Produit(f,g.derive()))),
		new Carree(f)) ;
	}
	public String toString() {
		return f+"/"+g ;
	}
}