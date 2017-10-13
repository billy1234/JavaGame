import java.awt.*;

public class GridActor extends GameObject implements Drawable,Runnable {

    public Tile tile;
    public Texture texture;

    public GridActor(EngineHeap[] engineHeaps,Tile tile, ImageLoader.ImageList texture)
    {
        super(engineHeaps);
        this.tile = tile;
        this.texture = new Texture(tile.size,ImageLoader.getInstance().getImage(texture));
    }

    @Override
    public void draw(Graphics g) {
        if(texture != null) {
            texture.draw(g,tile.x,tile.y);
        }
    }

    @Override
    public void run() {
        //some game logic
    }
}
