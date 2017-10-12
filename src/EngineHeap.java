

import java.lang.reflect.Type;
import java.util.ArrayList;

public abstract class EngineHeap<T> {


    protected ArrayList<T> heap;

    protected int heapSize = 1000;
    protected Class elementType;

    public EngineHeap(Class elementType)
    {
        this.heap = new ArrayList<T>(heapSize);
        this.elementType = elementType;
    }

    public void addObject(T e)
    {
        heap.add(e);
    }

    public void registerNewGameObject(GameObject g)
    {
        if(elementType.isInstance(g)) {
            heap.add((T)g);
        }
    }

}