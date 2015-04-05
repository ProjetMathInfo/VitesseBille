package maths.fonctions;

/* La classe Arrondir contient :
	2 attributs : 
	** le nombre x a arrondir
	** le nombre decimales n
	* 1 methode arrondir() qui renvoie une chaine de caracteres
	* 1 methode arrondi() qui renvoie un double
*/

public class Arrondir {
	double x;
	int n;

	public Arrondir(double a, int b){
		this.x = a;
		this.n = b;
	}
	public String arrondir() {
		double r =  (Math.round(x*Math.pow(10,n)) )/ (Math.pow(10,n));
		return Double.toString(r);
	}

	public double arrondi() {
		double r =  (Math.round(x*Math.pow(10,n)) )/ (Math.pow(10,n));
		return r;
	}
}