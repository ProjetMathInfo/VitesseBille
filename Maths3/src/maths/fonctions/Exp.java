package maths.fonctions;

public class Exp implements FonctionDerivable {
	private FonctionDerivable derivee;
	private FonctionDerivable f;
	
	public Exp(FonctionDerivable fx){
		this.f=fx;
	}
	
	public double eval(double x) {
		return Math.exp(this.f.eval(x)) ;
	}
	public FonctionDerivable derive() {
		this.derivee=new Exp(this.f);
		return derivee ;
	}
	public String toString() {
		return "exp" ;
	}
}