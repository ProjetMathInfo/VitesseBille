
import java.awt.*;
import java.awt.event.*;
import maths.*;
import javax.swing.*;
	

import maths.Expression;

	public class TracerFonction extends JFrame {
		
		static final Font POLICE = new Font("Monospaced", Font.PLAIN, 12);
		
	    static final String[] titresParametres = { "X min", "X max", "delta X",
	            "Y min", "Y max", "delta Y" };
	    

	                                        // valeurs par défaut
	    private double[] valeurParametres = { 0.0, +1.0, 0.2, 0.0, +1.0, 0.2 };
	    private JTextField[] champsParametres;

	    private JTextField texteFonction;
	    private Expression expression;
	    private JPanel panneauDessin;
	    
	    /*-----------------------*/

	    public TracerFonction(int w,int h) {
	        super("Calcule et représentaion graphique");

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
	                        BorderFactory.createEtchedBorder(), "Paramčtres"), 
	                BorderFactory.createEmptyBorder(5, 5, 5, 5)));
	        
	        JButton boutonTracer = new JButton("Tracer");
	        JPanel panB = new JPanel(new FlowLayout());
	        panB.add(boutonTracer);

	        JPanel panneauDeGauche = new JPanel(new BorderLayout());
	        panneauDeGauche.add(panA, BorderLayout.NORTH);
	        panneauDeGauche.add(panB, BorderLayout.CENTER);
	        panneauDeGauche.setBorder(BorderFactory.createEmptyBorder(0, 0, 10, 10));

	        JPanel panneauDuBas = new JPanel(new GridLayout(0, 1));
	        panneauDuBas.add(new JLabel("Expression ŕ tracer: f(x) ="));
	        panneauDuBas.add(texteFonction);
	        panneauDuBas.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

	        JPanel panneauDeContenu = new JPanel(new BorderLayout());
	        panneauDeContenu.add(panneauDeGauche, BorderLayout.WEST);
	        panneauDeContenu.add(panneauDuBas, BorderLayout.SOUTH);
	        panneauDeContenu.add(panneauDessin, BorderLayout.CENTER);
	        panneauDeContenu.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

	        setContentPane(panneauDeContenu);
	        setDefaultCloseOperation(EXIT_ON_CLOSE);
	        this.setSize(w, h);
	        pack();
	        setVisible(true);
	        
	        
	        //Event
	       
	        boutonTracer.addActionListener(new ActionListener() {
	            public void actionPerformed(ActionEvent evt) {
	                preparerLeTracé();}
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

    private void preparerLeTracé() {

        // on récupčre la fonction et on l'analyse
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

