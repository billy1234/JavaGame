import java.util.Random;

public class Grid {
    public Tile tiles [][];
    public int gridSize,tileSize,tileSpacing;

    public Grid(EngineHeap[] engines, int gridSize, int tileSize, int tileSpacing)
    {
        this.gridSize = gridSize;
        this.tileSize = tileSize;
        this.tileSpacing = tileSpacing;
        initTiles(engines);
    }

    private void initTiles(EngineHeap[] engines)
    {
        tiles = new Tile[gridSize][gridSize];
        GridVector position;
        Random rng = new Random();
        for(int i =0; i < gridSize; i ++) {
            for(int j =0; j < gridSize; j ++) {

                position = getPixelAt(i,j);
                tiles[i][j] = new Tile(engines,position.x,position.y,tileSize,ImageLoader.ImageList.values()[rng.nextInt(ImageLoader.ImageList.values().length - 1)]);
            }
        }
    }

    public GridVector getPixelAt(int x, int y)
    {
        return new GridVector(x,y).multiply(tileSize + tileSpacing).add(tileSpacing);
    }

    public Tile getTileAt(GridVector i)
    {
        if(i.x < 0 || i.y < 0 || i.x >= gridSize || i.y >= gridSize ) {
            return null;
        }
        return tiles[i.x][i.y];
    }
}
