


 import java.awt.*;
  import javax.swing.*;
 
public class StatusBar extends JLabel {
public static final long serialVersionUID = 0;  
    // Creates a new instance of StatusBar 
    public StatusBar() {
        super();
        super.setPreferredSize(new Dimension(1000, 16));
        setMessage("Ready");
    }
    
    public void setMessage(String message) {
        setText(" "+message);        
    }        
} 
