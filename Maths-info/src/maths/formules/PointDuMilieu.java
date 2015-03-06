package maths.formules;
import maths.fonctions.*;
import java.util.ArrayList;
import java.util.*;

public class PointDuMilieu implements Formule, Composite{
	private String name;
	private ArrayList<ArrayList<Double>> tabValeur;
	
	public PointDuMilieu(){
		this.name="Point du Milieu";
		this.tabValeur=new ArrayList<ArrayList<Double>>();
	}
	
	public ArrayList<ArrayList<Double>> resoudre(int n, Fonction fx){
		double res=fx.eval(1.0/2.0);
		Double[] array = {0.0,1.0,fx.eval(0.0),fx.eval(1.0),res};
		this.tabValeur.add(new ArrayList<Double>(Arrays.asList(array)));
		
		return this.tabValeur;
	}
	
	public ArrayList<ArrayList<Double>> calculComposite(int n, Fonction fx){
		double i=0;
		double res=0;
		double ssint=n;
		//int indice=0;
		while(i<=1){
			//calcul pour l'intégrale dans [i;i+1]
			double i1=i+(1.0/ssint);
			double ssdiv=(i1-i)*fx.eval((i+i1)/2.0);

			//on sauvegarde les valeurs pour chaque ssdiv dans l'array
			Double[] array = {i,i1,fx.eval(i),fx.eval(i1),ssdiv};
			this.tabValeur.add(new ArrayList<Double>(Arrays.asList(array)));
			//System.out.println(this.tabValeur.get(indice));

			//on addition ces valeurs
			res+=ssdiv;

			//i prend la valeur i1
			i=i1;
			//indice++;
		}
		//System.out.println("L'intégrale vaut "+res);
		Double[] array = {ssint,res,1.0};
		this.tabValeur.add(new ArrayList<Double>(Arrays.asList(array)));
		return this.tabValeur;
	}
	public String toString(){
		return this.name;
	}

}
