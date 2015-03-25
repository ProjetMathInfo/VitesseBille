import java.awt.*;
import java.awt.Composite;
import java.awt.event.*;
import java.util.*;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import javax.swing.text.JTextComponent;

import com.panayotis.gnuplot.JavaPlot;

import maths.*;
import maths.fonctions.*;
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

	 private DefaultTableModel tabModel;
	 private JTable table;
	  private JPanel pNordCentre=new JPanel();
	
	
	  JLabel form=new JLabel("");
	  private Object[][] tab2={{}};
	  private ImageIcon tiger=new ImageIcon("C:/Users/hajar/Documents/B.png");
	  
	  
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
	    JMenuItem err=new JMenuItem("Erreur de Quadrature*");
	    mformules.add(err);
	    JMenuItem gaussienne=new JMenuItem("Gaussienne*");
	    mformules.add(gaussienne);
	    JMenuItem hybride=new JMenuItem("Hybride*");
	    mformules.add(hybride);
	    
	    
	    JMenu mfonctions=new JMenu("Fonctions");
	    jmd.add(mfonctions);
	    
	    JMenuItem carree=new JMenuItem("(x)^(x)");
	    mfonctions.add(carree);
	    JMenuItem carreeExp=new JMenuItem("(x).exp(x)");
	    mfonctions.add(carreeExp);
	    JMenuItem x34=new JMenuItem("(x)^(-3/4)");
	    mfonctions.add(x34);
	    
	    
	    pNordCentre.add(form);
	    
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
	    pNordCentre.setBorder(BorderFactory.createCompoundBorder(
	    		BorderFactory.createTitledBorder(
	    				BorderFactory.createEtchedBorder(), "Formule"), 
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
	    
	   	
	   
		
	   panelOnglet = new JTabbedPane(SwingConstants.TOP);
	  
	 
	   //panelOnglet.addTab("Panel1", null,panneauDessin);
	   /* JScrollPane scrollPane = new JScrollPane();
		getContentPane().add(new JScrollPane(table));*/
	    JPanel panneauDeContenu = new JPanel(new BorderLayout());
	    panneauDeContenu.add(panneauDeGauche, BorderLayout.WEST);
	    panneauDeContenu.add(panneauDuBas, BorderLayout.SOUTH);
	   
	    panneauDeContenu.add(pNordCentre, BorderLayout.NORTH);
	   // panneauDeContenu.add(panelOnglet);
	 
	   // panneauDeContenu.add(table,BorderLayout.CENTER);
	    /*panneauDeContenu.add(panneauDessin, BorderLayout.CENTER);*/
	    panneauDeContenu.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
	   
	    setContentPane(panneauDeContenu);
	    setDefaultCloseOperation(EXIT_ON_CLOSE);
	    this.setSize(w, h);
	    pack();
	    setVisible(true);
	           
	  
		      String  title[] = {"a", "b", "f(a)","f(b)","Resultat"};
		     
		   /* table=new JTable(new DefaultTableModel(tab2,title));//celui ci c pour avoir une base
		   panneauDeContenu.add(table,BorderLayout.CENTER);
			panneauDeContenu.add(new JScrollPane(table));*/
		     
			
	    /************************
	     *  EVENT MENU FORMULE
	     ***********************
	     */
			// panelOnglet.addTab("Panel2", null,this.getContentPane().add(new JScrollPane(table)));
		      
		panelOnglet.addMouseListener( new MouseAdapter(){
		
			public void mouseClicked(MouseEvent e)
			{
				int selectedIndex = panelOnglet.getSelectedIndex();
				panelOnglet.remove(selectedIndex);
				System.gc();
			}
		});
	        
	    ptDuMil.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent evt) {
				//panneauDeContenu.remove(table);
				// panneauDeContenu.repaint();
	    		System.out.println("Point du milieu");
	    		form.setText("Point du milieu");
	    	
				//c.setFormule(new PointDuMilieu());
			
	    		CalculIntegrale c=new CalculIntegrale(new Carree(new Lineaire()));
	    		tab2=c.executer(10);
	 		   
				System.out.println(tab2);
				
				table=new JTable(new DefaultTableModel(tab2, title));
				
				panelOnglet.addTab("PointMil",tiger,new JScrollPane(table)); 
				panneauDeContenu.add(panelOnglet,BorderLayout.CENTER);
				
				texteFonction.setText(c.getFonction()+"");	
				
				
				
				//Object[][] t=c.executer((int)TracerFonction.getIntervalle());
				//setTab(t)
				//c.setFonction(texteFonction.getText());GROS PB pour analyser et convertir en Fonction
	    		//preparerLeTracer2(c.getFonction()+"");
	    	}
	    });
	    
	    compositePM.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent evt) {
				
				 //panneauDeContenu.repaint();
	    		System.out.println("Composite Point du milieu");
	    		form.setText("Composite Point du milieu");
				CalculIntegrale c=new CalculIntegrale();
				tab2=c.executerComposite(10);
				panneauDeContenu.remove(table);
				table=new JTable(new DefaultTableModel(tab2, title));
				 panelOnglet.addTab("FComposite", tiger,new JScrollPane(table)); 
				 panneauDeContenu.add(panelOnglet,BorderLayout.CENTER);
				 
				
				 
				//c.setComposite(new PointDuMilieu());
				//Object[][] t=c.executer((int)TracerFonction.getIntervalle());
				texteFonction.setText(c.getFonction()+"");
				System.out.println(tab);
				//tabModel=new DefaultTableModel(tab, title);
				//c.setFonction(texteFonction.getText());GROS PB pour analyser et convertir en Fonction
	    		//preparerLeTracer2(c.getFonction()+"");
	    	}
	    });
	    
	    trapeze.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent evt) {
				form.setText("Trapéze");
				CalculIntegrale c=new CalculIntegrale();
				
				tab2=c.executerComposite(10);
				//Object[][] t=c.executerComposite((int)TracerFonction.getIntervalle());	
				texteFonction.setText(c.getFonction()+"");
				//c.setFonction(texteFonction.getText());GROS PB pour analyser et convertir en Fonction
	    		//preparerLeTracer2(c.getFonction()+"");
	    	}
	    });
	    err.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent evt) {
				form.setText("Erreur Quadrature");
				CalculIntegrale c=new CalculIntegrale();
			
	    	}
	    });
	    
	    gaussienne.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent evt) {
				form.setText("Gaussienne");
				CalculIntegrale c=new CalculIntegrale();
			
	    	}
	    });
	   hybride.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent evt) {
				form.setText("Hybride");
				CalculIntegrale c=new CalculIntegrale();
			
	    	}
	    });
	    
	    
	   
	    /************************
	     *  EVENT MENU FONCTION
	     ***********************
	     */

	    carree.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent evt) {
				CalculIntegrale c=new CalculIntegrale();
				c.setFonction(new Carree(new Lineaire()));
				Object[][] t=c.executer((int)TracerFonction.getIntervalle());
				//setTab(t);
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
				Object[][] t=c.executer((int)TracerFonction.getIntervalle());
				//setTab(t);
				System.out.println(t);
				texteFonction.setText(c.getFonction()+"");
				//c.setFonction(texteFonction.getText());GROS PB pour analyser et convertir en Fonction
	    		//preparerLeTracer2(c.getFonction()+"");
	    	}
	    });
	    x34.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent evt) {
				CalculIntegrale c=new CalculIntegrale();
				c.setFonction(new Puissance(new Lineaire(),(-3.0/4.0)));
				Object[][] t=c.executer((int)TracerFonction.getIntervalle());
				//setTab(t);
				System.out.println(t);
				texteFonction.setText(c.getFonction()+"");
				//c.setFonction(texteFonction.getText());GROS PB pour analyser et convertir en Fonction
	    		//preparerLeTracer2(c.getFonction()+"");
	    	}
	    });
	    
	    //Event
	    boutonTracer.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent evt) {
	    		 JavaPlot p = new JavaPlot(true);
	    	        p.addPlot("sin(x)*y");
	    	        p.plot();
	    		//preparerLeTracer();
	    	        }
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
   
	        


	public static void main(String[] args) {
		 JFrame window = new JFrame();
	        //JFrame.setDefaultLookAndFeelDecorated(true);
	       
	        window.setSize(800, 600);
	        window.setLocationRelativeTo(null);
	        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	  
	        new TracerFonction(800,600);
	    }

}


