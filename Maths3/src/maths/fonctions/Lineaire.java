package maths.fonctions;

public class Lineaire implements FonctionDerivable{
	private double coef;
	
	public Lineaire(){
		this.coef=1.0;
	}
	
	public Lineaire(double a){
		this.coef=a;
	}
	
	public double eval(double x) {
		return  x*this.coef;
	}
	
	public FonctionDerivable derive(){
		return new Constante(this.coef);
	}
	
	public String toString() {
		return this.coef+"x";
	}
}