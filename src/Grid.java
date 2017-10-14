import java.util.Random;

public class Grid {
    public Tile tiles [][];
    public int gridSize,tileSize,tileSpacing;

    public Grid(Engine engine, int gridSize, int tileSize, int tileSpacing)
    {
        this.gridSize = gridSize;
        this.tileSize = tileSize;
        this.tileSpacing = tileSpacing;
        initTiles(engine);
    }

    private void initTiles(Engine engine)
    {
        tiles = new Tile[gridSize][gridSize];
        GridVector position;
        Random rng = new Random();
        for(int i =0; i < gridSize; i ++) {
            for(int j =0; j < gridSize; j ++) {

                position = getPixelAt(i,j);
                tiles[i][j] = new Tile(engine,position.x,position.y,tileSize,ImageLoader.ImageList.values()[rng.nextInt(4)]);
            }
        }
    }

    public GridVector getPixelAt(int x, int y)
    {
        return new GridVector(x,y).add(tileSpacing).multiply(tileSize + tileSpacing).add(tileSpacing);
    }

    public Tile getTileAt(GridVector i)
    {
        if(i.x < 0 || i.y < 0 || i.x >= gridSize || i.y >= gridSize ) {
            return null;
        }
        return tiles[i.x][i.y];
    }
}