public class Ticket {
    String customerName;
    String customerEmail;
    int seatID;
    int eventID;
    int sectionID;
    Ticket(int seatID, int sectionID){
        customerName="";
        customerEmail="";
        this.seatID = seatID;
        this.sectionID = sectionID;
    }
}
