

public class PrefabFactory {

    private static PrefabFactory instance;

    Engine e;

    public static PrefabFactory getInstance(Engine e) {
        if(instance == null){
            instance = new PrefabFactory(e);
        }
        return instance;
    }

    private PrefabFactory(Engine e)
    {
        this.e = e;
    }

    public GridActor createTree(Tile location){
        return new GridActor(e, location,  ImageLoader.ImageList.TREE);
    }

}
