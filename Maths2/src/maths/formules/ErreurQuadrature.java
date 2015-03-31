package maths.formules;
import maths.fonctions.*;
import maths.*;
import java.util.ArrayList;

public class ErreurQuadrature implements Formule{
	private String name;
	private CalculIntegrale approchee;
	private float integraleExacte;
	
	public ErreurQuadrature(){
		this.name="Erreur de Quadrature";
	}
	
	public Object[][] resoudre(int n, Fonction fonction){
		//le tableau resultat final est initialisé des le debut
		//il contient n sous tableaux qui auront deux élemens: {ni,|I-In|}
		Object[][] tabResulatFinal=new Object[n][2];
		
		//je fixe I, l'intégrale exacte
		FonctionDerivable fx=new Puissance(new Produit(new Constante(4.0),new Lineaire()),1/4);
		this.integraleExacte=(float) (fx.eval(1)-fx.eval(0));
		System.out.println(this.integraleExacte);
		//le tableau des valeurs approchees contient les integrales
		//[I1,I2,I3,...,In-1, In]
		Object[] tabApprochee=new Object[n];
		
		//il faut remplir ce tableau avec les integrales
		for(int i=0;i<tabApprochee.length;i++){
			//on calcule l'intégrale à i sous intervalle
			CalculIntegrale c=new CalculIntegrale(fonction);
			Object[][] tabObj=c.executerComposite(i+1);
			
			Object[] tabObj2=tabObj[tabObj.length-1];
			
			//System.out.println(c.getResultat());
			
			//pour la suite, je vais faire la différence |I-In|
			Float diff=(float) ( ((Float) tabObj2[4]).floatValue());
			//System.out.println(diff);
			diff=(integraleExacte)-diff;
			//System.out.println("diff "+Math.abs(diff));
			//et enregistrer dans tabResultat
			tabResulatFinal[i]=new Object[]{i+1,Math.abs(diff)};
		}		
		return tabResulatFinal;
	}
	
	public double[][] valeur(Fonction fonction,double a,double b,int n){
		double[][] tabResulatFinal=new double[n][2];
		
		FonctionDerivable fx=new Puissance(new Produit(new Constante(4.0),new Lineaire()),(float)0.25);
		this.integraleExacte=(float) (fx.eval(1)-fx.eval(0));
		
		for(int i=0;i<n;i++){
			CalculIntegrale c=new CalculIntegrale(fonction);
			//c.setComposite(new Trapeze());
			double integraleApprochee=c.valeurIntegraleComposite(i);
			//System.out.println(c.valeurIntegraleComposite(i));
			double differenceAbsolue=Math.abs(this.integraleExacte-integraleApprochee);
			
			tabResulatFinal[i]=new double[]{i,differenceAbsolue};
		}
		
		
		return tabResulatFinal;
	}
	public String toString(){
		return this.name;
	}

}