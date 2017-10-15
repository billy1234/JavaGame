import java.security.PublicKey;

public class GridVector {
    public int x,y;


    @Override
    public String toString()
    {
        return new String("screenX: " + x +" , "+"screenY: " + y +" , ");
    }

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

    public GridVector add(GridVector v)
    {
        x += v.x;
        y += v.y;
        return this;
    }

    public GridVector multiply(GridVector v)
    {
        x *= v.x;
        y *= v.y;
        return this;
    }

    public GridVector zero()
    {
        x = 0;
        y = 0;
        return this;
    }

    public GridVector constrain(int lowerX, int lowerY, int upperX, int upperY)
    {
        if(x < lowerX)
        {
            x = lowerX;
        }
        else if(x >= upperX)
        {
            x = upperX -1;
        }

        if(y < lowerY)
        {
            y = lowerY;
        }
        else if(y >= upperY)
        {
            y = upperY -1;
        }

        return this;
    }

    public boolean isZero()
    {
        return (x == 0 && y == 0);
    }
}
