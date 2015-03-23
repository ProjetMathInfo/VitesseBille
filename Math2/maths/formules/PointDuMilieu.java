package maths.formules;
import maths.fonctions.*;

import java.util.*;

public class PointDuMilieu implements Formule, Composite{
	private String name;
	
	public PointDuMilieu(){
		this.name="Point du Milieu";
	}

	public Object[][] resoudre(int n, Fonction fx){
		float res=(float) fx.eval(1.0/2.0);
		Object[] arrayTest = {0.0,1.0,fx.eval(0.0),fx.eval(1.0),res};
		
		Object[][] t={arrayTest};
		
		return t;
	}
	public Object[][] calculComposite(int n, Fonction fx){
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
	public String toString(){
		return this.name;
	}

}
