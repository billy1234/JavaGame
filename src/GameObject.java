public abstract class GameObject {

    private GameObject() {
    }

    public GameObject(Engine engine) {
        engine.registerGameObject(this);
    }
}
