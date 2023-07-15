// FrontEnd Plus GUI for JAD
// DeCompiled : SelectType.class
//package CGRexpack;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.TitledBorder;

public class SelectType extends JFrame
    implements ActionListener
{
	public static final long serialVersionUID = 0;
    private JRadioButton DNA;
    private JRadioButton RNA;
    private JRadioButton AminoAcid;
    private ButtonGroup AGroup;
    private JButton jButton1;
    private JButton jButton2;
    private JPanel jPanel1;
    CGRexMainGUI obj;
    CGRDrawing jpanel;
    Container Content;

    public SelectType(CGRexMainGUI maingui, CGRDrawing drawing)
    {
        obj = null;
        jpanel = null;
        Content = null;
        Content = getContentPane();
        initComponents();
        jpanel = drawing;
        obj = maingui;
    }

    private void initComponents()
    {
        DNA = new JRadioButton();
        RNA = new JRadioButton();
        AminoAcid = new JRadioButton();
        AGroup = new ButtonGroup();
        jButton1 = new JButton();
        jButton2 = new JButton();
        jPanel1 = new JPanel();
        Content.setLayout(null);
        jPanel1.setLayout(null);
        jPanel1.setBorder(new TitledBorder(null, "Type of Sequence", 0, 0, new Font("Arial", 0, 12)));
        DNA.setText("DNA");
        AGroup.add(DNA);
        jPanel1.add(DNA);
        DNA.setBounds(50, 30, 110, 23);
        RNA.setText("RNA");
        AGroup.add(RNA);
        jPanel1.add(RNA);
        RNA.setBounds(50, 60, 110, 23);
        AminoAcid.setText("Amino Acid");
        AGroup.add(AminoAcid);
        jPanel1.add(AminoAcid);
        AminoAcid.setBounds(50, 90, 120, 23);
        Content.add(jPanel1);
        jPanel1.setBounds(40, 40, 330, 170);
        jButton1.setText("OK");
        Content.add(jButton1);
        jButton1.setBounds(170, 250, 85, 25);
        jButton1.addActionListener(this);
        jButton2.setText("Cancel");
        Content.add(jButton2);
        jButton2.addActionListener(this);
        jButton2.setBounds(280, 250, 85, 25);
        Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
        setBounds((dimension.width - 421) / 2, (dimension.height - 331) / 2, 421, 331);
        setTitle("Select Type");
        addWindowListener(new WindowAdapter() {

            public void windowClosing(WindowEvent windowevent)
            {
                exitForm(windowevent);
            }

        });
    }

    public void actionPerformed(ActionEvent actionevent)
    {/*
        Object obj1 = actionevent.getSource();
        if(obj1 == jButton1)
        {
            if(DNA.isSelected())
            {
                jpanel.setTestSeqType("DNA");
                jpanel.setTestCorners(4);
                String as[] = {
                    "A", "G", "T", "C"
                };
                jpanel.setTestDistribution(as);
                obj.enable("PlotShape", false);
                obj.enable("PointsAssignments", false);
                obj.enable("Convert", true);
                obj.enable("DrawCGR", true);
            } else
            if(RNA.isSelected())
            {
                jpanel.setTestSeqType("RNA");
                jpanel.setTestCorners(4);
                String as1[] = {
                    "A", "G", "U", "C"
                };
                jpanel.setTestDistribution(as1);
                obj.enable("PlotShape", false);
                obj.enable("PointsAssignments", false);
                obj.enable("Convert", true);
                obj.enable("DrawCGR", true);
            } else
            if(AminoAcid.isSelected())
            {
                jpanel.setTestSeqType("Amino Acid");
                 jpanel.setTestCorners(20);
                String as1[] = {"A", "R", "N", "D", "C", "E", "Q", "G", "H", "I",
        "L", "K", "M", "F", "P", "S", "T", "W", "Y", "V"
    };
                
                jpanel.setTestDistribution(as1);
                
            }
            setVisible(false);
            
        } else
        if(obj1 == jButton2)
        {
            setVisible(false);
            dispose();
        }
    */
    			obj.enable("PlotShape", true);
                obj.enable("PointsAssignments", true);
                obj.enable("Convert", false);
                obj.enable("DrawCGR", true);
                dispose();
    }

    private void exitForm(WindowEvent windowevent)
    {
        setVisible(false);
        dispose();
        obj.setEnabled(true);
    }

}
