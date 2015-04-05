package maths.fonctions;

public interface Integrateur {
	/* interface representant un schema d’integration numerique */
	public double integre(Fonction f,double a,double b,int n) ;
}