package entities.creatures;

import control.Keyboard;
import graphics.Screen;
import graphics.Sprite;
import map.Map;

public class Player extends Creature{

    private Keyboard keyboard;
    private int animation;

    public Player(Map map, Keyboard keyboard, Sprite sprite) {
        this.map = map;
        this.keyboard = keyboard;
        this.sprite = sprite;
    }

    public Player(Map map, Keyboard keyboard, Sprite sprite, int postionX, int positionY) {
        this(map, keyboard, sprite);
        this.x = postionX;
        this.y = positionY;
    }

    public void update() {

        int moveX = 0;
        int moveY = 0;
        int moveSpeed = 1;
        int remainder = animation % 40;

        if (animation < 32767) animation++;
        else animation = 0;

        if(keyboard.run) moveSpeed = 4;
        if (keyboard.up) moveY -= moveSpeed;
        if (keyboard.down) moveY += moveSpeed;
        if (keyboard.left) moveX -= moveSpeed;
        if (keyboard.right) moveX += moveSpeed;
        if (moveX != 0 || moveY != 0) {
            move(moveX, moveY);
            isMoving = true;
        } else {
            isMoving = false;
        }
        if (direction == 'n') {
            sprite = Sprite.RAMBO_UP_1;
            if (isMoving) {
                if (animation % 30 > 15) sprite = Sprite.RAMBO_UP_2;
                else sprite = Sprite.RAMBO_UP_3;
            }
        }
        if (direction == 's') {
            sprite = Sprite.RAMBO_DOWN_1;
            if (isMoving) {
                if (animation % 30 > 15) sprite = Sprite.RAMBO_DOWN_2;
                else sprite = Sprite.RAMBO_DOWN_3;
            }
        }
        if (direction == 'e') {
            sprite = Sprite.RAMBO_RIGHT_1;
            if (isMoving) {
                if (remainder > 10 && remainder <= 20) sprite = Sprite.RAMBO_RIGHT_2;
                else if (remainder > 20 && remainder <= 30) sprite = Sprite.RAMBO_RIGHT_1;
                else sprite = Sprite.RAMBO_RIGHT_3;
            }
        }
        if (direction == 'w') {
            sprite = Sprite.RAMBO_LEFT_1;
            if (isMoving) {
                if (remainder > 10 && remainder <= 20) sprite = Sprite.RAMBO_LEFT_2;
                else if (remainder > 20 && remainder <= 30) sprite = Sprite.RAMBO_LEFT_1;
                else sprite = Sprite.RAMBO_LEFT_3;
            }
        }
    }
    public void draw(Screen screen){
        screen.drawPlayer(x, y, this);
    }
}
