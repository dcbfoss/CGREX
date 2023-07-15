// FrontEnd Plus GUI for JAD
// DeCompiled : KMeansClusteringDialog.class
//package CGRexpack;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.TitledBorder;

public class KMeansClusteringDialog extends JFrame
    implements ActionListener, ItemListener
{
	public static final long serialVersionUID = 0;
    CGRDrawing jpanel;
    String TestDistr[];
    private JButton Cancel;
   // private ButtonGroup Group;
    private JButton OK;
    private JPanel jPanel1;
    //private JRadioButton jRadioButton1;
    //private JRadioButton jRadioButton2;
    //private JRadioButton jRadioButton3;
    //private JRadioButton jRadioButton4;
    private JComboBox selAminoProp;
    
  //  private JLabel label1;

    



    public KMeansClusteringDialog(CGRDrawing drawing)
    {
        jpanel = null;
        initComponents();
        jpanel = drawing;
        
       // label1 = new JLabel();

              
       
    }

    private void initComponents()
    {
          
        jPanel1 = new JPanel();
        

        /*
        Group = new ButtonGroup();
        jRadioButton1 = new JRadioButton();
        jRadioButton2 = new JRadioButton();
        jRadioButton3 = new JRadioButton();
        jRadioButton4 = new JRadioButton();*/
        
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
		selAminoProp.setBounds(20, 50, 210, 20);
		jPanel1.add(selAminoProp);
		//jPanel1.add(label1);
		//label1.setText("busy");
		
        OK = new JButton();
        Cancel = new JButton();
        getContentPane().setLayout(null);
        setTitle("Applying K-means Clustering for Aminoacids");
        addWindowListener(new WindowAdapter() {

            public void windowClosing(WindowEvent windowevent)
            {
                exitForm(windowevent);
            }

        });
        jPanel1.setLayout(null);
        jPanel1.setBorder(new TitledBorder(null, "Select Properties(selection time 2 mins.) " , 0, 0, new Font("Verdana", 0, 10)));
        //jPanel1.setBorder(new TitledBorder(null, "this will take around 2 minutes", 0, 20, new Font("Verdana", 0, 7)));
        
        /*jRadioButton1.setText("Hydrophobicity");
        Group.add(jRadioButton1);
        jPanel1.add(jRadioButton1);
        jRadioButton1.setBounds(50, 30, 150, 23);
        jRadioButton2.setText("Molecular Weight");
        Group.add(jRadioButton2);
        jPanel1.add(jRadioButton2);
        jRadioButton2.setBounds(50, 60, 160, 23);
        jRadioButton3.setText("pI Values");
        Group.add(jRadioButton3);
        jPanel1.add(jRadioButton3);
        jRadioButton3.setBounds(50, 90, 130, 23);*/
        
        getContentPane().add(jPanel1);
        jPanel1.setBounds(30, 20, 240, 180);
        OK.setText("OK");
        getContentPane().add(OK);
        OK.setBounds(30, 220, 95, 25);
        OK.addActionListener(this);
        Cancel.setText("Cancel");
        Cancel.addActionListener(this);
        getContentPane().add(Cancel);
        Cancel.setBounds(190, 220, 85, 25);
        Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
        setBounds((dimension.width - 322) / 2, (dimension.height - 319) / 2, 322, 319);
    }

    public void actionPerformed(ActionEvent actionevent)
    {
        if(actionevent.getSource() == OK)
        {
            /*if(jRadioButton1.isSelected())
            {
                TestDistr = (new KmeansTest("Hydrophobicity", jpanel.getTestCorners())).getDist();
                jpanel.setTestDistribution(TestDistr);
                jpanel.setTestDistrName("Hydrophobicity");
            } else
            if(jRadioButton2.isSelected())
            {
                TestDistr = (new KmeansTest("Molecular Weight", jpanel.getTestCorners())).getDist();
                jpanel.setTestDistribution(TestDistr);
                jpanel.setTestDistrName("Molecular Weight");
            } else
            if(jRadioButton3.isSelected())
            {
                TestDistr = (new KmeansTest("pI Values", jpanel.getTestCorners())).getDist();
                jpanel.setTestDistribution(TestDistr);
                jpanel.setTestDistrName("pI Values");
            }*/
            setVisible(false);
            dispose();
        } else
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
 		if( event.getSource() == selAminoProp
				&& event.getStateChange() == ItemEvent.SELECTED )
				{
					if(selAminoProp.getSelectedItem()=="Hydrophobicity")
					{
						new KmeansTest("Hydrophobicity", jpanel.getTestCorners());
						TestDistr = KmeansTest.getDist();
						jpanel. setTestDistribution(TestDistr);
                		jpanel.setTestDistrName("Hydrophobicity");
                		System.out.println("testing.........");
					}
					else
					if(selAminoProp.getSelectedItem()=="Molecular Weight")
					{
						new KmeansTest("Molecular Weight", jpanel.getTestCorners());
						TestDistr = KmeansTest.getDist();
						jpanel. setTestDistribution(TestDistr);
                		jpanel.setTestDistrName("Molecular Weight");
                		System.out.println("testing.........");
					}
					else
					if(selAminoProp.getSelectedItem()=="pI Values")
					{
						new KmeansTest("pI Values", jpanel.getTestCorners());
						TestDistr = KmeansTest.getDist();
						jpanel. setTestDistribution(TestDistr);
                		jpanel.setTestDistrName("pI Values");
                		System.out.println("testing.........");
					}
					else
					if(selAminoProp.getSelectedItem()=="Residue volume")
					{
						new KmeansTest("Residue volume", jpanel.getTestCorners());
						TestDistr = KmeansTest.getDist();
						jpanel. setTestDistribution(TestDistr);
                		jpanel.setTestDistrName("Residue volume");
                		System.out.println("testing.........");
					}
					else
					if(selAminoProp.getSelectedItem()=="Composition")
					{
						new KmeansTest("Composition", jpanel.getTestCorners());
						TestDistr = KmeansTest.getDist();
						jpanel. setTestDistribution(TestDistr);
                		jpanel.setTestDistrName("Composition");
                		System.out.println("testing.........");
					}
					else
					if(selAminoProp.getSelectedItem()=="Polarity Partition energy")
					{
						new KmeansTest("Polarity Partition energy", jpanel.getTestCorners());
						TestDistr = KmeansTest.getDist();
						jpanel. setTestDistribution(TestDistr);
                		jpanel.setTestDistrName("Polarity Partition energy");
                		System.out.println("testing.........");
					}
					else
					if(selAminoProp.getSelectedItem()=="Hydration number")
					{
						new KmeansTest("Hydration number", jpanel.getTestCorners());
						TestDistr = KmeansTest.getDist();
						jpanel. setTestDistribution(TestDistr);
                		jpanel.setTestDistrName("Hydration number");
                		System.out.println("testing.........");
					}
					else
					if(selAminoProp.getSelectedItem()==" Hydrophilicity value")
					{
						new KmeansTest("Hydrophilicity value", jpanel.getTestCorners());
						TestDistr = KmeansTest.getDist();
						jpanel. setTestDistribution(TestDistr);
                		jpanel.setTestDistrName("Hydrophilicity value");
                		System.out.println("testing.........");
					}
					else
					if(selAminoProp.getSelectedItem()=="Heat capacity")
					{
						new KmeansTest("Heat capacity", jpanel.getTestCorners());
						TestDistr = KmeansTest.getDist();
						jpanel. setTestDistribution(TestDistr);
                		jpanel.setTestDistrName("Heat capacity");
                		System.out.println("testing.........");
					}
					else
					if(selAminoProp.getSelectedItem()=="Absolute entropy")
					{
						new KmeansTest("Absolute entropy", jpanel.getTestCorners());
						TestDistr = KmeansTest.getDist();
						jpanel. setTestDistribution(TestDistr);
                		jpanel.setTestDistrName("Absolute entropy");
                		System.out.println("testing.........");
					}
					else
					if(selAminoProp.getSelectedItem()=="Entropy of formation")
					{
						new KmeansTest("Entropy of formation", jpanel.getTestCorners());
						TestDistr = KmeansTest.getDist();
						jpanel. setTestDistribution(TestDistr);
                		jpanel.setTestDistrName("Entropy of formation");
                		System.out.println("testing.........");
					}
					else
					if(selAminoProp.getSelectedItem()=="Transfer free energy to surface")
					{
						new KmeansTest("Transfer free energy to surface", jpanel.getTestCorners());
						TestDistr = KmeansTest.getDist();
						jpanel. setTestDistribution(TestDistr);
                		jpanel.setTestDistrName("Transfer free energy to surface");
                		System.out.println("testing.........");
					}
								
					else
					if(selAminoProp.getSelectedItem()==	"Normalized relative frequency of bend")
					{
						new KmeansTest(	"Normalized relative frequency of bend", jpanel.getTestCorners());
						TestDistr = KmeansTest.getDist();
						jpanel. setTestDistribution(TestDistr);
                		jpanel.setTestDistrName(	"Normalized relative frequency of bend");
                		System.out.println("testing.........");
					}
												
					else
					if(selAminoProp.getSelectedItem()=="Average accessible surface area")
					{
						new KmeansTest("Average accessible surface area", jpanel.getTestCorners());
						TestDistr = KmeansTest.getDist();
						jpanel. setTestDistribution(TestDistr);
                		jpanel.setTestDistrName("Average accessible surface area");
                		System.out.println("testing.........");
					}
								
					else
					if(selAminoProp.getSelectedItem()=="Percentage of buried residues")
					{
						new KmeansTest("Percentage of buried residues", jpanel.getTestCorners());
						TestDistr = KmeansTest.getDist();
						jpanel. setTestDistribution(TestDistr);
                		jpanel.setTestDistrName("Percentage of buried residues");
                		System.out.println("testing.........");
					}
					
					else
					if(selAminoProp.getSelectedItem()=="Percentage of exposed residues")
					{
						new KmeansTest("Percentage of exposed residues", jpanel.getTestCorners());
						TestDistr = KmeansTest.getDist();
						jpanel. setTestDistribution(TestDistr);
                		jpanel.setTestDistrName("Percentage of exposed residues");
                		System.out.println("testing.........");
					}
					
					else
					if(selAminoProp.getSelectedItem()=="Ratio of buried and accessible molar fractions")
					{
						new KmeansTest("Ratio of buried and accessible molar fractions", jpanel.getTestCorners());
						TestDistr = KmeansTest.getDist();
						jpanel. setTestDistribution(TestDistr);
                		jpanel.setTestDistrName("Ratio of buried and accessible molar fractions");
                		System.out.println("testing.........");
					}
					
					
					else
					if(selAminoProp.getSelectedItem()=="Transfer free energy")
					{
						new KmeansTest("Transfer free energy", jpanel.getTestCorners());
						TestDistr = KmeansTest.getDist();
						jpanel. setTestDistribution(TestDistr);
                		jpanel.setTestDistrName("Transfer free energy");
                		System.out.println("testing.........");
					}
					
					else
					if(selAminoProp.getSelectedItem()=="Relative frequency of occurrence")
					{
						new KmeansTest("Relative frequency of occurrence", jpanel.getTestCorners());
						TestDistr = KmeansTest.getDist();
						jpanel. setTestDistribution(TestDistr);
                		jpanel.setTestDistrName("Relative frequency of occurrence");
                		System.out.println("testing.........");
					}					
      
      
					
					
					else
					if(selAminoProp.getSelectedItem()=="Relative mutability")
					{
						new KmeansTest("Relative mutability", jpanel.getTestCorners());
						TestDistr = KmeansTest.getDist();
						jpanel. setTestDistribution(TestDistr);
                		jpanel.setTestDistrName("Relative mutability");
                		System.out.println("testing.........");
					}
					
					else
					if(selAminoProp.getSelectedItem()=="Amino acid distribution")
					{
						new KmeansTest("Amino acid distribution", jpanel.getTestCorners());
						TestDistr = KmeansTest.getDist();
						jpanel. setTestDistribution(TestDistr);
                		jpanel.setTestDistrName("Amino acid distribution");
                		System.out.println("testing.........");
					}
					
					else
					if(selAminoProp.getSelectedItem()=="Sequence frequency")
					{
						new KmeansTest("Sequence frequency", jpanel.getTestCorners());
						TestDistr = KmeansTest.getDist();
						jpanel. setTestDistribution(TestDistr);
                		jpanel.setTestDistrName("Sequence frequency");
                		System.out.println("testing.........");
					}
					
					else
					if(selAminoProp.getSelectedItem()=="Average relative probability of helix")
					{
						new KmeansTest("Average relative probability of helix", jpanel.getTestCorners());
						TestDistr = KmeansTest.getDist();
						jpanel. setTestDistribution(TestDistr);
                		jpanel.setTestDistrName("Average relative probability of helix");
                		System.out.println("testing.........");
					}
					
					else
					if(selAminoProp.getSelectedItem()=="Average relative probability of beta-sheet")
					{
						new KmeansTest("Average relative probability of beta-sheet", jpanel.getTestCorners());
						TestDistr = KmeansTest.getDist();
						jpanel. setTestDistribution(TestDistr);
                		jpanel.setTestDistrName("Average relative probability of beta-sheet");
                		System.out.println("testing.........");
					}
					
       
					else
					if(selAminoProp.getSelectedItem()=="Average relative probability of inner helix")
					{
						new KmeansTest("Average relative probability of inner helix", jpanel.getTestCorners());
						TestDistr = KmeansTest.getDist();
						jpanel. setTestDistribution(TestDistr);
                		jpanel.setTestDistrName("Average relative probability of inner helix");
                		System.out.println("testing.........");
					}
					
					else
					if(selAminoProp.getSelectedItem()=="Average relative probability of inner beta-sheet")
					{
						new KmeansTest("Average relative probability of inner beta-sheet", jpanel.getTestCorners());
						TestDistr = KmeansTest.getDist();
						jpanel. setTestDistribution(TestDistr);
                		jpanel.setTestDistrName("Average relative probability of inner beta-sheet");
                		System.out.println("testing.........");
					}
					
					else
					if(selAminoProp.getSelectedItem()=="Flexibility parameter for no rigid neighbors")
					{
						new KmeansTest("Flexibility parameter for no rigid neighbors", jpanel.getTestCorners());
						TestDistr = KmeansTest.getDist();
						jpanel. setTestDistribution(TestDistr);
                		jpanel.setTestDistrName("Flexibility parameter for no rigid neighbors");
                		System.out.println("testing.........");
					}
					
					else
					if(selAminoProp.getSelectedItem()=="Flexibility parameter for one rigid neighbor")
					{
						new KmeansTest("Flexibility parameter for one rigid neighbor", jpanel.getTestCorners());
						TestDistr = KmeansTest.getDist();
						jpanel. setTestDistribution(TestDistr);
                		jpanel.setTestDistrName("Flexibility parameter for one rigid neighbor");
                		System.out.println("testing.........");
					}
					
					else
					if(selAminoProp.getSelectedItem()=="Apparent partial specific volume")
					{
						new KmeansTest("Apparent partial specific volume", jpanel.getTestCorners());
						TestDistr = KmeansTest.getDist();
						jpanel. setTestDistribution(TestDistr);
                		jpanel.setTestDistrName("Apparent partial specific volume");
                		System.out.println("testing.........");
					}
					else
					if(selAminoProp.getSelectedItem()=="Alpha-NH chemical shifts")
					{
						new KmeansTest("Alpha-NH chemical shifts", jpanel.getTestCorners());
						TestDistr = KmeansTest.getDist();
						jpanel. setTestDistribution(TestDistr);
                		jpanel.setTestDistrName("Alpha-NH chemical shifts");
                		System.out.println("testing.........");
					}
					
					else
					if(selAminoProp.getSelectedItem()=="Flexibility parameter for two rigid neighbors")
					{
						new KmeansTest("Flexibility parameter for two rigid neighbors", jpanel.getTestCorners());
						TestDistr = KmeansTest.getDist();
						jpanel. setTestDistribution(TestDistr);
                		jpanel.setTestDistrName("Flexibility parameter for two rigid neighbors");
                		System.out.println("testing.........");
					}
					
					else
					if(selAminoProp.getSelectedItem()=="The Kerr-constant increments")
					{
						new KmeansTest("The Kerr-constant increments", jpanel.getTestCorners());
						TestDistr = KmeansTest.getDist();
						jpanel. setTestDistribution(TestDistr);
                		jpanel.setTestDistrName("The Kerr-constant increments");
                		System.out.println("testing.........");
					}
					
					else
					if(selAminoProp.getSelectedItem()=="Net charge")
					{
						new KmeansTest("Net charge", jpanel.getTestCorners());
						TestDistr = KmeansTest.getDist();
						jpanel. setTestDistribution(TestDistr);
                		jpanel.setTestDistrName("Net charge");
                		System.out.println("testing.........");
					}
					
					else
					if(selAminoProp.getSelectedItem()=="Side chain interaction parameter")
					{
						new KmeansTest("Side chain interaction parameter", jpanel.getTestCorners());
						TestDistr = KmeansTest.getDist();
						jpanel. setTestDistribution(TestDistr);
                		jpanel.setTestDistrName("Side chain interaction parameter");
                		System.out.println("testing.........");
					}
					
					
					else
					if(selAminoProp.getSelectedItem()=="Fraction of site occupied by water")
					{
						new KmeansTest("Fraction of site occupied by water", jpanel.getTestCorners());
						TestDistr = KmeansTest.getDist();
						jpanel. setTestDistribution(TestDistr);
                		jpanel.setTestDistrName("Fraction of site occupied by water");
                		System.out.println("testing.........");
					}
					
					else
					if(selAminoProp.getSelectedItem()=="Side chain volume")
					{
						new KmeansTest("Side chain volume", jpanel.getTestCorners());
						TestDistr = KmeansTest.getDist();
						jpanel. setTestDistribution(TestDistr);
                		jpanel.setTestDistrName("Side chain volume");
                		System.out.println("testing.........");
					}
					
					else
					if(selAminoProp.getSelectedItem()=="Hydropathy index")
					{
						new KmeansTest("Hydropathy index", jpanel.getTestCorners());
						TestDistr = KmeansTest.getDist();
						jpanel. setTestDistribution(TestDistr);
                		jpanel.setTestDistrName("Hydropathy index");
                		System.out.println("testing.........");
					}
					
					else
					if(selAminoProp.getSelectedItem()=="Transfer free energy, CHP/water")
					{
						new KmeansTest("Transfer free energy, CHP/water", jpanel.getTestCorners());
						TestDistr = KmeansTest.getDist();
						jpanel. setTestDistribution(TestDistr);
                		jpanel.setTestDistrName("Transfer free energy, CHP/water");
                		System.out.println("testing.........");
					}
					
					else
					if(selAminoProp.getSelectedItem()=="Distance between C-alpha and centroid of side chain")
					{
						new KmeansTest("Distance between C-alpha and centroid of side chain", jpanel.getTestCorners());
						TestDistr = KmeansTest.getDist();
						jpanel. setTestDistribution(TestDistr);
                		jpanel.setTestDistrName("Distance between C-alpha and centroid of side chain");
                		System.out.println("testing.........");
					}
					
					else
					if(selAminoProp.getSelectedItem()=="Side chain angle theta(AAR)")
					{
						new KmeansTest("Side chain angle theta(AAR)", jpanel.getTestCorners());
						TestDistr = KmeansTest.getDist();
						jpanel. setTestDistribution(TestDistr);
                		jpanel.setTestDistrName("Side chain angle theta(AAR)");
                		System.out.println("testing.........");
					}
					
					else
					if(selAminoProp.getSelectedItem()=="Side chain torsion angle phi(AAAR)")
					{
						new KmeansTest("Side chain torsion angle phi(AAAR)", jpanel.getTestCorners());
						TestDistr = KmeansTest.getDist();
						jpanel. setTestDistribution(TestDistr);
                		jpanel.setTestDistrName("Side chain torsion angle phi(AAAR)");
                		System.out.println("testing.........");
					}
					
					else
					if(selAminoProp.getSelectedItem()=="Radius of gyration of side chain")
					{
						new KmeansTest("Radius of gyration of side chain", jpanel.getTestCorners());
						TestDistr = KmeansTest.getDist();
						jpanel. setTestDistribution(TestDistr);
                		jpanel.setTestDistrName("Radius of gyration of side chain");
                		System.out.println("testing.........");
					}
					
					else
					if(selAminoProp.getSelectedItem()=="van der Waals parameter R0")
					{
						new KmeansTest("van der Waals parameter R0", jpanel.getTestCorners());
						TestDistr = KmeansTest.getDist();
						jpanel. setTestDistribution(TestDistr);
                		jpanel.setTestDistrName("van der Waals parameter R0");
                		System.out.println("testing.........");
					}
					
					else
					if(selAminoProp.getSelectedItem()=="Normalized frequency of alpha-helix, with weights")
					{
						new KmeansTest("Transfer free energy to surface", jpanel.getTestCorners());
						TestDistr = KmeansTest.getDist();
						jpanel. setTestDistribution(TestDistr);
                		jpanel.setTestDistrName("Transfer free energy to surface");
                		System.out.println("testing.........");
					}
					
					else
					if(selAminoProp.getSelectedItem()=="Normalized frequency of beta-sheet, with weights")
					{
						new KmeansTest("Normalized frequency of beta-sheet, with weights", jpanel.getTestCorners());
						TestDistr = KmeansTest.getDist();
						jpanel. setTestDistribution(TestDistr);
                		jpanel.setTestDistrName("Normalized frequency of beta-sheet, with weights");
                		System.out.println("testing.........");
					}
					
					else
					if(selAminoProp.getSelectedItem()=="Normalized frequency of reverse turn, with weights")
					{
						new KmeansTest("Normalized frequency of reverse turn, with weights", jpanel.getTestCorners());
						TestDistr = KmeansTest.getDist();
						jpanel. setTestDistribution(TestDistr);
                		jpanel.setTestDistrName("Normalized frequency of reverse turn, with weights");
                		System.out.println("testing.........");
					}
					
					else
					if(selAminoProp.getSelectedItem()=="Normalized frequency of alpha-helix, unweighted")
					{
						new KmeansTest("Normalized frequency of alpha-helix, unweighted", jpanel.getTestCorners());
						TestDistr = KmeansTest.getDist();
						jpanel. setTestDistribution(TestDistr);
                		jpanel.setTestDistrName("Normalized frequency of alpha-helix, unweighted");
                		System.out.println("testing.........");
					}
					
					else
					if(selAminoProp.getSelectedItem()=="Normalized frequency of beta-sheet, unweighted")
					{
						new KmeansTest("Normalized frequency of beta-sheet, unweighted", jpanel.getTestCorners());
						TestDistr = KmeansTest.getDist();
						jpanel. setTestDistribution(TestDistr);
                		jpanel.setTestDistrName("Normalized frequency of beta-sheet, unweighted");
                		System.out.println("testing.........");
					}
					
					else
					if(selAminoProp.getSelectedItem()=="Normalized frequency of reverse turn, unweighted")
					{
						new KmeansTest("Normalized frequency of reverse turn, unweighted", jpanel.getTestCorners());
						TestDistr = KmeansTest.getDist();
						jpanel. setTestDistribution(TestDistr);
                		jpanel.setTestDistrName("Normalized frequency of reverse turn, unweighted");
                		System.out.println("testing.........");
					}
					
					else
					if(selAminoProp.getSelectedItem()=="Frequency of occurrence in beta-bends")
					{
						new KmeansTest("Frequency of occurrence in beta-bends", jpanel.getTestCorners());
						TestDistr = KmeansTest.getDist();
						jpanel. setTestDistribution(TestDistr);
                		jpanel.setTestDistrName("Frequency of occurrence in beta-bends");
                		System.out.println("testing.........");
					}
					
					else
					if(selAminoProp.getSelectedItem()=="Alpha-CH chemical shifts")
					{
						new KmeansTest("Alpha-CH chemical shifts", jpanel.getTestCorners());
						TestDistr = KmeansTest.getDist();
						jpanel. setTestDistribution(TestDistr);
                		jpanel.setTestDistrName("Alpha-CH chemical shifts");
                		System.out.println("testing.........");
					}
						else
					if(selAminoProp.getSelectedItem()=="Spin-spin coupling constants 3JHalpha-NH")
					{
						new KmeansTest("Transfer free energy to surface", jpanel.getTestCorners());
						TestDistr = KmeansTest.getDist();
						jpanel. setTestDistribution(TestDistr);
                		jpanel.setTestDistrName("Transfer free energy to surface");
                		System.out.println("testing.........");
					}
					
					else
					if(selAminoProp.getSelectedItem()=="Conformational preference for all beta-strands")
					{
						new KmeansTest("Conformational preference for all beta-strands", jpanel.getTestCorners());
						TestDistr = KmeansTest.getDist();
						jpanel. setTestDistribution(TestDistr);
                		jpanel.setTestDistrName("Conformational preference for all beta-strands");
                		System.out.println("testing.........");
					}
					
					else
					if(selAminoProp.getSelectedItem()=="Conformational preference for parallel beta-strands")
					{
						new KmeansTest("Conformational preference for parallel beta-strands", jpanel.getTestCorners());
						TestDistr = KmeansTest.getDist();
						jpanel. setTestDistribution(TestDistr);
                		jpanel.setTestDistrName("Conformational preference for parallel beta-strands");
                		System.out.println("testing.........");
					}
					
					else
					if(selAminoProp.getSelectedItem()=="Conformational preference for antiparallel beta-strands")
					{
						new KmeansTest("Conformational preference for antiparallel beta-strands", jpanel.getTestCorners());
						TestDistr = KmeansTest.getDist();
						jpanel. setTestDistribution(TestDistr);
                		jpanel.setTestDistrName("Conformational preference for antiparallel beta-strands");
                		System.out.println("testing.........");
					}
					
					else
					if(selAminoProp.getSelectedItem()== "Average surrounding hydrophobicity")
					{
						new KmeansTest("Average surrounding hydrophobicity", jpanel.getTestCorners());
						TestDistr = KmeansTest.getDist();
						jpanel. setTestDistribution(TestDistr);
                		jpanel.setTestDistrName("Average surrounding hydrophobicity");
                		System.out.println("testing.........");
					}
					else
					if(selAminoProp.getSelectedItem()=="Normalized frequency of alpha-helix")
					{
						new KmeansTest("Normalized frequency of alpha-helix", jpanel.getTestCorners());
						TestDistr = KmeansTest.getDist();
						jpanel. setTestDistribution(TestDistr);
                		jpanel.setTestDistrName("Normalized frequency of alpha-helix");
                		System.out.println("testing.........");
					}
						else
					if(selAminoProp.getSelectedItem()=="Normalized frequency of extended structure")
					{
						new KmeansTest("Normalized frequency of extended structure", jpanel.getTestCorners());
						TestDistr = KmeansTest.getDist();
						jpanel. setTestDistribution(TestDistr);
                		jpanel.setTestDistrName("Normalized frequency of extended structure");
                		System.out.println("testing.........");
					}
						else
					if(selAminoProp.getSelectedItem()=="Normalized frequency of zeta R")
					{
						new KmeansTest("Normalized frequency of zeta R", jpanel.getTestCorners());
						TestDistr = KmeansTest.getDist();
						jpanel. setTestDistribution(TestDistr);
                		jpanel.setTestDistrName("Normalized frequency of zeta R");
                		System.out.println("testing.........");
					}
						else
					if(selAminoProp.getSelectedItem()=="Normalized frequency of left-handed alpha-helix")
					{
						new KmeansTest("Normalized frequency of left-handed alpha-helix", jpanel.getTestCorners());
						TestDistr = KmeansTest.getDist();
						jpanel. setTestDistribution(TestDistr);
                		jpanel.setTestDistrName("Normalized frequency of left-handed alpha-helix");
                		System.out.println("testing.........");
					}
						else
					if(selAminoProp.getSelectedItem()=="Normalized frequency of alpha region")
					{
						new KmeansTest("Normalized frequency of alpha region", jpanel.getTestCorners());
						TestDistr = KmeansTest.getDist();
						jpanel. setTestDistribution(TestDistr);
                		jpanel.setTestDistrName("Normalized frequency of alpha region");
                		System.out.println("testing.........");
					}
						else
					if(selAminoProp.getSelectedItem()=="Refractivity")
					{
						new KmeansTest("Refractivity", jpanel.getTestCorners());
						TestDistr = KmeansTest.getDist();
						jpanel. setTestDistribution(TestDistr);
                		jpanel.setTestDistrName("Refractivity");
                		System.out.println("testing.........");
					}
						else
					if(selAminoProp.getSelectedItem()=="Average reduced distance for C-alpha")
					{
						new KmeansTest("Average reduced distance for C-alpha", jpanel.getTestCorners());
						TestDistr = KmeansTest.getDist();
						jpanel. setTestDistribution(TestDistr);
                		jpanel.setTestDistrName("Average reduced distance for C-alpha");
                		System.out.println("testing.........");
					}
						else
					if(selAminoProp.getSelectedItem()=="Average reduced distance for side chain")
					{
						new KmeansTest("Average reduced distance for side chain", jpanel.getTestCorners());
						TestDistr = KmeansTest.getDist();
						jpanel. setTestDistribution(TestDistr);
                		jpanel.setTestDistrName("Average reduced distance for side chain");
                		System.out.println("testing.........");
					}
						else
					if(selAminoProp.getSelectedItem()=="Average side chain orientation angle")
					{
						new KmeansTest("Average side chain orientation angle", jpanel.getTestCorners());
						TestDistr = KmeansTest.getDist();
						jpanel. setTestDistribution(TestDistr);
                		jpanel.setTestDistrName("Average side chain orientation angle");
                		System.out.println("testing.........");
					}
						else
					if(selAminoProp.getSelectedItem()=="Effective partition energy")
					{
						new KmeansTest("Effective partition energy", jpanel.getTestCorners());
						TestDistr = KmeansTest.getDist();
						jpanel. setTestDistribution(TestDistr);
                		jpanel.setTestDistrName("Effective partition energy");
                		System.out.println("testing.........");
					}
						else
					if(selAminoProp.getSelectedItem()=="Normalized frequency of alpha-helix")
					{
						new KmeansTest("Normalized frequency of alpha-helix", jpanel.getTestCorners());
						TestDistr = KmeansTest.getDist();
						jpanel. setTestDistribution(TestDistr);
                		jpanel.setTestDistrName("Normalized frequency of alpha-helix");
                		System.out.println("testing.........");
					}
						else
					if(selAminoProp.getSelectedItem()=="Normalized frequency of bata-structure")
					{
						new KmeansTest("Normalized frequency of bata-structure", jpanel.getTestCorners());
						TestDistr = KmeansTest.getDist();
						jpanel. setTestDistribution(TestDistr);
                		jpanel.setTestDistrName("Normalized frequency of bata-structure");
                		System.out.println("testing.........");
					}
						else
					if(selAminoProp.getSelectedItem()=="Normalized frequency of coil")
					{
						new KmeansTest("Normalized frequency of coil", jpanel.getTestCorners());
						TestDistr = KmeansTest.getDist();
						jpanel. setTestDistribution(TestDistr);
                		jpanel.setTestDistrName("Normalized frequency of coil");
                		System.out.println("testing.........");
					}
						else
					if(selAminoProp.getSelectedItem()=="AA composition of total proteins")
					{
						new KmeansTest("AA composition of total proteins", jpanel.getTestCorners());
						TestDistr = KmeansTest.getDist();
						jpanel. setTestDistribution(TestDistr);
                		jpanel.setTestDistrName("AA composition of total proteins");
                		System.out.println("testing.........");
					}
						else
					if(selAminoProp.getSelectedItem()=="Normalized frequency of extended structure")
					{
						new KmeansTest("Normalized frequency of extended structure", jpanel.getTestCorners());
						TestDistr = KmeansTest.getDist();
						jpanel. setTestDistribution(TestDistr);
                		jpanel.setTestDistrName("Normalized frequency of extended structure");
                		System.out.println("testing.........");
					}
						else
					if(selAminoProp.getSelectedItem()=="Steric parameter")
					{
						new KmeansTest("Steric parameter", jpanel.getTestCorners());
						TestDistr = KmeansTest.getDist();
						jpanel. setTestDistribution(TestDistr);
                		jpanel.setTestDistrName("Steric parameter");
                		System.out.println("testing.........");
					}	else
					if(selAminoProp.getSelectedItem()=="SD of AA composition of total proteins")
					{
						new KmeansTest("SD of AA composition of total proteins", jpanel.getTestCorners());
						TestDistr = KmeansTest.getDist();
						jpanel. setTestDistribution(TestDistr);
                		jpanel.setTestDistrName("SD of AA composition of total proteins");
                		System.out.println("testing.........");
					}
						else
					if(selAminoProp.getSelectedItem()=="AA composition of mt-proteins from fungi and plant")
					{
						new KmeansTest("AA composition of mt-proteins from fungi and plant", jpanel.getTestCorners());
						TestDistr = KmeansTest.getDist();
						jpanel. setTestDistribution(TestDistr);
                		jpanel.setTestDistrName("AA composition of mt-proteins from fungi and plant");
                		System.out.println("testing.........");
					}
						else
					if(selAminoProp.getSelectedItem()=="AA composition of mt-proteins from fungi and plant")
					{
						new KmeansTest("AA composition of mt-proteins from fungi and plant", jpanel.getTestCorners());
						TestDistr = KmeansTest.getDist();
						jpanel. setTestDistribution(TestDistr);
                		jpanel.setTestDistrName("AA composition of mt-proteins from fungi and plant");
                		System.out.println("testing.........");
					}
						else
					if(selAminoProp.getSelectedItem()=="Polarizability parameter")
					{
						new KmeansTest("Polarizability parameter", jpanel.getTestCorners());
						TestDistr = KmeansTest.getDist();
                		jpanel. setTestDistribution(TestDistr);
                		jpanel.setTestDistrName("Polarizability parameter");
                		System.out.println("testing.........");
					}	
				}
						
  		
   	}

}
