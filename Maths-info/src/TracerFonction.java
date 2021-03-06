
import java.awt.*;
import java.awt.Composite;
import java.awt.event.*;
import java.util.*;

import javax.swing.*;
import javax.swing.table.TableColumn;

import maths.*;
import maths.fonctions.Carree;
import maths.fonctions.E;
import maths.fonctions.FonctionDerivable;
import maths.fonctions.Lineaire;
import maths.fonctions.Produit;
import maths.formules.*;

public class TracerFonction extends JFrame {
	static final Font POLICE = new Font("Monospaced", Font.PLAIN, 12);
	static final String[] titresParametres = { "X min", "X max", "delta X",
	            "Y min", "Y max", "delta Y" , "Intervalle" };
	// valeurs par defaut
	static double[] valeurParametres = { -1.0, +1.0, 0.2, -1.0, +1.0, 0.2, 5.0 };
	private JTextField[] champsParametres;

	private JTextField texteFonction;
	private Expression expression;
	private JPanel panneauDessin;
	private JMenuBar jmd;
	    
	private JTabbedPane panelOnglet;
	JPanel onglet1 = new JPanel();
	JPanel onglet2 = new JPanel();
	
	 ArrayList<ArrayList<Double>> tab=new ArrayList<ArrayList<Double>>();

	    
	 private JTable table;
	   
	    
	/*-----------------------*/

