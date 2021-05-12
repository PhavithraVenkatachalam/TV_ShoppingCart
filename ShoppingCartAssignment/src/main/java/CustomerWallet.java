public class CustomerWallet implements EWallet{
    double balance;
    public CustomerWallet(double balance)
    {
        this.balance=balance;
    }
    @Override
    public void updateBalance(double amount) {
        balance=balance-amount;
    }


    @Override
    public double getBalance() {
        return balance;
    }
}
