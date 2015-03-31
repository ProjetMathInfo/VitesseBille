package maths;

import maths.fonctions.*;
import maths.formules.*;
import com.*;
import com.panayotis.gnuplot.JavaPlot;
import com.panayotis.gnuplot.plot.DataSetPlot;
import com.panayotis.gnuplot.utils.Debug;
import com.panayotis.*;

public class TestIntegralFirstTry {
	public static void main(String args[] ) {
		/*
	     * f(x)=x²
	     */
	    FonctionDerivable f1=new Carree(new Lineaire()) ;
	    //System.out.println(f1.eval(2));
	    CalculIntegrale i1=new CalculIntegrale(f1);
	    //System.out.println("\nTest du point du milieu de f(x)=(x)² \n"+i1.executer(10)[0][0]);
	    
	    i1.setComposite(new PointDuMilieu());
	    System.out.println(i1.valeurIntegraleComposite(10));
	    
	    i1.setComposite(new Trapeze());
	    //System.out.println("f(x)=(x)² :"+i1.executerComposite(10)[10][4]);
	    Integrateur i1bis=new IntTrapeze();
	    System.out.println("Trapèze x*x:"+i1bis.integre(f1, 0.0, 1.0, 10));
	    Integrateur i1bisR=new IntRectangle();
	    System.out.println("Rectangle x*x:"+i1bisR.integre(f1, 0.0, 1.0, 10));
	    
	    /*
	     * f(x)=x²exp(x)
	     */
	    FonctionDerivable f12=new E(new Lineaire());
	    FonctionDerivable f2=new Produit(f1, f12 ) ;
	    //System.out.println(f.eval(2));
	    CalculIntegrale i2BIS=new CalculIntegrale(f2);

	    System.out.println(i2BIS.valeurIntegraleComposite(10));
	    //System.out.println("\nTest du point du milieu de f(x)=(x)²exp(x) \n"+i2.executer(10)[0][0]);
	   // System.out.println(i2.executerComposite(10)[10][4]);
	    Integrateur i2bis=new IntTrapeze();
	    System.out.println("Trapèze x*x*exp():"+i2bis.integre(f2, 0.0, 1.0, 10));
	    Integrateur i2bisR=new IntRectangle();
	    System.out.println("Rectangle x*x*exp():"+i2bisR.integre(f2, 0.0, 1.0, 10));
	    
	    
	    
	    i2BIS.setComposite(new Trapeze());
	    //System.out.println("f(x)=(x)²exp(x) :"+i2BIS.executerComposite(10)[10][4]);
	    
	    /*
	     * f(x)=x^(-3/4)
	     */
	    FonctionDerivable f3=new Lineaire() ;
	    CalculIntegrale i3=new CalculIntegrale(f3);
	    //System.out.println(i3.executerComposite(10)[10][4]);
	    i3.setComposite(new Trapeze());
	    i3.setFormule(new ErreurQuadrature());
	    double[][] res=i3.valeurIntegrale(10);
	    //System.out.println(i2.executerComposite(10)[9][4]);

	    Integrateur i3bis=new IntTrapeze();
	    //System.out.println("Autre :"+i3bis.integre(f3, 0.0, 1.0, 10));
	    //i3.setFormule(new ErreurQuadrature(f3));
	    //Object[][] res=i3.executer(10);
	    //System.out.println(sst[0]+" et "+sst[1]);
	    //System.out.println("f(x)=(x)^(-3/4)\n"+res[res.length-1][0]);
	    
	    
	    
	    

	    FonctionDerivable f=new Lineaire() ;
	    
	    CalculIntegrale i=new CalculIntegrale(f1);
	    i.setFormule(new ErreurQuadrature());
	    double[][] resultat=i3.valeurIntegrale(100);
	    JavaPlot p = new JavaPlot();
	    DataSetPlot s = new DataSetPlot(resultat);
        p.addPlot(s);
        //p.plot();
	}
	
	
	
	
	
}