// FrontEnd Plus GUI for JAD
// DeCompiled : UserdefinedSelection.class
//package CGRexpack;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class UserdefinedSelection extends JFrame
    implements ActionListener
{
	public static final long serialVersionUID = 0;
    CGRDrawing jpanel;
    CGRDrawing jPanel1;
    String str;
    PanelSS jpanelss;
    private JButton jButton1;
    private JButton jButton2;

    public UserdefinedSelection(CGRDrawing drawing)
    {
        jpanel = null;
        jPanel1 = null;
        str = new String();
        jpanelss = null;
        jpanel = drawing;
        initComponents();
        jpanelss = new PanelSS("Assign Points", drawing.getTestCorners(), 320, 20, 280, 250);
        getContentPane().add(jpanelss);
        jpanelss.repaint();
        jPanel1 = new CGRDrawing(280, 250);
        jPanel1.setBounds(20, 50, 280, 250);
        jPanel1.setCorners(drawing.getTestCorners());
        jPanel1.drawPoly();
        repaint();
        getContentPane().add(jPanel1);
        jPanel1.repaint();
        jPanel1.setVisible(true);
    }

    private void initComponents()
    {
        jButton1 = new JButton();
        jButton2 = new JButton();
        getContentPane().setLayout(null);
        setTitle("Userdefined Selection");
        addWindowListener(new WindowAdapter() {

            public void windowClosing(WindowEvent windowevent)
            {
                exitForm(windowevent);
            }

        });
        jButton1.setText("OK");
        getContentPane().add(jButton1);
        jButton1.setBounds(390, 320, 85, 25);
        jButton1.addActionListener(this);
        jButton2.setText("Cancel");
        jButton2.addActionListener(this);
        getContentPane().add(jButton2);
        jButton2.setBounds(490, 320, 85, 25);
        Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
        setBounds((dimension.width - 612) / 2, (dimension.height - 414) / 2, 612, 414);
    }

    public void actionPerformed(ActionEvent actionevent)
    {
        if(actionevent.getSource() == jButton1)
        {
            String as[] = new String[jpanel.getTestCorners()];
            JTextField ajtextfield[] = jpanelss.getTxtfield();
            for(int i = 0; i < as.length; i++)
                as[i] = ajtextfield[i].getText();

            jpanel.setTestDistribution(as);
            setVisible(false);
            dispose();
        } else
        if(actionevent.getSource() == jButton2)
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

}
