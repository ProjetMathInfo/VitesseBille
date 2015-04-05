package maths.fonctions;

public class Puissance implements FonctionDerivable {
	private FonctionDerivable fonction ;
	private double puissance;
	
	public Puissance(FonctionDerivable f,double d) {
		this.puissance = d;
		this.fonction = f;
	}
	
	public double eval(double x) {
		return Math.pow(x, this.puissance);
	}
	
	public FonctionDerivable derive() {
		return new Produit(new Constante(this.puissance),new Puissance(this.fonction,this.puissance-1));
	}
	public String toString() {
		return this.fonction+"^"+this.puissance ;
	}
}