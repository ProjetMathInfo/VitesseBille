package maths.formules;
import java.util.ArrayList;
import maths.fonctions.*;
import java.util.ArrayList;

public interface Formule {
	
	//public abstract ArrayList<ArrayList<Double>> resoudre(int n, Fonction f);
	
	public abstract Object[][] resoudre(int n, Fonction f);
	
}
