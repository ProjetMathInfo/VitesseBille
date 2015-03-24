package maths.formules;
import maths.fonctions.*;
import java.util.ArrayList;

public class ErreurQuadrature implements Formule{
	private String name;
	
	public ErreurQuadrature(){
		this.name="Erreur de Quadrature";
	}
	
	public Object[][] resoudre(int n, Fonction fonction){
		double res=1.0/24.0/*dérivée seconde de f sur ]0,1[*/;
		Object[][] tableau=new Object[n+1][];
		return tableau;
	}
	public String toString(){
		return this.name;
	}

}
