package apk.Class;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;
public class LogicGate extends Rectangle2D.Double{
    private String label;
    private int index;
    Rectangle2D.Double input1,input2,output2;
    Ellipse2D.Double output;
    public LogicGate(){
        super();
    }
    public LogicGate(String label, int index) {
        super();
        this.label = label;
        this.index = index;
    }
    public LogicGate(String label, int index, double arg0, double arg1, double arg2, double arg3) {
        super(arg0, arg1, arg2, arg3);
        this.label = label;
        this.index = index;
        setObramowanie();
    }
    public void setX(double x) {
        this.x = x;
    }
    public void setY(double y) {
        this.y = y;
    }
    public void setXY(double x,double y) {
        this.x = x;
        this.y = y;
    }
    public int getIndex() {
        return index;
    }

    public String getLabel() {
        return label;
    }
    public void drawGate(Graphics2D g2){
     RenderingHints rh = new RenderingHints( RenderingHints.KEY_ANTIALIASING,RenderingHints.VALUE_ANTIALIAS_ON);
     rh.put(RenderingHints.KEY_RENDERING,RenderingHints.VALUE_RENDER_QUALITY); 
     g2.setRenderingHints(rh);
     // g2.setColor(new java.awt.Color(0, 127, 255));
     g2.setColor(Color.BLACK);
     g2.setStroke(new BasicStroke(2.2f, BasicStroke.CAP_ROUND,BasicStroke.JOIN_MITER));
    // g2.drawRect((int)this.x-5, (int)this.y-5, (int)this.width+10, (int)this.height+10);
     if(label.equals("NOT")){
         g2.draw(output);
         g2.fill(input1);
     }
     if(label.equals("AND")){
         g2.fill(output2);
         g2.fill(input1);
         g2.fill(input2);
     }
     if(label.equals("NAND")){
         g2.draw(output);
         g2.fill(input1);
         g2.fill(input2);
     }
     if(label.equals("OR")){
         g2.fill(output2);
         g2.fill(input1);
         g2.fill(input2);
     }
    if(label.equals("XOR")){
         g2.fill(output2);
         g2.fill(input1);
         g2.fill(input2);
     }
        if(label.equals("NOR")){
         g2.draw(output);
         g2.fill(input1);
         g2.fill(input2);
     }
        if(label.equals("NXOR")){
         g2.draw(output);
         g2.fill(input1);
         g2.fill(input2);
     }
    }
    private void setObramowanie(){
        if(label.equals("NOT")){
            input1= new Rectangle2D.Double(x-7,y+(height/2)-2,8,4);
            output= new Ellipse2D.Double(x+width-10,y+(height/2)-5,8,8);
        }
        if(label.equals("AND")){
            input1= new Rectangle2D.Double(x-7,y+10,8,4);
            input2= new Rectangle2D.Double(x-7,y+30,8,4);
            output2= new Rectangle2D.Double(x+width-10,y+(height/2)-6,8,4);
        }
        if(label.equals("NAND")){
            input1= new Rectangle2D.Double(x-7,y+10,8,4);
            input2= new Rectangle2D.Double(x-7,y+30,8,4);
            output= new Ellipse2D.Double(x+width-5,y+(height/2)-6,8,8);
        }
        if(label.equals("OR")){
            input1= new Rectangle2D.Double(x-2,y+9,11,4);
            input2= new Rectangle2D.Double(x-2,y+29,11,4);
            output2= new Rectangle2D.Double(x+width-2,y+(height/2)-2,8,4);
        }
        if(label.equals("NOR")){
            input1= new Rectangle2D.Double(x-2,y+9,11,4);
            input2= new Rectangle2D.Double(x-2,y+29,11,4);
            output= new Ellipse2D.Double(x+width-5,y+(height/2)-5,8,8);
        }
        if(label.equals("XOR")){
            input1= new Rectangle2D.Double(x+2,y+13,13,4);
            input2= new Rectangle2D.Double(x+2,y+33,13,4);
            output2= new Rectangle2D.Double(x+width-5,y+(height/2)-2,8,4);
        }
        if(label.equals("NXOR")){
            input1= new Rectangle2D.Double(x+2,y+13,13,4);
            input2= new Rectangle2D.Double(x+2,y+33,13,4);
            output= new Ellipse2D.Double(x+width,y+(height/2),8,8);
        }

    }
    @Override
    public boolean contains(double d, double d1) {
        return super.contains(d, d1); 
    }
    public boolean containsInput(double d, double d1) {
        if(label.equals("NOT")){
            if(input1.contains(d, d1)){
                return true;
            }
        }
        if(label.equals("AND")){
            if(input1.contains(d, d1) || input2.contains(d, d1)){
                return true;
            }
        }
        if(label.equals("OR")){
            if(input1.contains(d, d1) || input2.contains(d, d1)){
                return true;
            }
        }
         if(label.equals("XOR")){
            if(input1.contains(d, d1) || input2.contains(d, d1)){
                return true;
            }
        }
    return false;
    }
    public boolean containsOutput(double d, double d1) {
        if(label.equals("NOT")){
            if(output.contains(d, d1)){
                return true;
            }
        }
    return false;
    }
    
  
}
