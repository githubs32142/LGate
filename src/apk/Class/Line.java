
package apk.Class;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.geom.Line2D;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Line  implements Serializable {
    List<Line2D.Double> lines = new ArrayList<>(4);
    public double x1,y1,x2,y2;
    private String label;
    private int index;
    public Line(String label, int index,double x1, double y1, double x2, double y2) {
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;
        this.label = label;
        this.index = index;
        makeLines();
    }

    public String getLabel() {
        return label;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public void setLabel(String label) {
        this.label = label;
    }
    
    public void setXY1(double x1,double y1) {
        this.x1 = x1;
        this.y1 = y1;
        makeLines();
    }
    
    public void setXY2(double x2,double y2) {
        this.x2 = x2;
        this.y2 = y2;
        makeLines();
    }
    private void makeLines(){
            lines.clear();
            lines.add(new Line2D.Double(x1, y1, x2-(Math.abs(x1-x2)/2) , y1));
            lines.add(new Line2D.Double(x2-(Math.abs(x1-x2)/2), y1, x2-(Math.abs(x1-x2)/2), y2));
            lines.add(new Line2D.Double(x2-(Math.abs(x1-x2)/2), y2, x2, y2));
    }
     public void drawLine(Graphics2D g2){
     RenderingHints rh = new RenderingHints( RenderingHints.KEY_ANTIALIASING,RenderingHints.VALUE_ANTIALIAS_ON);
     rh.put(RenderingHints.KEY_RENDERING,RenderingHints.VALUE_RENDER_QUALITY); 
     g2.setRenderingHints(rh);
     // g2.setColor(new java.awt.Color(0, 127, 255));
     g2.setColor(Color.BLACK);
     g2.setStroke(new BasicStroke(2.2f, BasicStroke.CAP_ROUND,BasicStroke.JOIN_MITER));
     for(int i=0;i<lines.size();i++){
         g2.draw(lines.get(i));
     }
    }
     public boolean contains(int x, int y){
         for(int i=0;i<lines.size();i++){
             if(lines.get(i).intersects(x, y, 3, 3)){
                 return true;
             }
         }
         return false;
     }
    
}
