import org.omg.Messaging.SYNC_WITH_TRANSPORT;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.*;
import java.awt.event.*;
import java.time.*;

public class Main extends JFrame implements Runnable{

    private class Canvas extends  JPanel implements KeyListener {

        public Canvas() {
            setPreferredSize(new Dimension(1280, 720));

        }

        @Override
        public void paint(Graphics g) {
            renderEngine.draw(g);
        }

        @Override
        public void keyTyped(KeyEvent e) {}

        @Override
        public void keyPressed(KeyEvent e) {}

        @Override
        public void keyReleased(KeyEvent e) {}

    }

    RenderEngine renderEngine;
    LogicEngine logicEngine;

    EngineHeap[] engines;




    Instant lastFrame = Instant.now();
    Instant nextFrame = Instant.now();

    final long fps = 60;


    public static void main(String[] args) {
        Main window = new Main();
        window.run();
    }


    private Main() {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Canvas canvas = new Canvas();
        this.setContentPane(canvas);
        this.addKeyListener(canvas);
        this.pack();
        this.setVisible(true);
        this.setBackground(Color.black);
        init();

    }

    private void init() {
        renderEngine = new RenderEngine();
        logicEngine = new LogicEngine();
        engines = new EngineHeap[]{renderEngine,logicEngine};
    }

    @Override
    public void run() {

        Grid grid = new Grid( engines,20,30,1);
        GridActor player = new GridActor(engines,grid.getTileAt(new GridVector(1,1)), ImageLoader.ImageList.COIN);


        renderEngine.sortRenderOrder();
        System.out.println(renderEngine.heap.get(0));


        while (true) {

            waitForNextFrame();
            logicEngine.Update();
            this.repaint();

        }
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
