
import java.awt.*;
import java.awt.geom.Area;
import java.util.ArrayList;

import javax.swing.*;
import maths.*;

 public class PanneauDessin extends JPanel {
 	private double nombrePas;
	private TracerFonction cadre;
	/*private JLabel gaduate;*/
	
	public PanneauDessin(TracerFonction cadre) {
		this.cadre = cadre;
		setBackground(Color.WHITE);
	}
	
	public void setNbPas(double n){
		this.nombrePas=n;
	}
	public double getNbPas(){
		return this.nombrePas;
	}
	
 	public void paintComponent(Graphics g) {
 		super.paintComponent(g);
 		Expression expr = cadre.getExpression();
 		if (expr != null){
 			// obtention des parametres du tracé
            double xMin = cadre.getXmin();
            double xMax = cadre.getXmax() ;
            double deltaX = cadre.deltaX();
            double yMin = cadre.getYmin();
            double yMax = cadre.getYmax();
            double deltaY = cadre.deltaY();
            setNbPas(cadre.getIntervalle());
                
            long p, pMax;

            // obtention des transformations affines pour x et y
            Dimension d = getSize();
            double Ax = d.width / (xMax - xMin);
            double Bx = -Ax * xMin;
            double Ay = -d.height / (yMax - yMin);
            double By = -Ay * yMax;
            
            // tracé des axes
            Color coulPrec = g.getColor();
            g.setColor(Color.ORANGE);
            if (yMin * yMax < 0) { /* pour abs*/
            	int yc = (int) By;
                g.drawLine(0, yc - 1, d.width, yc - 1);
                g.drawLine(0, yc, d.width, yc);
                g.drawLine(0, yc + 1, d.width, yc + 1);
            }
            if (xMin * xMax < 0) {  /*ordonne*/
            	int xc = (int) Bx;
            	g.drawLine(xc - 1, 0, xc - 1, d.height);
            	g.drawLine(xc, 0, xc, d.height);
            	g.drawLine(xc + 1, 0, xc + 1, d.height);
            }
                
            // tracé de la grille
            p = Math.round(Math.floor(xMin / deltaX)); // pas
            pMax = Math.round(Math.ceil(xMax / deltaX)); //totale pas
            for ( ; p <= pMax; p++) {
            	int xc = (int) (Ax * (p * deltaX) + Bx);
            	g.drawLine(xc, 0, xc, d.height);
            }
            p = Math.round(Math.floor(yMin / deltaY));
            pMax = Math.round(Math.ceil(yMax / deltaY));
            for ( ; p <= pMax; p++) {
            	int yc = (int) (Ay * (p * deltaY) + By);
                g.drawLine(0, yc, d.width, yc);
                String label=Integer.toString((int) p);
                g.drawString(label, 0,yc);
                System.out.println(p);
            }
            g.setColor(coulPrec);

            // tracé de la fonction -- à la base
            double dx = (xMax - xMin) / nombrePas;
            int xp = 0, yp = 0;
            for (double x = xMin; x <= xMax; x += dx) {
            	double y = expr.valeur(x);
            	int xc = (int) (Ax * x + Bx);
            	int yc = (int) (Ay * y + By);
            	if (xc != 0){
            		g.drawLine(xp, yp, xc, yc);
            		int a[]={xp,xp,xc,xc};
            		int b[]={(int)(By),yp,yc,(int)(By)};
            		Polygon p1=new Polygon(a,b,4);
            		g.drawPolygon(p1);
            	}
            	xp = xc;
            	yp = yc;
            }
            //trace fonction -- à la base fin
            //tracé de la fonction -- expérimentation
            /*double dx = (xMax - xMin) / this.getNbPas();
            int xp = 0, yp = 0;
            for (double x = xMin; x <= xMax; x += dx) {
            	double y = expr.valeur(x);
            	int xc = (int) (Ax * x + Bx);
            	int yc = (int) (Ay * y + By);
            	if (xc != 0){
            		g.drawLine(xp, yp, xc, yc);
            		int a[]={xp,xp,xc,xc};
            		int b[]={(int)(By),yp,yc,(int)(By)};
            		Polygon p1=new Polygon(a,b,4);
            		g.drawPolygon(p1);
            	}
            	//((TracerFonction) cadre.tab).getTab();
            	xp = xc;
            	yp = yc;
            }
            double dx = (1.0 - 0.0) / this.getNbPas();
            int xp = 0, yp = 0,i=0;
           for (double x = 0.0; x <= 1.0; x += dx) {
           // for(int i=0;i<cadre.tab.size();i++){
        	   
            	double y = expr.valeur(x);
            	//double x=(cadre.getTab().get(i).get(0)+cadre.getTab().get(i).get(1))/2.0;
            	//double y=cadre.tab.get(i).get(3);
            	int xc = (int) (Ax * x + Bx);
            	int yc = (int) (Ay * y + By);
            	double x1=cadre.getTab().get(i).get(0);
            	double x2=cadre.getTab().get(i).get(1);
            	double y1=cadre.getTab().get(i).get(2);
            	double y2=cadre.getTab().get(i).get(3);
            	//g.drawLine((int)x1, (int)y1, (int)x2, (int)y2);
            	//if (xc != 0){
            		//if(cadre.getTab().get(0)==null){
                    	//System.out.println("Tab détecté");
                    	g.drawLine(xp, yp, xc, yc);
            		
            		//}else{
            			/*int a[]={x1,xp,xc,xc};
            		int b[]={(int)(By),yp,yc,(int)(By)};
            		Polygon p2=new Polygon(a,b,4);
            		g.drawPolygon(p2);*/
                    	/*int a[]={(int)x1,(int)x1,(int)x2,(int)x2};
                    	int b[]={(int)(By),(int)y1,(int)y2,(int)(By)};
                		Polygon p2=new Polygon(a,b,4);
                		g.drawPolygon(p2);
            		//}*/
            	//}*/
            	//x1 = x2;
            	//y1=y2;	
            	/*xp=xc;
            	yp = yc;
            }
            //trace fonction -- expérimentation*/
       }    
            
            //System.out.println(cadre.getTab());
            //trace fonction -- expérimentation
           // if(cadre.getTab().get(0)!=null)
            //	System.out.println("Tab détecté");
 		}
 	}
 	/*public void paintComponent2(Graphics2D g,ArrayList<ArrayList<Double>> tab) {
 		super.paintComponent(g);

        double xMin = cadre.getXmin();
        double xMax = cadre.getXmax() ;
        double deltaX = cadre.deltaX();
        double yMin = cadre.getYmin();
        double yMax = cadre.getYmax();
        double deltaY = cadre.deltaY();
        setNbPas(cadre.getIntervalle());
        
        Dimension d = getSize();
        double Ax = d.width / (xMax - xMin);
        double Bx = -Ax * xMin;
        double Ay = -d.height / (yMax - yMin);
        double By = -Ay * yMax;

 		Graphics2D g2 = (Graphics2D)g;
 		/*Area areaOne = new Area(p1);
 		g2.setPaint(Color.magenta);
 		g2.fill(areaOne);
 		g2.setPaint(Color.green);
 		g2.draw(areaOne);*/
 		//tracé de la fonction -- expérimentation
        /*double dx = (1.0 - 0.0) / this.getNbPas();
        int xp = 0, yp = 0;
       //for (double x = 0.0; x <= 1.0; x += dx) {
        for(int i=0;i<tab.size()-1;i++){
        	//double y = expr.valeur(x);
        	double x=(tab.get(i).get(0)+tab.get(i).get(1))/2.0;
        	double y=tab.get(i).get(3);
        	int xc = (int) (Ax * x + Bx);
        	int yc = (int) (Ay * y + By);
        	if (xc != 0){
        		//if(cadre.getTab().get(0)==null){
                	//System.out.println("Tab détecté");
                	g2.drawLine(xp, yp, xc, yc);
        		
        		//}else{
        			int a[]={xp,xp,xc,xc};
        		int b[]={(int)(By),yp,yc,(int)(By)};
        		Polygon p2=new Polygon(a,b,4);
        		//g2.drawPolygon(p2);
        		//}
        	}
        	xp = xc;
        	yp = yc;
        }
        //trace fonction -- expérimentation
   }    
        */
       /* public void paintComponent2(Graphics2D g) {
        	 super.paintComponent(g);
        Polygon p1 = new Polygon();
        /*for (int i = 0; i < 5; i++)
          p1.addPoint((int) (100 + 50 * Math.cos(i * 2 * Math.PI / 5)),
              (int) (100 + 50 * Math.sin(i * 2 * Math.PI / 5)));


        Graphics2D g2 = (Graphics2D)g;
        Area areaOne = new Area(p1);
        g2.setPaint(Color.magenta);
        g2.fill(areaOne);
        g2.setPaint(Color.green);
        g2.draw(areaOne);
        }*/

   
    
   /* public Repere (int X0,int Y0,int XMAX,int YMAX,double unitex,double unitey)
    	 			{ this.X0 = X0; this.Y0 = Y0;
    				  this.XMAX = XMAX ; this.YMAX = YMAX ;
    				  this.unitex = unitex ; this.unitey = unitey ;
    				}
    	
    	/**
    	* Trace le repere.
    	*/
    	
  /*  public void trace (Graphics g)
    { int UX = X0 + new Double (unitex) . intValue () ;
      int UY = Y0 - new Double (unitey) . intValue () ;
      if ((Y0 >= 0) && (Y0 <= YMAX)) { g.drawLine (0, Y0, XMAX, Y0) ;
                                          if ((UX >= 0) && (UX <= XMAX))
                                                g.drawLine (UX, Y0 - 2, UX, Y0 + 2) ;
                                        } 
      if ((X0 >= 0) && (X0 <= XMAX)) { g.drawLine (X0, 0, X0, YMAX) ;
                                          if ((UY >= 0) && (UY <= YMAX))
                                                g.drawLine (X0 - 2, UY, X0 + 2, UY);
                                        }
      }*/
                    
          