	public TracerFonction(int w,int h) {
		super("Calcule et representaion graphique");
	        
	    JMenuBar jmd=new JMenuBar();
	    this.setJMenuBar(jmd);
	        
	    JMenu mformules=new JMenu("Formules");
	    jmd.add(mformules);
	        
	    JMenuItem ptDuMil=new JMenuItem("Point du milieu");
	    mformules.add(ptDuMil);
	    JMenuItem compositePM=new JMenuItem("Composite Point du Milieu");
	    mformules.add(compositePM);
	    JMenuItem trapeze=new JMenuItem("Composite Trapeze");
	    mformules.add(trapeze);
	    JMenuItem gaussienne=new JMenuItem("Gaussienne*");
	    mformules.add(gaussienne);
	    JMenuItem hybride=new JMenuItem("Hybride*");
	    mformules.add(hybride);
	    JMenuItem err=new JMenuItem("Erreur de Quadrature*");
	    mformules.add(err);
	    
	    
	    JMenu mfonctions=new JMenu("Fonctions");
	    jmd.add(mfonctions);
	    
	    JMenuItem carree=new JMenuItem("(x)^²");
	    mfonctions.add(carree);
	    JMenuItem carreeExp=new JMenuItem("(x)^²*exp(x)");
	    mfonctions.add(carreeExp);
	    JMenuItem x34=new JMenuItem("(x)^(-3/4)*");
	    mfonctions.add(x34);
	        
	    ptDuMil.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent evt) {
	    		System.out.println("Point du milieu");
				CalculIntegrale c=new CalculIntegrale();
				c.setFormule(new PointDuMilieu());
				ArrayList<ArrayList<Double>> t=new ArrayList<ArrayList<Double>>();
				t=c.executer((int)TracerFonction.getIntervalle());
				setTab(t);
				System.out.println(t);
				texteFonction.setText(c.getFonction()+"");
				//c.setFonction(texteFonction.getText());GROS PB pour analyser et convertir en Fonction
	    		//preparerLeTracer2(c.getFonction()+"");
	    	}
	    });
	    
	    compositePM.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent evt) {
	    		System.out.println("Composite Point du milieu");
				CalculIntegrale c=new CalculIntegrale();
				c.setComposite(new PointDuMilieu());
				ArrayList<ArrayList<Double>> t=new ArrayList<ArrayList<Double>>();
				t=c.executer((int)TracerFonction.getIntervalle());
				tab=t;
				
				texteFonction.setText(c.getFonction()+"");
				//c.setFonction(texteFonction.getText());GROS PB pour analyser et convertir en Fonction
	    		//preparerLeTracer2(c.getFonction()+"");
	    	}
	    });
	    
	    trapeze.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent evt) {
	    		System.out.println("Composite Point du milieu");
				CalculIntegrale c=new CalculIntegrale();
				c.setComposite(new Trapeze());
				ArrayList<ArrayList<Double>> t=new ArrayList<ArrayList<Double>>();
				t=c.executer((int)TracerFonction.getIntervalle());
				tab=t;
			    System.out.println(tab);	
				texteFonction.setText(c.getFonction()+"");
				//c.setFonction(texteFonction.getText());GROS PB pour analyser et convertir en Fonction
	    		//preparerLeTracer2(c.getFonction()+"");
	    	}
	    });
	    
	    gaussienne.addActionListener(new ChoixFormuleListener());
	    
	    hybride.addActionListener(new ChoixFormuleListener());
	    
	    err.addActionListener(new ChoixFormuleListener());
	    
	    /*
	     * listener fonction
	     */
	    carree.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent evt) {
				CalculIntegrale c=new CalculIntegrale();
				c.setFonction(new Carree(new Lineaire()));
				ArrayList<ArrayList<Double>> t=new ArrayList<ArrayList<Double>>();
				t=c.executer((int)TracerFonction.getIntervalle());
				setTab(t);
				System.out.println(t);
				texteFonction.setText(c.getFonction()+"");
				//c.setFonction(texteFonction.getText());GROS PB pour analyser et convertir en Fonction
	    		//preparerLeTracer2(c.getFonction()+"");
	    	}
	    });
	    carreeExp.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent evt) {
				FonctionDerivable f12=new E(new Lineaire());
			    FonctionDerivable f2=new Produit(new Carree(new Lineaire()), f12 ) ;
				CalculIntegrale c=new CalculIntegrale();
				c.setFonction(f2);
				ArrayList<ArrayList<Double>> t=new ArrayList<ArrayList<Double>>();
				t=c.executer((int)TracerFonction.getIntervalle());
				setTab(t);
				System.out.println(t);
				texteFonction.setText(c.getFonction()+"");
				//c.setFonction(texteFonction.getText());GROS PB pour analyser et convertir en Fonction
	    		//preparerLeTracer2(c.getFonction()+"");
	    	}
	    });
	    champsParametres = new JTextField[titresParametres.length];
	    for (int i = 0; i < titresParametres.length; i++)
	    	champsParametres[i] = new JTextField(5);
	    texteFonction = new JTextField();
	    texteFonction.setFont(POLICE);
	    panneauDessin = new PanneauDessin(this);

	    JPanel panA = new JPanel(new GridLayout(0, 2, 5, 5));
	    for (int i = 0; i < titresParametres.length; i++) {
	    	champsParametres[i] = new JTextField(8);
	    	champsParametres[i].setHorizontalAlignment(JTextField.RIGHT);
	    	champsParametres[i].setFont(POLICE);
	    	champsParametres[i].setText(valeurParametres[i] + "");
	      	panA.add(new JLabel(titresParametres[i]));
	      	panA.add(champsParametres[i]);
	   	}
	    panA.setBorder(BorderFactory.createCompoundBorder(
	    		BorderFactory.createTitledBorder(
	    				BorderFactory.createEtchedBorder(), "Paramtres"), 
	    			BorderFactory.createEmptyBorder(5, 5, 5, 5)));
	        
	    JButton boutonTracer = new JButton("Tracer");
	    JPanel panB = new JPanel(new FlowLayout());
	    panB.add(boutonTracer);

	    JPanel panneauDeGauche = new JPanel(new BorderLayout());
	    panneauDeGauche.add(panA, BorderLayout.NORTH);
	    panneauDeGauche.add(panB, BorderLayout.CENTER);
	    panneauDeGauche.setBorder(BorderFactory.createEmptyBorder(0, 0, 10, 10));

	    JPanel panneauDuBas = new JPanel(new GridLayout(0, 1));
	    panneauDuBas.add(new JLabel("Expression a tracer: f(x) ="));
	    panneauDuBas.add(texteFonction);
	    panneauDuBas.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
	    
	   	
	    String  title[] = {"a", "b", "f(a)","f(b)","Resultat"};
	   /* CalculIntegrale c=new CalculIntegrale(new Carree(new Lineaire()));
	    ArrayList<ArrayList<Double>> t=c.executer(10);
	    System.out.println(t);*/
	    
	  Object[][] fake={{1.0},{2.2},{3.5},{2.5},{3.5},{1.0},{2.2},{3.5},{2.5},{3.5}};// ne marche pas
	  // Object[][] fake={{}}; ne marche pas
	   //Double[][] data=tab.toArray(new Double[tab.size()][tab.size()]);  celui ci marche tab vide??
	    //table = new JTable(data,title);
	 
	    table = new JTable(fake,title);
	    panelOnglet = new JTabbedPane(SwingConstants.TOP);
	    panelOnglet.addTab("Panel1", null,panneauDessin);
	    panelOnglet.addTab("Panel2", null,this.getContentPane().add(new JScrollPane(table)));
	    
	    pack();
	
	   /* JScrollPane scrollPane = new JScrollPane();
		getContentPane().add(new JScrollPane(table));*/
	       
	    JPanel panneauDeContenu = new JPanel(new BorderLayout());
	    panneauDeContenu.add(panneauDeGauche, BorderLayout.WEST);
	    panneauDeContenu.add(panneauDuBas, BorderLayout.SOUTH);
	    panneauDeContenu.add(panelOnglet,BorderLayout.CENTER);
	   // panneauDeContenu.add(table,BorderLayout.CENTER);
	    /*panneauDeContenu.add(panneauDessin, BorderLayout.CENTER);*/
	    panneauDeContenu.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
	   
	    setContentPane(panneauDeContenu);
	    setDefaultCloseOperation(EXIT_ON_CLOSE);
	    this.setSize(w, h);
	    pack();
	    setVisible(true);
	           
	    //Event
	    boutonTracer.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent evt) {
	    		preparerLeTracer();}
	    });    
	}
	 
	public Expression getExpression() {
		return expression;
	}
	
	public double getXmin() {
		return valeurParametres[0];
	}	
	public double getXmax() {
		return valeurParametres[1];
	}
	public double deltaX() {
		return valeurParametres[2];
	}	
	public double getYmin() {
		return valeurParametres[3];
	}
	public double getYmax() {
		return valeurParametres[4];
	}
	public double deltaY() {
		return valeurParametres[5];
	}
	public static double getIntervalle(){
		return valeurParametres[6];
	}
	public ArrayList<ArrayList<Double>> getTab(){
		return this.tab;
	}
	public void setTab(ArrayList<ArrayList<Double>> t){
		this.tab=t;
	}
	    

    public void preparerLeTracer() {

        // on recupere la fonction et on l'analyse
        try {
            String s = texteFonction.getText();
            Analyseur analyseur = new Analyseur(s);
            expression = analyseur.analyser();
        } catch (Exception exc) {
            JOptionPane.showMessageDialog(this, 
                exc.getMessage(), "Erreur dans la fonction",
                JOptionPane.ERROR_MESSAGE);
        }

        // on recupere les parametres et on les analyse aussi
        for (int i = 0; i <champsParametres.length ; i++)
            try {
                String s = champsParametres[i].getText();
                valeurParametres[i] = Double.parseDouble(s);
            } catch (Exception exc) {
                JOptionPane.showMessageDialog(this, 
                    exc.getMessage(), "Erreur dans " + titresParametres[i],
                    JOptionPane.ERROR_MESSAGE);
            }
        panneauDessin.repaint();
  
    }
    public void preparerLeTracer2(String ch){
        try{
            Analyseur analyseur = new Analyseur(ch);
            expression = analyseur.analyser();
        }catch (Exception exc) {
            JOptionPane.showMessageDialog(this, 
                exc.getMessage(), "Erreur dans la fonction",
                JOptionPane.ERROR_MESSAGE);
        }

        for (int i = 0; i <champsParametres.length ; i++)
            try{
                String s = champsParametres[i].getText();
                valeurParametres[i] = Double.parseDouble(s);
            }catch (Exception exc){
                JOptionPane.showMessageDialog(this, 
                    exc.getMessage(), "Erreur dans " + titresParametres[i],
                    JOptionPane.ERROR_MESSAGE);
            }
        panneauDessin.repaint();
  
    }
	        


	public static void main(String[] args) {
	        JFrame.setDefaultLookAndFeelDecorated(true);
	     
	        new TracerFonction(800,600);
	    }

}

