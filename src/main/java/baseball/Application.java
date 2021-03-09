package baseball;

import java.util.Scanner;

import baseball.controller.game.Game;


public class Application {
    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        Game game = new Game(scanner);
        game.start();
    }
}
