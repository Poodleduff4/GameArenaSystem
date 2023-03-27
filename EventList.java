import javax.swing.*;
import java.awt.*;
import java.sql.SQLOutput;
import java.util.ArrayList;



public class EventList extends JPanel {
    public int number_of_events = 2;
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
//        System.arraycopy(eventList, 0, this.eventList, 0, number_of_events);
            this.removeAll();
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
