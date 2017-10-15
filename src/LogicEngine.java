import java.util.ArrayList;

public class LogicEngine extends EngineHeap<LogicObject> {


    //TODO debug this with some ai
    int completedObjects = 0;
    ArrayList<LogicObject> activeList;
    ArrayList<LogicObject> completedItems;

    public LogicEngine()
    {
        super(LogicObject.class);
        completedObjects = 0;
        activeList = new ArrayList<LogicObject>();
        completedItems = new ArrayList<LogicObject>();
    }

    public boolean Update()
    {
        if(activeList.size() == 0)
        {
            startNewturn();
        }

        activeList.forEach(e ->{
            if(e.run()) {
                completedItems.add(e); //to avoid changing the list size while iterating over it
            } } );
        activeList.removeAll(completedItems);

        return (activeList.size() == 0); //if there are no elements left all logic objects have finished their turn
    }

    void startNewturn()
    {
        activeList.addAll(heap);
    }
}
