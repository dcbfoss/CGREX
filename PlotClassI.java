// FrontEnd Plus GUI for JAD
// DeCompiled : PlotClassI.class
//package CGRexpack;
import java.awt.Color;
import java.awt.Container;
import java.awt.event.*;
import java.awt.image.BufferedImage;
//import java.io.PrintStream;
import javax.swing.*;

public class PlotClassI extends JFrame
    implements ActionListener, Runnable
{
	public static final long serialVersionUID = 0;	

    DrawingAreaI jpanel;
    int x[];
    int y[]; 
    Text sequence;
    JButton load;
    JButton color;
    JButton movie;
    JButton enh;
    JButton mult;
    String str;
    Container content;
    int count;
    Thread t;
    BufferedImage bi[];

    public PlotClassI()
    {
        jpanel = null;
        sequence = null;
        load = null;
        color = null;
        movie = null;
        enh = null;
        mult = null;
        str = null;
        content = null;
        count = 0;
        t = null;
        bi = null;
        load = new JButton("Load");
        color = new JButton("Color");
        movie = new JButton("Movie");
        enh = new JButton("Enhancement");
        mult = new JButton("Multiplot");
        sequence = new Text();
        content = getContentPane();
        content.setLayout(null);
        content.add(sequence);
        content.add(load);
        content.add(color);
        content.add(movie);
        content.add(enh);
        content.add(mult);
        load.setBounds(530, 50, 50, 25);
        color.setBounds(530, 100, 50, 25);
        movie.setBounds(530, 150, 50, 25);
        enh.setBounds(530, 200, 50, 25);
        mult.setBounds(530, 250, 50, 25);
        load.addActionListener(this);
        color.addActionListener(this);
        movie.addActionListener(this);
        enh.addActionListener(this);
        mult.addActionListener(this);
        addWindowListener(new WindowAdapter() {

            public void windowClosing(WindowEvent windowevent)
            {
                System.exit(1);
            }

        });
    }

    public void actionPerformed(ActionEvent actionevent)
    {
        if(actionevent.getSource() == load)
        {
            count = 0;
            sequence.readwrite("D:/sandeep_java/amino.txt");
            str = sequence.getText();
            Manipulation manipulation = new Manipulation(str, 512, 512);
            jpanel = new DrawingAreaI(manipulation.compute(), 0, 0, 512, 512);
            content.add(jpanel);
            repaint();
        } else
        if(actionevent.getSource() == color)
        {
            count = 0;
            int i = sequence.getSelectionStart();
            int j = sequence.getSelectionEnd();
            content.remove(jpanel);
            Manipulation manipulation1 = new Manipulation(sequence.getText(), 512, 512);
            jpanel = new DrawingAreaI(manipulation1.addColor(i, j, Color.RED), 0, 0, 512, 512);
            content.add(jpanel);
            repaint();
        } else
        if(actionevent.getSource() == movie)
        {
            t = new Thread(this);
            t.start();
        } else
        if(actionevent.getSource() == enh)
            System.out.println(str);
    }

    public void run()
    {
        byte byte0 = 10;
        int i = 1;
        byte byte1 = 100;
        int j = 1;
        int k = (byte1 - (i - 1)) / byte0;
        int l = byte0;
        int i1 = i - 1;
        Manipulation manipulation = new Manipulation(sequence.getText(), 512, 512);
        for(int j1 = 0; j1 < k; j1++)
        {
            content.remove(jpanel);
            jpanel = new DrawingAreaI(manipulation.movieMaker(i1, l, j), 30, 80, 512, 512);
            content.add(jpanel);
            jpanel.repaint();
            try
            {
                Thread.sleep(1000L);
            }
            catch(Exception exception) { }
            i1 = l + 1;
            l = byte0 * (j1 + 2);
        }

    }

    public static void main(String args[])
    {
        try
        {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        }
        catch(Exception exception) { }
        PlotClassI plotclassi = new PlotClassI();
        plotclassi.setTitle("Plot Class");
        plotclassi.setSize(600, 600);
        plotclassi.setVisible(true);
    }
}
