import java.util.Random;

public class Grid {
    public Tile tiles[][];
    public int gridSize, tileSize, tileSpacing;
    public GridPhysics physics;

    public Grid(Engine e, int gridSize, int tileSize, int tileSpacing, Level level, String seed) {
        this.gridSize = gridSize;
        this.tileSize = tileSize;
        this.tileSpacing = tileSpacing;
        this.physics = new GridPhysics(this);
        generateGrid(e, level, seed);
    }

    private void generateGrid(Engine engine, Level level, String seed) {
        tiles = new Tile[gridSize][gridSize];
        GridVector position;
        Random rng = new Random(seed.hashCode());
        for (int i = 0; i < gridSize; i++) {
            for (int j = 0; j < gridSize; j++) {

                position = getPixelAt(i, j);
                tiles[i][j] = new Tile(engine, i, j, position.x, position.y, tileSize, this, ImageList.values()[rng.nextInt(4)]);

                if (rng.nextInt(10) == 0) { //1 in 10 chance
                    level.addGridActor(PrefabFactory.getInstance(engine).createTree(tiles[i][j]));
                }
            }
        }
    }

    public GridVector getPixelAt(int x, int y) {
        return new GridVector(x, y).add(tileSpacing).multiply(tileSize + tileSpacing).add(tileSpacing);
    }

    public Tile getTileAt(GridVector i) {
        if (!physics.inBounds(i)) {
            System.err.println("Cant find: " + i.toString());
            return null;
        }
        return tiles[i.x][i.y];
    }
}