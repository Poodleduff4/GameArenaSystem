import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class Cart extends JPanel {
    int label_height = 50;
    int label_width = 500;
    int padding = 10;
    ArrayList<Ticket> tickets = new ArrayList<>();

    Cart(){
        this.setVisible(true);
        this.setBounds(0, 0, label_width, (int)UI.size.getHeight());
        this.setLayout(null);
    }

    public int cartCounter(){
        return tickets.size();
    }

    public ArrayList<Ticket> getCartItems(){
        return tickets;
    }

    public void addItemsToCart(ArrayList<EventSeat> seats){
        for (EventSeat seat :
                seats) {
            seat.setBackground(Color.black);
            seat.updateAvailability();
            seat.setVisible(false);
            Ticket ticket = new Ticket(seat.getSeatID(), seat.getSectionID(), seat.rowNum);
            ticket.setBounds(0, tickets.size()*label_height + tickets.size()*padding, label_width, label_height);
            this.add(ticket);
            this.revalidate();
            this.repaint();
            tickets.add(ticket);
        }
    }
}
