import javax.swing.*;
import java.awt.*;
import java.sql.SQLOutput;
import java.util.ArrayList;



public class EventList extends JPanel {
    public int number_of_events = 4;
    public Event[] eventList;

    EventList(){
        eventList = new Event[number_of_events];
        this.setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
        this.setBounds(0, 0, 500, 500);
        this.setOpaque(true);
        this.setVisible(true);
    }

    public void setEventList(Event[] eventList) {
        this.eventList = eventList;
        // clear eventList
        this.removeAll();

        // add the events to the page and format them
        for (Event event :
                eventList) {
            this.add(event);
            this.add(Box.createVerticalGlue());
        }
        this.revalidate();
        this.repaint();
    }


    public Event[] getEventList() {
        return eventList;
    }

    // return the event that matches the given eventID
    public Event getEventByID(int id){
        for (Event event :
                eventList) {
            if(event.eventID == id){
                return event;
            }
        }
        return null;
    }
}
