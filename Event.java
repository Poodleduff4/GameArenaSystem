import javax.swing.*;
import java.awt.*;
import java.util.Date;

public class Event extends JLabel {
    int EventID;
    String eventName;
    String eventDesc;
    Date eventDate;
    String eventType;
    Section[] sections;
    int numSeats;
    int numSections;
    int seatsPerRow;

    Event(String eventName, String eventDesc, Date eventDate, String eventType, int numSections, int numSeats, int seatsPerRow){
        this.eventName = eventName;
        this.eventDesc = eventDesc;
        this.eventDate = eventDate;
        this.eventType = eventType;
        this.numSections = numSections;
        this.numSeats = numSeats;
        this.seatsPerRow = seatsPerRow;
    }

    public void initiateSeats(int numSections){
        sections = new Section[numSections];
        for (int i = 0; i < numSections; i++) {
            Section section = new Section(numSeats, seatsPerRow, UI.labelSize, (int)(.5*UI.labelSize), i);
            section.setLayout(null);
            section.setBackground(Color.white);
            sections[i] = section;
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
