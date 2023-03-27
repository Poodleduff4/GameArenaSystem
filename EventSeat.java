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

            @Override
            public void mouseEntered(MouseEvent e) {
                if (!selected)
                    setBackground(Color.red);
                getParent().setBackground(Color.gray);

                UI.updateSeatInformationPanel(EventSeat.this);

            }

            @Override
            public void mouseExited(MouseEvent e) {
                if (!selected)
                    setBackground(Color.black);
                getParent().setBackground(Color.white);
            }
        });
    }

    public boolean checkAvailability() {
        return this.available;
    }

    // seat bought, status = 0
    public void updateAvailability() {
        this.available = false;
    }

    public int getSeatID() {
        return this.seatID;
    }

    public int getSectionID() {
        return this.sectionID;
    }

    public double getPrice() {
        return this.price;
    }


}
