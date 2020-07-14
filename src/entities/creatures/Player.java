package entities.creatures;

import control.Keyboard;
import graphics.Screen;
import graphics.Sprite;

public class Player extends Creature{

    private Keyboard keyboard;
    private int animation;

    public Player(Keyboard keyboard, Sprite sprite) {
        this.keyboard = keyboard;
        this.sprite = sprite;
    }

    public Player(Keyboard keyboard, Sprite sprite, int postionX, int positionY) {
        this.keyboard = keyboard;
        this.sprite = sprite;
        this.x = postionX;
        this.y = positionY;
    }

    public void update(){

        int moveX = 0;
        int moveY = 0;

        if(animation < 32767) animation++;
        else animation = 0;

        if(keyboard.up) moveY--;
        if(keyboard.down) moveY++;
        if(keyboard.left) moveX--;
        if(keyboard.right) moveX++;
        if(moveX != 0 || moveY != 0) {
            move(moveX, moveY);
            isMoving = true;
        }else{
            isMoving = false;
        }
        if(direction=='n'){
            sprite = Sprite.RAMBO_UP_1;
            if(isMoving){
                if(animation % 30 > 15) sprite = Sprite.RAMBO_UP_2;
                else sprite = Sprite.RAMBO_UP_3;
            }
        }
        if(direction=='s') {
            sprite = Sprite.RAMBO_DOWN_1;
            if(isMoving){
                if(animation % 30 > 15) sprite = Sprite.RAMBO_DOWN_2;
                else sprite = Sprite.RAMBO_DOWN_3;
            }
        }
        if(direction=='e'){
            sprite = Sprite.RAMBO_RIGHT_1;
            if(isMoving){
                if(animation % 30 > 15) sprite = Sprite.RAMBO_RIGHT_2;
                else sprite = Sprite.RAMBO_RIGHT_3;
            }
        }
        if(direction=='w'){
            sprite = Sprite.RAMBO_LEFT_1;
            if(isMoving){
                if(animation % 30 > 15) sprite = Sprite.RAMBO_LEFT_2;
                else sprite = Sprite.RAMBO_LEFT_3;
            }
        }
    }

    public void draw(Screen screen){
        screen.drawPlayer(x, y, this);
    }
}
