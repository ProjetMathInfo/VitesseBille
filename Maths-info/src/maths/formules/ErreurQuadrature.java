package maths.formules;

import maths.Fonction;

public class ErreurQuadrature implements Formule{
	private String name;
	
	public ErreurQuadrature(){
		this.name="Erreur de Quadrature";
	}
	
	public void resoudre(int n, Fonction fonction){
		System.out.println("Résolution avec la méthode ErreurQuadrature");
	}
	public String toString(){
		return this.name;
	}

}
