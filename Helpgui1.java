// FrontEnd Plus GUI for JAD
// DeCompiled : Helpgui1.class
//package CGRexpack;
import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.FileInputStream;
import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
//import javax.swing.text.Document;
//import javax.swing.text.StyledEditorKit;

public class Helpgui1 extends JFrame
    implements ListSelectionListener, ActionListener
{
    public static final long serialVersionUID = 0;
    static int a = 0;
    private JButton Clear;
    private JTextField KeyTF;
    private JList List1;
    private JList List2;
    private JList List3a;
    private JList List3b;
    private JPanel Panel1;
    private JPanel Panel2;
    private JPanel Panel3;
    private JButton Search1;
    private JButton Search2;
    private JTextField SearchKey;
    private JTabbedPane Tabs;
    private JEditorPane jEditorPane1;
    private JLabel jLabel1;
    private JLabel jLabel2;
    private JLabel jLabel3;
    private JPanel jPanel1;
    private JScrollPane jScrollPane1;
    private JScrollPane jScrollPane2;
   // private StyledEditorKit m_kit;

    public Helpgui1()
    {
        setResizable(false);
        initComponents();
    }

    private void initComponents()
    {
        jEditorPane1 = new JEditorPane();
        jScrollPane1 = new JScrollPane(jEditorPane1, 20, 30);
       // StyledEditorKit stylededitorkit = new StyledEditorKit();
   //     jEditorPane1.setEditorKit(stylededitorkit);
        jEditorPane1.getDocument().putProperty("__EndOfLine__", "\n");
        jPanel1 = new JPanel();
        Tabs = new JTabbedPane();
        Panel1 = new JPanel();
        List1 = new JList();
        JScrollPane jscrollpane = new JScrollPane(22, 31);
        Panel2 = new JPanel();
        Search1 = new JButton();
        List2 = new JList();
      //  JScrollPane jscrollpane1 = new JScrollPane(List2);
        jScrollPane2 = new JScrollPane();
        SearchKey = new JTextField();
        Panel3 = new JPanel();
        KeyTF = new JTextField();
        Search2 = new JButton();
        Clear = new JButton();
        List3a = new JList();
     //   JScrollPane jscrollpane2 = new JScrollPane(List3a);
        List3b = new JList();
      //  JScrollPane jscrollpane3 = new JScrollPane(List3b);
        jLabel1 = new JLabel();
        jLabel2 = new JLabel();
        jLabel3 = new JLabel();
        DefaultListModel defaultlistmodel = new DefaultListModel();
        DefaultListModel defaultlistmodel1 = new DefaultListModel();
        getContentPane().setLayout(null);
        setTitle("Help");
        addWindowListener(new WindowAdapter() {

            public void windowClosing(WindowEvent windowevent)
            {
                exitForm(windowevent);
            }

        });
        jscrollpane.setViewportView(List1);
        Font font = new Font("Georgia", 1, 20);
        jEditorPane1.setFont(font);
        jEditorPane1.setEditable(false);
        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(240, 0, 580, 560);
        jPanel1.setLayout(null);
        Tabs.setTabLayoutPolicy(1);
        Tabs.setDoubleBuffered(true);
        Tabs.setFont(new Font("Georgia", 0, 12));
        Panel1.setLayout(null);
        Panel1.add(List1);
        List1.setBounds(7, 5, 200, 510);
     
     File file = new File("./Help");
        String as[] = file.list();
        int i = as.length;
        for(int j = 0; j < i + 1; j++)
            try
            {
                if(j < i)
                {
                    File file1 = new File("./Help\\" + as[j]);
                    if(file1.isFile())
                    {
                        String s = replaceWord(as[j], ".txt", "");
                        defaultlistmodel.addElement(s);
                        List1.setModel(defaultlistmodel);
                    }
                } else
                {
                    defaultlistmodel.addElement("Technical Documentation");
                    List1.setModel(defaultlistmodel);
                }
            }
            catch(Exception exception)
            {
                exception.printStackTrace();
            }

        List1.addListSelectionListener(this);
        Tabs.addTab("Contents", Panel1);
        Panel2.setLayout(null);
        Search1.setText("Search");
        Panel2.add(Search1);
        Search1.addActionListener(this);
        Search1.setBounds(120, 80, 80, 25);
        Panel2.add(List2);
        List2.setBounds(10, 120, 190, 390);
        List2.addListSelectionListener(this);
        jScrollPane2.setViewportView(SearchKey);
        Panel2.add(jScrollPane2);
        jScrollPane2.setBounds(12, 12, 190, 70);
        Tabs.addTab("Search", Panel2);
        Panel3.setLayout(null);
        Panel3.add(KeyTF);
        KeyTF.setBounds(10, 30, 190, 20);
        Search2.setText("Search");
        Panel3.add(Search2);
        Search2.setBounds(120, 60, 80, 25);
        Search2.addActionListener(this);
        Clear.setText("Clear");
        Panel3.add(Clear);
        Clear.setBounds(10, 60, 80, 25);
        Clear.addActionListener(this);
        Panel3.add(List3a);
        List3a.setBounds(10, 130, 190, 100);
        String as1[] = {
            "amino acid", "CGR", "color", "Convert", "Count Points", "Clustering", "Exit", "Export", "Print", "Features",
            "Load", "Mesh Plot", "Movie", "Multiplot", "protein",  "predefined", "point assignment", "rna", "CGREx",
            "split", "superimpose", "Save Project", "Show Label", "User Defined", "zoom"
        };
        for(int k = 0; k < as1.length; k++)
        {
            defaultlistmodel1.addElement(as1[k]);
            List3a.setModel(defaultlistmodel1);
        }

        List3a.addListSelectionListener(this);
        Panel3.add(List3b);
        List3b.setBounds(10, 270, 190, 240);
        List3b.addListSelectionListener(this);
        jLabel1.setFont(new Font("Georgia", 0, 12));
        jLabel1.setText("3. Choose a topic");
        Panel3.add(jLabel1);
        jLabel1.setBounds(10, 250, 160, 16);
        jLabel2.setFont(new Font("Georgia", 0, 12));
        jLabel2.setText("2. Or choose keywords");
        Panel3.add(jLabel2);
        jLabel2.setBounds(10, 110, 160, 15);
        jLabel3.setFont(new Font("Georgia", 0, 12));
        jLabel3.setText("1. Select keywords");
        Panel3.add(jLabel3);
        jLabel3.setBounds(10, 10, 160, 16);
        Tabs.addTab("Index", Panel3);
        jPanel1.add(Tabs);
        Tabs.setBounds(0, 10, 220, 550);
        getContentPane().add(jPanel1);
        jPanel1.setBounds(0, 0, 220, 560);
        Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
        setBounds((dimension.width - 842) / 2, (dimension.height - 605) / 2, 842, 605);
    }  // end of init components Function


    public String replaceWord(String s, String s1, String s2)
    {
        int i = s.indexOf(s1);
        if(i < 0)
        {
            return s;
        } else
        {
            String s3 = s.substring(0, i);
            String s4 = s.substring(i + s1.length());
            return s3 + s2 + s4;
        }
    }
    Process process;
    public void valueChanged(ListSelectionEvent listselectionevent)
    {
        if(listselectionevent.getSource() == List1)
            try
            {
                a++;
                
                if((String)List1.getSelectedValue() == "Technical Documentation" && a % 2 == 0)
                    process = Runtime.getRuntime().exec("C:/Program Files/Internet Explorer/IEXPLORE.EXE file:///" + (new File(".")).getAbsolutePath() + "/Help/docs/Myhtml.htm");
                else
                if((String)List1.getSelectedValue() != "Technical Documentation")
                {
                    FileInputStream fileinputstream = new FileInputStream("./Help\\" + (String)List1.getSelectedValue() + ".txt");
                    jEditorPane1.read(fileinputstream, this);
                    fileinputstream.close();
                }
            }
            catch(Exception exception)
            {
                exception.printStackTrace();
            }
        if(listselectionevent.getSource() == List2)
            try
            {
                FileInputStream fileinputstream1 = new FileInputStream("./Help\\" + (String)List2.getSelectedValue() + ".txt");
                jEditorPane1.read(fileinputstream1, this);
                fileinputstream1.close();
            }
            catch(Exception exception1)
            {
                exception1.printStackTrace();
            }
        if(listselectionevent.getSource() == List3a)
            try
            {
                KeyTF.setText((String)List3a.getSelectedValue());
            }
            catch(Exception exception2)
            {
                exception2.printStackTrace();
            }
        if(listselectionevent.getSource() == List3b)
            try
            {
                FileInputStream fileinputstream2 = new FileInputStream("./Help\\" + (String)List3b.getSelectedValue() + ".txt");
                jEditorPane1.read(fileinputstream2, this);
                fileinputstream2.close();
            }
            catch(Exception exception3)
            {
                exception3.printStackTrace();
            }
    }

    public void actionPerformed(ActionEvent actionevent)
    {
        DefaultListModel defaultlistmodel = new DefaultListModel();
        if(actionevent.getSource() == Search1)
        {
            boolean flag = false;
            try
            {
                List2.removeAll();
                File file = new File("./Help");
                String s = SearchKey.getText();
                String as[] = file.list();
              //  Object obj = null;
                int i = as.length;
                for(int k = 0; k < i; k++)
                {
                    String s4 = "./Help\\" + as[k];
                    File file2 = new File(s4);
                    if(file2.isFile())
                    {
                        FileInputStream fileinputstream2 = new FileInputStream(s4);
                        byte abyte0[] = new byte[(int)file2.length()];
                        fileinputstream2.read(abyte0);
                        String s2 = new String(abyte0);
                        fileinputstream2.close();
                        String s6 = s2.toLowerCase();
                        String s8 = s.toLowerCase();
                        if(s6.indexOf(s8) != -1)
                        {
                            flag = true;
                            String s10 = replaceWord(as[k], ".txt", "");
                            defaultlistmodel.addElement(s10);
                            List2.setModel(defaultlistmodel);
                        }
                    }
                }

            }
            catch(Exception exception)
            {
                exception.printStackTrace();
            }
            if(!flag)
                try
                {
                    FileInputStream fileinputstream = new FileInputStream("Sorry.txt");
                    jEditorPane1.read(fileinputstream, this);
                    fileinputstream.close();
                }
                catch(Exception exception1)
                {
                    exception1.printStackTrace();
                }
        }
        if(actionevent.getSource() == Search2)
        {
            boolean flag1 = false;
            List3b.removeAll();
            try
            {
                File file1 = new File("./Help");
                String s1 = KeyTF.getText();
                String as1[] = file1.list();
             //   Object obj1 = null;
                int j = as1.length;
                for(int l = 0; l < j; l++)
                {
                    String s5 = "./Help\\" + as1[l];
                    File file3 = new File(s5);
                    if(file3.isFile())
                    {
                        FileInputStream fileinputstream3 = new FileInputStream(s5);
                        byte abyte1[] = new byte[(int)file3.length()];
                        fileinputstream3.read(abyte1);
                        String s3 = new String(abyte1);
                        fileinputstream3.close();
                        String s7 = s3.toLowerCase();
                        String s9 = s1.toLowerCase();
                        if(s7.indexOf(s9) != -1)
                        {
                            flag1 = true;
                            String s11 = replaceWord(as1[l], ".txt", "");
                            defaultlistmodel.addElement(s11);
                            List3b.setModel(defaultlistmodel);
                        }
                    }
                }

            }
            catch(Exception exception2)
            {
                exception2.printStackTrace();
            }
            if(!flag1)
                try
                {
                    FileInputStream fileinputstream1 = new FileInputStream("Sorry.txt");
                    jEditorPane1.read(fileinputstream1, this);
                    fileinputstream1.close();
                }
                catch(Exception exception3)
                {
                    exception3.printStackTrace();
                }
        }
        if(actionevent.getSource() == Clear)
            KeyTF.setText("");
    }

    private void exitForm(WindowEvent windowevent)
    {
        setVisible(false);
        dispose();
    }

    public static void main(String args[])
    {
        try
        {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        }
        catch(Exception exception) { }
        (new Helpgui1()).setVisible(true);
    }


}
