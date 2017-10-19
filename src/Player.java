import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Player extends GridActor implements KeyListener {

    GridVector velocity;
    char up = 'w', down = 's', left = 'a', right = 'd';


    public Player(Engine engine, Tile tile) {
        super(engine, tile, ImageList.PLAYER);
        this.velocity = new GridVector(0, 0);
    }

    public Player(Engine engine,GridVector position ,Grid grid) {
       this(engine,grid.getTileAt(position));
    }



    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyReleased(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {

        if (e.getKeyChar() == up) {
            velocity.y = -1;
            velocity.x = 0;
        } else if (e.getKeyChar() == down) {
            velocity.y = 1;
            velocity.x = 0;
        } else if (e.getKeyChar() == left) {
            velocity.x = -1;
            velocity.y = 0;
        } else if (e.getKeyChar() == right) {
            velocity.x = 1;
            velocity.y = 0;
        }
    }


    public boolean takeTurn() {
        if (tryMove(velocity)) {
            velocity.zero();
            return true;
        }
        return false;

    }
}
