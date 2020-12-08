public class MasterSlaveBarrier {
    private Thread master;
    private Thread slave;

    public void tryMaster() {
        master.start();
    }

    public void trySlave() {
        while (true) {
            if (master.getState() == Thread.State.RUNNABLE) {
                slave.start();
                return;
            }
        }
    }

    public void doneMaster(Thread master) {
        this.master = master;
    }

    public void doneSlave(Thread slave) {
        this.slave = slave;
    }
}
