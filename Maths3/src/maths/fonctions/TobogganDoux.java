package maths.fonctions;
import maths.fonctions.*;
public class TobogganDoux implements FonctionDerivable{
	
	private FonctionDerivable f ;

	public TobogganDoux() {
		this.f=new Produit(
				new Produit(
						new Constante(0.5),new Produit(new RacineCarre(),new Lineaire()))
						,new Difference(new Constante(5),new Produit(new Constante(3),new Lineaire())));
	}
	
	public double eval(double x) {
		return 0.5*Math.pow(x, 1.5)*(5-3*x) ;
	}
	
	public FonctionDerivable derive() {
		return new Quotient(
				new Produit(new Produit(new Constante(15),new RacineCarre()),
								new Difference(new Constante(1),new Lineaire()))
				,new Constante(4));
		
	}
	
	public String toString() {
		return "(1/2) * x^(3/2) * (5-3x)"  ;
	}
}