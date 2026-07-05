public class Computer {

    // Required attributes
    private String CPU;
    private int RAM;
    private int storage;

    // Optional attributes
    private boolean graphicsCard;
    private boolean bluetooth;

    // Private constructor
    private Computer(Builder builder) {
        this.CPU = builder.CPU;
        this.RAM = builder.RAM;
        this.storage = builder.storage;
        this.graphicsCard = builder.graphicsCard;
        this.bluetooth = builder.bluetooth;
    }

    // Display Computer Configuration
    public void displayConfiguration() {
        System.out.println("Computer Configuration:");
        System.out.println("CPU: " + CPU);
        System.out.println("RAM: " + RAM + " GB");
        System.out.println("Storage: " + storage + " GB");
        System.out.println("Graphics Card: " + graphicsCard);
        System.out.println("Bluetooth: " + bluetooth);
        System.out.println();
    }

    // Static Nested Builder Class
    public static class Builder {

        // Required attributes
        private String CPU;
        private int RAM;
        private int storage;

        // Optional attributes
        private boolean graphicsCard = false;
        private boolean bluetooth = false;

        // Constructor for required attributes
        public Builder(String CPU, int RAM, int storage) {
            this.CPU = CPU;
            this.RAM = RAM;
            this.storage = storage;
        }

        public Builder setGraphicsCard(boolean graphicsCard) {
            this.graphicsCard = graphicsCard;
            return this;
        }

        public Builder setBluetooth(boolean bluetooth) {
            this.bluetooth = bluetooth;
            return this;
        }

        public Computer build() {
            return new Computer(this);
        }
    }
}