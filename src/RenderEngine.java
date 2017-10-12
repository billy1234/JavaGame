import java.awt.*;

public class RenderEngine extends EngineHeap<Drawable> {


    public RenderEngine()
    {
        super(Drawable.class);
    }

    public void draw(Graphics g)
    {
        heap.forEach((e) -> e.draw(g));
    }

}


