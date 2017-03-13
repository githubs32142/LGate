package apk.Class;
/**
 *
 * @author Andrzej Kierepka
 */
public class JoinObject {
    private String typrOfObject;
    private int indexObject;

    public JoinObject(String typrOfObject, int indexObject) {
        this.typrOfObject = typrOfObject;
        this.indexObject = indexObject;
    }

    public int getIndexObject() {
        return indexObject;
    }

    public String getTyprOfObject() {
        return typrOfObject;
    }

    public void setIndexObject(int indexObject) {
        this.indexObject = indexObject;
    }

    public void setTyprOfObject(String typrOfObject) {
        this.typrOfObject = typrOfObject;
    }

    
}
