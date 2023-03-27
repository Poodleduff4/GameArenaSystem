import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TicketTest {

    @Test
    void generateUniqueIDString() {
        Ticket ticket1 = new Ticket(1,23,29,55,1000);
        assertEquals(55 + "_" + 23 + "_" + 1,ticket1.generateUniqueIDString());

        Ticket ticket2 = new Ticket(90,45,65,324,4909435);
        assertEquals(324 + "_" + 45 + "_" + 90,ticket2.generateUniqueIDString());

        Ticket ticket3 = new Ticket(6456,415,4889,849,4187);
        assertEquals(849 + "_" + 415 + "_" + 6456,ticket3.generateUniqueIDString());

    }//eventID + "_" + sectionID + "_" + seatID;
}