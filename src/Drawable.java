import java.awt.*;
import java.util.Comparator;

public interface Drawable extends Comparable<Drawable>
{
    void draw(Graphics g);

    int order();

    @Override
    default int compareTo(Drawable o) {
        return order() - o.order();
    }

}

