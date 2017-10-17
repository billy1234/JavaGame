import sun.rmi.runtime.Log;

import java.util.ArrayList;

public class LogicEngine extends EngineHeap<LogicObject> {


    //TODO debug this with some ai
    int currentIndex = 0;
    ArrayList<LogicObject> currentHeap;


    public LogicEngine() {
        super(LogicObject.class);
        this.currentIndex = 0;
        this.currentHeap = new ArrayList<LogicObject>();
    }

    public boolean Update()  //true means all objects have have had all of their turns
    {

        if (currentIndex < currentHeap.size()) {
            if (currentHeap.get(currentIndex).run()) { //if the object returns it has finished its turn increment index
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
        currentHeap.clear();
        currentHeap.addAll(heap);
        currentIndex = 0;
    }
}