// FrontEnd Plus GUI for JAD
// DeCompiled : PrintImage.class
//package CGRexpack;
import java.awt.image.BufferedImage;
import java.io.*;
import javax.imageio.ImageIO;
import javax.print.*;
import javax.print.attribute.HashPrintRequestAttributeSet;
//import javax.print.attribute.PrintRequestAttributeSet;
import javax.print.attribute.standard.Copies;

public class PrintImage
{

    public PrintImage(BufferedImage bufferedimage)
    {
        print(bufferedimage);
    }

    public void print(BufferedImage bufferedimage)
    {
        try
        {
            String s = "png";
            File file = new File("./print.tmp");
            file.deleteOnExit();
            if(bufferedimage != null)
            {
                ImageIO.write(bufferedimage, s, file);
                HashPrintRequestAttributeSet hashprintrequestattributeset = new HashPrintRequestAttributeSet();
                hashprintrequestattributeset.add(new Copies(1));
                PrintService aprintservice[] = PrintServiceLookup.lookupPrintServices(javax.print.DocFlavor.INPUT_STREAM.GIF, hashprintrequestattributeset);
                if(aprintservice.length == 0)
                    throw new RuntimeException("No printer services available.");
                PrintService printservice = aprintservice[0];
                System.out.println("Printing to " + printservice);
                DocPrintJob docprintjob = printservice.createPrintJob();
                FileInputStream fileinputstream = new FileInputStream(file);
                SimpleDoc simpledoc = new SimpleDoc(fileinputstream, javax.print.DocFlavor.INPUT_STREAM.GIF, null);
                docprintjob.print(simpledoc, hashprintrequestattributeset);
                fileinputstream.close();
            }
        }
        catch(IOException ioexception)
        {
            ioexception.printStackTrace();
        }
        catch(PrintException printexception)
        {
            printexception.printStackTrace();
        }
    }
}
