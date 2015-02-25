package maths.formules;

import maths.Fonction;

public class Trapeze implements Composite{
	private String name;
	
	public Trapeze(){
		this.name="Trapeze";
	}
	
	public void calculComposite(int n, Fonction fx){
		double i=0;
		double res=0;
		double ssint=n;
		double tab[][]={{}};
		int indice=0;
		while(i<=1){
			double i1=i+(1.0/ssint);
			double ssdiv=(i1-i)*(fx.f(i)+fx.f(i1));

			/*double tabi[]={i,i1,ssdiv};
			System.out.println(tabi[0]);
			int j=0;
			for(double x : tabi){
				tab[indice][j]=x;
				j++;
			}
			System.out.println("tab "+tab[indice][0]);*/
			
			res+=ssdiv;

			i=i1;
			indice++;
		}
		System.out.println("L'intégrale vaut "+res*.5);
		//System.out.println("On obtient le tableau "+tab);
	}
	public String toString(){
		return this.name;
	}
}
