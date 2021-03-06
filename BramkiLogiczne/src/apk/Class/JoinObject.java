package apk.Class;

import java.io.Serializable;

/**
 *
 * @author Andrzej Kierepka
 */
public class JoinObject  implements Serializable  {
    private String typeOfObject;// typ obiektu który jest przyłączony np bramka czy też punkt
    private int indexObject; // indeks obiektu

    public JoinObject(String typrOfObject, int indexObject) {
        this.typeOfObject = typrOfObject;
        this.indexObject = indexObject;
    }

    public int getIndexObject() {
        return indexObject;
    }

    public String getTypeOfObject() {
        return typeOfObject;
    }

    public void setIndexObject(int indexObject) {
        this.indexObject = indexObject;
    }

    public void setTypeOfObject(String typrOfObject) {
        this.typeOfObject = typrOfObject;
    }

    
}
