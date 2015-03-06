package maths.fonctions;

public class IntRectangle implements Integrateur {

	public double integre(Fonction f,double a,double b,int n) {
		double resultat=0. ;
		for (int i=0;i<n;i++)
			resultat+=(b-a)/n*f.eval(a+i*(b-a)/n) ;
		return resultat ;
	}
}