import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;


public class Cart extends JPanel {
    int label_height = 100;
    int label_width = 400;
    int padding = 10;
    // ArrayList to store tickets
    ArrayList<Ticket> tickets = new ArrayList<>();
    ArrayList<EventSeat> selectedSeats = new ArrayList<>();

    Cart(){
        this.setVisible(true);
        this.setBounds(0, 0, label_width*(Math.floorDiv(UI.size.width, label_width)), (int)UI.size.getHeight());
        this.setLayout(null);
    }

    public int cartCounter(){
        return tickets.size();
    }

    public ArrayList<Ticket> getCartItems(){
        return tickets;
    }

    //
    public void addItemsToCart(ArrayList<EventSeat> seats){
        selectedSeats = seats;
        // for each seat in the argument list, make a new ticket and add it to the cart
        for (EventSeat seat :
                seats) {
            seat.setBackground(Color.black);
            seat.updateAvailability();
            seat.setVisible(false);

            Ticket ticket = new Ticket(seat.getSeatID(), seat.getSectionID(), seat.rowNum, seat.eventID, seat.getPrice());
            ticket.setLabelText();
            ticket.setBounds(0, tickets.size()*label_height + tickets.size()*padding, label_width, label_height);
            this.add(ticket);
            tickets.add(ticket);
            formatCart();
            this.revalidate();
            this.repaint();
        }
    }
    public void removeTicket(Ticket ticket) {
        int index = tickets.indexOf(ticket);
        this.remove(ticket);
        tickets.remove(ticket);
        formatCart();

        // Set the availability of a seat to true if you remove the ticket from the cart
        for (Event event : GameArenaSystem.eventList.eventList) {
            for (Section section : event.sections) {
                for (EventSeat seat : section.seats) {
                    if (seat.seatID == ticket.seatID && seat.sectionID == ticket.sectionID && seat.eventID == ticket.eventID) {
                        seat.available = true;
                    }
                }
            }
        }

        this.revalidate();
        this.repaint();
    }

    // Method to rerender all the tickets in the cart and keep them formatted
    public void formatCart(){
        int maxTicketsPerColumn = Math.floorDiv(this.getSize().height, label_height + padding)-1;
        for (int i = 0; i < tickets.size(); i++) {
            int y = (i % maxTicketsPerColumn) * (label_height + padding);
            int x = Math.floorDiv(i, maxTicketsPerColumn);
            tickets.get(i).setBounds(x  * (label_width + padding), y, label_width, label_height);
        }
    }

    // Remove all items from cart
    public void clearCart(){
        for (Ticket ticket : tickets) {
            this.remove(ticket);
        }
        tickets.clear();
        this.revalidate();
        this.repaint();
    }
}
