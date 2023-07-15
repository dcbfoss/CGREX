// FrontEnd Plus GUI for JAD
// DeCompiled : CGRDrawing.class
//package CGRexpack;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.*;
import java.io.FileOutputStream;
import java.util.ArrayList;
import javax.swing.*;

class CGRDrawing extends JPanel
    implements MouseListener, MouseMotionListener
{
	public static final long serialVersionUID = 0;
    static int ns;
    static int issplit;
	String SeqType;
    int SeqTypeIndex;
    String TestSeqType;
    int PlotShapeIndex;
    int SeqColor[][];
    int TestSeqColor[][];
    String s =null;
    String  ss = "";
    String SeqStr;
    String TestSeqStr;
    String Distr[];
    String TestDistr[];
    String DistrName;
    String TestDistrName;
    int Corners;
    int TestCorners;
    int GroupSelection;
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
    int x[];
    int y[];
    float xp[];
    float yp[];
    float Superxp[];
    float Superyp[];
    int x2[];
    int y2[];
    int xmesh[][];
    int ymesh[][];
    double angle0[][];
    double angle1[][];
    double angle2[][];
    double angle3[][];
    int dotSize;
    int countpoints;
    int ZoomLevel;
    ArrayList xcount;
    ArrayList ycount;
    int width;
    int height;
    int xOffset;
    int yOffset;
    boolean draw;
    boolean Multiplot;
    boolean count;
    boolean counttype;
    boolean zoom;
    boolean DoZoom;
    int level;
    int label;
    CGRexMainGUI obj;
    JOptionPane jop;
    BufferedImage bi;
    Graphics2D g;
    Polygon p;
    Point drag;
    Point drop;
    final int ZOOM_MAX = 100;
    double sxp[];
    double syp[];
    double zxp[][];
    double zyp[][];
    final float dash1[] = {
        10F
    };
    BasicStroke dashed;
    BasicStroke solid;
    AlphaComposite ac;
    AlphaComposite ac2;
    int sip[];
    int zip[][];

    public CGRDrawing(int i, int j)
    {
    	   
    	TestCorners = 4;
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
        
        xmesh = (int[][])null;
        ymesh = (int[][])null;
        angle0 = (double[][])null;
        angle1 = (double[][])null;
        angle2 = (double[][])null;
        angle3 = (double[][])null;
        dotSize = 0;
        countpoints = 0;
        ZoomLevel = 0;
        xcount = new ArrayList();
        ycount = new ArrayList();
        draw = false;
        Multiplot = false;
        count = false;
        counttype = false;
        zoom = false;
        DoZoom = false;
        level = 0;
        label = 0;
        bi = null;
        p = null;
        zxp = new double[100][];
        zyp = new double[100][];
        dashed = new BasicStroke(1.0F, 0, 0, 10F, dash1, 0.0F);
        solid = new BasicStroke();
        ac = AlphaComposite.getInstance(2, 0.35F);
        ac2 = AlphaComposite.getInstance(2, 1.0F);
        zip = new int[100][];
                
        tf0 = new JTextField();
        tf1 = new JTextField();
        tf2 = new JTextField();
        tf3 = new JTextField();
        tf4 = new JTextField();
        tf5 = new JTextField();
        tf6 = new JTextField();
        tf7 = new JTextField();
        tf8 = new JTextField();
        tf9 = new JTextField();
        tf10 = new JTextField();
        tf11 = new JTextField();
        tf12 = new JTextField();
        tf13 = new JTextField();
        tf14 = new JTextField();
        tf15 = new JTextField();
        tf16 = new JTextField();
        tf17 = new JTextField();
        tf18 = new JTextField();
        tf19 = new JTextField();
        tf0.setEnabled(false);
        tf1.setEnabled(false);
        tf2.setEnabled(false);
        tf3.setEnabled(false);
        tf4.setEnabled(false);
        tf5.setEnabled(false);
        tf6.setEnabled(false);
        tf7.setEnabled(false);
        tf8.setEnabled(false);
        tf9.setEnabled(false);
        tf10.setEnabled(false);
        tf11.setEnabled(false);
        tf12.setEnabled(false);
        tf13.setEnabled(false);
        tf14.setEnabled(false);
        tf15.setEnabled(false);
        tf16.setEnabled(false);
        tf17.setEnabled(false);
        tf18.setEnabled(false);
        tf19.setEnabled(false);
        obj = null;
        SeqTypeIndex = 0;
        PlotShapeIndex = 0;
        GroupSelection = 0;
        TestSeqType=null;    	
        
 		CGRDrawing1(i,j);        
    }

    public void CGRDrawing1(int i, int j)
    {

        bi = new BufferedImage(i, j, 2);
        g = bi.createGraphics();
        xOffset = i / 2;
        yOffset = j / 2;
   }
    
    public boolean validateSettings()
    {
       
     
        draw = false;
        SeqTypeIndex = 0;
        if(TestSeqType.equals("DNA"))
        {
        	
        	SeqTypeIndex = 1;
        
            if(TestCorners == 4)
            {
            	
                String as[] = {
                    "A", "G", "T", "C"
              				  };
                int i = 0;
                do
                {
                	
                    if(i >= as.length)
                    {
                    	break;
                    }
                    if(!TestDistr[i].equals(as[i]))
                    {
                    
                        draw = false;
                        break;
                    }
                    draw = true;
                    i++;
                } while(true);
                if(draw)
                {
                	
                    int j = 0;
                    do
                    {
                        if(j >= TestSeqStr.length())
                            break;
                        char c = TestSeqStr.charAt(j);
                        if(c != 'A' && c != 'G' && c != 'T' && c != 'C')
                        {
                        
                            draw = false;
                            break;
                        }
                        j++;
                    } while(true);
                }
            } else
            {
            	
                draw = false;
            }
        } else
        if(TestSeqType.equals("RNA"))
        {
        	SeqTypeIndex = 2;
        	
            if(TestCorners == 4)
            {
                String as1[] = {
                    "A", "G", "U", "C"
                };
                int k = 0;
                do
                {
                    if(k >= as1.length)
                        break;
                    if(!TestDistr[k].equals(as1[k]))
                    {
                   
                        draw = false;
                        break;
                    }
                    draw = true;
                    k++;
                } while(true);
                if(draw)
                {
                    int l = 0;
                    do
                    {
                        if(l >= TestSeqStr.length())
                            break;
                        char c1 = TestSeqStr.charAt(l);
                        if(c1 != 'A' && c1 != 'G' && c1 != 'U' && c1 != 'C')
                        {
                        	System.out.print("draw is false 4");
                            draw = false;
                            break;
                        }
                        l++;
                    } while(true);
                }
            } else
            {
            	System.out.print("draw is false 5");
                draw = false;
            }
        } else
        if(TestSeqType.equals("Amino Acid"))
        {
        	SeqTypeIndex = 3;
    
            if(TestCorners > 2)
            {
            //	 String as1[] = {"A", "R", "N", "D", "C", "E", "Q", "G", "H", "I", "L", "K", "M", "F", "P", "S", "T", "W", "Y", "V"  };
                if(TestDistr.length == TestCorners)
                {
                	int l = 0;
                	draw = true;
                	do
                     {
                         if(l >= TestSeqStr.length())
                             break;
                         char c1 = TestSeqStr.charAt(l);
                         if(c1 != 'A' && c1 != 'R' && c1 != 'N' && c1 != 'D'
                        	 && c1 != 'C' && c1 != 'E' && c1 != 'Q'
                        	 && c1 != 'G' && c1 != 'H' && c1 != 'I'
                        	 && c1 != 'L' && c1 != 'K' && c1 != 'M'
                        	 && c1 != 'F' && c1 != 'P' && c1 != 'S'
                        	 && c1 != 'T' && c1 != 'W' && c1 != 'Y'
                        	 && c1 != 'V')
                         {
                         	System.out.print("draw is false 4");
                             draw = false;
                             break;
                         }
                         l++;
                     } while(true);
                }
                    
                else
                {
                	System.out.println("draw is false 6");
                	draw = false;
                }
                    
            } else
            {
            	System.out.println("draw is false7");
                draw = false;
            }
           
         }
          if(draw)
        {
            SeqStr = TestSeqStr;
            SeqType = TestSeqType;
            Corners = TestCorners;
            Distr = TestDistr;
            DistrName = TestDistrName;
            SeqColor = TestSeqColor;
        } else
        {
            if(SeqStr != null)
                TestSeqStr = SeqStr;
            if(SeqType != null)
                TestSeqType = SeqType;
            if(Corners < 3)
                TestCorners = Corners;
            if(Distr != null)
                TestDistr = Distr;
            if(DistrName != null)
                TestDistrName = DistrName;
            if(SeqColor != null)
                TestSeqColor = SeqColor;
        }
      
        return draw;
    }

    public void drawPoly()
    {
        removeTextFields();
        g.setColor(Color.BLACK);
        g.setComposite(ac2);
        g.setStroke(solid);
        x = new int[Corners + 1];
        y = new int[Corners + 1];
        int i = 0;
        double d = 6.2831853071795862D / (double)Corners;
        if(Corners == 4)
            i = (int)((double)yOffset * 1.25D);
        else
            i = (int)((double)yOffset * 0.84999999999999998D);
        double d1 = (double)(2 + Corners) / (double)(2 * Corners);
        double d2 = d1 * 3.1415926535897931D;
        for(int j = 0; j < Corners + 1; j++)
        {
            x[j] = (int)((double)i * Math.cos((6.2831853071795862D - d * (double)j) + d2)) + xOffset;
            y[j] = (int)((double)i * Math.sin((6.2831853071795862D - d * (double)j) + d2)) + yOffset;
        }

        p = new Polygon(x, y, Corners + 1);
        g.setColor(Color.WHITE);
        g.fillPolygon(p);
        g.setColor(Color.BLACK);
        g.drawPolygon(p);
        draw = true;
        label = 0;
    }

    public void plot()
    {
       char [][]ac1 = new char[20][20];
        int i = 0;
        for(int j = 0; j < 20; j++)
        {
            for(int j1 = 0; j1 < 20; j1++)
                ac1[j][j1] = '\0';
        }
        for(int k = 0; k < Corners; k++)
        {
            for(int k1 = 0; k1 < Distr[k].length(); k1++)
                ac1[k][k1] = Distr[k].charAt(k1);
        }
label0:
        for(int l = 0; l < Corners; l++)
        {
            int l1 = 0;
            do
            {
                if(l1 >= Distr[l].length())
                    continue label0;
                if(SeqStr.charAt(0) == ac1[l][l1])
                {
                    i = l;
                    continue label0;
                }
                l1++;
            } while(true);
        }
      
        xp = new float[SeqStr.length()];
        yp = new float[SeqStr.length()];
        xp[0] = (xOffset + x[i]) / 2;
        yp[0] = (yOffset + y[i]) / 2;
        g.setComposite(ac2);
        g.setStroke(solid);
        g.setColor(new Color(SeqColor[0][0], SeqColor[0][1], SeqColor[0][2]));
       
        
         //g.drawOval((int)xp[0], (int)yp[0], dotSize, dotSize);
       
       
        for(int i1 = 1; i1 < SeqStr.length(); i1++)
        {
label1:
            for(int i2 = 0; i2 < Corners; i2++)
            {
                int j2 = 0;
                do
                {
                    if(j2 >= 20)
                        continue label1;
                    if(SeqStr.charAt(i1) == ac1[i2][j2])
                    {
                        i = i2;
                        continue label1;
                    }
                    j2++;
                } while(true);
            }

            xp[i1] = (xp[i1 - 1] + (float)x[i]) / 2.0F;
            yp[i1] = (yp[i1 - 1] + (float)y[i]) / 2.0F;
           // g.setColor(new Color(SeqColor[i1][0], SeqColor[i1][1], SeqColor[i1][2]));
            g.drawOval((int)xp[i1], (int)yp[i1], dotSize, dotSize);
            g.fillOval((int)xp[i1], (int)yp[i1], dotSize, dotSize);
        }
              
        split(x, y, level);
    }

    public void plotPoints()
    {
        g.setColor(Color.RED);
        g.setComposite(ac2);
        for(int i = 0; i < Superxp.length; i++)
            g.drawOval((int)Superxp[i], (int)Superyp[i], dotSize, dotSize);

    }

    public void clearPanel()
    {
        if(p != null)
        {
            g.setComposite(ac2);
            g.setStroke(solid);
            g.setColor(SystemColor.control);
            g.fillRect(0, 0, 512, 512);
        }
    }

    public void clearPlot()
    {
        countpoints = 0;
        if(p != null)
        {
            g.setComposite(ac2);
            g.setStroke(solid);
            g.setColor(Color.WHITE);
            g.fillPolygon(p);
            g.setColor(Color.BLACK);
            g.drawPolygon(p);
        }
    }

    public void addColor(int i, int j, Color color)
    {
        g.setComposite(ac2);
        for(int k = 0; k < SeqStr.length(); k++)
            if(k >= i && k < j)
            {
                SeqColor[k][0] = color.getRed();
                SeqColor[k][1] = color.getGreen();
                SeqColor[k][2] = color.getBlue();
                g.setColor(color);
                g.drawOval((int)xp[k], (int)yp[k], dotSize, dotSize);
            }

    }

    public void movieMaker(int i, int j, boolean flag)
    {
        g.setComposite(ac2);
        g.setStroke(solid);
        if(!flag)
        {
            g.setColor(Color.WHITE);
            g.fillPolygon(p);
            g.setColor(Color.BLACK);
            g.drawPolygon(p);
        }
        for(int k = i; k <= j; k++)
        {
            g.setColor(new Color(SeqColor[k][0], SeqColor[k][1], SeqColor[k][2]));
            g.drawOval((int)xp[k], (int)yp[k], dotSize, dotSize);
        }

    }

    public void splitPlot(int i)
    {
    	ss ="";
    	issplit=1;
    	//System.out.println("inside split plot .."+i);
        g.setComposite(ac2);
        level = i;
        clearPlot();
        plot();
        issplit=0;
        //split(x, y, i);
    }

    public void split(int ai[], int ai1[], int i)
    {
    	
        g.setComposite(ac);
        if(i == 0)
            return;
        int ai2[] = new int[Corners];
        int ai3[] = new int[Corners];
        if(Corners != 4)
        {
            for(int j = 0; j < Corners; j++)
            {
                for(int k = 0; k < Corners; k++)
                {
                    ai2[k] = (ai[j] + ai[j + k >= Corners ? (j + k) - Corners : j + k]) / 2;
                    ai3[k] = (ai1[j] + ai1[j + k >= Corners ? (j + k) - Corners : j + k]) / 2;
                }

                for(int l = 0; l < Corners; l++)
                {
                    if(j == 0)
                        g.setColor(Color.BLUE);
                    else
                    if(j == 1)
                        g.setColor(Color.RED);
                    else
                    if(j == 2)
                        g.setColor(Color.MAGENTA);
                    else
                    if(j == 3)
                        g.setColor(Color.ORANGE);
                    else
                    if(j == 4)
                        g.setColor(Color.PINK);
                    else
                    if(j == 5)
                        g.setColor(Color.GREEN);
                    else
                    if(j == 6)
                        g.setColor(Color.CYAN);
                    else
                    if(j == 7)
                        g.setColor(Color.YELLOW);
                    else
                    if(j == 8)
                        g.setColor(Color.DARK_GRAY);
                    else
                    if(j == 9)
                        g.setColor(Color.GRAY);
                    else
                    if(j == 10)
                        g.setColor(Color.WHITE);
                    g.drawLine(ai2[l], ai3[l], ai2[l + 1 >= Corners ? 0 : l + 1], ai3[l + 1 >= Corners ? 0 : l + 1]);
                }

                g.setColor(Color.BLACK);
                //System.out.println("aaaaaaaaa");                
                split(ai2, ai3, i - 1);
            }

        } else
        {
            int ai4[] = new int[Corners];
            int ai5[] = new int[Corners];
            for(int i1 = 0; i1 < Corners; i1++)
            {
                ai2[i1] = (ai[i1] + ai[i1 + 1 >= Corners ? 0 : i1 + 1]) / 2;
                ai3[i1] = (ai1[i1] + ai1[i1 + 1 >= Corners ? 0 : i1 + 1]) / 2;
                //System.out.println("ai2  "+ai2[i1]+"ai3    "+ai3[i1]);
               // System.out.println("corners  "+Corners);
            }

            if(i == level)
                g.setColor(Color.BLUE);
            else
            if(i == level - 1)
                g.setColor(Color.RED);
            else
            if(i == level - 2)
                g.setColor(Color.MAGENTA);
            else
            if(i == level - 3)
                g.setColor(Color.ORANGE);
            else
            if(i == level - 4)
                g.setColor(Color.PINK);
            else
            if(i == level - 5)
                g.setColor(Color.GREEN);
            else
            if(i == level - 6)
                g.setColor(Color.CYAN);
            else
            if(i == level - 7)
                g.setColor(Color.YELLOW);
            else
            if(i == level - 8)
                g.setColor(Color.DARK_GRAY);
            else
            if(i == level - 9)
                g.setColor(Color.GRAY);
            else
            if(i == level - 10)
                g.setColor(Color.WHITE);
            else
                g.setColor(Color.GRAY);
            g.drawLine(ai2[0], ai3[0], ai2[2], ai3[2]);
            g.drawLine(ai2[1], ai3[1], ai2[3], ai3[3]);
            g.setColor(Color.BLACK);
            for(int j1 = 0; j1 < Corners; j1++)
            {
                ai4[0] = ai[j1];
                ai4[1] = ai2[j1];
                ai4[2] = (ai2[j1 - 1 < 0 ? 3 : j1 - 1] + ai2[j1 + 1 >= Corners ? 0 : j1 + 1]) / 2;
                ai4[3] = ai2[j1 - 1 < 0 ? 3 : j1 - 1];
                ai5[0] = ai1[j1];
                ai5[1] = ai3[j1];
                ai5[2] = (ai3[j1 - 1 < 0 ? 3 : j1 - 1] + ai3[j1 + 1 >= Corners ? 0 : j1 + 1]) / 2;
                ai5[3] = ai3[j1 - 1 < 0 ? 3 : j1 - 1];
                //System.out.println("REC");
                split(ai4, ai5, i - 1);
               // System.out.println("ai4[0] "+ai4[0] +"ai5[0] "+ai5[0]);
                //System.out.println("ai4[1] "+ai4[1] +"ai5[1] "+ai5[1]);
                //System.out.println("ai4[2] "+ai4[2] +"ai5[2] "+ai5[2]);
                //System.out.println("ai4[3] "+ai4[3] +"ai5[3] "+ai5[3]);
                //System.out.println("i ="+ (i - 1));
                
                nMercount(ai4,ai5,i - 1);
               
                }
            
           // System.out.println("-----------------------------");
        }
        g.setComposite(ac2);
    }

    public void labelCorners()
    {
        x2 = new int[Corners];
        y2 = new int[Corners];
        for(int i = 0; i < Corners; i++)
        {
            byte byte0 = 22;
            byte byte2 = 20;
            if(x[i] > 130)
                x2[i] = x[i] + 3;
            else
                x2[i] = x[i] - (byte0 + 3);
            if(y[i] > 130)
                y2[i] = y[i] + 3;
            else
                y2[i] = y[i] - (byte2 + 3);
        }

        for(int j = 0; j < Corners; j++)
        {
            byte byte1 = 22;
            byte byte3 = 20;
            if(j == 0)
            {
                tf0.setBounds(x2[j], y2[j], byte1, byte3);
                if(label == 0)
                {
                    tf0.setText(String.valueOf(j + 1));
                    tf0.setVisible(true);
                    add(tf0);
                }
            }
            if(j == 1)
            {
                tf1.setBounds(x2[j], y2[j], byte1, byte3);
                if(label == 0)
                {
                    tf1.setText(String.valueOf(j + 1));
                    add(tf1);
                }
            }
            if(j == 2)
            {
                tf2.setBounds(x2[j], y2[j], byte1, byte3);
                if(label == 0)
                {
                    tf2.setText(String.valueOf(j + 1));
                    add(tf2);
                }
            }
            if(j == 3)
            {
                tf3.setBounds(x2[j], y2[j], byte1, byte3);
                if(label == 0)
                {
                    tf3.setText(String.valueOf(j + 1));
                    add(tf3);
                }
            }
            if(j == 4)
            {
                tf4.setBounds(x2[j], y2[j], byte1, byte3);
                if(label == 0)
                {
                    tf4.setText(String.valueOf(j + 1));
                    add(tf4);
                }
            }
            if(j == 5)
            {
                tf5.setBounds(x2[j], y2[j], byte1, byte3);
                if(label == 0)
                {
                    tf5.setText(String.valueOf(j + 1));
                    add(tf5);
                }
            }
            if(j == 6)
            {
                tf6.setBounds(x2[j], y2[j], byte1, byte3);
                if(label == 0)
                {
                    tf6.setText(String.valueOf(j + 1));
                    add(tf6);
                }
            }
            if(j == 7)
            {
                tf7.setBounds(x2[j], y2[j], byte1, byte3);
                if(label == 0)
                {
                    tf7.setText(String.valueOf(j + 1));
                    add(tf7);
                }
            }
            if(j == 8)
            {
                tf8.setBounds(x2[j], y2[j], byte1, byte3);
                if(label == 0)
                {
                    tf8.setText(String.valueOf(j + 1));
                    add(tf8);
                }
            }
            if(j == 9)
            {
                tf9.setBounds(x2[j], y2[j], byte1, byte3);
                if(label == 0)
                {
                    tf9.setText(String.valueOf(j + 1));
                    add(tf9);
                }
            }
            if(j == 10)
            {
                tf10.setBounds(x2[j], y2[j], byte1, byte3);
                if(label == 0)
                {
                    tf10.setText(String.valueOf(j + 1));
                    add(tf10);
                }
            }
            if(j == 11)
            {
                tf11.setBounds(x2[j], y2[j], byte1, byte3);
                if(label == 0)
                {
                    tf11.setText(String.valueOf(j + 1));
                    add(tf11);
                }
            }
            if(j == 12)
            {
                tf12.setBounds(x2[j], y2[j], byte1, byte3);
                if(label == 0)
                {
                    tf12.setText(String.valueOf(j + 1));
                    add(tf12);
                }
            }
            if(j == 13)
            {
                tf13.setBounds(x2[j], y2[j], byte1, byte3);
                if(label == 0)
                {
                    tf13.setText(String.valueOf(j + 1));
                    add(tf13);
                }
            }
            if(j == 14)
            {
                tf14.setBounds(x2[j], y2[j], byte1, byte3);
                if(label == 0)
                {
                    tf14.setText(String.valueOf(j + 1));
                    add(tf14);
                }
            }
            if(j == 15)
            {
                tf15.setBounds(x2[j], y2[j], byte1, byte3);
                if(label == 0)
                {
                    tf15.setText(String.valueOf(j + 1));
                    add(tf15);
                }
            }
            if(j == 16)
            {
                tf16.setBounds(x2[j], y2[j], byte1, byte3);
                if(label == 0)
                {
                    tf16.setText(String.valueOf(j + 1));
                    add(tf16);
                }
            }
            if(j == 17)
            {
                tf17.setBounds(x2[j], y2[j], byte1, byte3);
                if(label == 0)
                {
                    tf17.setText(String.valueOf(j + 1));
                    add(tf17);
                }
            }
            if(j == 18)
            {
                tf18.setBounds(x2[j], y2[j], byte1, byte3);
                if(label == 0)
                {
                    tf18.setText(String.valueOf(j + 1));
                    add(tf18);
                }
            }
            if(j != 19)
                continue;
            tf19.setBounds(x2[j], y2[j], byte1, byte3);
            if(label == 0)
            {
                tf19.setText(String.valueOf(j + 1));
                add(tf19);
            }
        }

        label++;
    }

    public void splitmesh()
    {
        xmesh = new int[(int)Math.pow(2D, level)][(int)Math.pow(2D, level)];
        ymesh = new int[(int)Math.pow(2D, level)][(int)Math.pow(2D, level)];
        //int ai[][] = new int[(int)Math.pow(2D, level)][(int)Math.pow(2D, level)];
        angle0 = new double[(int)Math.pow(2D, level)][(int)Math.pow(2D, level)];
        angle1 = new double[(int)Math.pow(2D, level)][(int)Math.pow(2D, level)];
        angle2 = new double[(int)Math.pow(2D, level)][(int)Math.pow(2D, level)];
        angle3 = new double[(int)Math.pow(2D, level)][(int)Math.pow(2D, level)];
        int ai1[] = new int[4];
        int ai2[] = new int[4];
        int i = (int)((double)(x[1] - x[0]) / Math.pow(2D, level));
        int j = (int)((double)(y[0] - y[3]) / Math.pow(2D, level));
        double d = x[0];
        for(int k = 0; d < x[1] && k < (int)Math.pow(2D, level); k++)
        {
            int l = y[3];
            for(int i1 = 0; l < y[0] && i1 < (int)Math.pow(2D, level); i1++)
            {
                ai1[0] = (int)d;
                ai1[1] = (int)d + i;
                ai1[2] = (int)d + i;
                ai1[3] = (int)d;
                ai2[0] = l + j;
                ai2[1] = l + j;
                ai2[2] = l;
                ai2[3] = l;
                Polygon polygon = new Polygon(ai1, ai2, 4);
                double d8 = 0.0D;
                double d9 = 0.0D;
                int j4 = 0;
                for(int k4 = 0; k4 < xp.length; k4++)
                    if(polygon.contains((int)xp[k4], (int)yp[k4]))
                    {
                        d8 += xp[k4];
                        d9 += yp[k4];
                        j4++;
                    }

                xmesh[k][i1] = (int)(d8 / (double)j4);
                ymesh[k][i1] = (int)(d9 / (double)j4);
                l += j;
            }

            d += i;
        }

        d = 0.0D;
        //double d4 = 0.0D;
        for(int j1 = 0; j1 < (int)Math.pow(2D, level) - 1; j1++)
        {
            for(int l2 = 0; l2 < (int)Math.pow(2D, level) - 1; l2++)
            {
                double d10 = ymesh[j1][l2 + 1] - ymesh[j1][l2];
                double d13 = xmesh[j1][l2 + 1] - xmesh[j1][l2];
                double d16 = ymesh[j1 + 1][l2] - ymesh[j1][l2];
                double d19 = xmesh[j1 + 1][l2] - xmesh[j1][l2];
                double d1;
                if(d13 == 0.0D)
                {
                    d1 = 1.5707963267948966D;
                } else
                {
                    d1 = Math.atan(d10 / d13);
                    if(d1 < 0.0D)
                        d1 += 3.1415926535897931D;
                }
                double d5;
                if(d19 == 0.0D)
                {
                    if(d16 > 0.0D)
                        d5 = 1.5707963267948966D;
                    else
                        d5 = -1.5707963267948966D;
                } else
                {
                    d5 = Math.atan(d16 / d19);
                }
                angle0[j1][l2] = angle(d1, d5);
            }

        }

        for(int k1 = 0; k1 < (int)Math.pow(2D, level) - 1; k1++)
        {
            for(int i3 = (int)Math.pow(2D, level) - 2; i3 >= 0; i3--)
            {
                double d11 = ymesh[k1][i3] - ymesh[k1][i3 + 1];
                double d14 = xmesh[k1][i3] - xmesh[k1][i3 + 1];
                double d17 = ymesh[k1 + 1][i3 + 1] - ymesh[k1][i3 + 1];
                double d20 = xmesh[k1 + 1][i3 + 1] - xmesh[k1][i3 + 1];
                double d2;
                if(d14 == 0.0D)
                {
                    d2 = -1.5707963267948966D;
                } else
                {
                    d2 = Math.atan(d11 / d14);
                    if(d2 > 0.0D)
                        d2 -= 3.1415926535897931D;
                }
                double d6;
                if(d20 == 0.0D)
                {
                    if(d17 > 0.0D)
                        d6 = 1.5707963267948966D;
                    else
                        d6 = -1.5707963267948966D;
                } else
                {
                    d6 = Math.atan(d17 / d20);
                }
                angle1[k1][i3] = angle(d2, d6);
            }

        }

        for(int l1 = (int)Math.pow(2D, level) - 2; l1 >= 0; l1--)
        {
            for(int j3 = (int)Math.pow(2D, level) - 2; j3 >= 0; j3--)
            {
                double d12 = ymesh[l1][j3 + 1] - ymesh[l1 + 1][j3 + 1];
                double d15 = xmesh[l1][j3 + 1] - xmesh[l1 + 1][j3 + 1];
                double d18 = ymesh[l1 + 1][j3] - ymesh[l1 + 1][j3 + 1];
                double d21 = xmesh[l1 + 1][j3] - xmesh[l1 + 1][j3 + 1];
                double d3;
                if(d21 == 0.0D)
                {
                    d3 = 1.5707963267948966D;
                } else
                {
                    d3 = Math.atan(d18 / d21);
                    if(d3 < 0.0D)
                        d3 += 3.1415926535897931D;
                }
                double d7;
                if(d15 == 0.0D)
                {
                    if(d12 > 0.0D)
                        d7 = 1.5707963267948966D;
                    else
                        d7 = -1.5707963267948966D;
                } else
                {
                    d7 = Math.atan(d12 / d15);
                }
                angle2[l1][j3] = angle(d3, d7);
            }

        }

        for(int i2 = 0; i2 < (int)Math.pow(2D, level) - 1; i2++)
        {
            for(int k3 = 0; k3 < (int)Math.pow(2D, level) - 1; k3++)
                angle3[i2][k3] = 360D - angle2[i2][k3] - angle1[i2][k3] - angle0[i2][k3];

        }

        for(int j2 = 0; j2 < (int)Math.pow(2D, level); j2++)
        {
            g.setComposite(ac2);
            g.setStroke(solid);
            for(int l3 = 0; l3 < (int)Math.pow(2D, level) - 1; l3++)
                if((xmesh[j2][l3] != 0 || ymesh[j2][l3] != 0) && (xmesh[j2][l3 + 1] != 0 || ymesh[j2][l3 + 1] != 0))
                    g.drawLine(xmesh[j2][l3], ymesh[j2][l3], xmesh[j2][l3 + 1], ymesh[j2][l3 + 1]);

        }

        for(int k2 = 0; k2 < (int)Math.pow(2D, level); k2++)
        {
            for(int i4 = 0; i4 < (int)Math.pow(2D, level) - 1; i4++)
                if((xmesh[i4][k2] != 0 || ymesh[i4][k2] != 0) && (xmesh[i4 + 1][k2] != 0 || ymesh[i4 + 1][k2] != 0))
                    g.drawLine(xmesh[i4][k2], ymesh[i4][k2], xmesh[i4 + 1][k2], ymesh[i4 + 1][k2]);

        }

    }

    public double angle(double d, double d1)
    {
        return (Math.abs(d - d1) * 180D) / 3.1415926535897931D;
    }

    public double getAngle(int i, int j)
    {
        int ai[] = new int[4];
        int ai1[] = new int[4];
        for(int k = 0; k < (int)Math.pow(2D, level) - 1; k++)
        {
            for(int l = 0; l < (int)Math.pow(2D, level) - 1; l++)
            {
                ai[0] = xmesh[k][l];
                ai[1] = xmesh[k][l + 1];
                ai[2] = xmesh[k + 1][l + 1];
                ai[3] = xmesh[k + 1][l];
                ai1[0] = ymesh[k][l];
                ai1[1] = ymesh[k][l + 1];
                ai1[2] = ymesh[k + 1][l + 1];
                ai1[3] = ymesh[k + 1][l];
                Polygon polygon = new Polygon(ai, ai1, 4);
                if(!polygon.contains(i, j))
                    continue;
                double d = Math.sqrt(Math.pow(j - ai1[0], 2D) + Math.pow(i - ai[0], 2D));
                double d1 = Math.sqrt(Math.pow(j - ai1[1], 2D) + Math.pow(i - ai[1], 2D));
                double d2 = Math.sqrt(Math.pow(j - ai1[2], 2D) + Math.pow(i - ai[2], 2D));
                double d3 = Math.sqrt(Math.pow(j - ai1[3], 2D) + Math.pow(i - ai[3], 2D));
                if(d < d1 && d < d2 && d < d3)
                    return angle0[k][l];
                if(d1 < d && d1 < d2 && d1 < d3)
                    return angle1[k][l];
                if(d2 < d1 && d2 < d && d2 < d3)
                    return angle2[k][l];
                if(d3 < d1 && d3 < d2 && d3 < d)
                    return angle3[k][l];
            }

        }

        return 0.0D;
    }

    public int meshcount(int i, int j)
    {
        int ai[] = new int[4];
        int ai1[] = new int[4];
        int k = 0;
        for(int l = 0; l < (int)Math.pow(2D, level) - 1; l++)
        {
            for(int i1 = 0; i1 < (int)Math.pow(2D, level) - 1; i1++)
            {
                ai[0] = xmesh[l][i1];
                ai[1] = xmesh[l][i1 + 1];
                ai[2] = xmesh[l + 1][i1 + 1];
                ai[3] = xmesh[l + 1][i1];
                ai1[0] = ymesh[l][i1];
                ai1[1] = ymesh[l][i1 + 1];
                ai1[2] = ymesh[l + 1][i1 + 1];
                ai1[3] = ymesh[l + 1][i1];
                Polygon polygon = new Polygon(ai, ai1, 4);
                if(polygon.contains(i, j))
                {
                    for(int j1 = 0; j1 < xp.length; j1++)
                        if(polygon.contains((int)xp[j1], (int)yp[j1]))
                            k++;

                    return k;
                }
            }

        }

        return 0;
    }

    public void mousePressed(MouseEvent mouseevent)
    {
    }

    public void mouseReleased(MouseEvent mouseevent)
    {
    }

    public void mouseEntered(MouseEvent mouseevent)
    {
    }

    public void mouseExited(MouseEvent mouseevent)
    {
    }
     	
    public void nMercount(int xc[], int yc[], int numCount)
    {
    	
    	if(numCount != 0)
    		return;
    	if(issplit!=1)
    	{
    		//System.out.println("if(issplit!=1)");
    		return;
    	}
    	try{
    		
			File file= new File("./nMerCount/nMerCount.txt");
			File file1= new File("./nMerCount/temp.txt");
			//file.createNewFile();
			FileWriter fw= new FileWriter(file);
			fw.flush();
			fw.close();
			file.delete();
			FileWriter fw1= new FileWriter(file1);
			//file.createNewFile();
			
			//System.out.println("nMercount");
			ns=0;
    	//System.out.println(numCount);
    	

    	//System.out.println(" xc[0]  is = "+xc[0]+" yc[0] is =  " +yc[0]);
       // System.out.println(" xc[1]  is = "+xc[1]+" yc[1] is =  " +yc[1]);
       // System.out.println(" xc[2]  is = "+xc[2]+" yc[2] is =  " +yc[2]);
       // System.out.println(" xc[3]  is = "+xc[3]+" yc[3] is =  " +yc[3]);
       // System.out.println("ends ...");
        Polygon polygon1 = new Polygon(xc, yc, xc.length);
        for(int i2 = 0; i2 < xp.length; i2++)
        { 
        	if(polygon1.contains((int)xp[i2], (int)yp[i2]))
        	{
        	numCount++;
          if (ns==0)
        {        	
        		double d2 = 262144D;
        		int j1 = 0;
        		ns=1;
        		for(int i3 = 0; i3 < xp.length; i3++)
        		{
        			double d1 = ((double)xp[i3] - xp[i2]) * ((double)xp[i3] - xp[i2]) + ((double)yp[i3] - yp[i2]) * ((double)yp[i3] - yp[i2]);
        			if(d1 < d2)
        			{
                    d2 = d1;
                    j1 = i3;
        			}
        			
        		}

            if(d2 < 10D)
         		{
            	j1++;
            	s=null;

                //if((j1 - level)< 0)
                //	j1 = level;  
            	//System.out.println("??????????????");
            	//System.out.println(j1);
               // System.out.println(j1 - level);
                s =( SeqStr.substring(Math.max(j1 - level, 0), j1));
   
            	//System.out.println("###string ###"+s);
         		}
        	}
           	} 
        }
        		if(numCount>0)
        		{
        			System.out.println("string "+s+" - "+numCount); 
        			ss =ss +" ,"+ s +"_"+numCount;
        			//System.out.println("ss is --- %s"+ss);
        			//fw.write(ss);
        			fw1.append(ss);
        			fw1.flush();
        		}
            	fw1.close();
            	file1.renameTo(file);
            	file1.delete();
        		
            	//System.out.println("numCOunt is = "+numCOunt);  	
            	//char c1= (char)numCOunt;
            	//String s1= c1;
        		
        		
        		}
        		
        		
            	//byte abyte0[] = ss.getBytes();
               // fileoutputstream.write(abyte0);
               // fileoutputstream.close();
                catch(Exception e){}
          
    }

    public void mouseClicked(MouseEvent mouseevent)
    {
    	
    	if(count)
        {
            int i = mouseevent.getX();
            int j = mouseevent.getY();
            System.out.println("mouseevent.getX()"+i);
            //nMercount(i,j);
            System.out.println(" i, j is "+i+"         " +j);
            if(Multiplot)
            {
                double d = (double)mouseevent.getX() * 1.2864321599999999D;
                double d1 = (double)mouseevent.getY() * 1.2864321599999999D;
                i = (int)d;
                j = (int)d1;
            }
           // xcount.add(new Integer(i));
          
           // ycount.add(new Integer(j));
            if(Corners == 4 && counttype)
            {
                int ai[] = new int[4];
                int ai2[] = new int[4];
                int k = (int)((double)(x[1] - x[0]) / Math.pow(2D, level));
                int i1 = (int)((double)(y[0] - y[3]) / Math.pow(2D, level));
                for(int k1 = x[0]; k1 < x[1]; k1 += k)
                    if(i >= k1 && i < k1 + k)
                    {
                        ai[0] = k1;
                        ai[1] = k1 + k;
                        ai[2] = k1 + k;
                        ai[3] = k1;
                    }

                	for(int l1 = y[3]; l1 < y[0]; l1 += i1)
                    if(j >= l1 && j < l1 + i1)
                    {
                        ai2[0] = l1 + i1;
                        ai2[1] = l1 + i1;
                        ai2[2] = l1;
                        ai2[3] = l1;
                    }
                g.setComposite(ac2);
                g.setStroke(solid);
                clearPlot();
                g.setComposite(ac);
                //g.setColor(Color.YELLOW);
                Polygon polygon1 = new Polygon(ai, ai2, ai.length);
               // g.fillPolygon(polygon1);
                g.setComposite(ac2);
                g.setStroke(solid);
               plot();
               // split(x, y, level);
                // count = false;
                //obj.nmerCount.setEnabled(false);
                //obj.CountButton.setEnabled(false);
                //lllklklklklklk
                repaint();
                for(int i2 = 0; i2 < xp.length; i2++)
                    if(polygon1.contains((int)xp[i2], (int)yp[i2]))
                        countpoints++; 
                //obj.displayCount(countpoints,s);

                xcount = new ArrayList();
                ycount = new ArrayList();
                
                Point point = mouseevent.getPoint();
                double d2 = 262144D;
                int j1 = 0;
                for(int i2 = 0; i2 < xp.length; i2++)
                {
                    double d1 = ((double)xp[i2] - point.getX()) * ((double)xp[i2] - point.getX()) + ((double)yp[i2] - point.getY()) * ((double)yp[i2] - point.getY());
                    if(d1 < d2)
                    {
                        d2 = d1;
                        j1 = i2;
                    }
                }
                 
                 if(d2 < 10D)
                {
                    j1++;
                    System.out.println(j1);
                    System.out.println(j1 - level);
                   s =( SeqStr.substring(Math.max(j1 - level, 0), j1));
                   
                }
                System.out.println("Nmer and Count is "+s +countpoints);
                System.out.println("Nmer and Count is ***************");      
                //JOptionPane.showMessageDialog(getContentPane(),String.valueOf(drawing1.countpoints),"No of n-mer"+drawing1.s,1);
       		 
                obj.displayCount(countpoints,s);
                s="";
                
            }
            
            else
            {
                if(xcount.size() > 1)
                {
                    g.setComposite(ac);
                    g.setStroke(dashed);
                    g.drawLine(i, j, ((Integer)xcount.get(xcount.size() - 2)).intValue(), ((Integer)ycount.get(xcount.size() - 2)).intValue());
                    g.setStroke(solid);
                    repaint();
                }
               /* if(mouseevent.getButton() == 3)
                {
                    //count = false;
                    int ai1[] = new int[xcount.size()];
                    int ai3[] = new int[ycount.size()];
                    for(int l = 0; l < xcount.size(); l++)
                    {
                        ai1[l] = ((Integer)xcount.get(l)).intValue();
                        ai3[l] = ((Integer)ycount.get(l)).intValue();
                    }

                    g.setComposite(ac2);
                    g.setStroke(solid);
                    clearPlot();
                    g.setComposite(ac);
                    g.setColor(Color.YELLOW);
                    Polygon polygon = new Polygon(ai1, ai3, ai1.length);
                    g.fillPolygon(polygon);
                    clearPlot();
                    g.setComposite(ac2);
                    g.setStroke(solid);
                    plot();
                    split(x, y, level);
                    repaint();
                    for(int j1 = 0; j1 < xp.length; j1++)
                        if(polygon.contains((int)xp[j1], (int)yp[j1]))
                            countpoints++;

                    xcount = new ArrayList();
                    ycount = new ArrayList();
                    //obj.displayCount(countpoints,s);
                }*/
            }
        }
    }

    public void mouseDragged(MouseEvent mouseevent)
    {
    }

    public void mouseMoved(MouseEvent mouseevent)
    {
       // int i = ZoomLevel;
        Point point = mouseevent.getPoint();
        double d2 = 262144D;
        int j = 0;
    //    int k = 0;
        //for(; zxp[i] == null && i != 0; i--);
        
        
        
        //++++++++++++++++
        /*
        if(zxp[i] != null)
        {
            for(int l = 0; l < zxp[i].length; l++)
            {
                double d = (zxp[i][l] - point.getX()) * (zxp[i][l] - point.getX()) + (zyp[i][l] - point.getY()) * (zyp[i][l] - point.getY());
                if(d < d2)
                {
                    d2 = d;
                    k = l;
                }
            }

            j = zip[i][k];
            if(d2 < 10D)
            {
                j++;
                setToolTipText(j + "++:" + SeqStr.substring(Math.max(j - 10, 0), j));
            }
        } else
        {*/
            for(int i1 = 0; i1 < xp.length; i1++)
            {
                double d1 = ((double)xp[i1] - point.getX()) * ((double)xp[i1] - point.getX()) + ((double)yp[i1] - point.getY()) * ((double)yp[i1] - point.getY());
                if(d1 < d2)
                {
                    d2 = d1;
                    j = i1;
                }
            }

            if(d2 < 10D)
            {
                j++;
                setToolTipText(j + ":" + SeqStr.substring(Math.max(j -10, 0), j));
            }
        }
    //}

    public void paintComponent(Graphics g1)
    {
        update(g1);
    }

    public void update(Graphics g1)
    {
        super.paintComponent(g1);
        Graphics2D graphics2d = (Graphics2D)g1;
        if(bi != null)
        {
            graphics2d.setBackground(Color.WHITE);
            if(Multiplot)
                graphics2d.scale(0.77734375D, 0.77734375D);
            if(DoZoom)
            {
              //  byte byte0 = 22;
              //  byte byte2 = 20;
                for(int i = 0; i < Corners; i++)
                    switch(i)
                    {
                    case 0: // '\0'
                        tf0.setVisible(false);
                        break;

                    case 1: // '\001'
                        tf1.setVisible(false);
                        break;

                    case 2: // '\002'
                        tf2.setVisible(false);
                        break;

                    case 3: // '\003'
                        tf3.setVisible(false);
                        break;

                    case 4: // '\004'
                        tf4.setVisible(false);
                        break;

                    case 5: // '\005'
                        tf5.setVisible(false);
                        break;

                    case 6: // '\006'
                        tf6.setVisible(false);
                        break;

                    case 7: // '\007'
                        tf7.setVisible(false);
                        break;

                    case 8: // '\b'
                        tf8.setVisible(false);
                        break;

                    case 9: // '\t'
                        tf9.setVisible(false);
                        break;

                    case 10: // '\n'
                        tf10.setVisible(false);
                        break;

                    case 11: // '\013'
                        tf11.setVisible(false);
                        break;

                    case 12: // '\f'
                        tf12.setVisible(false);
                        break;

                    case 13: // '\r'
                        tf13.setVisible(false);
                        break;

                    case 14: // '\016'
                        tf14.setVisible(false);
                        break;

                    case 15: // '\017'
                        tf15.setVisible(false);
                        break;

                    case 16: // '\020'
                        tf16.setVisible(false);
                        break;

                    case 17: // '\021'
                        tf17.setVisible(false);
                        break;

                    case 18: // '\022'
                        tf18.setVisible(false);
                        break;

                    case 19: // '\023'
                        tf19.setVisible(false);
                        break;
                    }

                graphics2d.drawImage(Zooming(drag, drop, ZoomLevel, zoom), null, 0, 0);
            } else
            {
                if(label == 0)
                    labelCorners();
                byte byte1 = 22;
                byte byte3 = 20;
                for(int j = 0; j < Corners; j++)
                    switch(j)
                    {
                    case 0: // '\0'
                        tf0.setBounds(x2[j], y2[j], byte1, byte3);
                        tf0.setVisible(true);
                        break;

                    case 1: // '\001'
                        tf1.setBounds(x2[j], y2[j], byte1, byte3);
                        tf1.setVisible(true);
                        break;

                    case 2: // '\002'
                        tf2.setBounds(x2[j], y2[j], byte1, byte3);
                        tf2.setVisible(true);
                        break;

                    case 3: // '\003'
                        tf3.setBounds(x2[j], y2[j], byte1, byte3);
                        tf3.setVisible(true);
                        break;

                    case 4: // '\004'
                        tf4.setBounds(x2[j], y2[j], byte1, byte3);
                        tf4.setVisible(true);
                        break;

                    case 5: // '\005'
                        tf5.setBounds(x2[j], y2[j], byte1, byte3);
                        tf5.setVisible(true);
                        break;

                    case 6: // '\006'
                        tf6.setBounds(x2[j], y2[j], byte1, byte3);
                        tf6.setVisible(true);
                        break;

                    case 7: // '\007'
                        tf7.setBounds(x2[j], y2[j], byte1, byte3);
                        tf7.setVisible(true);
                        break;

                    case 8: // '\b'
                        tf8.setBounds(x2[j], y2[j], byte1, byte3);
                        tf8.setVisible(true);
                        break;

                    case 9: // '\t'
                        tf9.setBounds(x2[j], y2[j], byte1, byte3);
                        tf9.setVisible(true);
                        break;

                    case 10: // '\n'
                        tf10.setBounds(x2[j], y2[j], byte1, byte3);
                        tf10.setVisible(true);
                        break;

                    case 11: // '\013'
                        tf11.setBounds(x2[j], y2[j], byte1, byte3);
                        tf11.setVisible(true);
                        break;

                    case 12: // '\f'
                        tf12.setBounds(x2[j], y2[j], byte1, byte3);
                        tf12.setVisible(true);
                        break;

                    case 13: // '\r'
                        tf13.setBounds(x2[j], y2[j], byte1, byte3);
                        tf13.setVisible(true);
                        break;

                    case 14: // '\016'
                        tf14.setBounds(x2[j], y2[j], byte1, byte3);
                        tf14.setVisible(true);
                        break;

                    case 15: // '\017'
                        tf15.setBounds(x2[j], y2[j], byte1, byte3);
                        tf15.setVisible(true);
                        break;

                    case 16: // '\020'
                        tf16.setBounds(x2[j], y2[j], byte1, byte3);
                        tf16.setVisible(true);
                        break;

                    case 17: // '\021'
                        tf17.setBounds(x2[j], y2[j], byte1, byte3);
                        tf17.setVisible(true);
                        break;

                    case 18: // '\022'
                        tf18.setBounds(x2[j], y2[j], byte1, byte3);
                        tf18.setVisible(true);
                        break;

                    case 19: // '\023'
                        tf19.setBounds(x2[j], y2[j], byte1, byte3);
                        tf19.setVisible(true);
                        break;
                    }

                graphics2d.drawImage(bi, null, 0, 0);
            }
        }
    }

    public boolean isSelected(double d, double d1)
    {
        return d >= Math.min(drag.getX(), drop.getX()) && d < Math.max(drag.getX(), drop.getX()) && d1 >= Math.min(drag.getY(), drop.getY()) && d1 < Math.max(drag.getY(), drop.getY());
    }

    public BufferedImage Zooming(Point point, Point point1, int i, boolean flag)
    {
        int ai[] = new int[5];
        int ai1[] = new int[5];
        ai[0] = 30;
        ai1[0] = 482;
        ai[1] = 452;
        ai1[1] = 482;
        ai[2] = 482;
        ai1[2] = 0;
        ai[3] = 30;
        ai1[3] = 30;
        BufferedImage bufferedimage = new BufferedImage(512, 512, 2);
        Graphics2D graphics2d = (Graphics2D)bufferedimage.getGraphics();
        graphics2d.setBackground(SystemColor.control);
        graphics2d.setColor(Color.WHITE);
        graphics2d.fillRect(30, 30, 452, 452);
        if(flag)
        {
            if(i == 0)
            {
                for(int j = 0; j < zxp.length; j++)
                {
                    zxp[j] = null;
                    zyp[j] = null;
                }

                int k = 0;
                int j1 = 0;
                int l1 = 0;
                for(; j1 < xp.length; j1++)
                    if(isSelected(xp[j1], yp[j1]))
                        k++;

                sxp = new double[k];
                syp = new double[k];
                sip = new int[k];
                j1 = 0;
                l1 = 0;
                for(; j1 < xp.length; j1++)
                    if(isSelected(xp[j1], yp[j1]))
                    {
                        sxp[l1] = xp[j1];
                        syp[l1] = yp[j1];
                        sip[l1] = j1;
                        l1++;
                    }

            } else
            if(i > 0)
            {
                int l = 0;
                int k1 = 0;
                int i2 = 0;
                for(; k1 < zxp[i - 1].length; k1++)
                    if(isSelected(zxp[i - 1][k1], zyp[i - 1][k1]))
                        l++;

                sxp = new double[l];
                syp = new double[l];
                k1 = 0;
                i2 = 0;
                for(; k1 < zxp[i - 1].length; k1++)
                    if(isSelected(zxp[i - 1][k1], zyp[i - 1][k1]))
                    {
                        sxp[i2] = zxp[i - 1][k1];
                        syp[i2] = zyp[i - 1][k1];
                        sip[i2] = zip[i - 1][k1];
                        i2++;
                    }

            }
            double d = Math.min(point.getX(), point1.getX());
            double d1 = Math.min(point.getY(), point1.getY());
            double d2 = Math.abs(point1.getX() - point.getX());
            double d3 = Math.abs(point1.getY() - point.getY());
            if(i >= 0)
            {
                zxp[i] = new double[sxp.length];
                zyp[i] = new double[syp.length];
                zip[i] = new int[sip.length];
                for(int j2 = 0; j2 < sxp.length; j2++)
                {
                    zxp[i][j2] = ((sxp[j2] - d) / d2) * 452D;
                    zyp[i][j2] = ((syp[j2] - d1) / d3) * 452D;
                    zip[i][j2] = sip[j2];
                    zxp[i][j2] += 30D;
                    zyp[i][j2] += 30D;
                }

            }
            graphics2d.setColor(Color.BLACK);
            graphics2d.drawRect(30, 30, 452, 452);
            graphics2d.setColor(Color.RED);
            for(int k2 = 0; k2 < zxp[i].length; k2++)
                graphics2d.fillOval((int)zxp[i][k2], (int)zyp[i][k2], dotSize + 2, dotSize + 2);

        } else
        if(!flag)
        {
            zxp[i] = null;
            zyp[i] = null;
            if(i > 0)
            {
                graphics2d.setColor(Color.BLACK);
                graphics2d.drawRect(30, 30, 452, 452);
                graphics2d.setColor(Color.RED);
                for(int i1 = 0; i1 < zxp[i - 1].length; i1++)
                    graphics2d.fillOval((int)zxp[i - 1][i1], (int)zyp[i - 1][i1], dotSize + 2, dotSize + 2);

            } else
            {
                bufferedimage = bi;
            }
        }
        return bufferedimage;
    }

    public void setZoomLevel(Point point, Point point1, int i, boolean flag, boolean flag1)
    {
        drag = point;
        drop = point1;
        ZoomLevel = i;
        zoom = flag;
        DoZoom = flag1;
    }

    public void setTestSeqColor(Color color)
    {	if (TestSeqStr != null)
    	{
        TestSeqColor = new int[TestSeqStr.length()][];
        SeqColor = new int[TestSeqStr.length()][];
        for(int i = 0; i < TestSeqColor.length; i++)
        {
            TestSeqColor[i] = new int[3];
            SeqColor[i] = new int[3];
            TestSeqColor[i][0] = color.getRed();
            TestSeqColor[i][1] = color.getGreen();
            TestSeqColor[i][2] = color.getBlue();
            SeqColor[i] = TestSeqColor[i];
        }
    	}
    }

    public void removeTextFields()
    {
        remove(tf0);
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

    public void setSeqType(String s)
    {
        SeqType = s;
    }

    public String getSeqType()
    {
        return SeqType;
    }

    public void setSeqStr(String s)
    {
        SeqStr = s;
    }

    public String getSeqStr()
    {
        return SeqStr;
    }

    public void setCorners(int i)
    {
        Corners = i;
    }

    public int getCorners()
    {
        return Corners;
    }

    public void setDistribution(String as[])
    {
        Distr = as;
    }

    public String[] getDistribution()
    {
        return Distr;
    }

    public void setTestSeqType(String s)
    {
    	 TestSeqType = s;
    	 
    }

    public String getTestSeqType()
    {
        return TestSeqType;
    }

    public void setTestSeqStr(String s)
    {
   
        TestSeqStr = s;
    }

   /* public void setTextSeqColor(Color c)

   {
		TestSeqStr.setSelectedTextColor(c);
    } */

    public String getTestSeqStr()
    {
        return TestSeqStr;
    }

    public void setPlotShape(int i)
    {
    	PlotShapeIndex=i;    	
    }
    
    public void setTestCorners(int i)
    {
        TestCorners = i;
    }

    public void setGroupSel(int i)
    {
        GroupSelection = i;
    }
    
    public int getTestCorners()
    {
        return TestCorners;
    }

    public void setTestDistribution(String as[])
    {
        TestDistr = as;
    }

    public String[] getTestDistribution()
    {
        return TestDistr;
    }

    public void setTestDistrName(String s)
    {
        TestDistrName = s;
    }

    public String getTestDistrName()
    {
        return TestDistrName;
    }

    public void setDistrName(String s)
    {
        DistrName = s;
    }

    public String getDistrName()
    {
        return DistrName;
    }

    public void setMultiplot(boolean flag)
    {
        Multiplot = flag;
    }

    public boolean getMultiplot()
    {
        return Multiplot;
    }

    public float[] getxp()
    {
        return xp;
    }

    public float[] getyp()
    {
        return yp;
    }

    public void setSuperxp(float af[])
    {
        Superxp = af;
    }

    public void setSuperyp(float af[])
    {
        Superyp = af;
    }

    public void setcounttype(boolean flag)
    {
        counttype = flag;
        count = true;
    }

    public void setMainFrameObject(CGRexMainGUI maingui)
    {
        obj = maingui;
    }

    public BufferedImage getImage()
    {
        return bi;
    }

    public int getZoomLevel()
    {
        return ZoomLevel;
    }

    public void setZoomLevel(int i)
    {
        ZoomLevel = i;
    }

    public double[][] getzxp()
    {
        return zxp;
    }

    public void setzxp(double ad[][])
    {
        zxp = ad;
    }

    public double[][] getzyp()
    {
        return zyp;
    }

    public void setzyp(double ad[][])
    {
        zyp = ad;
    }

    public int[][] getTestSeqColor()
    {
        return TestSeqColor;
    }

    public void setTestSeqColor(int ai[][])
    {
        TestSeqColor = ai;
    }

    public void setSplit(int i)
    {
        level = i;
    }

    public int getSplit()
    {
        return level;
    }

    public void setDotSize(int i)
    {
        dotSize = i;
    }    
    
}
