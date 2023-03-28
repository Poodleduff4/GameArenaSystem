import java.util.ArrayList;
import java.util.Date;

public class GameArenaSystem {
    static EventList eventList;
    static Cart cart;
    public static void main(String[] args) {
        //Creates a new UI to inialize and construct UI components using the UI class
        UI ui = new UI(2, 50, 10);
        //Inializes a new cart for user to add their tickets using Cart class
        cart = new Cart();
        //List of all events that will be displayed on the homepage
        Event[] events = {new Event("Billy Joel World Tour", "Billy Joel concert ", "October 9, 2023 12pm", "Concert", "AT&T Stadium, \nArlington Texas, USA",3, 100, 20, 0), new Event("Call Of Duty Major 3\nTournament", "Esports ", "June 26, 2023 7pm", "Tournament ", "Mattamy Athletic Center, \nToronto, Canada",5, 50, 25, 1), new Event("Kendrick Lamar Good Kid\nM.A.A.D City ", "Hip Hop ", "July 30, 2023 9pm", "Concert ", "Great Stage Park, \nManchester, USA",4, 80, 20, 2), new Event("Drake & 21 Savage\nBroke Boys Tour ", "Rap ", "October 31, 2023 10pm", "Concert ", "Toyota Center, \nHouston Text, USA",3, 60, 20, 3)};
        //Uses EventList() class to construct the buttons that direct user to submenus for each event
        eventList = new EventList();
        eventList.setEventList(events);
        //Calls UI to open the homepage/main screen of the application window
        UI.homepage();
    }

    public static void setCart(){

        cart = new Cart();
    }
}