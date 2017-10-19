import org.omg.Messaging.SYNC_WITH_TRANSPORT;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.*;
import java.awt.event.*;
import java.time.*;

public class Main extends JFrame implements Runnable {

    private class Canvas extends JPanel {

        public Canvas() {
            setPreferredSize(new Dimension(1280, 720));

        }

        @Override
        public void paint(Graphics g) {
            if (running) {
                engine.renderEngine.draw(g);
            }
        }

    }

    Engine engine;


    boolean running = false;

    Level level;


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
        start();

        while (running) {
            engine.update(level, this);
        }
    }

    public void start() {
        setIgnoreRepaint(true); //dont draw untill setup is finished
        level = PrefabFactory.getInstance(engine).loadDebugLevel(engine);
        engine.renderEngine.sortRenderOrder(this);
        running = true;
        setIgnoreRepaint(false);
    }


}
