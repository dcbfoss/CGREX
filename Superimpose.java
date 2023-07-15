// FrontEnd Plus GUI for JAD
// DeCompiled : Superimpose.class
//package CGRexpack;
//import java.awt.Container;
//import javax.swing.JTextPane;

class Superimpose
{
	public static final long serialVersionUID = 0;
    CGRexMainGUI obj;
    CGRDrawing drawing1;
    CGRDrawing drawing2;

    public Superimpose(CGRexMainGUI maingui, CGRDrawing drawingclass, CGRDrawing drawingclass1)
    {
        obj = null;
        drawing1 = null;
        drawing2 = null;
        obj = maingui;
        drawing1 = drawingclass;
        drawing2 = drawingclass1;
        drawingclass.setVisible(false);
        maingui.getContentPane().remove(maingui.drawing1);
        drawingclass1.setVisible(false);
        maingui.getContentPane().remove(maingui.drawing2);
        maingui.Sequencepanel1.setVisible(false);
        maingui.getContentPane().remove(maingui.Sequencepanel1);
        maingui.Sequencepanel2.setVisible(false);
        maingui.getContentPane().remove(maingui.Sequencepanel1);
        maingui.Settingspanel1.setVisible(false);
        maingui.getContentPane().remove(maingui.Settingspanel1);
        maingui.Settingspanel2.setVisible(false);
        maingui.getContentPane().remove(maingui.Settingspanel2);
        drawingclass.setMultiplot(true);
        drawingclass1.setMultiplot(true);
        maingui.Sequencepanel1 = new seqpanel1(0, 460, 398, 65);
        maingui.Sequencepanel1.seq.setText(drawingclass.getTestSeqStr());
        maingui.Sequencepanel2 = new seqpanel1(400, 460, 398, 65);
        maingui.Sequencepanel2.seq.setText(drawingclass1.getTestSeqStr());
        String as[] = {
                "Corners:" + drawingclass.getTestCorners(),"Sequence Type:" + drawingclass.getTestSeqType(),"File Name :"+drawingclass.getDistrName(), "_Points Assignment"
            };
            String as1[] = drawingclass.getTestDistribution();
            String as2[] = new String[as.length + as1.length];
            for(int i = 0; i < as.length; i++)
                as2[i] = new String(as[i]);

            for(int j = as.length; j < as.length + as1.length; j++)
                if(as1[j - as.length].trim().equals(""))
                    as2[j] = new String(" ");
                else
                    as2[j] = new String(as1[j - as.length]);

            maingui.Settingspanel1 = new settingsPanel("Settings", as2, 0, 530, 398, 140);
            String as3[] = {
                "Corners:" + drawingclass1.getTestCorners(), "Sequence Type:" + drawingclass1.getTestSeqType(),"File Name :"+maingui.SeqFile.getName(), "_Corner Assignment"
            };
            
        
        
        String as4[] = drawingclass1.getTestDistribution();
        String as5[] = new String[as3.length + as4.length];
        for(int k = 0; k < as3.length; k++)
            as5[k] = new String(as3[k]);
        for(int l = as3.length; l < as3.length + as4.length; l++)
            if(as4[l - as3.length].trim().equals(""))
                as5[l] = new String(" ");
            else
                as5[l] = new String(as4[l - as3.length]); 
        maingui.Settingspanel2 = new settingsPanel("Settings", as5, 400, 530, 398, 140);
        drawingclass.setBounds(0, 60, 398, 398);
        drawingclass1.setBounds(400, 60, 398, 398);
        maingui.repaint();
        drawingclass.setVisible(true);
        drawingclass.repaint();
        maingui.getContentPane().add(drawingclass);
        drawingclass1.clearPanel();
        drawingclass1.validateSettings();
        drawingclass1.drawPoly();
        drawingclass1.plot();
        drawingclass1.setSuperxp(drawingclass.xp);
        drawingclass1.setSuperyp(drawingclass.yp);
        drawingclass1.plotPoints();
        drawingclass1.repaint();
        maingui.getContentPane().add(drawingclass1);
        drawingclass1.setVisible(true);
        maingui.getContentPane().add(maingui.Sequencepanel1);
        maingui.Sequencepanel1.addMouseListener(maingui);
        maingui.getContentPane().add(maingui.Sequencepanel2);
        maingui.Sequencepanel2.addMouseListener(maingui);
        maingui.getContentPane().add(maingui.Settingspanel1);
        maingui.getContentPane().add(maingui.Settingspanel2);
        maingui.enable("LoadNewSequence", true);
        maingui.enable("DrawCGR", true);
        maingui.enable("LoadProject", true);
        maingui.enable("SaveProject", false);
        maingui.enable("ExportPlot", false);
        maingui.enable("PrintPlot", false);
        maingui.enable("Settings", false);
        maingui.enable("Tools", true);
        maingui.enable("ApplyColor", true);
        maingui.enable("Movie", true);
        maingui.enable("Split", true);
        maingui.enable("ShowLabel", false);
        maingui.enable("Select", false);
        maingui.enable("CountPoints", false);
        maingui.enable("MeshPlot", true);
        maingui.enable("DrawMesh", true);
        maingui.enable("MeshCount", false);
        maingui.enable("Angle", false);
        maingui.enable("ZoomIn", false);
        maingui.enable("ZoomOut", false);
        maingui.enable("Enhancements", true);
    }
}
