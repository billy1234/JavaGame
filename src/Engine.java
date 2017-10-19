import java.awt.event.KeyListener;
import java.time.Duration;
import java.time.Instant;

public class Engine {

    public RenderEngine renderEngine;
    public LogicEngine logicEngine;
    public Main main;

    private EngineHeap[] engines;

    Instant lastFrame = Instant.now();
    Instant nextFrame = Instant.now();
    final long fps = 60;

    public Engine(Main main) {
        this.renderEngine = new RenderEngine();
        this.logicEngine = new LogicEngine();
        this.main = main;
        this.engines = new EngineHeap[]{renderEngine, logicEngine};
    }

    public void registerGameObject(GameObject g) {

        for (int i = 0; i < engines.length; i++) {
            engines[i].registerNewGameObject(g);
        }

        if (g instanceof KeyListener) {
            main.addKeyListener((KeyListener) g);
        }
    }

    public void update(Level level, Main m) {
        waitForNextFrame();
        if (!level.isPlayerTurn) {
            if (logicEngine.Update()) {
                level.isPlayerTurn = true; //only give the player his turn when the logic loop is finished
            }
        } else {
            if (level.player.takeTurn()) {
                level.isPlayerTurn = false;
            }
        }
        m.repaint();//in turn calls render engine update
    }

    void waitForNextFrame() {
        if (lastFrame.isBefore(nextFrame)) { //if the time to update isn't now
            try {
                Thread.sleep(Duration.between(Instant.now(), nextFrame).toMillis());
            } catch (java.lang.InterruptedException e) {
            }

        }
        lastFrame = Instant.now();
        nextFrame = lastFrame.plusMillis((long) (((float) 1000) / (float) fps)); //add the fraction of a millisecond that a frame takes

    }
}
