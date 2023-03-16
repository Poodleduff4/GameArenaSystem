import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class EventSeat extends Seat {
    int status;
    int eventID;
    int seatID;
    int rowNum;
    int sectionID;
    int price;

    EventSeat(){
        this.status = 1;

        this.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                UI.selectedSeats.add(EventSeat.this);
            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {
                setBackground(Color.red);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                setBackground(Color.black);
            }
        });
    }

    public int checkStatus(){
        return this.status;
    }

    // seat bought, status = 0
    public void updateStatus() {
        this.status = 0;
    }

    public int getSeatID(){
        return this.seatID;
    }

    public int getSectionID(){
        return this.sectionID;
    }


}
