import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EventSeatTest {

    @Test
    void getSeatID() {
// EventSeat(int seatID, int rowNum, int sectionID, double price, int eventID)
        EventSeat test1 = new EventSeat(43,1,3,182.0,1);
        assertEquals(43, test1.getSeatID());

        EventSeat test2 = new EventSeat(57,5,4,6000.0,12);
        assertEquals(57, test2.getSeatID());

        EventSeat test3 = new EventSeat(1000,3,7,20.0,2);
        assertEquals(1000, test3.getSeatID());
    }

    @Test
    void getSectionID() {
        EventSeat tester = new EventSeat(43,1,3,182.0,1);
        assertEquals(3, tester.getSectionID());

        EventSeat test2 = new EventSeat(57,5,4,6000.0,12);
        assertEquals(4, test2.getSectionID());

        EventSeat test3 = new EventSeat(1000,3,7,20.0,2);
        assertEquals(7, test3.getSectionID());
    }
}