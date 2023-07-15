// FrontEnd Plus GUI for JAD
// DeCompiled : ProjectFileFilter.class
//package CGRexpack;
import java.io.File;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileFilter;

class ProjectFileFilter extends JFileChooser
{
	public static final long serialVersionUID = 0;
    String selected;

    public ProjectFileFilter()
    {
        selected = null;
        setCurrentDirectory(getCurrentDirectory());
        addChoosableFileFilter(new FileFilter() {

            public boolean accept(File file)
            {
                selected = "cgr";
                return file.getName().toLowerCase().endsWith(".cgr") || file.isDirectory();
            }

            public String getDescription()
            {
                return "Project Files(.cgr)";
            }

        });
    }
}
