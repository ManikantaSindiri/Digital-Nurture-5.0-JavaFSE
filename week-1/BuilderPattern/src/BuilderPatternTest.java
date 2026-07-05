public class BuilderPatternTest {

    public static void main(String[] args) {

        // Gaming Computer
        Computer gamingPC = new Computer.Builder("Intel i9", 32, 1000)
                .setGraphicsCard(true)
                .setBluetooth(true)
                .build();

        // Office Computer
        Computer officePC = new Computer.Builder("Intel i5", 16, 512)
                .setBluetooth(true)
                .build();

        System.out.println("Gaming PC:");
        gamingPC.displayConfiguration();

        System.out.println("Office PC:");
        officePC.displayConfiguration();
    }
}