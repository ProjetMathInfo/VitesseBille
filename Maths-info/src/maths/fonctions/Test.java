package maths.fonctions;

public class Test {
	
	public static double integraleTrapeze(Fonction f,double a,double b,int n) {
		double resultat=0. ;
		for (int i=0;i<n;i++)
		resultat+=(b-a)/n*(f.eval(a+i*(b-a)/n)+f.eval(a+(i+1)*(b-a)/n))/2 ;
		return resultat ;
	}
	
	public static double integraleRectangle(Fonction f,double a,double b,int n) {
		double resultat=0. ;
		for (int i=0;i<n;i++)
			resultat+=(b-a)/n*f.eval(a+i*(b-a)/n) ;
		return resultat ;
	}
	
	public static double dichotomie(Fonction f,double a,double b,double epsilon) {
		if (f.eval(a)*f.eval(b)>0) return Double.NaN ;
		while ((b-a)>epsilon) {
			double c=(a+b)/2 ;
			if (f.eval(a)*f.eval(c)<0)
				b=c ;
			else
				a=c ;
		}
		return (a+b)/2 ;
	}
	
	public static void main(String args[]) {
		
		FonctionDerivable f=new Cosinus() ;
		
		System.out.println(integraleTrapeze(f,0,Math.PI/2,100)) ;
		
		System.out.println(integraleRectangle(f,0,Math.PI/2,100)) ;
		
		Integrateur trapeze=new IntTrapeze() ;
		System.out.println(trapeze.integre(f
				,0,Math.PI/2,100)) ;
		
		System.out.println(dichotomie(f,0,Math.PI,0.001)) ;
		
		System.out.println(f.derive()) ;
		
		FonctionDerivable c=new Cosinus() ;
		FonctionDerivable s=new Sinus() ;
		FonctionDerivable p=new Produit(c,s) ;
		System.out.println("la derivee de "+p+" est "+p.derive()) ;


	}
}