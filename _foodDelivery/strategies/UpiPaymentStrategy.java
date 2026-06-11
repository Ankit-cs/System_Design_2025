package strategies;

public class UpiPaymentStrategy implements PaymentStrategy {
    private String mobile;

    public UpiPaymentStrategy(String mob) {
        this.mobile = mob;
    }

    @Override
    public boolean pay(double amount) {
        System.out.println("Paid \u20B9" + amount + " using UPI (" + mobile + ")");
        return true;
    }
}