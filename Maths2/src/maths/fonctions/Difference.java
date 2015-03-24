package maths.fonctions;

public class Difference implements FonctionDerivable {
	private FonctionDerivable f ;
	private FonctionDerivable g ;
	
	public Difference(FonctionDerivable f,FonctionDerivable g) {
		this.f=f ;
		this.g=g ;
	}
	public double eval(double x) {
		return f.eval(x)-g.eval(x) ;
	}
	public FonctionDerivable derive() {
		return new Difference(f.derive(),g.derive()) ;
	}
	public String toString() {
		return f+"-"+g ;
	}
}