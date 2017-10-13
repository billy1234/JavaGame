import java.awt.*;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;

public class RenderEngine extends EngineHeap<Drawable> {


    public RenderEngine()
    {
        super(Drawable.class);
    }

    public void draw(Graphics g)
    {
        heap.forEach((e) -> e.draw(g));
    }

    public void sortRenderOrder()
    {
        Collections.sort(heap);
    }

}


