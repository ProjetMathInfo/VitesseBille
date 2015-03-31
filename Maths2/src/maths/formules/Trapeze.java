package maths.formules;
import maths.fonctions.*;

import java.util.*;

import javax.swing.JMenu;
import javax.swing.JMenuItem;

public class Trapeze implements Composite{
	private String name;
	
	public Trapeze(){
		this.name="Trapeze";
	}
	
	public Object[][] calculComposite(int n, Fonction fx){
		float i=0;
		float res=0;
		int j=0;
		Object[][] tableau=new Object[n+1][];

		while(j<n){
			//calcul pour l'intégrale dans [i;i+1]
			float i1=(float) (i+(1.0/n));
			float ssdiv= (float) ((1.)/n*(fx.eval(i*(1.)/n)+fx.eval((i+1)*(1.)/n))/2);

			//on sauvegarde les valeurs pour chaque ssdiv dans l'array
			tableau[j]=new Object[]{i,i1,(float) fx.eval(i),(float) fx.eval(i1),ssdiv};

			//on addition ces valeurs
			res+=ssdiv;

			//i prend la valeur i1
			i++;
			j++;
		}
		tableau[n]=new Object[]{"-","-","-","-",res};
		return tableau;
	}
	public double valeurComposite(Fonction f,double a,double b,int n){
		double resultat=0. ;
		double base=(b-a)/n;
		double hauteur=0.;
		for (int i=0;i<n;i++){
			hauteur=f.eval(a+i*1./n)+f.eval(a+(i+1)*1./n);
			resultat+=hauteur*base*.5;
		}
		return resultat;
	}
	public String toString(){
		return this.name;
	}

}
