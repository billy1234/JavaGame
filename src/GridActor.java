import java.awt.*;

public class GridActor extends GameObject implements Drawable {

    protected Tile tile;

    public Texture texture;


    public GridActor(Engine engine,Tile tile, ImageLoader.ImageList texture)
    {
        super(engine);
        this.tile = tile;
        this.texture = new Texture(tile.size,ImageLoader.getInstance().getImage(texture));
        changeTile(tile);
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
        tryMove(v);
    }

    protected boolean tryMove(GridVector v){

        if(v.isZero()){
            return false;
        }

        GridVector pos = tile.getGridPos().add(v).constrain(0,0,tile.grid.gridSize,tile.grid.gridSize);
        return tryChangeTile(tile.grid.getTileAt(pos));
    }

    public boolean tryChangeTile(Tile nextTile)
    {
        if(nextTile.occupant == null) {
            changeTile(nextTile);
            return true;
        }
        else {
            return false;
        }
    }

    protected void changeTile(Tile nextTile) //dosnt check next tiles ocupacy status
    {
        if(nextTile.occupant == null) {
            tile.occupant = null;
            nextTile.occupant = this;
            this.tile = nextTile;
        }


    }

}
