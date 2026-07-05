public class ObserverPatternTest {

    public static void main(String[] args) {

        StockMarket stockMarket = new StockMarket();

        Observer mobileUser = new MobileApp("Manikanta");
        Observer webUser = new WebApp("Swaroop");

        stockMarket.registerObserver(mobileUser);
        stockMarket.registerObserver(webUser);

        stockMarket.setStock("TCS", 3850.50);

        stockMarket.deregisterObserver(webUser);

        stockMarket.setStock("Infosys", 1620.75);
    }
}