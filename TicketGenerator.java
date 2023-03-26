import java.io.IOException;

public class TicketGenerator {
    public static ProcessBuilder processBuilder = new ProcessBuilder();
    public static int generateTicket(Ticket ticket) throws Exception {
        String[] command = {"python", "./generateTicket.py"};
        processBuilder.command(command);
        processBuilder.redirectErrorStream(true);


        Process process = processBuilder.start();
        int exitCode = process.waitFor();
        return exitCode;
    }
}
