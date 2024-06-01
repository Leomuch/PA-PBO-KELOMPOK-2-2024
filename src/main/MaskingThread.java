package main;

class MaskingThread extends Thread {
    private volatile boolean stop;
    private char echochar = '*';

    public MaskingThread(String prompt) {
        System.out.print(prompt);
    }

    public void run() {
        int priority = Thread.currentThread().getPriority();
        Thread.currentThread().setPriority(Thread.MAX_PRIORITY);
        try {
            stop = true;
            while (stop) {
                System.out.print("\010" + echochar);
                try {
                    Thread.currentThread();
                    Thread.sleep(10);
                } catch (InterruptedException iex) {
                    Thread.currentThread().interrupt();
                    return;
                }
            }
        } finally {
            Thread.currentThread().setPriority(priority);
        }
    }

    public void stopMasking() {
        this.stop = false;
    }
}
