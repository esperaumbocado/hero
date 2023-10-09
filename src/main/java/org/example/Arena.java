package org.example;

import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.input.KeyType;
import com.googlecode.lanterna.screen.Screen;

public class Arena {
    private int width, height;
    private Hero hero;

    public Arena(int width,int height, Hero hero){
        this.height=height;
        this.width=width;
        this.hero=hero;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }


    public void processKey(KeyStroke key) {
        if (key.getKeyType()== KeyType.ArrowUp){
            hero.moveUp();
        }
        if (key.getKeyType()== KeyType.ArrowDown){
            hero.moveDown();
        }
        if (key.getKeyType()== KeyType.ArrowRight){
            hero.moveRight();
        }
        if (key.getKeyType()== KeyType.ArrowLeft){
            hero.moveLeft();
        }
    }

    public void draw(Screen screen) {
        hero.draw(screen);
    }
}
