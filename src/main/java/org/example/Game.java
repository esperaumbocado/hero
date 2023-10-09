package org.example;

import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.input.KeyType;
import com.googlecode.lanterna.screen.Screen;
import com.googlecode.lanterna.screen.TerminalScreen;
import com.googlecode.lanterna.terminal.DefaultTerminalFactory;
import com.googlecode.lanterna.terminal.Terminal;

import java.io.IOException;

import static java.lang.Boolean.TRUE;

public class Game {
    private final Hero hero= new Hero(new Position(10,10));
    private final Arena arena = new Arena(100,50,hero);
    private final Terminal terminal = new DefaultTerminalFactory().createTerminal();
    private final Screen screen = new TerminalScreen(terminal);
    public Game() throws IOException {
        try {
            screen.setCursorPosition(null); // we don't need a cursor
            screen.startScreen(); // screens must be started
            screen.doResizeIfNecessary(); // resize screen if necessary
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void draw() throws IOException {
        screen.clear();
        arena.draw(screen);
        screen.refresh();
    }

    public void run() throws IOException {

        while (TRUE){
            draw();
            KeyStroke key = screen.readInput();
            processKey(key);
            if (key.getKeyType() == KeyType.EOF){
                screen.close();
                break;
            }
        }


    }

    private void processKey(KeyStroke key) throws IOException {
        System.out.println(key);
        arena.processKey(key);
        if (key.getKeyType() == KeyType.Character && key.getCharacter() == 'q'){
            screen.close();
        }

    }

}
