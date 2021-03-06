package maths.fonctions;

public class Carree implements FonctionDerivable {
	private FonctionDerivable f ;
	
	public Carree(FonctionDerivable fx) {
		this.f=fx;
	}
	
	public double eval(double x) {
		return this.f.eval(x)*this.f.eval(x) ;
	}
	public FonctionDerivable derive() {
		return this.f;
	}
	public String toString() {
		return ""+this.f+"*"+this.f ;
	}
}