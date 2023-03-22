import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Date;

public class Event extends JLabel {
    int eventID;
    String eventName;
    String eventDesc;
    Date eventDate;
    String eventType;
    Section[] sections;
    int numSeats;
    int numSections;
    int seatsPerRow;

    Event(String eventName, String eventDesc, Date eventDate, String eventType, int numSections, int numSeats, int seatsPerRow, int eventID){
        this.eventName = eventName;
        this.eventDesc = eventDesc;
        this.eventDate = eventDate;
        this.eventType = eventType;
        this.numSections = numSections;
        this.numSeats = numSeats;
        this.seatsPerRow = seatsPerRow;
        this.sections = new Section[numSections];
        this.eventID = eventID;
        this.setPreferredSize(new Dimension(500, 200));
        this.setBackground(Color.green);
        this.setOpaque(true);
        this.setText(eventName + '\n' + eventDate + '\n' + eventDesc);
        this.setVisible(true);
        this.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                UI.eventPage(Event.this);
            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        });
    }

    public void initiateSeats(int numSections){
        if (this.sections[0] == null){
            for (int i = 0; i < numSections; i++) {
                Section section = new Section(numSeats, seatsPerRow, UI.labelSize, (int)(.5*UI.labelSize), i, eventID);
                section.setLayout(null);
                section.setBackground(Color.white);
                sections[i] = section;
            }
        }
    }
    public String getEventByType(){
        return "";
    }

    public String getEventDetails(){
        return eventDesc + '\n' + eventDate + '\n' + eventType;
    }

    public Section[] getSectionsForEvent(){
        return sections;
    }


}
