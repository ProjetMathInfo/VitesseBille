import java.util.ArrayList;

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

		    res=pointMilieu(a,b,n);

			System.out.println("L'integrale vaut: "+res);

	}
}
