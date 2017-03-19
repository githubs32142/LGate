package apk.Class;
/**
 *
 * @author Andrzej Kierepka
 */
public class JoinObject {
    private String typeOfObject;// typ obiektu który jest przyłączony np bramka czy też punkt
    private int indexObject; // indeks obiektu

    public JoinObject(String typrOfObject, int indexObject) {
        this.typeOfObject = typrOfObject;
        this.indexObject = indexObject;
    }

    public int getIndexObject() {
        return indexObject;
    }

    public String getTyprOfObject() {
        return typeOfObject;
    }

    public void setIndexObject(int indexObject) {
        this.indexObject = indexObject;
    }

    public void setTyprOfObject(String typrOfObject) {
        this.typeOfObject = typrOfObject;
    }

    
}
