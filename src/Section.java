import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class Section extends JPanel {
    EventSeat[] seats;
    int sectionID;
    int eventId;
    double price;
    int rowNum;

    Section(int numSeats, int seatsPerRow, int labelSize, int gapBetween, int sectionID, int eventID) {
        seats = new EventSeat[numSeats];
        this.sectionID = sectionID;
        this.eventId = eventID;
        // set size to hold all seat components
        int width = (seatsPerRow*labelSize) + (gapBetween * (seatsPerRow-1));
        int height = ((int) Math.ceil((double)numSeats / seatsPerRow) * (labelSize + gapBetween) - gapBetween);
        this.setBounds(0, sectionID* (height + labelSize), width, height);

        // Set general price for seciton depending on event and distance from stage
        if (eventID == 1) {
            if (sectionID == 4) {
                price = 200;
            }
            if (sectionID == 3) {
                price = 180;
            }
            if (sectionID == 2) {
                price = 150;
            }
            if (sectionID == 1) {
                price = 100;
            }
            if (sectionID == 0) {
                price = 70;
            }
        }
        if (eventID == 0) {
            if (sectionID == 0) {
                price = 200;
            }
            if (sectionID == 1) {
                price = 300;
            }
            if (sectionID == 2) {
                price = 500;
            }
        }
        if (eventID == 2){
            if (sectionID == 3){
                price = 69420;
            }
            if (sectionID == 2){
                price = 50000;
            }
            if (sectionID == 1){
                price = 30000;
            }
            if (sectionID == 0){
                price = 20000;
            }
        }
        if (eventID == 3){
            if (sectionID == 2){
                price = 500000;
            }
            if (sectionID == 1){
                price = 300000;
            }
            if (sectionID == 0){
                price = 100000;
            }
        }




        // create seats and add them to the seat array
        for (int j = 0; j < numSeats; j++) {
            EventSeat seat = new EventSeat(j, (int) (j / seatsPerRow), sectionID, price + Math.round(Math.random() * (int) (j / seatsPerRow)*3+1), this.eventId);
            seat.setBackground(Color.black);
            // set position based on number of seats per row
            seat.setBounds((j % seatsPerRow) * labelSize + (j % seatsPerRow) * gapBetween, (labelSize + gapBetween) * ((int) (j / seatsPerRow)), labelSize, labelSize);
            seat.setOpaque(true);
            seat.setVisible(false);
            this.add(seat);
            seats[j] = seat;
        }


        this.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                // set selected section
                UI.selectedSection = Section.this;
            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            // change color of section when hovering it
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

    // loop through all seats in the section and set them to visible(true) or visible(false)
    public void setSeatsVisible(boolean visible) {
        for (EventSeat seat : seats) {
            if(visible && seat.checkAvailability()){
                seat.setVisible(true);
            }
            else{
                seat.setVisible(false);
            }
        }
    }
}