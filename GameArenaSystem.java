import java.util.Date;

public class GameArenaSystem {
    public static void main(String[] args) {
        UI ui = new UI(2, 50, 10);
        Event[] eventList = {new Event("Billy Joel: World tour", "Billy Joel concert", new Date(), "Concert", 3, 50, 10)};
        EventList.setEventList(eventList);
    }
}