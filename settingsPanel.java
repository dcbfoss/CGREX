// FrontEnd Plus GUI for JAD
// DeCompiled : settingsPanel.class
//package CGRexpack;
import java.awt.Dimension;
import javax.swing.*;
import javax.swing.border.TitledBorder;

class settingsPanel extends JPanel
{
	public static final long serialVersionUID = 0;
    JLabel l[];
    JPanel panel1;
    JPanel panel2;
    JScrollPane jsp;

    public settingsPanel(String s, String as[], int i, int j, int k, int i1)
    {
        l = null;
        panel1 = null;
        panel2 = null;
        jsp = null;
        panel1 = new JPanel();
        panel2 = new JPanel();
        panel1.setLayout(null);
        panel2.setLayout(null);
        Dimension dimension = new Dimension(200, (as.length - 3) * 30);
        panel2.setPreferredSize(dimension);
        jsp = new JScrollPane(panel2, 20, 31);
        jsp.setBorder(null);
        setLayout(null);
        setBounds(i, j, k, i1);
        l = new JLabel[as.length];
        for(int j1 = 0; j1 < as.length; j1++)
            if(k > 195)
            {
                if(as[j1].charAt(0) == '_')
                    l[j1] = new JLabel("<HTML><u>" + as[j1] + "</u>");
                else
                    l[j1] = new JLabel(as[j1]);
                if(j1 < 3)
                {
                    l[j1].setBounds(10, 10 + j1 * 30, as[j1].length() * 30, 20);
                    panel1.add(l[j1]);
                    continue;
                }
                if(as[j1].charAt(0) != '_')
                    l[j1] = new JLabel(String.valueOf(j1 -3) + "." + as[j1]);
                	panel2.add(l[j1]);
                	l[j1].setBounds(10, 10 + (j1 - 3) * 30, as[j1].length() * 30, 20);
            } else
            {
                l[j1] = new JLabel(String.valueOf(j1 + 1) + ". " + as[j1]);
            	 panel2.add(l[j1]);
                l[j1].setBounds(10, 10 + j1 * 30, as[j1].length() * 30, 20);
            }

        panel1.setBounds(10, 25, 175, 90);
        int k1 = getHeight();
        if(k > 195)
        {
            if(k1 > 200)
                jsp.setBounds(10, 135, 175, 250);
            else
                jsp.setBounds(225, 15, 173, 120);
            add(panel1);
        } else
        {
            panel1.setVisible(false);
            jsp.setBounds(10, 25, 175, 175);
            panel2.repaint();
        }
        add(jsp);
        TitledBorder titledborder = BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(1), s);
        titledborder.setTitleJustification(2);
        setBorder(titledborder);
        setVisible(true);
    }
}
