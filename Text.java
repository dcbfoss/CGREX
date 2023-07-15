// FrontEnd Plus GUI for JAD
// DeCompiled : Text.class
//package CGRexpack;
import java.io.*;
import javax.swing.JTextField;

class Text extends JTextField
{
	public static final long serialVersionUID = 0;
    String str;

    public Text()
    {
        str = new String();
        setBounds(10, 520, 550, 25);
        setOpaque(true);
    }

    public void readwrite(String s)
    {
        try
        {
            BufferedReader bufferedreader = new BufferedReader(new FileReader(new File(s)));
            str = bufferedreader.readLine();
            setText(str);
        }
        catch(Exception exception)
        {
            System.out.println(exception);
        }
    }
}
// FrontEnd Plus GUI for JAD
// DeCompiled : Text.class
//package CGRexpack;
/*import java.io.*;
import javax.swing.JTextField;

class Text extends JTextField
{
	public static final long serialVersionUID = 0;
    String str;

    public Text()
    {
        str = new String();
        setBounds(10, 520, 550, 25);
        setOpaque(true);
    }

    public void readwrite(String s)
    {
        try
        {
            BufferedReader bufferedreader = new BufferedReader(new FileReader(new File(s)));
            str = bufferedreader.readLine();
            setText(str);
        }
        catch(Exception exception)
        {
            System.out.println(exception);
        }
    }
}*/


//
// * Title:        JackGraph<p>
// * Description:  Grafici 2D,3D.
// * Copyright 2000.
// * <p>
// * Copyright:    Copyright (c) Giacomo Veneri<p>
 //* Company:      Etruria Innovazione SCpA<p>
// * @author Giacomo Veneri
// * @version 1.0
// */
//package jack.component; 
/*import javax.swing.*;
import java.awt.*;
import javax.swing.border.*;

public class Text extends JProgressBar{

  //--------------------------------------------------------------------------

    public static final String TITLE = "Line Graph";
    public static final String VERSION = "1.0";
    private final boolean DEBUG = true;

  //--------------------------------------------------------------------------

    private int type = 0;
    private int typeColor = 0;
    public static final int INDICATOR = 0;
    public static final int COMPETITIVE = 1;
    public static final int CIRCULAR = 2;
    public static final int MULTICOLOR = 3;
    public static final int REDBLUE = 0;
    public static final int REDGREEN = 1;
    public static final int BLUEGREEN = 2;

  //--------------------------------------------------------------------------

    private int otherValue = -1;
    private Color otherForegroundColor = Color.red;

  //--------------------------------------------------------------------------
  //slider constructor
  public Text(int type) {
  super();
  this.setForeground(Color.blue);
  this.setType(type);
  this.setBorder(new EtchedBorder(EtchedBorder.LOWERED));
  }

  //slider constructor
  public Text() {
  super();
  this.setForeground(Color.blue);
  this.setBorder(new EtchedBorder(EtchedBorder.LOWERED));
  }

  //slider constructor
  public Text(int min, int max) {
  super(min,max);
  this.setForeground(Color.blue);
  this.setBorder(new EtchedBorder(EtchedBorder.LOWERED));
  }

  //graph ONLY OVERLOADED
  public void paint(Graphics g) {

    //controllo
    if (g==null) return;

    //delete paint
    g.setColor(this.getBackground());
    g.fill3DRect(0,0,this.getWidth(),this.getHeight(),true);

    //draw select
    if (type == INDICATOR) this.drawIndicator(g);
    if (type == CIRCULAR) this.drawCircular(g);
    if (type == MULTICOLOR) this.drawMulticolor(g);
    if (type == COMPETITIVE) this.drawCompetitive(g);
  }

  
/*
   public void setOtherValue(int value) {
    otherValue = value;
   }


   public int getOtherValue() {
    return otherValue;
   }

   public void setOtherForeground(Color value) {
    otherForegroundColor = value;
   }


   public Color getOtherForeground() {
    return otherForegroundColor;
   }

   public void setType(int type) {
    this.type = type;
   }

   public void setTypeColor(int typeColor) {
    this.typeColor = typeColor;
   }

   //--------------------------------------------------------------------------
   /**
    * PRIVATE FUNCTION
    */
    //INDICATOR MODE
   /* private void drawIndicator(Graphics g) {

    //prepare setting
    int h = this.getHeight();
    int w = this.getWidth();
    int ox = (getOtherValue()>=0) ? w/2 : 0;
    int oy = 0;

    //paint
    int[] xPoints = new int[4];
    int[] yPoints = new int[4];

    //upper
    xPoints[0]=ox;
    yPoints[0]=oy;
    xPoints[1]=ox;
    yPoints[1]=h;
    xPoints[2]= ox+((int)(((double)w/2)* ((double)this.getValue())/((double)(this.getMaximum()-this.getMinimum()))));
    xPoints[2]= (xPoints[2]>0) ? xPoints[2] : 0;
    yPoints[2]=h/2;
    xPoints[3]=ox;
    yPoints[3]=oy;

    //draw
    g.setColor(this.getForeground());
    g.fillPolygon(xPoints,yPoints,4);
    g.setColor(this.getForeground().darker());
    g.drawPolyline(xPoints,yPoints,4);
    g.drawString(this.getValue() + " %",xPoints[2],yPoints[2]+3);

    if (getOtherValue()>=0) {
        //lower
        xPoints[0]=0;
        yPoints[0]=oy;
        yPoints[1]=h;
        xPoints[0]=xPoints[1];
        xPoints[2]=((int)(ox-((double)ox)* ((double)this.getOtherValue())/((double)(this.getMaximum()-this.getMinimum()))));
        xPoints[2]= (xPoints[2]>0) ? xPoints[2] : 0;
        yPoints[2]=h/2;
        xPoints[3]=xPoints[0];
        yPoints[3]=yPoints[0];

        //draw
        g.setColor(this.getOtherForeground());
        g.fillPolygon(xPoints,yPoints,4);
        g.setColor(this.getOtherForeground().darker());
        g.drawPolyline(xPoints,yPoints,4);
        g.drawString(this.getOtherValue() + " %",xPoints[2]-10,yPoints[2]+3);
    }
    }

    //COMPETITIVE MODE
    private void drawCompetitive(Graphics g) {
    }

    //CIRCULAR MODE
    private void drawCircular(Graphics g) {
    }

    //MULTICOLOR MODE
    private void drawMulticolor(Graphics g) {
      //prepare setting
      int h = this.getHeight();
      int w = this.getWidth();

      //value
      int value = this.getValue();
      int maxV = this.getMaximum();
      float perc = ((float)value)/((float)maxV);

      int i=0;
      for (i=0; i<w; i++) {
        if ( perc>=((float)i)/((float)w) ) {
          g.setColor(this.getMColor(i,w));
          g.drawLine(i,1,i,h-1);
        } else {
          break;
        }
      }

      g.setColor(this.getBackground());
      g.drawString(this.getValue() + " %",w/2,h/2);
    }

    //GET COLOR
    private Color getMColor(int i, int N) {
      float v = ((float)i)/((float)N);
      if (this.typeColor == REDBLUE) return new Color((int)(254*v+1),0, (int)(255-254*v));
      if (this.typeColor == REDGREEN) return new Color((int)(254*v+1), (int)(255-254*v),0);
      if (this.typeColor == BLUEGREEN) return new Color(0,(int)(254*v+1), (int)(255-254*v));
      return new Color((int)(254*v+1),(int)(254*v+1), (int)(254*v+1));
    }


}
*/
