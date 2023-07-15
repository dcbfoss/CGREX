// FrontEnd Plus GUI for JAD
// DeCompiled : TextFileFilter.class
//package CGRexpack;
import java.io.File;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileFilter;

class TextFileFilter extends JFileChooser
{
	public static final long serialVersionUID = 0;
    String selected;

    public TextFileFilter()
    {
        selected = null;
        setCurrentDirectory(getCurrentDirectory());
        addChoosableFileFilter(new FileFilter() {

            public boolean accept(File file)
            {
                selected = "txt";
                return file.getName().toLowerCase().endsWith(".txt") || file.isDirectory();
            }

            public String getDescription()
            {
                return "Text Files";
            }

        });
    }
}
