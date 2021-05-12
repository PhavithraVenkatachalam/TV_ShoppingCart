import org.testng.Assert;
import org.testng.annotations.Test;

public class TestShoppingCart {

    @Test
    public void testEWalletBalance()
    {
        Customer customer=new Customer("phavi",2000);
        Apple apple=new Apple("Apple",10,20);
        Milk milk=new Milk("milk",20,20);
        NewsPaper newsPaper=new NewsPaper("NewsPaper",20,20);
        customer.addToCart(apple,10);
        customer.addToCart(milk,10);
        customer.addToCart(newsPaper,3);
        customer.displayCart();
        String actualValue= customer.getBalance();

        Assert.assertEquals(actualValue,"1640.00 is the balance in your eWallet");
    }

    @Test
    public void testWithLowStock()
    {
        Customer customer=new Customer("phavi",2000);

        Apple apple=new Apple("Apple",10,20);
        Milk milk=new Milk("milk",20,20);
        NewsPaper newsPaper=new NewsPaper("NewsPaper",20,20);
        String actual=customer.addToCart(apple,30);
        customer.addToCart(milk,10);
        customer.addToCart(newsPaper,3);
        String actualValue=customer.getBalance();

        Assert.assertEquals(actual,"Apple has less stocks than requested");
        Assert.assertEquals(actualValue,"1740.00 is the balance in your eWallet");
    }

    @Test
    public void testWithLowBalance()
    {
        Customer customer=new Customer("phavi",100);

        Apple apple=new Apple("Apple",10,20);
        Milk milk=new Milk("milk",20,20);
        NewsPaper newsPaper=new NewsPaper("NewsPaper",20,20);
        String actual=customer.addToCart(apple,30);
        customer.addToCart(milk,10);
        customer.addToCart(newsPaper,3);
        String actualValue=customer.getBalance();

        Assert.assertEquals(actual,"Apple has less stocks than requested");
        Assert.assertEquals(actualValue,"low Balance,Please add amount to your EWallet");
    }
}
