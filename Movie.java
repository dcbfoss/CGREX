// FrontEnd Plus GUI for JAD
// DeCompiled : Movie.class
//package CGRexpack;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.TitledBorder;

public class Movie extends JFrame
    implements ActionListener, Runnable
{
	public static final long serialVersionUID = 0;
    int window;
    int strt;
    int end;
    boolean view;
    Thread t;
    CGRexMainGUI mainframe1;
    CGRDrawing jpanel;
    JOptionPane jop;
    private JButton Cancel;
    private JRadioButton Complete;
    private ButtonGroup Grouping;
    private JPanel MovieType;
    private JRadioButton SlidingWindow;
    private JTextField WindowSize;
    private JTextField WindowSize1;
    private JTextField WindowSize2;
    private JButton jOK;
    private JLabel jLabel1;
    private JLabel jLabel2;
    private JLabel jLabel3;

    public Movie(CGRexMainGUI mainframe, CGRDrawing drawing)
    {
        window = 0;
        strt = 0;
        end = 0;
        view = false;
        t = null;
        mainframe1 = null;
        jpanel = null;
        jop = null;
        mainframe1 = mainframe;
        jpanel = drawing;
        initComponents();
        if(drawing == null)
        {
        //    JOptionPane _tmp = jop;
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
        Grouping = new ButtonGroup();
        MovieType = new JPanel();
        SlidingWindow = new JRadioButton();
        Complete = new JRadioButton();
        jLabel1 = new JLabel();
        WindowSize = new JTextField();
        jLabel2 = new JLabel();
        WindowSize1 = new JTextField();
        WindowSize2 = new JTextField();
        jLabel3 = new JLabel();
        jOK = new JButton();
        Cancel = new JButton();
        getContentPane().setLayout(null);
        setTitle("Movie");
        addWindowListener(new WindowAdapter() {

            public void windowClosing(WindowEvent windowevent)
            {
                exitForm(windowevent);
            }

        });
        MovieType.setLayout(null);
        MovieType.setBorder(new TitledBorder(null, "Movie Type", 0, 0, new Font("Verdana", 0, 12)));
        SlidingWindow.setText("Sliding Window");
        Grouping.add(SlidingWindow);
        MovieType.add(SlidingWindow);
        SlidingWindow.setBounds(20, 30, 130, 23);
        SlidingWindow.setSelected(true);
        Complete.setText("Complete");
        Grouping.add(Complete);
        MovieType.add(Complete);
        Complete.setBounds(170, 30, 120, 23);
        getContentPane().add(MovieType);
        MovieType.setBounds(50, 30, 300, 90);
        jLabel1.setFont(new Font("Verdana", 0, 12));
        jLabel1.setText("Window Size   :");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(100, 140, 100, 25);
        getContentPane().add(WindowSize);
        WindowSize.setBounds(210, 140, 60, 25);
        jLabel2.setFont(new Font("Verdana", 0, 12));
        jLabel2.setText("Starting Point  :");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(100, 170, 100, 25);
        getContentPane().add(WindowSize1);
        WindowSize1.setBounds(210, 170, 60, 25);
        getContentPane().add(WindowSize2);
        WindowSize2.setBounds(210, 200, 60, 25);
        jLabel3.setFont(new Font("Verdana", 0, 12));
        jLabel3.setText("End Point        :");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(100, 200, 100, 25);
        jOK.setText("OK");
        getContentPane().add(jOK);
        jOK.setBounds(180, 260, 85, 25);
        jOK.addActionListener(this);
        Cancel.setText("Cancel");
        Cancel.addActionListener(this);
        getContentPane().add(Cancel);
        Cancel.setBounds(280, 260, 85, 25);
        Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
        setBounds((dimension.width - 410) / 2, (dimension.height - 356) / 2, 410, 356);
    }

    public void actionPerformed(ActionEvent actionevent)
    {
    	if (mainframe1.SeqFile != null)
    	{
        if(actionevent.getSource() == jOK)
        {
            if(SlidingWindow.isSelected())
            {
                window = Integer.parseInt(WindowSize.getText());
                strt = Integer.parseInt(WindowSize1.getText());
                end = Integer.parseInt(WindowSize2.getText());
                view = false;
                t = new Thread(this);
                t.start();
            } else
            if(Complete.isSelected())
            {
                window = Integer.parseInt(WindowSize.getText());
                strt = Integer.parseInt(WindowSize1.getText());
                if(strt < 0)
                {
                	strt=1;
                	}
                
                end = Integer.parseInt(WindowSize2.getText());
                view = true;
                t = new Thread(this);
                t.start();
            }
            jpanel.setVisible(false);
            jpanel.clearPlot();
            mainframe1.repaint();
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

    public void run()
    {
        int i = (end - (strt - 1)) / window;
        int j = window;
        int k = strt - 1;
        if(k<0)
        {
        	k=0;
        }
        jpanel.setVisible(true);
        for(int l = 0; l < i; l++)
        {
            jpanel.movieMaker(k, j, view);
            jpanel.repaint();
            jpanel.setVisible(true);
            mainframe1.repaint();
            try
            {
                Thread.sleep(1000L);
            }
            catch(Exception exception) { }
            k = j + 1;
            j = window * (l + 2);
        }

    }

    private void exitForm(WindowEvent windowevent)
    {
        setVisible(false);
        dispose();
    }

}
