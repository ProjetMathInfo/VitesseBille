package maths.formules;

import maths.Fonction;

public class PointDuMilieu implements Formule, Composite{
	private String name;
	
	public PointDuMilieu(){
		this.name="Point du Milieu";
	}
	
	public void resoudre(int n, Fonction fx){
		double res=fx.f(1.0/2.0);
		
		System.out.println("L'intégrale vaut "+res);
	}
	
	public void calculComposite(int n, Fonction fx){
		double i=0;
		double res=0;
		double ssint=n;
		double tab[][]={{}};
		int indice=0;
		while(i<=1){
			//calcul pour l'intégrale dans [i;i+1]
			double i1=i+(1.0/ssint);
			double ssdiv=(i1-i)*fx.f((i+i1)/2.0);

			//on sauvegarde les valeurs pour chaque ssdiv dans l'array
			/*double tabi[]={i,i1,ssdiv};
			System.out.println(tabi[0]);
			int j=0;
			for(double x : tabi){
				tab[indice][j]=x;
				j++;
			}
			System.out.println("tab "+tab[indice][0]);*/
			

			//on addition ces valeurs
			res+=ssdiv;

			//i prend la valeur i1
			i=i1;
			indice++;
		}
		System.out.println("L'intégrale vaut "+res);
		//System.out.println("On obtient le tableau "+tab);
	}
	public String toString(){
		return this.name;
	}

}
