import java.awt.*;
import java.util.Random;

public class Tile extends GameObject implements Drawable,Runnable {

    public int x = 0,y = 0, size =5;
    Color color = Color.blue;

    public Tile (EngineHeap[] engineHeaps, int x, int y, int size) {
        super(engineHeaps);
        this.x = x;
        this.y = y;
        this.size = size;
        this.color = Color.blue;

    }

    @Override
    public void draw(Graphics g) {
        g.setColor(color);
        g.fillRect(x,y,size,size);
    }

    @Override
    public void run() {
        Random rng = new Random();
        color = new Color(rng.nextInt(255),rng.nextInt(255),rng.nextInt(255));
    }
}
