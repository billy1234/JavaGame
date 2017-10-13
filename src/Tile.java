import java.awt.*;
import java.util.Random;


public class Tile extends GameObject implements Drawable,Runnable {

    public int x = 0,y = 0, size =5;

    Texture texture;
    Color borderColor = Color.black;

    public Tile (EngineHeap[] engineHeaps, int x, int y, int size, ImageLoader.ImageList textureType) {
        super(engineHeaps);
        this.x = x;
        this.y = y;
        this.size = size;
        this.borderColor = Color.black;
        this.texture = new Texture(size, ImageLoader.getInstance().getImage(textureType));
        if(texture == null)
        {
            System.out.println("null texture object");
        }
    }

    @Override
    public void draw(Graphics g) {

        if(texture != null) {
            texture.draw(g,x,y);
        }
        
        g.setColor(borderColor);
        g.drawRoundRect(x,y,size,size,5,5);
    }

    @Override
    public void run() {
        //do nothing
    }
}
