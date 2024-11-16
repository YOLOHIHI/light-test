public class Switch extends ControlDevice {
    private boolean isClosed;

    public Switch(String id) {
        super(id);
        this.isClosed = false;
    }

    @Override
    public void updateState() {
        outputVoltage = isClosed ? inputVoltage : 0;
    }

    @Override
    public void adjust(String command) {
        isClosed = !isClosed;
    }

    @Override
    public String toString() {
        return String.format("@%s:%s", id, isClosed ? "closed" : "turned on");
    }
}
