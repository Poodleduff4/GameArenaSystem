import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EventTest {

    @Test
    void getEventDetails() {
        EventList eventList;
        Event[] events = {new Event("Billy Joel World Tour", "Billy Joel concert ", "October 9, 2023 12pm", "Concert", "AT&T Stadium, Arlington Texas, USA",3, 100, 20, 0), new Event("Call Of Duty Major 3\nTournament", "Esports ", "June 26, 2023 7pm", "Tournament ", "Rogers Center, Toronto, Canada",5, 50, 25, 1), new Event("Kendrick Lamar Good Kid M.A.A.D City ", "Hip Hop ", "July 30, 2023 9pm", "Concert ", "Great Stage Park, Manchester, USA",4, 80, 20, 2), new Event("Drake & 21 Savage Broke Boys Tour ", "Rap ", "October 31, 2023 10pm", "Concert ", "Toyota Center, Houston Texas, USA",3, 60, 20, 3)};
        eventList = new EventList();
        eventList.setEventList(events);
        assertEquals("Billy Joel concert " + '\n' + "October 9, 2023 12pm" + '\n' + "Concert" + '\n' + "AT&T Stadium, Arlington Texas, USA",eventList.getEventByID(0).getEventDetails());
        assertEquals("Esports " + '\n' + "June 26, 2023 7pm" + '\n' + "Tournament " + '\n' + "Rogers Center, Toronto, Canada",eventList.getEventByID(1).getEventDetails());
        assertEquals("Hip Hop " + '\n' + "July 30, 2023 9pm" + '\n' + "Concert " + '\n' + "Great Stage Park, Manchester, USA",eventList.getEventByID(2).getEventDetails());
    }

    @Test
    void getSectionsForEvent() {
        EventList eventList;

        Event[] events = {new Event("Billy Joel World Tour", "Billy Joel concert ", "October 9, 2023 12pm", "Concert", "AT&T Stadium, Arlington Texas, USA",3, 100, 20, 0), new Event("Call Of Duty Major 3\nTournament", "Esports ", "June 26, 2023 7pm", "Tournament ", "Rogers Center, Toronto, Canada",5, 50, 25, 1), new Event("Kendrick Lamar Good Kid M.A.A.D City ", "Hip Hop ", "July 30, 2023 9pm", "Concert ", "Great Stage Park, Manchester, USA",4, 80, 20, 2), new Event("Drake & 21 Savage Broke Boys Tour ", "Rap ", "October 31, 2023 10pm", "Concert ", "Toyota Center, Houston Texas, USA",3, 60, 20, 3)};
        eventList = new EventList();
        eventList.setEventList(events);
        Event testEvent = eventList.getEventByID(0);
        testEvent.initiateSeats(3);
        assertEquals(100,testEvent.numSeats);
        assertEquals(20,testEvent.seatsPerRow);
        assertEquals(0,testEvent.eventID);

    }
}