/************************
 *  EVENT MENU 
 ***********************
 */

class ChoixFormuleListener implements ActionListener{

	public void actionPerformed(ActionEvent e) {
		String s=e.getActionCommand();
		
		if(s.equals("Point du milieuyolo")){
			System.out.println("Point du milieu");
			CalculIntegrale c=new CalculIntegrale();
			c.setFormule(new PointDuMilieu());
			//c.executer((int)this.getIntervalle());
			
		}else if(s.equals("Composite Point du Milieu")){
			System.out.println("Composite Point du Milieu");
			CalculIntegrale c=new CalculIntegrale();
			c.setComposite(new PointDuMilieu());
		}else if(s.equals("Composite Trapeze")){
			System.out.println("Composite Trapeze");
			CalculIntegrale c=new CalculIntegrale();
			c.setComposite(new Trapeze());
		}else if(s.equals("Gaussienne*")){
			System.out.println("Gaussienne");
			CalculIntegrale c=new CalculIntegrale();
			c.setFormule(new Gaussienne());
		}else if(s.equals("Hybride*")){
			System.out.println("Hybride");
			CalculIntegrale c=new CalculIntegrale();
			c.setFormule(new Hybride());
		}else if(s.equals("Erreur de Quadrature*")){
			System.out.println("Erreur de Quadrature");
			CalculIntegrale c=new CalculIntegrale();
			c.setFormule(new ErreurQuadrature());
		}	
	}
}