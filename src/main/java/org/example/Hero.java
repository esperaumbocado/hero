package org.example;

import com.googlecode.lanterna.TextCharacter;
import com.googlecode.lanterna.screen.Screen;


public class Hero {

    private Position position = new Position(10,10);


    public Hero(Position position){
        this.position = position;
    }

    public void draw(Screen screen){
        screen.setCharacter(this.position.getX(), this.position.getY(), TextCharacter.fromCharacter('X')[0]);
    }

    int get_x(){
        return this.position.getX();
    }

    int get_y(){
        return this.position.getY();
    }

    void set_x(int x){
        this.position.setX(x);
    }

    void set_y(int y){
        this.position.setY(y);
    }

    public void moveUp() {
        this.position.setY(this.position.getY() - 1);
    }

    public void moveDown() {
        this.position.setY(this.position.getY() + 1);
    }

    public void moveRight() {
        this.position.setX(this.position.getX() + 1);
    }

    public void moveLeft() {
        this.position.setX(this.position.getX() - 1);
    }

}

    
