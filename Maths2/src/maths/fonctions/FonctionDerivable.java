package maths.fonctions;
import maths.*;

public interface FonctionDerivable extends Fonction {
	
	// Chaque fonction derivable doit renvoyer sa derivee
	public FonctionDerivable derive() ;
}