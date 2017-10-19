import java.util.function.Consumer;

public class GridPhysics { //collison detecion compnent of a grid object
    public Grid grid;

    public GridPhysics(Grid grid) {
        this.grid = grid;
    }

    public boolean canMove(GridVector i){
        if(!inBounds(i)){
            return false;
        } else {
            return !isFull(i);
        }
    }

    public void doTo(GridVector pos, Consumer<GridActor> action) {
        action.accept(grid.getTileAt(pos).getOccupant());
    }

    public boolean isFull(GridVector i) {
        return grid.getTileAt(i).isOccupied();
    }

    public boolean inBounds(GridVector i) {
        return (i.x >= 0 && i.y >= 0 && i.x < grid.gridSize && i.y < grid.gridSize);
    }

    public boolean tryMoveActor(GridActor a, GridVector newPos){
        if(canMove(newPos)){
            if(a.tile != null) { //dont bother freeing up null tiles
                a.tile.clearOccupant(); //free up the old tile
            }
            a.tile = grid.getTileAt(newPos); //set the actors tile to the tile at position
            a.tile.addOccupant(a);
        }else {
           return false;
        }
        return true;
    }

    public void moveActor(GridActor a, GridVector newPos){
        if(!tryMoveActor(a,newPos)) {
            System.err.println("Cant move: " + a.toString() + " to " + newPos.toString());
        }
    }

}
