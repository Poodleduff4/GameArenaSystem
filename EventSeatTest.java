import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EventSeatTest {

    @Test
    void getSeatIDTest() {
// EventSeat(int seatID, int rowNum, int sectionID, double price, int eventID)
        EventSeat tester = new EventSeat(43,1,3,182.0,1);
        assertEquals(43, tester.getSeatID());
    }

    @Test
    void getSectionIDTest() {
        EventSeat tester = new EventSeat(43,1,3,182.0,1);
        assertEquals(3, tester.getSectionID());
    }
}