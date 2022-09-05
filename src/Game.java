import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Game {

    Scanner sc = new Scanner(System.in);
    private final List<Player> players;
    private int currentPlayer;

    public Game(String[] playerNames) {
        this.players = new ArrayList<>(playerNames.length);
        for (String name : playerNames) {
            players.add(new Player(name));
        }
        this.currentPlayer = 0;
    }

    public String printNums(Player player) {
        StringBuilder numString = new StringBuilder();
        for (Dice d : players.get(currentPlayer).getDices()) {
            numString.append(d.getValue());
            if (d.isLocked()) {
                numString.append("*");
            }
            numString.append(" ");
        }
        return numString.toString();
    }

    public boolean endOfTurn() {
        for (Dice d : players.get(currentPlayer).getDices()) {
            if (d.isLocked()) {
                return true;
            }
        }
        return false;
    }

    public void startGame() {
        System.out.printf("Hello %s! Here is your roll:\n%s", players.get(currentPlayer).getName(),
                printNums(players.get(currentPlayer)));
    }

}
