public class MasterSlaveBarrier {
    private Thread master;
    private Thread slave;

    public synchronized void tryMaster() throws InterruptedException {
        notifyAll();
        wait();
    }

    public synchronized void trySlave() throws InterruptedException {
        if (master.getState() != Thread.State.WAITING) {
            wait();
        } else {
            notifyAll();
        }
    }

    public void doneMaster() {
        this.master = Thread.currentThread();
    }

    public void doneSlave() {
        this.slave = Thread.currentThread();
    }
}
