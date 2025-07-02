// Superclass: Device
class Device {
    String deviceId;
    String status;

    // Constructor
    Device(String deviceId, String status) {
        this.deviceId = deviceId;
        this.status = status;
    }

    // Method to display basic device status
    void displayStatus() {
        System.out.println("Device ID: " + deviceId);
        System.out.println("Status: " + status);
    }
}

// Subclass: Thermostat
class Thermostat extends Device {
    double temperatureSetting;

    // Constructor
    Thermostat(String deviceId, String status, double temperatureSetting) {
        super(deviceId, status);  // Call to superclass constructor
        this.temperatureSetting = temperatureSetting;
    }

    // Overridden method to include thermostat-specific info
    @Override
    void displayStatus() {
        super.displayStatus(); // Display general device info
        System.out.println("Temperature Setting: " + temperatureSetting + "°C");
    }
}

// Main class
public class SmartHomeTest {
    public static void main(String[] args) {
        Thermostat thermostat = new Thermostat("TH123", "ON", 22.5);
        thermostat.displayStatus();
    }
}
