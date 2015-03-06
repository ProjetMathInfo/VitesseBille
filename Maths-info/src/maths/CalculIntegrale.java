package maths;
import maths.fonctions.*;

import java.util.ArrayList;

import maths.formules.*;

public class CalculIntegrale {
	private Formule formule;
	private FonctionDerivable fonction;
	private Composite composite;

	public CalculIntegrale(){
		//this.fonction=new Fonction();
		this.formule=new PointDuMilieu();//par défaut, on résoud avec le PointDuMilieu
		this.composite=new PointDuMilieu();
	}
	public CalculIntegrale(FonctionDerivable fx){
		this.fonction=fx;
		this.formule=new PointDuMilieu();//par défaut, on résoud avec le PointDuMilieu
		this.composite=new PointDuMilieu();
	}
	public CalculIntegrale(FonctionDerivable fx, Formule f){
		this.fonction=fx;
		this.formule=f;//la formule sera choisie par le client
		//this.composite=new PointDuMilieu();
	}
	public CalculIntegrale(FonctionDerivable fx, Composite c){
		this.fonction=fx;
		//this.formule=f;//la formule sera choisie par le client
		this.composite=c;
	}
	
	public ArrayList<ArrayList<Double>> executer(int n){
		System.out.println("\nCalcul : la fonction f(x)="+this.getFonction()
			+" avec la formule "+this.getFormule());
		return this.formule.resoudre(n,this.getFonction());
	}
	public ArrayList<ArrayList<Double>> executerComposite(int n){
		System.out.println("\nCalcul la fonction f(x)="+this.getFonction()
				+" avec la composite "+this.getComposite());
		return this.composite.calculComposite(n,this.getFonction());
	}
	
	public void setFonction(FonctionDerivable fx){
		this.fonction=fx;
	}
	public FonctionDerivable getFonction(){
		return this.fonction;
	}
	
	public void setFormule(Formule f){
		this.formule=f;
	}
	public Formule getFormule(){
		return this.formule;
	}

	public void setComposite(Composite c){
		this.composite=c;
	}
	public Composite getComposite(){
		return this.composite;
	}

}