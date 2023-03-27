import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class CartTest {

    @Test
    void getCartItems() {
        Cart test1 = new Cart();
        ArrayList<EventSeat> arrayTest1= new ArrayList<EventSeat>();
        arrayTest1.add(new EventSeat(0,0,0,0,0));
        test1.addItemsToCart(arrayTest1);
        assertEquals(1, test1.getCartItems().size());
    }

    @Test
    void addItemsToCart() {


    }
}