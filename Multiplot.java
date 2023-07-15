// FrontEnd Plus GUI for JAD
// DeCompiled : Multiplot.class
//package CGRexpack;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import javax.swing.*;
import javax.swing.border.TitledBorder;

public class Multiplot extends JFrame
    implements ActionListener
{
	public static final long serialVersionUID = 0;
    CGRexMainGUI obj;
    CGRDrawing jpanel1;
    CGRDrawing jpanel2;
    File file;
    JOptionPane jop;
    private JRadioButton AminoAcid;
    private JButton Cancel;
    private JRadioButton DNA;
    private ButtonGroup Group1;
    private ButtonGroup Group2;
    private JRadioButton RNA;
    private JRadioButton Superimposebut;
    private JRadioButton TwoIndependentPlot;
    private JButton jButton1;
    private JButton jButton2;
    private JPanel jPanel1;
    private JPanel jPanel2;

    public Multiplot(CGRexMainGUI mainframe, CGRDrawing drawing, CGRDrawing drawing1)
    {
        obj = null;
        jpanel1 = null;
        jpanel2 = null;
        file = null;
        jop = null;
        obj = mainframe;
        jpanel1 = drawing;
        jpanel2 = drawing1;
        initComponents();
        getContentPane().setLayout(null);
        if(drawing == null)
        {
           // JOptionPane _tmp = jop;
           // JOptionPane _tmp1 = jop;
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
        RNA = new JRadioButton();
        AminoAcid = new JRadioButton();
        jPanel2 = new JPanel();
        TwoIndependentPlot = new JRadioButton();
        Superimposebut = new JRadioButton();
        jButton1 = new JButton();
        jButton2 = new JButton();
        Cancel = new JButton();
        getContentPane().setLayout(null);
        setTitle("Multiplot");
        addWindowListener(new WindowAdapter() {

            public void windowClosing(WindowEvent windowevent)
            {
                exitForm(windowevent);
            }

        });
        jPanel1.setLayout(null);
        jPanel1.setBorder(new TitledBorder(null, "Type of Sequence", 0, 0, new Font("Verdana", 0, 12)));
        DNA.setText("DNA");
        Group2.add(DNA);
        jPanel1.add(DNA);
        DNA.setBounds(50, 30, 80, 23);
        RNA.setText("RNA");
        Group2.add(RNA);
        jPanel1.add(RNA);
        RNA.setBounds(50, 60, 80, 23);
        AminoAcid.setText("Amino Acid");
        Group2.add(AminoAcid);
        jPanel1.add(AminoAcid);
        AminoAcid.setBounds(50, 90, 110, 23);
        getContentPane().add(jPanel1);
        jPanel1.setBounds(20, 40, 240, 170);
        jPanel2.setLayout(null);
        jPanel2.setBorder(new TitledBorder(null, "Plots", 0, 0, new Font("Verdana", 0, 12)));
        TwoIndependentPlot.setText("Two Independent Plot");
        Group1.add(TwoIndependentPlot);
        jPanel2.add(TwoIndependentPlot);
        TwoIndependentPlot.setBounds(40, 30, 160, 23);
        Superimposebut.setText("Superimpose");
        Group1.add(Superimposebut);
        jPanel2.add(Superimposebut);
        Superimposebut.setBounds(40, 90, 120, 23);
        getContentPane().add(jPanel2);
        jPanel2.setBounds(290, 40, 210, 170);
        jButton1.setText("Browse");
        getContentPane().add(jButton1);
        jButton1.setBounds(230, 250, 85, 25);
        jButton1.addActionListener(this);
        jButton2.setText("OK");
        getContentPane().add(jButton2);
        jButton2.setBounds(330, 250, 85, 25);
        jButton2.addActionListener(this);
        jButton2.setEnabled(false);
        Cancel.setText("Cancel");
        Cancel.addActionListener(this);
        getContentPane().add(Cancel);
        Cancel.setBounds(430, 250, 85, 25);
        Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
        setBounds((dimension.width - 540) / 2, (dimension.height - 336) / 2, 540, 336);
    }

    private void exitForm(WindowEvent windowevent)
    {
        setVisible(false);
        dispose();
    }

    public void clearAll()
    {
    	
    }
    
    public void actionPerformed(ActionEvent actionevent)
    {
    	
        if(actionevent.getSource() == jButton1)
        {

            //original strarts from here//
            TextFileFilter textfilefilter = new TextFileFilter();
            textfilefilter.setCurrentDirectory(new File("./Sequences"));
            int i = textfilefilter.showOpenDialog(new JFrame());
            if(i == 0)
                file = textfilefilter.getSelectedFile();
            if(file != null && file.exists())
                jButton2.setEnabled(true);
            else
                jButton2.setEnabled(false);
            obj.multiSeqfile = file;
        } else
        if(actionevent.getSource() == jButton2)
        {
            if(RNA.isSelected())
            {

                  //  FileReader filereader = new FileReader(file);
                  //  BufferedReader bufferedreader = new BufferedReader(filereader);
                  //  jpanel2.setTestSeqStr(bufferedreader.readLine());

                 //............... Insert Read Code here ...............................


                try
                {
					String SeqStr1="";
                    String SeqStr2="";
                    FileReader filereader = new FileReader(file);
                    
                    BufferedReader bufferedreader = new BufferedReader(filereader);
                    // section to read the entire text File
                    while ((SeqStr2=bufferedreader.readLine()) != null)
                     {
                       SeqStr1 += SeqStr2;
				     }
                    filereader.close();
                   jpanel2.setTestSeqStr(SeqStr1);

                }
                catch(Exception exception)
                {
                //    JOptionPane _tmp = jop;
                //    JOptionPane _tmp1 = jop;
                    JOptionPane.showMessageDialog(this, "File not found", "File IO Error", 0);
                }

                //................................................................

                jpanel2.setTestSeqType("RNA");
                jpanel2.setTestCorners(4);
                String as[] = {
                    "A", "G", "U", "C"
                };
                jpanel2.setTestDistribution(as);
                jpanel2.setTestSeqColor(Color.BLACK);
                if(TwoIndependentPlot.isSelected())
                    new Multiplotsameframe(obj, jpanel1, jpanel2);
                else
                if(Superimposebut.isSelected())
                    if(jpanel1.getCorners() == jpanel2.getTestCorners())
                    {
                        new Superimpose(obj, jpanel1, jpanel2);
                    } else
                    {
                    //    JOptionPane _tmp2 = jop;
                     //   JOptionPane _tmp3 = jop;
                        JOptionPane.showMessageDialog(this, "Corner Mismatch", "Corner Mismatch!!!", 0);
                    }
            } else
            if(DNA.isSelected())
            {

                    //FileReader filereader1 = new FileReader(file);
                    //BufferedReader bufferedreader1 = new BufferedReader(filereader1);
                    //  jpanel2.setTestSeqStr(bufferedreader1.readLine());

                try
                {
				    String SeqStr1="";
                    String SeqStr2="";
                    String s;
                    FileReader filereader = new FileReader(file);
                    s=file.getName();
                    BufferedReader bufferedreader = new BufferedReader(filereader);
                    // section to read the entire text File
                    while ((SeqStr2=bufferedreader.readLine()) != null)
                     {
                       SeqStr1 += SeqStr2;
				     }
                    filereader.close();
                    jpanel2.setTestSeqStr(SeqStr1);
                    jpanel2.setDistrName(s);

                }
                catch(Exception exception1)
                {
              //      JOptionPane _tmp4 = jop;
              //      JOptionPane _tmp5 = jop;
                    JOptionPane.showMessageDialog(this, "File not found", "File IO Error", 0);
                }
                jpanel2.setTestSeqType("DNA");
                jpanel2.setTestCorners(4);
                String as1[] = {
                    "A", "G", "T", "C"
                };
                jpanel2.setTestDistribution(as1);
                jpanel2.setTestSeqColor(Color.BLACK);
                if(TwoIndependentPlot.isSelected())
                    new Multiplotsameframe(obj, jpanel1, jpanel2);
                else
                if(Superimposebut.isSelected())
                    if(jpanel1.getCorners() == jpanel2.getTestCorners())
                    {
                        new Superimpose(obj, jpanel1, jpanel2);
                    } else
                    {
                  //      JOptionPane _tmp6 = jop;
                  //      JOptionPane _tmp7 = jop;
                        JOptionPane.showMessageDialog(this, "Corner Mismatch", "Corner Mismatch!!!", 0);
                    }
            } else
            if(AminoAcid.isSelected())
            {

                   // FileReader filereader2 = new FileReader(file);
                  //  BufferedReader bufferedreader2 = new BufferedReader(filereader2);
                  //jpanel2.setTestSeqStr(bufferedreader2.readLine());
               try
                {
				    String SeqStr1="";
                    String SeqStr2="";
                    FileReader filereader = new FileReader(file);
                    BufferedReader bufferedreader = new BufferedReader(filereader);
                    // section to read the entire text File
                    while ((SeqStr2=bufferedreader.readLine()) != null)
                     {
                       SeqStr1 += SeqStr2;
				     }
                    filereader.close();
                    jpanel2.setTestSeqStr(SeqStr1);


                }

               catch(Exception exception2)
                {
               //      	JOptionPane _tmp8 = jop;
               //      	JOptionPane _tmp9 = jop;
                    	JOptionPane.showMessageDialog(this, "File not found", "File IO Error", 0);
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
        if(actionevent.getSource() == Cancel)
        {
            setVisible(false);
            dispose();
        }
    }

}
