// FrontEnd Plus GUI for JAD
// DeCompiled : PredefinedPointAssignment.class
//package CGRexpack;
import java.awt.*;
import java.awt.event.*;

import javax.swing.*;
import javax.swing.border.TitledBorder;

public class PredefinedPointAssignment extends JFrame
    implements ActionListener , ItemListener
{
	public static final long serialVersionUID = 0;	
    CGRDrawing jpanel;
    CGRDrawing jPanel2;
    String TestDistr[] = {
        ""
    };
    settingsPanel Distribution;
    JOptionPane jop;
   // private ButtonGroup Group1;
    
    private JButton jButton3;
    private JButton jButton4;
    private JPanel jPanel1;
    
    private JComboBox selAminoProp;
    
    public PredefinedPointAssignment(CGRDrawing drawing)
    {
        jpanel = null;
        jPanel2 = null;
        Distribution = null;
        initComponents();
        jpanel = drawing;
        Distribution = new settingsPanel("Distribution Of Properties", TestDistr, 340, 170, 190, 210);
        Distribution.setVisible(true);
        getContentPane().add(Distribution);
        Distribution.repaint();
        initTextFields();
    }

    private void initTextFields()
    {
        jPanel2 = new CGRDrawing(280, 250);
        jPanel2.setBounds(30, 50, 285, 255);
        jPanel2.setCorners(jpanel.getTestCorners());
        jPanel2.drawPoly();
        repaint();
        getContentPane().add(jPanel2);
        jPanel2.repaint();
        jPanel2.setVisible(true);
        jPanel2.tf0.setEnabled(true);
        jPanel2.tf1.setEnabled(true);
        jPanel2.tf2.setEnabled(true);
        jPanel2.tf3.setEnabled(true);
        jPanel2.tf4.setEnabled(true);
        jPanel2.tf5.setEnabled(true);
        jPanel2.tf6.setEnabled(true);
        jPanel2.tf7.setEnabled(true);
        jPanel2.tf8.setEnabled(true);
        jPanel2.tf9.setEnabled(true);
        jPanel2.tf10.setEnabled(true);
        jPanel2.tf11.setEnabled(true);
        jPanel2.tf12.setEnabled(true);
        jPanel2.tf13.setEnabled(true);
        jPanel2.tf14.setEnabled(true);
        jPanel2.tf15.setEnabled(true);
        jPanel2.tf16.setEnabled(true);
        jPanel2.tf17.setEnabled(true);
        jPanel2.tf18.setEnabled(true);
        jPanel2.tf19.setEnabled(true);
    }

    private void initComponents()
    {
       // Group1 = new ButtonGroup();
        jPanel1 = new JPanel();
        
        jButton3 = new JButton();
        jButton4 = new JButton();
        getContentPane().setLayout(null);
        setTitle("PredefinedPointAssignment");
        
        //@@@@@@@@@@@@@@@@@@@@@@@@@@
        
        
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
		selAminoProp.setBounds(20, 50, 160, 20);
		jPanel1.add(selAminoProp);
        
        
        
        
        
        
        addWindowListener(new WindowAdapter() {

            public void windowClosing(WindowEvent windowevent)
            {
                exitForm(windowevent);
            }

        });
        jPanel1.setLayout(null);
        jPanel1.setBorder(new TitledBorder(null, "Various Properties", 0, 0, new Font("Verdana", 0, 12)));
       		getContentPane().add(jPanel1);
        		jPanel1.setBounds(340, 20, 190, 120);
        		jButton3.setText("OK");
        		getContentPane().add(jButton3);
        		jButton3.addActionListener(this);
        		jButton3.setBounds(100, 350, 85, 25);
        		jButton4.setText("Cancel");
        		jButton4.addActionListener(this);
        		getContentPane().add(jButton4);
        		jButton4.setBounds(200, 350, 85, 25);
        		Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
        		setBounds((dimension.width - 573) / 2, (dimension.height - 448) / 2, 573, 448);
    }

    public boolean validateDistr()
    {
        boolean flag = true;
        int ai[] = new int[jPanel2.getCorners()];
        String as[] = new String[jPanel2.getCorners()];
        for(int i = 0; i < ai.length; i++)
            ai[i] = i + 1;

        for(int j = 0; j < ai.length; j++)
        {
            if(j == 0 && flag)
            {
                flag = false;
                for(int k = 0; k < ai.length; k++)
                    if(Integer.parseInt(jPanel2.tf0.getText()) == ai[k])
                    {
                        as[j] = TestDistr[ai[k] - 1];
                        ai[k] = 0;
                        flag = true;
                    }

            }
            if(j == 1 && flag)
            {
                flag = false;
                for(int l = 0; l < ai.length; l++)
                    if(Integer.parseInt(jPanel2.tf1.getText()) == ai[l])
                    {
                        as[j] = TestDistr[ai[l] - 1];
                        ai[l] = 0;
                        flag = true;
                    }

            }
            if(j == 2 && flag)
            {
                flag = false;
                for(int i1 = 0; i1 < ai.length; i1++)
                    if(Integer.parseInt(jPanel2.tf2.getText()) == ai[i1])
                    {
                        as[j] = TestDistr[ai[i1] - 1];
                        ai[i1] = 0;
                        flag = true;
                    }

            }
            if(j == 3 && flag)
            {
                flag = false;
                for(int j1 = 0; j1 < ai.length; j1++)
                    if(Integer.parseInt(jPanel2.tf3.getText()) == ai[j1])
                    {
                        as[j] = TestDistr[ai[j1] - 1];
                        ai[j1] = 0;
                        flag = true;
                    }

            }
            if(j == 4 && flag)
            {
                flag = false;
                for(int k1 = 0; k1 < ai.length; k1++)
                    if(Integer.parseInt(jPanel2.tf4.getText()) == ai[k1])
                    {
                        as[j] = TestDistr[ai[k1] - 1];
                        ai[k1] = 0;
                        flag = true;
                    }

            }
            if(j == 5 && flag)
            {
                flag = false;
                for(int l1 = 0; l1 < ai.length; l1++)
                    if(Integer.parseInt(jPanel2.tf5.getText()) == ai[l1])
                    {
                        as[j] = TestDistr[ai[l1] - 1];
                        ai[l1] = 0;
                        flag = true;
                    }

            }
            if(j == 6 && flag)
            {
                flag = false;
                for(int i2 = 0; i2 < ai.length; i2++)
                    if(Integer.parseInt(jPanel2.tf6.getText()) == ai[i2])
                    {
                        as[j] = TestDistr[ai[i2] - 1];
                        ai[i2] = 0;
                        flag = true;
                    }

            }
            if(j == 7 && flag)
            {
                flag = false;
                for(int j2 = 0; j2 < ai.length; j2++)
                    if(Integer.parseInt(jPanel2.tf7.getText()) == ai[j2])
                    {
                        as[j] = TestDistr[ai[j2] - 1];
                        ai[j2] = 0;
                        flag = true;
                    }

            }
            if(j == 8 && flag)
            {
                flag = false;
                for(int k2 = 0; k2 < ai.length; k2++)
                    if(Integer.parseInt(jPanel2.tf8.getText()) == ai[k2])
                    {
                        as[j] = TestDistr[ai[k2] - 1];
                        ai[k2] = 0;
                        flag = true;
                    }

            }
            if(j == 9 && flag)
            {
                flag = false;
                for(int l2 = 0; l2 < ai.length; l2++)
                    if(Integer.parseInt(jPanel2.tf9.getText()) == ai[l2])
                    {
                        as[j] = TestDistr[ai[l2] - 1];
                        ai[l2] = 0;
                        flag = true;
                    }

            }
            if(j == 10 && flag)
            {
                flag = false;
                for(int i3 = 0; i3 < ai.length; i3++)
                    if(Integer.parseInt(jPanel2.tf10.getText()) == ai[i3])
                    {
                        as[j] = TestDistr[ai[i3] - 1];
                        ai[i3] = 0;
                        flag = true;
                    }

            }
            if(j == 11 && flag)
            {
                flag = false;
                for(int j3 = 0; j3 < ai.length; j3++)
                    if(Integer.parseInt(jPanel2.tf11.getText()) == ai[j3])
                    {
                        as[j] = TestDistr[ai[j3] - 1];
                        ai[j3] = 0;
                        flag = true;
                    }

            }
            if(j == 12 && flag)
            {
                flag = false;
                for(int k3 = 0; k3 < ai.length; k3++)
                    if(Integer.parseInt(jPanel2.tf12.getText()) == ai[k3])
                    {
                        as[j] = TestDistr[ai[k3] - 1];
                        ai[k3] = 0;
                        flag = true;
                    }

            }
            if(j == 13 && flag)
            {
                flag = false;
                for(int l3 = 0; l3 < ai.length; l3++)
                    if(Integer.parseInt(jPanel2.tf13.getText()) == ai[l3])
                    {
                        as[j] = TestDistr[ai[l3] - 1];
                        ai[l3] = 0;
                        flag = true;
                    }

            }
            if(j == 14 && flag)
            {
                flag = false;
                for(int i4 = 0; i4 < ai.length; i4++)
                    if(Integer.parseInt(jPanel2.tf14.getText()) == ai[i4])
                    {
                        as[j] = TestDistr[ai[i4] - 1];
                        ai[i4] = 0;
                        flag = true;
                    }

            }
            if(j == 15 && flag)
            {
                flag = false;
                for(int j4 = 0; j4 < ai.length; j4++)
                    if(Integer.parseInt(jPanel2.tf15.getText()) == ai[j4])
                    {
                        as[j] = TestDistr[ai[j4] - 1];
                        ai[j4] = 0;
                        flag = true;
                    }

            }
            if(j == 16 && flag)
            {
                flag = false;
                for(int k4 = 0; k4 < ai.length; k4++)
                    if(Integer.parseInt(jPanel2.tf16.getText()) == ai[k4])
                    {
                        as[j] = TestDistr[ai[k4] - 1];
                        ai[k4] = 0;
                        flag = true;
                    }

            }
            if(j == 17 && flag)
            {
                flag = false;
                for(int l4 = 0; l4 < ai.length; l4++)
                    if(Integer.parseInt(jPanel2.tf17.getText()) == ai[l4])
                    {
                        as[j] = TestDistr[ai[l4] - 1];
                        ai[l4] = 0;
                        flag = true;
                    }

            }
            if(j == 18 && flag)
            {
                flag = false;
                for(int i5 = 0; i5 < ai.length; i5++)
                    if(Integer.parseInt(jPanel2.tf18.getText()) == ai[i5])
                    {
                        as[j] = TestDistr[ai[i5] - 1];
                        ai[i5] = 0;
                        flag = true;
                    }

            }
            if(j != 19 || !flag)
                continue;
            flag = false;
            for(int j5 = 0; j5 < ai.length; j5++)
                if(Integer.parseInt(jPanel2.tf19.getText()) == ai[j5])
                {
                    as[j] = TestDistr[ai[j5] - 1];
                    ai[j5] = 0;
                    flag = true;
                }

        }

        if(flag)
            TestDistr = as;
        return flag;
    }
	

    public void actionPerformed(ActionEvent actionevent)
    {
        jPanel2.setVisible(false);
        getContentPane().remove(jPanel2);
        Object obj = actionevent.getSource();
              
        if(obj == jButton3)
        {
            if(TestDistr != null)
                if(validateDistr())
                {
                    jpanel.setTestDistribution(TestDistr);
                    setVisible(false);
                    dispose();
                } else
                {
                   // JOptionPane _tmp = jop;
                    //JOptionPane _tmp1 = jop;
                    JOptionPane.showMessageDialog(this, "Invalid Distribution", "Number the corners correctly", 0);
                }
        } else
        if(obj == jButton4)
        {
            setVisible(false);
            dispose();
        }
        initTextFields();
    }
    public void itemStateChanged( ItemEvent event )
   	{
    	 jPanel2.setVisible(false);
         getContentPane().remove(jPanel2);
         
    	 if( event.getSource() == selAminoProp
				&& event.getStateChange() == ItemEvent.SELECTED )
				{
				 if(selAminoProp.getSelectedItem()=="Hydrophobicity")
					{	Distribution.setVisible(false);
						getContentPane().remove(Distribution);
						Distribution.repaint();
						System.out.println("testing..hiiiiiiii....");
						
						
						new KmeansTest("Hydrophobicity", jpanel.getTestCorners());
						TestDistr = KmeansTest.getDist();
                		jpanel.setTestDistrName("Hydrophobicity");
                		Distribution = new settingsPanel("Distribution Of Properties", TestDistr, 340, 170, 190, 210);
      		           
						/*Distribution = null;
						TestDistr = (new KmeansTest("Hydrophobicity", jpanel.getTestCorners())).getDist();
    		            
    		            */
    		            
    		            Distribution.setVisible(true);
    		            getContentPane().add(Distribution);
    		            Distribution.repaint();
    		            jpanel. setTestDistribution(TestDistr);
                		jpanel.setTestDistrName("Hydrophobicity");
                	}
					
					else
					if(selAminoProp.getSelectedItem()=="Molecular Weight")
					{
						Distribution.setVisible(false);
						getContentPane().remove(Distribution);
						Distribution.repaint();
						Distribution = null;
						
						new KmeansTest("Molecular Weight", jpanel.getTestCorners());
						TestDistr = KmeansTest.getDist();
                		jpanel.setTestDistrName("Molecular Weight");
              	
						Distribution = new settingsPanel("Distribution Of Properties", TestDistr, 340, 170, 190, 210);
    		            Distribution.setVisible(true);
    		            getContentPane().add(Distribution);
    		            Distribution.repaint();
                		jpanel. setTestDistribution(TestDistr);
                		jpanel.setTestDistrName("Molecular Weight");
                		System.out.println("testing.........");
					}
					else
					if(selAminoProp.getSelectedItem()=="pI Values")
					{
						Distribution.setVisible(false);
						getContentPane().remove(Distribution);
						Distribution.repaint();
						Distribution = null;
						
						
						new KmeansTest("pI Values", jpanel.getTestCorners());
						TestDistr = KmeansTest.getDist();
						Distribution = new settingsPanel("Distribution Of Properties", TestDistr, 340, 170, 190, 210);
    		            Distribution.setVisible(true);
    		            getContentPane().add(Distribution);
    		            Distribution.repaint();
						jpanel. setTestDistribution(TestDistr);
                		jpanel.setTestDistrName("pI Values");
                		System.out.println("testing.........");
					}
					else
					if(selAminoProp.getSelectedItem()=="Residue volume")
					{
						Distribution.setVisible(false);
						getContentPane().remove(Distribution);
						Distribution.repaint();
						System.out.println("testing..hiiiiiiii....");
						Distribution = null;
						
						new KmeansTest("Residue volume", jpanel.getTestCorners());
						TestDistr =KmeansTest.getDist();
						Distribution = new settingsPanel("Distribution Of Properties", TestDistr, 340, 170, 190, 210);
    		            Distribution.setVisible(true);
    		            getContentPane().add(Distribution);
    		            Distribution.repaint();
						jpanel. setTestDistribution(TestDistr);
                		jpanel.setTestDistrName("Residue volume");
                		System.out.println("testing.........");
					}
					else
					if(selAminoProp.getSelectedItem()=="Composition")
					{
						Distribution.setVisible(false);
						getContentPane().remove(Distribution);
						Distribution.repaint();
						System.out.println("testing..hiiiiiiii....");
						Distribution = null;
						new KmeansTest("Composition", jpanel.getTestCorners());
						TestDistr = KmeansTest.getDist();
						Distribution = new settingsPanel("Distribution Of Properties", TestDistr, 340, 170, 190, 210);
    		            Distribution.setVisible(true);
    		            getContentPane().add(Distribution);
    		            Distribution.repaint();
						jpanel. setTestDistribution(TestDistr);
                		jpanel.setTestDistrName("Composition");
                		System.out.println("testing.........");
					}
					else
					if(selAminoProp.getSelectedItem()=="Polarity Partition energy")
					{
						Distribution.setVisible(false);
						getContentPane().remove(Distribution);
						Distribution.repaint();
						System.out.println("testing..hiiiiiiii....");
						Distribution = null;
						new KmeansTest("Polarity Partition energy", jpanel.getTestCorners());
						TestDistr = KmeansTest.getDist();
						Distribution = new settingsPanel("Distribution Of Properties", TestDistr, 340, 170, 190, 210);
    		            Distribution.setVisible(true);
    		            getContentPane().add(Distribution);
    		            Distribution.repaint();
						jpanel. setTestDistribution(TestDistr);
                		jpanel.setTestDistrName("Polarity Partition energy");
                		System.out.println("testing.........");
					}
					else
					if(selAminoProp.getSelectedItem()=="Hydration number")
					{
						Distribution.setVisible(false);
						getContentPane().remove(Distribution);
						Distribution.repaint();
						System.out.println("testing..hiiiiiiii....");
						Distribution = null;
						new KmeansTest("Hydration number", jpanel.getTestCorners());
						TestDistr = KmeansTest.getDist();
						Distribution = new settingsPanel("Distribution Of Properties", TestDistr, 340, 170, 190, 210);
    		            Distribution.setVisible(true);
    		            getContentPane().add(Distribution);
    		            Distribution.repaint();
						jpanel. setTestDistribution(TestDistr);
                		jpanel.setTestDistrName("Hydration number");
                		System.out.println("testing.........");
					}
					else
					if(selAminoProp.getSelectedItem()==" Hydrophilicity value")
					{
						Distribution.setVisible(false);
						getContentPane().remove(Distribution);
						Distribution.repaint();
						System.out.println("testing..hiiiiiiii....");
						Distribution = null;
						new KmeansTest("Hydrophilicity value", jpanel.getTestCorners());
						TestDistr = KmeansTest.getDist();
						Distribution = new settingsPanel("Distribution Of Properties", TestDistr, 340, 170, 190, 210);
    		            Distribution.setVisible(true);
    		            getContentPane().add(Distribution);
    		            Distribution.repaint();
						jpanel. setTestDistribution(TestDistr);
                		jpanel.setTestDistrName("Hydrophilicity value");
                		System.out.println("testing.........");
					}
					else
					if(selAminoProp.getSelectedItem()=="Heat capacity")
					{
						
						Distribution.setVisible(false);
						getContentPane().remove(Distribution);
						Distribution.repaint();
						System.out.println("testing..hiiiiiiii....");
						Distribution = null;
						
						new KmeansTest("Heat capacity", jpanel.getTestCorners());
						TestDistr = KmeansTest.getDist();
						Distribution = new settingsPanel("Distribution Of Properties", TestDistr, 340, 170, 190, 210);
    		            Distribution.setVisible(true);
    		            getContentPane().add(Distribution);
    		            Distribution.repaint();
						jpanel. setTestDistribution(TestDistr);
                		jpanel.setTestDistrName("Heat capacity");
                		System.out.println("testing.........");
					}
					else
					if(selAminoProp.getSelectedItem()=="Absolute entropy")
					{
						Distribution.setVisible(false);
						getContentPane().remove(Distribution);
						Distribution.repaint();
						System.out.println("testing..hiiiiiiii....");
						Distribution = null;
						new KmeansTest("Absolute entropy", jpanel.getTestCorners());
						TestDistr = KmeansTest.getDist();
						Distribution = new settingsPanel("Distribution Of Properties", TestDistr, 340, 170, 190, 210);
    		            Distribution.setVisible(true);
    		            getContentPane().add(Distribution);
    		            Distribution.repaint();
						jpanel. setTestDistribution(TestDistr);
                		jpanel.setTestDistrName("Absolute entropy");
                		System.out.println("testing.........");
					}
					else
					if(selAminoProp.getSelectedItem()=="Entropy of formation")
					{
						Distribution.setVisible(false);
						getContentPane().remove(Distribution);
						Distribution.repaint();
						System.out.println("testing..hiiiiiiii....");
						Distribution = null;
						new KmeansTest("Entropy of formation", jpanel.getTestCorners());
						TestDistr = KmeansTest.getDist();
						Distribution = new settingsPanel("Distribution Of Properties", TestDistr, 340, 170, 190, 210);
    		            Distribution.setVisible(true);
    		            getContentPane().add(Distribution);
    		            Distribution.repaint();
						jpanel. setTestDistribution(TestDistr);
                		jpanel.setTestDistrName("Entropy of formation");
                		System.out.println("testing.........");
					}
					else
					if(selAminoProp.getSelectedItem()=="Transfer free energy to surface")
					{
						Distribution.setVisible(false);
						getContentPane().remove(Distribution);
						Distribution.repaint();
						System.out.println("testing..hiiiiiiii....");
						Distribution = null;
						new KmeansTest("Transfer free energy to surface", jpanel.getTestCorners());
						TestDistr = KmeansTest.getDist();
						Distribution = new settingsPanel("Distribution Of Properties", TestDistr, 340, 170, 190, 210);
    		            Distribution.setVisible(true);
    		            getContentPane().add(Distribution);
    		            Distribution.repaint();
						jpanel. setTestDistribution(TestDistr);
                		jpanel.setTestDistrName("Transfer free energy to surface");
                		System.out.println("testing.........");
					}
					
					
			
					else
					if(selAminoProp.getSelectedItem()==	"Normalized relative frequency of bend")
					{
						Distribution.setVisible(false);
						getContentPane().remove(Distribution);
						Distribution.repaint();
						System.out.println("testing..hiiiiiiii....");
						Distribution = null;
						new KmeansTest(	"Normalized relative frequency of bend", jpanel.getTestCorners());
						TestDistr = KmeansTest.getDist();
						Distribution = new settingsPanel("Distribution Of Properties", TestDistr, 340, 170, 190, 210);
    		            Distribution.setVisible(true);
    		            getContentPane().add(Distribution);
    		            Distribution.repaint();
						jpanel. setTestDistribution(TestDistr);
                		jpanel.setTestDistrName(	"Normalized relative frequency of bend");
                		System.out.println("testing.........");
					}
					
					
					
					else
					if(selAminoProp.getSelectedItem()=="Average accessible surface area")
					{
						Distribution.setVisible(false);
						getContentPane().remove(Distribution);
						Distribution.repaint();
						System.out.println("testing..hiiiiiiii....");
						Distribution = null;
						new KmeansTest("Average accessible surface area", jpanel.getTestCorners());
						TestDistr = KmeansTest.getDist();
						Distribution = new settingsPanel("Distribution Of Properties", TestDistr, 340, 170, 190, 210);
    		            Distribution.setVisible(true);
    		            getContentPane().add(Distribution);
    		            Distribution.repaint();
						jpanel. setTestDistribution(TestDistr);
                		jpanel.setTestDistrName("Average accessible surface area");
                		System.out.println("testing.........");
					}
					
					
					
					else
					if(selAminoProp.getSelectedItem()=="Percentage of buried residues")
					{
						Distribution.setVisible(false);
						getContentPane().remove(Distribution);
						Distribution.repaint();
						System.out.println("testing..hiiiiiiii....");
						Distribution = null;
						new KmeansTest("Percentage of buried residues", jpanel.getTestCorners());
						TestDistr = KmeansTest.getDist();
						Distribution = new settingsPanel("Distribution Of Properties", TestDistr, 340, 170, 190, 210);
    		            Distribution.setVisible(true);
    		            getContentPane().add(Distribution);
    		            Distribution.repaint();
						jpanel. setTestDistribution(TestDistr);
                		jpanel.setTestDistrName("Percentage of buried residues");
                		System.out.println("testing.........");
					}
					
					else
					if(selAminoProp.getSelectedItem()=="Percentage of exposed residues")
					{
						Distribution.setVisible(false);
						getContentPane().remove(Distribution);
						Distribution.repaint();
						System.out.println("testing..hiiiiiiii....");
						Distribution = null;
						new KmeansTest("Percentage of exposed residues", jpanel.getTestCorners());
						TestDistr = KmeansTest.getDist();
						Distribution = new settingsPanel("Distribution Of Properties", TestDistr, 340, 170, 190, 210);
    		            Distribution.setVisible(true);
    		            getContentPane().add(Distribution);
    		            Distribution.repaint();
						jpanel. setTestDistribution(TestDistr);
                		jpanel.setTestDistrName("Percentage of exposed residues");
                		System.out.println("testing.........");
					}
					
					else
					if(selAminoProp.getSelectedItem()=="Ratio of buried and accessible molar fractions")
					{
						Distribution.setVisible(false);
						getContentPane().remove(Distribution);
						Distribution.repaint();
						System.out.println("testing..hiiiiiiii....");
						Distribution = null;
						new KmeansTest("Ratio of buried and accessible molar fractions", jpanel.getTestCorners());
						TestDistr = KmeansTest.getDist();
						Distribution = new settingsPanel("Distribution Of Properties", TestDistr, 340, 170, 190, 210);
    		            Distribution.setVisible(true);
    		            getContentPane().add(Distribution);
    		            Distribution.repaint();
						jpanel. setTestDistribution(TestDistr);
                		jpanel.setTestDistrName("Ratio of buried and accessible molar fractions");
                		System.out.println("testing.........");
					}
					
					
					else
					if(selAminoProp.getSelectedItem()=="Transfer free energy")
					{
						Distribution.setVisible(false);
						getContentPane().remove(Distribution);
						Distribution.repaint();
						System.out.println("testing..hiiiiiiii....");
						Distribution = null;
						new KmeansTest("Transfer free energy", jpanel.getTestCorners());
						TestDistr = KmeansTest.getDist();
						Distribution = new settingsPanel("Distribution Of Properties", TestDistr, 340, 170, 190, 210);
    		            Distribution.setVisible(true);
    		            getContentPane().add(Distribution);
    		            Distribution.repaint();
						jpanel. setTestDistribution(TestDistr);
                		jpanel.setTestDistrName("Transfer free energy");
                		System.out.println("testing.........");
					}
					
					else
					if(selAminoProp.getSelectedItem()=="Relative frequency of occurrence")
					{
						Distribution.setVisible(false);
						getContentPane().remove(Distribution);
						Distribution.repaint();
						System.out.println("testing..hiiiiiiii....");
						Distribution = null;
						new KmeansTest("Relative frequency of occurrence", jpanel.getTestCorners());
						TestDistr = KmeansTest.getDist();
						Distribution = new settingsPanel("Distribution Of Properties", TestDistr, 340, 170, 190, 210);
    		            Distribution.setVisible(true);
    		            getContentPane().add(Distribution);
    		            Distribution.repaint();
						jpanel. setTestDistribution(TestDistr);
                		jpanel.setTestDistrName("Relative frequency of occurrence");
                		System.out.println("testing.........");
					}					
      
      
					
					
					else
					if(selAminoProp.getSelectedItem()=="Relative mutability")
					{
						Distribution.setVisible(false);
						getContentPane().remove(Distribution);
						Distribution.repaint();
						System.out.println("testing..hiiiiiiii....");
						Distribution = null;
						new KmeansTest("Relative mutability", jpanel.getTestCorners());
						TestDistr = KmeansTest.getDist();
						Distribution = new settingsPanel("Distribution Of Properties", TestDistr, 340, 170, 190, 210);
    		            Distribution.setVisible(true);
    		            getContentPane().add(Distribution);
    		            Distribution.repaint();
						jpanel. setTestDistribution(TestDistr);
                		jpanel.setTestDistrName("Relative mutability");
                		System.out.println("testing.........");
					}
					
					else
					if(selAminoProp.getSelectedItem()=="Amino acid distribution")
					{
						Distribution.setVisible(false);
						getContentPane().remove(Distribution);
						Distribution.repaint();
						System.out.println("testing..hiiiiiiii....");
						Distribution = null;
						new KmeansTest("Amino acid distribution", jpanel.getTestCorners());
						TestDistr = KmeansTest.getDist();
						Distribution = new settingsPanel("Distribution Of Properties", TestDistr, 340, 170, 190, 210);
    		            Distribution.setVisible(true);
    		            getContentPane().add(Distribution);
    		            Distribution.repaint();
						jpanel. setTestDistribution(TestDistr);
                		jpanel.setTestDistrName("Amino acid distribution");
                		System.out.println("testing.........");
					}
					
					else
					if(selAminoProp.getSelectedItem()=="Sequence frequency")
					{
						Distribution.setVisible(false);
						getContentPane().remove(Distribution);
						Distribution.repaint();
						System.out.println("testing..hiiiiiiii....");
						Distribution = null;
						new KmeansTest("Sequence frequency", jpanel.getTestCorners());
						TestDistr = KmeansTest.getDist();
						Distribution = new settingsPanel("Distribution Of Properties", TestDistr, 340, 170, 190, 210);
    		            Distribution.setVisible(true);
    		            getContentPane().add(Distribution);
    		            Distribution.repaint();
						jpanel. setTestDistribution(TestDistr);
                		jpanel.setTestDistrName("Sequence frequency");
                		System.out.println("testing.........");
					}
					
					else
					if(selAminoProp.getSelectedItem()=="Average relative probability of helix")
					{
						Distribution.setVisible(false);
						getContentPane().remove(Distribution);
						Distribution.repaint();
						System.out.println("testing..hiiiiiiii....");
						Distribution = null;
						new KmeansTest("Average relative probability of helix", jpanel.getTestCorners());
						TestDistr = KmeansTest.getDist();
						Distribution = new settingsPanel("Distribution Of Properties", TestDistr, 340, 170, 190, 210);
    		            Distribution.setVisible(true);
    		            getContentPane().add(Distribution);
    		            Distribution.repaint();
						jpanel. setTestDistribution(TestDistr);
                		jpanel.setTestDistrName("Average relative probability of helix");
                		System.out.println("testing.........");
					}
					
					else
					if(selAminoProp.getSelectedItem()=="Average relative probability of beta-sheet")
					{
						Distribution.setVisible(false);
						getContentPane().remove(Distribution);
						Distribution.repaint();
						System.out.println("testing..hiiiiiiii....");
						Distribution = null;
						new KmeansTest("Average relative probability of beta-sheet", jpanel.getTestCorners());
						TestDistr = KmeansTest.getDist();
						Distribution = new settingsPanel("Distribution Of Properties", TestDistr, 340, 170, 190, 210);
    		            Distribution.setVisible(true);
    		            getContentPane().add(Distribution);
    		            Distribution.repaint();
						jpanel. setTestDistribution(TestDistr);
                		jpanel.setTestDistrName("Average relative probability of beta-sheet");
                		System.out.println("testing.........");
					}
					
       
					else
					if(selAminoProp.getSelectedItem()=="Average relative probability of inner helix")
					{
						Distribution.setVisible(false);
						getContentPane().remove(Distribution);
						Distribution.repaint();
						System.out.println("testing..hiiiiiiii....");
						Distribution = null;
						new KmeansTest("Average relative probability of inner helix", jpanel.getTestCorners());
						TestDistr = KmeansTest.getDist();
						Distribution = new settingsPanel("Distribution Of Properties", TestDistr, 340, 170, 190, 210);
    		            Distribution.setVisible(true);
    		            getContentPane().add(Distribution);
    		            Distribution.repaint();
						jpanel. setTestDistribution(TestDistr);
                		jpanel.setTestDistrName("Average relative probability of inner helix");
                		System.out.println("testing.........");
					}
					
					else
					if(selAminoProp.getSelectedItem()=="Average relative probability of inner beta-sheet")
					{
						Distribution.setVisible(false);
						getContentPane().remove(Distribution);
						Distribution.repaint();
						System.out.println("testing..hiiiiiiii....");
						Distribution = null;
						new KmeansTest("Average relative probability of inner beta-sheet", jpanel.getTestCorners());
						TestDistr = KmeansTest.getDist();
						Distribution = new settingsPanel("Distribution Of Properties", TestDistr, 340, 170, 190, 210);
    		            Distribution.setVisible(true);
    		            getContentPane().add(Distribution);
    		            Distribution.repaint();
						jpanel. setTestDistribution(TestDistr);
                		jpanel.setTestDistrName("Average relative probability of inner beta-sheet");
                		System.out.println("testing.........");
					}
					
					else
					if(selAminoProp.getSelectedItem()=="Flexibility parameter for no rigid neighbors")
					{
						Distribution.setVisible(false);
						getContentPane().remove(Distribution);
						Distribution.repaint();
						System.out.println("testing..hiiiiiiii....");
						Distribution = null;
						new KmeansTest("Flexibility parameter for no rigid neighbors", jpanel.getTestCorners());
						TestDistr = KmeansTest.getDist();
						Distribution = new settingsPanel("Distribution Of Properties", TestDistr, 340, 170, 190, 210);
    		            Distribution.setVisible(true);
    		            getContentPane().add(Distribution);
    		            Distribution.repaint();
						jpanel. setTestDistribution(TestDistr);
                		jpanel.setTestDistrName("Flexibility parameter for no rigid neighbors");
                		System.out.println("testing.........");
					}
					
					else
					if(selAminoProp.getSelectedItem()=="Flexibility parameter for one rigid neighbor")
					{
						Distribution.setVisible(false);
						getContentPane().remove(Distribution);
						Distribution.repaint();
						System.out.println("testing..hiiiiiiii....");
						Distribution = null;
						new KmeansTest("Flexibility parameter for one rigid neighbor", jpanel.getTestCorners());
						TestDistr = KmeansTest.getDist();
						Distribution = new settingsPanel("Distribution Of Properties", TestDistr, 340, 170, 190, 210);
    		            Distribution.setVisible(true);
    		            getContentPane().add(Distribution);
    		            Distribution.repaint();
						jpanel. setTestDistribution(TestDistr);
                		jpanel.setTestDistrName("Flexibility parameter for one rigid neighbor");
                		System.out.println("testing.........");
					}
					
					else
					if(selAminoProp.getSelectedItem()=="Apparent partial specific volume")
					{
						Distribution.setVisible(false);
						getContentPane().remove(Distribution);
						Distribution.repaint();
						System.out.println("testing..hiiiiiiii....");
						Distribution = null;
						new KmeansTest("Apparent partial specific volume", jpanel.getTestCorners());
						TestDistr = KmeansTest.getDist();
						Distribution = new settingsPanel("Distribution Of Properties", TestDistr, 340, 170, 190, 210);
    		            Distribution.setVisible(true);
    		            getContentPane().add(Distribution);
    		            Distribution.repaint();
						jpanel. setTestDistribution(TestDistr);
                		jpanel.setTestDistrName("Apparent partial specific volume");
                		System.out.println("testing.........");
					}
					else
					if(selAminoProp.getSelectedItem()=="Alpha-NH chemical shifts")
					{
						Distribution.setVisible(false);
						getContentPane().remove(Distribution);
						Distribution.repaint();
						System.out.println("testing..hiiiiiiii....");
						Distribution = null;
						new KmeansTest("Alpha-NH chemical shifts", jpanel.getTestCorners());
						TestDistr = KmeansTest.getDist();
						Distribution = new settingsPanel("Distribution Of Properties", TestDistr, 340, 170, 190, 210);
    		            Distribution.setVisible(true);
    		            getContentPane().add(Distribution);
    		            Distribution.repaint();
						jpanel. setTestDistribution(TestDistr);
                		jpanel.setTestDistrName("Alpha-NH chemical shifts");
                		System.out.println("testing.........");
					}
					
					else
					if(selAminoProp.getSelectedItem()=="Flexibility parameter for two rigid neighbors")
					{
						Distribution.setVisible(false);
						getContentPane().remove(Distribution);
						Distribution.repaint();
						System.out.println("testing..hiiiiiiii....");
						Distribution = null;
						new KmeansTest("Flexibility parameter for two rigid neighbors", jpanel.getTestCorners());
						TestDistr = KmeansTest.getDist();
						Distribution = new settingsPanel("Distribution Of Properties", TestDistr, 340, 170, 190, 210);
    		            Distribution.setVisible(true);
    		            getContentPane().add(Distribution);
    		            Distribution.repaint();
						jpanel. setTestDistribution(TestDistr);
                		jpanel.setTestDistrName("Flexibility parameter for two rigid neighbors");
                		System.out.println("testing.........");
					}
					
					else
					if(selAminoProp.getSelectedItem()=="The Kerr-constant increments")
					{
						Distribution.setVisible(false);
						getContentPane().remove(Distribution);
						Distribution.repaint();
						System.out.println("testing..hiiiiiiii....");
						Distribution = null;
						new KmeansTest("The Kerr-constant increments", jpanel.getTestCorners());
						TestDistr = KmeansTest.getDist();
						Distribution = new settingsPanel("Distribution Of Properties", TestDistr, 340, 170, 190, 210);
    		            Distribution.setVisible(true);
    		            getContentPane().add(Distribution);
    		            Distribution.repaint();
						jpanel. setTestDistribution(TestDistr);
                		jpanel.setTestDistrName("The Kerr-constant increments");
                		System.out.println("testing.........");
					}
					
					else
					if(selAminoProp.getSelectedItem()=="Net charge")
					{
						Distribution.setVisible(false);
						getContentPane().remove(Distribution);
						Distribution.repaint();
						System.out.println("testing..hiiiiiiii....");
						Distribution = null;
						new KmeansTest("Net charge", jpanel.getTestCorners());
						TestDistr = KmeansTest.getDist();
						Distribution = new settingsPanel("Distribution Of Properties", TestDistr, 340, 170, 190, 210);
    		            Distribution.setVisible(true);
    		            getContentPane().add(Distribution);
    		            Distribution.repaint();
						jpanel. setTestDistribution(TestDistr);
                		jpanel.setTestDistrName("Net charge");
                		System.out.println("testing.........");
					}
					
					else
					if(selAminoProp.getSelectedItem()=="Side chain interaction parameter")
					{
						Distribution.setVisible(false);
						getContentPane().remove(Distribution);
						Distribution.repaint();
						System.out.println("testing..hiiiiiiii....");
						Distribution = null;
						new KmeansTest("Side chain interaction parameter", jpanel.getTestCorners());
						TestDistr = KmeansTest.getDist();
						Distribution = new settingsPanel("Distribution Of Properties", TestDistr, 340, 170, 190, 210);
    		            Distribution.setVisible(true);
    		            getContentPane().add(Distribution);
    		            Distribution.repaint();
						jpanel. setTestDistribution(TestDistr);
                		jpanel.setTestDistrName("Side chain interaction parameter");
                		System.out.println("testing.........");
					}
					
					
					else
					if(selAminoProp.getSelectedItem()=="Fraction of site occupied by water")
					{
						Distribution.setVisible(false);
						getContentPane().remove(Distribution);
						Distribution.repaint();
						System.out.println("testing..hiiiiiiii....");
						Distribution = null;
						new KmeansTest("Fraction of site occupied by water", jpanel.getTestCorners());
						TestDistr = KmeansTest.getDist();
                		
						Distribution = new settingsPanel("Distribution Of Properties", TestDistr, 340, 170, 190, 210);
    		            Distribution.setVisible(true);
    		            getContentPane().add(Distribution);
    		            Distribution.repaint();
    		            jpanel. setTestDistribution(TestDistr);
                		jpanel.setTestDistrName("Fraction of site occupied by water");
                		System.out.println("testing.........");
					}
					
					else
					if(selAminoProp.getSelectedItem()=="Side chain volume")
					{
						Distribution.setVisible(false);
						getContentPane().remove(Distribution);
						Distribution.repaint();
						System.out.println("testing..hiiiiiiii....");
						Distribution = null;
						
						new KmeansTest("Side chain volume", jpanel.getTestCorners());
						TestDistr = KmeansTest.getDist();
						Distribution = new settingsPanel("Distribution Of Properties", TestDistr, 340, 170, 190, 210);
    		            Distribution.setVisible(true);
    		            getContentPane().add(Distribution);
    		            Distribution.repaint();
						jpanel. setTestDistribution(TestDistr);
                		jpanel.setTestDistrName("Side chain volume");
                		System.out.println("testing.........");
					}
					
					else
					if(selAminoProp.getSelectedItem()=="Hydropathy index")
					{
						Distribution.setVisible(false);
						getContentPane().remove(Distribution);
						Distribution.repaint();
						System.out.println("testing..hiiiiiiii....");
						Distribution = null;
						new KmeansTest("Hydropathy index", jpanel.getTestCorners());
						TestDistr = KmeansTest.getDist();
						Distribution = new settingsPanel("Distribution Of Properties", TestDistr, 340, 170, 190, 210);
    		            Distribution.setVisible(true);
    		            getContentPane().add(Distribution);
    		            Distribution.repaint();
						jpanel. setTestDistribution(TestDistr);
                		jpanel.setTestDistrName("Hydropathy index");
                		System.out.println("testing.........");
					}
					
					else
					if(selAminoProp.getSelectedItem()=="Transfer free energy, CHP/water")
					{
						Distribution.setVisible(false);
						getContentPane().remove(Distribution);
						Distribution.repaint();
						System.out.println("testing..hiiiiiiii....");
						Distribution = null;
						new KmeansTest("Transfer free energy, CHP/water", jpanel.getTestCorners());
						TestDistr = KmeansTest.getDist();
						Distribution = new settingsPanel("Distribution Of Properties", TestDistr, 340, 170, 190, 210);
    		            Distribution.setVisible(true);
    		            getContentPane().add(Distribution);
    		            Distribution.repaint();
						jpanel. setTestDistribution(TestDistr);
                		jpanel.setTestDistrName("Transfer free energy, CHP/water");
                		System.out.println("testing.........");
					}
					
					else
					if(selAminoProp.getSelectedItem()=="Distance between C-alpha and centroid of side chain")
					{
						Distribution.setVisible(false);
						getContentPane().remove(Distribution);
						Distribution.repaint();
						System.out.println("testing..hiiiiiiii....");
						Distribution = null;
						new KmeansTest("Distance between C-alpha and centroid of side chain", jpanel.getTestCorners());
						TestDistr = KmeansTest.getDist();
						Distribution = new settingsPanel("Distribution Of Properties", TestDistr, 340, 170, 190, 210);
    		            Distribution.setVisible(true);
    		            getContentPane().add(Distribution);
    		            Distribution.repaint();
						jpanel. setTestDistribution(TestDistr);
                		jpanel.setTestDistrName("Distance between C-alpha and centroid of side chain");
                		System.out.println("testing.........");
					}
					
					else
					if(selAminoProp.getSelectedItem()=="Side chain angle theta(AAR)")
					{
						Distribution.setVisible(false);
						getContentPane().remove(Distribution);
						Distribution.repaint();
						System.out.println("testing..hiiiiiiii....");
						Distribution = null;
						new KmeansTest("Side chain angle theta(AAR)", jpanel.getTestCorners());
						TestDistr = KmeansTest.getDist();
						Distribution = new settingsPanel("Distribution Of Properties", TestDistr, 340, 170, 190, 210);
    		            Distribution.setVisible(true);
    		            getContentPane().add(Distribution);
    		            Distribution.repaint();
						jpanel. setTestDistribution(TestDistr);
                		jpanel.setTestDistrName("Side chain angle theta(AAR)");
                		System.out.println("testing.........");
					}
					
					else
					if(selAminoProp.getSelectedItem()=="Side chain torsion angle phi(AAAR)")
					{
						Distribution.setVisible(false);
						getContentPane().remove(Distribution);
						Distribution.repaint();
						System.out.println("testing..hiiiiiiii....");
						Distribution = null;
						new KmeansTest("Side chain torsion angle phi(AAAR)", jpanel.getTestCorners());
						TestDistr = KmeansTest.getDist();
						Distribution = new settingsPanel("Distribution Of Properties", TestDistr, 340, 170, 190, 210);
    		            Distribution.setVisible(true);
    		            getContentPane().add(Distribution);
    		            Distribution.repaint();
						jpanel. setTestDistribution(TestDistr);
                		jpanel.setTestDistrName("Side chain torsion angle phi(AAAR)");
                		System.out.println("testing.........");
					}
					
					else
					if(selAminoProp.getSelectedItem()=="Radius of gyration of side chain")
					{
						Distribution.setVisible(false);
						getContentPane().remove(Distribution);
						Distribution.repaint();
						System.out.println("testing..hiiiiiiii....");
						Distribution = null;
						new KmeansTest("Radius of gyration of side chain", jpanel.getTestCorners());
						TestDistr = KmeansTest.getDist();
						Distribution = new settingsPanel("Distribution Of Properties", TestDistr, 340, 170, 190, 210);
    		            Distribution.setVisible(true);
    		            getContentPane().add(Distribution);
    		            Distribution.repaint();
						jpanel. setTestDistribution(TestDistr);
                		jpanel.setTestDistrName("Radius of gyration of side chain");
                		System.out.println("testing.........");
					}
					
					else
					if(selAminoProp.getSelectedItem()=="van der Waals parameter R0")
					{
						Distribution.setVisible(false);
						getContentPane().remove(Distribution);
						Distribution.repaint();
						System.out.println("testing..hiiiiiiii....");
						Distribution = null;
						new KmeansTest("van der Waals parameter R0", jpanel.getTestCorners());
						TestDistr = KmeansTest.getDist();
						Distribution = new settingsPanel("Distribution Of Properties", TestDistr, 340, 170, 190, 210);
    		            Distribution.setVisible(true);
    		            getContentPane().add(Distribution);
    		            Distribution.repaint();
						jpanel. setTestDistribution(TestDistr);
                		jpanel.setTestDistrName("van der Waals parameter R0");
                		System.out.println("testing.........");
					}
					
					else
					if(selAminoProp.getSelectedItem()=="Normalized frequency of alpha-helix, with weights")
					{
						Distribution.setVisible(false);
						getContentPane().remove(Distribution);
						Distribution.repaint();
						System.out.println("testing..hiiiiiiii....");
						Distribution = null;
						new KmeansTest("Transfer free energy to surface", jpanel.getTestCorners());
						TestDistr = KmeansTest.getDist();
						Distribution = new settingsPanel("Distribution Of Properties", TestDistr, 340, 170, 190, 210);
    		            Distribution.setVisible(true);
    		            getContentPane().add(Distribution);
    		            Distribution.repaint();
						jpanel. setTestDistribution(TestDistr);
                		jpanel.setTestDistrName("Transfer free energy to surface");
                		System.out.println("testing.........");
					}
					
					else
					if(selAminoProp.getSelectedItem()=="Normalized frequency of beta-sheet, with weights")
					{
						Distribution.setVisible(false);
						getContentPane().remove(Distribution);
						Distribution.repaint();
						System.out.println("testing..hiiiiiiii....");
						Distribution = null;
						new KmeansTest("Normalized frequency of beta-sheet, with weights", jpanel.getTestCorners());
						TestDistr = KmeansTest.getDist();
						Distribution = new settingsPanel("Distribution Of Properties", TestDistr, 340, 170, 190, 210);
    		            Distribution.setVisible(true);
    		            getContentPane().add(Distribution);
    		            Distribution.repaint();
						jpanel. setTestDistribution(TestDistr);
                		jpanel.setTestDistrName("Normalized frequency of beta-sheet, with weights");
                		System.out.println("testing.........");
					}
					
					else
					if(selAminoProp.getSelectedItem()=="Normalized frequency of reverse turn, with weights")
					{
						Distribution.setVisible(false);
						getContentPane().remove(Distribution);
						Distribution.repaint();
						System.out.println("testing..hiiiiiiii....");
						Distribution = null;
						new KmeansTest("Normalized frequency of reverse turn, with weights", jpanel.getTestCorners());
						TestDistr = KmeansTest.getDist();
						Distribution = new settingsPanel("Distribution Of Properties", TestDistr, 340, 170, 190, 210);
    		            Distribution.setVisible(true);
    		            getContentPane().add(Distribution);
    		            Distribution.repaint();
						jpanel. setTestDistribution(TestDistr);
                		jpanel.setTestDistrName("Normalized frequency of reverse turn, with weights");
                		System.out.println("testing.........");
					}
					
					else
					if(selAminoProp.getSelectedItem()=="Normalized frequency of alpha-helix, unweighted")
					{
						Distribution.setVisible(false);
						getContentPane().remove(Distribution);
						Distribution.repaint();
						System.out.println("testing..hiiiiiiii....");
						Distribution = null;
						new KmeansTest("Normalized frequency of alpha-helix, unweighted", jpanel.getTestCorners());
						TestDistr = KmeansTest.getDist();
						Distribution = new settingsPanel("Distribution Of Properties", TestDistr, 340, 170, 190, 210);
    		            Distribution.setVisible(true);
    		            getContentPane().add(Distribution);
    		            Distribution.repaint();
						jpanel. setTestDistribution(TestDistr);
                		jpanel.setTestDistrName("Normalized frequency of alpha-helix, unweighted");
                		System.out.println("testing.........");
					}
					
					else
					if(selAminoProp.getSelectedItem()=="Normalized frequency of beta-sheet, unweighted")
					{
						Distribution.setVisible(false);
						getContentPane().remove(Distribution);
						Distribution.repaint();
						System.out.println("testing..hiiiiiiii....");
						Distribution = null;
						new KmeansTest("Normalized frequency of beta-sheet, unweighted", jpanel.getTestCorners());
						TestDistr = KmeansTest.getDist();
						Distribution = new settingsPanel("Distribution Of Properties", TestDistr, 340, 170, 190, 210);
    		            Distribution.setVisible(true);
    		            getContentPane().add(Distribution);
    		            Distribution.repaint();
						jpanel. setTestDistribution(TestDistr);
                		jpanel.setTestDistrName("Normalized frequency of beta-sheet, unweighted");
                		System.out.println("testing.........");
					}
					
					else
					if(selAminoProp.getSelectedItem()=="Normalized frequency of reverse turn, unweighted")
					{
						Distribution.setVisible(false);
						getContentPane().remove(Distribution);
						Distribution.repaint();
						System.out.println("testing..hiiiiiiii....");
						Distribution = null;
						new KmeansTest("Normalized frequency of reverse turn, unweighted", jpanel.getTestCorners());
						TestDistr = KmeansTest.getDist();
						Distribution = new settingsPanel("Distribution Of Properties", TestDistr, 340, 170, 190, 210);
    		            Distribution.setVisible(true);
    		            getContentPane().add(Distribution);
    		            Distribution.repaint();
						jpanel. setTestDistribution(TestDistr);
                		jpanel.setTestDistrName("Normalized frequency of reverse turn, unweighted");
                		System.out.println("testing.........");
					}
					
					else
					if(selAminoProp.getSelectedItem()=="Frequency of occurrence in beta-bends")
					{
						Distribution.setVisible(false);
						getContentPane().remove(Distribution);
						Distribution.repaint();
						System.out.println("testing..hiiiiiiii....");
						Distribution = null;
						new KmeansTest("Frequency of occurrence in beta-bends", jpanel.getTestCorners());
						TestDistr = KmeansTest.getDist();
						Distribution = new settingsPanel("Distribution Of Properties", TestDistr, 340, 170, 190, 210);
    		            Distribution.setVisible(true);
    		            getContentPane().add(Distribution);
    		            Distribution.repaint();
						jpanel. setTestDistribution(TestDistr);
                		jpanel.setTestDistrName("Frequency of occurrence in beta-bends");
                		System.out.println("testing.........");
					}
					
					else
					if(selAminoProp.getSelectedItem()=="Alpha-CH chemical shifts")
					{
						Distribution.setVisible(false);
						getContentPane().remove(Distribution);
						Distribution.repaint();
						System.out.println("testing..hiiiiiiii....");
						Distribution = null;
						new KmeansTest("Alpha-CH chemical shifts", jpanel.getTestCorners());
						TestDistr = KmeansTest.getDist();
						Distribution = new settingsPanel("Distribution Of Properties", TestDistr, 340, 170, 190, 210);
    		            Distribution.setVisible(true);
    		            getContentPane().add(Distribution);
    		            Distribution.repaint();
						jpanel. setTestDistribution(TestDistr);
                		jpanel.setTestDistrName("Alpha-CH chemical shifts");
                		System.out.println("testing.........");
					}
						else
					if(selAminoProp.getSelectedItem()=="Spin-spin coupling constants 3JHalpha-NH")
					{
						Distribution.setVisible(false);
						getContentPane().remove(Distribution);
						Distribution.repaint();
						System.out.println("testing..hiiiiiiii....");
						Distribution = null;
						new KmeansTest("Transfer free energy to surface", jpanel.getTestCorners());
						TestDistr = KmeansTest.getDist();
						Distribution = new settingsPanel("Distribution Of Properties", TestDistr, 340, 170, 190, 210);
    		            Distribution.setVisible(true);
    		            getContentPane().add(Distribution);
    		            Distribution.repaint();
						jpanel. setTestDistribution(TestDistr);
                		jpanel.setTestDistrName("Transfer free energy to surface");
                		System.out.println("testing.........");
					}
					
					else
					if(selAminoProp.getSelectedItem()=="Conformational preference for all beta-strands")
					{
						Distribution.setVisible(false);
						getContentPane().remove(Distribution);
						Distribution.repaint();
						System.out.println("testing..hiiiiiiii....");
						Distribution = null;
						new KmeansTest("Conformational preference for all beta-strands", jpanel.getTestCorners());
						TestDistr = KmeansTest.getDist();
						Distribution = new settingsPanel("Distribution Of Properties", TestDistr, 340, 170, 190, 210);
    		            Distribution.setVisible(true);
    		            getContentPane().add(Distribution);
    		            Distribution.repaint();
						jpanel. setTestDistribution(TestDistr);
                		jpanel.setTestDistrName("Conformational preference for all beta-strands");
                		System.out.println("testing.........");
					}
					
					else
					if(selAminoProp.getSelectedItem()=="Conformational preference for parallel beta-strands")
					{
						Distribution.setVisible(false);
						getContentPane().remove(Distribution);
						Distribution.repaint();
						System.out.println("testing..hiiiiiiii....");
						Distribution = null;
						new KmeansTest("Conformational preference for parallel beta-strands", jpanel.getTestCorners());
						TestDistr = KmeansTest.getDist();
						Distribution = new settingsPanel("Distribution Of Properties", TestDistr, 340, 170, 190, 210);
    		            Distribution.setVisible(true);
    		            getContentPane().add(Distribution);
    		            Distribution.repaint();
						jpanel. setTestDistribution(TestDistr);
                		jpanel.setTestDistrName("Conformational preference for parallel beta-strands");
                		System.out.println("testing.........");
					}
					
					else
					if(selAminoProp.getSelectedItem()=="Conformational preference for antiparallel beta-strands")
					{
						Distribution.setVisible(false);
						getContentPane().remove(Distribution);
						Distribution.repaint();
						System.out.println("testing..hiiiiiiii....");
						Distribution = null;
						new KmeansTest("Conformational preference for antiparallel beta-strands", jpanel.getTestCorners());
						TestDistr = KmeansTest.getDist();
						Distribution = new settingsPanel("Distribution Of Properties", TestDistr, 340, 170, 190, 210);
    		            Distribution.setVisible(true);
    		            getContentPane().add(Distribution);
    		            Distribution.repaint();
						jpanel. setTestDistribution(TestDistr);
                		jpanel.setTestDistrName("Conformational preference for antiparallel beta-strands");
                		System.out.println("testing.........");
					}
					
					else
					if(selAminoProp.getSelectedItem()== "Average surrounding hydrophobicity")
					{
						Distribution.setVisible(false);
						getContentPane().remove(Distribution);
						Distribution.repaint();
						System.out.println("testing..hiiiiiiii....");
						Distribution = null;
						new KmeansTest("Average surrounding hydrophobicity", jpanel.getTestCorners());
						TestDistr = KmeansTest.getDist();
						Distribution = new settingsPanel("Distribution Of Properties", TestDistr, 340, 170, 190, 210);
    		            Distribution.setVisible(true);
    		            getContentPane().add(Distribution);
    		            Distribution.repaint();
						jpanel. setTestDistribution(TestDistr);
                		jpanel.setTestDistrName("Average surrounding hydrophobicity");
                		System.out.println("testing.........");
					}
					else
					if(selAminoProp.getSelectedItem()=="Normalized frequency of alpha-helix")
					{
						Distribution.setVisible(false);
						getContentPane().remove(Distribution);
						Distribution.repaint();
						System.out.println("testing..hiiiiiiii....");
						Distribution = null;
						new KmeansTest("Normalized frequency of alpha-helix", jpanel.getTestCorners());
						TestDistr = KmeansTest.getDist();
						Distribution = new settingsPanel("Distribution Of Properties", TestDistr, 340, 170, 190, 210);
    		            Distribution.setVisible(true);
    		            getContentPane().add(Distribution);
    		            Distribution.repaint();
						jpanel. setTestDistribution(TestDistr);
                		jpanel.setTestDistrName("Normalized frequency of alpha-helix");
                		System.out.println("testing.........");
					}
						else
					if(selAminoProp.getSelectedItem()=="Normalized frequency of extended structure")
					{
						Distribution.setVisible(false);
						getContentPane().remove(Distribution);
						Distribution.repaint();
						System.out.println("testing..hiiiiiiii....");
						Distribution = null;
						new KmeansTest("Normalized frequency of extended structure", jpanel.getTestCorners());
						TestDistr = KmeansTest.getDist();
						Distribution = new settingsPanel("Distribution Of Properties", TestDistr, 340, 170, 190, 210);
    		            Distribution.setVisible(true);
    		            getContentPane().add(Distribution);
    		            Distribution.repaint();
						jpanel. setTestDistribution(TestDistr);
                		jpanel.setTestDistrName("Normalized frequency of extended structure");
                		System.out.println("testing.........");
					}
						else
					if(selAminoProp.getSelectedItem()=="Normalized frequency of zeta R")
					{
						Distribution.setVisible(false);
						getContentPane().remove(Distribution);
						Distribution.repaint();
						System.out.println("testing..hiiiiiiii....");
						Distribution = null;
						new KmeansTest("Normalized frequency of zeta R", jpanel.getTestCorners());
						TestDistr = KmeansTest.getDist();
						Distribution = new settingsPanel("Distribution Of Properties", TestDistr, 340, 170, 190, 210);
    		            Distribution.setVisible(true);
    		            getContentPane().add(Distribution);
    		            Distribution.repaint();
						jpanel. setTestDistribution(TestDistr);
                		jpanel.setTestDistrName("Normalized frequency of zeta R");
                		System.out.println("testing.........");
					}
						else
					if(selAminoProp.getSelectedItem()=="Normalized frequency of left-handed alpha-helix")
					{
						Distribution.setVisible(false);
						getContentPane().remove(Distribution);
						Distribution.repaint();
						System.out.println("testing..hiiiiiiii....");
						Distribution = null;
						new KmeansTest("Normalized frequency of left-handed alpha-helix", jpanel.getTestCorners());
						TestDistr = KmeansTest.getDist();
						Distribution = new settingsPanel("Distribution Of Properties", TestDistr, 340, 170, 190, 210);
    		            Distribution.setVisible(true);
    		            getContentPane().add(Distribution);
    		            Distribution.repaint();
						jpanel. setTestDistribution(TestDistr);
                		jpanel.setTestDistrName("Normalized frequency of left-handed alpha-helix");
                		System.out.println("testing.........");
					}
						else
					if(selAminoProp.getSelectedItem()=="Normalized frequency of alpha region")
					{
						Distribution.setVisible(false);
						getContentPane().remove(Distribution);
						Distribution.repaint();
						System.out.println("testing..hiiiiiiii....");
						Distribution = null;
						new KmeansTest("Normalized frequency of alpha region", jpanel.getTestCorners());
						TestDistr = KmeansTest.getDist();
						Distribution = new settingsPanel("Distribution Of Properties", TestDistr, 340, 170, 190, 210);
    		            Distribution.setVisible(true);
    		            getContentPane().add(Distribution);
    		            Distribution.repaint();
						jpanel. setTestDistribution(TestDistr);
                		jpanel.setTestDistrName("Normalized frequency of alpha region");
                		System.out.println("testing.........");
					}
						else
					if(selAminoProp.getSelectedItem()=="Refractivity")
					{
						Distribution.setVisible(false);
						getContentPane().remove(Distribution);
						Distribution.repaint();
						System.out.println("testing..hiiiiiiii....");
						Distribution = null;
						new KmeansTest("Refractivity", jpanel.getTestCorners());
						TestDistr = KmeansTest.getDist();
						Distribution = new settingsPanel("Distribution Of Properties", TestDistr, 340, 170, 190, 210);
    		            Distribution.setVisible(true);
    		            getContentPane().add(Distribution);
    		            Distribution.repaint();
						jpanel. setTestDistribution(TestDistr);
                		jpanel.setTestDistrName("Refractivity");
                		System.out.println("testing.........");
					}
						else
					if(selAminoProp.getSelectedItem()=="Average reduced distance for C-alpha")
					{
						Distribution.setVisible(false);
						getContentPane().remove(Distribution);
						Distribution.repaint();
						System.out.println("testing..hiiiiiiii....");
						Distribution = null;
						new KmeansTest("Average reduced distance for C-alpha", jpanel.getTestCorners());
						Distribution = new settingsPanel("Distribution Of Properties", TestDistr, 340, 170, 190, 210);
    		            Distribution.setVisible(true);
    		            getContentPane().add(Distribution);
    		            Distribution.repaint();
						jpanel. setTestDistribution(TestDistr);
                		jpanel.setTestDistrName("Average reduced distance for C-alpha");
                		System.out.println("testing.........");
					}
						else
					if(selAminoProp.getSelectedItem()=="Average reduced distance for side chain")
					{
						Distribution.setVisible(false);
						getContentPane().remove(Distribution);
						Distribution.repaint();
						System.out.println("testing..hiiiiiiii....");
						Distribution = null;
						new KmeansTest("Average reduced distance for side chain", jpanel.getTestCorners());
						TestDistr = KmeansTest.getDist();
						Distribution = new settingsPanel("Distribution Of Properties", TestDistr, 340, 170, 190, 210);
    		            Distribution.setVisible(true);
    		            getContentPane().add(Distribution);
    		            Distribution.repaint();
						jpanel. setTestDistribution(TestDistr);
                		jpanel.setTestDistrName("Average reduced distance for side chain");
                		System.out.println("testing.........");
					}
						else
					if(selAminoProp.getSelectedItem()=="Average side chain orientation angle")
					{
						Distribution.setVisible(false);
						getContentPane().remove(Distribution);
						Distribution.repaint();
						System.out.println("testing..hiiiiiiii....");
						Distribution = null;
						new KmeansTest("Average side chain orientation angle", jpanel.getTestCorners());
						TestDistr = KmeansTest.getDist();
						Distribution = new settingsPanel("Distribution Of Properties", TestDistr, 340, 170, 190, 210);
    		            Distribution.setVisible(true);
    		            getContentPane().add(Distribution);
    		            Distribution.repaint();
						jpanel. setTestDistribution(TestDistr);
                		jpanel.setTestDistrName("Average side chain orientation angle");
                		System.out.println("testing.........");
					}
						else
					if(selAminoProp.getSelectedItem()=="Effective partition energy")
					{
						Distribution.setVisible(false);
						getContentPane().remove(Distribution);
						Distribution.repaint();
						System.out.println("testing..hiiiiiiii....");
						Distribution = null;
						new KmeansTest("Effective partition energy", jpanel.getTestCorners());
						TestDistr = KmeansTest.getDist();
						Distribution = new settingsPanel("Distribution Of Properties", TestDistr, 340, 170, 190, 210);
    		            Distribution.setVisible(true);
    		            getContentPane().add(Distribution);
    		            Distribution.repaint();
						jpanel. setTestDistribution(TestDistr);
                		jpanel.setTestDistrName("Effective partition energy");
                		System.out.println("testing.........");
					}
						else
					if(selAminoProp.getSelectedItem()=="Normalized frequency of alpha-helix")
					{
						Distribution.setVisible(false);
						getContentPane().remove(Distribution);
						Distribution.repaint();
						System.out.println("testing..hiiiiiiii....");
						Distribution = null;
						new KmeansTest("Normalized frequency of alpha-helix", jpanel.getTestCorners());
						TestDistr = KmeansTest.getDist();
						Distribution = new settingsPanel("Distribution Of Properties", TestDistr, 340, 170, 190, 210);
    		            Distribution.setVisible(true);
    		            getContentPane().add(Distribution);
    		            Distribution.repaint();
						jpanel. setTestDistribution(TestDistr);
                		jpanel.setTestDistrName("Normalized frequency of alpha-helix");
                		System.out.println("testing.........");
					}
						else
					if(selAminoProp.getSelectedItem()=="Normalized frequency of bata-structure")
					{
						Distribution.setVisible(false);
						getContentPane().remove(Distribution);
						Distribution.repaint();
						System.out.println("testing..hiiiiiiii....");
						Distribution = null;
						new KmeansTest("Normalized frequency of bata-structure", jpanel.getTestCorners());
						TestDistr = KmeansTest.getDist();
						Distribution = new settingsPanel("Distribution Of Properties", TestDistr, 340, 170, 190, 210);
    		            Distribution.setVisible(true);
    		            getContentPane().add(Distribution);
    		            Distribution.repaint();
						jpanel. setTestDistribution(TestDistr);
                		jpanel.setTestDistrName("Normalized frequency of bata-structure");
                		System.out.println("testing.........");
					}
						else
					if(selAminoProp.getSelectedItem()=="Normalized frequency of coil")
					{
						Distribution.setVisible(false);
						getContentPane().remove(Distribution);
						Distribution.repaint();
						System.out.println("testing..hiiiiiiii....");
						Distribution = null;
						new KmeansTest("Normalized frequency of coil", jpanel.getTestCorners());
						TestDistr = KmeansTest.getDist();
						Distribution = new settingsPanel("Distribution Of Properties", TestDistr, 340, 170, 190, 210);
    		            Distribution.setVisible(true);
    		            getContentPane().add(Distribution);
    		            Distribution.repaint();
						jpanel. setTestDistribution(TestDistr);
                		jpanel.setTestDistrName("Normalized frequency of coil");
                		System.out.println("testing.........");
					}
						else
					if(selAminoProp.getSelectedItem()=="AA composition of total proteins")
					{
						Distribution.setVisible(false);
						getContentPane().remove(Distribution);
						Distribution.repaint();
						System.out.println("testing..hiiiiiiii....");
						Distribution = null;
						new KmeansTest("AA composition of total proteins", jpanel.getTestCorners());
						TestDistr = KmeansTest.getDist();
						Distribution = new settingsPanel("Distribution Of Properties", TestDistr, 340, 170, 190, 210);
    		            Distribution.setVisible(true);
    		            getContentPane().add(Distribution);
    		            Distribution.repaint();
                		jpanel. setTestDistribution(TestDistr);
                		jpanel.setTestDistrName("AA composition of total proteins");
                		System.out.println("testing.........");
					}
						else
					if(selAminoProp.getSelectedItem()=="Normalized frequency of extended structure")
					{
						Distribution.setVisible(false);
						getContentPane().remove(Distribution);
						Distribution.repaint();
						System.out.println("testing..hiiiiiiii....");
						Distribution = null;
						new KmeansTest("Normalized frequency of extended structure", jpanel.getTestCorners());
						TestDistr = KmeansTest.getDist();
						Distribution = new settingsPanel("Distribution Of Properties", TestDistr, 340, 170, 190, 210);
    		            Distribution.setVisible(true);
    		            getContentPane().add(Distribution);
    		            Distribution.repaint();
						jpanel. setTestDistribution(TestDistr);
                		jpanel.setTestDistrName("Normalized frequency of extended structure");
                		System.out.println("testing.........");
					}
						else
					if(selAminoProp.getSelectedItem()=="Steric parameter")
					{
						Distribution.setVisible(false);
						getContentPane().remove(Distribution);
						Distribution.repaint();
						System.out.println("testing..hiiiiiiii....");
						Distribution = null;
						new KmeansTest("Steric parameter", jpanel.getTestCorners());
						TestDistr = KmeansTest.getDist();
						Distribution = new settingsPanel("Distribution Of Properties", TestDistr, 340, 170, 190, 210);
    		            Distribution.setVisible(true);
    		            getContentPane().add(Distribution);
    		            Distribution.repaint();
						jpanel. setTestDistribution(TestDistr);
                		jpanel.setTestDistrName("Steric parameter");
                		System.out.println("testing.........");
					}	else
					if(selAminoProp.getSelectedItem()=="SD of AA composition of total proteins")
					{
						Distribution.setVisible(false);
						getContentPane().remove(Distribution);
						Distribution.repaint();
						System.out.println("testing..hiiiiiiii....");
						Distribution = null;
						new KmeansTest("SD of AA composition of total proteins", jpanel.getTestCorners());
						TestDistr = KmeansTest.getDist();
						Distribution = new settingsPanel("Distribution Of Properties", TestDistr, 340, 170, 190, 210);
    		            Distribution.setVisible(true);
    		            getContentPane().add(Distribution);
    		            Distribution.repaint();
						jpanel. setTestDistribution(TestDistr);
                		jpanel.setTestDistrName("SD of AA composition of total proteins");
                		System.out.println("testing.........");
					}
						else
					if(selAminoProp.getSelectedItem()=="AA composition of mt-proteins from fungi and plant")
					{
						Distribution.setVisible(false);
						getContentPane().remove(Distribution);
						Distribution.repaint();
						Distribution = null;
						new KmeansTest("AA composition of mt-proteins from fungi and plant", jpanel.getTestCorners());
						TestDistr = KmeansTest.getDist();
						Distribution = new settingsPanel("Distribution Of Properties", TestDistr, 340, 170, 190, 210);
    		            Distribution.setVisible(true);
    		            getContentPane().add(Distribution);
    		            Distribution.repaint();
						jpanel. setTestDistribution(TestDistr);
                		jpanel.setTestDistrName("AA composition of mt-proteins from fungi and plant");
               	}
						else
					if(selAminoProp.getSelectedItem()=="AA composition of mt-proteins from fungi and plant")
					{
						Distribution.setVisible(false);
						getContentPane().remove(Distribution);
						Distribution.repaint();
							Distribution = null;
						Distribution.repaint();
						new KmeansTest("AA composition of mt-proteins from fungi and plant", jpanel.getTestCorners());
						TestDistr = KmeansTest.getDist();
						Distribution = new settingsPanel("Distribution Of Properties", TestDistr, 340, 170, 190, 210);
    		            Distribution.setVisible(true);
    		            getContentPane().add(Distribution);
    		            
						jpanel. setTestDistribution(TestDistr);
                		jpanel.setTestDistrName("AA composition of mt-proteins from fungi and plant");
                				}
						else
					if(selAminoProp.getSelectedItem()=="Polarizability parameter")
					{
						Distribution.setVisible(false);
						getContentPane().remove(Distribution);
						Distribution.repaint();
						Distribution = null;
						
						new KmeansTest("Polarizability parameter", jpanel.getTestCorners());
						TestDistr = KmeansTest.getDist();
						Distribution = new settingsPanel("Distribution Of Properties", TestDistr, 340, 170, 190, 210);
    		            Distribution.setVisible(true);
    		            getContentPane().add(Distribution);
    		            Distribution.repaint();
						jpanel. setTestDistribution(TestDistr);
                		jpanel.setTestDistrName("Polarizability parameter");
                				}	
    				initTextFields();
				}
   	}

    private void exitForm(WindowEvent windowevent)
    {
        setVisible(false);
        dispose();
    }

}
