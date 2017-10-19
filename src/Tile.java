import java.awt.*;


public class Tile extends GameObject implements Drawable {

    public int screenX = 0, screenY = 0, size = 5, gridX = 0, gridY = 0;

    Texture texture;
    Color borderColor = Color.black;

    public Grid grid;
    private GridActor occupant;

    public Tile(Engine engine, int gridX, int gridY, int screenX, int screenY, int size, Grid grid, ImageList textureType) {
        super(engine);
        this.screenX = screenX;
        this.screenY = screenY;
        this.gridX = gridX;
        this.gridY = gridY;
        this.size = size;
        this.grid = grid;
        this.borderColor = Color.black;
        this.texture = new Texture(size, ImageLoader.getInstance().getImage(textureType));
        if (texture == null) {
            System.out.println("null texture object");
        }
    }

    public GridVector getGridPos() {
        return new GridVector(gridX, gridY);
    }

    public boolean isOccupied(){
        return (occupant != null);
    }

    public void addOccupant(GridActor a){
        if(!isOccupied()){
            occupant = a;
        }
    }

    public GridActor getOccupant(){
        return occupant;
    }

    public void clearOccupant(){
        occupant = null;
    }

    @Override
    public void draw(Graphics g) {

        if (texture != null) {
            texture.draw(g, screenX, screenY);
        }

        g.setColor(borderColor);
        g.drawRoundRect(screenX, screenY, size, size, 5, 5);
    }

    @Override
    public int order() {
        return 0;
    }
}
