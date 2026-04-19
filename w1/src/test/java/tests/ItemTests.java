package tests;


import one.Item;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class ItemTest {

    @Test
    void testGetPrice() {
        Item item = new Item(5.5, 3);
        assertEquals(5.5, item.getPrice());
    }

    @Test
    void testGetQuantity() {
        Item item = new Item(5.5, 3);
        assertEquals(3, item.getQuantity());
    }

    @Test
    void testGetTotal() {
        Item item = new Item(5.0, 4);
        assertEquals(20, item.getTotal());
    }

    @Test
    void testGetTotalTruncatesDecimal() {
        Item item = new Item(5.9, 2); // (int)5.9 * 2 = 10
        assertEquals(10, item.getTotal());
    }
}