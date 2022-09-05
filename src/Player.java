public class Player {

    private final String name;
    private final Dice[] dices = new Dice[6];
    private int sips;

    public Player(String name) {
        this.name = name;
        this.sips = 0;
        for (int i = 0; i < this.dices.length; i++) {
            this.dices[i] = new Dice();
        }
    }

    public String getName() {
        return this.name;
    }

    public int[] getDices() {
        int[] diceNums = new int[this.dices.length];
        for (int i = 0; i < this.dices.length; i++) {
            diceNums[i] = dices[i].getValue();
        }
        return diceNums;
    }

    public void rollDices() {
        for (Dice dice : this.dices) {
            if (!dice.isLocked()) {
                dice.roll();
            }
        }
    }

    public void lockDices(String toLock) {
        String[] toLockInput = toLock.split(",");
        int[] nums = new int[toLockInput.length];
        for (int i = 0; i < toLockInput.length; i++) {
            nums[i] = Integer.parseInt(toLockInput[i]);
        }
        for (int n : nums) {
            dices[n].lock();
        }
    }

    public int getSips() {
        return sips;
    }

    public void allocateSips(int amount) {
        this.sips += amount;
    }


}
