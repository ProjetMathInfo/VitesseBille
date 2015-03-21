
import java.awt.*;


import com.panayotis.gnuplot.JavaPlot;

import com.panayotis.gnuplot.*;

public class TestPlot {

    public static void main(String[] args) {

        JavaPlot p = new JavaPlot();

        p.addPlot("sin(x)");

        p.plot();

    }

}

