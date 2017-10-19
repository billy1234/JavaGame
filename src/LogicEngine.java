import sun.rmi.runtime.Log;

import java.util.ArrayList;

public class LogicEngine extends EngineHeap<LogicObject> {

    int currentIndex = 0;


    public LogicEngine() {
        this.currentIndex = 0;
    }

    public boolean Update()  //true means all objects have have had all of their turns
    {
        if (currentIndex < heap.size()) {
            if (heap.get(currentIndex).run()) { //if the object returns it has finished its turn increment index
                currentIndex++;
                return false; //still exit the function to render the turn
            } else {
                return false;
            }
        } else {
            startNewturn();
            return true;
        }

    }

    void startNewturn() {
        updateHeap();
        currentIndex = 0;
    }

    @Override
    protected boolean isLegalGameobj(GameObject g) {
        return (g instanceof LogicObject);
    }
}