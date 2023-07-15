//CGRDraw;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
//import javax.swing.event.*;
//import javax.swing.ComboBoxEditor;
import java.io.*;
//import java.lang.*;



public class CGRDraw extends JFrame
    implements ActionListener,MouseListener, MouseMotionListener,ItemListener
{
	public static final long serialVersionUID = 0;
	final static String GENERAL = "General    ";
	final static String ADVANCED = "Advanced    ";
    
    CGRexMainGUI maingui;
	private JLabel LsearchSeq;
	private JLabel LSeqType;
	private JLabel LPlotShape;
	private JLabel LCornerAssgn;
	private JButton searchSeq;
	private JButton DrawCGR;
	private JComboBox selSeqType;
	private JComboBox selPlotShape;
	private JComboBox selCorner;
	Container Content;
	//MainWindow mw;
    CGRDrawing plottingPanel;
    CGRDrawing multiplotPanel;
    CGRDrawing jpanel1;
    CGRDrawing jpanel2;
   
    JPanel pGeneral;
    JPanel pAdvanced;
    JTabbedPane pMainPane;

    JOptionPane jop;
    seqpanel1 Sequencepanel1;
    seqpanel1 Sequencepanel2;
    settingsPanel Settingspanel1;
    settingsPanel Settingspanel2;
	
	String SeqStr1;
    String SeqStr2;
    
    int MeshCountStart;
    boolean bSeqTypeSelected;
    boolean bSequenceSelected;
    
      
    public CGRDraw( CGRexMainGUI maingui )
	{
		this.maingui = maingui;
		this.Sequencepanel1 = maingui.Sequencepanel1;
		//this.jpanel1 = maingui.jpanel1;
		this.Sequencepanel2 = maingui.Sequencepanel2;
		Content = null;
		Content = getContentPane();
		initComponents();
		}
	
	public void initComponents()
	{


		bSeqTypeSelected = false;
		bSequenceSelected = false;
        multiplotPanel = null;
        MeshCountStart = 0;

		pGeneral = new JPanel();
		pAdvanced = new JPanel();
		pMainPane = new JTabbedPane();
		multiplotPanel = new CGRDrawing(512, 512);
		
		
		pGeneral.setBounds(20, 20, 270, 200);
		pGeneral.setVisible(true);
		pAdvanced.setBounds(20, 20, 270, 200);
		pAdvanced.setVisible(true);
		Content.setLayout(new BorderLayout());
	

    
 		LsearchSeq= new JLabel();
		LSeqType= new JLabel();
		LPlotShape = new JLabel();
	    LCornerAssgn = new JLabel();
		searchSeq=new JButton();
		DrawCGR=new JButton();
       
        LSeqType.setText("Select Sequence Type");
        LSeqType.setPreferredSize(new Dimension(162, 223));
        LSeqType.setBounds(10, 22, 150, 10);
        pGeneral.add(LSeqType);
       
        String[] seqType = { "NONE", "DNA", "RNA", "AminoAcid" };
		selSeqType = new JComboBox(seqType);
		pGeneral.add(selSeqType);	
		selSeqType.addItemListener(this);
		selSeqType.addActionListener(this);
		selSeqType.setBounds(160, 20, 80, 20);
      
               
        LsearchSeq.setText("Select Sequence");
        LsearchSeq.setPreferredSize(new Dimension(162, 223));
        LsearchSeq.setBounds(10, 62, 150, 10);
        pGeneral.add(LsearchSeq);
        
        
        
        //LsearchSeq.setFont(Font (new Font("Verdana")));
        
        searchSeq.setText("Browse");
        pGeneral.add(searchSeq);
        searchSeq.setBounds(160, 60, 70, 20);
        searchSeq.addActionListener(this);
 
        DrawCGR.setText("Sketch");
        DrawCGR.setBounds(160, 110, 70, 20);
        DrawCGR.addActionListener(this);
        DrawCGR.setEnabled(false);
        pGeneral.add(DrawCGR);
        
        
        
        LPlotShape.setText("Select Plot Shape");
        LPlotShape.setPreferredSize(new Dimension(162, 223));
        LPlotShape.setBounds(10, 22, 150, 10);
        pAdvanced.add(LPlotShape);
        
        String[] plotShape = {"NONE", "TRIANGLE", "SQUARE", "PENTAGON", "HEXAGON",
        					  "HEPTAGON","OCTAGON","ENNEAGON" ,"DECAGON","HENDECAGON",
        					  "TRISKAIDECAGON","TETRAKAIDECAGON","PENTAKAIDECAGON",
        					  "HEXAKAIDECAGON","HEPTAKAIDECAGON","OCTAKAIDECAGON",
        					  "ENNEAKAIDECAGON","ICOSAGON","ICOSIKAIHENAGON",
        					  "ICOSIKAIDIGON","ICOSIKAITRIGON","ICOSIKAITETRAGON",
        					  "ICOSIKAIPENTAGON","ICOSIKAIHEXAGON" };
        
		selPlotShape = new JComboBox(plotShape);
		pAdvanced.add(selPlotShape);	
		selPlotShape.addItemListener(this);
		selPlotShape.addActionListener(this);
		selPlotShape.setBounds(160, 20, 80, 20);

        
        LCornerAssgn.setText("Corner Asssignment");
        LCornerAssgn.setPreferredSize(new Dimension(162, 223));
        LCornerAssgn.setBounds(10, 62, 150, 10);
        pAdvanced.add(LCornerAssgn);
        
        String[] corner = { "Clustering", "Pre Defind",  "User Defind"};
		selCorner = new JComboBox(corner);
		pAdvanced.add(selCorner);	
		selCorner.addItemListener(this);
		selCorner.addActionListener(this);
		selCorner.setBounds(160, 60, 80, 20);
       
        pGeneral.setLayout(null);
        pAdvanced.setLayout(null);
        pMainPane.addTab(GENERAL, pGeneral);
        pMainPane.addTab(ADVANCED, pAdvanced);		
		Content.add(pMainPane);//, BorderLayout.CENTER);

		Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
        setBounds((dimension.width - 319) / 2, (dimension.height - 335) / 2, 280, 210);
        setTitle("CGRex Settings");
		
        jpanel2 = new CGRDrawing(512, 512);
        jpanel2.addMouseListener(this);
        		

               
   	}
   	
   	private void enableSketch()
    {
    	if(bSeqTypeSelected && bSequenceSelected)
    		DrawCGR.setEnabled(true);
		else
		    DrawCGR.setEnabled(false);
    }
   	
   	public void itemStateChanged( ItemEvent event )
	{
		if( event.getSource() == selSeqType
				&& event.getStateChange() == ItemEvent.SELECTED )
		{
			if(selSeqType.getSelectedItem()=="NONE")
			{
				bSeqTypeSelected = false;
				enableSketch();
			}
			else if(selSeqType.getSelectedItem()=="DNA")
            {   
                jpanel1.setTestSeqType("DNA");
                jpanel1.setTestCorners(4);
                String as[] = {
                    "A", "G", "T", "C"
                };
                jpanel1.setTestDistribution(as);
                bSeqTypeSelected = true;
                enableSketch();
                
            } else
            if(selSeqType.getSelectedItem()=="RNA")
            {
                jpanel1.setTestSeqType("RNA");
                jpanel1.setTestCorners(4);
                String as1[] = {
                    "A", "G", "U", "C"
                };
                jpanel1.setTestDistribution(as1);
                bSeqTypeSelected = true;
                enableSketch();
                
            } else
            if(selSeqType.getSelectedItem()=="AminoAcid")
            {
                jpanel1.setTestSeqType("Amino Acid");
                jpanel1.setTestCorners(20);
                String as1[] = {"A", "R", "N", "D", "C", "E", "Q", "G", "H", "I", "L", "K", "M", "F", "P", "S", "T", "W", "Y", "V"  };
                jpanel1.setTestDistribution(as1);
                bSeqTypeSelected = true;
                enableSketch();
            }						
		}
		else if( event.getSource() == selPlotShape
				&& event.getStateChange() == ItemEvent.SELECTED )
		{
			if(selPlotShape.getSelectedItem()!="NONE")
			{
				jpanel1.setTestCorners(selPlotShape.getSelectedIndex()+2);
				maingui.Select = 0;
            	maingui.MeshCountStart = 0;
            	maingui.enable("ZoomIn", false);
            	maingui.enable("ZoomOut", false);
	            if(jpanel1.getTestDistrName() != null)
	            {
	            	String TestDistr[] = {""};
	            	
	                TestDistr = KmeansTest.getDist();
	                jpanel1.setTestDistribution(TestDistr);
	            }
			}			
			

		}

	}
   	
   	
   	 public void clearAll()
    {
        if(jpanel1 != null)
            jpanel1.setVisible(false);
        if(jpanel2 != null)
            jpanel2.setVisible(false);
        if(Sequencepanel1 != null)
        {
            Sequencepanel1.setVisible(false);
        }
        if(Sequencepanel2 != null)
        {
            Sequencepanel2.setVisible(false);
        }
        if(Settingspanel1 != null)
        {
            Settingspanel1.setVisible(false);
            Content.remove(Settingspanel1);
        }
        if(Settingspanel2 != null)
        {
            Settingspanel2.setVisible(false);
            Content.remove(Settingspanel2);
        }
    }


   	   	
   	
   	public void actionPerformed(ActionEvent actionevent)
    { 
    Object obj = actionevent.getSource();
        if(obj == searchSeq)
        {
        	
           // Object obj1 = null;
            TextFileFilter textfilefilter = new TextFileFilter();
            textfilefilter.setCurrentDirectory(new File("./Sequences"));
            int i1 = textfilefilter.showOpenDialog(new JFrame());
            if(i1 == 0)
            {
                File file = textfilefilter.getSelectedFile();
                SeqStr1="";
                String SeqStr2="";
                try
                {
                    FileReader filereader = new FileReader(file);
                    BufferedReader bufferedreader = new BufferedReader(filereader);
                    // section to read the entire text File
                    while ((SeqStr2=bufferedreader.readLine()) != null)
                     {
                       SeqStr1 += SeqStr2;
				     }
                    filereader.close();
                }
                catch(Exception exception)
                {
                    //JOptionPane _tmp = jop;
                    //JOptionPane _tmp1 = jop;
                    JOptionPane.showMessageDialog(this, "File not found", "Error", 0);
                    bSequenceSelected = false;
                    enableSketch();
                }
                bSequenceSelected = true;
                enableSketch();
                
                jpanel1.setMultiplot(false);
                jpanel2.setMultiplot(false);
                MeshCountStart = 0;
                
                Sequencepanel1.addMouseListener(this);
                Sequencepanel1.setVisible(true);
                Sequencepanel1.seq.setText(SeqStr1);
                jpanel1.setTestSeqStr(SeqStr1);
                jpanel1.setTestSeqColor(Color.BLACK);
                String as3[] = { "No Selection Made" };
                Settingspanel1 = new settingsPanel("Settings", as3, 590, 100, 200, 400);
                Settingspanel1.setVisible(true);
                Content.add(Settingspanel1);
                Settingspanel1.repaint();          
                 
            }
        
                         
         }
         else
         if(obj == DrawCGR)
         { 
            if(!jpanel1.validateSettings())
            
            {  	
            	System.out.println(" validateSettings failed...");
                //JOptionPane _tmp2 = jop;
                //JOptionPane _tmp3 = jop;
                JOptionPane.showMessageDialog(this, "Invalid selection", "Type mismatch", 0);
            } else
            {
            	System.out.println(" -----validateSettings success...");
                jpanel1.clearPanel();
                jpanel1.setMultiplot(false);
                multiplotPanel.setMultiplot(false);
                jpanel1.drawPoly();
                jpanel1.plot();
                jpanel1.repaint();
                jpanel1.setVisible(true);
                String as[] = {
                    "Shape:" + jpanel1.getCorners(), "Sequence Type:" + jpanel1.getSeqType(), "Name of sequence:", "_Points Assignment"
                };
                String as1[] = jpanel1.getDistribution();
                String as2[] = new String[as.length + as1.length];
                for(int k1 = 0; k1 < as.length; k1++)
                    as2[k1] = new String(as[k1]);
                for(int l1 = as.length; l1 < as.length + as1.length; l1++)
                    if(as1[l1 - as.length].trim().equals(""))
                        as2[l1] = new String(" ");
                    else
                        as2[l1] = new String(as1[l1 - as.length]);
			    Sequencepanel1.setVisible(true);
			    Sequencepanel1.seq.setText(jpanel1.getSeqStr());		    
                dispose();
            }         	
         
         }
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
    }
    
    public void mouseDragged(MouseEvent mouseevent)
    {
    	
    }
   
    public void mouseMoved(MouseEvent mouseevent)
    {
    	
    }
 
  /*public static void main(String args[])
    {
        try
        {
        
        	UIManager.installLookAndFeel("WindowsLookAndFeel","com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
          	UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
        }
        catch(Exception exception) { }
              
      // (new CGRDraw()).setVisible(true);
    }*/
    
}
    	