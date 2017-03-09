
package apk.Class;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.geom.Ellipse2D;

public class LogicPoint extends Ellipse2D.Double{
    private boolean state;
    private String label;
    private int index;

    public LogicPoint(boolean state, String label, int index, double arg0, double arg1) {
        super(arg0, arg1, 25, 25);
        this.state = state;
        this.label = label;
        this.index = index;
    }
    
    public void drawGate(Graphics2D g2){
     RenderingHints rh = new RenderingHints( RenderingHints.KEY_ANTIALIASING,RenderingHints.VALUE_ANTIALIAS_ON);
     rh.put(RenderingHints.KEY_RENDERING,RenderingHints.VALUE_RENDER_QUALITY); 
     g2.setRenderingHints(rh);
     // g2.setColor(new java.awt.Color(0, 127, 255));
     g2.setColor(Color.BLACK);
     g2.setStroke(new BasicStroke(2.2f, BasicStroke.CAP_ROUND,BasicStroke.JOIN_MITER));
     if(state){
         g2.drawLine((int)x,(int) (y+(width/2)),(int)(x+width),(int) (y+(width/2)));
     }
     g2.draw(this);
    }
    public void setXY(double x,double y) {
        this.x = x;
        this.y = y;
    }
    
    public void setIndex(int index) {
        this.index = index;
    }

    public int getIndex() {
        return index;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }
    
    public boolean getState() {
        return state;
    }
    
    public void setState(boolean state) {
        this.state=state;
    }
}
