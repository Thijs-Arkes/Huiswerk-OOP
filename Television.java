public class Television {

    private String brand; // Brand of the television
    private String model; // Model of the television
    private int volume;   // Volume level (0 to 100)
    private int channel;  // Channel number (1 to 75)
    private String childLockPin; // Pin for child lock (4 digits as a String)
    private boolean childLocked; // Boolean flag for child lock status

    // Constructor to initialize brand and model
    public Television(String brand, String model) {
        this.brand = brand;
        this.model = model;
        this.volume = 50;  // Default volume is 50
        this.channel = 1;  // Default channel is 1
        this.childLockPin = "";  // No child lock initially set
        this.childLocked = false; // Child lock is disabled initially
    }

    // Method to increase the volume
    public void increaseVolume() {
        if (this.volume < 100) {
            this.volume++;
        } else {
            System.out.println("The volume cannot be increased further!");
        }
    }

    // Method to decrease the volume
    public void decreaseVolume() {
        if (this.volume > 0) {
            this.volume--;
        } else {
            System.out.println("The volume cannot be decreased further!");
        }
    }

    // Method to increase the channel
    public void increaseChannel() {
        if (!this.childLocked) { // If child lock is enabled, channel cannot be changed
            if (this.channel < 75) {
                this.channel++;
            } else {
                System.out.println("The channel cannot be increased further!");
            }
        } else {
            System.out.println("Channels cannot be changed due to the child lock!");
        }
    }

    // Method to decrease the channel
    public void decreaseChannel() {
        if (!this.childLocked) { // If child lock is enabled, channel cannot be changed
            if (this.channel > 1) {
                this.channel--;
            } else {
                System.out.println("The channel cannot be decreased further!");
            }
        } else {
            System.out.println("Channels cannot be changed due to the child lock!");
        }
    }

    // Method to manually set the channel
    public void setChannel(int channel) {
        if (!this.childLocked) { // Set channel manually, only if child lock is off
            if (channel >= 1 && channel <= 75) {
                this.channel = channel;
            } else {
                System.out.println("The channel must be between 1 and 75.");
            }
        } else {
            System.out.println("Channels cannot be changed due to the child lock!");
        }
    }

    // Method to set the child lock with a pin
    public void setChildLock(String pin) {
        this.childLockPin = pin;
        this.childLocked = true;
        System.out.println("Child lock has been set.");
    }

    // Method to remove the child lock with the correct pin
    public void removeChildLock(String pin) {
        if (pin.equals(this.childLockPin)) {
            this.childLocked = false;
            System.out.println("Child lock removed.");
        } else {
            System.out.println("Incorrect PIN. The child lock remains active.");
        }
    }

    // Method to print the current status of the television
    public void getStatus() {
        System.out.println("Brand: " + this.brand);
        System.out.println("Model: " + this.model);
        System.out.println("Volume: " + this.volume);
        System.out.println("Channel: " + this.channel);
        System.out.println("Child Lock: " + (this.childLocked ? "Enabled" : "Disabled"));
    }

    public static void main(String[] args) {
        // Example usage
        Television tv = new Television("Samsung", "QLED123");

        tv.getStatus();

        tv.increaseVolume();
        tv.decreaseChannel();
        tv.setChannel(10);

        tv.setChildLock("1234");
        tv.increaseChannel();

        tv.removeChildLock("1234");
        tv.increaseChannel();

        tv.getStatus();
    }
}
