package maths.formules;
import maths.fonctions.*;

import java.util.ArrayList;


public interface Composite {
	
	//public abstract ArrayList<ArrayList<Double>> calculComposite(int n, Fonction f);
	
	public abstract Object[][] calculComposite(int n, Fonction f);

	public abstract double valeurComposite(Fonction fonction, double a,double b, int n);

}