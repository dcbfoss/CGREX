// FrontEnd Plus GUI for JAD
// DeCompiled : seqpanel1.class
//package CGRexpack;
import java.awt.*;
import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.text.*;

class seqpanel1 extends JPanel
    implements ChangeListener
{
	public static final long serialVersionUID = 0;
    JTextPane seq;
    JLabel l1;
    JLabel l2;
    JViewport jvp;
    JScrollPane jsp;

    seqpanel1(int i, int j, int k, int l)
    {
        seq = null;
        l1 = null;
        l2 = null;
        jvp = null;
        jsp = null;
        setSize(k, l);
        setBounds(i, j, k, l);
        setLayout(null);
        seq = new JTextPane();
        seq.setEditorKit(new NoWrapEditorKit());
        seq.getInputMap(0).put(KeyStroke.getKeyStroke(10, 0), "actionName");
        seq.getInputMap(0).put(KeyStroke.getKeyStroke(new Character(' '), 0), "actionName");
        Dimension dimension = new Dimension(200, 200);
        seq.setPreferredSize(dimension);
        seq.setText("");
        l1 = new JLabel("Base no");
        l2 = new JLabel("Base no");
        jsp = new JScrollPane(seq, 21, 32);
        validateSequence("DNA");
        jvp = new JViewport();
        jsp.setViewportView(seq);
        jvp = jsp.getViewport();
        l1.setBounds(0, 0, 100, 20);
        l2.setBounds(k - 80, 0, 100, 20);
        jsp.setBounds(0, 20, k, l - 20);
        add(jsp);
        add(l1);
        add(l2);
        jvp.addChangeListener(this);
    }

    public void append(Color color, int i, String s)
    {
        StyleContext stylecontext = StyleContext.getDefaultStyleContext();
        javax.swing.text.AttributeSet attributeset = stylecontext.addAttribute(SimpleAttributeSet.EMPTY, StyleConstants.Foreground, color);
        seq.setCaretPosition(i);
        seq.setSelectionStart(i);
        seq.setSelectionEnd(i + s.length());
        seq.replaceSelection("");
        seq.setCharacterAttributes(attributeset, false);
        seq.replaceSelection(s);
    }

    public void validateSequence(String s)
    {
        if(s.equals("DNA"))
        {
            for(int i = 0; i < 256; i++)
                if(i != 65 && i != 71 && i != 67 && i != 84)
                    seq.getInputMap(0).put(KeyStroke.getKeyStroke(new Character((char)i), 0), "actionName");

        } else
        if(s.equals("RNA"))
        {
            for(int j = 0; j < 256; j++)
                if(j != 65 && j != 71 && j != 67 && j != 85)
                    seq.getInputMap(0).put(KeyStroke.getKeyStroke(new Character((char)j), 0), "actionName");

        } else
        if(s.equals("AMINOACID"))
        {
            for(int k = 0; k < 256; k++)
                if(k != 82 && k != 75 && k != 68 && k != 81 && k != 78 && k != 69 && k != 72 && k != 80 && k != 89 && k != 87 && k != 83 && k != 84 && k != 71 && k != 65 && k != 77 && k != 67 && k != 70 && k != 76 && k != 86 && k != 73)
                    seq.getInputMap(0).put(KeyStroke.getKeyStroke(new Character((char)k), 0), "actionName");

        } else
        if(s.equals("OTHER"))
        {
            for(int l = 0; l < 256; l++)
                if(l < 65 || l > 90)
                    seq.getInputMap(0).put(KeyStroke.getKeyStroke(new Character((char)l), 0), "actionName");

        } else
        {
            JOptionPane.showMessageDialog(null, "Invalid sequence type", "Sequence Dialog", 0);
        }
    }

    public void stateChanged(ChangeEvent changeevent)
    {
        int i = (int)jvp.getViewPosition().getX() / 8;
        if(i < seq.getText().length())
            l1.setText("Base no: " + String.valueOf(1 + (int)jvp.getViewPosition().getX() / 8));
        if(jsp.getWidth() / 8 + i < seq.getText().length())
            l2.setText("Base no: " + String.valueOf(jsp.getWidth() / 8 + (int)jvp.getViewPosition().getX() / 8));
    }
}
