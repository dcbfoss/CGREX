// FrontEnd Plus GUI for JAD
// DeCompiled : ShapeClustering.class
//package CGRexpack;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.TitledBorder;

public class ShapeClustering extends JFrame
    implements ActionListener, ItemListener
{
	public static final long serialVersionUID = 0;
	String TestDistr[];

    CGRexMainGUI obj;
    CGRDrawing jpanel1;
    CGRDrawing jpanel2;
    boolean superimpose;
   // private ButtonGroup Group1;
   // private ButtonGroup Group2;
    /*private JRadioButton HydroButton;
    private JRadioButton PIButton;
    private JRadioButton RatioButton;*/
    
    private JComboBox selAminoProp;
    //private JPanel Panel1;
    private JPanel Panel2;
    /*private JTextField PolugonSidesField;
    private JRadioButton PolygonButton;
    
    private JRadioButton SquareButton;
    private JRadioButton TriangleButton;*/
    private JButton jButton1;
    private JButton jButton2;
   // private JLabel jLabel1;

    public ShapeClustering(CGRexMainGUI mainframe, CGRDrawing drawingclass, CGRDrawing drawingclass1, boolean flag)
    {
        obj = null;
        jpanel1 = null;
        jpanel2 = null;
        superimpose = false;
        obj = mainframe;
        jpanel1 = drawingclass;
        jpanel2 = drawingclass1;
        //superimpose = flag;
        initComponents();
        if(flag)
        {
           // SquareButton.setSelected(false);
            //Panel1.setEnabled(false);
          //  SquareButton.setEnabled(false);
          //  TriangleButton.setEnabled(false);
          //  PolygonButton.setEnabled(false);
          //  PolugonSidesField.setEnabled(false);
            drawingclass1.setTestCorners(drawingclass.getCorners());
        }
    }

    private void initComponents()
    {
      //  Group1 = new ButtonGroup();
     //   Group2 = new ButtonGroup();
      //  Panel1 = new JPanel();
       // SquareButton = new JRadioButton();
       // TriangleButton = new JRadioButton();
     //   PolygonButton = new JRadioButton();
      //  PolugonSidesField = new JTextField();
      //  jLabel1 = new JLabel();
        Panel2 = new JPanel();
    /* HydroButton = new JRadioButton();
           RatioButton = new JRadioButton();
        PIButton = new JRadioButton();*/
        
         String[] AminoProperties = {"NONE", "Hydrophobicity", 
        "Molecular Weight", "pI Values","Residue volume",
        "Composition","Polarity Partition energy",
        "Hydration number","Hydrophilicity value","Heat capacity",
        "Absolute entropy","Entropy of formation","Transfer free energy to surface",
        "Normalized relative frequency of bend",
       "Average accessible surface area","Percentage of buried residues",
       "Percentage of exposed residues",
       "Ratio of buried and accessible molar fractions",
       "Transfer free energy","Relative frequency of occurrence",
       "Relative mutability","Amino acid distribution","Sequence frequency",
       "Average relative probability of helix",
       "Average relative probability of beta-sheet",
       "Average relative probability of inner helix",
       "Average relative probability of inner beta-sheet",
       "Flexibility parameter for no rigid neighbors",
       "Flexibility parameter for one rigid neighbor",
       "Apparent partial specific volume","Alpha-NH chemical shifts",
       "Flexibility parameter for two rigid neighbors",
       "The Kerr-constant increments",
       "Net charge","Side chain interaction parameter",
       "Fraction of site occupied by water",
       "Side chain volume","Hydropathy index",
       "Transfer free energy, CHP/water",
       "Distance between C-alpha and centroid of side chain",
       "Side chain angle theta(AAR)",
       "Side chain torsion angle phi(AAAR)",
       "Radius of gyration of side chain",
       "van der Waals parameter R0",
       "Normalized frequency of alpha-helix, with weights",
       "Normalized frequency of beta-sheet, with weights",
       "Normalized frequency of reverse turn, with weights",
       "Normalized frequency of alpha-helix, unweighted",
       "Normalized frequency of beta-sheet, unweighted",
       "Normalized frequency of reverse turn, unweighted",
       "Frequency of occurrence in beta-bends",
       "Alpha-CH chemical shifts","Spin-spin coupling constants 3JHalpha-NH",
       "Conformational preference for all beta-strands",
       "Conformational preference for parallel beta-strands",
       "Conformational preference for antiparallel beta-strands",
       "Average surrounding hydrophobicity",
       "Normalized frequency of alpha-helix",          
       "Normalized frequency of extended structure",
       "Normalized frequency of zeta R",
       "Normalized frequency of left-handed alpha-helix","Normalized frequency of alpha region",
       "Refractivity","Average reduced distance for C-alpha",
       "Average reduced distance for side chain","",
       "Average side chain orientation angle","Effective partition energy",
       "Normalized frequency of alpha-helix","Normalized frequency of bata-structure",
       "Normalized frequency of coil","Normalized frequency of coil",
       "AA composition of total proteins","Normalized frequency of extended structure",
       "Steric parameter","SD of AA composition of total proteins",
       "AA composition of mt-proteins from fungi and plant",
       "AA composition of membrane proteins","Polarizability parameter"};
       
		selAminoProp = new JComboBox(AminoProperties);
		selAminoProp.addItemListener(this);
		selAminoProp.addActionListener(this);
		selAminoProp.setBounds(20, 40, 285, 20);
		Panel2.add(selAminoProp);
		
        jButton1 = new JButton();
        jButton2 = new JButton();
        getContentPane().setLayout(null);
        setTitle("Amino Acid Properties for Clustering(dur.2 min.)");
        addWindowListener(new WindowAdapter() {

            public void windowClosing(WindowEvent windowevent)
            {
                exitForm(windowevent);
            }

        });
      //  Panel1.setLayout(null);
       // Panel1.setBorder(new TitledBorder(null, "Select Plot Shape", 0, 0, new Font("Verdana", 0, 12)));
       // SquareButton.setSelected(true);
     //   SquareButton.setText("Square");
      //  Group1.add(SquareButton);
      //  Panel1.add(SquareButton);
      //  SquareButton.setBounds(20, 30, 150, 23);
      //  TriangleButton.setText("Triangle");
      //  Group1.add(TriangleButton);
     //   Panel1.add(TriangleButton);
     //   TriangleButton.setBounds(20, 60, 140, 23);
     //   PolygonButton.setText("Polygon with");
      //  Group1.add(PolygonButton);
     //   Panel1.add(PolygonButton);
      //  PolygonButton.setBounds(20, 90, 140, 23);
     //   Panel1.add(PolugonSidesField);
     //   PolugonSidesField.setBounds(50, 120, 40, 25);
      //  jLabel1.setText("Sides");
      //  Panel1.add(jLabel1);
     //   jLabel1.setBounds(100, 120, 70, 25);
   //     getContentPane().add(Panel1);
    //    Panel1.setBounds(20, 20, 190, 200);
        Panel2.setLayout(null);
        Panel2.setBorder(new TitledBorder(null, "Select Clustering type(duration, 2 mins. apox.)", 0, 0, new Font("Verdana", 0, 10)));
        /*HydroButton.setSelected(true);
        HydroButton.setText("Hydrophobicity");
        Group2.add(HydroButton);
        Panel2.add(HydroButton);
        HydroButton.setBounds(30, 30, 140, 23);
        RatioButton.setText("Water-Oil Ratio");
        Group2.add(RatioButton);
        Panel2.add(RatioButton);
        RatioButton.setBounds(30, 60, 150, 23);
        PIButton.setText("pI Value");
        Group2.add(PIButton);
        Panel2.add(PIButton);
        PIButton.setBounds(30, 90, 140, 23);*/
        getContentPane().add(Panel2);
        Panel2.setBounds(30, 25, 320, 150);
        jButton1.setText("Cancel");
        jButton1.addActionListener(this);
       
       // 60, 40, 120, 20
        jButton1.setBounds(230, 100, 80, 25);
        getContentPane().add(jButton1);
        Panel2.add(jButton1);
        jButton2.setText("OK");
        jButton2.setBounds(140,100, 80, 25);
        getContentPane().add(jButton2);
        Panel2.add(jButton2);
        jButton2.addActionListener(this);
        Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
        setBounds((dimension.width - 361) / 2, (dimension.height - 236) / 2, 361, 236);
    }

    public void actionPerformed(ActionEvent actionevent)
    {
        Object obj1 = actionevent.getSource();
        if(obj1 == jButton2)
        {
            //String as[] = null;
        	/*if(superimpose)
                jpanel2.setTestCorners(jpanel1.getCorners());
            else
            if(SquareButton.isSelected())
                jpanel2.setTestCorners(4);
            else
            if(TriangleButton.isSelected())
                jpanel2.setTestCorners(3);
            else
            if(PolygonButton.isSelected())
            {
                jpanel2.setTestCorners(Integer.parseInt(PolugonSidesField.getText()));
           if(HydroButton.isSelected())
            {
                new KmeansTest("Hydrophobicity", jpanel2.getTestCorners());
                as = KmeansTest.getDist();
                jpanel2.setTestDistrName("Hydrophobicity");
            }  else
            if(RatioButton.isSelected())
            {
                new KmeansTest("Molecular Weight", jpanel2.getTestCorners());
                as = KmeansTest.getDist();
                jpanel2.setTestDistrName("Molecular Weight");
            } else
            if(PIButton.isSelected())
            {
                new KmeansTest("pI Values", jpanel2.getTestCorners());
                as = KmeansTest.getDist();
                jpanel2.setTestDistrName("pI Values");
            }
            setVisible(false);
            dispose();*/
            //jpanel2.setTestDistribution(as);
            //jpanel2.setTestSeqColor(Color.BLACK);
   		   if(superimpose)
                new Superimpose(obj, jpanel1, jpanel2);
           else
                new Multiplotsameframe(obj, jpanel1, jpanel2);
   		  setVisible(false);
          dispose();
        }
        
        
         else if(obj1 == jButton1)
        {
            setVisible(false);
            dispose();
        }
    }

    private void exitForm(WindowEvent windowevent)
    {
        setVisible(false);
        dispose();
    }
    	public void itemStateChanged( ItemEvent event )
   	{
 		String as[] = null;
 		
 		if( event.getSource() == selAminoProp
				&& event.getStateChange() == ItemEvent.SELECTED )
				{	/*String s;
					s= new String();
            		s = selAminoProp.getSelectedItem();*/
					if(selAminoProp.getSelectedItem()=="Hydrophobicity")
					{
						/*TestDistr = (new KmeansTest("Hydrophobicity", jpanel1.getTestCorners())).getDist();
                		jpanel1. setTestDistribution(TestDistr);
                		jpanel1.setTestDistrName("Hydrophobicity");
                		System.out.println("testing.........");*/
                		
                		new KmeansTest("Hydrophobicity", jpanel2.getTestCorners());
                		as = KmeansTest.getDist();
                		jpanel2.setTestDistrName("Hydrophobicity");
					}
					else
						if(selAminoProp.getSelectedItem()=="Molecular Weight")
						{
							new KmeansTest("Molecular Weight", jpanel2.getTestCorners());
	                		as = KmeansTest.getDist();
	                		jpanel2.setTestDistrName("Molecular Weight");
							
						}
					
					else
					if(selAminoProp.getSelectedItem()=="pI Values")
					{
						new KmeansTest("pI Values", jpanel2.getTestCorners());
                		as = KmeansTest.getDist();
                		jpanel2.setTestDistrName("pI Values");
							
					}
					else
					if(selAminoProp.getSelectedItem()=="Residue volume")
					{
						
						new KmeansTest("Residue volume", jpanel2.getTestCorners());
                		as = KmeansTest.getDist();
                		jpanel2.setTestDistrName("Residue volume");
						
				
						
					}
					else
					if(selAminoProp.getSelectedItem()=="Composition")
					{
						new KmeansTest("Composition", jpanel2.getTestCorners());
                		as = KmeansTest.getDist();
                		jpanel2.setTestDistrName("Composition");
						
				
                		/*KmeansTest a = (new KmeansTest("Composition", jpanel1.getTestCorners()));
						TestDistr=KmeansTest.getDist();
                		jpanel1. setTestDistribution(TestDistr);
                		jpanel1.setTestDistrName("Composition");
                		System.out.println("testing.........");*/
					}
					else
					if(selAminoProp.getSelectedItem()=="Polarity Partition energy")
					{
						new KmeansTest("Polarity Partition energy", jpanel2.getTestCorners());
                		as = KmeansTest.getDist();
                		jpanel2.setTestDistrName("Polarity Partition energy");
						
				
						
					}
					else
					if(selAminoProp.getSelectedItem()=="Hydration number")
					{
						new KmeansTest("Hydration number", jpanel2.getTestCorners());
                		as = KmeansTest.getDist();
                		jpanel2.setTestDistrName("Hydration number");
							
					}
					else
					if(selAminoProp.getSelectedItem()==" Hydrophilicity value")
					{
						new KmeansTest("Hydrophilicity value", jpanel2.getTestCorners());
                		as = KmeansTest.getDist();
                		jpanel2.setTestDistrName("Hydrophilicity value");
						
				
						
					}
					else
					if(selAminoProp.getSelectedItem()=="Heat capacity")
					{
						new KmeansTest("Heat capacity", jpanel2.getTestCorners());
                		as = KmeansTest.getDist();
                		jpanel2.setTestDistrName("Heat capacity");
						
					}
					else
					if(selAminoProp.getSelectedItem()=="Absolute entropy")
					{
						new KmeansTest("Absolute entropy", jpanel2.getTestCorners());
                		as = KmeansTest.getDist();
                		jpanel2.setTestDistrName("Absolute entropy");
						
					}
					else
					if(selAminoProp.getSelectedItem()=="Entropy of formation")
					{
						new KmeansTest("Entropy of formation", jpanel2.getTestCorners());
                		as = KmeansTest.getDist();
                		jpanel2.setTestDistrName("Entropy of formation");
					
				
						
					}
					else
					if(selAminoProp.getSelectedItem()=="Transfer free energy to surface")
					{
						new KmeansTest("Transfer free energy to surface", jpanel2.getTestCorners());
                		as = KmeansTest.getDist();
                		jpanel2.setTestDistrName("Transfer free energy to surface");
						
				
					}
					
					
			
					else
					if(selAminoProp.getSelectedItem()==	"Normalized relative frequency of bend")
					{
						new KmeansTest("Normalized relative frequency of bend", jpanel2.getTestCorners());
                		as = KmeansTest.getDist();
                		jpanel2.setTestDistrName("Normalized relative frequency of bend");
						
				
					}
					
					
					
					else
					if(selAminoProp.getSelectedItem()=="Average accessible surface area")
					{
						new KmeansTest("Average accessible surface area", jpanel2.getTestCorners());
                		as = KmeansTest.getDist();
                		jpanel2.setTestDistrName("Average accessible surface area");
						
				
					}
					
					
					
					else
					if(selAminoProp.getSelectedItem()=="Percentage of buried residues")
					{
						new KmeansTest("Percentage of buried residues", jpanel2.getTestCorners());
                		as = KmeansTest.getDist();
                		jpanel2.setTestDistrName("Percentage of buried residues");
						
				
					}
					
					else
					if(selAminoProp.getSelectedItem()=="Percentage of exposed residues")
					{
						new KmeansTest("Percentage of exposed residues", jpanel2.getTestCorners());
                		as = KmeansTest.getDist();
                		jpanel2.setTestDistrName("Percentage of exposed residues");
						
					}
					
					else
					if(selAminoProp.getSelectedItem()=="Ratio of buried and accessible molar fractions")
					{
						new KmeansTest("Ratio of buried and accessible molar fractions", jpanel2.getTestCorners());
                		as = KmeansTest.getDist();
                		jpanel2.setTestDistrName("Ratio of buried and accessible molar fractions");
						
				
						
					}
					
					
					else
					if(selAminoProp.getSelectedItem()=="Transfer free energy")
					{
						new KmeansTest("Transfer free energy", jpanel2.getTestCorners());
                		as = KmeansTest.getDist();
                		jpanel2.setTestDistrName("Transfer free energy");
						
					}
					
					else
					if(selAminoProp.getSelectedItem()=="Relative frequency of occurrence")
					{
						new KmeansTest("Relative frequency of occurrence", jpanel2.getTestCorners());
                		as = KmeansTest.getDist();
                		jpanel2.setTestDistrName("Relative frequency of occurrence");
						
					}					
      
      
					
					
					else
					if(selAminoProp.getSelectedItem()=="Relative mutability")
					{
						new KmeansTest("Relative mutability", jpanel2.getTestCorners());
                		as = KmeansTest.getDist();
                		jpanel2.setTestDistrName("Relative mutability");
					
					}
					
					else
					if(selAminoProp.getSelectedItem()=="Amino acid distribution")
					{
						new KmeansTest("Amino acid distribution", jpanel2.getTestCorners());
                		as = KmeansTest.getDist();
                		jpanel2.setTestDistrName("Amino acid distribution");
				
					}
					
					else
					if(selAminoProp.getSelectedItem()=="Sequence frequency")
					{
						new KmeansTest("Sequence frequency", jpanel2.getTestCorners());
                		as = KmeansTest.getDist();
                		jpanel2.setTestDistrName("Sequence frequency");
						
				
					}
					
					else
					if(selAminoProp.getSelectedItem()=="Average relative probability of helix")
					{
						new KmeansTest("Average relative probability of helix", jpanel2.getTestCorners());
                		as = KmeansTest.getDist();
                		jpanel2.setTestDistrName("Average relative probability of helix");
				
				
					}
					
					else
					if(selAminoProp.getSelectedItem()=="Average relative probability of beta-sheet")
					{
						new KmeansTest("Average relative probability of beta-sheet", jpanel2.getTestCorners());
                		as = KmeansTest.getDist();
                		jpanel2.setTestDistrName("Average relative probability of beta-sheet");
					
					}
					
       
					else
					if(selAminoProp.getSelectedItem()=="Average relative probability of inner helix")
					{
						new KmeansTest("Average relative probability of inner helix", jpanel2.getTestCorners());
                		as = KmeansTest.getDist();
                		jpanel2.setTestDistrName("Average relative probability of inner helix");
						
				
					}
					
					else
					if(selAminoProp.getSelectedItem()=="Average relative probability of inner beta-sheet")
					{
						new KmeansTest("Average relative probability of inner beta-sheet", jpanel2.getTestCorners());
                		as = KmeansTest.getDist();
                		jpanel2.setTestDistrName("Average relative probability of inner beta-sheet");
					
					}
					
					else
					if(selAminoProp.getSelectedItem()=="Flexibility parameter for no rigid neighbors")
					{
						new KmeansTest("Flexibility parameter for no rigid neighbors", jpanel2.getTestCorners());
                		as = KmeansTest.getDist();
                		jpanel2.setTestDistrName("Flexibility parameter for no rigid neighbors");
				
					}
					
					else
					if(selAminoProp.getSelectedItem()=="Flexibility parameter for one rigid neighbor")
					{
						new KmeansTest("Flexibility parameter for one rigid neighbor", jpanel2.getTestCorners());
                		as = KmeansTest.getDist();
                		jpanel2.setTestDistrName("Flexibility parameter for one rigid neighbor");
					}
					
					else
					if(selAminoProp.getSelectedItem()=="Apparent partial specific volume")
					{
						new KmeansTest("Apparent partial specific volume", jpanel2.getTestCorners());
                		as = KmeansTest.getDist();
                		jpanel2.setTestDistrName("Apparent partial specific volume");
				
					}
					else
					if(selAminoProp.getSelectedItem()=="Alpha-NH chemical shifts")
					{
						new KmeansTest("Alpha-NH chemical shifts", jpanel2.getTestCorners());
                		as = KmeansTest.getDist();
                		jpanel2.setTestDistrName("Alpha-NH chemical shifts");
				
					}
					
					else
					if(selAminoProp.getSelectedItem()=="Flexibility parameter for two rigid neighbors")
					{
						new KmeansTest("Flexibility parameter for two rigid neighbors", jpanel2.getTestCorners());
                		as = KmeansTest.getDist();
                		jpanel2.setTestDistrName("Flexibility parameter for two rigid neighbors");
						
					}
					
					else
					if(selAminoProp.getSelectedItem()=="The Kerr-constant increments")
					{
						new KmeansTest("The Kerr-constant increments", jpanel2.getTestCorners());
                		as = KmeansTest.getDist();
                		jpanel2.setTestDistrName("The Kerr-constant increments");
						
					}
					
					else
					if(selAminoProp.getSelectedItem()=="Net charge")
					{
						new KmeansTest("Net charge", jpanel2.getTestCorners());
                		as = KmeansTest.getDist();
                		jpanel2.setTestDistrName("Net charge");
					
					}
					
					else
					if(selAminoProp.getSelectedItem()=="Side chain interaction parameter")
					{
						new KmeansTest("Side chain interaction parameter", jpanel2.getTestCorners());
                		as = KmeansTest.getDist();
                		jpanel2.setTestDistrName("Side chain interaction parameter");
						
					}
					
					
					else
					if(selAminoProp.getSelectedItem()=="Fraction of site occupied by water")
					{
						new KmeansTest("Fraction of site occupied by water", jpanel2.getTestCorners());
                		as = KmeansTest.getDist();
                		jpanel2.setTestDistrName("Fraction of site occupied by water");
					
					}
					
					else
					if(selAminoProp.getSelectedItem()=="Side chain volume")
					{
						new KmeansTest("Side chain volume", jpanel2.getTestCorners());
                		as = KmeansTest.getDist();
                		jpanel2.setTestDistrName("Side chain volume");
					
					}
					
					else
					if(selAminoProp.getSelectedItem()=="Hydropathy index")
					{
						new KmeansTest("Hydropathy index", jpanel2.getTestCorners());
                		as = KmeansTest.getDist();
                		jpanel2.setTestDistrName("Hydropathy index");
						
					}
					
					else
					if(selAminoProp.getSelectedItem()=="Transfer free energy, CHP/water")
					{
						new KmeansTest("Transfer free energy, CHP/water", jpanel2.getTestCorners());
                		as = KmeansTest.getDist();
                		jpanel2.setTestDistrName("Transfer free energy, CHP/water");
						
				
					}
					
					else
					if(selAminoProp.getSelectedItem()=="Distance between C-alpha and centroid of side chain")
					{
						
						new KmeansTest("Distance between C-alpha and centroid of side chain", jpanel2.getTestCorners());
                		as = KmeansTest.getDist();
                		jpanel2.setTestDistrName("Distance between C-alpha and centroid of side chain");
						
				 	}
					
					else
					if(selAminoProp.getSelectedItem()=="Side chain angle theta(AAR)")
					{
						new KmeansTest("Side chain angle theta(AAR)", jpanel2.getTestCorners());
                		as = KmeansTest.getDist();
                		jpanel2.setTestDistrName("Side chain angle theta(AAR)");
						
					}
					
					else
					if(selAminoProp.getSelectedItem()=="Side chain torsion angle phi(AAAR)")
					{
						new KmeansTest("Side chain torsion angle phi(AAAR)", jpanel2.getTestCorners());
                		as = KmeansTest.getDist();
                		jpanel2.setTestDistrName("Side chain torsion angle phi(AAAR)");
					
					}
					
					else
					if(selAminoProp.getSelectedItem()=="Radius of gyration of side chain")
					{
						new KmeansTest("Radius of gyration of side chain", jpanel2.getTestCorners());
                		as = KmeansTest.getDist();
                		jpanel2.setTestDistrName("Radius of gyration of side chain");
						
				
					}
					
					else
					if(selAminoProp.getSelectedItem()=="van der Waals parameter R0")
					{
						new KmeansTest("van der Waals parameter R0", jpanel2.getTestCorners());
                		as = KmeansTest.getDist();
                		jpanel2.setTestDistrName("van der Waals parameter R0");
						
					}
					
					else
					if(selAminoProp.getSelectedItem()=="Normalized frequency of alpha-helix, with weights")
					{
						new KmeansTest("Normalized frequency of alpha-helix, with weights", jpanel2.getTestCorners());
                		as = KmeansTest.getDist();
                		jpanel2.setTestDistrName("Normalized frequency of alpha-helix, with weights");
						
				
					}
					
					else
					if(selAminoProp.getSelectedItem()=="Normalized frequency of beta-sheet, with weights")
					{
						new KmeansTest("Normalized frequency of beta-sheet, with weights", jpanel2.getTestCorners());
                		as = KmeansTest.getDist();
                		jpanel2.setTestDistrName("Normalized frequency of beta-sheet, with weights");
						
					}
					
					else
					if(selAminoProp.getSelectedItem()=="Normalized frequency of reverse turn, with weights")
					{
						new KmeansTest("Normalized frequency of reverse turn, with weights", jpanel2.getTestCorners());
                		as = KmeansTest.getDist();
                		jpanel2.setTestDistrName("Normalized frequency of reverse turn, with weights");
						
				
					}
					
					else
					if(selAminoProp.getSelectedItem()=="Normalized frequency of alpha-helix, unweighted")
					{
						new KmeansTest("Normalized frequency of alpha-helix, unweighted", jpanel2.getTestCorners());
                		as = KmeansTest.getDist();
                		jpanel2.setTestDistrName("Normalized frequency of alpha-helix, unweighted");
						
				
					}
					
					else
					if(selAminoProp.getSelectedItem()=="Normalized frequency of beta-sheet, unweighted")
					{
						new KmeansTest("Normalized frequency of beta-sheet, unweighted", jpanel2.getTestCorners());
                		as = KmeansTest.getDist();
                		jpanel2.setTestDistrName("Normalized frequency of beta-sheet, unweighted");
						
				
					}
					
					else
					if(selAminoProp.getSelectedItem()=="Normalized frequency of reverse turn, unweighted")
					{
						new KmeansTest("Normalized frequency of reverse turn, unweighted", jpanel2.getTestCorners());
                		as = KmeansTest.getDist();
                		jpanel2.setTestDistrName("Normalized frequency of reverse turn, unweighted");
					
					}
					
					else
					if(selAminoProp.getSelectedItem()=="Frequency of occurrence in beta-bends")
					{
						new KmeansTest("Frequency of occurrence in beta-bends", jpanel2.getTestCorners());
                		as = KmeansTest.getDist();
                		jpanel2.setTestDistrName("Frequency of occurrence in beta-bends");
					
					}
					
					else
					if(selAminoProp.getSelectedItem()=="Alpha-CH chemical shifts")
					{
						new KmeansTest("Alpha-CH chemical shifts", jpanel2.getTestCorners());
                		as = KmeansTest.getDist();
                		jpanel2.setTestDistrName("Alpha-CH chemical shifts");
					
					}
						else
					if(selAminoProp.getSelectedItem()=="Spin-spin coupling constants 3JHalpha-NH")
					{
						new KmeansTest("Spin-spin coupling constants 3JHalpha-NH", jpanel2.getTestCorners());
                		as = KmeansTest.getDist();
                		jpanel2.setTestDistrName("Spin-spin coupling constants 3JHalpha-NH");
					
					}
					
					else
					if(selAminoProp.getSelectedItem()=="Conformational preference for all beta-strands")
					{
						new KmeansTest("Conformational preference for all beta-strands", jpanel2.getTestCorners());
                		as = KmeansTest.getDist();
                		jpanel2.setTestDistrName("Conformational preference for all beta-strands");
					
					}
					
					else
					if(selAminoProp.getSelectedItem()=="Conformational preference for parallel beta-strands")
					{
						new KmeansTest("Conformational preference for parallel beta-strands", jpanel2.getTestCorners());
                		as = KmeansTest.getDist();
                		jpanel2.setTestDistrName("Conformational preference for parallel beta-strands");
					
					}
					
					else
					if(selAminoProp.getSelectedItem()=="Conformational preference for antiparallel beta-strands")
					{
						new KmeansTest("Conformational preference for antiparallel beta-strands", jpanel2.getTestCorners());
                		as = KmeansTest.getDist();
                		jpanel2.setTestDistrName("Conformational preference for antiparallel beta-strands");
						
					}
					
					else
					if(selAminoProp.getSelectedItem()== "Average surrounding hydrophobicity")
					{
						new KmeansTest("Average surrounding hydrophobicity", jpanel2.getTestCorners());
                		as = KmeansTest.getDist();
                		jpanel2.setTestDistrName("Average surrounding hydrophobicity");
					
					}
					else
					if(selAminoProp.getSelectedItem()=="Normalized frequency of alpha-helix")
					{
						new KmeansTest("Normalized frequency of alpha-helix", jpanel2.getTestCorners());
                		as = KmeansTest.getDist();
                		jpanel2.setTestDistrName("Normalized frequency of alpha-helix");
						
					}
						else
					if(selAminoProp.getSelectedItem()=="Normalized frequency of extended structure")
					{
						new KmeansTest("Normalized frequency of extended structure", jpanel2.getTestCorners());
                		as = KmeansTest.getDist();
                		jpanel2.setTestDistrName("Normalized frequency of extended structure");
						
					}
						else
					if(selAminoProp.getSelectedItem()=="Normalized frequency of zeta R")
					{
						new KmeansTest("Normalized frequency of zeta R", jpanel2.getTestCorners());
                		as = KmeansTest.getDist();
                		jpanel2.setTestDistrName("Normalized frequency of zeta R");
						
					}
						else
					if(selAminoProp.getSelectedItem()=="Normalized frequency of left-handed alpha-helix")
					{
						new KmeansTest("Normalized frequency of left-handed alpha-helix", jpanel2.getTestCorners());
                		as = KmeansTest.getDist();
                		jpanel2.setTestDistrName("Normalized frequency of left-handed alpha-helix");
						
				
					}
						else
					if(selAminoProp.getSelectedItem()=="Normalized frequency of alpha region")
					{
						new KmeansTest("Normalized frequency of alpha region", jpanel2.getTestCorners());
                		as = KmeansTest.getDist();
                		jpanel2.setTestDistrName("Normalized frequency of alpha region");
						
				
					}
						else
					if(selAminoProp.getSelectedItem()=="Refractivity")
					{
						new KmeansTest("Refractivity", jpanel2.getTestCorners());
                		as = KmeansTest.getDist();
                		jpanel2.setTestDistrName("Refractivity");
			
					}
						else
					if(selAminoProp.getSelectedItem()=="Average reduced distance for C-alpha")
					{
						new KmeansTest("Average reduced distance for C-alpha", jpanel2.getTestCorners());
                		as = KmeansTest.getDist();
                		jpanel2.setTestDistrName("Average reduced distance for C-alpha");
						
					}
						else
					if(selAminoProp.getSelectedItem()=="Average reduced distance for side chain")
					{
						new KmeansTest("Average reduced distance for side chain", jpanel2.getTestCorners());
                		as = KmeansTest.getDist();
                		jpanel2.setTestDistrName("Average reduced distance for side chain");
						
				
					}
						else
					if(selAminoProp.getSelectedItem()=="Average side chain orientation angle")
					{
						new KmeansTest("Average side chain orientation angle", jpanel2.getTestCorners());
                		as = KmeansTest.getDist();
                		jpanel2.setTestDistrName("Average side chain orientation angle");
						
				
					}
						else
					if(selAminoProp.getSelectedItem()=="Effective partition energy")
					{
						new KmeansTest("Effective partition energy", jpanel2.getTestCorners());
                		as = KmeansTest.getDist();
                		jpanel2.setTestDistrName("Effective partition energy");
					
					}
						else
					if(selAminoProp.getSelectedItem()=="Normalized frequency of alpha-helix")
					{
						new KmeansTest("Normalized frequency of alpha-helix", jpanel2.getTestCorners());
                		as = KmeansTest.getDist();
                		jpanel2.setTestDistrName("Normalized frequency of alpha-helix");
					
					}
						else
					if(selAminoProp.getSelectedItem()=="Normalized frequency of bata-structure")
					{
						new KmeansTest("Normalized frequency of bata-structure", jpanel2.getTestCorners());
                		as = KmeansTest.getDist();
                		jpanel2.setTestDistrName("Normalized frequency of bata-structure");
						
					}
						else
					if(selAminoProp.getSelectedItem()=="Normalized frequency of coil")
					{
						new KmeansTest("Normalized frequency of coil", jpanel2.getTestCorners());
                		as = KmeansTest.getDist();
                		jpanel2.setTestDistrName("Normalized frequency of coil");
					
					}
						else
					if(selAminoProp.getSelectedItem()=="AA composition of total proteins")
					{
						new KmeansTest("AA composition of total proteins", jpanel2.getTestCorners());
                		as = KmeansTest.getDist();
                		jpanel2.setTestDistrName("AA composition of total proteins");
						
				
					}
						else
					if(selAminoProp.getSelectedItem()=="Normalized frequency of extended structure")
					{
						new KmeansTest("Normalized frequency of extended structure", jpanel2.getTestCorners());
                		as = KmeansTest.getDist();
                		jpanel2.setTestDistrName("Normalized frequency of extended structure");
						
					}
						else
					if(selAminoProp.getSelectedItem()=="Steric parameter")
					{
						new KmeansTest("Steric parameter", jpanel2.getTestCorners());
                		as = KmeansTest.getDist();
                		jpanel2.setTestDistrName("Steric parameter");
						
				
					}	else
					if(selAminoProp.getSelectedItem()=="SD of AA composition of total proteins")
					{
						new KmeansTest("SD of AA composition of total proteins", jpanel2.getTestCorners());
                		as = KmeansTest.getDist();
                		jpanel2.setTestDistrName("SD of AA composition of total proteins");
					
					}
						else
					if(selAminoProp.getSelectedItem()=="AA composition of mt-proteins from fungi and plant")
					{
						new KmeansTest("AA composition of mt-proteins from fungi and plant", jpanel2.getTestCorners());
                		as = KmeansTest.getDist();
                		jpanel2.setTestDistrName("AA composition of mt-proteins from fungi and plant");
						
					}
						
						else
					if(selAminoProp.getSelectedItem()=="Polarizability parameter")
					{
						new KmeansTest("Polarizability parameter", jpanel2.getTestCorners());
                		as = KmeansTest.getDist();
                		jpanel2.setTestDistrName("Polarizability parameter");
						
				
					}
					jpanel2.setTestDistribution(as);
            		jpanel2.setTestSeqColor(Color.BLACK);
            			
				}
						
  		
   	}

}
