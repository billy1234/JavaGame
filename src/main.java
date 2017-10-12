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

        }

        @Override
        public void keyTyped(KeyEvent e) {}

        @Override
        public void keyPressed(KeyEvent e) {}

        @Override
        public void keyReleased(KeyEvent e) {}

    }

    RenderEngine renderEngine;

    Instant lastFrame = Instant.now();
    Instant nextFrame;

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
        init();

    }

    private void init() {
        renderEngine = new RenderEngine(() -> repaint());

    }

    @Override
    public void run() {


        while (true) {

            waitForNextFrame();
            renderEngine.update(); //TODO move this to the correct area

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
        nextFrame = lastFrame.plusSeconds(60/fps); //add the fraction of a second that the fps represents

    }

}
