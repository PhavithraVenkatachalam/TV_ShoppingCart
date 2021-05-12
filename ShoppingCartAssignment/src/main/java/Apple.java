public class Apple implements Product {
    private String name;
    private int availableStock;
    private double price;

    public Apple(String name, double price, int quantity)
    {
        this.name=name;
        this.price=price;
        this.availableStock=quantity;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public double getPrice() {
        return price;
    }

    @Override
    public int getAvailableQuantity() {
        return availableStock;
    }

    @Override
    public void updateStock(int stock) {
        availableStock=stock;
    }
}
