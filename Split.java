
// FrontEnd Plus GUI for JAD
// DeCompiled : Split.class
//package CGRexpack;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Split extends JFrame
    implements ActionListener
          
{
	public static final long serialVersionUID = 0;
    CGRDrawing jpanel1;
    JOptionPane jop;
    private JButton Cancel;
    private JButton OK;
    private JComboBox jComboBox1;
    private JLabel jLabel1;

    public Split(CGRDrawing drawing)
    {
        jpanel1 = null;
        jop = null;
        jpanel1 = drawing;
        initComponents();
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
        jLabel1 = new JLabel();
        jComboBox1 = new JComboBox();
        OK = new JButton();
        Cancel = new JButton();
        getContentPane().setLayout(null);
        setTitle("Split");
        addWindowListener(new WindowAdapter() {

            public void windowClosing(WindowEvent windowevent)
            {
                exitForm(windowevent);
            }

        });
        jLabel1.setFont(new Font("Verdana", 0, 12));
        jLabel1.setText("Split to Level :");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(40, 40, 90, 16);
        if(Manipulation.corners > 7)
            jComboBox1.setModel(new DefaultComboBoxModel(new String[] {
                "0", "1", "2", "3", "4"
            }));
        else
            jComboBox1.setModel(new DefaultComboBoxModel(new String[] {
                "0", "1", "2", "3", "4", "5"
            }));
        getContentPane().add(jComboBox1);
        jComboBox1.setBounds(170, 40, 40, 19);
        OK.setText("OK");
        getContentPane().add(OK);
        OK.setBounds(40, 80, 85, 25);
        OK.addActionListener(this);
        Cancel.setText("Cancel");
        Cancel.addActionListener(this);
        getContentPane().add(Cancel);
        Cancel.setBounds(130, 80, 85, 25);
        Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
        setBounds((dimension.width - 259) / 2, (dimension.height - 173) / 2, 259, 173);
    }

    public void actionPerformed(ActionEvent actionevent)
    {
        if(actionevent.getSource() == OK)
        {
            jpanel1.splitPlot(Integer.parseInt(jComboBox1.getSelectedItem().toString()));
            jpanel1.repaint();
            
            setVisible(false);
            dispose();
        } else
        if(actionevent.getSource() == Cancel)
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
