public class ContinuousSpeedController extends ControlDevice {
    private double position;

    public ContinuousSpeedController(String id) {
        super(id);
        this.position = 0.0;
    }

    @Override
    public void updateState() {
        outputVoltage = inputVoltage * position;
    }

    @Override
    public void adjust(String command) {
        try {
            double newPosition = Double.parseDouble(command);
            if (newPosition >= 0.0 && newPosition <= 1.0) {
                this.position = newPosition;
                updateState();
            } else {
                System.out.println("档位参数超出范围：[0.00 - 1.00]");
            }
        } catch (NumberFormatException e) {
            System.out.println("无效的档位参数：" + command);
        }
    }

    @Override
    public String toString() {
        return String.format("@%s:%.2f", id, position);
    }
}
