package maths.formules;

import maths.Fonction;

public class Gaussienne implements Formule{
	private String name;
	
	public Gaussienne(){
		this.name="Gaussienne";
	}
	
	public void resoudre(int n, Fonction fonction){
		System.out.println("Résolution avec la méthode Gaussienne");
	}
	public String toString(){
		return this.name;
	}
}
