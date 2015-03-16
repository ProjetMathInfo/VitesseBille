
import java.awt.*;
import java.awt.event.*;
import java.util.*;

import javax.swing.*;

import maths.*;
import maths.formules.*;

import com.panayotis.gnuplot.JavaPlot;

 

public class TestProjet {

    public static void main(String[] args) {

        JavaPlot p = new JavaPlot();

        p.addPlot("sin(x)");

        p.plot();

    }

}

