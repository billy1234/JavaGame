import java.awt.*;
import java.util.function.Consumer;


public class GridActor extends GameObject implements Drawable {

    protected Tile tile;
    protected GridPhysics physics;

    public Texture texture;


    public GridActor(Engine engine,GridVector position, Grid grid, ImageList texture) {
        super(engine);
        this.physics = grid.physics;
        physics.moveActor(this,position);
        this.texture = new Texture(tile.size, ImageLoader.getInstance().getImage(texture));

    }

    public GridActor(Engine engine,Tile tile, ImageList texture){
        this(engine,tile.getGridPos(),tile.grid,texture);
    }

    @Override
    public void draw(Graphics g) {
        if (texture != null) {
            texture.draw(g, tile.screenX, tile.screenY);
        }
    }

    @Override
    public int order() {
        return 1;
    }

    protected void move(GridVector v) {
        tryMove(v);
    }

    protected boolean tryMove(GridVector v) {

        if (v.isZero()) {
            return false;
        }

        //convert from velocity to a grid position
        GridVector pos = tile.getGridPos().add(v).constrain(0, 0, tile.grid.gridSize, tile.grid.gridSize);
        return tryChangeTile(pos);
    }

    public boolean tryChangeTile(GridVector pos) {
        return  physics.tryMoveActor(this,pos);
    }

    protected void toDoRelative(GridVector vec, Consumer<GridActor> action){
        physics.doTo(tile.getGridPos().add(vec),action);
    }


}
