import java.util.HashMap;
import java.util.Map;

public class Circuit {
    private Map<String, CircuitDevice> devices = new HashMap<>();

    public void addDevice(CircuitDevice device) {
        devices.put(device.getId(), device);
    }

    public void connectDevices(String id1, String id2) {
        // 在电路中连接设备
        CircuitDevice device1 = devices.get(id1);
        CircuitDevice device2 = devices.get(id2);
        if (device1 != null && device2 != null) {
            // 连接逻辑，可以设置输入和输出电压
        }
    }

    public void adjustDevice(String id, String command) {
        CircuitDevice device = devices.get(id);
        if (device instanceof ControlDevice) {
            ((ControlDevice) device).adjust(command);
        }
    }

    public void printStatus() {
        for (CircuitDevice device : devices.values()) {
            System.out.println(device.toString());
        }
    }
}
