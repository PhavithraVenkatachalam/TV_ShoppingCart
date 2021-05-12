import java.util.ArrayList;
import java.util.List;

public class ShoppingCart {

    private List<Object> productsCart;
    private double totalAmount;
    List<Object> availableProductList;

    public ShoppingCart(){
        productsCart=new ArrayList<>();
        totalAmount=0;
        availableProductList=new ArrayList<>();
    }

    public String addToCart(Object object,int quantity)
    {
        if(object instanceof Apple)
            return addAppleToCart((Apple) object,quantity);
        if(object instanceof Milk)
            return addMilkToCart((Milk)object, quantity);
        if(object instanceof NewsPaper)
            return addNewsPaperToCart((NewsPaper) object, quantity);
        return null;
    }
    public String addAppleToCart(Apple apple,int quantity)
    {
        if(apple.getAvailableQuantity()>=quantity)
        {
            productsCart.add(apple);
            apple.updateStock(apple.getAvailableQuantity()-quantity);
            totalAmount=totalAmount+(apple.getPrice()*quantity);
            System.out.println("cart amount apple" + apple.getPrice()*quantity);
            return "added";
        }
        else
        {
            return String.format("%s has less stocks than requested",apple.getName());
        }

    }

    public String addMilkToCart(Milk milk,int quantity)
    {
        if(milk.getAvailableQuantity()>=quantity)
        {
            productsCart.add(milk);
            milk.updateStock(milk.getAvailableQuantity()-quantity);
            totalAmount=totalAmount+(milk.getPrice()*quantity);
            System.out.println("cart amount milk" + milk.getPrice()*quantity);
            return "added";
        }
        else
        {
            return String.format("%s has less stocks than requested",milk.getName());
        }

    }

    public String addNewsPaperToCart(NewsPaper newsPaper,int quantity)
    {
        if(newsPaper.getAvailableQuantity()>=quantity)
        {
            productsCart.add(newsPaper);
            newsPaper.updateStock(newsPaper.getAvailableQuantity()-quantity);
            totalAmount=totalAmount+(newsPaper.getPrice()*quantity);
            System.out.println("cart amount news" + newsPaper.getPrice()*quantity);
            return "added";
        }
        else
        {
            return String.format("%s has less stocks than requested",newsPaper.getName());
        }

    }

    public void displayCart()
    {
        productsCart.stream().forEach(p->System.out.println(p.getClass().getName()));
    }




    public double getTotalAmount()
    {
        return totalAmount;
    }


}
