import java.util.ArrayList;
import java.util.Date;

public class GameArenaSystem {
    static EventList eventList;
    static Cart cart;
    public static void main(String[] args) {
        UI ui = new UI(2, 50, 10);
        cart = new Cart();
        Event[] events = {new Event("Billy Joel World Tour", "Billy Joel concert ", "October 9, 2023 12pm", "Concert", "AT&T Stadium, \nArlington Texas, USA",3, 100, 20, 0), new Event("Call Of Duty Major 3\nTournament", "Esports ", "June 26, 2023 7pm", "Tournament ", "Mattamy Athletic Center, \nToronto Ontario, Canada",5, 50, 25, 1), new Event("Kendrick Lamar Good Kid\nM.A.A.D City ", "Hip Hop ", "July 30, 2023 9pm", "Concert ", "Great Stage Park, \nManchester, USA",4, 80, 20, 2), new Event("Drake & 21 Savage\nBroke Boys Tour ", "Rap ", "October 31, 2023 10pm", "Concert ", "Toyota Center, \nHouston Text, USA",3, 60, 20, 3)};
        eventList = new EventList();
        eventList.setEventList(events);
        UI.homepage();
    }

    public static void setCart(){
        cart = new Cart();
    }
}