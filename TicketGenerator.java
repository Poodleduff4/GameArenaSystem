import java.io.IOException;
import java.util.Arrays;

public class TicketGenerator {
    public static ProcessBuilder processBuilder = new ProcessBuilder();
    public static int generateTicket(Ticket ticket) throws Exception {
        String[] command = {"python3", "./generateTicket.py", ticket.generateUniqueIDString(), GameArenaSystem.eventList.getEventByID(ticket.eventID).eventName, Integer.toString(ticket.sectionID), Integer.toString(ticket.rowNum), Integer.toString(ticket.seatID), GameArenaSystem.eventList.getEventByID(ticket.eventID).eventDate};
        System.out.println(Arrays.toString(command));
        processBuilder.command(command);
        processBuilder.redirectErrorStream(true);


        Process process = processBuilder.start();
        int exitCode = process.waitFor();
        return exitCode;
    }

    public static void generateTickets() throws Exception{
        for (Ticket ticket :
                GameArenaSystem.cart.getCartItems()) {
            generateTicket(ticket);
        }
    }
}
