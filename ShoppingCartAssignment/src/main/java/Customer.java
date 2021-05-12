
public class Customer {


    private String name;
    private CustomerWallet wallet;
    private ShoppingCart shoppingCart;

    public Customer(String name,double amount)
    {
        this.name=name;
        shoppingCart=new ShoppingCart();
        wallet= new CustomerWallet(amount);
    }

    public String addToCart(Object product,int quantity)
    {
        return shoppingCart.addToCart(product,quantity);
    }

    public boolean checkBalance()
    {
        if(wallet.getBalance()>shoppingCart.getTotalAmount()) {
            return true;
        }
        return false;
    }
    public String getBalance()
    {
        if(checkBalance()) {
            wallet.updateBalance(shoppingCart.getTotalAmount());
            return String.format("%.2f is the balance in your eWallet",wallet.getBalance());
        }
        return "low Balance,Please add amount to your EWallet";
    }

    public void displayCart()
    {
        shoppingCart.displayCart();
    }


}
