import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Circuit circuit = new Circuit();

        // 初始化设备
        Switch k1 = new Switch("K1");
        StepSpeedController f1 = new StepSpeedController("F1");
        ContinuousSpeedController l1 = new ContinuousSpeedController("L1");
        IncandescentLamp b2 = new IncandescentLamp("B2");
        CeilingFan d2 = new CeilingFan("D2");

        // 将设备添加到电路中
        circuit.addDevice(k1);
        circuit.addDevice(f1);
        circuit.addDevice(l1);
        circuit.addDevice(b2);
        circuit.addDevice(d2);

        // 建立连接
        circuit.connectDevices("VCC", "K1-1");  // 假设VCC接到K1的输入引脚
        circuit.connectDevices("K1-2", "D2-1"); // 假设K1的输出连接到D2的输入
        circuit.connectDevices("D2-2", "GND");  // 假设D2的输出连接到地

        // 初始化Scanner读取控制输入
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入控制命令，以'end'结束：");

        while (true) {
            String input = scanner.nextLine();
            if (input.equals("end")) {
                break;
            }

            // 解析命令
            if (input.startsWith("#")) {
                String command = input.substring(1);
                if (command.startsWith("K")) {
                    // 处理开关命令
                    circuit.adjustDevice(command, "toggle");
                } else if (command.startsWith("F")) {
                    // 处理分档调速器命令
                    String deviceId = command.substring(0, 2);
                    String operation = command.substring(2);
                    circuit.adjustDevice(deviceId, operation);
                } else if (command.startsWith("L")) {
                    // 处理连续调速器命令
                    String[] parts = command.split(":");
                    String deviceId = parts[0];
                    double position = Double.parseDouble(parts[1]);
                    circuit.adjustDevice(deviceId, String.valueOf(position));
                }
            }
        }

        // 打印所有设备的状态
        System.out.println("电路状态：");
        circuit.printStatus();

        scanner.close();
    }
}
