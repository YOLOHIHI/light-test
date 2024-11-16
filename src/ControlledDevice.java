public abstract class ControlledDevice extends CircuitDevice {
    public ControlledDevice(String id) {
        super(id);
    }

    // 受控设备的具体更新状态方法
    public abstract void calculateOutput();
}
