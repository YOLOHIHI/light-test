public abstract class ControlDevice extends CircuitDevice {
    public ControlDevice(String id) {
        super(id);
    }

    // 控制设备特有的设置状态方法
    public abstract void adjust(String command);
}
