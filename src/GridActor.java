import java.awt.*;

public class GridActor extends GameObject implements Drawable,Runnable {

    public Tile tile;
    public Texture texture;

    public GridActor(Engine engine,Tile tile, ImageLoader.ImageList texture)
    {
        super(engine);
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
    public int order() {
        return 1;
    }

    @Override
    public void run() {
        //some game logic
    }



}
