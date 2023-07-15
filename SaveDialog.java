// FrontEnd Plus GUI for JAD
// DeCompiled : SaveDialog.class
//package CGRexpack;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import javax.swing.*;

public class SaveDialog extends JFrame
    implements ActionListener
{

	public static final long serialVersionUID = 0;
	JOptionPane jop;
    CGRDrawing jpanel1;
    private JButton jButton1;
    private JButton jButton2;
    private JButton jButton3;
    private JLabel jLabel1;

    public SaveDialog(CGRDrawing drawing)
    {
        jpanel1 = drawing;
        initComponents();
    }

    private void initComponents()
    {
        jLabel1 = new JLabel();
        jButton1 = new JButton();
        jButton2 = new JButton();
        jButton3 = new JButton();
        getContentPane().setLayout(null);
        setTitle("Save Project");
        setUndecorated(true);
        addWindowListener(new WindowAdapter() {

            public void windowClosing(WindowEvent windowevent)
            {
                exitForm(windowevent);
            }

        });
        jLabel1.setFont(new Font("Verdana", 0, 14));
        jLabel1.setText("Do you want to save changes?");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(80, 40, 320, 20);
        jButton1.setText("Cancel");
        jButton1.addActionListener(this);
        getContentPane().add(jButton1);
        jButton1.setBounds(360, 100, 80, 25);
        jButton2.setText("No");
        getContentPane().add(jButton2);
        jButton2.setBounds(260, 100, 80, 25);
        jButton2.addActionListener(this);
        jButton3.setText("Yes");
        getContentPane().add(jButton3);
        jButton3.setBounds(160, 100, 80, 25);
        jButton3.addActionListener(this);
        Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
        setBounds((dimension.width - 476) / 2, (dimension.height - 204) / 2, 476, 180);
    }

    public void actionPerformed(ActionEvent actionevent)
    {
        Object obj = actionevent.getSource();
        if(obj == jButton3)
        {
        //    String s = new String();
       //     Object obj1 = null;
            ProjectFileFilter projectfilefilter = new ProjectFileFilter();
            projectfilefilter.setCurrentDirectory(new File("./Save"));
            int i = projectfilefilter.showSaveDialog(new JFrame());
            if(i == 0)
            {
                String s1 = projectfilefilter.selected;
                File file;
                if(projectfilefilter.getSelectedFile().toString().charAt(projectfilefilter.getSelectedFile().toString().length() - projectfilefilter.selected.length() - 1) != '.')
                    file = new File(projectfilefilter.getSelectedFile().toString() + "." + s1);
                else
                    file = projectfilefilter.getSelectedFile();
                try
                {
                    FileOutputStream fileoutputstream = new FileOutputStream(file);
                    ObjectOutputStream objectoutputstream = new ObjectOutputStream(fileoutputstream);
                    MYCGREX mycgrex = new MYCGREX(jpanel1);
                    objectoutputstream.writeObject(mycgrex);
                    objectoutputstream.flush();
                    fileoutputstream.close();
                    objectoutputstream.close();
               //     JOptionPane _tmp = jop;
               //     JOptionPane _tmp1 = jop;
                    JOptionPane.showMessageDialog(this, "Project file has been saved", "Project saved", 1);
                    dispose();
                    System.exit(0);
                }
                catch(FileNotFoundException filenotfoundexception)
                {
               //     JOptionPane _tmp2 = jop;
               //     JOptionPane _tmp3 = jop;
                    JOptionPane.showMessageDialog(this, "Error in saving", "File IO Error", 0);
                }
                catch(IOException ioexception)
                {
                 //   JOptionPane _tmp4 = jop;
                 //   JOptionPane _tmp5 = jop;
                    JOptionPane.showMessageDialog(this, "Error in saving", "File IO Error", 0);
                }
            }
        } else
        if(obj == jButton2)
        {
            dispose();
            System.exit(0);
        } else
        if(obj == jButton1)
            dispose();
    }

    private void exitForm(WindowEvent windowevent)
    {
        setVisible(false);
        dispose();
    }

}
