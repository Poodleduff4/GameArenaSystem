import java.awt.*;
import java.util.ArrayList;

public class Cart {
    static ArrayList<Ticket> tickets = new ArrayList<>();

    public int cartCounter(){
        return tickets.size();
    }

    public static ArrayList<Ticket> getCartItems(){
        return tickets;
    }

    public static void setCartItems(ArrayList<EventSeat> seats){
        for (EventSeat seat :
                seats) {
            seat.setBackground(Color.black);
            seat.updateAvailability();
            seat.setVisible(false);
            tickets.add(new Ticket(seat.getSeatID(), seat.getSectionID()));
        }
    }
}
