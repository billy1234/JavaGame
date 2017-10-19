import java.util.Optional;
import java.util.Stack;
import java.util.ArrayList;

public abstract class EngineHeap<T> {


    protected ArrayList<T> heap;
    protected Stack<T> stack;

    protected int heapSize = 1000;

    protected Optional<Runnable> heapModifiedCallback;


    public EngineHeap() {
        this.heap = new ArrayList<T>(heapSize);
        this.stack = new Stack<T>();
        this.heapModifiedCallback = Optional.empty();
    }

    protected void updateHeap() {
        boolean needsCallback = (stack.size() > 0);
        for (int i = 0; i < stack.size(); i++) {
            heap.add(stack.pop()); //realisticaly this should find the correct spot and insert the element and shit the necessary ones
        }

        if (heapModifiedCallback.isPresent() && needsCallback) { //if the heap was modified alert the modified callback
            heapModifiedCallback.get().run();
        }
    }


    protected abstract boolean isLegalGameobj(GameObject g);

    public void registerNewGameObject(GameObject g) {
        if (isLegalGameobj(g)) {
            stack.add((T) g);
        }
    }

}