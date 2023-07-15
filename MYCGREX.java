// FrontEnd Plus GUI for JAD
// DeCompiled : MYCGREX.class
//package CGRexpack;
import java.io.Serializable;

class MYCGREX
    implements Serializable
{
	public static final long serialVersionUID = 0;
    String SqStr;
    public String SqType;
    public int NCrnrs;
    public int splevel;
    public int zmlevel;
    double zxp[][];
    double zyp[][];
    public String DistrName;
    public String Distr[];
    int color[][];

    MYCGREX(CGRDrawing drawing)
    {
        SqStr = null;
        SqType = null;
        NCrnrs = 0;
        SqStr = drawing.getSeqStr();
        SqType = drawing.getSeqType();
        NCrnrs = drawing.getCorners();
        DistrName = drawing.getDistrName();
        Distr = drawing.getDistribution();
        splevel = drawing.getSplit();
        zmlevel = drawing.getZoomLevel();
        zxp = drawing.getzxp();
        zyp = drawing.getzyp();
        color = drawing.getTestSeqColor();
    }
}
