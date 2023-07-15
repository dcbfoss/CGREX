// FrontEnd Plus GUI for JAD
// DeCompiled : PanelSS.class
//package CGRexpack;
import java.awt.Dimension;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.*;
import javax.swing.border.TitledBorder;

class PanelSS extends JPanel
{
		
	public static final long serialVersionUID = 0;
    JTextField tf[];
    JPanel panel;
    JScrollPane scrollPane;
    JLabel lb;
    int groupCount;

    PanelSS(String s, int i, int j, int k, int l, int i1)
    {
        tf = null;
        panel = null;
        scrollPane = null;
        lb = null;
        groupCount = 0;
        groupCount = i;
        setLayout(null);
        setBounds(j, k, l, i1);
        TitledBorder titledborder = BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(1), s);
        titledborder.setTitleJustification(1);
        setBorder(titledborder);
        panel = new JPanel();
        Dimension dimension = new Dimension(l, groupCount * 31);
        panel.setPreferredSize(dimension);
        panel.setLayout(null);
        scrollPane = new JScrollPane(20, 31);
        scrollPane.setBounds(10, 15, l - 15, i1 - 20);
        scrollPane.setBorder(null);
        add(scrollPane);
        tf = new JTextField[groupCount];
        showFields(groupCount);
        scrollPane.getViewport().add(panel);
    }

    public JTextField[] getTxtfield()
    {
        return tf;
    }

    public void showFields(int i)
    {
        int j = getHeight();
        int k = j / i - 20 / i;
        for(int l = 0; l < i; l++)
        {
            JLabel jlabel = new JLabel("Group " + String.valueOf(l + 1), 2);
            tf[l] = new JTextField(50);
            if(k >= 30)
            {
                jlabel.setBounds(10, 20 + l * k, 75, 20);
                tf[l].setBounds(100, 20 + l * k, getWidth() - 150, 20);
            } else
            {
                jlabel.setBounds(10, 20 + l * 30, 75, 20);
                tf[l].setBounds(100, 20 + l * 30, getWidth() - 150, 20);
            }
            panel.add(jlabel);
            panel.add(tf[l]);
            tf[l].addKeyListener(new KeyAdapter() {

                public void keyReleased(KeyEvent keyevent)
                {
                    try
                    {
                        char c = Character.toUpperCase(keyevent.getKeyChar());
                        if(c != '\uFFFF')
                        {
                            JTextField jtextfield = (JTextField)keyevent.getSource();
                            jtextfield.setText(jtextfield.getText().toUpperCase());
                            if(c != ',')
                                if(c < 'A' || c > 'Z')
                                {
                                    if(c != '\b')
                                    {
                                        jtextfield.setText(jtextfield.getText().replaceAll(String.valueOf(c), ""));
                                        JOptionPane.showMessageDialog(null, "Invalid character", "VALIDATION", 0);
                                    }
                                } else
                                {
                                    char c1 = jtextfield.getText().charAt(jtextfield.getText().length() - 2);
                                    if(c1 >= 'A' && c1 <= 'Z')
                                        jtextfield.setText(jtextfield.getText().substring(0, jtextfield.getText().length() - 1));
                                }
                        }
                    }
                    catch(StringIndexOutOfBoundsException stringindexoutofboundsexception) { }
                }

            });
        }

    }
}
