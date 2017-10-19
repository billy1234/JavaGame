import java.util.ArrayList;


public class Level {

    public boolean isPlayerTurn;
    public Player player;
    public Grid grid;
    public ArrayList<GridActor> actors;

    public Level() {
        this.isPlayerTurn = true;
        this.actors = new ArrayList<GridActor>();
    }



    public Level spawnGrid(Engine e) {
        grid = PrefabFactory.getInstance(e).loadGrid(e, this);
        return this;
    }

    public Level addPlayer(Engine e, GridVector pos) {
        player = PrefabFactory.getInstance(e).createPlayer(e, pos, grid);
        return this;
    }

    public Level addGridActor(GridActor g) {
        actors.add(g);
        return this;
    }


}
