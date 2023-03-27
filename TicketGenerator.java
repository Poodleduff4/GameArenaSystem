import java.io.IOException;
import java.util.Arrays;

public class TicketGenerator {
    // ProcessBuilder to start processes that generate tickets
    public static ProcessBuilder processBuilder = new ProcessBuilder();
    public static int generateTicket(Ticket ticket) throws Exception {
        String[] command = {"python3", "./generateTicket.py", ticket.generateUniqueIDString(), GameArenaSystem.eventList.getEventByID(ticket.eventID).eventName, Integer.toString(ticket.sectionID), Integer.toString(ticket.rowNum), Integer.toString(ticket.seatID), GameArenaSystem.eventList.getEventByID(ticket.eventID).eventDate, GameArenaSystem.eventList.getEventByID(ticket.eventID).eventLocation};
        processBuilder.command(command);
        processBuilder.redirectErrorStream(true);

        // start the process with the desired command arguments above
        Process process = processBuilder.start();
        // wait for process to end
        int exitCode = process.waitFor();
        return exitCode;
    }

    // generate a ticket for each item in the cart
    public static void generateTickets() throws Exception{
        for (Ticket ticket :
                GameArenaSystem.cart.getCartItems()) {
            generateTicket(ticket);
        }
    }
}
