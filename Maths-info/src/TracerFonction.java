
import java.awt.*;
import java.awt.event.*;

import maths.*;

import javax.swing.*;

import maths.Expression;

public class TracerFonction extends JFrame {
		
		static final Font POLICE = new Font("Monospaced", Font.PLAIN, 12);
		
	    static final String[] titresParametres = { "X min", "X max", "delta X",
	            "Y min", "Y max", "delta Y" };
	    

	                                        // valeurs par dÃ©faut
	    private double[] valeurParametres = { -1.0, +1.0, 0.2, -1.0, +1.0, 0.2 };
	    private JTextField[] champsParametres;

	    private JTextField texteFonction;
	    private Expression expression;
	    private JPanel panneauDessin;
	    private JMenuBar jmd;
	    
	    private JTabbedPane panelOnglet;
	    JPanel onglet1 = new JPanel();
	    JPanel onglet2 = new JPanel();
	   
	    
	    /*-----------------------*/

	    public TracerFonction(int w,int h) {
	        super("Calcule et representaion graphique");
	        
	        JMenuBar jmd=new JMenuBar();
	        this.setJMenuBar(jmd);
	        
	        JMenu mformules=new JMenu("Formules");
	        jmd.add(mformules);
	        
	        JMenu mfonctions=new JMenu("Fonctions");
	        jmd.add(mfonctions);
	        
	        JMenuItem composite=new JMenuItem("Composite");
	        mformules.add(composite);
	        JMenuItem ptDuMil=new JMenuItem("Point du milieu");
	        mformules.add(ptDuMil);
	        JMenuItem trapeze=new JMenuItem("Trapeze");
	        mformules.add(trapeze);
	        JMenuItem gaussienne=new JMenuItem("Gaussienne");
	        mformules.add(gaussienne);
	        JMenuItem hybride=new JMenuItem("Hybride");
	        mformules.add(hybride);
	        JMenuItem err=new JMenuItem("ErreurQuadrature");
	        mformules.add(err);
	        
	        composite.addActionListener(new ChoixFormuleListener());
	        ptDuMil.addActionListener(new ChoixFormuleListener());
	        trapeze.addActionListener(new ChoixFormuleListener());
	        gaussienne.addActionListener(new ChoixFormuleListener());
	        hybride.addActionListener(new ChoixFormuleListener());
	        err.addActionListener(new ChoixFormuleListener());
	        
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
	        
	        panelOnglet = new JTabbedPane(SwingConstants.TOP);
	     
	        panelOnglet.addTab("Panel1", null,onglet1);
	        panelOnglet.addTab("Panel2", null,onglet2);
	        onglet1.add(panneauDessin, BorderLayout.CENTER);
	        onglet1.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
	        
	        JPanel panneauDeContenu = new JPanel(new BorderLayout());
	        panneauDeContenu.add(panneauDeGauche, BorderLayout.WEST);
	        panneauDeContenu.add(panneauDuBas, BorderLayout.SOUTH);
	       /* panneauDeContenu.add(panneauDessin, BorderLayout.CENTER);*/
	        panneauDeContenu.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
	        panneauDeContenu.add(panelOnglet);

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

    private void preparerLeTracer() {

        // on rÃ©cupÄ�re la fonction et on l'analyse
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
		
		if(s.equals("Composite")){
			
		}else if(s.equals("point du mileu")){
			
		}else if(s.equals("Trapeze")){
			
		}else if(s.equals("Gaussienne")){
			
		}else if(s.equals("Hybride")){
			
		}else if(s.equals("ErreurQuadrature")){
				
		}
		
	}
}

