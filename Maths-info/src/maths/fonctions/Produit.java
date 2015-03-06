package maths.fonctions;

public class Produit implements FonctionDerivable {
	private FonctionDerivable f ;
	private FonctionDerivable g ;
	
	public Produit(FonctionDerivable f,FonctionDerivable g) {
		this.f=f ;
		this.g=g ;
	}
	public double eval(double x) {
		return f.eval(x)*g.eval(x) ;
	}
	public FonctionDerivable derive() {
		return new Somme(
		new Produit(f.derive(),g),
		new Produit(f,g.derive())) ;
	}
	public String toString() {
		return f+"*"+g ;
	}
}