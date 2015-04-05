package maths.formules;
import maths.fonctions.*;
import maths.*;
import java.util.*;

public class PointDuMilieu implements Formule, Composite{
	private String name;
	private float resultat;
	
	public PointDuMilieu(){
		this.name="Point du Milieu";
		this.resultat=0;
	}

	public Object[][] resoudre(int n, Fonction fx){
		float res=(float) fx.eval(1.0/2.0);
		Object[] arrayTest = {0.0,1.0,fx.eval(0.0),fx.eval(1.0),res};
		
		Object[][] t={{res}};
		
		return t;
	}
	public Object[][] calculComposite2(int n, Fonction fx){
		float i=0;
		float res=0;
		int j=0;
		Object[][] tableau=new Object[n+1][];

		while(j<n){
			//calcul pour l'intégrale dans [i;i+1]
			float i1=(float) (i+(1.0/n));		
			float ssdiv= (i1-i)*(float)fx.eval((i+i1)/2.0);

			//on sauvegarde les valeurs pour chaque ssdiv dans l'array
			tableau[j]=new Object[]{i,i1,(float) fx.eval(i),(float) fx.eval(i1),ssdiv};

			//on addition ces valeurs
			res+=ssdiv;

			//i prend la valeur i1
			i=i1;
			j++;
		}
		tableau[n]=new Object[]{"-","-","-","-",res};
		return tableau;
	}
	public Object[][] calculComposite(int n, Fonction fx){
		Object[][] tableau=new Object[n+1][];
		for(int i=0;i<n+1;i++){
			CalculIntegrale c=new CalculIntegrale(fx);
			tableau[i]=new Object[]{i,c.valeurIntegraleComposite(fx,0.0,1.0,i)};
		}
		/*
		float i=0;
		float res=0;
		int j=0;
		while(j<n){
			//calcul pour l'integrale dans [i;i+1]
			float i1=(float) (i+(1.0/n));		
			float ssdiv= (i1-i)*(float)fx.eval((i+i1)/2.0);

			//on sauvegarde les valeurs pour chaque ssdiv dans l'array
			tableau[j]=new Object[]{i,i1,(float) fx.eval(i),(float) fx.eval(i1),ssdiv};

			//on addition ces valeurs
			res+=ssdiv;

			//i prend la valeur i1
			i=i1;
			j++;
		}
		tableau[n]=new Object[]{"-","-","-","-",res};*/
		return tableau;
	}

	public double valeurComposite(Fonction f, double a, double b, int n){
		double resultat=0.;
		double h=(b-a)/n;
		for(int i=0;i<n;i++){
			//somme
			resultat+=f.eval(a+(i+0.5)*h);
		}
		return resultat*h;
	}
	
	public String toString(){
		return this.name;
	}

	public double[][] valeur(Fonction f, double a, double b, int n) {
		double[][] t=new double[1][2];
		t[0]=new double[]{n,(b-a)*f.eval((a+b)/2.0)};
		return t;
	}

}