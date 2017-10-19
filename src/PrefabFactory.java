import com.sun.org.apache.regexp.internal.RE;

import java.security.PublicKey;
import java.util.Random;

public class PrefabFactory {

    private static PrefabFactory instance;
    private final int gridSize = 25, tileSize = 30, tileSpacing = 1;

    private String seed = "World 1";
    protected Random rng;

    private final boolean debugSeed = true;

    Engine e;

    public static PrefabFactory getInstance(Engine e) {
        if (instance == null) {
            instance = new PrefabFactory(e);
        }
        return instance;
    }

    private void RandomizeSeed() {
        Random r = new Random();
        seed = ((Integer) r.nextInt()).toString();

    }

    private PrefabFactory(Engine e) {
        this.e = e;
        if (!debugSeed) {
            RandomizeSeed();
        }

        rng = new Random(seed.hashCode());
    }

    public GridActor createTree(Tile location) {
        return new GridActor(e, location, ImageList.TREE);
    }

    public Player createPlayer(Engine e, GridVector pos, Grid grid) {
        return new Player(e, grid.getTileAt(pos));
    }

    public Level loadNewLevel(Engine e) {
        return Level.getEmptyLevel().spawnGrid(e).addPlayer(e, new GridVector(1, 1));
    }

    public Level loadDebugLevel(Engine e) {
        Level L = loadNewLevel(e);
        L.addGridActor(debugEnemy(e,L.grid));
        return L;
    }

    public Grid loadGrid(Engine e, Level level) {
        return new Grid(e, gridSize, tileSize, tileSpacing, level, seed);
    }


    public Enemy debugEnemy(Engine e, Grid g){
        return new Enemy(e,g.getTileAt(new GridVector(1,5)),ImageList.TREE);
    }

}
