package maths.fonctions;

public class FonctionDeIntegrale implements Fonction{
	
	private FonctionDerivable formeToboggan;

	// La fonction prend en parametre la forme du toboggan
	public FonctionDeIntegrale(FonctionDerivable f){
		this.formeToboggan = f;
	}
	
	// on renvoie la valeur de la fonction de l'integrale pour x
	public double eval(double x){
		return Math.sqrt(1+Math.pow(this.formeToboggan.derive().eval(x),2))/Math.sqrt(2*10*this.formeToboggan.eval(x));
	}
}