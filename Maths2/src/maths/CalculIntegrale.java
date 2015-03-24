package maths;
import maths.fonctions.*;

import java.util.ArrayList;

import maths.formules.*;

public class CalculIntegrale {
	private Formule formule;
	private Fonction fonction;
	private Composite composite;

	public CalculIntegrale(){
		//par défaut, on résoud avec le PointDuMilieu la fonction lineaire
		this.fonction=new Lineaire();
		this.formule=new PointDuMilieu();
		this.composite=new PointDuMilieu();
	}
	public CalculIntegrale(Fonction fx){
		this.fonction=fx;
		this.formule=new PointDuMilieu();
		this.composite=new PointDuMilieu();
	}
	public CalculIntegrale(Fonction fx, Formule f){
		this.fonction=fx;
		this.formule=f;
		this.composite=new PointDuMilieu();
	}
	public CalculIntegrale(Fonction fx, Composite c){
		this.fonction=fx;
		this.formule=new PointDuMilieu();
		this.composite=c;
	}
	
	public Object[][] executer(int n){
		return this.formule.resoudre(n,this.getFonction());
	}

	public Object[][] executerComposite(int n){
		return this.composite.calculComposite(n,this.getFonction());
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
