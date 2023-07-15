// FrontEnd Plus GUI for JAD
// DeCompiled : Dhoom.class
//package CGRexpack;
import java.awt.*;
import java.awt.image.BufferedImage;

class Dhoom
{

    int width;
    int height;
    CGRDrawing jpanel1;
    float xp[];
    float yp[];
    final int ZOOM_MAX = 100;
    double sxp[];
    double syp[];
    double zxp[][];
    double zyp[][];
    boolean mouse;
    boolean zoom;
    int zoomLevel;
    Point drag;
    Point drop;
    int x[];
    int y[];

    public Dhoom(CGRDrawing drawing, Point point, Point point1, int i)
    {
        width = 512;
        height = 512;
        zxp = new double[100][];
        zyp = new double[100][];
        mouse = false;
        zoom = true;
        zoomLevel = 0;
        x = new int[4];
        y = new int[4];
        xp = drawing.getxp();
        yp = drawing.getyp();
        jpanel1 = drawing;
        drag = point;
        drop = point1;
        zoomLevel = i;
        x[0] = 0;
        y[0] = 0;
        x[1] = 510;
        y[1] = 0;
        x[2] = 510;
        y[2] = 510;
        x[3] = 0;
        y[3] = 510;
    }

    public Dhoom(Dhoom dhoom, int i, Point point, Point point1, boolean flag)
    {
        width = 512;
        height = 512;
        zxp = new double[100][];
        zyp = new double[100][];
        mouse = false;
        zoom = true;
        zoomLevel = 0;
        x = new int[4];
        y = new int[4];
        xp = dhoom.xp;
        yp = dhoom.yp;
        drag = point;
        drop = point1;
        zoomLevel = i;
        zxp = dhoom.zxp;
        zyp = dhoom.zyp;
        zoom = flag;
        x = dhoom.x;
        y = dhoom.y;
    }

    public void mapToZoom(double d, double d1, double d2, double d3)
    {
        if(zoomLevel >= 0)
        {
            zxp[zoomLevel] = new double[sxp.length];
            zyp[zoomLevel] = new double[syp.length];
            for(int i = 0; i < sxp.length; i++)
            {
                zxp[zoomLevel][i] = ((sxp[i] - d) / d2) * 512D;
                zyp[zoomLevel][i] = ((syp[i] - d1) / d3) * 512D;
            }

        }
    }

    public boolean isSelected(double d, double d1)
    {
        return d >= Math.min(drag.getX(), drop.getX()) && d < Math.max(drag.getX(), drop.getX()) && d1 >= Math.min(drag.getY(), drop.getY()) && d1 < Math.max(drag.getY(), drop.getY());
    }

    void plotSelectedPoints(Graphics2D graphics2d)
    {
        graphics2d.setColor(Color.BLACK);
        graphics2d.drawPolygon(new Polygon(x, y, 4));
        graphics2d.setColor(Color.RED);
        for(int i = 0; i < zxp[zoomLevel].length; i++)
            graphics2d.fillOval((int)zxp[zoomLevel][i], (int)zyp[zoomLevel][i], zoomLevel + 5, zoomLevel + 5);

    }

    void setSelectedPoints()
    {
        if(zoomLevel == 0)
        {
            for(int i = 0; i < zxp.length; i++)
            {
                zxp[i] = null;
                zyp[i] = null;
            }

            int j = 0;
            int l = 0;
            int j1 = 0;
            for(; l < xp.length; l++)
                if(isSelected(xp[l], yp[l]))
                    j++;

            sxp = new double[j];
            syp = new double[j];
            l = 0;
            j1 = 0;
            for(; l < xp.length; l++)
                if(isSelected(xp[l], yp[l]))
                {
                    sxp[j1] = xp[l];
                    syp[j1] = yp[l];
                    j1++;
                }

        } else
        if(zoomLevel > 0)
        {
            int k = 0;
            int i1 = 0;
            int k1 = 0;
            for(; i1 < zxp[zoomLevel - 1].length; i1++)
                if(isSelected(zxp[zoomLevel - 1][i1], zyp[zoomLevel - 1][i1]))
                    k++;

            sxp = new double[k];
            syp = new double[k];
            i1 = 0;
            k1 = 0;
            for(; i1 < zxp[zoomLevel - 1].length; i1++)
                if(isSelected(zxp[zoomLevel - 1][i1], zyp[zoomLevel - 1][i1]))
                {
                    sxp[k1] = zxp[zoomLevel - 1][i1];
                    syp[k1] = zyp[zoomLevel - 1][i1];
                    k1++;
                }

        }
    }

    public BufferedImage zoomedIn()
    {
        BufferedImage bufferedimage = new BufferedImage(width, height, 1);
        Graphics2D graphics2d = (Graphics2D)bufferedimage.getGraphics();
        graphics2d.setBackground(Color.WHITE);
        graphics2d.setColor(Color.WHITE);
        graphics2d.fillRect(0, 0, 512, 512);
        if(zoom)
        {
            setSelectedPoints();
            mapToZoom(Math.min(drag.getX(), drop.getX()), Math.min(drag.getY(), drop.getY()), Math.abs(drop.getX() - drag.getX()), Math.abs(drop.getY() - drag.getY()));
            plotSelectedPoints(graphics2d);
        } else
        {
            zxp[zoomLevel] = null;
            zyp[zoomLevel] = null;
            if(zoomLevel > 0)
            {
                graphics2d.setColor(Color.BLACK);
                graphics2d.drawPolygon(new Polygon(x, y, 4));
                graphics2d.setColor(Color.RED);
                for(int i = 0; i < zxp[zoomLevel - 1].length; i++)
                    graphics2d.fillOval((int)zxp[zoomLevel - 1][i], (int)zyp[zoomLevel - 1][i], zoomLevel + 5, zoomLevel + 5);

            }
        }
        return bufferedimage;
    }
}
