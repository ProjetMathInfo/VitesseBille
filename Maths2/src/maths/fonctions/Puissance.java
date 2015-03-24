package maths.fonctions;

public class Puissance implements FonctionDerivable {
	
	private static FonctionDerivable derivee;
	private FonctionDerivable fonction;
	private double puissance;
	
	public Puissance(FonctionDerivable f,double p){
		this.fonction=f;
		this.puissance=p;
	}
	
	public double eval(double a) {
		return Math.pow(this.fonction.eval(a), this.puissance) ;
	}
	public FonctionDerivable derive() {
		return derivee ;
	}
	public String toString() {
		return this.fonction+"^"+this.puissance ;
	}
}