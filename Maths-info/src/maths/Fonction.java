package maths;

public class Fonction {
	private String name;
	
	public Fonction(){
		this.name="x²";
	}
	
	public String toString(){
		return this.name;
	}
	
	public double f(double x){
		return x*x;
	}
}
