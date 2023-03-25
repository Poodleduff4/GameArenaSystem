import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;


public class Cart extends JPanel {
    int label_height = 75;
    int label_width = 500;
    int padding = 10;
    ArrayList<Ticket> tickets = new ArrayList<>();
    ArrayList<EventSeat> selectedSeats = new ArrayList<>();

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
        selectedSeats = seats;
        for (EventSeat seat :
                seats) {
            seat.setBackground(Color.black);
            seat.updateAvailability();
            seat.setVisible(false);
            System.out.println(seat.eventID);
            Ticket ticket = new Ticket(seat.getSeatID(), seat.getSectionID(), seat.rowNum, seat.eventID);
            ticket.setBounds(0, tickets.size()*label_height + tickets.size()*padding, label_width, label_height);
            this.add(ticket);
            this.revalidate();
            this.repaint();
            tickets.add(ticket);
        }
    }
    public void removeTicket(Ticket ticket) {
        // loops thru all the seats in all events to make the seat visible again on the event pages, checks for matching seatID, sectionID, eventID to get the right seat
        this.remove(ticket);
        tickets.remove(ticket);

        this.revalidate();
        this.repaint();

        for (Event event : GameArenaSystem.eventList.eventList) {
            for (Section section : event.sections) {
                for (EventSeat seat : section.seats) {
                    if (seat.seatID == ticket.seatID && seat.sectionID == ticket.sectionID && seat.eventID == ticket.eventID) {
                        seat.available = true;
                    }
                }
            }
        }
        // starting at the ticket that is being removed
        int index = tickets.indexOf(ticket);
        // remove the ticket from the list


        // moves all the tickets below the removed one up in the panel


        for(int i = index;i < tickets.size();i++) {
            tickets.get(i).setBounds(0, tickets.get(i).getBounds().y-label_height-padding, label_width, label_height);
        }
        this.revalidate();
        this.repaint();
    }
}
