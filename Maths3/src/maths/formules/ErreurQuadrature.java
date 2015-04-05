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
		Object[][] tabResulatFinal=new Object[n][2];
		double a=0.0,b=1.0;
		FonctionDerivable fx=new Puissance(new Lineaire(4.0),(float)0.25);
		//this.integraleExacte=(float) (fx.eval(1.0)-fx.eval(0));
		//System.out.println("integraleExacte : "+integraleExacte);
		for(int i=0;i<n;i++){
			CalculIntegrale c=new CalculIntegrale(fonction);
			double integraleApprochee=c.valeurIntegraleComposite(fonction,a,b,i);
			double differenceAbsolue=Math.abs(4-integraleApprochee);
			tabResulatFinal[i]=new Object[]{i,differenceAbsolue};
		}
		return tabResulatFinal;
	}
	
	public double[][] valeur(Fonction fonction,double a,double b,int n){
		double[][] tabResulatFinal=new double[n+1][2];
		
		//primitive
		FonctionDerivable fx=new Puissance(new Lineaire(4.0),(float)0.25);
		for(int i=1;i<=n;i++){
			//nouvelle intégrale approchée en fonction de N
			CalculIntegrale c=new CalculIntegrale(fonction);
			double integraleApprochee=c.valeurIntegraleComposite(fonction,a,b,i);
			
			//différence absolue entre la valeur exacte et l'approchée
			double differenceAbsolue=Math.abs(4-integraleApprochee);
			
			tabResulatFinal[i]=new double[]{i,differenceAbsolue};
		}
		return tabResulatFinal;
	}
	
	public String toString(){
		return this.name;
	}

}