public class GridVector {
    public int x,y;

    public GridVector(int x, int y)
    {
        this.x = x;
        this.y = y;
    }

    public GridVector multiply(int number)
    {
        x *= number;
        y *= number;
        return this;
    }
    public GridVector add(int number)
    {
        x += number;
        y += number;
        return this;
    }
}
