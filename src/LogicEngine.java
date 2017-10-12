public class LogicEngine extends EngineHeap<Runnable> {


    public LogicEngine()
    {
        super(Runnable.class);
    }

    public void Update()
    {
        heap.forEach((e) -> e.run());
    }
}
