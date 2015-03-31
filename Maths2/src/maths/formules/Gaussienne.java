package maths.formules;

import java.util.ArrayList;
import maths.fonctions.*;
import java.util.ArrayList;

public class Gaussienne /*implements Formule*/{
	private String name;
	
	public Gaussienne(){
		this.name="Gaussienne";
	}
	
	public Object[][] resoudre(int n, Fonction fonction){
		Object[][] tableau=new Object[n+1][];
		return tableau;
	}
	public String toString(){
		return this.name;
	}
}
