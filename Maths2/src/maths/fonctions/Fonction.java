package maths.fonctions;

public interface Fonction {
	public double eval(double x) ;
	
	/*public static double dichotomie(Fonction f,double a,double b,double epsilon) {
		if (f.eval(a)*f.eval(b)>0) 
			return Double.NaN ;
		while ((b-a)>epsilon) {
			double c=(a+b)/2 ;
			if (f.eval(a)*f.eval(c)<0)
				b=c ;
			else
				a=c ;
		}
		return (a+b)/2 ;
	}*/
}