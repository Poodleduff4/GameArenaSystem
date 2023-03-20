import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class EventSeat extends Seat {
    boolean available;
    int eventID;
    int seatID;
    int rowNum;
    int sectionID;
    double price;
    boolean selected = false;

    EventSeat(int seatID, int rowNum, int sectionID, double price) {
        this.seatID = seatID;
        this.rowNum = rowNum;
        this.sectionID = sectionID;
        this.price = price;

        this.available = true;

        this.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                UI.selectedSeats.add(EventSeat.this);
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

    public double getPrice(){
        return this.price;
    }


}
