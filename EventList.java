import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;



public class EventList extends JPanel {
    public int number_of_events = 1;
    public Event[] eventList = new Event[number_of_events];

    EventList(){
        this.setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
        this.setBounds(0, 0, 500, 500);
        this.setOpaque(true);
        this.setBackground(Color.red);
        this.setVisible(true);

    }

    public void setEventList(Event[] eventList) {
        this.eventList = eventList;
            this.removeAll();
        for (Event event :
                eventList) {
            this.add(event);
            this.add(Box.createVerticalGlue());
        }
            this.revalidate();
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
        r
    }
}
