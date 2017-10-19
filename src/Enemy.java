public class Enemy extends GridActor implements LogicObject {


    public Enemy(Engine engine, GridVector position ,Grid grid, ImageList texture) {
        super(engine, position,grid, texture);
    }

    public Enemy(Engine engine, Tile tile, ImageList texture) {
        super(engine, tile, texture);
    }

    @Override
    public boolean run() {
        if      (tryMove(GridVector.get(0,1    ))){} //try move n,e,s,w
        else  if(tryMove(GridVector.get(1,0    ))){}
        else  if(tryMove(GridVector.get(0,-1   ))){}
        else  if(tryMove(GridVector.get(1,0    ))){}

        return true;
    }


}
