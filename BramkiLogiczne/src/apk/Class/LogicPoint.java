
package apk.Class;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.geom.Ellipse2D;
import java.util.ArrayList;
import java.util.List;
/**
 * 
 * @author Andrzej Kierepka
 * @version 1.7
 * 
 */
public class LogicPoint extends Ellipse2D.Double{
    private boolean state;
    private String label;
    private int index;
    public List<JoinGateObject> inObject = new ArrayList<>();
    public List<JoinGateObject> outObject = new ArrayList<>();
    /**
     ** Konstruktor obiektu  
     * @param state stan logiczny obiektu
     * @param label oznaczenie obiektu, standardowo POINT
     * @param index identyfikator obiektu
     * @param arg0 współrzędna x
     * @param arg1 współrzędna y
     */
    public LogicPoint(boolean state, String label, int index, double arg0, double arg1) {
        super(arg0, arg1, 25, 25);
        this.state = state;
        this.label = label;
        this.index = index;
    }
    /**
     *Metoda która odpowiada za rysowanie punktu 
     * @param g2 parametr dzięki któremy będziemy mogli rysować
     */
    public void drawPoint(Graphics2D g2){
     RenderingHints rh = new RenderingHints( RenderingHints.KEY_ANTIALIASING,RenderingHints.VALUE_ANTIALIAS_ON);
     rh.put(RenderingHints.KEY_RENDERING,RenderingHints.VALUE_RENDER_QUALITY); 
     g2.setRenderingHints(rh);
     g2.setStroke(new BasicStroke(2.2f, BasicStroke.CAP_ROUND,BasicStroke.JOIN_MITER));
     if(state){
         g2.drawLine((int)x,(int) (y+(width/2)),(int)(x+width),(int) (y+(width/2)));
     }
     else{
          g2.drawLine((int)x,(int) (y+(width/2)),(int)(x+5),(int) (y+(width/2)));
          g2.drawLine((int)x+10,(int) (y),(int)(x+15),(int) (y+(width/2)));
          g2.drawLine((int)(x+15),(int) (y+(width/2)), (int)(x+width), (int)(y+(width/2)) );
     }
     g2.draw(this);
    }
    /**
     ** Metoda ustawia współrzęnde x i y. 
     * @param x współrzędna x
     * @param y współrzędna y.
     */
    public void setXY(double x,double y) {
        this.x = x;
        this.y = y;
    }
    /**
     ** Metoda która pozwala na ustawienie identyfikatora 
     * @param index id na który chcemy zmienić nasz obiekt
     */
    public void setIndex(int index) {
        this.index = index;
    }
    /**
     ** Metoda która zwraca identyfikator obiektu 
     * @return identyfikator obiektu
     */
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
        /**
     * 
     **  Metoda dodaje obiekt do bramki 
     * @param indexOfObject index Obiektu z którym będziemy się łączyć
     * @param indexOfPosition indeks pozycji na wejściu(dotyczy jedynie wejść bramek logicznych)
     * @param indexLine index lini która łączy dwa obiekrty
     * @param typeOfObject typ obiektu z którym będziemy połączeni
     * @param typeOfJoin typ połączenia INPUT- wchodzi OUTPUT- wychodzi
     */
    public void addObject(int indexOfObject, int indexOfPosition,int indexLine,String typeOfObject,String typeOfJoin){
        if(typeOfJoin.equals("INPUT")){// jeżeli wchodzi do bramki logicznej
            inObject.add(new JoinGateObject(indexOfPosition,indexLine, typeOfObject, indexOfObject));
        }
        if(typeOfJoin.equals("OUTPUT")){// jeżeli wychodzi od bramki logicznej
            outObject.add(new JoinGateObject(indexOfPosition,indexLine, typeOfObject, indexOfObject));
        }
    }
}
