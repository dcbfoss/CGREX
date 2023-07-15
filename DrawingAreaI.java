// FrontEnd Plus GUI for JAD
// DeCompiled : DrawingAreaI.class
//package CGRexpack;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.*;
import javax.swing.JPanel;
import javax.swing.JTextField;

class DrawingAreaI extends JPanel
{
	public static final long serialVersionUID = 0;
    BufferedImage bi;
    BufferedImage bi2[];
    Graphics2D g2;
    AlphaComposite ac;
    Polygon p;
    Polygon q;
    BufferedReader fin;
    char dist[][];
    int k;
    int view;
    Color drawColor;
    int width;
    int height;
    int locX;
    int locY;
    int zoomlevel;
    int xOffset;
    int yOffset;
    int level;
    JTextField tf0;
    JTextField tf1;
    JTextField tf2;
    JTextField tf3;
    JTextField tf4;
    JTextField tf5;
    JTextField tf6;
    JTextField tf7;
    JTextField tf8;
    JTextField tf9;
    JTextField tf10;
    JTextField tf11;
    JTextField tf12;
    JTextField tf13;
    JTextField tf14;
    JTextField tf15;
    JTextField tf16;
    JTextField tf17;
    JTextField tf18;
    JTextField tf19;

    public DrawingAreaI(BufferedImage bufferedimage, int i, int j, int l, int i1, int j1)
    {
        g2 = null;
        ac = null;
        fin = new BufferedReader(new InputStreamReader(System.in));
        dist = new char[20][20];
        view = 0;
        width = 512;
        height = 512;
        locX = 0;
        locY = 0;
        zoomlevel = 0;
        xOffset = width / 2;
        yOffset = height / 2;
        level = 0;
        tf0 = null;
        tf1 = null;
        tf2 = null;
        tf3 = null;
        tf4 = null;
        tf5 = null;
        tf6 = null;
        tf7 = null;
        tf8 = null;
        tf9 = null;
        tf10 = null;
        tf11 = null;
        tf12 = null;
        tf13 = null;
        tf14 = null;
        tf15 = null;
        tf16 = null;
        tf17 = null;
        tf18 = null;
        tf19 = null;
        setLayout(null);
        locX = i;
        locY = j;
        width = l;
        height = i1;
        zoomlevel = j1;
        xOffset = l / 2;
        yOffset = i1 / 2;
        setOpaque(true);
        drawColor = Color.black;
        setBackground(Color.WHITE);
        setBounds(i, j, l, i1);
        view = 0;
    }

    public DrawingAreaI(BufferedImage bufferedimage, int i, int j, int l, int i1)
    {
        g2 = null;
        ac = null;
        fin = new BufferedReader(new InputStreamReader(System.in));
        dist = new char[20][20];
        view = 0;
        width = 512;
        height = 512;
        locX = 0;
        locY = 0;
        zoomlevel = 0;
        xOffset = width / 2;
        yOffset = height / 2;
        level = 0;
        tf0 = null;
        tf1 = null;
        tf2 = null;
        tf3 = null;
        tf4 = null;
        tf5 = null;
        tf6 = null;
        tf7 = null;
        tf8 = null;
        tf9 = null;
        tf10 = null;
        tf11 = null;
        tf12 = null;
        tf13 = null;
        tf14 = null;
        tf15 = null;
        tf16 = null;
        tf17 = null;
        tf18 = null;
        tf19 = null;
        setLayout(null);
        locX = i;
        locY = j;
        width = l;
        height = i1;
        xOffset = l / 2;
        yOffset = i1 / 2;
        view = 0;
        bi = bufferedimage;
        setOpaque(true);
        drawColor = Color.black;
        setBackground(Color.WHITE);
        setBounds(i, j, l, i1);
        System.out.println(i + " " + j);
        ac = AlphaComposite.getInstance(3, 1.0F);
    }

    public void paintComponent(Graphics g)
    {
        update(g);
    }

    public void update(Graphics g)
    {
        super.paintComponent(g);
        g2 = (Graphics2D)g;
        if(view == 0)
            if(bi != null)
            {
                g2.setComposite(ac);
                g2.setBackground(Color.WHITE);
                g2.drawImage(bi, null, 0, 0);
                if(zoomlevel == 0)
                    labelCorners();
                else
                    removeTF();
            } else
            {
                System.out.println("BINULL");
            }
    }

    public void removeTF()
    {
        tf0.setBounds(600, 600, 22, 23);
        remove(tf1);
        remove(tf2);
        remove(tf3);
        remove(tf4);
        remove(tf5);
        remove(tf6);
        remove(tf7);
        remove(tf8);
        remove(tf9);
        remove(tf10);
        remove(tf11);
        remove(tf12);
        remove(tf13);
        remove(tf14);
        remove(tf15);
        remove(tf16);
        remove(tf17);
        remove(tf18);
        remove(tf19);
    }

