package maths.fonctions;

public class Polynome implements Fonction {
	private double[] coefficients ;
	
	public Polynome(double[] coefficients) {
		this.coefficients=coefficients ;
	}
	
	public double eval(double x) {
		double resultat=0 ;
		for (int i=coefficients.length-1;i>0;i--) {
			resultat+=coefficients[i] ;
			resultat*=x ;
		}
		resultat+=coefficients[0] ;
		return resultat ;
	}
	
	/* renvoie la somme du polynome appelant et du parametre */
	public Polynome somme(Polynome p) {
		int n;
		if (coefficients.length<p.coefficients.length)
			n=p.coefficients.length ;
		else
		n=coefficients.length ;
		double[] tab=new double[n] ;
		for (int i=0;i<n;i++) {
			if (i<coefficients.length)
				tab[i]+=coefficients[i] ;
			if (i<p.coefficients.length)
				tab[i]+=p.coefficients[i] ;
		}
		return new Polynome(tab) ;
	}
}