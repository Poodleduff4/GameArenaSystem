import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EventListTest {

    @Test
    void getEventByID() {

        //This test both setEventList and getEventByID
        EventList eventList;
        Event[] events = {new Event("Billy Joel World Tour", "Billy Joel concert ", "October 9, 2023 12pm", "Concert", "AT&T Stadium, Arlington Texas, USA",3, 100, 20, 0), new Event("Call Of Duty Major 3\nTournament", "Esports ", "June 26, 2023 7pm", "Tournament ", "Rogers Center, Toronto, Canada",5, 50, 25, 1), new Event("Kendrick Lamar Good Kid M.A.A.D City ", "Hip Hop ", "July 30, 2023 9pm", "Concert ", "Great Stage Park, Manchester, USA",4, 80, 20, 2), new Event("Drake & 21 Savage Broke Boys Tour ", "Rap ", "October 31, 2023 10pm", "Concert ", "Toyota Center, Houston Texas, USA",3, 60, 20, 3)};
        eventList = new EventList();
        eventList.setEventList(events);
        assertEquals("Billy Joel World Tour",eventList.getEventByID(0).eventName);
        assertEquals("Call Of Duty Major 3\nTournament",eventList.getEventByID(1).eventName);
        assertEquals("Kendrick Lamar Good Kid M.A.A.D City ",eventList.getEventByID(2).eventName);
        assertEquals("Drake & 21 Savage Broke Boys Tour ",eventList.getEventByID(3).eventName);


    }
}