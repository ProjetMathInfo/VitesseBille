package maths.fonctions;

public class RacineCarre implements FonctionDerivable {
	
	private static FonctionDerivable derivee = new DeriveeRacineCarre() ;
	
	public RacineCarre(){}
	
	public double eval(double x) {
		return Math.sqrt(x) ;
	}
	public FonctionDerivable derive() {
		return derivee ;
	}
	public String toString() {
		return "√x" ;
	}
}