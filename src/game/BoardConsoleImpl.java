package game;

import game.interf.BoardConsole;

import java.util.Scanner;

public class BoardConsoleImpl implements BoardConsole {

    private final Scanner reader = new Scanner(System.in);

    @Override
    public String enterPlayerType() {
        while (!reader.hasNextLine()) ;
        return reader.next();
    }

    @Override
    public String enterPlayerName() {
        return reader.next();
    }

    @Override
    public int enterNumberOfPlayers() {
        return reader.nextInt();
    }

    @Override
    public String enterConfirmationNewGame() {
        return reader.next();
    }

}
