package maths;

import maths.fonctions.*;
import maths.formules.*;

public class TestIntegralFirstTry {
	public static double F1(double x) {
		//On construit la fonction
		//x²
		double f1 = (x*x);
		return f1;
	}

	public static double F2(double x) {
		//On construit la fonction
		//X²exp(x)
		double f2 = Math.exp(x)*(x*x);
		return f2;
	}

	public static double pointMilieu(double a, double b, int n){
		//a,b bornes de l'interval
		//n nb de ss-division

		/*
		 * pb avec arraylist<double>
		 *ArrayList<double> values=new ArrayList<double>();
		 */

		double res=0;

		//formule du point de milieu
		//I(f)=(b-a)*f((a+b)/2)

		/*
		 *on stocke dans une ArrayList
		 *values.add(i0);
		 */

		//on augmente la précision avec n
		//on initialise i à a (le début de l'interval)
		double i=a;
		while(i<=b){
			//calcul pour l'intégrale dans [i;i+1]
			//double ssdiv=(i-i+1)*F1((i+i+1)/2);
			double ssdiv=(i-i+1)*F2((i+i+1)/2);

			/*
			 *on sauvegarde les valeurs pour chaque ssdiv dans l'array
			 *values.add(in);
			 */

			//on addition ces valeurs
			res+=ssdiv;

			//on incremente i avec les sous divisions
			i+=(b-a)/n;
		}
		/*
		 *on place le résultat à la fin de l'ArrayList
		 *values.add(res);
		 */

		return res;
	}
	public static double compositeTrapeze(double a, double b, int n){
		//a,b bornes de l'interval
		//n nb de ss-division

		double res=0;
		//formule du composite du trapeze
		 /*double trapezoid_integrate(const ContainerA &x, const ContainerB &y) {
			 if (x.size() != y.size()) {
			 throw std::logic_error("x and y must be the same size");
			 }
			 double sum = 0.0;
			 for (int i = 1; i < x.size(); i++) {
			 sum += (x[i] - x[i-1]) * (y[i] + y[i-1]);
			 }
			 return sum * 0.5;*/

		return res;
	}

	public static double erreurQuadrature(double a, double b, int n){
		//a,b bornes de l'interval
		//n nb de ss-division
		double res=0;

		//Erreur de quadrature

		return res;
	}

	public static void main(String args[] ) {
		    int n;
		    double a,b,res;

		    a=0.0;
		    b=1.0;
		    n=10;

		    /*
		     * f(x)=x²
		     */
		    FonctionDerivable f1=new Carree(new Lineaire()) ;
		   //System.out.println(f1.eval(2));
		    CalculIntegrale i1=new CalculIntegrale(f1);
		    System.out.println("\n\nTest du point du milieu de f(x)=(x)² \n"+i1.executer(10));
		    
		    i1.setComposite(new PointDuMilieu());
		    //System.out.println(i1.executerComposite(10));
		    
		    i1.setComposite(new Trapeze());
		    //System.out.println(i1.executerComposite(10));
		    
		    /*
		     * f(x)=x²exp(x)
		     */
		    FonctionDerivable f12=new E(new Lineaire());
		    FonctionDerivable f2=new Produit(f1, f12 ) ;
		   //System.out.println(f.eval(2));
		    CalculIntegrale i2=new CalculIntegrale(f2);
		    System.out.println("\n\nTest du point du milieu de f(x)=(x)²*exp(x)\n"+i2.executer(10));
		    
		    i2.setComposite(new PointDuMilieu());
		    //System.out.println(i2.executerComposite(10));
		    
		    i2.setComposite(new Trapeze());
		    //System.out.println(i2.executerComposite(10));
		    //Fonction f=new Cosinus();
		    
		    /*
		     * f(x)=x^(-3/4)
		     */
		    FonctionDerivable f31=new Lineaire();
		    FonctionDerivable f3=new Puissance(f31,(-3.0/4.0)) ;
		    CalculIntegrale i3=new CalculIntegrale(f3);
		    i3.setComposite(new PointDuMilieu());
		    System.out.println(i3.executerComposite(10));
		    //System.out.println("\n\nTest du point du milieu de f(x)=(x)^(-3/4)\n"+i3.executer(10));
		    
		    
		    /*
		     * Test produit de dérivée
		     */
		    FonctionDerivable c=new Cosinus() ;
			FonctionDerivable s=new Sinus() ;
			FonctionDerivable p=new Produit(c,s) ;
			//System.out.println("\n\nTest de dérivée\nla derivee de "+p+" est "+p.derive()) ;
	}
}