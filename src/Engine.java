public class Engine {

    public RenderEngine renderEngine;
    public LogicEngine logicEngine;

    private EngineHeap[] engines;

    public Engine()
    {
        this.renderEngine = new RenderEngine();
        this.logicEngine = new LogicEngine();
        this.engines = new EngineHeap[]{renderEngine,logicEngine};
    }

    public void registerGameObject(GameObject g)
    {
        for(int i =0; i < engines.length; i ++) {
            engines[i].registerNewGameObject(g);
        }
    }
}
