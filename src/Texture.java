import java.awt.*;

public class Texture implements Drawable {


    Image image;
    int x,y, xSize, ySize;

    final Color bg = Color.white;

    public Texture( int x, int y, int size,Image image)
    {
        this.image = image;
        this.x = x;
        this.y = y;
        this.xSize = size;
        this.ySize = size;
    }

    @Override
    public void draw(Graphics g) {
        g.drawImage(image,x,y,xSize,ySize,bg,null);
    }

}
