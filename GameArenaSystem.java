import java.util.Date;

public class GameArenaSystem {
    static EventList eventList;
    public static void main(String[] args) {
        UI ui = new UI(2, 50, 10);
        Event[] events = {new Event("Billy Joel: World tour", "Billy Joel concert", new Date(), "Concert", 3, 50, 10), new Event("Esports tournament", "Esports", new Date(), "Tournament", 5, 50, 10)};
        eventList = new EventList();
        eventList.setEventList(events);
        UI.homepage();
    }
}