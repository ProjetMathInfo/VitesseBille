package maths.formules;
import java.util.ArrayList;
import maths.fonctions.*;

import java.util.ArrayList;

public interface Formule {
	
	
	public abstract Object[][] resoudre(int n, Fonction f);

	public abstract double[][] valeur(Fonction f, double a, double b, int n);
	
	//public abstract void setResultatIntegrale();
	
}