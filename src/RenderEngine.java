import javax.swing.*;
import java.awt.*;
import java.util.Collections;
import java.util.Optional;


public class RenderEngine extends EngineHeap<Drawable> {


    public RenderEngine() {
        this.heapModifiedCallback = Optional.of(() -> Collections.sort(heap)); //when an element is added sort for to ensure draw order
    }

    public void draw(Graphics g) {
        updateHeap();
        for (int i = 0; i < heap.size(); i++) {
            heap.get(i).draw(g);
        }
    }

    public void sortRenderOrder(JFrame frame) {
        frame.setIgnoreRepaint(true);
        Collections.sort(heap);
        frame.setIgnoreRepaint(false);
    }

    @Override
    protected boolean isLegalGameobj(GameObject g) {
        return (g instanceof Drawable);
    }
}


