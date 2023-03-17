import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class Section extends JPanel {
    EventSeat[] seats;
    int sectionID;

    Section(int numSeats, int seatsPerRow, int labelSize, int gapBetween, int sectionID) {
        seats = new EventSeat[numSeats];
        this.sectionID = sectionID;

        for (int j = 0; j < numSeats; j++) {
            EventSeat seat = new EventSeat();
            seat.setBackground(Color.black);
            seat.setBounds((j % seatsPerRow) * labelSize + (j % seatsPerRow) * gapBetween, (labelSize + gapBetween) * ((int) (j / seatsPerRow)), labelSize, labelSize);
            seat.setOpaque(true);
            seat.setVisible(false);
            this.add(seat);
            seats[j] = seat;
        }


        this.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (UI.sectionSelected)
                    UI.selectedSection.setSeatsVisible(false);
                setSeatsVisible(true);
                UI.sectionSelected = true;
                UI.selectedSection = Section.this;
            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {
                setBackground(Color.gray);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                setBackground(Color.white);
            }
        });
    }

    public void hide(boolean hidden) {
        setVisible(hidden);
        setSeatsVisible(false);
    }

    public void setSeatsVisible(boolean visible) {
        for (EventSeat seat : seats) {
            if (seat.checkAvailability())
                seat.setVisible(visible);
        }
    }
}
