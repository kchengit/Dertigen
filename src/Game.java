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

    public String printNums(Player player) {
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

    public void startGame() {
        System.out.printf("Hello %s! Here is your roll:\n%s", players.get(currentPlayer).getName(),
                printNums(players.get(currentPlayer)));
    }

}
