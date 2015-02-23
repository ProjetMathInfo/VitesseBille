

    import java.awt.*;
    import javax.swing.*;
    import maths.*;
    public class PanneauDessin extends JPanel {
        private static final int nombrePas = 1000;
        private TracerFonction cadre;

        public PanneauDessin(TracerFonction cadre) {
            this.cadre = cadre;
            setBackground(Color.WHITE);
        }

        public void paintComponent(Graphics g) {
            super.paintComponent(g);

            Expression expr = cadre.getExpression();
            if (expr != null) {

                // obtention des paramètres du tracé
                double xMin = cadre.getXmin();
                double xMax = cadre.getXmax() ;
                double deltaX = cadre.deltaX();
                double yMin = cadre.getYmin();
                double yMax = cadre.getYmax();
                double deltaY = cadre.deltaY();

                // obtention des transformations affines pour x et y
                Dimension d = getSize();
                double Ax = d.width / (xMax - xMin);
                double Bx = -Ax * xMin;
                double Ay = -d.height / (yMax - yMin);
                double By = -Ay * yMax;

                // tracé des axes
                Color coulPrec = g.getColor();
                g.setColor(Color.GREEN);
                if (yMin * yMax < 0) {
                    int yc = (int) By;
                    g.drawLine(0, yc - 1, d.width, yc - 1);
                    g.drawLine(0, yc, d.width, yc);
                    g.drawLine(0, yc + 1, d.width, yc + 1);
                }
                if (xMin * xMax < 0) {
                    int xc = (int) Bx;
                    g.drawLine(xc - 1, 0, xc - 1, d.height);
                    g.drawLine(xc, 0, xc, d.height);
                    g.drawLine(xc + 1, 0, xc + 1, d.height);
                }

                // tracé de la grille
                long p, pMax;
                p = Math.round(Math.floor(xMin / deltaX));
                pMax = Math.round(Math.ceil(xMax / deltaX));
                for ( ; p <= pMax; p++) {
                    int xc = (int) (Ax * (p * deltaX) + Bx);
                    g.drawLine(xc, 0, xc, d.height);
                }
                p = Math.round(Math.floor(yMin / deltaY));
                pMax = Math.round(Math.ceil(yMax / deltaY));
                for ( ; p <= pMax; p++) {
                    int yc = (int) (Ay * (p * deltaY) + By);
                    g.drawLine(0, yc, d.width, yc);
                }
                g.setColor(coulPrec);

                // tracé de la fonction
                double dx = (xMax - xMin) / nombrePas;
                int xp = 0, yp = 0;
                for (double x = xMin; x <= xMax; x += dx) {
                    double y = expr.valeur(x);
                    int xc = (int) (Ax * x + Bx);
                    int yc = (int) (Ay * y + By);
                    if (xc != 0)
                        g.drawLine(xp, yp, xc, yc);
                    xp = xc;
                    yp = yc;
                }
            }
        }
    }

