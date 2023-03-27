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


        centerPanel.add(removeTicket);


        this.add(centerPanel, BorderLayout.SOUTH);
    }
     public void setLabelText() {
         this.setText("<html><pre>Event: " + GameArenaSystem.eventList.getEventByID(this.eventID).eventName + "<br>Section: " + sectionID + "<br>Row Number: " + rowNum + "<br>Seat Number: " + seatID + "<br>Price: $" + seatPrice + "0" + "</pre></html>");
     }
     public String generateUniqueIDString(){
        return eventID + "_" + sectionID + "_" + seatID;
    }
}
