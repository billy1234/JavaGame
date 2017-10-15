import org.omg.Messaging.SYNC_WITH_TRANSPORT;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.*;
import java.awt.event.*;
import java.time.*;

public class Main extends JFrame implements Runnable{

    private class Canvas extends  JPanel {

        public Canvas() {
            setPreferredSize(new Dimension(1280, 720));

        }

        @Override
        public void paint(Graphics g) {
            if(running) {
                engine.renderEngine.draw(g);
            }
        }

    }

    Engine engine;

    Instant lastFrame = Instant.now();
    Instant nextFrame = Instant.now();

    boolean running = false;
    boolean isPlayerTurn = true;

    Grid grid;
    Player player;

    final long fps = 60;

    public static void main(String[] args) {
        Main window = new Main();
        window.run();
    }

    private Main() {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Canvas canvas = new Canvas();
        this.setContentPane(canvas);
        this.pack();
        this.setVisible(true);
        this.setBackground(Color.black);
        init();
    }

    private void init() {
        engine = new Engine(this);
    }

    @Override
    public void run() {
        setIgnoreRepaint(true); //dont draw untill setup is finished
        start();
        setIgnoreRepaint(false);

        while (running) {


            waitForNextFrame();
            if(!isPlayerTurn) {
                engine.logicEngine.Update();
                isPlayerTurn = true;
            }
            else
            {
                player.takeTurn();
            }
            this.repaint();//in turn calls render engine update

        }
    }

    public void start()
    {

        grid = new Grid( engine,20,30,1);
        player = new Player(engine,grid.getTileAt(new GridVector(1,1)), ImageLoader.ImageList.COIN, () -> onPlayerTurn());
        engine.renderEngine.sortRenderOrder(this);


        running = true;
    }

    void onPlayerTurn()
    {
        isPlayerTurn = false;
    }
    void waitForNextFrame()
    {
        if(lastFrame.isBefore(nextFrame)) { //if the time to update isn't now
            try {
                Thread.sleep(Duration.between(Instant.now(), nextFrame).toMillis());
            }
            catch (java.lang.InterruptedException e){}

        }
        lastFrame = Instant.now();
        nextFrame = lastFrame.plusMillis( (long)(( (float)1000) / (float)fps)); //add the fraction of a millisecond that a frame takes

    }

}
