package maths.fonctions;

public class Puissance implements FonctionDerivable {
	private FonctionDerivable fonction ;
	private int puissance;
	
	public Puissance(FonctionDerivable f,int n) {
		this.puissance = n;
		this.fonction = f;
	}
	
	public double eval(double x) {
		return Math.pow(x, this.puissance);
	}
	
	public FonctionDerivable derive() {
		return new Produit(new Constante(this.puissance),new Puissance(this.fonction,this.puissance-1));
	}
	public String toString() {
		return this.fonction+"^n" ;
	}
}