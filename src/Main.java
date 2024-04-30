import com.dyma.exceptions.TicTacToeInvalidException;
import com.dyma.game.Player;
import com.dyma.game.TicTacToe;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        var scanner = new Scanner(System.in);
        var game = new TicTacToe();

        var player = Player.FIRST;

        while (true) {
            try{
                System.out.println(game);
                System.out.println(player + " / Saisissez un nombre entre 1 et 9 : ");
                final var inputUser = getInputUser();

                game.processInput(player, inputUser);
                if (game.checkWin()) {
                    System.out.println("Le joueur " + player + " a gagné la partie");
                    break;
                }
                if (game.checkDraw()) {
                    System.out.println("Personne n'a gagné la partie");
                    System.out.println(game);
                    break;
                }
                player = nextPlayer(player);
            } catch (TicTacToeInvalidException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private static int getInputUser() throws TicTacToeInvalidException {
        final var scanner = new Scanner(System.in);
        var input = scanner.nextInt();
        if (input < 1 || input > 9) {
            throw new TicTacToeInvalidException("Le chiffre doit être entre 1 et 9");
        }
        return scanner.nextInt();
    }

    private static Player nextPlayer(Player player){
        if (player == Player.FIRST) {
            return Player.SECOND;
        }else{
            return Player.FIRST;
        }
    }
}