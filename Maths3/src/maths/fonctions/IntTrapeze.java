package maths.fonctions;

public class IntTrapeze implements Integrateur {
	
	/* integrale par la methode des trapezes */
	public double integre(Fonction f,double a,double b,int n) {
		double resultat=0. ;
		for (int i=0;i<n;i++)
			resultat+=(b-a)/n*(f.eval(a+i*(b-a)/n)+f.eval(a+(i+1)*(b-a)/n))/2 ;
		return resultat ;
	}
}