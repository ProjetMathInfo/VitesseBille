package maths.fonctions;

public class Lineaire implements FonctionDerivable{
	
	public Lineaire(){}
	
	public double eval(double x) {
		return  x;
	}
	
	public FonctionDerivable derive(){
		return new Constante(1);
	}
	
	public String toString() {
		return "x";
	}
}