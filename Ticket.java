import javax.swing.*;
import java.awt.*;

public class Ticket extends JLabel {
    String customerName;
    String customerEmail;
    int eventID;
    int sectionID;
    int rowNum;
    int seatID;

    // https://stackoverflow.com/questions/11532028/how-to-format-a-text-in-jlabel
    // Format text using HTML, make the ticket look nice
    Ticket(int seatID, int sectionID, int rowNum, int eventID){
        customerName="";
        customerEmail="";
        this.seatID = seatID;
        this.sectionID = sectionID;
        this.rowNum = rowNum;
        this.eventID = eventID;
        this.setVisible(true);
        this.setOpaque(true);
        this.setBackground(Color.yellow);
        this.setText("<html><pre>Event: " + GameArenaSystem.eventList.getEventByID(this.eventID).eventName + "<br>Section: " + sectionID + "<br>Row Number: " + rowNum + "<br>Seat Number: " + seatID + "</pre></html>");
    }
}
