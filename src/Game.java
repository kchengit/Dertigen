import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Game {

    Scanner sc = new Scanner(System.in);
    private final List<Player> players;
    private Player currentPlayer;

    public Game(String[] playerNames) {
        this.players = new ArrayList<>(playerNames.length);
        for (String name : playerNames) {
            players.add(new Player(name));
        }
        this.currentPlayer = players.get(0);
    }

    public String printNums() {
        StringBuilder numString = new StringBuilder();
        for (Dice d : currentPlayer.getDices()) {
            numString.append(d.getValue());
            if (d.isLocked()) {
                numString.append("*");
            }
            numString.append(" ");
        }
        numString.append("\n- - - - - -\n1 2 3 4 5 6 <- dice numbers \nWhich dices would you like to keep?");
        return numString.toString();
    }

    public boolean endOfTurn() {
        for (Dice d : currentPlayer.getDices()) {
            if (!d.isLocked()) {
                return false;
            }
        }
        return true;
    }

    public void playGame() {
        while (true) {
            for (Player p : players) {
                currentPlayer = p;
                while (!endOfTurn()) {
                    System.out.printf("Hello %s! Here is your roll:\n", currentPlayer.getName());
                    System.out.println(printNums());
                    currentPlayer.rollDices(sc.nextLine());
                }
                System.out.println("Your total was: " + currentPlayer.getSum());
                handoutSips();
                currentPlayer.resetDices();
            }
        }
    }

    public void handoutSips() {
        Player nextPlayer = players.get((players.indexOf(currentPlayer) + 1) % players.size());
        int sum = currentPlayer.getSum();
        if (sum <= 10) {
            System.out.printf("Congratulations! %s gets 20 sips!\n", nextPlayer.getName());
            nextPlayer.allocateSips(20);
        } else if (sum <= 30) {
            int sips = 30 - sum;
            System.out.printf("Unfortunate, you get %d sips!\n", sips);
            currentPlayer.allocateSips(sips);
        } else {
            int sips = sum - 30;
            System.out.printf("You handout %d sips to %s!\n", sips, nextPlayer.getName());
            nextPlayer.allocateSips(sips);
        }
        for (Player p : players) {
            System.out.printf("%s has %d sips\n", p.getName(), p.getSips());
        }
    }

}
