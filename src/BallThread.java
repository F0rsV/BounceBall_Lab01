public class BallThread extends Thread {
    private final Ball b;
    private final BallThread aditionalBallthread;

    public BallThread(Ball ball, int priority){
        b = ball;
        this.setPriority(priority);
        this.aditionalBallthread = null;
    }

    public BallThread(Ball ball, int priority, BallThread aditionalBallthread) {
        b = ball;
        this.setPriority(priority);
        this.aditionalBallthread = aditionalBallthread;
    }

    @Override
    public void run(){
        try{
            if (this.aditionalBallthread != null){
                this.aditionalBallthread.join();
            }

            for(int i=1; i<10000; i++){
                b.move();

                if(b.isInCorner()){
                    //System.out.println(Thread.currentThread().getName() + " interrupted");
                    break;
                }

                //System.out.println("Thread name = " + Thread.currentThread().getName());
                Thread.sleep(5);
            }
        }
        catch(InterruptedException ex){

        }
    }
}

