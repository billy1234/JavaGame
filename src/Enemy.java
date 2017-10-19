public class Enemy extends GridActor implements LogicObject {


    public Enemy(Engine engine, Tile tile, ImageList texture) {
        super(engine, tile, texture);
    }

    @Override
    public boolean run() {
        move(new GridVector(0, 1));
        return true;
    }


}
