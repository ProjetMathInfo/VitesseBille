package maths.fonctions;

public class RacineCarre implements FonctionDerivable {
	
	public RacineCarre(){}
	
	public double eval(double x) {
		return Math.sqrt(x) ;
	}
	public FonctionDerivable derive() {
		return new Quotient(new Constante(1),new Produit(new Constante(2),new RacineCarre())) ;
	}
	public String toString() {
		return "√x" ;
	}
}