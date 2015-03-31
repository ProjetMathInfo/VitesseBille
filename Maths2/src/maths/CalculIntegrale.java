package maths;
import maths.fonctions.*;
import maths.formules.*;

public class CalculIntegrale {
	private Formule formule;
	private Fonction fonction;
	private Composite composite;
	private float valeur;

	public CalculIntegrale(){
		this.fonction=new Lineaire();
		this.formule=new PointDuMilieu();
		this.composite=new PointDuMilieu();
		this.valeur=0;
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
		Object[][] tab=this.formule.resoudre(n,this.fonction);
		return tab;
	}

	public Object[][] executerComposite(int n){
		return this.composite.calculComposite(n,this.getFonction());
	}
	
	public double valeurIntegraleComposite(int n){
		return this.composite.valeurComposite(this.fonction, 0.0, 1.0, n);
	}

	public double[][] valeurIntegrale(int n){
		return this.formule.valeur(this.getFonction(),0.0,1.0,n);
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
	
	public float getResultat(){
		return this.valeur;
	}
	public void setResultat(float o){
		this.valeur=o;
	}

}