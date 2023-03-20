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
        int width = (seatsPerRow*labelSize) + (gapBetween * (seatsPerRow-1));
        int height = ((int) Math.ceil((double)numSeats / seatsPerRow) * (labelSize + gapBetween) - gapBetween);
        this.setBounds(0, sectionID* (height + labelSize), width, height);

        for (int j = 0; j < numSeats; j++) {
            EventSeat seat = new EventSeat(j, (int) (j / seatsPerRow), sectionID, Math.random() * 100 + 20);
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

    public void setSeatsVisible(boolean visible) {
        for (EventSeat seat : seats) {
            if(visible && seat.checkAvailability()){
                seat.setVisible(true);
            }
            else{
                seat.setVisible(false);
            }
            if(seat.checkAvailability() == false){
                System.out.println("Not Available");
            }
        }
    }
}
