package dk.fb.test.tictactoe;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.w3c.dom.ls.LSOutput;

import java.util.Random;
import java.util.Scanner;

@SpringBootApplication
public class TicTacToeApplication {

    public static void main(String[] args) {
        SpringApplication.run(TicTacToeApplication.class, args);

        Game game = new Game();
        game.PlayGame();

        Boolean shouldTerminate = false;

        while (!shouldTerminate)
        {
            Scanner sc = new Scanner(System.in);

            System.out.println("Do you want to play again? true/false");
            if (!sc.nextBoolean())
            {
                shouldTerminate = true;
            }
            else
            {
                game.PlayGame();
            }
        }


    }


}
