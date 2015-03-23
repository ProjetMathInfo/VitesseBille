package maths.fonctions;

public class Oppose implements FonctionDerivable {
	private FonctionDerivable f ;
	
	public Oppose(FonctionDerivable f) {
		this.f=f ;
	}
	
	public double eval(double x) {
		return -f.eval(x) ;
	}
	
	public FonctionDerivable derive() {
		return new Oppose(f.derive()) ;
	}
	
	public String toString() {
		return "-"+f ;
	}
}