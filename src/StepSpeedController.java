public class StepSpeedController extends ControlDevice {
    private int level;

    public StepSpeedController(String id) {
        super(id);
        this.level = 0;
    }

    @Override
    public void updateState() {
        outputVoltage = inputVoltage * (level * 0.3);
    }

    @Override
    public void adjust(String command) {
        if (command.equals("+") && level < 3) {
            level++;
        } else if (command.equals("-") && level > 0) {
            level--;
        }
    }

    @Override
    public String toString() {
        return String.format("@%s:%d", id, level);
    }
}
