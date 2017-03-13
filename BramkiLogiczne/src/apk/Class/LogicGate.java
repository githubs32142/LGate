package apk.Class;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;
import java.util.ArrayList;
import java.util.List;
public class LogicGate extends Rectangle2D.Double{
    private String label;
    private int index;
    Rectangle2D.Double output2;
    List<Rectangle2D.Double> in = new ArrayList<>();
    List<JoinGateObject> inObject = new ArrayList<>();
    List<JoinObject> outObject = new ArrayList<>();
    Ellipse2D.Double output;
    private int input;
    
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
        if(!this.label.equals("NOT")){
         this.setInput(2);   
        }
        else{
         this.setInput(1);   
        }
        setBorder();
    }
    public int getInput() {
        return input;
    }
    public void setInput(int input) {
        this.input = input;
        setBorder();
    }
    public void setX(double x) {
        this.x = x;
        setBorder();
    }
    public void setY(double y) {
        this.y = y;
        setBorder();
    }
    public void setXY(double x,double y) {
        this.x = x;
        this.y = y;
        setBorder();
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
     g2.setColor(Color.BLACK);
     g2.setStroke(new BasicStroke(2.2f, BasicStroke.CAP_ROUND,BasicStroke.JOIN_MITER));
     if(label.equals("NOT")){
         for(int i=0;i<in.size();i++){
             g2.fill(in.get(i));
         }
         g2.draw(output);
         g2.drawString(label,(int) this.x+5,(int) (this.y+(height/2)+3.5));
     }
     if(label.equals("AND")){
         g2.fill(output2);
         for(int i=0;i<in.size();i++){
             g2.fill(in.get(i));
         }
         g2.drawString(label,(int) this.x+8,(int) (this.y+(height/2)));
     }
     if(label.equals("NAND")){
         g2.draw(output);
         for(int i=0;i<in.size();i++){
             g2.fill(in.get(i));
         }
         g2.drawString(label,(int) this.x+6,(int) (this.y+(height/2)+2.0));
     }
     if(label.equals("OR")){
         g2.fill(output2);
         for(int i=0;i<in.size();i++){
             g2.fill(in.get(i));
         }
         g2.drawString(label,(int) this.x+17,(int) (this.y+(height/2)+3.5));
     }
    if(label.equals("XOR")){
         g2.fill(output2);
         for(int i=0;i<in.size();i++){
             g2.fill(in.get(i));
         }
         g2.drawString(label,(int) this.x+23,(int) (this.y+(height/2)+4.0));
     }
        if(label.equals("NOR")){
         g2.draw(output);
         for(int i=0;i<in.size();i++){
             g2.fill(in.get(i));
         }
         g2.drawString(label,(int) this.x+15,(int) (this.y+(height/2)+3.5));
     }
        if(label.equals("NXOR")){
         g2.draw(output);
         for(int i=0;i<in.size();i++){
             g2.fill(in.get(i));
         }
         g2.drawString(label,(int) this.x+20,(int) (this.y+(height/2)+8.0));
     }
    }
    private void setBorder(){
        if(label.equals("NOT")){
            if(getInput()==1){
               in.clear();
               in.add(new Rectangle2D.Double(x-7,y+(height/2)-2,8,4));
               output= new Ellipse2D.Double(x+width-10,y+(height/2)-5,8,8);
            }
        } 
        if(label.equals("AND")){
            if(getInput()==2){
               in.clear();
               in.add(new Rectangle2D.Double(x-7,y+10,8,4)); 
               in.add(new Rectangle2D.Double(x-7,y+30,8,4)); 
            }
            if(getInput()==3){
               in.clear();
               in.add(new Rectangle2D.Double(x-7,y+10,8,4)); 
               in.add(new Rectangle2D.Double(x-7,y+20,8,4)); 
               in.add(new Rectangle2D.Double(x-7,y+30,8,4));
            }
            if(getInput()==4){
               in.clear();
               in.add(new Rectangle2D.Double(x-7,y+5,8,4)); 
               in.add(new Rectangle2D.Double(x-7,y+12,8,4)); 
               in.add(new Rectangle2D.Double(x-7,y+22,8,4));
               in.add(new Rectangle2D.Double(x-7,y+32,8,4));
            }
            output2= new Rectangle2D.Double(x+width-10,y+(height/2)-6,8,4);
        }
        
        if(label.equals("NAND")){
            if(getInput()==2){
               in.clear();
               in.add(new Rectangle2D.Double(x-7,y+10,8,4)); 
               in.add(new Rectangle2D.Double(x-7,y+30,8,4)); 
            }
            if(getInput()==3){
               in.clear();
               in.add(new Rectangle2D.Double(x-7,y+10,8,4)); 
               in.add(new Rectangle2D.Double(x-7,y+20,8,4)); 
               in.add(new Rectangle2D.Double(x-7,y+30,8,4));
            }
            if(getInput()==4){
               in.clear();
               in.add(new Rectangle2D.Double(x-7,y+5,8,4)); 
               in.add(new Rectangle2D.Double(x-7,y+12,8,4)); 
               in.add(new Rectangle2D.Double(x-7,y+22,8,4));
               in.add(new Rectangle2D.Double(x-7,y+32,8,4));
            }
            output= new Ellipse2D.Double(x+width-5,y+(height/2)-6,8,8);
        }
        if(label.equals("OR")){
            if(getInput()==2){
               in.clear();
               in.add(new Rectangle2D.Double(x-2,y+9,11,4)); 
               in.add(new Rectangle2D.Double(x-2,y+29,11,4)); 
            }
            if(getInput()==3){
               in.clear();
               in.add(new Rectangle2D.Double(x-2,y+9,11,4)); 
               in.add(new Rectangle2D.Double(x-2,y+19,11,4)); 
               in.add(new Rectangle2D.Double(x-2,y+29,11,4)); 
            }
            if(getInput()==4){
               in.clear();
               in.add(new Rectangle2D.Double(x-2,y+4,8,4)); 
               in.add(new Rectangle2D.Double(x-2,y+12,11,4)); 
               in.add(new Rectangle2D.Double(x-2,y+22,11,4)); 
               in.add(new Rectangle2D.Double(x-2,y+32,8,4)); 
            }
            output2= new Rectangle2D.Double(x+width-2,y+(height/2)-2,8,4);
        }
        if(label.equals("NOR")){
            if(getInput()==2){
               in.clear();
               in.add(new Rectangle2D.Double(x-2,y+9,11,4)); 
               in.add(new Rectangle2D.Double(x-2,y+29,11,4)); 
            }
            if(getInput()==3){
               in.clear();
               in.add(new Rectangle2D.Double(x-2,y+9,11,4)); 
               in.add(new Rectangle2D.Double(x-2,y+19,11,4)); 
               in.add(new Rectangle2D.Double(x-2,y+29,11,4)); 
            }
            if(getInput()==4){
               in.clear();
               in.add(new Rectangle2D.Double(x-2,y+4,8,4)); 
               in.add(new Rectangle2D.Double(x-2,y+12,11,4)); 
               in.add(new Rectangle2D.Double(x-2,y+22,11,4)); 
               in.add(new Rectangle2D.Double(x-2,y+32,8,4)); 
            }
            output= new Ellipse2D.Double(x+width-2,y+(height/2)-5,8,8);
        }
        if(label.equals("XOR")){
            if(getInput()==2){
               in.clear();
               in.add(new Rectangle2D.Double(x+2,y+13,13,4)); 
               in.add(new Rectangle2D.Double(x+2,y+33,13,4)); 
            }
            if(getInput()==3){
               in.clear();
               in.add(new Rectangle2D.Double(x+2,y+13,13,4)); 
               in.add(new Rectangle2D.Double(x+2,y+23,15,4)); 
               in.add(new Rectangle2D.Double(x+2,y+33,13,4)); 
            }
            if(getInput()==4){
               in.clear();
               in.add(new Rectangle2D.Double(x+2,y+10,13,4)); 
               in.add(new Rectangle2D.Double(x+2,y+20,15,4)); 
               in.add(new Rectangle2D.Double(x+2,y+30,13,4)); 
               in.add(new Rectangle2D.Double(x+2,y+38,13,4)); 
            }
            output2= new Rectangle2D.Double(x+width-5,y+(height/2)-2,8,4);
        }
        if(label.equals("NXOR")){
            if(getInput()==2){
               in.clear();
               in.add(new Rectangle2D.Double(x+2,y+13,13,4)); 
               in.add(new Rectangle2D.Double(x+2,y+33,13,4)); 
            }
            if(getInput()==3){
               in.clear();
               in.add(new Rectangle2D.Double(x+2,y+13,13,4)); 
               in.add(new Rectangle2D.Double(x+2,y+23,15,4)); 
               in.add(new Rectangle2D.Double(x+2,y+33,13,4)); 
            }
            if(getInput()==4){
               in.clear();
               in.add(new Rectangle2D.Double(x+2,y+10,13,4)); 
               in.add(new Rectangle2D.Double(x+2,y+20,15,4)); 
               in.add(new Rectangle2D.Double(x+2,y+30,13,4)); 
               in.add(new Rectangle2D.Double(x+2,y+38,13,4)); 
            }
            output= new Ellipse2D.Double(x+width,y+(height/2),8,8);
        }

    }
    
    @Override
    public boolean contains(double d, double d1) {
        return super.contains(d, d1); 
    }
    public boolean containsInput(double d, double d1) {
        for(int i=0;i<in.size();i++){
            if(in.get(i).contains(d, d1)){
                return true;
            }
        }
    return false;
    }
    public boolean containsOutput(double d, double d1) {
        if(label.equals("NOT") || label.equals("NAND") || label.equals("NXOR") || label.equals("NOR")){
            if(output.contains(d, d1)){
                return true;
            }
        }
        if( label.equals("AND") || label.equals("XOR") || label.equals("OR")){
            if(output2.contains(d, d1)){
                return true;
            }
        }
    return false;
    }
    public void drawBorder(Graphics2D g2){
        g2.setColor(new java.awt.Color(0, 127, 255));
        if(label.equals("AND")){
           g2.drawRect((int)this.x-10, (int)this.y-5, (int)this.width+10, (int)this.height); 
        }
        if(label.equals("OR")){
           g2.drawRect((int)this.x-7, (int)this.y-5, (int)this.width+15, (int)this.height+10); 
        }
        if(label.equals("XOR")){
           g2.drawRect((int)this.x, (int)this.y, (int)this.width+5, (int)this.height); 
        }
        if(label.equals("NOR")){
           g2.drawRect((int)this.x-7, (int)this.y-5, (int)this.width+17, (int)this.height+10);
        }
        if(label.equals("NOT")){
           g2.drawRect((int)this.x-10, (int)this.y-2, (int)this.width+10, (int)this.height+4);
        }
        if(label.equals("NAND")){
           g2.drawRect((int)this.x-10, (int)this.y-5, (int)this.width+17, (int)this.height+5); 
        }
        if(label.equals("NXOR")){
           g2.drawRect((int)this.x, (int)this.y, (int)this.width+10, (int)this.height+10);  
        }
    }
    public int returnInput(double x, double y){
        for(int i=0;i<in.size();i++){
            if(in.get(i).contains(x, y)){
                return i;
            }
        }
    return -1;
    }
    public void addObject(int indexPoint,int index,String type,String typeOfJoin){
        if(typeOfJoin.equals("INPUT")){// jeżeli wchodzi do bramki logicznej
            inObject.add(new JoinGateObject(indexPoint, type, index));
        }
    }
      public boolean containInPoint(int index){
      for(int i=0;i<inObject.size();i++){
          if(index==inObject.get(i).getIndex()){
              return true;
          }
      }
      return false;
    }
}
