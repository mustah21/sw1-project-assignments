import java.util.HashMap;

public class ShoppingCart {

    HashMap<String, Item> cart;


    public ShoppingCart() {
        this.cart = new HashMap<>();
    }

    public void addItem(String name, Item item) {
        cart.put(name, item);
    }

    public void removeItem(String name) {
        cart.remove(name);
    }

    // just in case for printing
    public HashMap<String, Item> getItems() {
        return cart;
    }

    public int getTotalBill() {
        int totalBill = 0;
        for (Item i : cart.values()) {
            totalBill += i.getTotal();
        }
        return totalBill;

    }
}

