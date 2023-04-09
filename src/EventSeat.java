import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class EventSeat extends JLabel {
    boolean available;
    int eventID;
    int seatID;
    int rowNum;
    int sectionID;
    double price;
    boolean selected = false;
    boolean added = false;

    EventSeat(int seatID, int rowNum, int sectionID, double price, int eventID) {
        this.seatID = seatID;
        this.rowNum = rowNum;
        this.sectionID = sectionID;
        this.price = price;
        this.eventID = eventID;

        this.available = true;

        this.addMouseListener(new MouseListener() {
            // When the user clicks a seat, set the color and selection status
            @Override
            public void mouseClicked(MouseEvent e) {
                if (!added) {
                    UI.selectedSeats.add(EventSeat.this);
                    added = true;
                }
                if(selected)
                {
                    UI.selectedSeats.remove(EventSeat.this);
                    added = false;
                }
                selected = !selected;
            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            // when user hovers over the seat, change color to red
            @Override
            public void mouseEntered(MouseEvent e) {
                if (!selected)
                    setBackground(Color.red);
                getParent().setBackground(Color.gray);

                UI.updateSeatInformationPanel(EventSeat.this);

            }

            // when user mouse exits a seat, set color back to normal
            @Override
            public void mouseExited(MouseEvent e) {
                if (!selected)
                    setBackground(Color.black);
                getParent().setBackground(Color.white);
            }
        });
    }

    // check if the seat is available to purchase
    public boolean checkAvailability() {
        return this.available;
    }

    // Set the seat availability to false
    public void updateAvailability() {
        this.available = false;
    }

    // get the seatID
    public int getSeatID() {
        return this.seatID;
    }

    // Get the sectionID of the seat
    public int getSectionID() {
        return this.sectionID;
    }

    // get the price of the seat
    public double getPrice() {
        return this.price;
    }
}
