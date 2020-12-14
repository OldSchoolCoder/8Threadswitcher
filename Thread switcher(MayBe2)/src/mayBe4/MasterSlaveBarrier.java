package mayBe4;

public class MasterSlaveBarrier {
    private boolean barrier = true;

    public synchronized void tryMaster() throws InterruptedException {
        while (!barrier) {
            this.wait();
        }
    }

    public synchronized void trySlave() throws InterruptedException {
        while (barrier) {
            this.wait();
        }
    }

    public synchronized void doneMaster() {
        barrier = false;
        this.notifyAll();
    }

    public synchronized void doneSlave() {
        barrier = true;
        this.notifyAll();
    }
}
