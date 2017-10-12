public abstract class GameObject {

    private GameObject() {}

    public GameObject(EngineHeap[] engineHeaps)
    {
        for(int i =0; i < engineHeaps.length; i ++) {
            engineHeaps[i].registerNewGameObject(this);
        }

    }
}
