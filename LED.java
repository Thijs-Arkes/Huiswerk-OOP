public class LEDStrip {

    // RGB values for the LED strip
    private int red;
    private int green;
    private int blue;

    // Dimmer value (0-255)
    private int dimmer;

    // Constructor
    public LEDStrip() {
        this.red = 0;
        this.green = 0;
        this.blue = 0;
        this.dimmer = 255; // Default dimmer value is set to 255 (full brightness)
    }

    // Method to set the color based on text input
    public boolean setColor(String color) {
        switch (color.toLowerCase()) {
            case "red":
                this.red = 255;
                this.green = 0;
                this.blue = 0;
                return true;
            case "green":
                this.red = 0;
                this.green = 255;
                this.blue = 0;
                return true;
            case "blue":
                this.red = 0;
                this.green = 0;
                this.blue = 255;
                return true;
            case "purple":
                this.red = 255;
                this.green = 0;
                this.blue = 255;
                return true;
            case "orange":
                this.red = 255;
                this.green = 165;
                this.blue = 0;
                return true;
            case "sun":
                this.red = 201;
                this.green = 141;
                this.blue = 38;
                return true;
            default:
                return false; // Unknown color
        }
    }

    // Method to convert RGB values to color name text
    public String getColorName() {
        if (this.red == 255 && this.green == 0 && this.blue == 0) {
            return "red";
        } else if (this.red == 0 && this.green == 255 && this.blue == 0) {
            return "green";
        } else if (this.red == 0 && this.green == 0 && this.blue == 255) {
            return "blue";
        } else if (this.red == 255 && this.green == 0 && this.blue == 255) {
            return "purple";
        } else if (this.red == 255 && this.green == 165 && this.blue == 0) {
            return "orange";
        } else if (this.red == 201 && this.green == 141 && this.blue == 38) {
            return "sun";
        } else {
            return "unknown"; // RGB values do not match a known color
        }
    }

    // Method to adjust the dimmer based on percentage (0-100)
    public void setDimmer(int percentage) {
        if (percentage >= 0 && percentage <= 100) {
            this.dimmer = (int) ((percentage / 100.0) * 255);
        } else {
            System.out.println("Invalid percentage. Please provide a value between 0 and 100.");
        }
    }

    // Method to get the current dimmer value (0-255)
    public int getDimmer() {
        return this.dimmer;
    }

    // Method to get the current RGB values
    public int[] getRGB() {
        return new int[]{this.red, this.green, this.blue};
    }

    // Method to display the current status of the LED strip
    public void displayStatus() {
        System.out.println("Current color: " + getColorName());
        System.out.println("Red: " + this.red + ", Green: " + this.green + ", Blue: " + this.blue);
        System.out.println("Dimmer: " + this.dimmer);
    }

    public static void main(String[] args) {
        // Example usage
        LEDStrip led = new LEDStrip();

        // Set color to "red"
        led.setColor("red");
        led.displayStatus();

        // Set dimmer to 50%
        led.setDimmer(50);
        led.displayStatus();

        // Set color to "green"
        led.setColor("green");
        led.displayStatus();

        // Set dimmer to 100%
        led.setDimmer(100);
        led.displayStatus();

        // Set color to an unknown color (invalid input)
        boolean result = led.setColor("purpleblue");
        System.out.println("Color set: " + result);
        led.displayStatus();
    }
}