    public void labelCorners()
    {
        System.out.println("length = " + Manipulation.x.length + " " + Manipulation.corners + " " + Manipulation.x[0]);
        int ai[] = new int[Manipulation.numPoints];
        int ai1[] = new int[Manipulation.numPoints];
        ai = Manipulation.x;
        ai1 = Manipulation.y;
        int ai2[] = new int[Manipulation.numPoints];
        int ai3[] = new int[Manipulation.numPoints];
        for(int i = 0; i < Manipulation.numPoints; i++)
        {
            byte byte0 = 22;
            byte byte2 = 20;
            if(ai[i] > 130)
                ai2[i] = ai[i] + 3;
            else
                ai2[i] = ai[i] - (byte0 + 3);
            if(ai1[i] > 130)
                ai3[i] = ai1[i] + 3;
            else
                ai3[i] = ai1[i] - (byte2 + 3);
        }

        System.out.println("Manipulation.Corners: " + Manipulation.corners);
        for(int j = 0; j < Manipulation.corners; j++)
        {
            byte byte1 = 22;
            byte byte3 = 20;
            if(j == 0)
            {
                tf0 = new JTextField(String.valueOf(j + 1));
                add(tf0);
                tf0.setBounds(ai2[j], ai3[j], byte1, byte3);
            }
            if(j == 1)
            {
                tf1 = new JTextField(String.valueOf(j + 1));
                add(tf1);
                tf1.setBounds(ai2[j], ai3[j], byte1, byte3);
            }
            if(j == 2)
            {
                tf1 = new JTextField(String.valueOf(j + 1));
                add(tf1);
                tf1.setBounds(ai2[j], ai3[j], byte1, byte3);
            }
            if(j == 3)
            {
                tf3 = new JTextField(String.valueOf(j + 1));
                add(tf3);
                tf3.setBounds(ai2[j], ai3[j], byte1, byte3);
            }
            if(j == 4)
            {
                tf4 = new JTextField(String.valueOf(j + 1));
                add(tf4);
                tf4.setBounds(ai2[j], ai3[j], byte1, byte3);
            }
            if(j == 5)
            {
                tf5 = new JTextField(String.valueOf(j + 1));
                add(tf5);
                tf5.setBounds(ai2[j], ai3[j], byte1, byte3);
            }
            if(j == 6)
            {
                tf6 = new JTextField(String.valueOf(j + 1));
                add(tf6);
                tf6.setBounds(ai2[j], ai3[j], byte1, byte3);
            }
            if(j == 7)
            {
                tf7 = new JTextField(String.valueOf(j + 1));
                add(tf7);
                tf7.setBounds(ai2[j], ai3[j], byte1, byte3);
            }
            if(j == 8)
            {
                tf8 = new JTextField(String.valueOf(j + 1));
                add(tf8);
                tf8.setBounds(ai2[j], ai3[j], byte1, byte3);
            }
            if(j == 9)
            {
                tf9 = new JTextField(String.valueOf(j + 1));
                add(tf9);
                tf9.setBounds(ai2[j], ai3[j], byte1, byte3);
            }
            if(j == 10)
            {
                tf10 = new JTextField(String.valueOf(j + 1));
                add(tf10);
                tf10.setBounds(ai2[j], ai3[j], byte1, byte3);
            }
            if(j == 11)
            {
                tf11 = new JTextField(String.valueOf(j + 1));
                add(tf11);
                tf11.setBounds(ai2[j], ai3[j], byte1, byte3);
            }
            if(j == 12)
            {
                tf12 = new JTextField(String.valueOf(j + 1));
                add(tf12);
                tf12.setBounds(ai2[j], ai3[j], byte1, byte3);
            }
            if(j == 13)
            {
                tf13 = new JTextField(String.valueOf(j + 1));
                add(tf13);
                tf13.setBounds(ai2[j], ai3[j], byte1, byte3);
            }
            if(j == 14)
            {
                tf14 = new JTextField(String.valueOf(j + 1));
                add(tf14);
                tf14.setBounds(ai2[j], ai3[j], byte1, byte3);
            }
            if(j == 15)
            {
                tf15 = new JTextField(String.valueOf(j + 1));
                add(tf15);
                tf15.setBounds(ai2[j], ai3[j], byte1, byte3);
            }
            if(j == 16)
            {
                tf16 = new JTextField(String.valueOf(j + 1));
                add(tf16);
                tf16.setBounds(ai2[j], ai3[j], byte1, byte3);
            }
            if(j == 17)
            {
                tf17 = new JTextField(String.valueOf(j + 1));
                add(tf17);
                tf17.setBounds(ai2[j], ai3[j], byte1, byte3);
            }
            if(j == 18)
            {
                tf18 = new JTextField(String.valueOf(j + 1));
                add(tf18);
                tf18.setBounds(ai2[j], ai3[j], byte1, byte3);
            }
            if(j == 19)
            {
                tf19 = new JTextField(String.valueOf(j + 1));
                add(tf19);
                tf19.setBounds(ai2[j], ai3[j], byte1, byte3);
            }
        }

    }
}
