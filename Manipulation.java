// FrontEnd Plus GUI for JAD
// DeCompiled : Manipulation.class
//package CGRexpack;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
//import java.io.PrintStream;
import java.util.ArrayList;


class Manipulation
    implements MouseListener
{
	public static final long serialVersionUID = 0;
    BufferedImage bi;
    BufferedImage temp;
    Graphics2D g;
    int view;
    static String seqtype = new String();
    String seq;
    static String distStr[] = new String[20];
    char dist[][];
    String stng;
    int width;
    int height;
    static int level = 0;
    static int corners;
    static int numPoints;
    static int x[] = null;
    static int y[] = null;
    int i;
    Polygon p;
    Polygon q;
    boolean flag;
    int countpoints;
    ArrayList xcount;
    ArrayList ycount;
    int k;
    Color drawColor;
    static float xp[];
    static float yp[];
    int xOffset;
    int yOffset;
    boolean counttype;

    public Manipulation(String s, String s1, int j, int l)
    {
        g = null;
        seq = "ABCDEFABCDEF";
        dist = new char[20][20];
        stng = null;
        width = 512;
        height = 512;
        i = 1;
        flag = false;
        countpoints = 0;
        xcount = new ArrayList();
        ycount = new ArrayList();
        xOffset = width / 2;
        yOffset = height / 2;
        counttype = false;
      //  Manipulation _tmp = this;
        seqtype = s;
        stng = s1;
        width = j;
        height = l;
        xOffset = j / 2;
        yOffset = l / 2;
        if(bi == null)
        {
            bi = new BufferedImage(j, l, 2);
            g = bi.createGraphics();
            g.setBackground(Color.WHITE);
            g.setColor(Color.WHITE);
            g.fillRect(0, 0, 512, 512);
        }
        System.out.println("seq type= " + s);
    }

    public Manipulation(String s, int j, int l, int i1)
    {
        g = null;
        seq = "ABCDEFABCDEF";
        dist = new char[20][20];
        stng = null;
        width = 512;
        height = 512;
        i = 1;
        flag = false;
        countpoints = 0;
        xcount = new ArrayList();
        ycount = new ArrayList();
        xOffset = width / 2;
        yOffset = height / 2;
        counttype = false;
        stng = s;
        view = j;
        width = l;
        height = i1;
        xOffset = l / 2;
        yOffset = i1 / 2;
    }

    public Manipulation(String s, int j, int l)
    {
        g = null;
        seq = "ABCDEFABCDEF";
        dist = new char[20][20];
        stng = null;
        width = 512;
        height = 512;
        i = 1;
        flag = false;
        countpoints = 0;
        xcount = new ArrayList();
        ycount = new ArrayList();
        xOffset = width / 2;
        yOffset = height / 2;
        counttype = false;
        stng = s;
        width = j;
        height = l;
        xOffset = j / 2;
        yOffset = l / 2;
        if(bi == null)
        {
            bi = new BufferedImage(j, l, 2);
            g = bi.createGraphics();
            g.setBackground(Color.WHITE);
            g.setColor(Color.WHITE);
            g.fillRect(0, 0, 512, 512);
        }
    }

    public Manipulation(String s, boolean flag1, int j, int l, DrawingAreaI drawingareai)
    {
        g = null;
        seq = "ABCDEFABCDEF";
        dist = new char[20][20];
        stng = null;
        width = 512;
        height = 512;
        i = 1;
        flag = false;
        countpoints = 0;
        xcount = new ArrayList();
        ycount = new ArrayList();
        xOffset = width / 2;
        yOffset = height / 2;
        counttype = false;
        stng = s;
        width = j;
        height = l;
        flag = flag1;
        xOffset = j / 2;
        yOffset = l / 2;
        if(bi == null)
        {
            bi = new BufferedImage(j, l, 2);
            g = bi.createGraphics();
            g.setBackground(Color.WHITE);
            g.setColor(Color.WHITE);
            g.fillRect(0, 0, 512, 512);
        }
        getdata();
        drawPoly(p);
        plot();
        drawingareai.addMouseListener(this);
    }

    public Manipulation(String s, boolean flag1, int j, int l, DrawingAreaI drawingareai, boolean flag2)
    {
        g = null;
        seq = "ABCDEFABCDEF";
        dist = new char[20][20];
        stng = null;
        width = 512;
        height = 512;
        i = 1;
        flag = false;
        countpoints = 0;
        xcount = new ArrayList();
        ycount = new ArrayList();
        xOffset = width / 2;
        yOffset = height / 2;
        counttype = false;
        stng = s;
        width = j;
        height = l;
        flag = flag1;
        counttype = flag2;
        xOffset = j / 2;
        yOffset = l / 2;
        if(bi == null)
        {
            bi = new BufferedImage(j, l, 2);
            g = bi.createGraphics();
            g.setBackground(Color.WHITE);
            g.setColor(Color.WHITE);
            g.fillRect(0, 0, 512, 512);
        }
        getdata();
        drawPoly(p);
        plot();
        drawingareai.addMouseListener(this);
    }

    public BufferedImage compute()
    {
        g.setColor(Color.BLACK);
        getdata();
        drawPoly(p);
        plot();
        return bi;
    }

    public BufferedImage computewithsplit(int j)
    {
     //   Manipulation _tmp = this;
        level = j;
        g.setColor(Color.BLACK);
        getdata();
        drawPoly(p);
        plot();
        split(x, y, j);
        return bi;
    }

    public BufferedImage getPoly()
    {
        g.setBackground(SystemColor.control);
        g.setColor(SystemColor.control);
        g.fillRect(0, 0, 512, 512);
        g.setColor(Color.BLACK);
        getdata();
        drawPoly(p);
        return bi;
    }

    public BufferedImage addColor(int j, int l, Color color)
    {
        byte byte0 = 2;
        g.setColor(Color.BLACK);
        Polygon polygon = new Polygon(x, y, numPoints);
        g.drawPolygon(polygon);
        for(int i1 = 0; i1 < stng.length(); i1++)
        {
            g.setColor(Color.BLACK);
            if(i1 >= j && i1 < l)
                g.setColor(color);
            g.drawOval((int)xp[i1], (int)yp[i1], byte0, byte0);
        }

        return bi;
    }

    public void getdata()
    {
        try
        {
            if(seqtype.equalsIgnoreCase("DNA"))
                seq = stng;
            else
            if(seqtype.equalsIgnoreCase("RNA"))
            {
                seq = stng;
            } else
            {
                System.out.println("corners = " + corners);
                for(int j = 0; j < corners; j++)
                    System.out.println(distStr[j]);

                seq = stng;
                numPoints = corners + 1;
            }
        }
        catch(Exception exception)
        {
            exception.printStackTrace();
        }
    }

    public void drawPoly(Polygon polygon)
    {
        g.setColor(null);
        x = new int[numPoints];
        y = new int[numPoints];
        int j = 0;
        double d = 6.2831853071795862D / (double)corners;
        if(corners == 4)
            j = (int)((double)yOffset * 1.25D);
        else
            j = (int)((double)yOffset * 0.84999999999999998D);
        double d1 = (double)(2 + corners) / (double)(2 * corners);
        double d2 = d1 * 3.1415926535897931D;
        for(int l = 0; l < numPoints; l++)
        {
            x[l] = (int)((double)j * Math.cos((6.2831853071795862D - d * (double)l) + d2)) + xOffset;
            y[l] = (int)((double)j * Math.sin((6.2831853071795862D - d * (double)l) + d2)) + yOffset;
        }

        polygon = new Polygon(x, y, numPoints);
        g.drawPolygon(polygon);
    }

    public void plot()
    {
        for(int j = 0; j < 20; j++)
        {
            for(int j1 = 0; j1 < 20; j1++)
                dist[j][j1] = '\0';

        }

        for(int l = 0; l < corners; l++)
        {
            for(int k1 = 0; k1 < distStr[l].length(); k1++)
                dist[l][k1] = distStr[l].charAt(k1);

        }

label0:
        for(int i1 = 0; i1 < corners; i1++)
        {
            int l1 = 0;
            do
            {
                if(l1 >= distStr[i1].length())
                    continue label0;
                if(seq.charAt(0) == dist[i1][l1])
                {
                    k = i1;
                    continue label0;
                }
                l1++;
            } while(true);
        }

        xp = new float[seq.length()];
        yp = new float[seq.length()];
        xp[0] = (xOffset + x[k]) / 2;
        yp[0] = (yOffset + y[k]) / 2;
        byte byte0 = 2;
        g.drawOval((int)xp[0], (int)yp[0], byte0, byte0);
        for(int i2 = 1; i2 < seq.length(); i2++)
        {
label1:
            for(int j2 = 0; j2 < corners; j2++)
            {
                int k2 = 0;
                do
                {
                    if(k2 >= 20)
                        continue label1;
                    if(seq.charAt(i2) == dist[j2][k2])
                    {
                        k = j2;
                        continue label1;
                    }
                    k2++;
                } while(true);
            }

            xp[i2] = (xp[i2 - 1] + (float)x[k]) / 2.0F;
            yp[i2] = (yp[i2 - 1] + (float)y[k]) / 2.0F;
            g.drawOval((int)xp[i2], (int)yp[i2], byte0, byte0);
        }

    }

    public BufferedImage movieMaker(int j, int l, int i1)
    {
        byte byte0 = 2;
        if(temp == null || i1 == 0)
        {
            g.setColor(Color.WHITE);
            g.fillRect(0, 0, 512, 512);
            Polygon polygon = new Polygon(x, y, numPoints);
            g.setColor(Color.BLACK);
            g.drawPolygon(polygon);
        }
        if(i1 == 1 && temp != null)
            g.drawImage(temp, null, 0, 0);
        for(int j1 = j; j1 <= l; j1++)
        {
            g.setColor(Color.BLACK);
            g.drawOval((int)xp[j1], (int)yp[j1], byte0, byte0);
        }

        temp = bi;
        return bi;
    }

    public BufferedImage SuperImpose(String s, String s1, String s2, String s3)
    {
        seqtype = s3;
        stng = s2;
        g.setColor(Color.WHITE);
        g.fillRect(0, 0, 512, 512);
        Polygon polygon = new Polygon(x, y, numPoints);
        g.setColor(Color.BLACK);
        g.drawPolygon(polygon);
        getdata();
        drawPoly(polygon);
        plot();
        String as[] = null;
        String as1[] = null;
        as1 = distStr;
        if(s1.equalsIgnoreCase("DNA"))
        {
            String as2[] = {
                "A", "G", "T", "C"
            };
            as = as2;
        } else
        if(s1.equalsIgnoreCase("RNA"))
        {
            String as3[] = {
                "A", "G", "U", "C"
            };
            as = as3;
        } else
        if(s1.equalsIgnoreCase("Amino Acid"))
        {
           new KmeansTest("Hydrophobicity", corners);
            as = KmeansTest.getDist();
           // as = KmeansTest.getDist();
        }
        setDistribution(as);
        seqtype = s1;
        stng = s;
        g.setColor(Color.RED);
        getdata();
        plot();
        String as4[] = {
            "Shape:" + getCorners(), "Sequence Type:" + getSeqType(), "Name of sequence:Collagen", "_Points Assignment"
        };
        String as5[] = new String[as4.length + as.length];
        for(int j = 0; j < as4.length; j++)
            as5[j] = new String(as4[j]);

        for(int l = as4.length; l < as4.length + as.length; l++)
            if(as[l - as4.length].trim().equals(""))
                as5[l] = new String(" ");
            else
                as5[l] = new String(as[l - as4.length]);

        for(int i1 = 0; i1 < as5.length; i1++)
            System.out.println(as5[i1]);


        SeqTypeConvertionGUI.settingsPanel1 = new settingsPanel("Settings", as5, 400, 530, 398, 140);
        setDistribution(as1);
        return bi;
    }

    public void split(int ai[], int ai1[], int j)
    {
        AlphaComposite alphacomposite = AlphaComposite.getInstance(2, 0.25F);
        g.setComposite(alphacomposite);
        if(j == 0)
            return;
        int ai2[] = new int[corners];
        int ai3[] = new int[corners];
        if(corners != 4)
        {
            for(int l = 0; l < corners; l++)
            {
                for(int i1 = 0; i1 < corners; i1++)
                {
                    ai2[i1] = (ai[l] + ai[l + i1 >= corners ? (l + i1) - corners : l + i1]) / 2;
                    ai3[i1] = (ai1[l] + ai1[l + i1 >= corners ? (l + i1) - corners : l + i1]) / 2;
                }

                for(int j1 = 0; j1 < corners; j1++)
                {
                    if(l == 0)
                        g.setColor(Color.BLUE);
                    else
                    if(l == 1)
                        g.setColor(Color.RED);
                    else
                    if(l == 2)
                        g.setColor(Color.MAGENTA);
                    else
                    if(l == 3)
                        g.setColor(Color.ORANGE);
                    else
                    if(l == 4)
                        g.setColor(Color.PINK);
                    else
                    if(l == 5)
                        g.setColor(Color.GREEN);
                    else
                    if(l == 6)
                        g.setColor(Color.CYAN);
                    else
                    if(l == 7)
                        g.setColor(Color.YELLOW);
                    else
                    if(l == 8)
                        g.setColor(Color.DARK_GRAY);
                    else
                    if(l == 9)
                        g.setColor(Color.GRAY);
                    else
                    if(l == 10)
                        g.setColor(Color.WHITE);
                    g.drawLine(ai2[j1], ai3[j1], ai2[j1 + 1 >= corners ? 0 : j1 + 1], ai3[j1 + 1 >= corners ? 0 : j1 + 1]);
                }

                g.setColor(Color.BLACK);
                split(ai2, ai3, j - 1);
            }

        } else
        {
            int ai4[] = new int[corners];
            int ai5[] = new int[corners];
            for(int k1 = 0; k1 < corners; k1++)
            {
                ai2[k1] = (ai[k1] + ai[k1 + 1 >= corners ? 0 : k1 + 1]) / 2;
                ai3[k1] = (ai1[k1] + ai1[k1 + 1 >= corners ? 0 : k1 + 1]) / 2;
            }

         //   Manipulation _tmp = this;
            if(j == level)
            {
                g.setColor(Color.BLUE);
            } else
            {
              //  Manipulation _tmp1 = this;
                if(j == level - 1)
                {
                    g.setColor(Color.RED);
                } else
                {
                 //   Manipulation _tmp2 = this;
                    if(j == level - 2)
                    {
                        g.setColor(Color.MAGENTA);
                    } else
                    {
               //         Manipulation _tmp3 = this;
                        if(j == level - 3)
                        {
                            g.setColor(Color.ORANGE);
                        } else
                        {
                //            Manipulation _tmp4 = this;
                            if(j == level - 4)
                            {
                                g.setColor(Color.PINK);
                            } else
                            {
                     //           Manipulation _tmp5 = this;
                                if(j == level - 5)
                                {
                                    g.setColor(Color.GREEN);
                                } else
                                {
                     //               Manipulation _tmp6 = this;
                                    if(j == level - 6)
                                    {
                                        g.setColor(Color.CYAN);
                                    } else
                                    {
                        //                Manipulation _tmp7 = this;
                                        if(j == level - 7)
                                        {
                                            g.setColor(Color.YELLOW);
                                        } else
                                        {
                        //                    Manipulation _tmp8 = this;
                                            if(j == level - 8)
                                            {
                                                g.setColor(Color.DARK_GRAY);
                                            } else
                                            {
                         //                       Manipulation _tmp9 = this;
                                                if(j == level - 9)
                                                {
                                                    g.setColor(Color.GRAY);
                                                } else
                                                {
                        //                            Manipulation _tmp10 = this;
                                                    if(j == level - 10)
                                                        g.setColor(Color.WHITE);
                                                    else
                                                        g.setColor(Color.GRAY);
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
            g.drawLine(ai2[0], ai3[0], ai2[2], ai3[2]);
            g.drawLine(ai2[1], ai3[1], ai2[3], ai3[3]);
            g.setColor(Color.BLACK);
            for(int l1 = 0; l1 < corners; l1++)
            {
                ai4[0] = ai[l1];
                ai4[1] = ai2[l1];
                ai4[2] = (ai2[l1 - 1 < 0 ? 3 : l1 - 1] + ai2[l1 + 1 >= corners ? 0 : l1 + 1]) / 2;
                ai4[3] = ai2[l1 - 1 < 0 ? 3 : l1 - 1];
                ai5[0] = ai1[l1];
                ai5[1] = ai3[l1];
                ai5[2] = (ai3[l1 - 1 < 0 ? 3 : l1 - 1] + ai3[l1 + 1 >= corners ? 0 : l1 + 1]) / 2;
                ai5[3] = ai3[l1 - 1 < 0 ? 3 : l1 - 1];
                split(ai4, ai5, j - 1);
            }

        }
        alphacomposite = AlphaComposite.getInstance(2, 1.0F);
        g.setComposite(alphacomposite);
    }

    public static void setCorners(int j)
    {
        corners = j;
    }

    public static void setSeqType(String s)
    {
        seqtype = s;
    }

    public static String getSeqType()
    {
        return seqtype;
    }

    public static void setDistribution(String as[])
    {
        distStr = as;
        for(int j = 0; j < distStr.length; j++)
            System.out.println(distStr[j]);

    }

    public static String[] getDistribution()
    {
        return distStr;
    }

    public static int[] getx()
    {
        return x;
    }

    public static int[] gety()
    {
        return y;
    }

    public static int getCorners()
    {
        return corners;
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

    public void mouseClicked(MouseEvent mouseevent)
    {
        if(flag)
        {
            AlphaComposite alphacomposite = AlphaComposite.getInstance(2, 1.0F);
            g.setComposite(alphacomposite);
            BasicStroke basicstroke = new BasicStroke();
            g.setStroke(basicstroke);
            g.setColor(Color.BLACK);
            getdata();
            drawPoly(p);
            plot();
            split(x, y, level);
            System.out.println("Clicked");
            //xcount.add(new Integer(mouseevent.getX())); // comment for creating jar file only
           // ycount.add(new Integer(mouseevent.getY()));
            float af[] = {
                10F
            };
            basicstroke = new BasicStroke(1.0F, 0, 0, 10F, af, 0.0F);
            g.setStroke(basicstroke);
            alphacomposite = AlphaComposite.getInstance(2, 0.35F);
            g.setComposite(alphacomposite);
            g.setColor(Color.YELLOW);
            if(corners == 4 && counttype)
            {
                int ai[] = new int[4];
                int ai2[] = new int[4];
                int j = (int)((double)(x[1] - x[0]) / Math.pow(2D, level));
                int j1 = (int)((double)(y[0] - y[3]) / Math.pow(2D, level));
                for(int k1 = x[0]; k1 < x[1]; k1 += j)
                    if(mouseevent.getX() >= k1 && mouseevent.getX() < k1 + j)
                    {
                        ai[0] = k1;
                        ai[1] = k1 + j;
                        ai[2] = k1 + j;
                        ai[3] = k1;
                    }

                for(int l1 = y[3]; l1 < y[0]; l1 += j1)
                    if(mouseevent.getY() >= l1 && mouseevent.getY() < l1 + j1)
                    {
                        ai2[0] = l1 + j1;
                        ai2[1] = l1 + j1;
                        ai2[2] = l1;
                        ai2[3] = l1;
                    }

                g.setColor(Color.GRAY);
                p = new Polygon(ai, ai2, ai.length);
                g.fillPolygon(p);
                AlphaComposite alphacomposite1 = AlphaComposite.getInstance(2, 1.0F);
                g.setComposite(alphacomposite1);
                BasicStroke basicstroke1 = new BasicStroke();
                g.setStroke(basicstroke1);
                g.setColor(Color.BLACK);
                getdata();
                drawPoly(p);
                plot();
                split(x, y, level);
                flag = false;
                for(int i2 = 0; i2 < xp.length; i2++)
                {
                //    Manipulation _tmp = this;
                //    Manipulation _tmp1 = this;
                    System.out.println((int)xp[i2] + "\t" + (int)yp[i2]);
                    if(p.contains((int)xp[i2], (int)yp[i2]))
                        countpoints++;
                }

               // CGREX.Noofpoints(countpoints, bi, flag, this);
            } else
            {
                if(xcount.size() > 1)
                {
                    g.drawLine(mouseevent.getX(), mouseevent.getY(), ((Integer)xcount.get(xcount.size() - 2)).intValue(), ((Integer)ycount.get(xcount.size() - 2)).intValue());
                    BasicStroke basicstroke2 = new BasicStroke();
                    g.setStroke(basicstroke2);
                    //CGREX.Noofpoints(countpoints, bi, flag, this);
                }
                System.out.println(mouseevent.getX() + "\t" + mouseevent.getY());
                if(mouseevent.getButton() == 3)
                {
                    System.out.println("DoubleClicked");
                    flag = false;
                    int ai1[] = new int[xcount.size()];
                    int ai3[] = new int[ycount.size()];
                    for(int l = 0; l < xcount.size(); l++)
                    {
                        ai1[l] = ((Integer)xcount.get(l)).intValue();
                        ai3[l] = ((Integer)ycount.get(l)).intValue();
                        System.out.println(ai1[l] + "\t" + ai3[l]);
                    }

                    g.setColor(Color.GRAY);
                    p = new Polygon(ai1, ai3, ai1.length);
                    g.fillPolygon(p);
                    AlphaComposite alphacomposite2 = AlphaComposite.getInstance(2, 1.0F);
                    g.setComposite(alphacomposite2);
                    BasicStroke basicstroke3 = new BasicStroke();
                    g.setStroke(basicstroke3);
                    g.setColor(Color.BLACK);
                    getdata();
                    drawPoly(p);
                    plot();
                    split(x, y, level);
                    for(int i1 = 0; i1 < xp.length; i1++)
                    {
                  //      Manipulation _tmp2 = this;
                  //      Manipulation _tmp3 = this;
                        System.out.println((int)xp[i1] + "\t" + (int)yp[i1]);
                        if(p.contains((int)xp[i1], (int)yp[i1]))
                            countpoints++;
                    }

                    //CGREX.Noofpoints(countpoints, bi, flag, this);
                }
            }
        }
    }

    static
    {
        corners = 4;
        numPoints = corners + 1;
    }
}
