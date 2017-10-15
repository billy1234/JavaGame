import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Player extends GridActor implements KeyListener,Runnable {

    GridVector velocity;
    char up = 'w',down = 's',left = 'a',right = 'd';

    public Player(Engine engine,Tile tile, ImageLoader.ImageList texture)
    {
        super(engine,tile, texture);
        this.velocity = new GridVector(0,0);
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyReleased(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {

        if(e.getKeyChar() == up) {
            velocity.y = -1;
        }
        else if(e.getKeyChar() == down) {
            velocity.y = 1;
        }

        if(e.getKeyChar() == left) {
            velocity.x = -1;
        }
        else if(e.getKeyChar() == right){
            velocity.x = 1;
        }
    }

    @Override
    public void run() {
        move(velocity);
        velocity.zero();
    }
}
