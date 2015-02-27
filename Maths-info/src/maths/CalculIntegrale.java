package maths;

import maths.formules.*;

public class CalculIntegrale {
	private Formule formule;
	private Fonction fonction;
	private Composite composite;

	public CalculIntegrale(){
		this.fonction=new Fonction();
		this.formule=new PointDuMilieu();//par défaut, on résoud avec le PointDuMilieu
		this.composite=new PointDuMilieu();
	}
	public CalculIntegrale(Fonction fx){
		this.fonction=fx;
		this.formule=new PointDuMilieu();//par défaut, on résoud avec le PointDuMilieu
		this.composite=new PointDuMilieu();
	}
	public CalculIntegrale(Fonction fx, Formule f){
		this.fonction=fx;
		this.formule=f;//la formule sera choisie par le client
		//this.composite=new PointDuMilieu();
	}
	public CalculIntegrale(Fonction fx, Composite c){
		this.fonction=fx;
		//this.formule=f;//la formule sera choisie par le client
		this.composite=c;
	}
	
	public void executer(int n){
		System.out.println("\nJe résous la fonction f(x)="+this.getFonction()
				+" avec la formule "+this.getFormule());
		this.formule.resoudre(n,this.getFonction());
	}
	public void executerComposite(int n){
		System.out.println("\nJe résous la fonction f(x)="+this.getFonction()
				+" avec la composite "+this.getComposite());
		this.composite.calculComposite(n,this.getFonction());
	}
	
	public void setFonction(Fonction fx){
		this.fonction=fx;
	}
	public Fonction getFonction(){
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
