//package CGRexpack;

import java.awt.*;
import java.awt.event.*;
import java.io.*;
//import javax.swing.JFileChooser;
import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;
//import javax.swing.text.StyledEditorKit;

public class CGRexMainGUI extends JFrame
    implements ActionListener, MouseListener, MouseMotionListener
{
	
	public static final long serialVersionUID = 0;
	public int MeshCountStart;
	public int nmercount;
    public int Select;
    private JMenuBar mBar;
    private JMenu File;   
   // private JMenu NewProject;
    //private JMenu CGR;
    private JMenuItem CloseProject;
    private JMenuItem DrawCGR;
    private JSeparator jSeparator1;
    private JMenuItem LoadProject;
    private JMenuItem SaveProject;
    private JMenuItem CurrentProject;
    private JMenuItem SavePlot;
    private JMenuItem PrintPlot;
    private JSeparator jSeparator2;
    private JMenuItem Exit;

    private JMenuItem Selecttype;
    private JMenuItem CGRDrawingShape;
    private JMenu PointsAssignments;
    private JMenuItem Predefined;
    private JMenuItem Clustering;
    private JMenuItem UserDefined;
    private JMenu Tools;
    private JMenuItem ApplyColor;
    private JMenuItem Movie;
    private JMenuItem Split;
    private JMenuItem ShowLabel;
    public JMenuItem nmerCount;
    private JMenu MeshPlot;
    private JMenuItem DrawMesh;
    private JMenuItem MeshCount;
    private JMenuItem Angle;
    private JMenuItem ZoomIn;
    private JMenuItem ZoomOut;
    private JMenu PlotProperties;
    private JMenu PlotSize;
    private JMenu PointSize;
    private JMenuItem Size_0;
    private JMenuItem Size_1;
    private JMenuItem Size_2;
    private JMenuItem Size_3;
    private JMenuItem Size_4;
    private JMenuItem Size_5;
    private JMenuItem Size_6;
    private JMenuItem Size_7;
    private JMenuItem Size_8;
    private JMenuItem Size_9;
    
    private JMenuItem Size1_0;
    private JMenuItem Size1_1;
    private JMenuItem Size1_2;
    private JMenuItem Size1_3;
    private JMenuItem Size1_4;
    private JMenuItem Size1_5;
    private JMenuItem Size1_6;
    private JMenuItem Size1_7;
    private JMenuItem Size1_8;
    private JMenuItem Size1_9;
    
    private JMenu Enhancements;
    private JMenuItem ConvertSeqType;
    private JMenuItem Multiplot;
    private JMenu Help;
    private JMenuItem HelpCGREX;
    private JMenuItem AboutCGREX;
    private JToolBar ToolBar;
    private JButton SaveButton;
    private JButton PrintButton;
    private JButton DrawCGRButton;
    public JButton CountButton;
    private JButton SelectButton;
    private JButton ColorButton;
    private JButton MeshButton;
    private JButton SplitButton;
    private JButton ZoomInButton;
    private JButton ZoomOutButton;
    private JButton MovieButton;
    private JButton HelpButton;
    
    Container Content;
    
    JOptionPane jop;    
    CGRDrawingGUI drawingGUI;    
    CGRDrawing plottingPanel;
    CGRDrawing drawing1;
    CGRDrawing drawing2;
    MYCGREX mycgrex;
    nMercount nMercount1;
    seqpanel1 Sequencepanel1;
    seqpanel1 Sequencepanel2;
    settingsPanel Settingspanel1;
    settingsPanel Settingspanel2;
    Text tx1;
    String SeqStr1;
    String SeqStr2;
    String SeqType1;
    String SeqType2;
   	File SeqFile;
   	File multiSeqfile;

    
    int NoOfCrnrs1;
    int NoOfCrnrs2;
    Point drag1;
    Point drop1;
    Point drag2;
    Point drop2;
    Point rubber;
    int Active;
    int zoomlevel1;
    int zoomlevel2;

    public CGRexMainGUI()
    {
        Content = null;
        jop = null;
        drawing1 = null;
        drawing2 = null;
        SeqFile = null;
        multiSeqfile = null;
        Sequencepanel1 = null;
        Sequencepanel2 = null;
        Settingspanel1 = null;
        Settingspanel2 = null;
        tx1=null;
        SeqStr1 = "";
        SeqStr2 = "";
        SeqType1 = "";
        SeqType2 = "";
        Active = 1;
        zoomlevel1 = 0;
        zoomlevel2 = 0;
        MeshCountStart = 0;
        nmercount=0;
        Select = 1;
        drag1 = new Point(200,200);
        drop1 = new Point(200,200);
        Content = getContentPane();
		  
               
        final JPopupMenu popupMenu = new JPopupMenu();

	   
	    JMenuItem cutMenuItem = new JMenuItem("Cut");
	    //cutMenuItem.addActionListener();
	    popupMenu.add(cutMenuItem);
	   /* MouseListener mouseListener = new MouseAdapter() 
	    {
	      private void showIfPopupTrigger(MouseEvent mouseEvent) 
	      {
	        if (mouseEvent.isPopupTrigger()) 
	        {
	          popupMenu.show(mouseEvent.getComponent(),
				  mouseEvent.getX(),
				  mouseEvent.getY());
	        }
	      }
	      public void mousePressed(MouseEvent mouseEvent) {
	        showIfPopupTrigger(mouseEvent);
	      }
	      public void mouseReleased(MouseEvent mouseEvent) {
	        showIfPopupTrigger(mouseEvent);
	      }
	    };*/
        
	    
  		
	    drawing1 = new CGRDrawing(512, 512);
	    drawing1.setBounds(30, 80, 512, 512);
        drawing1.repaint();
  		Content.add(drawing1);     
        //Sequencepanel1 = new seqpanel1(20, 620, 760, 65);
        //Content.add(Sequencepanel1);
        //Sequencepanel1.setVisible(true);
        //Sequencepanel1.seq.setText(SeqStr1);
      //  String as[] = {
      //      "No Selection Made"
      //  };
      //Settingspanel1 = new settingsPanel("Settings", as, 590, 100, 200, 400);
        //Settingspanel1.setVisible(true);
       // Content.add(Settingspanel1);
        //Settingspanel1.repaint();
        drawing2 = new CGRDrawing(512, 512);
        Sequencepanel2 = new seqpanel1(20, 620, 760, 65);
        String as1[] = { "NO"};
        Settingspanel2 = new settingsPanel("Settings", as1, 590, 100, 200, 400);
        drawing1.addMouseListener(this);
        drawing1.addMouseMotionListener(this);
        drawing2.addMouseListener(this);
        drawing2.addMouseMotionListener(this);
        initComponents();
        //Settingspanel1.repaint();
    }

    public void initComponents()
    {

        mBar = new JMenuBar();
        File = new JMenu();
       // NewProject = new JMenu();
       // CGR = new JMenu();
        CloseProject = new JMenuItem();
        DrawCGR = new JMenuItem();
        jSeparator1 = new JSeparator();
        LoadProject = new JMenuItem();
        CurrentProject = new JMenuItem();
        SaveProject = new JMenuItem();
        SavePlot = new JMenuItem();
        PrintPlot = new JMenuItem();
        jSeparator2 = new JSeparator();
        Exit = new JMenuItem();
        
       // Settings = new JMenu();
        Selecttype = new JMenuItem();
        CGRDrawingShape = new JMenuItem();
        PointsAssignments = new JMenu();
        Predefined = new JMenuItem();
        Clustering = new JMenuItem();
        UserDefined = new JMenuItem();
        Tools = new JMenu();
        ApplyColor = new JMenuItem();
        Movie = new JMenuItem();
        Split = new JMenuItem();
        ShowLabel = new JMenuItem();
        nmerCount = new JMenuItem();
      //  Manual = new JMenuItem();
        //Automatic = new JMenuItem();
        MeshPlot = new JMenu();
        DrawMesh = new JMenuItem();
        MeshCount = new JMenuItem();
        Angle = new JMenuItem();
        ZoomIn = new JMenuItem();
        ZoomOut = new JMenuItem();
		PlotSize = new JMenu();
		PointSize = new JMenu();
		PlotProperties = new JMenu();
      
        
       
        Size_0 = new JMenuItem();
        Size_1 = new JMenuItem();
        Size_2 = new JMenuItem();
        Size_3 = new JMenuItem();
        Size_4 = new JMenuItem();
        Size_5 = new JMenuItem();
        Size_6 = new JMenuItem();
        Size_7 = new JMenuItem();
        Size_8 = new JMenuItem();
        Size_9 = new JMenuItem();
        
        
        Size1_0 = new JMenuItem();
        Size1_1 = new JMenuItem();
        Size1_2 = new JMenuItem();
        Size1_3 = new JMenuItem();
        Size1_4 = new JMenuItem();
        Size1_5 = new JMenuItem();
        Size1_6 = new JMenuItem();
        Size1_7 = new JMenuItem();
        Size1_8 = new JMenuItem();
        Size1_9 = new JMenuItem();
        
        
        Enhancements = new JMenu();
        ConvertSeqType = new JMenuItem();
        Multiplot = new JMenuItem();
        Help = new JMenu();
        HelpCGREX = new JMenuItem();
        AboutCGREX = new JMenuItem();
        ToolBar = new JToolBar();
        //OpenButton = new JButton();
        SaveButton = new JButton();
        PrintButton = new JButton();
        DrawCGRButton = new JButton();
        CountButton = new JButton();
        MovieButton = new JButton();
        SelectButton = new JButton();
        ColorButton= new JButton();
        MeshButton= new JButton() ;
        SplitButton= new JButton() ;
        ZoomInButton = new JButton();
        ZoomOutButton = new JButton();
        HelpButton = new JButton();
        Content.setLayout(null);
        File.setMnemonic('F');
        File.setText("File");
       // CGR.setText("CGR");
       
        File.setPreferredSize(new Dimension(40, 25));
        DrawCGR.setMnemonic('D');
        DrawCGR.setText("Draw CGR");
        DrawCGR.addActionListener(this);
        //CGR.add(DrawCGR);
        
       // NewProject.setText("New Project");
       // NewProject.addActionListener(this);
      //  NewProject.add(DrawCGR);
        File.add(DrawCGR);
       
        //CGR.setPreferredSize(new Dimension(40, 25));
        File.add(jSeparator1);
        LoadProject.setMnemonic('L');
        LoadProject.setText("Load Project");
        LoadProject.addActionListener(this);
        File.add(LoadProject);
        
        SaveProject.setMnemonic('S');
        SaveProject.setText("Save Project");
        SaveProject.addActionListener(this);
        File.add(SaveProject);
        
        CurrentProject.setMnemonic('S');
        CurrentProject.setText("Current Project");
        CurrentProject.addActionListener(this);
        File.add(CurrentProject);
        
        CloseProject.setText("Close Project");
        CloseProject.addActionListener(this);
        File.add(CloseProject);
        SavePlot.setMnemonic('E');
        SavePlot.setText("Save Plot");
        SavePlot.addActionListener(this);
        File.add(SavePlot);
        PrintPlot.setMnemonic('P');
        PrintPlot.setText("Print Plot");
        PrintPlot.addActionListener(this);
        File.add(PrintPlot);
        File.add(jSeparator2);
        Exit.setMnemonic('X');
        Exit.setText("Exit");
        Exit.addActionListener(this);
        File.add(Exit);
        mBar.add(File);
      //  mBar.add(CGR);
       // Settings.setText("Settings");
       // Settings.setPreferredSize(new Dimension(90, 25));
       // Selecttype.setText("Select Type");
       // Selecttype.addActionListener(this);
       // Settings.add(Selecttype);
        CGRDrawingShape.setText("Plot Shape");
        CGRDrawingShape.addActionListener(this);
       // Settings.add(CGRDrawingShape);
        PointsAssignments.setText("Points Assignments");
        Predefined.setText("Predefined");
        Predefined.addActionListener(this);
        PointsAssignments.add(Predefined);
        Clustering.setText("Clustering");
        Clustering.addActionListener(this);
        PointsAssignments.add(Clustering);
        UserDefined.setText("User Defined");
        UserDefined.addActionListener(this);
        PointsAssignments.add(UserDefined);
       // Settings.add(PointsAssignments);
       // mBar.add(Settings);
        Tools.setText("Tools");
        Tools.setPreferredSize(new Dimension(50, 25));
        ApplyColor.setText("Color");
        ApplyColor.addActionListener(this);
        Tools.add(ApplyColor);
        Movie.setText("Movie");
        Movie.addActionListener(this);
        Tools.add(Movie);
        Split.setText("Split Plot");
        Split.addActionListener(this);
        Tools.add(Split);
        ShowLabel.setText("ShowLabel");
        ShowLabel.addActionListener(this);
        Tools.add(ShowLabel);
        nmerCount.setText("Count N-mer");
        nmerCount.addActionListener(this);
        Tools.add(nmerCount);
        MeshPlot.setText("Mesh Plot");
        DrawMesh.setText("Draw Mesh");
        DrawMesh.addActionListener(this);
        MeshPlot.add(DrawMesh);
        MeshCount.setText("Mesh Count");
        MeshCount.addActionListener(this);
        MeshPlot.add(MeshCount);
        Angle.setText("Angle.");
        Angle.addActionListener(this);
        MeshPlot.add(Angle);
        Tools.add(MeshPlot);
        ZoomIn.setText("Zoom In");
        ZoomIn.addActionListener(this);
        Tools.add(ZoomIn);
        ZoomOut.setText("Zoom Out");
        ZoomOut.addActionListener(this);
        Tools.add(ZoomOut);
        
        PlotProperties.setText("Plot Properties");
        
        PlotSize.setText("Plot Size");
        PointSize.setText("Point Size");
        
        
       
        Size_0.setText("Size-0");
        Size_0.addActionListener(this);
        Size1_0.setText("Size-0");
        Size1_0.addActionListener(this);
        PlotSize.add(Size_0);
        PointSize.add(Size1_0);
        
        Size_1.setText("Size-1");
        Size_1.addActionListener(this);
        Size1_1.setText("Size-1");
        Size1_1.addActionListener(this);
        PlotSize.add(Size_1);
        PointSize.add(Size1_1);
        
        Size_2.setText("Size-2");
        Size_2.addActionListener(this);
        Size1_2.setText("Size-2");
        Size1_2.addActionListener(this);
        PlotSize.add(Size_2);
        PointSize.add(Size1_2);
        
        Size_3.setText("Size-3");
        Size_3.addActionListener(this);
        Size1_3.setText("Size-3");
        Size1_3.addActionListener(this);
        PlotSize.add(Size_3);
        PointSize.add(Size1_3);
        
        Size_4.setText("Size-4");
        Size_4.addActionListener(this);
        Size1_4.setText("Size-4");
        Size1_4.addActionListener(this);
        PlotSize.add(Size_4);
        PointSize.add(Size1_4);
        
        Size_5.setText("Size-5");
        Size_5.addActionListener(this);
        Size1_5.setText("Size-5");
        Size1_5.addActionListener(this);
        PlotSize.add(Size_5);
        PointSize.add(Size1_5);
        
        Size_6.setText("Size-6");
        Size_6.addActionListener(this);
        Size1_6.setText("Size-6");
        Size1_6.addActionListener(this);
        PlotSize.add(Size_6);
        PointSize.add(Size1_6);
        
        Size_7.setText("Size-7");
        Size_7.addActionListener(this);
        Size1_7.setText("Size-7");
        Size1_7.addActionListener(this);
        PlotSize.add(Size_7);
        PointSize.add(Size1_7);
        
        Size_8.setText("Size-8");
        Size_8.addActionListener(this);
        Size1_8.setText("Size-8");
        Size1_8.addActionListener(this);
        PlotSize.add(Size_8);
        PointSize.add(Size1_8);
        
        Size_9.setText("Size-9");
        Size_9.addActionListener(this);
        Size1_9.setText("Size-9");
        Size1_9.addActionListener(this);
        PlotSize.add(Size_9);
        PointSize.add(Size1_9);
        
        
       
        
        
        
        PlotProperties.add(PlotSize);
        PlotProperties.add(PointSize); 
        //Tools.add(PlotSize);
        PlotProperties.setPreferredSize(new Dimension(90, 25));
        mBar.add(PlotProperties);
        mBar.add(Tools);
        Enhancements.setText("Enhancements");
        Enhancements.setPreferredSize(new Dimension(85, 25));
        ConvertSeqType.setText("Convert Sequence Type");
        ConvertSeqType.addActionListener(this);
        Enhancements.add(ConvertSeqType);
        Multiplot.setText("Multiplot");
        Multiplot.addActionListener(this);
        Enhancements.add(Multiplot);
        mBar.add(Enhancements);
        Help.setText("Help");
        Help.setPreferredSize(new Dimension(35, 25));
        HelpCGREX.setText("Help");
        HelpCGREX.addActionListener(this);
        Help.add(HelpCGREX);
        AboutCGREX.setText("About CGREX");
        AboutCGREX.addActionListener(this);
        Help.add(AboutCGREX);
        mBar.add(Help);
        setJMenuBar(mBar); 
        Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
       // setBounds((dimension.width - 801) / 2, (dimension.height - 768) / 2 - 3, 801, 768);
       // setBounds((dimension.width - 508) / 2, (dimension.height - 358) / 2 - 3, 508, 358);
        setBounds((dimension.width - 1008) / 2, (dimension.height - 760) / 2 - 3, 1008, 738);
        ToolBar.setBorder(new EtchedBorder());
        //ToolBar.setBounds(100,100,100,100);
        ToolBar.setRollover(true);
        
       /* OpenButton.setIcon(new   ImageIcon(getClass().getResource("/Resources/Icons/32x32-open.png")));
        OpenButton.setToolTipText("Load New Sequence");
        OpenButton.setBorder(new EmptyBorder(new Insets(3, 3, 3, 3)));
        OpenButton.setMaximumSize(new Dimension(50, 50));
        OpenButton.setPreferredSize(new Dimension(50, 50));
        OpenButton.setVerticalAlignment(3);
        OpenButton.addActionListener(this);
        ToolBar.add(OpenButton);*/
        //SaveButton.setIcon(new ImageIcon(getClass().getResource("Save.png")));
       
        DrawCGRButton.setIcon(new ImageIcon(getClass().getResource("Icon_Draw.png")));
        DrawCGRButton.setToolTipText("Draw CGR");
        DrawCGRButton.setBorder(new EmptyBorder(new Insets(3, 3, 3, 3)));
        DrawCGRButton.setMaximumSize(new Dimension(40, 50));
        DrawCGRButton.setPreferredSize(new Dimension(40, 50));
        DrawCGRButton.setVerticalAlignment(3);
        DrawCGRButton.addActionListener(this);
        ToolBar.add(DrawCGRButton);
      SaveButton.setIcon(new ImageIcon(getClass().getResource("Icon_Save.png")));
        SaveButton.setToolTipText("Save Plot");
        SaveButton.setBorder(new EmptyBorder(new Insets(3, 3, 3, 3)));
        SaveButton.setMaximumSize(new Dimension(40, 50));
        SaveButton.setPreferredSize(new Dimension(40, 50));
        SaveButton.setVerticalAlignment(3);
        SaveButton.addActionListener(this);
        ToolBar.add(SaveButton);
       // PrintButton.setIcon(new       ImageIcon(getClass().getResource("/Resources/Icons/Print.png")));
        PrintButton.setIcon(new ImageIcon(getClass().getResource("Icon_Print.png")));
        PrintButton.setToolTipText("Print Plot");
        PrintButton.setBorder(new EmptyBorder(new Insets(3, 3, 3, 3)));
        PrintButton.setMaximumSize(new Dimension(40, 50));
        PrintButton.setPreferredSize(new Dimension(40, 50));
        PrintButton.setVerticalAlignment(3);
        PrintButton.addActionListener(this);
        ToolBar.add(PrintButton);
               
        
        
        ColorButton.setIcon(new ImageIcon(getClass().getResource("Icon_Color.png")));
        ColorButton.setToolTipText("Color");
        ColorButton.setBorder(new EmptyBorder(new Insets(3, 3, 3, 3)));
        ColorButton.setMaximumSize(new Dimension(40, 50));
        ColorButton.setPreferredSize(new Dimension(40, 50));
        ColorButton.setVerticalAlignment(3);
        ColorButton.addActionListener(this);
        ToolBar.add(ColorButton);
        
        SplitButton.setIcon(new ImageIcon(getClass().getResource("Icon_Split.png")));
        SplitButton.setToolTipText("Split Plot");
        SplitButton.setBorder(new EmptyBorder(new Insets(3, 3, 3, 3)));
        SplitButton.setMaximumSize(new Dimension(40, 50));
        SplitButton.setPreferredSize(new Dimension(40, 50));
        SplitButton.setVerticalAlignment(3);
        SplitButton.addActionListener(this);
        ToolBar.add(SplitButton);
        
        CountButton.setIcon(new ImageIcon(getClass().getResource("Icon_Count.png")));
        CountButton.setToolTipText("Count N-mer");
        CountButton.setBorder(new EmptyBorder(new Insets(3, 3, 3, 2)));
        CountButton.setMaximumSize(new Dimension(50, 50));
        CountButton.setPreferredSize(new Dimension(50, 50));
        CountButton.setVerticalAlignment(3);
        CountButton.addActionListener(this);
        ToolBar.add(CountButton);
        
        SelectButton.setIcon(new ImageIcon(getClass().getResource("Icon_Label.png")));
        SelectButton.setToolTipText("Show Label");
        SelectButton.setBorder(new EmptyBorder(new Insets(3, 3, 3, 3)));
        SelectButton.setMaximumSize(new Dimension(50, 50));
        SelectButton.setPreferredSize(new Dimension(50, 50));
        SelectButton.setVerticalAlignment(3);
        SelectButton.addActionListener(this);
        ToolBar.add(SelectButton);
        
        //MeshButton.setIcon(new ImageIcon(getClass().getResource("Icon_Mesh.png")));
        MeshButton.setToolTipText("Draw Mesh");
        MeshButton.setBorder(new EmptyBorder(new Insets(3, 3, 3, 3)));
        MeshButton.setMaximumSize(new Dimension(40, 50));
        MeshButton.setPreferredSize(new Dimension(40, 50));
        MeshButton.setVerticalAlignment(3);
        MeshButton.addActionListener(this);
       // DrawCGRButton.setIcon(new ImageIcon(getClass().getResource("/Resources/Icons/Draw.png")));
       
        
        ToolBar.add(CountButton);
        
        
        //ZoomInButton.setIcon(new ImageIcon(getClass().getResource("/Resources/Icons/ZoomIn.png")));
        
        ZoomInButton.setIcon(new ImageIcon(getClass().getResource("Icon_Zoom-In.png")));
        ZoomInButton.setToolTipText("Zoom In");
        ZoomInButton.setBorder(new EmptyBorder(new Insets(3, 3, 3, 3)));
        ZoomInButton.setMaximumSize(new Dimension(40, 50));
        ZoomInButton.setPreferredSize(new Dimension(40, 50));
        ZoomInButton.setVerticalAlignment(3);
        ZoomInButton.addActionListener(this);
        ToolBar.add(ZoomInButton);
        //ZoomOutButton.setIcon(new ImageIcon(getClass().getResource("/Resources/Icons/ZoomOut.png")));
       
       ZoomOutButton.setIcon(new ImageIcon(getClass().getResource("Icon_Zoom-Out.png")));
        ZoomOutButton.setToolTipText("Zoom Out");
        ZoomInButton.setBorder(new EmptyBorder(new Insets(3, 3, 3, 3)));
        ZoomOutButton.setMaximumSize(new Dimension(40, 50));
        ZoomOutButton.setPreferredSize(new Dimension(40, 50));
        ZoomOutButton.setVerticalAlignment(3);
        ZoomOutButton.addActionListener(this);
        ToolBar.add(ZoomOutButton);
        //MovieButton.setIcon(new ImageIcon(getClass().getResource("/Resources/Icons/Movie.png")));
        
        MovieButton.setIcon(new ImageIcon(getClass().getResource("Icon_Play.png")));
        MovieButton.setToolTipText("Movie");
        ZoomInButton.setBorder(new EmptyBorder(new Insets(3, 3, 3, 3)));
        MovieButton.setMaximumSize(new Dimension(40, 50));
        MovieButton.setPreferredSize(new Dimension(40, 50));
        MovieButton.setVerticalAlignment(3);
        MovieButton.addActionListener(this);
        ToolBar.add(MovieButton);
        //HelpButton.setIcon(new ImageIcon(getClass().getResource("/Resources/Icons/Help.png")));
        
        HelpButton.setIcon(new ImageIcon(getClass().getResource("Icon_Help.png")));
        HelpButton.setToolTipText("Help");
       HelpButton.setBorder(new EmptyBorder(new Insets(3, 3, 3, 3)));
        HelpButton.setMaximumSize(new Dimension(40, 50));
        HelpButton.setPreferredSize(new Dimension(40, 50));
        HelpButton.setVerticalAlignment(3);
        HelpButton.addActionListener(this);
        ToolBar.add(HelpButton);
        Content.add(ToolBar);
       
        ToolBar.setBounds(0, 0, 1020, 50);
        setTitle("CGRex");
        
        
        CloseProject.setAccelerator(KeyStroke.getKeyStroke(78, 2));
        DrawCGR.setAccelerator(KeyStroke.getKeyStroke(68, 2));
        LoadProject.setAccelerator(KeyStroke.getKeyStroke(79, 2));
        SaveProject.setAccelerator(KeyStroke.getKeyStroke(83, 2));
        SavePlot.setAccelerator(KeyStroke.getKeyStroke(69, 2));
        PrintPlot.setAccelerator(KeyStroke.getKeyStroke(80, 2));
        Exit.setAccelerator(KeyStroke.getKeyStroke(88, 2));
        ApplyColor.setAccelerator(KeyStroke.getKeyStroke(67, 2));
        Split.setAccelerator(KeyStroke.getKeyStroke(84, 2));
        DrawMesh.setAccelerator(KeyStroke.getKeyStroke(72, 2));
        MeshCount.setAccelerator(KeyStroke.getKeyStroke(75, 2));
        Angle.setAccelerator(KeyStroke.getKeyStroke(65, 2));
        ShowLabel.setAccelerator(KeyStroke.getKeyStroke(76, 2));
        Movie.setAccelerator(KeyStroke.getKeyStroke(77, 2));
     //   Manual.setAccelerator(KeyStroke.getKeyStroke(90, 2));
        nmerCount.setAccelerator(KeyStroke.getKeyStroke(65, 2));
        ZoomIn.setAccelerator(KeyStroke.getKeyStroke(521, 2));
        ZoomOut.setAccelerator(KeyStroke.getKeyStroke(45, 2));
        HelpCGREX.setAccelerator(KeyStroke.getKeyStroke(72, 2));
        setResizable(false);
        enable("CloseProject", false);
        enable("DrawCGR", true);
        enable("LoadProject", true);
        enable("SaveProject", false);
        enable("ExportPlot", false);
        enable("PrintPlot", false);
        enable("PlotProperties", false);
       
        enable("ApplyColor", false);
        enable("Movie", false);
        enable("Split", false);
        enable("ShowLabel", false);
        enable("nmerCount", false);
        enable("MeshPlot", false);
        enable("Tools", false);
        
        enable("Select", false);
        enable("Manual", false);
        enable("ZoomIn", false);
        enable("ZoomOut", false);
        enable("Movie", false);
        enable("Enhancements", false);
        enable("CurrentProject", false);
        addWindowListener(new WindowAdapter() {

            public void windowClosing(WindowEvent windowevent)
            {
                setVisible(true);
                //(new SaveDialog(drawing1)).setVisible(true);
            }
       });
    }

    public void actionPerformed(ActionEvent actionevent)
    {
        Object obj = actionevent.getSource();
      
        if(obj == CloseProject)
        {
        	
        	LoadProject.setEnabled(true);
        	//dispose();
        	drawing1.setSeqStr("");
        	drawing1.level=0;
        	drawing1.TestSeqStr ="";
        	drawing1.TestSeqType = "None";
        	drawing1.TestCorners = 0;
        	SeqFile = null;
         	drawing1.SeqStr ="";
        	drawing1.SeqType = "None";
        	drawing1.Corners = 4;
        	enable("", false);
        	enable("Movie",false);
        	enable("Split",false);
        	enable("ShowLabel",false);
        	enable("nmerCount",false);
        	enable("Tools",false);
        	enable("Enhancements",false);
        	enable("CloseProject",false);
        	enable("SaveProject",false);
        	enable("CurrentProject",false);
        	enable("SavePlot",false);
        	enable("MeshPlot ",false);
        	enable("DrawMesh ",false);
        	enable("MeshCount",false);
        	enable("Angle",false);
        	enable("ZoomIn",false);
        	enable("ZoomOut",false);
        	enable("PlotSize",false);
        	enable("PointSize",false);
        	enable("PlotProperties", false);
        	enable("ConvertSeqType", false);
            enable("Multiplot", false);
            enable("PrintPlot", false);
           // enable("AboutCGREX", false);
        	enable("ApplyColor", false);
        	enable("PlotSize", false);
        	enable("PointSize", false);
        	enable("DrawMesh",false);
        	Sequencepanel1.setVisible(false);     
        	clearAll();  
        	drawing1.setcounttype(false);
        	Select = 0;
        	//drawing1.removeMouseListener(drawing1);
        	//drawing2.removeMouseListener(drawing2);
        }
        	
        else if((obj == DrawCGR ) || (obj == DrawCGRButton))
        {	
//        	new
          	drawing1.count = false;
        	//LoadProject.setEnabled(false);        	
        	Active = 1;
        	drawing1.level=0;
        	//drawing1.removeMouseListener(drawing1);
        	//drawing2.removeMouseListener(drawing2);
        	clearmultiPlot();
        	drawing1.setSeqStr("");
        	drawing1.TestSeqStr ="";
        	drawing1.TestSeqType = "None";
        	drawing1.TestCorners = 0;
        	SeqFile = null;
        	drawing1.SeqStr ="";
        	drawing1.SeqType = "None";
        	drawing1.Corners = 4;
        	drawing1.setDotSize(1);
        	drawing1.CGRDrawing1(512, 512); 
        	drawingGUI = new CGRDrawingGUI(this);
        	drawingGUI.showProperties();
        	drawingGUI.setVisible(true);
        	    	
        	enable("DrawCGR", true);
        	enable("PlotProperties", false);
        	
        	enable("Enhancements", false);
        	enable("Movie", false);
        	enable("nmerCount", false);
        	
        	enable("Split", false);
        	enable("Tools", false);
        	//enable("CountPoints", false);
        	//enable("Manual", false);
        	enable("MeshPlot", false);
        	enable("ApplyColor", false);
        	enable("ShowLabel", false);
        	enable("Angle", false);
        	enable("ZoomIn", false);
        	enable("ZoomOut", false);
        	enable("Enhancements", false);
        	enable("PlotProperties", false);
        	enable("CurrentProject", false);
        	drawing1.setcounttype(false);
        	
        	
        	// clearAll();
            // drawing1.setVisible(true);
            // drawing1.setBounds(30, 80, 512, 512);
            // Sequencepanel1.setBounds(20, 600, 760, 65);
            // Sequencepanel1.setSize(760, 65);
        	  
        /*	
            if(!drawing1.validateSettings())
            
            {System.out.println("^^-------drawing1.validateSettings() ..."+drawing1.validateSettings());
            	System.out.println(" validateSettings failed...");
                JOptionPane _tmp2 = jop;
                JOptionPane _tmp3 = jop;
                JOptionPane.showMessageDialog(this, "Invalid selection", "Type mismatch", 0);
            } else
            {System.out.println("drawing1.validateSettings() ..."+!drawing1.validateSettings());
            	System.out.println(" -----validateSettings success...");
                clearAll();
                Content.remove(drawing1);
                drawing1.setBounds(30, 80, 512, 512);
                drawing1.clearPanel();
                drawing1.setMultiplot(false);
                drawing2.setMultiplot(false);
                drawing1.drawPoly();
                drawing1.plot();
                repaint();
                drawing1.repaint();
                Content.add(drawing1);
                drawing1.setVisible(true);
                String as[] = {
                    "Shape:" + drawing1.getCorners(), "Sequence Type:" + drawing1.getSeqType(), "Name of sequence:", "_Points Assignment"
                };
                String as1[] = drawing1.getDistribution();
                String as2[] = new String[as.length + as1.length];
                for(int k1 = 0; k1 < as.length; k1++)
                    as2[k1] = new String(as[k1]);

                for(int l1 = as.length; l1 < as.length + as1.length; l1++)
                    if(as1[l1 - as.length].trim().equals(""))
                        as2[l1] = new String(" ");
                    else
                        as2[l1] = new String(as1[l1 - as.length]);

                Settingspanel1 = new settingsPanel("Settings", as2, 590, 100, 200, 400);
                Settingspanel1.repaint();
                Content.add(Settingspanel1);
                Settingspanel1.setVisible(true);
                Sequencepanel1 = new seqpanel1(20, 620, 760, 65);
                Content.add(Sequencepanel1);
                Sequencepanel1.addMouseListener(this);
                Sequencepanel1.setVisible(true);
                Sequencepanel1.seq.setText(drawing1.getSeqStr());
                enable("LoadNewSequence", true);
                enable("DrawCGR", true);
                enable("LoadProject", true);
                enable("SaveProject", true);
                enable("ExportPlot", true);
                enable("PrintPlot", true);
                enable("Settings", true);
                enable("Tools", true);
                enable("Movie", true);
                enable("ShowLabel", true);
                enable("Select", true);
                enable("CountPoints", true);
                enable("Manual", true);
                enable("MeshPlot", true);
                enable("DrawMesh", true);
                enable("MeshCount", true);
                enable("Angle", true);
                enable("ZoomIn", false);
                enable("ZoomOut", false);
                enable("Enhancements", true);
                if(drawing1.getCorners() == 4)
                    enable("Automatic", true);
                else
                    enable("Automatic", false);
                Active = 1;
            }*/
        } else
        if(actionevent.getSource() == LoadProject)
        {
        	
            //Object obj2 = null;
        	drawing1.level=0;
        	ProjectFileFilter projectfilefilter = new ProjectFileFilter();
            projectfilefilter.setCurrentDirectory(new File("./Save"));
            int j1 = projectfilefilter.showOpenDialog(new JFrame());
            if(j1 == 0)
            {
                File file1 = projectfilefilter.getSelectedFile();
                SeqFile = file1;
                try
                {
                	    	
                    FileInputStream fileinputstream = new FileInputStream(file1);
                    ObjectInputStream objectinputstream = new ObjectInputStream(fileinputstream);
                    mycgrex = (MYCGREX)objectinputstream.readObject();
                   
                    loadSet(mycgrex); 
                    DrawSeqPanel();
                    DrawSettingsPanel();
             
                    //Sequencepanel1.seq.setText(drawing1.getSeqStr());
                     Sequencepanel1.seq.setText(mycgrex.SqStr);
                   // Settingspanel1.setVisible(true);
        
                    fileinputstream.close();
                    objectinputstream.close();
                    //drawingGUI.Sketch();
                    DrawCGR();

                }
                catch(FileNotFoundException filenotfoundexception)
                {
                 //   JOptionPane _tmp6 = jop;
                 //   JOptionPane _tmp7 = jop;
                    JOptionPane.showMessageDialog(this, "File not found", "File IO Error", 0);
                }
                catch(IOException ioexception)
                {
                  //  JOptionPane _tmp8 = jop;
                  //  JOptionPane _tmp9 = jop;
                    JOptionPane.showMessageDialog(this, "File not found", "File IO Error", 0);
                }
                catch(ClassNotFoundException classnotfoundexception) { }
                LoadProject.setEnabled(false);
            }
            Select = 0;
            MeshCountStart = 0;
            nmercount=0;
            drawing1.setMultiplot(false);
            drawing2.setMultiplot(false);
            enable("DrawCGR", true);
            enable("SaveProject", false);
            enable("ExportPlot", false);
            enable("PrintPlot", false);
         //   enable("Settings", false);
           /* if(drawing1.getTestSeqType().equalsIgnoreCase("Amino Acid"))
            {
                enable("CGRDrawingShape", true);
                enable("PointsAssignments", true);
            }*/
            enable("CloseProject", true);
            enable("Tools", false);
            enable("Select", false);
            enable("Manual", false);
            enable("Movie", false);
            enable("ZoomIn", false);
            enable("ZoomOut", false);
            enable("ConvertSeqType", false);
            enable("Multiplot", false);
           // enable("HelpCGREX", false);
           // enable("AboutCGREX", false);
           
        } else
        if(obj == SavePlot || obj == SaveButton)
        {
            Select = 0;
            MeshCountStart = 0;
            nmercount=0;
            enable("ZoomIn", false);
            enable("ZoomOut", false);
        //    String s = new String();
        //    Object obj3 = null;
            ImageFileFilter imagefilefilter = new ImageFileFilter();
            imagefilefilter.setCurrentDirectory(new File("./Save"));
            int i2 = imagefilefilter.showSaveDialog(new JFrame());
            if(i2 == 0)
            {
                String s1 = imagefilefilter.selected;
                File file2;
                if(imagefilefilter.getSelectedFile().toString().charAt(imagefilefilter.getSelectedFile().toString().length() - imagefilefilter.selected.length() - 1) != '.')
                    file2 = new File(imagefilefilter.getSelectedFile().toString() + "." + s1);
                else
                    file2 = imagefilefilter.getSelectedFile();
                try
                {
                    if(drawing1 == null)
                    {
                     //   JOptionPane _tmp10 = jop;
                      //  JOptionPane _tmp11 = jop;
                        JOptionPane.showMessageDialog(this, "No Picture Selected", "NO IMAGE!!!", 0);
                    } else
                    {
                        ImageIO.write(drawing1.getImage(), s1, file2);
                   //     JOptionPane _tmp12 = jop;
                   //     JOptionPane _tmp13 = jop;
                        JOptionPane.showMessageDialog(this, "Image Copied", "IMAGE COPIED!!!", 1);
                    }
                }
                catch(Exception exception1) { }
            }
        } else
        if(obj == PrintPlot || obj == PrintButton)
        {
            //Select = 0;
            MeshCountStart = 0;
            nmercount=0;
            //enable("ZoomIn", false);
            //enable("ZoomOut", false);
            if(drawing1.getImage() == null)
            {
             //   JOptionPane _tmp14 = jop;
             //   JOptionPane _tmp15 = jop;
                JOptionPane.showMessageDialog(this, "No Picture Selected", "NO IMAGE!!!", 0);
            } else
            {
                new PrintImage(drawing1.getImage());
           //     JOptionPane _tmp16 = jop;
            //    JOptionPane _tmp17 = jop;
                JOptionPane.showMessageDialog(this, "Image sent to printer", "IMAGE PRINTED!!!", 1);
            }
        }
        else
            if(actionevent.getSource() == CurrentProject)
            {
            	drawing1.splitPlot(0);
            	DrawCGR();
            }
        
        else
        if(actionevent.getSource() == SaveProject)
        {    // tx1.setVisible(true);
            Select = 0;
            MeshCountStart = 0;
            nmercount=0;
            //enable("ZoomIn", false);
            //enable("ZoomOut", false);
        //    String s2 = new String();
        //    Object obj4 = null;
            ProjectFileFilter projectfilefilter1 = new ProjectFileFilter();
            projectfilefilter1.setCurrentDirectory(new File("./Save"));
            int j2 = projectfilefilter1.showSaveDialog(new JFrame());
            if(j2 == 0)
            {
                String s3 = projectfilefilter1.selected;
                File file3;
                if(projectfilefilter1.getSelectedFile().toString().charAt(projectfilefilter1.getSelectedFile().toString().length() - projectfilefilter1.selected.length() - 1) != '.')
                    file3 = new File(projectfilefilter1.getSelectedFile().toString() + "." + s3);
                else
                    file3 = projectfilefilter1.getSelectedFile();
                
                try
                {
                    FileOutputStream fileoutputstream = new FileOutputStream(file3);
                    ObjectOutputStream objectoutputstream = new ObjectOutputStream(fileoutputstream);
                   
                    
                    MYCGREX mycgrex1 = new MYCGREX(drawing1);
                    //System.out.print("++++++++++"+mycgrex1.DistrName);
                    objectoutputstream.writeObject(mycgrex1);
                    objectoutputstream.flush();
                    fileoutputstream.close();
                    objectoutputstream.close();
             //     JOptionPane _tmp18 = jop;
             //     JOptionPane _tmp19 = jop;
                    JOptionPane.showMessageDialog(this, "Project file has been saved", "Project saved", 1);
                }
                catch(FileNotFoundException filenotfoundexception1)
                {
              //      JOptionPane _tmp20 = jop;
              //      JOptionPane _tmp21 = jop;
                      JOptionPane.showMessageDialog(this, "Error in saving", "File IO Error", 0);
                }
                catch(IOException ioexception1)
                {
            //        JOptionPane _tmp22 = jop;
            //        JOptionPane _tmp23 = jop;
                    JOptionPane.showMessageDialog(this, "Error in saving", "File IO Error", 0);
                }
            }
        } /*else
        if(obj == Selecttype)
        {
            //Select = 0;
            MeshCountStart = 0;
            //enable("ZoomIn", false);
            //enable("ZoomOut", false);
            enable("CGR",false);
            (new SelectType(this, drawing1)).setVisible(true);
        } else
        if(obj == CGRDrawingShape)
        {
            Select = 0;
            MeshCountStart = 0;
            enable("ZoomIn", false);
            enable("ZoomOut", false);
            (new CGRDrawingShape(drawing1)).setVisible(true);
        } else
        if(obj == Predefined)
        {
            Select = 0;
            MeshCountStart = 0;
            enable("ZoomIn", false);
            enable("ZoomOut", false);
            if(drawing1.getTestCorners() > 2)
                (new PredefinedPointAssignment(drawing1)).setVisible(true);
        } else
        if(obj == Clustering)
        {
            Select = 0;
            MeshCountStart = 0;
            enable("ZoomIn", false);
            enable("ZoomOut", false);
            if(drawing1.getTestCorners() > 2)
                (new KMeansClusteringDialog(drawing1)).setVisible(true);
        } else
        if(obj == UserDefined)
        {
            Select = 0;
            MeshCountStart = 0;
            enable("ZoomIn", false);
            enable("ZoomOut", false);
            if(drawing1.getTestCorners() > 2)
                (new UserdefinedSelection(drawing1)).setVisible(true);
        }*/ 
        else if((obj == ApplyColor)|| (obj ==ColorButton))
        {
            Select = 0;
            MeshCountStart = 0;
            nmercount=0;
            enable("ZoomIn", false);
            enable("ZoomOut", false);
            if(Active == 1)
            {
                if(drawing1 == null)
                {
        //            JOptionPane _tmp24 = jop;
        //            JOptionPane _tmp25 = jop;
                    JOptionPane.showMessageDialog(this, " Select the Sequence first ! ", "NO PLOT!!!", 0);
                } else
                {
                    int i = Sequencepanel1.seq.getSelectionStart();
                    int k = Sequencepanel1.seq.getSelectionEnd();
          //          JColorChooser jcolorchooser = new JColorChooser();
        //            JColorChooser _tmp26 = jcolorchooser;
                    Color color = null;
                    color = JColorChooser.showDialog(null, "Choose the plot colour", null);

                    ApplyColor.setAction(new javax.swing.text.StyledEditorKit.ForegroundAction("Color", color));
                    drawing1.addColor(i, k, color);
                    drawing1.repaint();
                }
            } else
            if(Active == 2)
                if(drawing2 == null)
                {
              //      JOptionPane _tmp27 = jop;
              //      JOptionPane _tmp28 = jop;
                    JOptionPane.showMessageDialog(this, " Select the Sequence first ! ", "NO PLOT!!!", 0);
                } else
                {
                    int j = Sequencepanel2.seq.getSelectionStart();
                    int l = Sequencepanel2.seq.getSelectionEnd();
              //      JColorChooser jcolorchooser1 = new JColorChooser();
              //      JColorChooser _tmp29 = jcolorchooser1;
                    Color color1 = null;
                    color1 = JColorChooser.showDialog(null, "Choose the plot colour", null);

                    ApplyColor.setAction(new javax.swing.text.StyledEditorKit.ForegroundAction("Color", color1));
                    drawing2.addColor(j, l, color1);
                    drawing2.repaint();
                }
        } else
        if(obj == Movie || obj == MovieButton)
        {
            Select = 0;
            MeshCountStart = 0;
            nmercount=0;
            enable("ZoomIn", false);
            enable("ZoomOut", false);
            enable("SaveProject", false);
            enable("ExportPlot", false);
            enable("PrintPlot", false);
        //    enable("Settings", false);
            if(Active == 1)
                new Movie(this, drawing1);
            else
            if(Active == 2)
                new Movie(this, drawing2);
        } 
        else if((obj == Split) || (obj ==SplitButton))
        {
            Select = 0;
            MeshCountStart = 0;
            nmercount=0;
            enable("ZoomIn", false);
            enable("ZoomOut", false);
            enable("ShowLabel", true);
       	 enable("nmerCount", true);
       	 enable("Manual", true);
       	 enable("MeshPlot", true);
       	 enable("DrawMesh", true);
       	 enable("MeshCount", true);
       	 enable("Angle", true);
       	 //new
       	 drawing1.count = false;
            if(Active == 1)
                new Split(drawing1);
            else
            if(Active == 2)
                new Split(drawing2);
        } else
        if((obj == ShowLabel) || (obj == SelectButton))
        {
//        	new
          	drawing1.count = false;
        	Select = 0;
            enable("ZoomIn", false);
            enable("ZoomOut", false);
            drawing1.addMouseMotionListener(drawing1);
            MeshCountStart = 0;
            nmercount=0;
        } else
        	
       /* if(obj == Manual || obj == CountButton)
        {
            Select = 0;
            MeshCountStart = 0;
            enable("ZoomIn", false);
            enable("ZoomOut", false);
            if(Active == 1)
            {
                drawing1.clearPlot();
                drawing1.plot();
     //         drawing1.setMainFrameObject(this);
                drawing1.addMouseListener(drawing1);
                drawing1.setcounttype(false);
            } else
            if(Active == 2)
            {
                drawing2.clearPlot();
                drawing2.plot();
     //         drawing2.setMainFrameObject(this);
                drawing2.addMouseListener(drawing2);
                drawing2.setcounttype(false);
            }
        } else */
        if((obj == nmerCount) || (obj == CountButton))
        {
            Select = 0;
            // on 1st march //Select = 1
            nmercount=1;
            MeshCountStart = 0;
            enable("ZoomIn", false);
            enable("ZoomOut", false);
            if(Active == 1)
            {
            	if(drawing1.count == true)
            		return;
                drawing1.clearPlot();
                drawing1.plot();
               drawing1.setMainFrameObject(this);
                drawing1.addMouseListener(drawing1);
                drawing1.setcounttype(true);
              	 drawing1.count = true;
            } else
            if(Active == 2)
            {
                drawing2.clearPlot();
                drawing2.plot();
                drawing2.setMainFrameObject(this);
                drawing2.addMouseListener(drawing1);
                drawing2.setcounttype(true);
            	drawing1.count = true;
            }
        } else
        if((obj == DrawMesh)|| (obj ==MeshButton))
        		
        {
            Select = 0;
            nmercount=0;
            MeshCountStart = 0;
            enable("ZoomIn", false);
            enable("ZoomOut", false);
            if(Active == 1)
            {
                drawing1.setVisible(false);
                drawing1.splitmesh();
                drawing1.repaint();
                drawing1.setVisible(true);
            } else
            if(Active == 2)
            {
                drawing2.setVisible(false);
                drawing2.splitmesh();
                drawing2.repaint();
                drawing2.setVisible(true);
            }
        } else
        if(obj == MeshCount)
        {
            Select = 0;
            enable("ZoomIn", false);
            enable("ZoomOut", false);
            nmercount=0;
            MeshCountStart = 1;
            drawing1.removeMouseMotionListener(drawing1);
        } else
        if(obj == Angle)
        {
            Select = 0;
            enable("ZoomIn", false);
            enable("ZoomOut", false);
            nmercount=0;
            MeshCountStart = 2;
            drawing1.removeMouseMotionListener(drawing1);
        } else
        if(obj == ZoomIn || obj == ZoomInButton)
        {
            if(Active == 1)
            {
                drawing1.setZoomLevel(drag1, drop1, zoomlevel1, true, true);
                drawing1.repaint();
                zoomlevel1++;
            } else
            if(Active == 2)
            {
                drawing2.setZoomLevel(drag2, drop2, zoomlevel2, true, true);
                drawing2.repaint();
                zoomlevel2++;
            }
        } else
        if(obj == ZoomOut || obj == ZoomOutButton)
        {
            if(Active == 1)
            {
                zoomlevel1--;
                if(zoomlevel1 > 0)
                {
                    drawing1.setZoomLevel(drag1, drop1, zoomlevel1, false, true);
                    drawing1.repaint();
                } else
                {
                    zoomlevel1 = 0;
                    drawing1.setZoomLevel(drag1, drop1, zoomlevel1, false, false);
                    drawing1.repaint();
                }
            } else
            if(Active == 2)
            {
                zoomlevel2--;
                if(zoomlevel2 > 0)
                {
                    drawing2.setZoomLevel(drag2, drop2, zoomlevel2, false, true);
                    drawing2.repaint();
                } else
                {
                    zoomlevel2 = 0;
                    drawing2.setZoomLevel(drag2, drop2, zoomlevel2, false, false);
                    drawing2.repaint();
                }
            }
        } else
        if(obj == ConvertSeqType)
        {
            new SeqTypeConvertionGUI(this, drawing1, drawing2);
            Select = 0;
            MeshCountStart = 0;
            nmercount=0;
            
            enable("ZoomIn", false);
            enable("ZoomOut", false);
        } else
        if(obj == Multiplot)
        {
        	drawing1.CGRDrawing1(512, 512);   
        	drawing1.dotSize = 1;
        	DrawCGR();
		    drawing1.repaint();
        	clearSinglePlot();
            new Multiplot(this, drawing1, drawing2);
            Select = 0;
            MeshCountStart = 0;
            nmercount=0;
            enable("PlotProperties", false);
            enable("Movie", false);
        	//enable("nmerCount", false);
        	enable("Split", false);
        	//enable("Tools", false);
        	enable("MeshPlot", false);
        	enable("ApplyColor", false);
        	enable("ShowLabel", false);
            enable("ZoomOut", false);
            enable("ZoomIn", false);
            enable("ZoomOut", false);
        } else
        if(obj == HelpCGREX || obj == HelpButton)
            (new Helpgui1()).setVisible(true);
	// (new About()).setVisible(true);
        else
        if(obj == AboutCGREX)
            (new About()).setVisible(true);
       /* else
        if(obj == SelectButton)
        {
            Select = 1;
            enable("Select", true);
            enable("Manual", true);
            enable("ZoomIn", true);
            enable("ZoomOut", true);
        }*/ else
        if(obj == Exit)
        {
        	(new SaveDialog(drawing1)).setVisible(true);
        }else
                	
        	if (obj == Size_0)
            {
            	//drawing1.setDotSize(1);
            	drawing1.CGRDrawing1(212, 212);        	
            	DrawCGR();
    		    drawing1.repaint();
    		    enable("ZoomIn", false);
                enable("ZoomOut", false);
            }else
        	
            	if (obj == Size_1)
                {
                	//drawing1.setDotSize(1);
                	drawing1.CGRDrawing1(242, 242);        	
                	DrawCGR();
        		    drawing1.repaint();
        		    enable("ZoomIn", false);
                    enable("ZoomOut", false);
                }else
                	if (obj == Size_2)
                    {
                    	//drawing1.setDotSize(1);
                    	drawing1.CGRDrawing1(282, 282);        	
                    	DrawCGR();
            		    drawing1.repaint();
            		    enable("ZoomIn", false);
                        enable("ZoomOut", false);
                    }else
                   	if (obj == Size_3)
                        {
                        	//drawing1.setDotSize(1);
                        	drawing1.CGRDrawing1(322, 322);        	
                        	DrawCGR();
                		    drawing1.repaint();
                		    enable("ZoomIn", false);
                            enable("ZoomOut", false);
                     }else
                   	if (obj == Size_4)
                           {
                            	//drawing1.setDotSize(1);
                            	drawing1.CGRDrawing1(362, 362);        	
                            	DrawCGR();
                    		    drawing1.repaint();
                    		    enable("ZoomIn", false);
                                enable("ZoomOut", false);
                   }else
                   	if (obj == Size_5)
                                {
                                	//drawing1.setDotSize(1);
                                	drawing1.CGRDrawing1(402, 402);        	
                                	DrawCGR();
                        		    drawing1.repaint();
                        		    enable("ZoomIn", false);
                                    enable("ZoomOut", false);
                    }else
                    	if (obj == Size_6)
                                    {
                                    	//drawing1.setDotSize(1);
                                    	drawing1.CGRDrawing1(442, 442);        	
                                    	DrawCGR();
                            		    drawing1.repaint();
                            		    enable("ZoomIn", false);
                                        enable("ZoomOut", false);
                      }else
                    	  if (obj == Size_7)
                                        {
                                        	//drawing1.setDotSize(1);
                                        	drawing1.CGRDrawing1(482, 482);        	
                                        	DrawCGR();
                                		    drawing1.repaint();
                                		    enable("ZoomIn", false);
                                            enable("ZoomOut", false);
                        }else
                         	if (obj == Size_8)
                                            {
                                            	//drawing1.setDotSize(1);
                                            	drawing1.CGRDrawing1(502, 502);        	
                                            	DrawCGR();
                                    		    drawing1.repaint();
                                    		    enable("ZoomIn", false);
                                                enable("ZoomOut", false);
                            }else
                          if (obj == Size_9)
                                                {
                                                	//drawing1.setDotSize(1);
                                                	drawing1.CGRDrawing1(512, 512);        	
                                                	DrawCGR();
                                        		    drawing1.repaint();
                                        		    enable("ZoomIn", false);
                                                    enable("ZoomOut", false);
                            }else
            
        /*if (obj == SmallPlot)
        {
        	//drawing1.setDotSize(1);
        	drawing1.CGRDrawing1(312, 312);        	
        	DrawCGR();
		    drawing1.repaint();
        }else
        if (obj == MediumPlot)
        {
       		drawing1.CGRDrawing1(412, 412);
       		DrawCGR();
		    drawing1.repaint();
        }else
        if (obj == LargePlot)
        {
       		drawing1.CGRDrawing1(512, 512);
       		DrawCGR();
		    drawing1.repaint();
        }
        else */
        if (obj == Size1_0)
        {
        drawing1.setDotSize(0);        
        DrawCGR();
        drawing1.repaint();
        enable("ZoomIn", false);
        enable("ZoomOut", false);
        }else
            if (obj == Size1_1)
            {
            drawing1.setDotSize(1);        
            DrawCGR();
            drawing1.repaint();
            enable("ZoomIn", false);
            enable("ZoomOut", false);
            }else 
                if (obj == Size1_2)
                {
                drawing1.setDotSize(2);        
                DrawCGR();
                drawing1.repaint();
                enable("ZoomIn", false);
                enable("ZoomOut", false);
                }else 
                    if (obj == Size1_3)
                    {
                    drawing1.setDotSize(3);        
                    DrawCGR();
                    drawing1.repaint();
                    enable("ZoomIn", false);
                    enable("ZoomOut", false);
                    }else 
                        if (obj == Size1_4)
                        {
                        drawing1.setDotSize(4);        
                        DrawCGR();
                        enable("ZoomIn", false);
                        enable("ZoomOut", false);
                        drawing1.repaint();
                        }else 
                            if (obj == Size1_5)
                            {
                            drawing1.setDotSize(5);        
                            DrawCGR();
                            drawing1.repaint();
                            enable("ZoomIn", false);
                            enable("ZoomOut", false);
                            }else 
                            	
                                if (obj == Size1_6)
                                {
                                drawing1.setDotSize(6);        
                                DrawCGR();
                                drawing1.repaint();
                                enable("ZoomIn", false);
                                enable("ZoomOut", false);
                                }else
                                    if (obj == Size1_7)
                                    {
                                    drawing1.setDotSize(7);        
                                    DrawCGR();
                                    drawing1.repaint();
                                    enable("ZoomIn", false);
                                    enable("ZoomOut", false);
                                    }else 
                                        if (obj == Size1_8)
                                        {
                                        drawing1.setDotSize(8);        
                                        DrawCGR();
                                        drawing1.repaint();
                                        enable("ZoomIn", false);
                                        enable("ZoomOut", false);
                                        }else 
                                            if (obj == Size1_9)
                                            {
                                            drawing1.setDotSize(9);        
                                            DrawCGR();
                                            drawing1.repaint();
                                            enable("ZoomIn", false);
                                            enable("ZoomOut", false);
                                            } 
                            	
       
            
    }

   public void displayCount(int i, String s)
    {
        //JOptionPane _tmp = jop;
       // JOptionPane _tmp1 = jop;
       // JOptionPane.showMessageDialog(getContentPane(), String.valueOf(i), "No of Points", 1);
	   JOptionPane.showMessageDialog(getContentPane(), String.valueOf (i),"No of N-mer: "+s,1);
	   
    }

    public void clearAll()
    {
        if(drawing1 != null)
            drawing1.setVisible(false);
        if(drawing2 != null)
            drawing2.setVisible(false);
        if(Sequencepanel1 != null)
        {
            Sequencepanel1.setVisible(false);
            Content.remove(Sequencepanel1);
        }
        if(Sequencepanel2 != null)
        {
            Sequencepanel2.setVisible(false);
            Content.remove(Sequencepanel2);
        }
        if(Settingspanel1 != null)
        {
            Settingspanel1.setVisible(false);
            Content.remove(Settingspanel1);
        }
        if(Settingspanel2 != null)
        {
            Settingspanel2.setVisible(false);
            Content.remove(Settingspanel2);
        }
    }

    public void enable(String s, boolean flag)
    {
    	if(s.equals("CurrentProject"))
    		CurrentProject.setEnabled(flag);
    	if(s.equals("File"))
            File.setEnabled(flag);
        if(s.equals("SavePlot"))
        	SavePlot.setEnabled(flag);
        if(s.equals("PrintPlot"))
        	PrintPlot.setEnabled(flag);
        if(s.equals("CloseProject"))
        {
            CloseProject.setEnabled(flag);
            CloseProject.setEnabled(flag);
        }
        if(s.equals("DrawCGR"))
        {
            DrawCGR.setEnabled(flag);
            DrawCGRButton.setEnabled(flag);
        }
        //if(s.equals("LoadProject"))
            //LoadProject.setEnabled(flag);
        if(s.equals("Select"))
            SelectButton.setEnabled(flag);
        if(s.equals("PlotProperties"))
        	PlotProperties.setEnabled(flag);
        if(s.equals("ExportPlot"))
        {
        	SavePlot.setEnabled(flag);
            SaveButton.setEnabled(flag);
        }
        if(s.equals("PrintPlot"))
        {
            PrintPlot.setEnabled(flag);
            PrintButton.setEnabled(flag);
        }
        if(s.equals("SaveProject"))
            SaveProject.setEnabled(flag);
        if(s.equals("Exit"))
            Exit.setEnabled(flag);
       // if(s.equals("Settings"))
        //    Settings.setEnabled(flag);
        if(s.equals("Selecttype"))
            Selecttype.setEnabled(flag);
        if(s.equals("CGRDrawingShape"))
            CGRDrawingShape.setEnabled(flag);
        if(s.equals("PointsAssignments"))
            PointsAssignments.setEnabled(flag);
        if(s.equals("Predefined"))
            Predefined.setEnabled(flag);
        if(s.equals("Clustering"))
            Clustering.setEnabled(flag);
        if(s.equals("UserDefined"))
            UserDefined.setEnabled(flag);
        if(s.equals("Tools"))
            Tools.setEnabled(flag);
        if(s.equals("ApplyColor"))
        {
        	
        	 ApplyColor.setEnabled(flag);
        	 ColorButton.setEnabled(flag);
        }
           
        if(s.equals("Movie"))
        {
            Movie.setEnabled(flag);
            MovieButton.setEnabled(flag);
        }
        if(s.equals("Split"))
        {
            Split.setEnabled(flag);
            SplitButton.setEnabled(flag);
        }
        
        if(s.equals("ShowLabel"))
        {
            ShowLabel.setEnabled(flag);
            SelectButton.setEnabled(flag);
        }
        if(s.equals("MeshPlot"))
        {
            MeshPlot.setEnabled(flag);
            MeshButton.setEnabled(flag);
        }
        
        if(s.equals("DrawMesh"))
            DrawMesh.setEnabled(flag);
        if(s.equals("MeshCount"))
        {
            MeshCount.setEnabled(flag);
                  }
        if(s.equals("Angle"))
            Angle.setEnabled(flag);
        if(s.equals("nmerCount"))
        {
        	nmerCount.setEnabled(flag);
            CountButton.setEnabled(flag);
        }
        	
        
       /* if(s.equals("Manual"))
        {
            Manual.setEnabled(flag);
            CountButton.setEnabled(flag);
        }
        if(s.equals("Automatic"))
            Automatic.setEnabled(flag);*/
        
        if(s.equals("ZoomIn"))
        {
            ZoomIn.setEnabled(flag);
            ZoomInButton.setEnabled(flag);
        }
        if(s.equals("ZoomOut"))
        {
            ZoomOut.setEnabled(flag);
            ZoomOutButton.setEnabled(flag);
        }
        if(s.equals("Enhancements"))
            Enhancements.setEnabled(flag);
        if(s.equals("ConvertSeqType"))
            ConvertSeqType.setEnabled(flag);
        if(s.equals("Multiplot"))
            Multiplot.setEnabled(flag);
        if(s.equals("Help"))
            Help.setEnabled(flag);
        if(s.equals("HelpCGREX"))
        {
            HelpCGREX.setEnabled(flag);
            HelpButton.setEnabled(flag);
        }
        if(s.equals("AboutCGREX"))
            AboutCGREX.setEnabled(flag);
    }

    public void mousePressed(MouseEvent mouseevent)
    {
    	 
    		 if(Select == 0)
    		 {
    			 Object obj = mouseevent.getSource();
    			 if(obj == drawing1)
    			 {
    				 Active = 1;
    				 drawing1.repaint();
    				 drag1 = mouseevent.getPoint();
    			 }
    			 if(obj == drawing2)
    			 {
    				 Active = 2;
    				 drawing2.repaint();
    				 drag2 = mouseevent.getPoint();
    			 }
    		}
         
    }

    public void mouseReleased(MouseEvent mouseevent)
    {
    	 if(ZoomOut.isEnabled()==true)
         {
        
    	if(Select == 1)
        {
      //      Object obj = null;
            Object obj1 = mouseevent.getSource();
            if(obj1 == drawing1)
            {
                Active = 1;
                drop1 = mouseevent.getPoint();
                Graphics2D graphics2d = (Graphics2D)drawing1.getGraphics();
                graphics2d.setColor(Color.BLACK);
                graphics2d.drawRect((int)Math.min(drag1.getX(), drop1.getX()), (int)Math.min(drag1.getY(), drop1.getY()), (int)Math.abs(drop1.getX() - drag1.getX()), (int)Math.abs(drop1.getY() - drag1.getY()));
            } else
            if(obj1 == drawing2)
            {
                Active = 2;
                drop2 = mouseevent.getPoint();
                Graphics2D graphics2d1 = (Graphics2D)drawing2.getGraphics();
                graphics2d1.setColor(Color.BLACK);
                graphics2d1.drawRect((int)Math.min(drag2.getX(), drop2.getX()), (int)Math.min(drag2.getY(), drop2.getY()), (int)Math.abs(drop2.getX() - drag2.getX()), (int)Math.abs(drop2.getY() - drag2.getY()));
            }
            if(drawing1.getMultiplot())
            {
                double d = (drag1.getX() * 398D) / 512D;
                double d1 = (drag1.getY() * 398D) / 512D;
                drag1.setLocation((int)d, (int)d1);
                d = (drop1.getX() / 512D) * 398D;
                d1 = (drop1.getY() / 512D) * 398D;
                drop1.setLocation((int)d, (int)d1);
            }
        }
         }
    }

    public void mouseEntered(MouseEvent mouseevent)
    {
    }

    public void mouseExited(MouseEvent mouseevent)
    {
    }

    public void mouseClicked(MouseEvent mouseevent)
    {
        
    	if(ZoomOut.isEnabled()==true)
        {
        Object obj = mouseevent.getSource();
        if(obj == drawing1)
            Active = 1;
        if(obj == drawing2)
            Active = 2;
        }    
        /*if(mouseevent.isMetaDown())
        {
        	if((obj == drawing1)||(obj == drawing2))
        	{
        		PlotProp = new JPopupMenu("Plot Properties");
        		PlotSize = new JMenuItem("PlotSize");
        		PlotProp.add(PlotSize);
        		PlotProp.setLocation(mouseevent.getX(),mouseevent.getY());
        		PlotProp.setVisible(true);
        	}
        	
        }
    	 if (nmercount==1)
    	 {
    		 JOptionPane.showMessageDialog(getContentPane(),String.valueOf(drawing1.countpoints),"No of n-mer"+drawing1.s,1);
    		 
    	 }*/
    	
    	 if(MeshCountStart == 1)
         {
             if(Active == 1)
             { String ss = null;
                 drawing1.setToolTipText(String.valueOf(drawing1.meshcount(mouseevent.getX(), mouseevent.getY())));
                 ss=String.valueOf(drawing1.meshcount(mouseevent.getX(), mouseevent.getY()));
                 JOptionPane.showMessageDialog(getContentPane(), ss,"Mesh Count",1);
             	
               }
             else
             if(Active == 2)
                 drawing2.setToolTipText(String.valueOf(drawing2.meshcount(mouseevent.getX(), mouseevent.getY())));
         } else
         if(MeshCountStart == 2)
             if(Active == 1)
                 drawing1.setToolTipText(String.valueOf(drawing1.getAngle(mouseevent.getX(), mouseevent.getY())));
             else
             if(Active == 2)
                 drawing2.setToolTipText(String.valueOf(drawing2.getAngle(mouseevent.getX(), mouseevent.getY())));
     
    }

    public void mouseDragged(MouseEvent mouseevent)
    {
        if(Select == 1)
        {
         //   Object obj = null;
            Object obj1 = mouseevent.getSource();
            if(obj1 == drawing1)
            {
                Active = 1;
                rubber = mouseevent.getPoint();
                drawing1.repaint();
                Graphics2D graphics2d = (Graphics2D)drawing1.getGraphics();
                graphics2d.setColor(Color.BLACK);
                graphics2d.drawRect((int)Math.min(drag1.getX(), rubber.getX()), (int)Math.min(drag1.getY(), rubber.getY()), (int)Math.abs(rubber.getX() - drag1.getX()), (int)Math.abs(rubber.getY() - drag1.getY()));
            } else
            if(obj1 == drawing2)
            {
                Active = 2;
                rubber = mouseevent.getPoint();
                drawing2.repaint();
                Graphics2D graphics2d1 = (Graphics2D)drawing2.getGraphics();
                graphics2d1.setColor(Color.BLACK);
                graphics2d1.drawRect((int)Math.min(drag2.getX(), rubber.getX()), (int)Math.min(drag2.getY(), rubber.getY()), (int)Math.abs(rubber.getX() - drag2.getX()), (int)Math.abs(rubber.getY() - drag2.getY()));
            }
        }
    }

    public void mouseMoved(MouseEvent mouseevent)
    {
       }

    public void loadSet(MYCGREX mycgrex)
    {
    	
    	//System.out.println("loadSet enter");
    	drawing1.SeqStr=mycgrex.SqStr;//"AGCTTTTTTTTTTTTTT";//mycgrex.SqStr;
    	drawing1.SeqType=mycgrex.SqType;
    	drawing1.Corners =mycgrex.NCrnrs;
    	drawing1.SeqColor = mycgrex.color;
    	drawing1.DistrName = mycgrex.DistrName;
    	drawing1.Distr = mycgrex.Distr;
    	         
        // SeqColor = TestSeqColor;
    	drawing1.setTestSeqStr(mycgrex.SqStr);
        drawing1.setTestSeqType(mycgrex.SqType);
        drawing1.setTestCorners(mycgrex.NCrnrs);
        drawing1.setTestDistribution(mycgrex.Distr);
        drawing1.setTestDistrName(mycgrex.DistrName);
        drawing1.setSplit(mycgrex.splevel);
        drawing1.setZoomLevel(mycgrex.zmlevel);
        drawing1.setzxp(mycgrex.zxp);
        drawing1.setzyp(mycgrex.zyp);
        drawing1.setTestSeqColor(mycgrex.color);
      //  System.out.println("loadSet leave");
      
    }

    public static void main(String args[])
    {
    	//JFrame frame = new JFrame("Drawing");
    	
    	
    	/*ActionListener actionListener = new ActionListener() {
    	      public void actionPerformed(ActionEvent actionEvent) {
    	        System.out.println("Selected: " + actionEvent.getActionCommand());
    	      }
    	    };

    	    
    	    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    	    final JPopupMenu popupMenu = new JPopupMenu();*/

    	     // Cut
    	 //   JMenuItem cutMenuItem = new JMenuItem("Cut");
    	 //   cutMenuItem.addActionListener(actionListener);
    	 //   popupMenu.add(cutMenuItem);

    	    // Copy
    	//    JMenuItem copyMenuItem = new JMenuItem("Copy");
    	 //   copyMenuItem.addActionListener(actionListener);
    	 //   popupMenu.add(copyMenuItem);

    	    // Paste
    	  //  JMenuItem pasteMenuItem = new JMenuItem("Paste");
    	  //  pasteMenuItem.addActionListener(actionListener);
    	  //  pasteMenuItem.setEnabled(false);
    	  //  popupMenu.add(pasteMenuItem);

    	    // Separator
    	 //   popupMenu.addSeparator();

    	    // Find
    	  //  JMenuItem findMenuItem = new JMenuItem("Find");
    	  //  findMenuItem.addActionListener(actionListener);
    	 //   popupMenu.add(findMenuItem);

    	   
    	    
    	  
    	try
        {         
        	//UIManager.installLookAndFeel("Windows Classic","com.sun.java.swing.plaf.windows.WindowsClassicLookAndFeel");
       		//UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsClassicLookAndFeel");
            UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
           UIManager.installLookAndFeel("Quaqua","com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
           // UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
          // UIManager.installLookAndFeel("Quaqua","com.sun.java.swing.plaf.motif.MotifLookAndFeel");
           // UIManager.installLookAndFeel("NimROD", "com.nilo.plaf.nimrod.NimRODLookAndFeel");
           // UIManager.setLookAndFeel("com.nilo.plaf.nimrod.NimRODLookAndFeel");
           // UIManager.setLookAndFeel(" javax.swing.plaf.metal.MetalLookAndFeel()");
            //UIManager.installLookAndFeel("Quaqua","Quaqua 3.7.3.lib.swing-layout.jar");
            //UIManager.setLookAndFeel("Quaqua 3.7.3.lib.swing-layout.jar");
         
        }
        catch(Exception exception) { }
        
        CGRexMainGUI CGRexMain = new CGRexMainGUI();
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        Dimension screenSize = toolkit.getScreenSize();
       // CGRexMain.setContentPane(CGRexMain);
        CGRexMain.setSize(screenSize.width, screenSize.height);
        CGRexMain.setLocationRelativeTo(null);
        CGRexMain.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        CGRexMain.setResizable(false);
        CGRexMain.setVisible(true);
      
        
    }
   
    public void DrawnMercount()
	{
    	nMercount1 = new nMercount (20, 500);	
	}
    
    public void DrawSeqPanel()
	{	
    	Sequencepanel1 = new seqpanel1(20, 500, 760, 65);
        SeqStr1="";
        String SeqStr2="";
        try
        {
        	if ((SeqFile) != null)
        	{
        	System.out.println("%shiiiihihihihihi"+SeqFile);
        	
            FileReader filereader = new FileReader(SeqFile);
            BufferedReader bufferedreader = new BufferedReader(filereader);
            // section to read the entire text File
            while ((SeqStr2=bufferedreader.readLine()) != null)
             {
               SeqStr1 += SeqStr2;
		     }
            filereader.close();
        	}
        	else
        	{
        		SeqStr1 = drawingGUI.seqstring;
        		
        	}
        }
        catch(Exception exception)
        {
        //JptionPane _tmp = jop;
        //JOptionPane _tmp1 = jop;
        JOptionPane.showMessageDialog(this, "File not found from DrawSeqPanel", "Error", 0);
        }
        
        drawing1.setMultiplot(false);
        drawing2.setMultiplot(false);
        MeshCountStart = 0;
        Sequencepanel1.addMouseListener(this);
        //Sequencepanel1.setVisible(true);
        Sequencepanel1.seq.setText(SeqStr1);
        drawing1.setTestSeqStr(SeqStr1);
        
        drawing1.setTestSeqColor(Color.BLACK);
        Sequencepanel1.setBounds(20, 620, 760, 65);
        Sequencepanel1.setSize(760, 65);     
        Content.add(Sequencepanel1);
        Sequencepanel1.repaint(); 
        Sequencepanel1.setVisible(false);
	}
	
	public void DrawSettingsPanel()
	{
		if ((SeqFile) != null)
		{
		String as3[] = {
                    "No Selection Made"
                };
	             String as[] = {"No of corners:" + drawing1.getTestCorners(),
                   "Sequence Type:" + drawing1.getTestSeqType(),"File Name: "+SeqFile.getName(), "_Corner Assignment"
         };
        String as1[] = drawing1.getTestDistribution();
        String as2[] = new String[as.length + as1.length];
        for(int i = 0; i < as.length; i++)
              as2[i] = new String(as[i]);

        for(int j = as.length; j < as.length + as1.length; j++)
            if(as1[j - as.length].trim().equals(""))
                as2[j] = new String(" ");
            else
                as2[j] = new String(as1[j - as.length]);
        

      	Settingspanel1 = new settingsPanel("Settings", as2, 560, 100, 200, 400);
      	
        
        
        String as4[] = drawing1.getTestDistribution();
        String as5[] = new String[as.length + as4.length];
        for(int k = 0; k < as3.length; k++)
            as5[k] = new String(as3[k]);

        for(int l = as3.length; l < as3.length + as4.length; l++)
            if(as4[l - as3.length].trim().equals(""))
                as5[l] = new String(" ");
            else
                as5[l] = new String(as4[l - as3.length]);

        //Settingspanel1.setVisible(true);
        Settingspanel1.setVisible(false);
        Content.add(Settingspanel1);
        Settingspanel1.repaint();
        
        //Settingspanel1.setVisible(true);
        //Content.add(Settingspanel1);
        //Settingspanel1.repaint();
		}
		else
			{
			String as3[] = {
                "No Selection Made"
            };
             String as[] = {"No of corners:" + drawing1.getTestCorners(),
               "Sequence Type:" + drawing1.getTestSeqType(),"File Name: Null ", "_Corner Assignment"
     };
    String as1[] = drawing1.getTestDistribution();
    String as2[] = new String[as.length + as1.length];
    for(int i = 0; i < as.length; i++)
          as2[i] = new String(as[i]);

    for(int j = as.length; j < as.length + as1.length; j++)
        if(as1[j - as.length].trim().equals(""))
            as2[j] = new String(" ");
        else
            as2[j] = new String(as1[j - as.length]);
    

  	Settingspanel1 = new settingsPanel("Settings", as2, 560, 100, 200, 400);
  	
    
    
    String as4[] = drawing1.getTestDistribution();
    String as5[] = new String[as.length + as4.length];
    for(int k = 0; k < as3.length; k++)
        as5[k] = new String(as3[k]);

    for(int l = as3.length; l < as3.length + as4.length; l++)
        if(as4[l - as3.length].trim().equals(""))
            as5[l] = new String(" ");
        else
            as5[l] = new String(as4[l - as3.length]);

    //Settingspanel1.setVisible(true);
    Settingspanel1.setVisible(false);
    Content.add(Settingspanel1);
    Settingspanel1.repaint();
    
    //Settingspanel1.setVisible(true);
    //Content.add(Settingspanel1);
    //Settingspanel1.repaint();
	}   
	}

	public void DrawCGR()
	{   
		clearAll();
	    DrawSeqPanel();
		DrawSettingsPanel();
		Settingspanel1.setVisible(true);
		drawing1.setVisible(true);
		drawing1.setBounds(30, 80, 512, 512);
		ZoomInButton.setEnabled(true);
	    drawing1.clearPanel();
	    drawing1.setMultiplot(false);
	    drawing1.drawPoly();
	    drawing1.plot();
	    //drawing1.repaint();
	    repaint();
	    Content.add(drawing1); 
	    drawing1.repaint();
	    /*String as[] = {
	        "No of Corners:" + drawing1.getCorners(), "Sequence Type:" + drawing1.getSeqType()," "+SeqFile , "_Points Assignment"
	    };
	    
	    String as1[] = drawing1.getDistribution();
	    String as2[] = new String[as.length + as1.length];
	    for(int k1 = 0; k1 < as.length; k1++)
	        as2[k1] = new String(as[k1]);
	
	    for(int l1 = as.length; l1 < as.length + as1.length; l1++)
	        if(as1[l1 - as.length].trim().equals(""))
	            as2[l1] = new String(" ");
	        else
	            as2[l1] = new String(as1[l1 - as.length]);*/
	
	
	    Sequencepanel1.setVisible(true);
	    Sequencepanel1.seq.setText(drawing1.getSeqStr());
	   
	    
	}
	
	public void clearSinglePlot()
	{
        if(drawing1 != null)
        {
            drawing1.setVisible(false);
            Content.remove(drawing1);            
        }
        
        if(Settingspanel1 != null)
        {
            Settingspanel1.setVisible(false);
            Content.remove(Settingspanel1);
        }
        
        if(Sequencepanel1 != null)
        {
            Sequencepanel1.setVisible(false);
            Content.remove(Sequencepanel1);
        }
		
	}
	public void clearmultiPlot()
	{	
		if(drawing1 != null)
        {
            drawing1.setVisible(false);
            Content.remove(drawing1);            
        }
        if(drawing2 != null)
        {
            drawing2.setVisible(false);
            Content.remove(drawing2);            
        }
        
        if(Settingspanel2 != null)
        {
            Settingspanel2.setVisible(false);
            Content.remove(Settingspanel2);
        }
        
        if(Sequencepanel2 != null)
        {
            Sequencepanel2.setVisible(false);
            Content.remove(Sequencepanel2);
        }
       
        if(Settingspanel1 != null)
        {
            Settingspanel1.setVisible(false);
            Content.remove(Settingspanel1);
        }
        
        if(Sequencepanel1 != null)
        {
            Sequencepanel1.setVisible(false);
            Content.remove(Sequencepanel1);
        }
		
	}

}

