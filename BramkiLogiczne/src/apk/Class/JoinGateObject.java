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
    private int index;

    public JoinGateObject(int index, String typeOfObject, int indexObject) {
        super(typeOfObject, indexObject);
        this.index = index;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }
    
}
