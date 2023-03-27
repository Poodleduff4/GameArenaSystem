import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Ticket extends JLabel {
    String customerName;
    String customerEmail;
    int eventID;
    int sectionID;
    int rowNum;
    int seatID;
    double seatPrice;
    static JButton removeTicket;

    // Format text using HTML, make the ticket look nice
    Ticket(int seatID, int sectionID, int rowNum, int eventID, double seatPrice){
        //Customer emails and name are put onto the ticket
        customerName="";
        customerEmail="";
        this.seatID = seatID;
        this.sectionID = sectionID;
        this.rowNum = rowNum;
        this.eventID = eventID;
        this.seatPrice = seatPrice;
        this.setVisible(true);
        this.setOpaque(true);
        this.setBackground(Color.yellow);
        this.setLayout(new BorderLayout());

        //Creates the center panel to put every item on it
        JPanel centerPanel = new JPanel();
        centerPanel.setOpaque(false);

        //Button that removes the ticket specified
        removeTicket = new JButton("Remove Ticket");
        removeTicket.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                GameArenaSystem.cart.removeTicket(Ticket.this);
            }
            });

        //Add the remove ticket button to the screen of view cart
        centerPanel.add(removeTicket);

        //formats the button to the bottom
        this.add(centerPanel, BorderLayout.SOUTH);
    }
    //Adds the tickets to the screen and label
    public void setLabelText() {
         this.setText("<html><pre>Event: " + GameArenaSystem.eventList.getEventByID(this.eventID).eventName + "<br>Section: " + sectionID + "<br>Row Number: " + rowNum + "<br>Seat Number: " + seatID + "<br>Price: $" + seatPrice + "0" + "</pre></html>");
     }
     public String generateUniqueIDString(){
        return eventID + "_" + sectionID + "_" + seatID;
    }
}
