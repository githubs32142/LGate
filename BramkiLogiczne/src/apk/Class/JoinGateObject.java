/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package apk.Class;
/**
 *
 * @author Andrzej Kierepka
 */
public class JoinGateObject extends JoinObject{
    private int index;// indeks oznacza miejsce przyłączenia do bramki logicznej jak jest 
    private int indexLine;
    public JoinGateObject(int index,int indexLine, String typeOfObject, int indexObject) {
        super(typeOfObject, indexObject);
        this.index = index;
        this.indexLine=indexLine;
        
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public void setIndexLine(int indexLine) {
        this.indexLine = indexLine;
    }

    public int getIndexLine() {
        return indexLine;
    }
    
    
}
