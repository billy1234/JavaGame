import java.awt.*;

public class Texture {


    Image image;
    int xSize, ySize;

    final Color bg = Color.white;

    public Texture( int size,Image image)
    {
        this.image = image;
        this.xSize = size;
        this.ySize = size;
    }

    public void draw(Graphics g,int x,int y) {
        g.drawImage(image,x,y,xSize,ySize,bg,null);
    }

}
