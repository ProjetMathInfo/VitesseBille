package maths.fonctions;

public class E implements FonctionDerivable {
	private FonctionDerivable derivee;
	private FonctionDerivable f;
	
	public E(FonctionDerivable fx){
		this.f=fx;
	}
	
	public double eval(double x) {
		return Math.exp(this.f.eval(x)) ;
	}
	public FonctionDerivable derive() {
		this.derivee=new E(this.f);
		return derivee ;
	}
	public String toString() {
		return "exp("+this.f+")" ;
	}
}