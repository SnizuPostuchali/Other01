package positioning;

public class Position implements Cloneable{
    private int x;
    private int y;

    public Position(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void setX(int x) { this.x = x;}

    public void setY(int y) {
        this.y = y;
    }

    public static Position clone(Position position){
        return new Position(position.getX(), position.getY());
    }
}
