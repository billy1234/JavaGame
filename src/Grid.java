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
                tiles[i][j] = new Tile(engine,i,j,position.x,position.y,tileSize,this,ImageLoader.ImageList.values()[rng.nextInt(4)]);

                if(rng.nextInt(10) == 0){ //1 in 10 chance
                    PrefabFactory.getInstance(engine).createTree(tiles[i][j]);
                }
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