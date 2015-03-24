package maths.fonctions;

public class DeriveeRacineCarre implements FonctionDerivable {
		
	private static FonctionDerivable derivee= new Sinus() ;
	
	public DeriveeRacineCarre(){}
	
	public double eval(double x) {
		return (1/(2*Math.sqrt(x))) ;
	}
	
	public String toString() {
		return "1/(2√x)" ;
	}
	
	public FonctionDerivable derive() {
		return derivee;
	}
}