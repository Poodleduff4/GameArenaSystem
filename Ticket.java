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


    // https://stackoverflow.com/questions/11532028/how-to-format-a-text-in-jlabel
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
        this.setText("<html><pre>Event: " + GameArenaSystem.eventList.getEventByID(this.eventID).eventName + "<br>Section: " + sectionID + "<br>Row Number: " + rowNum + "<br>Seat Number: " + seatID + "<br>Price: $" + seatPrice + "0" + "</pre></html>");

        JPanel centerPanel = new JPanel();
        centerPanel.setOpaque(false);


        removeTicket = new JButton("Remove Ticket");
        removeTicket.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Cart cart = (Cart) SwingUtilities.getAncestorOfClass(Cart.class, Ticket.this);
                cart.removeTicket(Ticket.this);
                //Add the stuff here

//                for (double value : UI.currentPrice){
//
//                }
            }
            });


        centerPanel.add(removeTicket);


        this.add(centerPanel, BorderLayout.SOUTH);
    }

    public String generateUniqueIDString(){
        return eventID + "_" + sectionID + "_" + seatID;
    }
}
