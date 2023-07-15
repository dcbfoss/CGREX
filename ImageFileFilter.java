// FrontEnd Plus GUI for JAD
// DeCompiled : ImageFileFilter.class
//package CGRexpack;
import java.io.File;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileFilter;

class ImageFileFilter extends JFileChooser
{
	public static final long serialVersionUID = 0;
    String selected;

    public ImageFileFilter()
    {
        selected = null;
        addChoosableFileFilter(new FileFilter() {

            public boolean accept(File file)
            {
                selected = "jpg";
                return file.getName().toLowerCase().endsWith(".jpg") || file.getName().toLowerCase().endsWith(".jpeg") || file.isDirectory();
            }

            public String getDescription()
            {
                return "JPG/JPEG Images";
            }

        });
        addChoosableFileFilter(new FileFilter() {

            public boolean accept(File file)
            {
                selected = "png";
                return file.getName().toLowerCase().endsWith(".png") || file.isDirectory();
            }

            public String getDescription()
            {
                return "PNG Images";
            }

        });
    }
}
