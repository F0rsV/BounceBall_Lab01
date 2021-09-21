import javax.swing.*;

public class TaskStarter {
    public static void BallApp(){
        BounceFrame frame = new BounceFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        System.out.println("Thread name = " + Thread.currentThread().getName());
    }

    public static void SymbolsFirstTask(){
        Thread symbolNoSyncThread1 = new Thread(new SymbolsNoSync('-'));
        Thread symbolNoSyncThread2 = new Thread(new SymbolsNoSync('|'));
        symbolNoSyncThread1.start();
        symbolNoSyncThread2.start();
    }

    public static void SymbolsSecondTask(){
        SymbolThreadsSynchronizer synchronizer1 = new SymbolThreadsSynchronizer(1);
        SymbolThreadsSynchronizer synchronizer2 = new SymbolThreadsSynchronizer(0);

        Thread symbolWithSyncThread1 = new Thread(new SymbolsWithSync('-', synchronizer1, synchronizer2));
        Thread symbolWithSyncThread2 = new Thread(new SymbolsWithSync('|', synchronizer2, synchronizer1));

        symbolWithSyncThread1.start();
        symbolWithSyncThread2.start();
    }

    public static void CounterNoSync(ICounter counter){
        CounterIncrementThread incrementThread = new CounterIncrementThread(counter);
        CounterDecrementThread decrementThread = new CounterDecrementThread(counter);

        incrementThread.start();
        decrementThread.start();
        counter.print();
    }
}
