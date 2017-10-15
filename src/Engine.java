import java.awt.event.KeyListener;
import java.security.PublicKey;

public class Engine {

    public RenderEngine renderEngine;
    public LogicEngine logicEngine;
    public Main main;

    private EngineHeap[] engines;

    public Engine(Main main)
    {
        this.renderEngine = new RenderEngine();
        this.logicEngine = new LogicEngine();
        this.main = main;
        this.engines = new EngineHeap[]{renderEngine,logicEngine};
    }

    public void registerGameObject(GameObject g)
    {
        for(int i =0; i < engines.length; i ++) {
            engines[i].registerNewGameObject(g);
        }

        if(g instanceof KeyListener) {
            main.addKeyListener((KeyListener) g);
        }
    }
}
