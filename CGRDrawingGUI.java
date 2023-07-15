//package CGRexpack;
import java.awt.*;
import java.awt.event.*;

import javax.swing.*;
//import javax.swing.event.*;
//import javax.swing.ComboBoxEditor;
import java.io.*;
//import java.lang.*;


public class CGRDrawingGUI extends JFrame
    implements ActionListener,MouseListener, 
    MouseMotionListener,ItemListener
{
	public static final long serialVersionUID = 0;
	final static String GENERAL = "General    ";
	final static String ADVANCED = "Advanced    ";
    
    CGRexMainGUI maingui;
    CGRexMainGUI mainframe;
    CGRDrawing drawing1;
    StatusBar statusBar;
	private JLabel LsearchSeq;
	private JLabel LSeqType;
	private JLabel LPlotShape;
	private JLabel or;
	private JLabel status;
	private JLabel LCornerAssgn;
	private JButton searchSeq;
	private JButton sketch;
	private JButton sketchAdv;
	private JButton ok;
	private JTextArea  seqText;
	private JComboBox selSeqType;
	private JComboBox selPlotShape;
	private JComboBox selGrouping;
	
	String seqstring="";
	
	Container Content;
   
    JPanel pGeneral;
    JPanel pAdvanced;
    JTabbedPane pMainPane;

    JOptionPane jop;
   
    int MeshCountStart;
    boolean bPlotShapeChanged;
    boolean bCornerAssgnChanged;
    boolean bFromShowProperties;
      
    public CGRDrawingGUI( CGRexMainGUI maingui )
	{
    	
    	pGeneral = new JPanel();
		pAdvanced = new JPanel();
		pMainPane = new JTabbedPane();
		seqText= new JTextArea();
		//JScrollBar scrollbar = new JScrollBar();
		status = new JLabel("");
		or = new JLabel("OR");
		pAdvanced.setFocusable(false);//)setVisible(false);
    	Content = null;
		Content = getContentPane();
    	statusBar = new StatusBar();
      	//getContentPane().add(statusBar, java.awt.BorderLayout.SOUTH); 
		this.maingui = maingui;
		
		pGeneral.setBounds(20, 20, 400, 1000);
		pGeneral.setVisible(true);
		pAdvanced.setBounds(20, 20, 400, 1000);
		pAdvanced.setVisible(false);
		
		
		JPanel content = new JPanel();
        content.setLayout(new BorderLayout());
                
        seqText.setText("Paste Sequence");
       
		JScrollPane scrollPane = new JScrollPane(seqText);
		seqText.setAutoscrolls(true);
		scrollPane.setViewportView(seqText);
	
		content.add(scrollPane, BorderLayout.CENTER);
		content.setBounds(160, 122, 150, 50);
		
		pGeneral.add(content);
		//ok.setEnabled(false);	
		
	}
	public void showProperties()
	{
		
		bFromShowProperties= true;
		bPlotShapeChanged = false;
        bCornerAssgnChanged = false;
        MeshCountStart = 0;
        
		/*pGeneral = new JPanel();
		pAdvanced = new JPanel();
		pMainPane = new JTabbedPane();*/

		
		
		
		//pGeneral.se
	

    
 		LsearchSeq= new JLabel();
		LSeqType= new JLabel();
		LPlotShape = new JLabel();
	    LCornerAssgn = new JLabel();
		searchSeq=new JButton();
		sketch=new JButton();
		ok = new JButton();
		sketchAdv=new JButton();
       
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
		//JScrollPane scrollPane = new JScrollPane(seqText);
		// scrollPane.setHorizontalScrollBar(scrollbar);//setViewportView(seqText);
		//selSeqType.setSelectedIndex(maingui.drawing1.SeqTypeIndex);
      
		/*TextArea textArea = new JTextArea(5, 30);
		
		...
		contentPane.setPreferredSize(...);
		...
		contentPane.add(scrollPane, BorderLayout.CENTER);*/
		
		or.setBounds(180, 75, 150, 50);
		pGeneral.add(or);
		
		
               
        LsearchSeq.setText("Select Sequence");
        LsearchSeq.setPreferredSize(new Dimension(162, 223));
        LsearchSeq.setBounds(10, 62, 150, 10);
        pGeneral.add(LsearchSeq);
        
        
        
        //LsearchSeq.setFont(Font (new Font("Verdana")));
        
        searchSeq.setText("Browse");
        pGeneral.add(searchSeq);
        searchSeq.setBounds(160, 60, 70, 20);
        searchSeq.addActionListener(this);
 
        
        
        
        LPlotShape.setText("Select Plot Shape");
        LPlotShape.setPreferredSize(new Dimension(162, 223));
        LPlotShape.setBounds(10, 22, 150, 10);
        pAdvanced.add(LPlotShape);
        
        String[] plotShape = {"NONE", "TRIANGLE", 
        		"SQUARE", "PENTAGON", "HEXAGON", 
        		"HEPTAGON","OCTAGON",
        		"ENNEAGON" ,"DECAGON","HENDECAGON",
        		"TRISKAIDECAGON","TETRAKAIDECAGON",
        		"PENTAKAIDECAGON","HEXAKAIDECAGON",
        		"HEPTAKAIDECAGON",
        		"OCTAKAIDECAGON","ENNEAKAIDECAGON",
        		"ICOSAGON","ICOSIKAIHENAGON","ICOSIKAIDIGON",
        		"ICOSIKAITRIGON","ICOSIKAITETRAGON",
        		"ICOSIKAIPENTAGON","ICOSIKAIHEXAGON"};      
        
    
		selPlotShape = new JComboBox(plotShape);
		
		pAdvanced.add(selPlotShape);	
		selPlotShape.addItemListener(this);
		selPlotShape.addActionListener(this);
		selPlotShape.setBounds(160, 20, 80, 20);
		selPlotShape.setSelectedIndex( (maingui.drawing1.PlotShapeIndex));
        
        LCornerAssgn.setText("Corner Asssignment");
        LCornerAssgn.setPreferredSize(new Dimension(162, 223));
        LCornerAssgn.setBounds(10, 62, 150, 10);
        pAdvanced.add(LCornerAssgn);
        
        String[] corner = {"None", "Clustering", "Predefined",  "User Defined"};
		selGrouping = new JComboBox(corner);
		pAdvanced.add(selGrouping);	
		selGrouping.addItemListener(this);
		selGrouping.addActionListener(this);
		selGrouping.setBounds(160, 60, 80, 20);
		selGrouping.setSelectedIndex(maingui.drawing1.GroupSelection);
       
		ok.setText("Ok");
		ok.setBounds(160, 180, 70, 20);
		ok.addActionListener(this);
        pGeneral.add(ok);
        status.setBounds(20, 210, 70, 20);
        pGeneral.add(status);
		sketch.setText("Sketch");
        sketch.setBounds(160, 210, 70, 20);
        sketch.addActionListener(this);
        pGeneral.add(sketch);

        sketchAdv.setText("Sketch");
        sketchAdv.setBounds(160, 110, 70, 20);
        sketchAdv.addActionListener(this);
        enableSketch();
        pAdvanced.add(sketchAdv);
        
        pGeneral.setLayout(null);
        pAdvanced.setLayout(null);
        pMainPane.addTab(GENERAL,null,pGeneral, "General");
        pMainPane.addTab(ADVANCED, null, pAdvanced, "Advanced");
        pMainPane.setEnabledAt(1, false);
        //pAdvanced.setEnabled(false);
        //pMainPane.addTab(ADVANCED, pAdvanced);
        //pAdvanced.setEnabled(ADVANCED, false);
		Content.add(pMainPane);//, BorderLayout.NORTH);
		

		Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
        setBounds((dimension.width - 319) / 2, (dimension.height - 335) / 2, 340, 310);
        setTitle("CGRex Settings");
        
        bFromShowProperties=false;
        ok.setEnabled(false);

   	}
   	
   	private void enableSketch()
    {
    	if(((maingui.drawing1.TestSeqType!=null) && (maingui.SeqFile !=null)) && (bPlotShapeChanged == bCornerAssgnChanged) )
    	{
    		sketch.setEnabled(true);
    		sketchAdv.setEnabled(true);
    	}	
    	else
    	{
    		sketch.setEnabled(false);
    		sketchAdv.setEnabled(false);
    	}       
    }
   	
   	public void itemStateChanged( ItemEvent event )
	{
		if( event.getSource() == selSeqType
				&& event.getStateChange() == ItemEvent.SELECTED )
		{
			if(selSeqType.getSelectedItem()=="NONE")
			{
				pMainPane.setEnabledAt(1, false);
				maingui.drawing1.setTestSeqType("NONE");
				 ok.setEnabled(false);
				enableSketch();
			}
			else if(selSeqType.getSelectedItem()=="DNA")
            {   
				pMainPane.setEnabledAt(1, false);
                maingui.drawing1.setTestSeqType("DNA");
                maingui.drawing1.setTestCorners(4);
                String as[] = {
                    "A", "G", "T", "C"
                };
                maingui.drawing1.setTestDistribution(as);
                enableSketch();
                ok.setEnabled(true);
            } else
            if(selSeqType.getSelectedItem()=="RNA")
            {
            	pMainPane.setEnabledAt(1, false);
                maingui.drawing1.setTestSeqType("RNA");
                maingui.drawing1.setTestCorners(4);
                String as1[] = {
                    "A", "G", "U", "C"
                };
                maingui.drawing1.setTestDistribution(as1);
                enableSketch();
                ok.setEnabled(true);
            } else
            if(selSeqType.getSelectedItem()=="AminoAcid")
            {
            	pMainPane.setEnabledAt(1, true);
            	maingui.drawing1.setTestSeqType("Amino Acid");
                maingui.drawing1.setTestCorners(20);
                String as1[] = {"A", "R", "N", "D", "C", "E", "Q", "G", "H", "I", "L", "K", "M", "F", "P", "S", "T", "W", "Y", "V"  };
                maingui.drawing1.setTestDistribution(as1);
                enableSketch();
                pAdvanced.setEnabled(false);
                ok.setEnabled(true);
            }						
		}
		else if( event.getSource() == selPlotShape
				&& event.getStateChange() == ItemEvent.SELECTED )
		{
			maingui.drawing1.TestDistrName =null;
		    if(selPlotShape.getSelectedItem()!="NONE")
			{
				bPlotShapeChanged = true;
				enableSketch();
				maingui.drawing1.setPlotShape(selPlotShape.getSelectedIndex());
				maingui.drawing1.setTestCorners(selPlotShape.getSelectedIndex()+2);
				maingui.Select = 0;
            	maingui.MeshCountStart = 0;
            	maingui.enable("ZoomIn", false);
            	maingui.enable("ZoomOut", false);
           
           
	            if((maingui.drawing1.getTestDistrName() != null) && (!bFromShowProperties))
	            {
	            	String TestDistr[] = {""};
	            	
	                new KmeansTest(maingui.drawing1.getTestDistrName(), maingui.drawing1.getTestCorners());
	                String[] dist2	=KmeansTest.getDist();
	                String[] dist	=	dist2;
	                dist2 = dist;
	                maingui.drawing1.setTestDistribution(TestDistr);
	            }
	         
			}			
		}
		else if( event.getSource() == selGrouping
				&& event.getStateChange() == ItemEvent.SELECTED )
		{
			
		    maingui.drawing1.setGroupSel(selGrouping.getSelectedIndex());
		    if(selGrouping.getSelectedItem()!="NONE")
			{
				bCornerAssgnChanged = true;
				enableSketch();
		        if(selGrouping.getSelectedItem() == "Predefined")
		        {
		            
		            maingui.Select = 0;
		            maingui.MeshCountStart = 0;
		            maingui.enable("ZoomIn", false);
		            maingui.enable("ZoomOut", false);
		            if((maingui.drawing1.getTestCorners() > 2) && (!bFromShowProperties))
		                (new PredefinedPointAssignment(maingui.drawing1)).setVisible(true);
		            bFromShowProperties=false;
		        } 
		        else if(selGrouping.getSelectedItem() == "Clustering")
		        {
		            maingui.Select = 0;
		            maingui.MeshCountStart = 0;
		            maingui.enable("ZoomIn", false);
		            maingui.enable("ZoomOut", false);
		            if((maingui.drawing1.getTestCorners() > 2) && (!bFromShowProperties))
		                (new KMeansClusteringDialog(maingui.drawing1)).setVisible(true);
		            bFromShowProperties=false;
		        } 
		        else if(selGrouping.getSelectedItem() == "User Defined")
		        {
		            maingui.Select = 0;
		            maingui.MeshCountStart = 0;
		            maingui.enable("ZoomIn", false);
		            maingui.enable("ZoomOut", false);
		            if((maingui.drawing1.getTestCorners() > 2) && (!bFromShowProperties))
		                (new UserdefinedSelection(maingui.drawing1)).setVisible(true);
		            bFromShowProperties=false;
		        }				
			}			
		}
		
	}
   	public void keyPressed(KeyEvent e) {
   	   int keyUpper = e.getKeyCode() - 32;
   	   char keyUpperAsChar = (char) keyUpper;
   	}


   	public void actionPerformed(ActionEvent actionevent)
    { 
    Object obj = actionevent.getSource();
        if(obj == searchSeq)
        {                
            TextFileFilter textfilefilter = new TextFileFilter();
            textfilefilter.setCurrentDirectory(new File("./Sequences"));
            int i1 = textfilefilter.showOpenDialog(new JFrame());
            if(i1 == 0)
            {
                maingui.SeqFile = textfilefilter.getSelectedFile();
                enableSketch();
            }     
           // System.out.print("maingui.SeqFile.getName()"+maingui.SeqFile.getName());
                           
         }
        else
        if(obj == ok)
            		{
        			if(seqText.getText() != null)
        			{
        				String seqstring1 =seqText.getText();
        				char[] upper = seqstring1.toCharArray();
        				int j=0;
        	             for (int i = 0; i < upper.length; i++) {
        	            	 upper[i] = Character.toUpperCase(upper[i]);
        	            	 if((selSeqType.getSelectedItem()=="DNA")&&((upper[i]=='A')||(upper[i]=='G')||(upper[i]=='C')||(upper[i]=='T')))
        	            	 {
        	            		 if(i!=j)
        	            		upper[j]=upper[i];        	            	
        	            		 j++;
        	            		 
        	            	 }
        	            	 else if((selSeqType.getSelectedItem()=="RNA")&&((upper[i]=='A')||(upper[i]=='G')||(upper[i]=='U')||(upper[i]=='C')))
        	            	 {
        	            		 if(i!=j)
        	            		upper[j]=upper[i];        	            		
        	            		 j++;
        	            		 
        	            	 } 
        	            	 else
        	            	 {
        	            		 //System.out.println("Invalid");
        	            	 }
        	            
        	              }
        	             if(j==0)
        	             {        	            	
        	            	 return;
        	             }
        	            
        	             //upper[j] ='\0';
        	             seqstring="";
        	             for (int i = 0; i < j; i++)
        	             {
        	            	 seqstring = seqstring + (upper[i]);
        	             }
        	            
        	             
        				sketch.setEnabled(true);
        				
        			}
            		}
         else
         if((obj == sketch)|| (obj == sketchAdv))
         {   
        	status.setText("sorry...");
        	status.repaint();
        	maingui.DrawSeqPanel();
       		maingui.DrawSettingsPanel();
       		
            if(!maingui.drawing1.validateSettings())
            
            { 
            	JOptionPane.showMessageDialog(this, "Invalid selection", "Type mismatch", 0);
                bPlotShapeChanged = false;
        		bCornerAssgnChanged= false;
            	maingui.drawing1.setPlotShape(0);
				bPlotShapeChanged = false;
				selGrouping.setSelectedItem("NONE");
				selGrouping.setSelectedIndex(0);
				dispose();   
            } else
            {
            	maingui.Settingspanel1.setVisible(true);
            	bPlotShapeChanged = false;
        		bCornerAssgnChanged= false;      
            	maingui.DrawCGR();
            	maingui.drawing1.repaint();
            	maingui.Settingspanel1.setVisible(true);
            	maingui.Sequencepanel1.setVisible(true);
            	maingui.drawing1.setPlotShape(0);
				bPlotShapeChanged = false;
				selGrouping.setSelectedItem("NONE");
				selGrouping.setSelectedIndex(0);
				
				
				 maingui.enable("LoadNewSequence", true);
	        	 maingui.enable("DrawCGR", true);
	        	 maingui.enable("LoadProject", true);
	        	 maingui.enable("CloseProject", true);
	        	 maingui.enable("SaveProject", true);
	        	 maingui.enable("CurrentProject", true);
	        	 maingui.enable("ExportPlot", true);//
	        	 maingui.enable("PrintPlot", true);
	             maingui.enable("Split", true);
	        	 maingui.enable("Tools", true);
	        	 maingui.enable("ApplyColor", true);
	        	 maingui.enable("Movie", true);
	        	// maingui.enable("ShowLabel", true);
	        	// maingui.enable("nmerCount", true);
	        	 maingui.enable("MeshPlot", true);
	        	 maingui.enable("DrawMesh", true);
	             maingui.enable("Select", true);
	        	 maingui.enable("ZoomIn", true);
	        	 maingui.enable("ZoomOut", true);
	        	 maingui.enable("Enhancements", true);
	        	 maingui.enable("ConvertSeqType", true);
	        	 maingui.enable("Multiplot", true);
	        	 maingui.enable("PlotProperties", true);
	        	 maingui.enable("ShowLabel", false);
	        	 maingui.enable("nmercount", false);
	        	 maingui.enable("Manual", false);
	        	 maingui.enable("MeshPlot", false);
	        	 maingui.enable("DrawMesh", false);
	        	 maingui.enable("MeshCount", false);
	        	 maingui.enable("Angle", false);
	        	 status.setText("");
				//maingui.drawing1.setDistrName("");
				  dispose();   
				  //System.out.print("++++++++++++++"+maingui.drawing1.DistrName);
				 
            }         	
         
         }
    }
   	
public void Sketch()
{
	
maingui.enable("LoadNewSequence", true);
maingui.enable("DrawCGR", true);
maingui.enable("LoadProject", true);
maingui.enable("SaveProject", true);
maingui.enable("ExportPlot", true);//
maingui.enable("PrintPlot", true);
maingui.enable("CloseProject", true);
maingui.enable("Tools", true);
maingui.enable("Movie", true);
maingui.enable("ShowLabel", true);
maingui.enable("Select", true);
maingui.enable("CountPoints", true);
maingui.enable("Manual", true);
maingui.enable("MeshPlot", true);
maingui.enable("DrawMesh", true);
maingui.enable("MeshCount", true);
maingui.enable("Angle", true);
maingui.enable("ZoomIn", true);
maingui.enable("ZoomOut", true);
maingui.enable("Enhancements", true);
maingui.enable("PlotProperties", true);
maingui.DrawSeqPanel();
	maingui.DrawSettingsPanel();
if(!maingui.drawing1.validateSettings())
{ 
	
 //  JOptionPane _tmp2 = jop;
  // JOptionPane _tmp3 = jop;
   JOptionPane.showMessageDialog(this, "Invalid selection", "Type mismatch", 0);
   bPlotShapeChanged = false;
	bCornerAssgnChanged= false;
	maingui.drawing1.setPlotShape(0);
	maingui.drawing1.setTestCorners(0);
	bPlotShapeChanged = false;
	selGrouping.setSelectedItem("NONE");
	selGrouping.setSelectedIndex(0);
	maingui.drawing1.setDistrName("");
	dispose();   
} else
{
	maingui.Settingspanel1.setVisible(true);
	bPlotShapeChanged = false;
	bCornerAssgnChanged= false;

	maingui.DrawCGR();
	maingui.Settingspanel1.setVisible(true);
	maingui.Sequencepanel1.setVisible(true);
	maingui.drawing1.setPlotShape(0);
	maingui.drawing1.setTestCorners(0);
	bPlotShapeChanged = false;
	selGrouping.setSelectedItem("NONE");
	selGrouping.setSelectedIndex(0);
		maingui.drawing1.setDistrName("");
	  dispose();     
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
    public void windowClosing(WindowEvent windowevent)
    {
    	drawing1.setSeqStr("");
    	drawing1.TestSeqStr ="";
    	drawing1.TestSeqType = "None";
    	drawing1.TestCorners = 0;
    	mainframe.SeqFile = null;
    	
    	maingui.enable("nmerCount",false);
    	maingui.enable("Manual",false);
    	maingui.enable("Automatic",false);
    	maingui.enable("MeshPlot ",false);
    	maingui.enable("DrawMesh ",false);
    	maingui.enable("MeshCount",false);
    	maingui.enable("Angle",false);
    	maingui.enable("ZoomIn",false);
    	maingui.enable("ZoomOut",false);
    	mainframe.enable("PlotSize",false);
    	mainframe.enable("PointSize",false);
    	mainframe.enable("PlotProperties", false);
    	mainframe.enable("ConvertSeqType", false);
    	mainframe.enable("Multiplot", false);
    	mainframe.enable("HelpCGREX", false);
    	mainframe.enable("AboutCGREX", false);
    	mainframe.enable("ApplyColor", false);
    	mainframe.enable("PlotSize", false);
    	mainframe.enable("PointSize", false);
    	mainframe.enable("DrawMesh",false);
    }
 /* public static void main(String args[])
    {
	  
	  
        try
        {
        
        	UIManager.installLookAndFeel("WindowsLookAndFeel","com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
          	UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
        }
        catch(Exception exception) { }
              
      // (new CGRDrawingGUI()).setVisible(true);
    }*/
    
}
    	