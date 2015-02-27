package maths.formules;

import java.util.*;

import maths.Fonction;

public class Trapeze implements Composite{
	private String name;
	private ArrayList<ArrayList<Double>> tabValeur;
	
	public Trapeze(){
		this.name="Trapeze";
		this.tabValeur=new ArrayList<ArrayList<Double>>();
	}
	
	public void calculComposite(int n, Fonction fx){
		double i=0;
		double res=0;
		double ssint=n;
		while(i<=1){
			double i1=i+(1.0/ssint);
			double ssdiv=(i1-i)*(fx.f(i)+fx.f(i1));

			Double[] array = {i,i1,ssdiv};
			this.tabValeur.add(new ArrayList<Double>(Arrays.asList(array)));
			
			res+=ssdiv;

			i=i1;
		}
		Double[] array = {ssint,res,1.0};
		this.tabValeur.add(new ArrayList<Double>(Arrays.asList(array)));
		System.out.println("L'intégrale vaut "+res*.5);
	}
	public String toString(){
		return this.name;
	}
}
