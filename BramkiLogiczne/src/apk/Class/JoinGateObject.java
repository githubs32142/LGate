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
    private int indexOfPosition;// indeks oznacza miejsce przyłączenia do bramki logicznej jak jest 
    private int indexLine;
    public JoinGateObject(int indexOfPosition,int indexLine, String typeOfObject, int indexObject) {
        super(typeOfObject, indexObject);
        this.indexOfPosition = indexOfPosition;
        this.indexLine=indexLine;
        
    }

    public int getIndexOfPosition() {
        return indexOfPosition;
    }

    public void setIndexOfPosition(int index) {
        this.indexOfPosition = index;
    }

    public void setIndexLine(int indexLine) {
        this.indexLine = indexLine;
    }

    public int getIndexLine() {
        return indexLine;
    }
    
    
}
