public class IncandescentLamp extends ControlledDevice {
    public IncandescentLamp(String id) {
        super(id);
    }

    @Override
    public void updateState() {
        calculateOutput();
    }

    @Override
    public void calculateOutput() {
        if (inputVoltage >= 10 && inputVoltage <= 220) {
            outputVoltage = (inputVoltage - 10) * 200 / 210;
        } else if (inputVoltage > 220) {
            outputVoltage = 200;
        } else {
            outputVoltage = 0;
        }
    }

    @Override
    public String toString() {
        return String.format("@%s:%d", id, (int) outputVoltage);
    }
}
