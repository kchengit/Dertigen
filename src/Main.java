import java.util.Scanner;

public class Main {

    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("Welcome! With how many players are you?");
        String[] playerNames = new String[sc.nextInt()];
        for (int i = 0; i < playerNames.length; i++) {
            System.out.printf("What is the name of player %d?\n", i+1);
            String name = sc.next();
            playerNames[i] = name;
        }
        Game game = new Game(playerNames);
        game.startGame();
    }

}
