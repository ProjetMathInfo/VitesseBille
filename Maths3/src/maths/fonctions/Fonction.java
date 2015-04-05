package maths.fonctions;

//Creation de l'interface Fonction pour manipuler des objets Fonction
public interface Fonction {
	
	// Chaque fonction dependra d'une valeur x 
	// Cette methode calculera le resulat en fonction de x grace a l'expression de la fonction 
	public double eval(double x) ;
}