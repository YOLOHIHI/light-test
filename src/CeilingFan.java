public class CeilingFan extends ControlledDevice {
    public CeilingFan(String id) {
        super(id);
    }

    @Override
    public void updateState() {
        calculateOutput();
    }

    @Override
    public void calculateOutput() {
        if (inputVoltage < 80) {
            outputVoltage = 0;
        } else if (inputVoltage <= 150) {
            outputVoltage = (inputVoltage - 80) * 280 / 70 + 80;
        } else {
            outputVoltage = 360;
        }
    }

    @Override
    public String toString() {
        return String.format("@%s:%d", id, (int) outputVoltage);
    }
}
