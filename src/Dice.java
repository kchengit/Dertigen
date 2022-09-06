import java.util.Random;

public class Dice {

    private int value;
    private boolean isLocked;
    Random r = new Random();

    public Dice() {
        this.value = r.nextInt(6) + 1;
        this.isLocked = false;
    }

    public void roll() {
        this.value = r.nextInt(6) + 1;
    }

    public void lock() {
        isLocked = true;
    }

    public void unlock() {
        isLocked = false;
    }

    public int getValue() {
        return value;
    }

    public boolean isLocked() {
        return isLocked;
    }

}
