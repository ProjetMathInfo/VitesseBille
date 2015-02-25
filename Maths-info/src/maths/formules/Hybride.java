package maths.formules;

import maths.Fonction;

public class Hybride implements Formule{
	private String name;
	
	public Hybride(){
		this.name="Hybride";
	}
	
	public void resoudre(int n, Fonction fonction){
		System.out.println("Résolution avec la méthode Hybride");
	}
	public String toString(){
		return this.name;
	}
}
