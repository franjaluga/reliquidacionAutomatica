import java.util.Arrays;

public class BaseYear {

    int[][] base;

    public BaseYear() {
        this.base = new int[10][2];
    }

    public void setBase(int[][] base) {
        this.base = base;
    }

    public void setBySlot(int indexOne, int indexTwo, int value){
        this.base[indexOne][indexTwo] = value;
    }

    public int getBySlot(int indexOne, int indexTwo){
        return this.base[indexOne][indexTwo];
    }
}
