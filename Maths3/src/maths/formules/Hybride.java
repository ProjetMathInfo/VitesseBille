package maths.formules;
import maths.fonctions.*;
import java.util.ArrayList;


public class Hybride/* implements Formule*/{
	private String name;
	
	public Hybride(){
		this.name="Hybride";
	}
	
	public Object[][] resoudre(int n, Fonction fonction){
		Object[][] tableau=new Object[n+1][];
		return tableau;
	}
	public String toString(){
		return this.name;
	}
}
