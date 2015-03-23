package maths.formules;
import maths.fonctions.*;
import java.util.*;

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
			float ssdiv= (float) ((i1-i)*((fx.eval(i)+fx.eval(i1))*.5));

			//on sauvegarde les valeurs pour chaque ssdiv dans l'array
			tableau[j]=new Object[]{i,i1,(float) fx.eval(i),(float) fx.eval(i1),ssdiv};

			//on addition ces valeurs
			res+=ssdiv;

			//i prend la valeur i1
			i=i1;
			j++;
		}
		tableau[n]=new Object[]{"-","-","-","-",res*.5};
		return tableau;
	}
	public String toString(){
		return this.name;
	}
}
