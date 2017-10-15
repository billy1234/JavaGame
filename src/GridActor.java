import java.awt.*;

public class GridActor extends GameObject implements Drawable {

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
            texture.draw(g,tile.screenX,tile.screenY);
        }
    }

    @Override
    public int order() {
        return 1;
    }

    protected void move(GridVector v){

        if(v.isZero()){
            return;
        }

        GridVector pos = tile.getGridPos().add(v).constrain(0,0,tile.grid.gridSize,tile.grid.gridSize);
        tile = tile.grid.getTileAt(pos);
    }

}
