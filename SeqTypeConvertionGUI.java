// FrontEnd Plus GUI for JAD
// DeCompiled : SeqTypeConversionGUI.class
//package CGRexpack;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import javax.swing.*;
import javax.swing.border.TitledBorder;

public class SeqTypeConvertionGUI extends JFrame
    implements ActionListener
{
	public static final long serialVersionUID = 0;
    static settingsPanel settingsPanel1 = null;
    CGRexMainGUI obj;
    CGRDrawing jpanel1;
    CGRDrawing jpanel2;
    JOptionPane jop;
    private ButtonGroup Group1;
    private ButtonGroup Group2;
    private JButton jButtonBrowse;
    private JButton jButtonOk;
    private JPanel jPanel1;
    private JPanel jPanel2;
    private JRadioButton DNA;
   // private JRadioButton RNA;
    private JRadioButton AminoAcid;
    private JRadioButton TwoIndependentPlot;
    private JRadioButton Superimposebut;


    public SeqTypeConvertionGUI(CGRexMainGUI maingui, CGRDrawing drawing, CGRDrawing drawing1)
    {
        obj = null;
        jpanel1 = null;
        jpanel2 = null;
        jop = null;
        obj = maingui;
        jpanel1 = drawing;
        jpanel2 = drawing1;
        initComponents();
        if(drawing.getSeqStr().equals("DNA"))
        {
            DNA.setEnabled(false);
           // RNA.setEnabled(true);
        } else
        if(drawing.getSeqStr().equals("RNA"))
        {
           // RNA.setEnabled(false);
            DNA.setEnabled(true);
        }
        if(drawing == null)
        {
        //   JOptionPane _tmp = jop;
        //    JOptionPane _tmp1 = jop;
            JOptionPane.showMessageDialog(this, "No Plot", "NO PLOT!!!", 0);
            setVisible(false);
            dispose();
            return;
        } else
        {
            setVisible(true);
            return;
        }
    }

    private void initComponents()
    {
        Group1 = new ButtonGroup();
        Group2 = new ButtonGroup();
        jPanel1 = new JPanel();
        DNA = new JRadioButton();
        //RNA = new JRadioButton();
        AminoAcid = new JRadioButton();
        jPanel2 = new JPanel();
        TwoIndependentPlot = new JRadioButton();
        Superimposebut = new JRadioButton();
        jButtonBrowse = new JButton();
        jButtonOk = new JButton();
        getContentPane().setLayout(null);
        setTitle("SeqTypeConversionGUI");
        addWindowListener(new WindowAdapter() {

            public void windowClosing(WindowEvent windowevent)
            {
                exitForm(windowevent);
            }

        });
        jPanel1.setLayout(null);
        jPanel1.setBorder(new TitledBorder(null, "Convert Sequence Type To", 0, 0, new Font("Verdana", 0, 12)));
        DNA.setText("DNA");
        Group1.add(DNA);
        jPanel1.add(DNA);
        DNA.setBounds(50, 30, 110, 23);
        //RNA.setText("RNA");
      //  Group1.add(RNA);
      //  jPanel1.add(RNA);
       // RNA.setBounds(50, 50, 110, 23);
        AminoAcid.setText("Amino Acid");
        Group1.add(AminoAcid);
        jPanel1.add(AminoAcid);
        AminoAcid.setBounds(50, 70, 120, 23);
        getContentPane().add(jPanel1);
        jPanel1.setBounds(30, 50, 190, 140);
        jPanel2.setLayout(null);
        jPanel2.setBorder(new TitledBorder(null, "Plots", 0, 0, new Font("Verdana", 0, 12)));
        TwoIndependentPlot.setText("Two Independent Plots");
        Group2.add(TwoIndependentPlot);
        jPanel2.add(TwoIndependentPlot);
        TwoIndependentPlot.setBounds(30, 30, 150, 23);
        Superimposebut.setText("Superimpose");
        Group2.add(Superimposebut);
        jPanel2.add(Superimposebut);
        Superimposebut.setBounds(30, 70, 150, 23);
        getContentPane().add(jPanel2);
        jPanel2.setBounds(240, 50, 190, 140);
        jButtonBrowse.setText("OK");
        getContentPane().add(jButtonBrowse);
        jButtonBrowse.setBounds(240, 230, 85, 25);
        jButtonBrowse.addActionListener(this);
        jButtonOk.setText("Cancel");
        jButtonOk.addActionListener(this);
        getContentPane().add(jButtonOk);
        jButtonOk.setBounds(340, 230, 85, 25);
        Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
        setBounds((dimension.width - 457) / 2, (dimension.height - 338) / 2, 457, 338);
    }

    private void exitForm(WindowEvent windowevent)
    {
        setVisible(false);
        dispose();
    }

    public void actionPerformed(ActionEvent actionevent)
    {
    	 System.out.println("jpanel1.getDistrName()"+jpanel1.getDistrName());
         System.out.println("jpanel2.getDistrName()"+jpanel2.getDistrName());
        
        if(actionevent.getSource() == jButtonBrowse)
        {
        	obj.multiSeqfile= obj.SeqFile;
            /*if(RNA.isSelected())
            {
                SeqTypeConversion conversion = new SeqTypeConversion();
                conversion.dnatorna(jpanel1.getSeqStr());
                try
                {
                    FileReader filereader = new FileReader(new File("./Conversion/dnatornaconv.txt"));
                    BufferedReader bufferedreader = new BufferedReader(filereader);
                    jpanel2.setTestSeqStr(bufferedreader.readLine());
                    
                }
                catch(Exception exception)
                {
                    System.out.println("File Cannot be read");
                }
                /*jpanel2.SeqStr = TestSeqStr;
                SeqType = TestSeqType;
                Corners = TestCorners;
                Distr = TestDistr;
                DistrName = TestDistrName;
                SeqColor = TestSeqColor;
                jpanel2.setTestSeqType("RNA");
                jpanel2.setTestCorners(4);
                String as[] = {
                    "A", "G", "U", "C"
                };
                jpanel2.setTestDistribution(as);*/
                
               /* jpanel2.setTestSeqColor(Color.BLACK);
                if(TwoIndependentPlot.isSelected())
                    new Multiplotsameframe(obj, jpanel1, jpanel2);
                else
                if(Superimposebut.isSelected())
                    new Superimpose(obj, jpanel1, jpanel2);
            } else*/
            if(DNA.isSelected())
            {
            	//if(jpanel1.getSeqType().equals("AMINO ACID"))
            	//{
            	SeqTypeConversion conversion1 = new SeqTypeConversion();
            			
                conversion1.aminoacidtodna(jpanel1.getSeqStr());
                System.out.println("today....");
                try
                {
                    FileReader filereader1 = new FileReader(new File("./Conversion/aminoacidtodnaconv.txt"));
                    BufferedReader bufferedreader1 = new BufferedReader(filereader1);
                    jpanel2.setTestSeqStr(bufferedreader1.readLine());
                }
                catch(Exception exception1)
                {
                    System.out.println("File Cannot be read");
                }
                jpanel2.setTestSeqType("DNA");
                jpanel2.setTestCorners(4);
                String as1[] = {
                    "A", "G", "T", "C"
                };
                jpanel2.setTestDistribution(as1);
                jpanel2.setTestSeqColor(Color.BLACK);
                System.out.println("jpanel1.getDistrName()"+jpanel1.getDistrName());
                
                System.out.println("jpanel2.getDistrName()"+jpanel2.getDistrName());
                if(TwoIndependentPlot.isSelected())
                    new Multiplotsameframe(obj, jpanel1, jpanel2);
                else
                if(Superimposebut.isSelected())
                    new Superimpose(obj, jpanel1, jpanel2);
            }
           // }
            else
            if(AminoAcid.isSelected())
            {
                SeqTypeConversion conversion2 = new SeqTypeConversion();
                if(jpanel1.getSeqType().equals("DNA"))
                {
                    conversion2.dnatoaminoacid(jpanel1.getSeqStr());
                    try
                    {
                        FileReader filereader2 = new FileReader(new File("./Conversion/dnatoaminoacidconv.txt"));
                        BufferedReader bufferedreader2 = new BufferedReader(filereader2);
                       // System.out.println("filereader2"+filereader2);
                       // System.out.println("bufferedreader2"+bufferedreader2);
                       // System.out.println("bufferedreader2.readLine()"+bufferedreader2.readLine());
                        jpanel2.setTestSeqStr(bufferedreader2.readLine());
                    }
                    catch(Exception exception2)
                    {
                        System.out.println("File Cannot be read");
                    }
                } else
                if(jpanel1.getSeqType().equals("RNA"))
                {
                    conversion2.rnatoaminoacid(jpanel1.getSeqStr());
                    try
                    {
                        FileReader filereader3 = new FileReader(new File("./Conversion/rnatoaminoacidconv.txt"));
                        BufferedReader bufferedreader3 = new BufferedReader(filereader3);
                        jpanel2.setTestSeqStr(bufferedreader3.readLine());
                    }
                    catch(Exception exception3)
                    {
                        System.out.println("File Cannot be read");
                    }
                }
                jpanel2.setTestSeqType("Amino Acid");
                if(TwoIndependentPlot.isSelected())
                    (new ShapeClustering(obj, jpanel1, jpanel2, false)).setVisible(true);
                else
                if(Superimposebut.isSelected())
                    (new ShapeClustering(obj, jpanel1, jpanel2, true)).setVisible(true);
            }
            setVisible(false);
            dispose();
        } else
        if(actionevent.getSource() == jButtonOk)
        {
            setVisible(false);
            dispose();
        }
    }

}
