public class FluorescentLamp extends ControlledDevice {
    private static final int BRIGHTNESS_ON = 180;
    private static final int BRIGHTNESS_OFF = 0;

    public FluorescentLamp(String id) {
        super(id);
    }

    @Override
    public void updateState() {
        calculateOutput();
    }

    @Override
    public void calculateOutput() {
        if (inputVoltage > 0) {
            outputVoltage = BRIGHTNESS_ON;
        } else {
            outputVoltage = BRIGHTNESS_OFF;
        }
    }

    @Override
    public String toString() {
        return String.format("@%s:%d", id, (int) outputVoltage);
    }
}
