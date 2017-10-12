import java.awt.*;
import java.util.ArrayList;
import java.util.concurrent.*;
import java.lang.Object;

public class RenderEngine {

    Runnable repaint;
    ArrayList<Drawable> renderables;
    public RenderEngine(Runnable repaint)
    {
        this.repaint = repaint;
    }

    public void update(Graphics g)
    {
        renderables.forEach((e) -> e.draw(g));
        repaint.run();
    }

}


