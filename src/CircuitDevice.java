public abstract class CircuitDevice {
    protected String id;  // 设备的唯一标识符，如 K1, F2
    protected double inputVoltage;
    protected double outputVoltage;
    protected int pin1;  // 输入引脚编号
    protected int pin2;  // 输出引脚编号

    public CircuitDevice(String id) {
        this.id = id;
        this.inputVoltage = 0;
        this.outputVoltage = 0;
    }

    // 更新设备的状态或输出
    public abstract void updateState();

    public String getId() {
        return id;
    }

    public double getOutputVoltage() {
        return outputVoltage;
    }

    public void setInputVoltage(double voltage) {
        this.inputVoltage = voltage;
        updateState(); // 每次输入电压改变时更新状态
    }
}
