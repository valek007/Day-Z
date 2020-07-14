package entities;

import map.Map;

public abstract class Entitie {

    protected int x;
    protected int y;
    private boolean isRemoved = false;
    protected Map map;

    public int getX() {
        return x;
    }

    public void setX(int moveX) {
        this.x += moveX;
    }

    public int getY() {
        return y;
    }

    public void setY(int moveY) {
        this.y += moveY;
    }

    public void remove(){
        isRemoved = true;
    }

    public boolean isRemoved() {
        return isRemoved;
    }

    public void update(){

    }

    public void draw(){

    }
}
