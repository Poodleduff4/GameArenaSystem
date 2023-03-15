import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class Section extends JPanel {
    Seat[] seats;
    Section(int numSeats, int seatsPerRow, int labelSize, int gapBetween) {
        seats = new Seat[numSeats];

        for (int j = 0; j < numSeats; j++) {
            Seat seat = new Seat();
            seat.setBackground(Color.black);
            seat.setBounds((j % seatsPerRow) * labelSize + (j % seatsPerRow) * gapBetween, (labelSize + gapBetween) * ((int) (j / seatsPerRow)), labelSize, labelSize);
            seat.setOpaque(true);
            this.add(seat);
        }


        this.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {

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
}
