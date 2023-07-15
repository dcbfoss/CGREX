
// class name : About.class
//package CGRexpack;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.EtchedBorder;

public class About extends JFrame
{
	public static final long serialVersionUID = 78879866;
	private JButton jButton1;
    private JLabel jLabel1;
 // private JLabel jLabel10;
    private JLabel jLabel2;
    private JLabel jLabel3;
    private JLabel jLabel4;
    private JLabel jLabel5;
    private JLabel jLabel6;
  private JLabel jLabel7;
 // private JLabel jLabel8;
 // private JLabel jLabel9;
    private JPanel jPanel1;

    public About()
    {
        initComponents();
    }

    private void initComponents()
    {
        jButton1 = new JButton();
        jPanel1 = new JPanel();
        jLabel2 = new JLabel();
        jLabel3 = new JLabel();
        jLabel4 = new JLabel();
        jLabel5 = new JLabel();
        jLabel6 = new JLabel();
      jLabel7 = new JLabel();
   //   jLabel8 = new JLabel();
      //jLabel9 = new JLabel();
      //jLabel10 = new JLabel();
        jLabel1 = new JLabel();
        getContentPane().setLayout(null);
        setTitle("About");
        addWindowListener(new WindowAdapter() {

            public void windowClosing(WindowEvent windowevent)
            {
                exitForm(windowevent);
            }

        });
        jButton1.setText("Ok");
        jButton1.setBackground(Color.blue);
        jButton1.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent actionevent)
            {
                jButton1ActionPerformed(actionevent);
            }

        });
        getContentPane().add(jButton1);
        jButton1.setBounds(390, 260, 80, 25);
        jPanel1.setLayout(null);
        
        jPanel1.setBorder(new EtchedBorder(0));
        jLabel2.setIcon(new ImageIcon("C:\\Project\\Icons\\java.png"));
       // jPanel1.add(jLabel2);
        jLabel2.setBounds(320, 10, 0, 30);
        jLabel3.setFont(new Font("Verdana", 1, 18));
        jLabel3.setText("C-GREx , A Biosequence Kaleidoscope");
        jPanel1.add(jLabel3);
        jLabel3.setBounds(20, 20, 390, 30);
        jLabel4.setFont(new Font("Verdana", 0, 13));
        jLabel4.setText("Version 1.0");
        jPanel1.add(jLabel4);
        jLabel4.setBounds(325, 40, 390, 30);
        jLabel5.setFont(new Font("Arial", 0, 10));
        jLabel5.setText("Powered by Department of Information Technology, Govt.of India ");
        jPanel1.add(jLabel5);
        jLabel5.setBounds(20, 150, 390, 14);
        jLabel7.setFont(new Font("Arial", 0, 10));
        jLabel7.setText("Developed by Center for Bioinformatics,University of Kerala");
        jPanel1.add(jLabel7);
        jLabel7.setBounds(20, 170, 390, 14);
        jLabel6.setFont(new Font("Verdana", 0, 10));
        getContentPane().add(jPanel1);
        jPanel1.setBounds(20, 20, 455, 270);
        jLabel1.setIcon(new ImageIcon("e:/CGRex/CGRexpack/dna.jpg"));
        getContentPane().add(jLabel1);
        jLabel1.setBounds(0, 0, 500, 340);
        Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
        setBounds((dimension.width - 500) / 2, (dimension.height - 340) / 2, 500, 340);
    }

    private void jButton1ActionPerformed(ActionEvent actionevent)
    {
        setVisible(false);
        dispose();
    }

    private void exitForm(WindowEvent windowevent)
    {
        setVisible(false);
        dispose();
    }

   /* public static void main(String args[])
    {
        (new About()).setVisible(true);
    }
*/

}
