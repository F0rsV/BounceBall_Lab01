public class CounterIncrementThread extends Thread {
    private final ICounter _counter;

    public CounterIncrementThread(ICounter counter) {
        _counter = counter;
    }

    @Override
    public void run() {
        for (int i = 0; i < 100000; i++) {
            _counter.increment();
        }
    }
}
