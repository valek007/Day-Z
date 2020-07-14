package entities.creatures;

import control.Keyboard;

public class Player extends Creature{

    private Keyboard keyboard;

    public Player(Keyboard keyboard) {
        this.keyboard = keyboard;
    }

    public Player(Keyboard keyboard, int postionX, int positionY) {
        this.keyboard = keyboard;
        this.x = postionX;
        this.y = positionY;
    }

    public void update(){

        int moveX = 0;
        int moveY = 0;

        if(keyboard.up) moveY--;
        if(keyboard.down) moveY++;
        if(keyboard.left) moveX--;
        if(keyboard.right) moveX++;
        if(moveX != 0 || moveY != 0) move(moveX,moveY);
    }

    public void draw(){

    }
}
