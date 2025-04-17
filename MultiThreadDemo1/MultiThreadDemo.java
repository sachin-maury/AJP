package MultiThreadDemo1;

class MultiThreadDemo implements Runnable {
    private String threadName;

    MultiThreadDemo(String name) {
        threadName = name;
    }

    public void run() {
        for (int i = 0; i < 5; i++) {
            System.out.println(threadName + " - Count: " + i);
            try {
             
                Thread.sleep(500);
            } catch (InterruptedException e) {
                System.out.println(threadName + " interrupted.");
            }
        }
        System.out.println(threadName + " exiting.");
    }

    public static void main(String[] args) {
        Thread thread1 = new Thread(new MultiThreadDemo("Thread 1"));
        Thread thread2 = new Thread(new MultiThreadDemo("Thread 2"));
        Thread thread3 = new Thread(new MultiThreadDemo("Thread 3"));

        thread1.start();
        thread2.start();
        thread3.start();
    }
}

