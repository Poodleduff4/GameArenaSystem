import javax.swing.*;
import java.util.ArrayList;



public class EventList extends JPanel {
    public static int number_of_events = 5;
    public static Event[] eventList = new Event[number_of_events];

    public static void setEventList(Event[] eventList) {
        EventList.eventList = eventList;
    }
}
