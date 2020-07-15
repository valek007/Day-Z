package entities.creatures;

import entities.Entitie;
import graphics.Sprite;

public abstract class Creature extends Entitie {

    protected Sprite sprite;
    protected char direction = 'N';
    protected boolean isMoving = false;

    private boolean inCollision(int moveX, int moveY){

        boolean collission = false;

        int positionX = x + moveX;
        int positionY = y + moveY;

        int marginLeft = -6;
        int marginRight = 18;
        int marginHigher = -4;
        int marginLower = 31;

        int leftBorder = (positionX - marginLeft + 4) / sprite.getSide();
        int rightBorder = (positionX + marginRight + 5) / sprite.getSide();
        int higherBorder = (positionY + marginLower) / sprite.getSide();
        int lowerBorder = (positionY + marginLower + marginHigher) / sprite.getSide();

        if(map.getCatalogTile(leftBorder + higherBorder * map.getWidth()).isSolid()) collission = true;
        if(map.getCatalogTile(leftBorder + lowerBorder * map.getWidth()).isSolid()) collission = true;
        if(map.getCatalogTile(rightBorder + higherBorder * map.getWidth()).isSolid()) collission = true;
        if(map.getCatalogTile(rightBorder + lowerBorder * map.getWidth()).isSolid()) collission = true;

        return collission;
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
            if(!inCollision(moveX, 0)) setX(moveX);
            if(!inCollision(0,moveY)) setY(moveY);
        }
    }

    public Sprite getSprite(){
        return sprite;
    }
}
