package entities.creatures;

import entities.Entitie;
import graphics.Sprite;

public abstract class Creature extends Entitie {

    protected Sprite sprite;
    protected char direction = 'N';
    protected boolean isMoving = false;

    private boolean inCollision(){
        return false;
    }

    public void update(){

    }

    public void draw(){

    }

    public void move(int moveX,int moveY){
        if(moveX > 0) direction = 'e';
        if(moveX < 0) direction = 'w';
        if(moveY > 0) direction = 's';
        if(moveY < 0) direction = 'n';
        if(!isRemoved()) {
            setX(moveX);
            setY(moveY);
        }
    }

    public Sprite getSprite(){
        return sprite;
    }
}
