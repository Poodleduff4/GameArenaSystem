import java.util.ArrayList;
import java.util.Date;

public class GameArenaSystem {
    static EventList eventList;
    static Cart cart;
    public static void main(String[] args) {
        UI ui = new UI(2, 50, 10);
        cart = new Cart();
        Event[] events = {new Event("Billy Joel World Tour : ", " : Billy Joel concert ", new Date(), "Concert", 3, 50, 10, 0), new Event("Call Of Duty Major 3 Tournament : ", " : Esports ", new Date(), "Tournament ", 5, 50, 25, 1)};
        eventList = new EventList();
        eventList.setEventList(events);
        UI.homepage();
    }
}