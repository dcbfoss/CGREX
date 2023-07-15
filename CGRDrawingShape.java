// FrontEnd Plus GUI for JAD
// DeCompiled : CGRDrawingShape.class

//package CGRexpack;
import java.awt.*;
import java.awt.event.*;

import javax.swing.*;
import javax.swing.border.TitledBorder;

public class CGRDrawingShape extends JFrame
    implements ActionListener
{
	public static final long serialVersionUID = 0;
    private JRadioButton Triangle;
    private JRadioButton Square;
    private JRadioButton Polygon;
    private JTextField Corners;
    private ButtonGroup GroupA;
    private JButton OK;
    private JButton Cancel;
    private JLabel jLabel;
    private JPanel jPanel1;
    Container Content;
    CGRDrawing jpanel;
    CGRDrawing drawing1;
    CGRexMainGUI mainframe;
    String TestDistr[] = {
        ""
    };
    JOptionPane jop;

    public CGRDrawingShape(CGRDrawing drawing)
    {
        Content = null;
        jpanel = null;
        Content = getContentPane();
        initComponents();
        jpanel = drawing;
        
    }

    private void initComponents()
    {
        Triangle = new JRadioButton();
        Square = new JRadioButton();
        Polygon = new JRadioButton();
        Corners = new JTextField();
        GroupA = new ButtonGroup();
        jPanel1 = new JPanel();
        jLabel = new JLabel();
        OK = new JButton();
        Cancel = new JButton();
        Content.setLayout(null);
        jPanel1.setLayout(null);
        jPanel1.setBorder(new TitledBorder(null, "Select Plot Shape", 0, 0, new Font("Verdana", 0, 12)));
        Triangle.setText("Triangle");
        GroupA.add(Triangle);
        jPanel1.add(Triangle);
        Triangle.setBounds(40, 30, 90, 23);
        Square.setText("Square");
        GroupA.add(Square);
        jPanel1.add(Square);
        Square.setBounds(150, 30, 100, 23);
        Polygon.setText("Polygon with");
        GroupA.add(Polygon);
        jPanel1.add(Polygon);
        Polygon.setBounds(40, 100, 100, 23);
        Corners.setPreferredSize(new Dimension(62, 23));
        jPanel1.add(Corners);
        Corners.setBounds(140, 100, 30, 23);
        jLabel.setText("corners");
        jLabel.setPreferredSize(new Dimension(34, 23));
        jPanel1.add(jLabel);
        jLabel.setBounds(180, 100, 80, 23);
        Content.add(jPanel1);
        jPanel1.setBounds(20, 20, 270, 200);
        OK.setText("OK");
        getContentPane().add(OK);
        OK.setBounds(20, 250, 85, 25);
        OK.addActionListener(this);
        Cancel.setText("Cancel");
        Cancel.addActionListener(this);
        Content.add(Cancel);
        Cancel.setBounds(200, 250, 85, 25);
        Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
        setBounds((dimension.width - 319) / 2, (dimension.height - 335) / 2, 319, 335);
        setTitle("Plot Shape");
        addWindowListener(new WindowAdapter() {

            public void windowClosing(WindowEvent windowevent)
            {
                exitForm(windowevent);
            }

        });
    }

    public void actionPerformed(ActionEvent actionevent)
    {
        Object obj = actionevent.getSource();
        if(obj == OK)
        {
            if(Triangle.isSelected())
                jpanel.setTestCorners(3);
            else
            if(Square.isSelected())
                jpanel.setTestCorners(4);
            else
            if(Polygon.isSelected())
            {
                if(Integer.parseInt(Corners.getText()) > 20)
                {
                    Corners.setText("20");
                   // JOptionPane _tmp = jop;
                  //  JOptionPane _tmp1 = jop;
                    JOptionPane.showMessageDialog(this, "Corner Restriction.Set to 20", "CORNER SETTING!!!", 1);
                }
                jpanel.setTestCorners(Integer.parseInt(Corners.getText()));
            }
            if(jpanel.getTestDistrName() != null)
            {
            	new KmeansTest(jpanel.getTestDistrName(), jpanel.getTestCorners());
                TestDistr = KmeansTest.getDist();                
                jpanel.setTestDistribution(TestDistr);
            }
            setVisible(false);
            dispose();
        } else
        if(obj == Cancel)
        {
            setVisible(false);
            dispose();
        }
    }
    
    
    public void windowClosing(WindowEvent windowevent)
    {
    	drawing1.setSeqStr("");
    	drawing1.TestSeqStr ="";
    	drawing1.TestSeqType = "None";
    	drawing1.TestCorners = 0;
    	mainframe.SeqFile = null;
    	
    	mainframe.enable("nmerCount",false);
    	mainframe.enable("Manual",false);
    	mainframe.enable("Automatic",false);
    	mainframe.enable("MeshPlot ",false);
    	mainframe.enable("DrawMesh ",false);
    	mainframe.enable("MeshCount",false);
    	mainframe.enable("Angle",false);
    	mainframe.enable("ZoomIn",false);
    	mainframe.enable("ZoomOut",false);
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
    private void exitForm(WindowEvent windowevent)
    {
    	mainframe.enable("Movie",false);
    	mainframe.enable("Split",false);
    	mainframe.enable("ShowLabel",false);
        setVisible(false);
        dispose();
    }

 
}
    	